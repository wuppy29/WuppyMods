package com.wuppy.frozen.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class EntityAnna extends EntityAnimal
{
    public EntityAnna(World par1World)
    {
        super(par1World);
        this.setSize(1.0F, 2.0F);
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.6D, 0.6D));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
        this.tasks.addTask(6, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(7, new EntityAIWatchClosest2(this, EntityVillager.class, 5.0F, 0.02F));
        this.tasks.addTask(8, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
    }
    
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    public int getTotalArmorValue()
    {
        return 5;
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    @Override
	protected void dropFewItems(boolean par1, int par2)
	{
		dropItem(Item.getItemFromBlock(Blocks.red_flower), 3);
	}

	public EntityAgeable createChild(EntityAgeable var1)
	{
		return null;
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
				par1EntityPlayer.addChatComponentMessage(new ChatComponentText("Anna: Do you want to build a snowman?"));
			else if (rand == 1)
				par1EntityPlayer.addChatComponentMessage(new ChatComponentText("Anna: Wait, what?"));
			else if (rand == 2)
				par1EntityPlayer.addChatComponentMessage(new ChatComponentText("Anna: For the first time in forever"));
			else
				par1EntityPlayer.addChatComponentMessage(new ChatComponentText("Anna: It is not nice to throw people"));
			
			lastTalked = worldObj.getWorldTime();
			return true;
		}
		
		return false;
	}
}