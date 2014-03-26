package com.wuppy.magicalexp.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemPickaxeExperion extends ItemPickaxe
{
	public ItemPickaxeExperion(ToolMaterial enumToolMaterialExperion)
    {
        super(enumToolMaterialExperion);
        this.setCreativeTab(CreativeTabs.tabTools);
    }
    
    public boolean hasEffect(ItemStack itemstack)
    {
        return true;
    }
}