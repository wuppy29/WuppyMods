package com.wuppy.peacefulpackmod.helper;

import net.minecraft.item.ItemStack;

import com.wuppy.peacefulpackmod.block.ModBlocks;
import com.wuppy.peacefulpackmod.item.ModItems;

import cpw.mods.fml.common.IFuelHandler;

public class PeacefulFuel implements IFuelHandler 
{
	public int getBurnTime(ItemStack fuel) 
	{
		if(fuel == new ItemStack(ModItems.sulphDust))
			return 1000;
		if(fuel == new ItemStack(ModBlocks.blazelog))
			return 1600;
		
		else
			return 0;
	}
}
