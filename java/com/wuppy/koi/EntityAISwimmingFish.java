package com.wuppy.koi;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.BlockPos;

public class EntityAISwimmingFish extends EntityAIBase
{
    private EntityLiving entity;

    public EntityAISwimmingFish(EntityLiving par1EntityLiving)
    {
        entity = par1EntityLiving;
        setMutexBits(4);
        ((PathNavigateGround)par1EntityLiving.getNavigator()).setCanSwim(true);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return entity.isInWater() || entity.handleLavaMovement();
    }
    
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
