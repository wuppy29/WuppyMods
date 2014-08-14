package com.wuppy.slimedungeons.blocks;

import com.wuppy.slimedungeons.SlimeDungeon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSlimeCobble extends Block
{
	private String name = "slimecobble";
	
	public BlockSlimeCobble()
	{
		super(Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(soundTypeStone);
		setHardness(3F);
		setResistance(1.0F);
		setBlockName(SlimeDungeon.MODID + "_" + name);
		setBlockTextureName(SlimeDungeon.MODID + ":" + name);
	}
}