package com.wuppy.magicalexp;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.wuppy.magicalexp.blocks.ModBlocks;
import com.wuppy.magicalexp.items.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MagicalExperienceTab extends CreativeTabs
{
	private String name;
	
	public MagicalExperienceTab(int par1, String par2Str)
	{
		super(par1, par2Str);
		name = par2Str;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		if(name.equals("me_blocks"))
			return Item.getItemFromBlock(ModBlocks.spell);
		else if(name.equals("me_materials"))
			return ModItems.components;
		else if(name.equals("me_usables"))
			return ModItems.thunderbottle;
		else
		{
			System.out.println("Error getting CreativeTab");
			return null;
		}
	}
}