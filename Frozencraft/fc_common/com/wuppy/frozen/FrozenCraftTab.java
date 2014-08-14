package com.wuppy.frozen;

import com.wuppy.frozen.items.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FrozenCraftTab extends CreativeTabs
{
	String name;
	
	public FrozenCraftTab(int par1, String par2Str)
	{
		super(par1, par2Str);
		name = par2Str;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		if(name.equals("fc_armor"))
			return ModItems.elsaBodice;
		else
		{
			System.out.println("Error getting CreativeTab");
			return null;
		}
	}
}