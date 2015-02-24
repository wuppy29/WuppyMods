package com.wuppy.koi;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.BlockPos;

public class EntityAISwimmingFish extends EntityAIBase
{
    private EntityLiving entity;

    public EntityAISwimmingFish(EntityLiving par1EntityLiving)
    {
        entity = par1EntityLiving;
        setMutexBits(4);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute()
    {
        return entity.isInWater() || entity.handleLavaMovement();
    }
    
    @Override
    public void updateTask()
    {
    	if(entity.worldObj.getBlockState(new BlockPos(entity.posX, entity.posY + 1, entity.posZ)).getBlock().getMaterial() == Material.water);
    	{
	        if (entity.getRNG().nextFloat() < 0.1F)
	        {
	            entity.getJumpHelper().setJumping();
	        }
    	}
    }
}
