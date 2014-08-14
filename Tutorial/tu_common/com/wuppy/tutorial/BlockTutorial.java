package com.wuppy.tutorial;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockTutorial extends Block
{
	public BlockTutorial()
	{
		super(Material.rock);
		setBlockName(Reference.MODID + "_" + "tutorialBlock");
		setBlockTextureName(Reference.MODID + ":" + "tutorialBlock");
		setCreativeTab(CreativeTabs.tabBlock);
	}
}