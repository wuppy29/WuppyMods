package com.wuppy.magicalexp;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class MagicFuel implements IFuelHandler 
{
	public int getBurnTime(ItemStack fuel) 
	{
		if(fuel == new ItemStack(MagicalExperience.fuelbottle))
			return 3200;
		
		else
			return 0;
	}
}
