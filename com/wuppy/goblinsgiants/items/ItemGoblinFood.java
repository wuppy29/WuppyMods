package com.wuppy.goblinsgiants.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;

import com.wuppy.goblinsgiants.GoblinGiant;
import com.wuppy.goblinsgiants.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGoblinFood extends ItemFood
{
	/** Number of ticks to run while 'EnumAction'ing until result. */
	public final int itemUseDuration;

	public ItemGoblinFood(int heal, float saturation, boolean wolfFood)
	{
		super(heal, saturation, wolfFood);
		this.itemUseDuration = 32;
		this.setCreativeTab(ModTabs.ggMiscTab);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(GoblinGiant.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}