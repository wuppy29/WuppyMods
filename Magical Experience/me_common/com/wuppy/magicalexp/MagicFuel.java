package com.wuppy.magicalexp;

import net.minecraft.item.ItemStack;

import com.wuppy.magicalexp.items.ModItems;

import cpw.mods.fml.common.IFuelHandler;

public class MagicFuel implements IFuelHandler
{
	public int getBurnTime(ItemStack fuel)
	{
		if (fuel == new ItemStack(ModItems.fuelbottle))
			return 3200;

		else
			return 0;
	}
}
