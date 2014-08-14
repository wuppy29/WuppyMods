package com.wuppy.slimedungeons.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.wuppy.slimedungeons.SlimeDungeon;

public class BlockSlimeBlock extends Block
{
	private String name = "slimeblock";
	
	public BlockSlimeBlock()
	{
		super(Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(soundTypeStone);
		setHardness(3F);
		setResistance(1.0F);
		setBlockName(SlimeDungeon.MODID + "_" + name);
		setBlockTextureName(SlimeDungeon.MODID + ":" + name);
	}
	
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return Items.slime_ball;
    }
	
	@Override
    public int quantityDropped(Random par1Random)
    {
        return 2;
    }
}