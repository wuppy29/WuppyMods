package com.wuppy.magicalexp.items;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

import com.wuppy.magicalexp.MagicalExperience;

public class ItemAxeExperion extends ItemAxe
{
	public ItemAxeExperion(ToolMaterial par2EnumToolMaterialExperion)
    {
        super(par2EnumToolMaterialExperion);
        setCreativeTab(MagicalExperience.meUsables);
    }
	
	public boolean hasEffect(ItemStack itemstack)
    {
		return true;
    }
}