package com.wuppy.frozen.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.wuppy.frozen.items.ModItems;

public class EntityHans extends EntityMob
{
	private static final ItemStack defaultHeldItem = new ItemStack(ModItems.hansSword, 1);

	public EntityHans(World par1World)
	{
		super(par1World);

		tasks.addTask(1, new EntityAISwimming(this));
		tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		tasks.addTask(5, new EntityAIWander(this, 1.0D));
		tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
		tasks.addTask(6, new EntityAILookIdle(this));

		targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4D);
	}

	@Override
	public ItemStack getHeldItem()
	{
		return defaultHeldItem;
	}

	long lastTalked = 0;

	@Override
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		if (lastTalked == 0)
			worldObj.getWorldTime();

		if (!worldObj.isRemote && lastTalked + 20 < worldObj.getWorldTime())
		{
			int rand = worldObj.rand.nextInt(3);

			if (rand == 0)
				par1EntityPlayer.addChatComponentMessage(new ChatComponentText("Hans: Prince Hans of the Southern Isles"));
			else if (rand == 1)
				par1EntityPlayer.addChatComponentMessage(new ChatComponentText("Hans: You're no match for Elsa"));
			else
				par1EntityPlayer.addChatComponentMessage(new ChatComponentText("Hans: Love is an open door"));
			
			lastTalked = worldObj.getWorldTime();
		}

		return false;
	}

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		dropItem(Items.gold_ingot, 2);
	}
}