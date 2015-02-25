package com.wuppy.frozen.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntitySven extends EntityTameable
{
	public EntitySven(World world)
	{
		super(world);
		setSize(3F, 2.5F);
		tasks.addTask(1, new EntityAISwimming(this));
		tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.0D, true));
		tasks.addTask(3, new EntityAIFollowOwner(this, 0.6D, 4.0F, 20.0F));
		tasks.addTask(4, new EntityAIWander(this, 1.0D));
		tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(5, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6D);
	}

	@Override
	public boolean interact(EntityPlayer player)
	{
		ItemStack itemstack = player.inventory.getCurrentItem();

		if (itemstack != null)
		{
			if (itemstack.getItem() == Items.carrot)
			{
				if (!isTamed())
				{
					setTamed(true);
					return true;
				}
			}
		}

		return super.interact(player);
	}

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		dropItem(Items.leather, 2);
		dropItem(Items.carrot, 2);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_)
	{
		return null;
	}
}