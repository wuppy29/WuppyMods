package com.wuppy.goblinsgiants.items;

import com.wuppy.goblinsgiants.GoblinGiant;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPortalPlacer extends Item
{
	public ItemPortalPlacer()
	{
		super();
		maxStackSize = 1;
		this.setCreativeTab(CreativeTabs.tabMisc);
	}

	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(GoblinGiant.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if(!par2World.isRemote)
		{
			par2World.setBlock((int) par3EntityPlayer.posX, (int) par3EntityPlayer.posY, (int) par3EntityPlayer.posZ, Blocks.sandstone);
			par2World.setBlock((int) par3EntityPlayer.posX, (int) par3EntityPlayer.posY + 1, (int) par3EntityPlayer.posZ, Blocks.sandstone);
			par2World.setBlock((int) par3EntityPlayer.posX, (int) par3EntityPlayer.posY + 2, (int) par3EntityPlayer.posZ, Blocks.sandstone);
			par2World.setBlock((int) par3EntityPlayer.posX, (int) par3EntityPlayer.posY + 3, (int) par3EntityPlayer.posZ, Blocks.sandstone);
			par2World.setBlock((int) par3EntityPlayer.posX, (int) par3EntityPlayer.posY + 4, (int) par3EntityPlayer.posZ, Blocks.sandstone);
			par2World.setBlock((int) par3EntityPlayer.posX + 1, (int) par3EntityPlayer.posY + 4, (int) par3EntityPlayer.posZ, Blocks.sandstone);
			par2World.setBlock((int) par3EntityPlayer.posX + 1, (int) par3EntityPlayer.posY, (int) par3EntityPlayer.posZ, Blocks.sandstone);
			par2World.setBlock((int) par3EntityPlayer.posX + 2, (int) par3EntityPlayer.posY + 4, (int) par3EntityPlayer.posZ, Blocks.sandstone);
			par2World.setBlock((int) par3EntityPlayer.posX + 2, (int) par3EntityPlayer.posY, (int) par3EntityPlayer.posZ, Blocks.sandstone);
			par2World.setBlock((int) par3EntityPlayer.posX + 3, (int) par3EntityPlayer.posY, (int) par3EntityPlayer.posZ, Blocks.sandstone);
			par2World.setBlock((int) par3EntityPlayer.posX + 3, (int) par3EntityPlayer.posY + 1, (int) par3EntityPlayer.posZ, Blocks.sandstone);
			par2World.setBlock((int) par3EntityPlayer.posX + 3, (int) par3EntityPlayer.posY + 2, (int) par3EntityPlayer.posZ, Blocks.sandstone);
			par2World.setBlock((int) par3EntityPlayer.posX + 3, (int) par3EntityPlayer.posY + 3, (int) par3EntityPlayer.posZ, Blocks.sandstone);
			par2World.setBlock((int) par3EntityPlayer.posX + 3, (int) par3EntityPlayer.posY + 4, (int) par3EntityPlayer.posZ, Blocks.sandstone);

			par2World.setBlock((int) par3EntityPlayer.posX + 1, (int) par3EntityPlayer.posY + 1, (int) par3EntityPlayer.posZ, GoblinGiant.goblinportal);
			par2World.setBlock((int) par3EntityPlayer.posX + 1, (int) par3EntityPlayer.posY + 2, (int) par3EntityPlayer.posZ, GoblinGiant.goblinportal);
			par2World.setBlock((int) par3EntityPlayer.posX + 1, (int) par3EntityPlayer.posY + 3, (int) par3EntityPlayer.posZ, GoblinGiant.goblinportal);
			par2World.setBlock((int) par3EntityPlayer.posX + 2, (int) par3EntityPlayer.posY + 1, (int) par3EntityPlayer.posZ, GoblinGiant.goblinportal);
			par2World.setBlock((int) par3EntityPlayer.posX + 2, (int) par3EntityPlayer.posY + 2, (int) par3EntityPlayer.posZ, GoblinGiant.goblinportal);
			par2World.setBlock((int) par3EntityPlayer.posX + 2, (int) par3EntityPlayer.posY + 3, (int) par3EntityPlayer.posZ, GoblinGiant.goblinportal);

			par1ItemStack.stackSize--;
		}

		return par1ItemStack;
    }
}
