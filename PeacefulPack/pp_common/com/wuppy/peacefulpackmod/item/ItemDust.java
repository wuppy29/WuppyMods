package com.wuppy.peacefulpackmod.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import com.wuppy.peacefulpackmod.PeacefulPack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDust extends Item
{
    public ItemDust(String name)
    {
        setCreativeTab(PeacefulPack.ppMaterialTab);
        setUnlocalizedName(name);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(PeacefulPack.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }
}