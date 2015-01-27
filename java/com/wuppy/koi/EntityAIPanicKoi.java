package com.wuppy.koi;

import java.util.Random;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class EntityAIPanicKoi extends EntityAIBase
{
    private EntityKoi entityKoi;
    private double speed;
    private double randPosX;
    private double randPosY;
    private double randPosZ;

    public EntityAIPanicKoi(EntityKoi entity, double par2)
    {
        this.entityKoi = entity;
        this.speed = par2;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	if(!this.entityKoi.isInWater())
    	{
    		return false;
    	}
        if (this.entityKoi.getAITarget() == null && !this.entityKoi.isBurning())
        {
            return false;
        }
        else
        {
            Vec3 vec3 = entityKoi.findRandomTargetBlock(this.entityKoi, 5, 4, (Vec3)null);

            if (vec3 == null)
            {
                return false;
            }
            else
            {
                this.randPosX = vec3.xCoord;
                this.randPosY = vec3.yCoord;
                this.randPosZ = vec3.zCoord;
                return true;
            }
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.entityKoi.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ, this.speed);
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.entityKoi.getNavigator().noPath();
    }
    
}
