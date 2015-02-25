package com.wuppy.peacefulpackmod.helper;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

import com.wuppy.peacefulpackmod.block.ModBlocks;
import com.wuppy.peacefulpackmod.item.ModItems;

public class PeacefulFuel implements IFuelHandler 
{
	@Override
	public int getBurnTime(ItemStack fuel)
	{
		if(fuel == new ItemStack(ModItems.peacefulMaterial, 1, 0))
			return 1000;
		if(fuel == new ItemStack(ModBlocks.blazeLog))
			return 1600;
		
		else
			return 0;
	}
}
