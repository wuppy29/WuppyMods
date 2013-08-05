package magicalexp.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityDirtBottle extends EntityThrowable
{
    public EntityDirtBottle(World par1World)
    {
        super(par1World);
    }

    public EntityDirtBottle(World par1World, EntityLivingBase par2EntityLiving)
    {
        super(par1World, par2EntityLiving);
    }

    public EntityDirtBottle(World par1World, double par2, double par4, double par6)
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

            	int i1 = MathHelper.floor_double(posX);
            	int j1 = MathHelper.floor_double(posY);
                int k1 = MathHelper.floor_double(posZ);
                if(worldObj.getBlockId(i1, j1, k1) == 0)
                {
                        worldObj.setBlock(i1, j1, k1, Block.dirt.blockID);
                        
                        if (worldObj.getBlockId(i1 + 1, j1, k1) == 0)
                        {
                        	worldObj.setBlock(i1 + 1, j1, k1, Block.dirt.blockID);
                        }
                        if (worldObj.getBlockId(i1 - 1, j1, k1) == 0)
                        {
                        	worldObj.setBlock(i1 - 1, j1, k1, Block.dirt.blockID);
                        }
                        if (worldObj.getBlockId(i1, j1, k1 + 1) == 0)
                        {
                        	worldObj.setBlock(i1, j1, k1 + 1, Block.dirt.blockID);
                        }
                        if (worldObj.getBlockId(i1 + 1, j1, k1 + 1) == 0)
                        {
                        	worldObj.setBlock(i1 + 1, j1, k1 + 1, Block.dirt.blockID);
                        }
                        if (worldObj.getBlockId(i1 - 1, j1, k1 + 1) == 0)
                        {
                        	worldObj.setBlock(i1 - 1, j1, k1 + 1, Block.dirt.blockID);
                        }
                        if (worldObj.getBlockId(i1 + 1, j1, k1 - 1) == 0)
                        {
                        	worldObj.setBlock(i1 + 1, j1, k1 - 1, Block.dirt.blockID);
                        }
                        if (worldObj.getBlockId(i1 - 1, j1, k1 - 1) == 0)
                        {
                        	worldObj.setBlock(i1 - 1, j1, k1 - 1, Block.dirt.blockID);
                        }
                        if (worldObj.getBlockId(i1, j1, k1 - 1) == 0)
                        {
                        	worldObj.setBlock(i1, j1, k1 - 1, Block.dirt.blockID);
                        }
                }
                setDead();
        }
    }
}
