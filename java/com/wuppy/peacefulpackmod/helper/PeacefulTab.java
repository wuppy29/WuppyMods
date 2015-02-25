package com.wuppy.peacefulpackmod.helper;

import com.wuppy.peacefulpackmod.block.ModBlocks;
import com.wuppy.peacefulpackmod.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
		if (name.equals("pp_blocks"))
			return Item.getItemFromBlock(ModBlocks.oreBlock);
		else if (name.equals("pp_materials"))
			return ModItems.peacefulMaterial;
		else
		{
			System.out.println("Error getting CreativeTab");
			return null;
		}
	}
}