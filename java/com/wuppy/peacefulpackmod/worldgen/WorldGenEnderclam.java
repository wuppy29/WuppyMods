package com.wuppy.peacefulpackmod.worldgen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenEnderclam extends WorldGenerator
{
	private Block enderclam;

	public WorldGenEnderclam(Block par1)
	{
		enderclam = par1;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos)
	{
		if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).getBlock() == Blocks.sand || worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).getBlock() == Blocks.dirt || worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).getBlock() == Blocks.clay)
		{
			if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock() == Blocks.water || worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock() == Blocks.flowing_water)
			{
				worldIn.setBlockState(pos, enderclam.getDefaultState(), 2);
			}
		}
		return true;
	}
}