package com.wuppy.peacefulpackmod.helper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.wuppy.peacefulpackmod.block.ModBlocks;
import com.wuppy.peacefulpackmod.item.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PeacefulTab extends CreativeTabs
{
	String name;
	
	public PeacefulTab(int par1, String par2Str)
	{
		super(par1, par2Str);
		name = par2Str;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		if(name == "pp_blocks")
			return Item.getItemFromBlock(ModBlocks.oreblock);
		else if(name == "pp_materials")
			return ModItems.chain;
		else
		{
			System.out.println("Error getting CreativeTab");
			return null;
		}
	}
}