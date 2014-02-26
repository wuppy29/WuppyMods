package com.wuppy.goblinsgiants.blocks;

import java.util.List;
import java.util.Random;

import com.wuppy.goblinsgiants.GoblinGiant;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOreBlock extends Block
{
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public BlockOreBlock()
	{
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHarvestLevel("pickaxe", 2);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IIconRegister)
	{
		icons = new IIcon[9];

		for (int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IIconRegister.registerIcon(GoblinGiant.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2)
	{
		switch (par2)
		{
		case 0:
			if (par1 == 1)
				return icons[1];
			if (par1 == 0)
				return icons[0];
			else
				return icons[2];
		case 1:
			return icons[3];
		case 2:
			return icons[4];
		case 3:
			return icons[5];
		case 4:
			return icons[6];
		case 5:
			return icons[7];
		case 6:
			return icons[8];
		default:
			return icons[0];
		}
	}

	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return GoblinGiant.gem;
	}

	public int damageDropped(int par1)
	{
		return par1;
	}

	public int quantityDropped(Random par1Random)
	{
		return 1;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int var4 = 0; var4 < 7; ++var4)
		{
			par3List.add(new ItemStack(par1, 1, var4));
		}
	}
}
