package com.wuppy.peacefulpackmod.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;

import com.wuppy.peacefulpackmod.PeacefulPack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCookedFlesh extends ItemFood
{
    public ItemCookedFlesh(int health, float saturation, boolean wolfFood)
    {
        super(health, saturation, wolfFood);
        setCreativeTab(PeacefulPack.ppMaterialTab);
        setUnlocalizedName("cookedflesh");
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(PeacefulPack.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }
}