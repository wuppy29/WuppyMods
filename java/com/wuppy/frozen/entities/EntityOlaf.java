package com.wuppy.frozen.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class EntityOlaf extends EntityTameable
{
	public EntityOlaf(World world)
	{
		super(world);
		setSize(0.8F, 0.6F);
		((PathNavigateGround) this.getNavigator()).setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
	}

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		dropItem(Items.snowball, 10);
	}

	long lastTalked = 0;

	@Override
	public boolean interact(EntityPlayer player)
	{
		ItemStack itemstack = player.inventory.getCurrentItem();

		if (itemstack != null)
		{
			if (itemstack.getItem() == Items.bone)
			{
				if (!isTamed())
				{
					setTamed(true);
					return true;
				}
			}
		}

		if (lastTalked == 0)
			worldObj.getWorldTime();

		if (!worldObj.isRemote && lastTalked + 20 < worldObj.getWorldTime())
		{
			int rand = worldObj.rand.nextInt(4);

			if (rand == 0)
				player.addChatComponentMessage(new ChatComponentText("Olaf: Hi everyone! I'm Olaf and I like warm hugs"));
			else if (rand == 1)
				player.addChatComponentMessage(new ChatComponentText("Olaf: It's so cute! It's like a little baby unicorn!"));
			else if (rand == 2)
				player.addChatComponentMessage(new ChatComponentText("Olaf: I dont have a skull. Or bones"));
			else if (rand == 3)
				player.addChatComponentMessage(new ChatComponentText("Olaf: Oh look at that, I've been impaled"));
			else
				player.addChatComponentMessage(new ChatComponentText("Olaf: Some people are worth melting for"));

			lastTalked = worldObj.getWorldTime();
			return true;
		}

		return super.interact(player);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_)
	{
		return null;
	}
}