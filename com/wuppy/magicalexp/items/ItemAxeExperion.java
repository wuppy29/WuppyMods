package com.wuppy.magicalexp.items;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemAxeExperion extends ItemAxe
{
	public ItemAxeExperion(ToolMaterial par2EnumToolMaterialExperion)
    {
        super(par2EnumToolMaterialExperion);
    }
	
	public boolean hasEffect(ItemStack itemstack)
    {
		return true;
    }
}