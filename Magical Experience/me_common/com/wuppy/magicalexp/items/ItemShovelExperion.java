package com.wuppy.magicalexp.items;

import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

import com.wuppy.magicalexp.MagicalExperience;

public class ItemShovelExperion extends ItemSpade
{
	public ItemShovelExperion(ToolMaterial enumToolMaterialExperion)
    {
        super(enumToolMaterialExperion);
        setCreativeTab(MagicalExperience.meUsables);
    }

    public boolean hasEffect(ItemStack itemstack)
    {
        return true;
    }
}
