package com.wuppy.magicalexp.items;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.BonemealEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;

public class ItemEarthStaff extends ItemSword
{
    public ItemEarthStaff(ToolMaterial enumToolMaterial)
    {
        super(enumToolMaterial);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7)
    {
    	if (applyBonemeal(par1ItemStack, par3World, par4, par5, par6, par2EntityPlayer))
        {
            if (!par3World.isRemote)
            {
                par3World.playAuxSFX(2005, par4, par5, par6, 0);
            }

            return true;
        }
    	return true;
    }
    
    public static boolean applyBonemeal(ItemStack p_150919_0_, World p_150919_1_, int p_150919_2_, int p_150919_3_, int p_150919_4_, EntityPlayer player)
    {
        Block block = p_150919_1_.getBlock(p_150919_2_, p_150919_3_, p_150919_4_);

        BonemealEvent event = new BonemealEvent(player, p_150919_1_, block, p_150919_2_, p_150919_3_, p_150919_4_);
        if (MinecraftForge.EVENT_BUS.post(event))
        {
            return false;
        }

        if (event.getResult() == Result.ALLOW)
        {
            if (!p_150919_1_.isRemote)
            {
                p_150919_0_.stackSize--;
            }
            return true;
        }

        if (block instanceof IGrowable)
        {
            IGrowable igrowable = (IGrowable)block;

            if (igrowable.func_149851_a(p_150919_1_, p_150919_2_, p_150919_3_, p_150919_4_, p_150919_1_.isRemote))
            {
                if (!p_150919_1_.isRemote)
                {
                    if (igrowable.func_149852_a(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_))
                    {
                        igrowable.func_149853_b(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_);
                    }

                    --p_150919_0_.stackSize;
                }

                return true;
            }
        }

        return false;
    }
}
