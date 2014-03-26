package com.wuppy.magicalexp.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityExpBottlexl extends EntityThrowable
{
    public EntityExpBottlexl(World world)
    {
        super(world);
    }

    public EntityExpBottlexl(World world, EntityLivingBase entityliving)
    {
        super(world, entityliving);
    }

    public EntityExpBottlexl(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
    }

    protected float getGravityVelocity()
    {
        return 0.07F;
    }

    protected float func_40077_c()
    {
        return 0.7F;
    }

    protected float func_40074_d()
    {
        return -20F;
    }

    /**
     * Called when the throwable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition movingobjectposition)
    {
        if (!worldObj.isRemote)
        {
            worldObj.playAuxSFX(2002, (int)Math.round(posX), (int)Math.round(posY), (int)Math.round(posZ), 0);
            
            int var2 = 3 + this.worldObj.rand.nextInt(20) + this.worldObj.rand.nextInt(20);

            while (var2 > 0)
            {
                int var3 = EntityXPOrb.getXPSplit(var2);
                var2 -= var3;
                this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var3));
            }

            setDead();
        }
    }
}
