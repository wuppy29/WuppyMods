package com.wuppy.frozen.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class EntityElsa extends EntityMob implements IRangedAttackMob {
	public EntityElsa(World par1World) {
		super(par1World);

		tasks.addTask(1, new EntityAISwimming(this));
		tasks.addTask(4, new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F));
		tasks.addTask(5, new EntityAIWander(this, 1.0D));
		tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
		tasks.addTask(6, new EntityAILookIdle(this));

		targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2D);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30D);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		int x = (int) posX;
		int y = (int) posY - 1;
		int z = (int) posZ;

		Block block = worldObj.getBlockState(new BlockPos(x, y, z)).getBlock();

		// water
		if (block == Blocks.water || block == Blocks.flowing_water) {
			worldObj.setBlockState(new BlockPos(x, y, z), Blocks.ice.getDefaultState());
		}
		if (worldObj.getBlockState(new BlockPos(x + 1, y, z)).getBlock() == Blocks.water || worldObj.getBlockState(new BlockPos(x + 1, y, z)).getBlock() == Blocks.flowing_water) {
			worldObj.setBlockState(new BlockPos(x + 1, y, z), Blocks.ice.getDefaultState());
		}
		if (worldObj.getBlockState(new BlockPos(x - 1, y, z)).getBlock() == Blocks.water || worldObj.getBlockState(new BlockPos(x - 1, y, z)).getBlock() == Blocks.flowing_water) {
			worldObj.setBlockState(new BlockPos(x - 1, y, z), Blocks.ice.getDefaultState());
		}
		if (worldObj.getBlockState(new BlockPos(x, y, z + 1)).getBlock() == Blocks.water || worldObj.getBlockState(new BlockPos(x, y, z + 1)).getBlock() == Blocks.flowing_water) {
			worldObj.setBlockState(new BlockPos(x, y, z + 1), Blocks.ice.getDefaultState());
		}
		if (worldObj.getBlockState(new BlockPos(x, y, z - 1)).getBlock() == Blocks.water || worldObj.getBlockState(new BlockPos(x, y, z - 1)).getBlock() == Blocks.flowing_water) {
			worldObj.setBlockState(new BlockPos(x, y, z - 1), Blocks.ice.getDefaultState());
		}

		// lava
		if (block == Blocks.lava || block == Blocks.flowing_lava) {
			worldObj.setBlockState(new BlockPos(x, y, z), Blocks.obsidian.getDefaultState());
		}
		if (worldObj.getBlockState(new BlockPos(x + 1, y, z)).getBlock() == Blocks.lava || worldObj.getBlockState(new BlockPos(x + 1, y, z)).getBlock() == Blocks.flowing_lava) {
			worldObj.setBlockState(new BlockPos(x + 1, y, z), Blocks.obsidian.getDefaultState());
		}
		if (worldObj.getBlockState(new BlockPos(x - 1, y, z)).getBlock() == Blocks.lava || worldObj.getBlockState(new BlockPos(x - 1, y, z)).getBlock() == Blocks.flowing_lava) {
			worldObj.setBlockState(new BlockPos(x - 1, y, z), Blocks.obsidian.getDefaultState());
		}
		if (worldObj.getBlockState(new BlockPos(x, y, z + 1)).getBlock() == Blocks.lava || worldObj.getBlockState(new BlockPos(x, y, z + 1)).getBlock() == Blocks.flowing_lava) {
			worldObj.setBlockState(new BlockPos(x, y, z + 1), Blocks.obsidian.getDefaultState());
		}
		if (worldObj.getBlockState(new BlockPos(x, y, z - 1)).getBlock() == Blocks.lava || worldObj.getBlockState(new BlockPos(x, y, z - 1)).getBlock() == Blocks.flowing_lava) {
			worldObj.setBlockState(new BlockPos(x, y, z - 1), Blocks.obsidian.getDefaultState());
		}
	}

	long lastTalked = 0;

	@Override
	public boolean interact(EntityPlayer par1EntityPlayer) {
		if (lastTalked == 0)
			worldObj.getWorldTime();

		if (!worldObj.isRemote && lastTalked + 20 < worldObj.getWorldTime()) {
			int rand = worldObj.rand.nextInt(4);

			if (rand == 0)
				par1EntityPlayer.addChatComponentMessage(new ChatComponentText("Elsa: Conceal, don't feel"));
			else if (rand == 1)
				par1EntityPlayer.addChatComponentMessage(new ChatComponentText("Elsa: Let it go"));
			else if (rand == 2)
				par1EntityPlayer.addChatComponentMessage(new ChatComponentText("Elsa: Love will thaw"));
			else
				par1EntityPlayer.addChatComponentMessage(new ChatComponentText("Elsa: You can't marry a man you just met"));

			lastTalked = worldObj.getWorldTime();
			return true;
		}

		return false;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase entity, float var2) {
		if (!worldObj.isRemote)
			worldObj.spawnEntityInWorld(new EntityIceBoltElsa(this.worldObj, this, entity, 1.6F, (float) (14 - this.worldObj.getDifficulty().getDifficultyId() * 4)));
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		dropItem(Item.getItemFromBlock(Blocks.ice), 2);
	}
}