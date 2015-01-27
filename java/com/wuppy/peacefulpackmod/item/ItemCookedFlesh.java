package com.wuppy.peacefulpackmod.item;

import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.wuppy.peacefulpackmod.PeacefulPack;

public class ItemCookedFlesh extends ItemFood
{
	private final String name = "cookedFlesh";
	
    public ItemCookedFlesh(int health, float saturation, boolean wolfFood)
    {
        super(health, saturation, wolfFood);
        GameRegistry.registerItem(this, name);
    	setUnlocalizedName(PeacefulPack.modid + "_" + name);
        
        setCreativeTab(PeacefulPack.ppMaterialTab);
    }
    
    public String getName()
    {
    	return name;
    }
    
    /*@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(PeacefulPack.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }*/
}