package com.wuppy.magicalexp.entity;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.entity.player.BonemealEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;

public class EntityBonemealBottle extends EntityThrowable
{
    public EntityBonemealBottle(World par1World)
    {
        super(par1World);
    }

    public EntityBonemealBottle(World par1World, EntityLivingBase par2EntityLiving)
    {
        super(par1World, par2EntityLiving);
    }

    public EntityBonemealBottle(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    protected float getGravityVelocity()
    {
        return 0.07F;
    }

    protected float func_70182_d()
    {
        return 0.7F;
    }

    protected float func_70183_g()
    {
        return -20.0F;
    }

    /**
     * Called when the throwable hits a block or entity.z
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
    	if (applyBonemeal(worldObj, par1MovingObjectPosition.blockX, par1MovingObjectPosition.blockY, par1MovingObjectPosition.blockZ, FakePlayerFactory.getMinecraft((WorldServer) worldObj)))
        {
            if (!worldObj.isRemote)
            {
                worldObj.playAuxSFX(2005, par1MovingObjectPosition.blockX, par1MovingObjectPosition.blockY, par1MovingObjectPosition.blockZ, 0);
            }
        }
    }
    
    public static boolean applyBonemeal(World world, int x, int y, int z, EntityPlayer player)
    {
        Block block = world.getBlock(x, y, z);

        BonemealEvent event = new BonemealEvent(player, world, block, x, y, z);
        if (MinecraftForge.EVENT_BUS.post(event))
        {
            return false;
        }

        if (event.getResult() == Result.ALLOW)
        {
            return true;
        }

        if (block instanceof IGrowable)
        {
            IGrowable igrowable = (IGrowable)block;

            if (igrowable.func_149851_a(world, x, y, z, world.isRemote))
            {
                if (!world.isRemote)
                {
                    if (igrowable.func_149852_a(world, world.rand, x, y, z))
                    {
                        igrowable.func_149853_b(world, world.rand, x, y, z);
                    }
                }

                return true;
            }
        }

        return false;
    }
}
