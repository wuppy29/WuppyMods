package com.wuppy.peacefulpackmod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockBuriedRemains extends Block
{
	public BlockBuriedRemains()
	{
		super(Material.ground);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
		return Items.rotten_flesh;
	}
}
