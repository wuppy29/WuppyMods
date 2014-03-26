package com.wuppy.slimedungeons;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSlimeCobble extends Block
{
	public BlockSlimeCobble()
	{
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
}