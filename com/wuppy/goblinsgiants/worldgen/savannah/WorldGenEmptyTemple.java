package com.wuppy.goblinsgiants.worldgen.savannah;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenEmptyTemple extends WorldGenerator
{
	protected Block[] GetValidSpawnBlocks()
	{
		return new Block[] { Blocks.sand, Blocks.sandstone };
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k)
	{
		int distanceToAir = 0;
		Block checkBlock = world.getBlock(i, j, k);

		while (checkBlock != Blocks.air)
		{
			distanceToAir++;
			checkBlock = world.getBlock(i, j + distanceToAir, k);
		}

		if (distanceToAir > 0)
		{
			return false;
		}
		j += distanceToAir - 1;

		Block block = world.getBlock(i, j, k);
		Block blockAbove = world.getBlock(i, j + 1, k);
		Block blockBelow = world.getBlock(i, j - 1, k);
		for (Block x : GetValidSpawnBlocks())
		{
			if (blockAbove != Blocks.air)
			{
				return false;
			}
			if (block == x)
			{
				return true;
			}
			else if (block == Blocks.snow && blockBelow == x)
			{
				return true;
			}
		}
		return false;
	}

	public WorldGenEmptyTemple()
	{
	}

	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		if (!LocationIsValidSpawn(world, x, y, z) || !LocationIsValidSpawn(world, x + 9, y, z) || !LocationIsValidSpawn(world, x + 9, y, z + 12) || !LocationIsValidSpawn(world, x, y, z + 12))
		{
			return false;
		}
		
		if(rand.nextInt(3) != 0)
		{
			return false;
		}

		world.setBlock(x + 0, y + 0, z + 2, Blocks.stonebrick, 2, 2);
		world.setBlock(x + 1, y + 0, z + 5, Blocks.stonebrick, 2, 2);
		world.setBlock(x + 2, y + 0, z + 3, Blocks.stonebrick);
		world.setBlock(x + 2, y + 0, z + 5, Blocks.stonebrick);
		world.setBlock(x + 2, y + 0, z + 7, Blocks.stonebrick);
		world.setBlock(x + 2, y + 0, z + 9, Blocks.stonebrick);
		world.setBlock(x + 2, y + 1, z + 4, Blocks.stonebrick, 1, 2);
		world.setBlock(x + 2, y + 1, z + 5, Blocks.stonebrick, 2, 2);
		world.setBlock(x + 2, y + 1, z + 7, Blocks.stonebrick);
		world.setBlock(x + 2, y + 1, z + 9, Blocks.stonebrick);
		world.setBlock(x + 2, y + 2, z + 5, Blocks.stonebrick);
		world.setBlock(x + 2, y + 2, z + 6, Blocks.stonebrick, 3, 2);
		world.setBlock(x + 2, y + 2, z + 7, Blocks.stonebrick, 1, 2);
		world.setBlock(x + 2, y + 2, z + 8, Blocks.stonebrick);
		world.setBlock(x + 2, y + 3, z + 3, Blocks.stonebrick, 1, 2);
		world.setBlock(x + 2, y + 3, z + 5, Blocks.stonebrick, 2, 2);
		world.setBlock(x + 2, y + 3, z + 6, Blocks.stonebrick);
		world.setBlock(x + 2, y + 3, z + 7, Blocks.stonebrick);
		world.setBlock(x + 3, y + 0, z + 3, Blocks.stonebrick);
		world.setBlock(x + 3, y + 0, z + 9, Blocks.stonebrick, 1, 2);
		world.setBlock(x + 3, y + 0, z + 12, Blocks.stonebrick, 1, 2);
		world.setBlock(x + 3, y + 1, z + 3, Blocks.stonebrick, 2, 2);
		world.setBlock(x + 3, y + 2, z + 3, Blocks.stonebrick);
		world.setBlock(x + 3, y + 2, z + 9, Blocks.stonebrick);
		world.setBlock(x + 3, y + 3, z + 3, Blocks.stonebrick);
		world.setBlock(x + 3, y + 3, z + 9, Blocks.stonebrick);
		world.setBlock(x + 3, y + 4, z + 4, Blocks.stone_slab, 5, 2);
		world.setBlock(x + 3, y + 4, z + 5, Blocks.brick_stairs);
		world.setBlock(x + 3, y + 4, z + 7, Blocks.brick_stairs);
		world.setBlock(x + 4, y + 0, z + 1, Blocks.stonebrick, 2, 2);
		world.setBlock(x + 4, y + 0, z + 9, Blocks.stonebrick);
		world.setBlock(x + 4, y + 1, z + 9, Blocks.stonebrick);
		world.setBlock(x + 4, y + 2, z + 3, Blocks.stonebrick, 2, 2);
		world.setBlock(x + 4, y + 2, z + 9, Blocks.stonebrick);
		world.setBlock(x + 4, y + 4, z + 4, Blocks.brick_stairs, 2, 2);
		world.setBlock(x + 4, y + 4, z + 5, Blocks.glass);
		world.setBlock(x + 4, y + 4, z + 7, Blocks.glass);
		world.setBlock(x + 4, y + 4, z + 8, Blocks.brick_stairs, 3, 2);
		world.setBlock(x + 5, y + 2, z + 3, Blocks.stonebrick, 3, 2);
		world.setBlock(x + 5, y + 2, z + 9, Blocks.stonebrick, 3, 2);
		world.setBlock(x + 5, y + 3, z + 3, Blocks.stonebrick);
		world.setBlock(x + 5, y + 3, z + 9, Blocks.stonebrick);
		world.setBlock(x + 5, y + 4, z + 5, Blocks.glass);
		world.setBlock(x + 5, y + 4, z + 6, Blocks.glowstone, 0, 2);
		world.setBlock(x + 5, y + 4, z + 7, Blocks.glass);
		world.setBlock(x + 5, y + 4, z + 8, Blocks.brick_stairs, 3, 2);
		world.setBlock(x + 6, y + 0, z + 9, Blocks.stonebrick);
		world.setBlock(x + 6, y + 1, z + 3, Blocks.stonebrick);
		world.setBlock(x + 6, y + 1, z + 9, Blocks.stonebrick);
		world.setBlock(x + 6, y + 2, z + 3, Blocks.stonebrick);
		world.setBlock(x + 6, y + 2, z + 9, Blocks.stonebrick, 1, 2);
		world.setBlock(x + 6, y + 3, z + 3, Blocks.stonebrick, 1, 2);
		world.setBlock(x + 6, y + 4, z + 4, Blocks.brick_stairs, 2, 2);
		world.setBlock(x + 6, y + 4, z + 6, Blocks.glass);
		world.setBlock(x + 6, y + 4, z + 7, Blocks.glass);
		world.setBlock(x + 7, y + 0, z + 0, Blocks.stonebrick, 2, 2);
		world.setBlock(x + 7, y + 0, z + 3, Blocks.stonebrick);
		world.setBlock(x + 7, y + 0, z + 9, Blocks.stonebrick, 1, 2);
		world.setBlock(x + 7, y + 0, z + 11, Blocks.stonebrick, 1, 2);
		world.setBlock(x + 7, y + 1, z + 3, Blocks.stonebrick);
		world.setBlock(x + 7, y + 3, z + 9, Blocks.stonebrick);
		world.setBlock(x + 7, y + 4, z + 4, Blocks.stone_slab, 5, 2);
		world.setBlock(x + 7, y + 4, z + 5, Blocks.brick_stairs, 1, 2);
		world.setBlock(x + 7, y + 4, z + 6, Blocks.brick_stairs, 1, 2);
		world.setBlock(x + 7, y + 4, z + 8, Blocks.stone_slab, 5, 2);
		world.setBlock(x + 8, y + 0, z + 3, Blocks.stonebrick, 2, 2);
		world.setBlock(x + 8, y + 0, z + 4, Blocks.stonebrick);
		world.setBlock(x + 8, y + 0, z + 7, Blocks.stonebrick, 1, 2);
		world.setBlock(x + 8, y + 0, z + 8, Blocks.stonebrick, 2, 2);
		world.setBlock(x + 8, y + 0, z + 9, Blocks.stonebrick);
		world.setBlock(x + 8, y + 1, z + 4, Blocks.stonebrick, 1, 2);
		world.setBlock(x + 8, y + 1, z + 9, Blocks.stonebrick);
		world.setBlock(x + 8, y + 2, z + 3, Blocks.stonebrick);
		world.setBlock(x + 8, y + 2, z + 4, Blocks.stonebrick, 1, 2);
		world.setBlock(x + 8, y + 2, z + 5, Blocks.stonebrick);
		world.setBlock(x + 8, y + 2, z + 6, Blocks.stonebrick, 3, 2);
		world.setBlock(x + 8, y + 2, z + 8, Blocks.stonebrick);
		world.setBlock(x + 8, y + 2, z + 9, Blocks.stonebrick, 2, 2);
		world.setBlock(x + 8, y + 3, z + 4, Blocks.stonebrick);
		world.setBlock(x + 8, y + 3, z + 5, Blocks.stonebrick, 2, 2);
		world.setBlock(x + 8, y + 3, z + 6, Blocks.stonebrick);
		world.setBlock(x + 8, y + 3, z + 8, Blocks.stonebrick);
		world.setBlock(x + 9, y + 0, z + 2, Blocks.stonebrick, 1, 2);

		return true;
	}
}