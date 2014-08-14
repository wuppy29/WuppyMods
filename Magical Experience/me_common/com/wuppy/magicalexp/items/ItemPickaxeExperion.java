package com.wuppy.magicalexp.items;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

import com.wuppy.magicalexp.MagicalExperience;

public class ItemPickaxeExperion extends ItemPickaxe
{
	public ItemPickaxeExperion(ToolMaterial enumToolMaterialExperion)
    {
        super(enumToolMaterialExperion);
        setCreativeTab(MagicalExperience.meUsables);
    }
    
    public boolean hasEffect(ItemStack itemstack)
    {
        return true;
    }
}