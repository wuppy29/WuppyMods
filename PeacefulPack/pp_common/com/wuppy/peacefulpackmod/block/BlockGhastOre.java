package com.wuppy.peacefulpackmod.block;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.wuppy.peacefulpackmod.PeacefulPack;
import com.wuppy.peacefulpackmod.config.Config;

public class BlockGhastOre extends Block
{
	public BlockGhastOre()
	{
		super(Material.rock);
		setCreativeTab(PeacefulPack.ppBlocksTab);
		setStepSound(soundTypeStone);
		setHardness(3F);
		setResistance(1.0F);
		setBlockName("ghastore");
		setBlockTextureName(PeacefulPack.modid + ":" + "ghastore");
	}

	boolean brokenByPlayer = false;
	boolean lavaAround = false;

	List<Block> surroundingBlocks;
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int l)
	{
		brokenByPlayer = true;
		surroundingBlocks = null;
		surroundingBlocks = Arrays.asList(world.getBlock(x + 1, y, z), world.getBlock(x - 1, y, z), world.getBlock(x, y, z + 1), world.getBlock(x, y, z - 1), world.getBlock(x, y + 1, z), world.getBlock(x, y - 1, z));

		for (Block i : surroundingBlocks)
		{
			if (i == Blocks.flowing_lava || i == Blocks.lava)
			{
				lavaAround = true;
				int var8 = 0;

				var8 = MathHelper.getRandomIntegerInRange(world.rand, 3, 7);

				this.dropXpOnBlockBreak(world, x, y, z, var8);
			}
		}
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> ret = super.getDrops(world, x, y, z, metadata, fortune);

		if (brokenByPlayer)
		{
			if(lavaAround || !Config.lavaForGhastOres)
			{
				int i = world.rand.nextInt(fortune);
				
				if(i < 1)
					i = 0;
				
				ret.add(new ItemStack(Items.ghast_tear, 1 + i));
			}
			else
				ret.add(new ItemStack(this));
		}

		return ret;
	}
}