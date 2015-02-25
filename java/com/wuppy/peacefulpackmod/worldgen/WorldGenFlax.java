package com.wuppy.peacefulpackmod.worldgen;

import com.wuppy.peacefulpackmod.block.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenFlax extends WorldGenerator
{
	@Override
	public boolean generate(World par1World, Random par2Random, BlockPos pos)
	{
		for (int i = 0; i < 64; i++)
		{
			int x1 = (pos.getX() + par2Random.nextInt(6)) - par2Random.nextInt(6);
			int y1 = (pos.getY() + par2Random.nextInt(4)) - par2Random.nextInt(4);
			int z1 = (pos.getZ() + par2Random.nextInt(6)) - par2Random.nextInt(6);

			if (par1World.isAirBlock(new BlockPos(x1, y1, z1)) && par1World.getBlockState(new BlockPos(x1, y1 - 1, z1)).getBlock() == Blocks.grass)
			{
				par1World.setBlockState(new BlockPos(x1, y1, z1), ModBlocks.flax.getDefaultState(), 2);
			}
		}

		return true;
	}
}
