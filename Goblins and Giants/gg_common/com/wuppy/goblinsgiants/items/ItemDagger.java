package com.wuppy.goblinsgiants.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSword;

import com.wuppy.goblinsgiants.GoblinGiant;
import com.wuppy.goblinsgiants.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDagger extends ItemSword
{
    public ItemDagger(ToolMaterial enumToolMaterial)
    {
        super(enumToolMaterial);
        setCreativeTab(ModTabs.ggWeaponsTab);
        setUnlocalizedName("dagger");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(GoblinGiant.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }
}