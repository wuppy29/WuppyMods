package com.wuppy.koi;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class Entitykoi extends EntityWaterMob
{
    public Entitykoi(World par1World)
    {
    	super (par1World);
    	tasks.addTask(0, new EntityAIMoveToWater(this, this.worldObj));
    	tasks.addTask(1, new EntityAISwimmingFish(this));
    	tasks.addTask(2, new EntityAIPanicKoi(this, 0.38F));
    	tasks.addTask(3, new EntityAIWanderKoi(this, 0.3F)); 
    	System.out.println("build");
    }
    
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(1D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(10.0D);
    }
    
    public boolean isAIEnabled()
    {
        return true;
    }
	
	public boolean canBreatheUnderwater()
    {
        return true;
    }
	
	protected boolean canDespawn()
    {
        return true;
    }
	
	protected Item func_146068_u()
    {
        return Items.fish;
    }
	
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
    }
	
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
    }
    
    public boolean getCanSpawnHere()
    {
        return worldObj.checkNoEntityCollision(boundingBox);
    }
}
