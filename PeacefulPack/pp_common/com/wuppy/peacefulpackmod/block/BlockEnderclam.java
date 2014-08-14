package com.wuppy.peacefulpackmod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.wuppy.peacefulpackmod.PeacefulPack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEnderclam extends Block
{
	public BlockEnderclam()
	{
		super(Material.rock);
		setStepSound(soundTypeStone);
		setLightLevel(0.8F);
		setHardness(3F);
		setResistance(1.0F);
		setBlockName("enderclam");
		setCreativeTab(PeacefulPack.ppBlocksTab);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		return Items.ender_pearl;
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		iconArray = new IIcon[4];
		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
		}
	}

	@Override
	public IIcon getIcon(int par1, int par2)
	{
		if (par1 == 0)
			return iconArray[0];
		else if (par1 == 1)
			return iconArray[3];
		else if (par1 == 2 || par1 == 3)
			return iconArray[1];
		else
			return iconArray[2];
	}

	@Override
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
	{
		super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);

		int var8 = 0;
		var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
		this.dropXpOnBlockBreak(par1World, par2, par3, par4, var8);
	}
}
