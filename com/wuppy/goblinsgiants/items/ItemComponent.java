package com.wuppy.goblinsgiants.items;

import java.util.List;

import com.wuppy.goblinsgiants.GoblinGiant;
import com.wuppy.goblinsgiants.tabs.ModTabs;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemComponent extends Item
{
	public static final String[] names = new String[] { "vampireblood", "speartip", "giantbone", "redgiantbone", "poisonbottle", "savannahgunpowder" };

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public ItemComponent()
	{
		super();
		this.setHasSubtypes(true);
		maxStackSize = 64;
		this.setCreativeTab(ModTabs.ggMaterialTab);
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
		return super.getUnlocalizedName() + "." + names[i];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
		icons = new IIcon[names.length];

		for (int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(GoblinGiant.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
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
		for (int x = 0; x < 6; x++)
		{
			par3List.add(new ItemStack(this, 1, x));
		}
	}
}
