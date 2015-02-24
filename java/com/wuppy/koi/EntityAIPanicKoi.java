package com.wuppy.koi;

import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

public class EntityAIPanicKoi extends EntityAIBase
{
    private EntityMob theEntityCreature;
    protected double speed;
    private double randPosX;
    private double randPosY;
    private double randPosZ;
    private static final String __OBFID = "CL_00001604";

    public EntityAIPanicKoi(EntityMob p_i1645_1_, double p_i1645_2_)
    {
        this.theEntityCreature = p_i1645_1_;
        this.speed = p_i1645_2_;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute()
    {
        if (this.theEntityCreature.getAITarget() == null && !this.theEntityCreature.isBurning())
        {
            return false;
        }
        else
        {
            Vec3 vec3 = RandomPositionGenerator.findRandomTarget(this.theEntityCreature, 5, 4);

            if (vec3 == null)
            {
                return false;
            }
            else if(theEntityCreature.worldObj.getBlockState(new BlockPos(vec3)).getBlock().getMaterial() != Material.water)
            {
            	return false;
            }
            else
            {
                this.randPosX = vec3.xCoord;
                //this.randPosY = vec3.yCoord;
                this.randPosZ = vec3.zCoord;
                return true;
            }
        }
    }

    @Override
    public void startExecuting()
    {
        this.theEntityCreature.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ, this.speed);
    }

    @Override
    public boolean continueExecuting()
    {
        return !this.theEntityCreature.getNavigator().noPath();
    }
}