package com.wuppy.koi;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityKoi extends EntityCreature
{
	double speed = 0.38;
	
    public EntityKoi(World par1World)
    {
    	super(par1World);
    	tasks.addTask(0, new EntityAIPanicKoi(this, speed));
    	tasks.addTask(1, new EntityAISwimmingFish(this));
    	tasks.addTask(2, new EntityAIWander(this, speed));
    }

	@Override
	public float getBlockPathWeight(BlockPos pos)
	{
		return this.worldObj.getBlockState(pos).getBlock().getMaterial() == Material.water ? 10.0F + this.worldObj.getLightBrightness(pos) - 0.5F : super.getBlockPathWeight(pos);
	}

	@Override
	protected PathNavigate getNewNavigator(World worldIn)
	{
		return new PathNavigateSwimmer(this, worldIn);
	}
    
    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
    }
    
    @Override
	protected Item getDropItem()
    {
        return Items.fish;
    }
	
    @Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
    }
	
    @Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
    }
    
    //EntityWaterMob class because MC devs are stupid
    @Override
    public boolean canBreatheUnderwater()
    {
        return true;
    }

    @Override
    public boolean getCanSpawnHere()
    {
	    return worldObj.getBlockState(new BlockPos(posX, posY, posZ)).getBlock().getMaterial() == Material.water;
    }

    @Override
    public boolean handleLavaMovement()
    {
        return this.worldObj.checkNoEntityCollision(this.getEntityBoundingBox(), this);
    }
    
    @Override
    protected boolean canDespawn()
    {
        return true;
    }
    
    @Override
    public void onEntityUpdate()
    {
        int i = this.getAir();
        super.onEntityUpdate();

        if (this.isEntityAlive() && !this.isInWater())
        {
            --i;
            this.setAir(i);

            if (this.getAir() == -20)
            {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.drown, 2.0F);
            }
        }
        else
        {
            this.setAir(300);
        }
    }

    @Override
    public boolean isPushedByWater()
    {
        return false;
    }
}