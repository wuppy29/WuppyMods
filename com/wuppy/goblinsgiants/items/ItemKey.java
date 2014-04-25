package com.wuppy.goblinsgiants.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import com.wuppy.goblinsgiants.GoblinGiant;
import com.wuppy.goblinsgiants.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemKey extends Item
{
	public static final String[] names = new String[] { "yellow", "blue", "white", "grey", "cyan", "brown", "red" };

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public ItemKey()
	{
		super();
		this.setHasSubtypes(true);
		maxStackSize = 64;
		this.setCreativeTab(ModTabs.ggMiscTab);
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		int var2 = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
		return super.getUnlocalizedName() + "." + names[var2];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
		icons = new IIcon[names.length];

		for (int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(GoblinGiant.modid + ":" + (this.getUnlocalizedName().substring(5)) + " " + names[i]);
		}
	}

	@Override
	public IIcon getIconFromDamage(int par1)
	{
		return icons[par1];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int x = 0; x < 7; x++)
		{
			par3List.add(new ItemStack(this, 1, x));
		}
	}
}
