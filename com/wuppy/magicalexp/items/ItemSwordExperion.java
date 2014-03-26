package com.wuppy.magicalexp.items;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemSwordExperion extends ItemSword
{
    public ItemSwordExperion(ToolMaterial enumToolMaterialExperion)
    {
        super(enumToolMaterialExperion);
    }
    
    public boolean hasEffect(ItemStack itemstack)
    {
        return true;
    }
}