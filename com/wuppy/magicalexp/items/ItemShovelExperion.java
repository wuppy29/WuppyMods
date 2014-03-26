package com.wuppy.magicalexp.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemShovelExperion extends ItemSpade
{
	public ItemShovelExperion(ToolMaterial enumToolMaterialExperion)
    {
        super(enumToolMaterialExperion);
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    public boolean hasEffect(ItemStack itemstack)
    {
        return true;
    }
}
