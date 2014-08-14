package com.wuppy.frozen.items;

import com.wuppy.frozen.FrozenCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;

public class ItemFrozenHeart extends Item
{
	public ItemFrozenHeart()
	{
		setUnlocalizedName("frozenHeart");
		setTextureName(FrozenCraft.modid + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabMisc);
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (!par2World.isRemote)
		{
			WorldInfo worldinfo = MinecraftServer.getServer().worldServers[0].getWorldInfo();
			worldinfo.setRaining(!worldinfo.isRaining());
			par1ItemStack.stackSize--;
		}

		return par1ItemStack;
	}
}