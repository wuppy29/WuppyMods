package com.wuppy.magicalexp.items;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

import com.wuppy.magicalexp.MagicalExperience;

public class ItemSwordExperion extends ItemSword
{
    public ItemSwordExperion(ToolMaterial enumToolMaterialExperion)
    {
        super(enumToolMaterialExperion);
        setCreativeTab(MagicalExperience.meUsables);
    }
    
    public boolean hasEffect(ItemStack itemstack)
    {
        return true;
    }
}