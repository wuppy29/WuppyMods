package com.wuppy.peacefulpackmod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.wuppy.peacefulpackmod.PeacefulPack;

public class BlockEnderclam extends Block
{
	private final String name = "enderclam";
	
	public BlockEnderclam()
	{
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(PeacefulPack.modid + "_" + name);
		
		setStepSound(soundTypeStone);
		setLightLevel(0.8F);
		setHardness(3F);
		setResistance(1.0F);

		setCreativeTab(PeacefulPack.ppBlocksTab);
	}
	
	public String getName()
	{
		return name;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Items.ender_pearl;
	}
/*
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
	}*/
}