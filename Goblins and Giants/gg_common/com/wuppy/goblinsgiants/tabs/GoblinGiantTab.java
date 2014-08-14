package com.wuppy.goblinsgiants.tabs;

import com.wuppy.goblinsgiants.blocks.ModBlocks;
import com.wuppy.goblinsgiants.items.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GoblinGiantTab extends CreativeTabs
{
	String name;
	
	public GoblinGiantTab(int par1, String par2Str)
	{
		super(par1, par2Str);
		name = par2Str;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		if(name == "gg_weapons")
			return ModItems.bonespear;
		else if(name == "gg_blocks")
			return Item.getItemFromBlock(ModBlocks.savannahtnt);
		else if(name == "gg_materials")
			return ModItems.component;
		else if(name == "gg_misc")
			return ModItems.key;
		else
		{
			System.out.println("Error getting CreativeTab");
			return null;
		}
	}
}