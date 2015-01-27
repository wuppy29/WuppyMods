package com.wuppy.frozen;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.wuppy.frozen.items.ModItems;

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