package com.wuppy.slimedungeons;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockSlimeBlock extends Block
{
	public BlockSlimeBlock()
	{
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return Items.slime_ball;
    }
	
    public int quantityDropped(Random par1Random)
    {
        return 2;
    }
}