package com.wuppy.koi;

import java.util.Random;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityKoi extends EntityWaterMob
{
    public EntityKoi(World par1World)
    {
    	super(par1World);
    	tasks.addTask(1, new EntityAISwimmingFish(this));
    	tasks.addTask(2, new EntityAIPanicKoi(this, 0.38F));
    	tasks.addTask(3, new EntityAIWanderKoi(this, 0.3F));
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
    
    //created custom findRandomTargetBlock because MC devs are stupid apparently
    static Vec3 findRandomTargetBlock(EntityKoi entity, int p_75462_1_, int p_75462_2_, Vec3 p_75462_3_)
    {
        Random random = entity.getRNG();
        boolean flag = false;
        int k = 0;
        int l = 0;
        int i1 = 0;
        float f = -99999.0F;
        boolean flag1 = false;

        for (int l1 = 0; l1 < 10; ++l1)
        {
            int j1 = random.nextInt(2 * p_75462_1_ + 1) - p_75462_1_;
            int i2 = random.nextInt(2 * p_75462_2_ + 1) - p_75462_2_;
            int k1 = random.nextInt(2 * p_75462_1_ + 1) - p_75462_1_;

            if (p_75462_3_ == null || (double)j1 * p_75462_3_.xCoord + (double)k1 * p_75462_3_.zCoord >= 0.0D)
            {
                BlockPos blockpos;

                j1 += MathHelper.floor_double(entity.posX);
                i2 += MathHelper.floor_double(entity.posY);
                k1 += MathHelper.floor_double(entity.posZ);
                blockpos = new BlockPos(j1, i2, k1);

                float f1 = 0;

                if (f1 > f)
                {
                    f = f1;
                    k = j1;
                    l = i2;
                    i1 = k1;
                    flag = true;
                }
            }
        }

        if (flag)
        {
            return new Vec3((double)k, (double)l, (double)i1);
        }
        else
        {
            return null;
        }
    }
}