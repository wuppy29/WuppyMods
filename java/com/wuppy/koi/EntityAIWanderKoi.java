package com.wuppy.koi;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

public class EntityAIWanderKoi extends EntityAIBase
{
    private EntityCreature entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private double speed;
    private int field_179481_f;
    private boolean field_179482_g;
    private static final String __OBFID = "CL_00001608";

    public EntityAIWanderKoi(EntityCreature p_i1648_1_, double p_i1648_2_)
    {
        this(p_i1648_1_, p_i1648_2_, 120);
    }

    public EntityAIWanderKoi(EntityCreature p_i45887_1_, double p_i45887_2_, int p_i45887_4_)
    {
        this.entity = p_i45887_1_;
        this.speed = p_i45887_2_;
        this.field_179481_f = p_i45887_4_;
        this.setMutexBits(1);
    }

    public boolean shouldExecute()
    {
        if (!this.field_179482_g)
        {
            if (this.entity.getAge() >= 100)
            {
                return false;
            }

            if (this.entity.getRNG().nextInt(this.field_179481_f) != 0)
            {
                return false;
            }
        }

        Vec3 vec3 = RandomPositionGenerator.findRandomTarget(this.entity, 10, 7);

        if (vec3 == null)
        {
            return false;
        }
        else if(entity.worldObj.getBlockState(new BlockPos(vec3)).getBlock().getMaterial() != Material.water)
        {
        	return false;
        }
        else
        {
            this.xPosition = vec3.xCoord;
            //this.yPosition = vec3.yCoord;
            this.zPosition = vec3.zCoord;
            this.field_179482_g = false;
            return true;
        }
    }

    public boolean continueExecuting()
    {
        return !this.entity.getNavigator().noPath();
    }

    public void startExecuting()
    {
        this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
    }

    public void func_179480_f()
    {
        this.field_179482_g = true;
    }

    public void func_179479_b(int p_179479_1_)
    {
        this.field_179481_f = p_179479_1_;
    }
}