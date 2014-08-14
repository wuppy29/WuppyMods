package com.wuppy.frozen.blocks;

import java.util.Random;

import net.minecraft.block.BlockObsidian;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockBoltObsidian extends BlockObsidian
{
	public BlockBoltObsidian()
	{
		super();
		setBlockName("obsidian");
		setBlockTextureName("obsidian");
		setCreativeTab((CreativeTabs) null);
		setHardness(50.0F);
		setResistance(2000.0F);
		setStepSound(soundTypePiston);
	}
	
	public void updateTick(World world, int x, int y, int z, Random rand)
    {
		world.setBlock(x, y, z, Blocks.obsidian);
    }
	
	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune)
	{
		return Item.getItemFromBlock(Blocks.obsidian);
	}
}