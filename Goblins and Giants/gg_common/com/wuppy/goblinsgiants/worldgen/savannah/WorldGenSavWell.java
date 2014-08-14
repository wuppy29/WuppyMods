package com.wuppy.goblinsgiants.worldgen.savannah;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSavWell extends WorldGenerator
{
	public WorldGenSavWell()
	{
	}

	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		if (world.getBlock(x, y + 1, z) == Blocks.air || world.getBlock(x + 3, y + 1, z) == Blocks.air || world.getBlock(x, y + 1, z + 3) == Blocks.air || world.getBlock(x + 3, y + 1, z + 3) == Blocks.air)
		{
			return false;
		}
		if (world.getBlock(x, y + 2, z) != Blocks.air || world.getBlock(x + 3, y + 2, z) != Blocks.air || world.getBlock(x, y + 2, z + 3) != Blocks.air || world.getBlock(x + 3, y + 2, z + 3) != Blocks.air)
		{
			return false;
		}

		world.setBlock(x + 0, y + 0, z + 0, Blocks.sandstone, 2, 2);
		world.setBlock(x + 0, y + 0, z + 1, Blocks.sandstone, 2, 2);
		world.setBlock(x + 0, y + 0, z + 2, Blocks.sandstone, 2, 2);
		world.setBlock(x + 0, y + 0, z + 3, Blocks.sandstone, 2, 2);
		world.setBlock(x + 0, y + 1, z + 0, Blocks.sandstone, 2, 2);
		world.setBlock(x + 0, y + 1, z + 1, Blocks.sandstone, 2, 2);
		world.setBlock(x + 0, y + 1, z + 2, Blocks.sandstone, 2, 2);
		world.setBlock(x + 0, y + 1, z + 3, Blocks.sandstone, 2, 2);
		world.setBlock(x + 0, y + 2, z + 0, Blocks.stone_slab, 1, 2);
		world.setBlock(x + 0, y + 2, z + 1, Blocks.sandstone, 2, 2);
		world.setBlock(x + 0, y + 2, z + 2, Blocks.sandstone, 2, 2);
		world.setBlock(x + 0, y + 2, z + 3, Blocks.sandstone, 2, 2);
		world.setBlock(x + 0, y + 3, z + 0, Blocks.air);
		world.setBlock(x + 0, y + 3, z + 1, Blocks.air);
		world.setBlock(x + 0, y + 3, z + 2, Blocks.fence);
		world.setBlock(x + 0, y + 3, z + 3, Blocks.air);
		world.setBlock(x + 0, y + 4, z + 0, Blocks.air);
		world.setBlock(x + 0, y + 4, z + 1, Blocks.sandstone_stairs, 2, 2);
		world.setBlock(x + 0, y + 4, z + 2, Blocks.double_stone_slab, 1, 2);
		world.setBlock(x + 0, y + 4, z + 3, Blocks.sandstone_stairs, 3, 2);
		world.setBlock(x + 1, y + 0, z + 0, Blocks.sandstone, 2, 2);
		world.setBlock(x + 1, y + 0, z + 1, Blocks.sandstone, 2, 2);
		world.setBlock(x + 1, y + 0, z + 2, Blocks.sandstone, 2, 2);
		world.setBlock(x + 1, y + 0, z + 3, Blocks.sandstone, 2, 2);
		world.setBlock(x + 1, y + 1, z + 0, Blocks.sandstone, 2, 2);
		world.setBlock(x + 1, y + 1, z + 1, Blocks.air);
		world.setBlock(x + 1, y + 1, z + 2, Blocks.air);
		world.setBlock(x + 1, y + 1, z + 3, Blocks.sandstone, 2, 2);
		world.setBlock(x + 1, y + 2, z + 0, Blocks.stone_slab, 1, 2);
		world.setBlock(x + 1, y + 2, z + 1, Blocks.air);
		world.setBlock(x + 1, y + 2, z + 2, Blocks.air);
		world.setBlock(x + 1, y + 2, z + 3, Blocks.sandstone, 2, 2);
		world.setBlock(x + 1, y + 3, z + 0, Blocks.air);
		world.setBlock(x + 1, y + 3, z + 1, Blocks.air);
		world.setBlock(x + 1, y + 3, z + 2, Blocks.air);
		world.setBlock(x + 1, y + 3, z + 3, Blocks.air);
		world.setBlock(x + 1, y + 4, z + 0, Blocks.air);
		world.setBlock(x + 1, y + 4, z + 1, Blocks.sandstone_stairs, 2, 2);
		world.setBlock(x + 1, y + 4, z + 2, Blocks.double_stone_slab, 1, 2);
		world.setBlock(x + 1, y + 4, z + 3, Blocks.sandstone_stairs, 3, 2);
		world.setBlock(x + 2, y + 0, z + 0, Blocks.sandstone, 2, 2);
		world.setBlock(x + 2, y + 0, z + 1, Blocks.sandstone, 2, 2);
		world.setBlock(x + 2, y + 0, z + 2, Blocks.sandstone, 2, 2);
		world.setBlock(x + 2, y + 0, z + 3, Blocks.sandstone, 2, 2);
		world.setBlock(x + 2, y + 1, z + 0, Blocks.sandstone, 2, 2);
		world.setBlock(x + 2, y + 1, z + 1, Blocks.air);
		world.setBlock(x + 2, y + 1, z + 2, Blocks.air);
		world.setBlock(x + 2, y + 1, z + 3, Blocks.sandstone, 2, 2);
		world.setBlock(x + 2, y + 2, z + 0, Blocks.stone_slab, 1, 2);
		world.setBlock(x + 2, y + 2, z + 1, Blocks.air);
		world.setBlock(x + 2, y + 2, z + 2, Blocks.air);
		world.setBlock(x + 2, y + 2, z + 3, Blocks.sandstone, 2, 2);
		world.setBlock(x + 2, y + 3, z + 0, Blocks.air);
		world.setBlock(x + 2, y + 3, z + 1, Blocks.air);
		world.setBlock(x + 2, y + 3, z + 2, Blocks.air);
		world.setBlock(x + 2, y + 3, z + 3, Blocks.air);
		world.setBlock(x + 2, y + 4, z + 0, Blocks.air);
		world.setBlock(x + 2, y + 4, z + 1, Blocks.sandstone_stairs, 2, 2);
		world.setBlock(x + 2, y + 4, z + 2, Blocks.double_stone_slab, 1, 2);
		world.setBlock(x + 2, y + 4, z + 3, Blocks.sandstone_stairs, 3, 2);
		world.setBlock(x + 3, y + 0, z + 0, Blocks.sandstone, 2, 2);
		world.setBlock(x + 3, y + 0, z + 1, Blocks.sandstone, 2, 2);
		world.setBlock(x + 3, y + 0, z + 2, Blocks.sandstone, 2, 2);
		world.setBlock(x + 3, y + 0, z + 3, Blocks.sandstone, 2, 2);
		world.setBlock(x + 3, y + 1, z + 0, Blocks.sandstone, 2, 2);
		world.setBlock(x + 3, y + 1, z + 1, Blocks.sandstone, 2, 2);
		world.setBlock(x + 3, y + 1, z + 2, Blocks.sandstone, 2, 2);
		world.setBlock(x + 3, y + 1, z + 3, Blocks.sandstone, 2, 2);
		world.setBlock(x + 3, y + 2, z + 0, Blocks.stone_slab, 1, 2);
		world.setBlock(x + 3, y + 2, z + 1, Blocks.sandstone, 2, 2);
		world.setBlock(x + 3, y + 2, z + 2, Blocks.sandstone, 2, 2);
		world.setBlock(x + 3, y + 2, z + 3, Blocks.sandstone, 2, 2);
		world.setBlock(x + 3, y + 3, z + 0, Blocks.air);
		world.setBlock(x + 3, y + 3, z + 1, Blocks.air);
		world.setBlock(x + 3, y + 3, z + 2, Blocks.fence);
		world.setBlock(x + 3, y + 3, z + 3, Blocks.air);
		world.setBlock(x + 3, y + 4, z + 0, Blocks.air);
		world.setBlock(x + 3, y + 4, z + 1, Blocks.sandstone_stairs, 2, 2);
		world.setBlock(x + 3, y + 4, z + 2, Blocks.double_stone_slab, 1, 2);
		world.setBlock(x + 3, y + 4, z + 3, Blocks.sandstone_stairs, 3, 2);

		return true;
	}
}