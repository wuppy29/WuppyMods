package magicalexp.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityThunderbottle extends EntityThrowable
{
    public EntityThunderbottle(World par1World)
    {
        super(par1World);
    }

    public EntityThunderbottle(World par1World, EntityLivingBase par2EntityLiving)
    {
        super(par1World, par2EntityLiving);
    }

    public EntityThunderbottle(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    protected float func_40075_e()
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
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (!worldObj.isRemote)
        {
            worldObj.playAuxSFX(2002, (int)Math.round(posX), (int)Math.round(posY), (int)Math.round(posZ), 0);

            for (int i = 3 + worldObj.rand.nextInt(5) + worldObj.rand.nextInt(5); i > 0;)
            {
                int j = EntityXPOrb.getXPSplit(i);
                i -= j;
            }

            setDead();
        }
        
        worldObj.spawnEntityInWorld(new EntityLightningBolt(worldObj, posX, posY, posZ));
    }
}