package com.wuppy.nethereye;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemNetherEye extends Item
{
	private final String name = "nethereye";
	
    public ItemNetherEye()
    {
    	GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabs.tabMisc);
    }
    
    public String getName()
    {
    	return name;
    }
    
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	if (!par2World.isRemote && par3EntityPlayer.dimension == -1)
        {
    		BlockPos blockpos = par2World.getStrongholdPos("Fortress", new BlockPos(par3EntityPlayer));
            
            if (blockpos != null)
            {
                EntityNetherEye var6 = new EntityNetherEye(par2World, par3EntityPlayer.posX, par3EntityPlayer.posY + 1.5f, par3EntityPlayer.posZ);
                var6.moveTowards((double)blockpos.getX(), blockpos.getY(), (double)blockpos.getZ());
                par2World.spawnEntityInWorld(var6);
                par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                par2World.playAuxSFXAtEntity(null, 1002, new BlockPos(par3EntityPlayer), 0);

                if (!par3EntityPlayer.capabilities.isCreativeMode)
                {
                    --par1ItemStack.stackSize;
                }
            }
            else
            {
            	par3EntityPlayer.addChatComponentMessage(new ChatComponentText("There is no fortress nearby."));
            }
        }
    	else if(!par2World.isRemote)
    	{
    		par3EntityPlayer.addChatComponentMessage(new ChatComponentText("You need to be in the Nether to use this."));
    	}

        return par1ItemStack;
    }
}
