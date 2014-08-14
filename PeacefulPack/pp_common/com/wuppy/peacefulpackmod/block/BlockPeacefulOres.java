package com.wuppy.peacefulpackmod.block;

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
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

import com.wuppy.peacefulpackmod.PeacefulPack;
import com.wuppy.peacefulpackmod.item.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPeacefulOres extends Block
{
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public BlockPeacefulOres()
	{
		super(Material.rock);
		setStepSound(soundTypeStone);
		setHardness(3F);
		setResistance(1.0F);
		setBlockName("oreblock");
		setCreativeTab(PeacefulPack.ppBlocksTab);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return this.icons[par2];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		icons = new IIcon[5];

		for (int i = 0; i < icons.length; i++)
		{
			if (i == 0)
				icons[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":sulphur");
			if (i == 1)
				icons[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":niter");
			if (i == 2)
				icons[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":fossil 1");
			if (i == 3)
				icons[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":fossil 2");
			if (i == 4)
				icons[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":fossil 3");
		}
	}

	@Override
	public Item getItemDropped(int metadata, Random rand, int par3)
	{
		if (metadata == 0)
		{
			return ModItems.sulphDust;
		}
		if (metadata == 1)
		{
			return ModItems.niterDust;
		}
		else
			return Items.bone;
	}

	Random rand = new Random();

	@Override
	public int getExpDrop(IBlockAccess world, int metadata, int fortune)
	{
		return MathHelper.getRandomIntegerInRange(rand, 1, 3);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int var4 = 0; var4 < 5; ++var4)
		{
			par3List.add(new ItemStack(par1, 1, var4));
		}
	}
}
