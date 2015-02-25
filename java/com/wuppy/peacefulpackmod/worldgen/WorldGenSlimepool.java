package com.wuppy.peacefulpackmod.worldgen;

import com.wuppy.peacefulpackmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenSlimepool extends WorldGenerator
{
	public WorldGenSlimepool()
	{
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos)
	{
		if (pos.getY() > 45 || pos.getY() < 3)
		{
			return false;
		}

		Block block = ModBlocks.slimeSlab;
		if (world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ())).getBlock().getMaterial().isSolid() && rand.nextInt(4) == 1)
		{
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()), block.getDefaultState(), 2);
			if (world.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())).getBlock().getMaterial().isSolid())
			{
				world.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), block.getDefaultState(), 2);
			}
			if (world.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())).getBlock().getMaterial().isSolid())
			{
				world.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), block.getDefaultState(), 2);
			}
			if (world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)).getBlock().getMaterial().isSolid())
			{
				world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), block.getDefaultState(), 2);
			}
			if (world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)).getBlock().getMaterial().isSolid())
			{
				world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), block.getDefaultState(), 2);
			}
			if (world.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1)).getBlock().getMaterial().isSolid())
			{
				world.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1), block.getDefaultState(), 2);
			}
			if (world.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() - 1)).getBlock().getMaterial().isSolid())
			{
				world.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() - 1), block.getDefaultState(), 2);
			}
			if (world.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() + 1)).getBlock().getMaterial().isSolid())
			{
				world.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() + 1), block.getDefaultState(), 2);
			}
			if (world.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1)).getBlock().getMaterial().isSolid())
			{
				world.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1), block.getDefaultState(), 2);
			}
			if (world.getBlockState(new BlockPos(pos.getX() + 2, pos.getY(), pos.getZ())).getBlock().getMaterial().isSolid() && world.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())).getBlock() == block)
			{
				world.setBlockState(new BlockPos(pos.getX() + 2, pos.getY(), pos.getZ()), block.getDefaultState(), 2);
			}
			return true;
		} else
			return false;
	}
}
