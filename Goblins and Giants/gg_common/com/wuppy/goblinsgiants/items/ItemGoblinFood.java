package com.wuppy.goblinsgiants.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;

import com.wuppy.goblinsgiants.GoblinGiant;
import com.wuppy.goblinsgiants.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGoblinFood extends ItemFood
{
	public ItemGoblinFood(int heal, float saturation, boolean wolfFood, String name)
	{
		super(heal, saturation, wolfFood);
		setCreativeTab(ModTabs.ggMiscTab);
		setUnlocalizedName(name);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(GoblinGiant.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}