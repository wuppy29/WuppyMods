package com.wuppy.frozen.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class EntityElsa extends EntityMob implements IRangedAttackMob
{
	public EntityElsa(World par1World)
	{
		super(par1World);

		tasks.addTask(1, new EntityAISwimming(this));
		tasks.addTask(4, new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F));
		tasks.addTask(5, new EntityAIWander(this, 1.0D));
		tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
		tasks.addTask(6, new EntityAILookIdle(this));

		targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2D);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30D);
	}

	@Override
	protected boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		int x = (int) posX;
		int y = (int) posY - 1;
		int z = (int) posZ;

		Block block = worldObj.getBlock(x, y, z);

		// water
		if (block == Blocks.water || block == Blocks.flowing_water)
		{
			worldObj.setBlock(x, y, z, Blocks.ice);
		}
		if (worldObj.getBlock(x + 1, y, z) == Blocks.water || worldObj.getBlock(x + 1, y, z) == Blocks.flowing_water)
		{
			worldObj.setBlock(x + 1, y, z, Blocks.ice);
		}
		if (worldObj.getBlock(x - 1, y, z) == Blocks.water || worldObj.getBlock(x - 1, y, z) == Blocks.flowing_water)
		{
			worldObj.setBlock(x - 1, y, z, Blocks.ice);
		}
		if (worldObj.getBlock(x, y, z + 1) == Blocks.water || worldObj.getBlock(x, y, z + 1) == Blocks.flowing_water)
		{
			worldObj.setBlock(x, y, z + 1, Blocks.ice);
		}
		if (worldObj.getBlock(x, y, z - 1) == Blocks.water || worldObj.getBlock(x, y, z - 1) == Blocks.flowing_water)
		{
			worldObj.setBlock(x, y, z - 1, Blocks.ice);
		}

		// lava
		if (block == Blocks.lava || block == Blocks.flowing_lava)
		{
			worldObj.setBlock(x, y, z, Blocks.obsidian);
		}
		if (worldObj.getBlock(x + 1, y, z) == Blocks.lava || worldObj.getBlock(x + 1, y, z) == Blocks.flowing_lava)
		{
			worldObj.setBlock(x + 1, y, z, Blocks.obsidian);
		}
		if (worldObj.getBlock(x - 1, y, z) == Blocks.lava || worldObj.getBlock(x - 1, y, z) == Blocks.flowing_lava)
		{
			worldObj.setBlock(x - 1, y, z, Blocks.obsidian);
		}
		if (worldObj.getBlock(x, y, z + 1) == Blocks.lava || worldObj.getBlock(x, y, z + 1) == Blocks.flowing_lava)
		{
			worldObj.setBlock(x, y, z + 1, Blocks.obsidian);
		}
		if (worldObj.getBlock(x, y, z - 1) == Blocks.lava || worldObj.getBlock(x, y, z - 1) == Blocks.flowing_lava)
		{
			worldObj.setBlock(x, y, z - 1, Blocks.obsidian);
		}
	}

	long lastTalked = 0;

	@Override
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		if (lastTalked == 0)
			worldObj.getWorldTime();

		if (!worldObj.isRemote && lastTalked + 20 < worldObj.getWorldTime())
		{
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
	public void attackEntityWithRangedAttack(EntityLivingBase entity, float var2)
	{
		if (!worldObj.isRemote)
			worldObj.spawnEntityInWorld(new EntityIceBoltElsa(this.worldObj, this, entity, 1.6F, (float) (14 - this.worldObj.difficultySetting.getDifficultyId() * 4)));
	}

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		dropItem(Item.getItemFromBlock(Blocks.ice), 2);
	}
}