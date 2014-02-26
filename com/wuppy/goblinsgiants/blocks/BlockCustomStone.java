package com.wuppy.goblinsgiants.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.wuppy.goblinsgiants.GoblinGiant;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCustomStone extends Block
{
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public BlockCustomStone()
	{
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHarvestLevel("pickaxe", 2);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		icons = new IIcon[18];

		for (int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(GoblinGiant.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
		}
	}

	public IIcon getIcon(int par1, int par2)
	{
		switch (par2)
		{
		case 0:
			if (par1 == 1)
				return icons[0];
			if (par1 == 0)
				return icons[1];
			else
				return icons[2];
		case 1:
			if (par1 == 1)
				return icons[3];
			if (par1 == 0)
				return icons[4];
			else
				return icons[5];
		case 2:
			if (par1 == 1)
				return icons[6];
			if (par1 == 0)
				return icons[7];
			else
				return icons[8];
		case 3:
			if (par1 == 1)
				return icons[9];
			if (par1 == 0)
				return icons[10];
			else
				return icons[11];
		case 4:
			if (par1 == 1)
				return icons[12];
			if (par1 == 0)
				return icons[13];
			else
				return icons[14];
		case 5:
			if (par1 == 1)
				return icons[15];
			if (par1 == 0)
				return icons[16];
			else
				return icons[17];
		default:
			return icons[0];
		}
	}

	public Item getItemDropped(int par1, Random rand_, int par3)
	{
		switch(par1)
		{
		case 0:
			return Item.getItemFromBlock(this);
		case 1:
			return Item.getItemFromBlock(this);
		case 2: 
			return Items.coal;
		case 3:
			return Items.diamond;
		case 4:
			return Items.redstone;
		case 5:
			return Items.dye;
		default:
			return null;
		}
	}
	
	public int damageDropped(int par1)
	{
		if(par1 == 0)
			return 0;
		if(par1 == 1)
			return 1;
	    if(par1 == 5)
	    	return 4;
	    else
		return par1;
	}
	
	public int quantityDropped(int par1, int par2, Random rand)
	{
		switch(par1)
		{
		case 4:
			return 1 + rand.nextInt(4);
		case 5:
			return 1 + rand.nextInt(4);
		default:
				return 1;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int var4 = 0; var4 < 6; ++var4)
		{
			par3List.add(new ItemStack(par1, 1, var4));
		}
	}
}
