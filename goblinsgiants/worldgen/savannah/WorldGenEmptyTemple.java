package goblinsgiants.worldgen.savannah;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenEmptyTemple extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks()
	{
		return new int[] { Block.sand.blockID, Block.sandStone.blockID };
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k)
	{
		int distanceToAir = 0;
		int checkID = world.getBlockId(i, j, k);

		while (checkID != 0)
		{
			distanceToAir++;
			checkID = world.getBlockId(i, j + distanceToAir, k);
		}

		if (distanceToAir > 0)
		{
			return false;
		}
		j += distanceToAir - 1;

		int blockID = world.getBlockId(i, j, k);
		int blockIDAbove = world.getBlockId(i, j + 1, k);
		int blockIDBelow = world.getBlockId(i, j - 1, k);
		for (int x : GetValidSpawnBlocks())
		{
			if (blockIDAbove != 0)
			{
				return false;
			}
			if (blockID == x)
			{
				return true;
			}
			else if (blockID == Block.snow.blockID && blockIDBelow == x)
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

		world.setBlock(x + 0, y + 0, z + 2, Block.stoneBrick.blockID, 2, 2);
		world.setBlock(x + 1, y + 0, z + 5, Block.stoneBrick.blockID, 2, 2);
		world.setBlock(x + 2, y + 0, z + 3, Block.stoneBrick.blockID);
		world.setBlock(x + 2, y + 0, z + 5, Block.stoneBrick.blockID);
		world.setBlock(x + 2, y + 0, z + 7, Block.stoneBrick.blockID);
		world.setBlock(x + 2, y + 0, z + 9, Block.stoneBrick.blockID);
		world.setBlock(x + 2, y + 1, z + 4, Block.stoneBrick.blockID, 1, 2);
		world.setBlock(x + 2, y + 1, z + 5, Block.stoneBrick.blockID, 2, 2);
		world.setBlock(x + 2, y + 1, z + 7, Block.stoneBrick.blockID);
		world.setBlock(x + 2, y + 1, z + 9, Block.stoneBrick.blockID);
		world.setBlock(x + 2, y + 2, z + 5, Block.stoneBrick.blockID);
		world.setBlock(x + 2, y + 2, z + 6, Block.stoneBrick.blockID, 3, 2);
		world.setBlock(x + 2, y + 2, z + 7, Block.stoneBrick.blockID, 1, 2);
		world.setBlock(x + 2, y + 2, z + 8, Block.stoneBrick.blockID);
		world.setBlock(x + 2, y + 3, z + 3, Block.stoneBrick.blockID, 1, 2);
		world.setBlock(x + 2, y + 3, z + 5, Block.stoneBrick.blockID, 2, 2);
		world.setBlock(x + 2, y + 3, z + 6, Block.stoneBrick.blockID);
		world.setBlock(x + 2, y + 3, z + 7, Block.stoneBrick.blockID);
		world.setBlock(x + 3, y + 0, z + 3, Block.stoneBrick.blockID);
		world.setBlock(x + 3, y + 0, z + 9, Block.stoneBrick.blockID, 1, 2);
		world.setBlock(x + 3, y + 0, z + 12, Block.stoneBrick.blockID, 1, 2);
		world.setBlock(x + 3, y + 1, z + 3, Block.stoneBrick.blockID, 2, 2);
		world.setBlock(x + 3, y + 2, z + 3, Block.stoneBrick.blockID);
		world.setBlock(x + 3, y + 2, z + 9, Block.stoneBrick.blockID);
		world.setBlock(x + 3, y + 3, z + 3, Block.stoneBrick.blockID);
		world.setBlock(x + 3, y + 3, z + 9, Block.stoneBrick.blockID);
		world.setBlock(x + 3, y + 4, z + 4, Block.stoneSingleSlab.blockID, 5, 2);
		world.setBlock(x + 3, y + 4, z + 5, Block.stairsStoneBrick.blockID);
		world.setBlock(x + 3, y + 4, z + 7, Block.stairsStoneBrick.blockID);
		world.setBlock(x + 4, y + 0, z + 1, Block.stoneBrick.blockID, 2, 2);
		world.setBlock(x + 4, y + 0, z + 9, Block.stoneBrick.blockID);
		world.setBlock(x + 4, y + 1, z + 9, Block.stoneBrick.blockID);
		world.setBlock(x + 4, y + 2, z + 3, Block.stoneBrick.blockID, 2, 2);
		world.setBlock(x + 4, y + 2, z + 9, Block.stoneBrick.blockID);
		world.setBlock(x + 4, y + 4, z + 4, Block.stairsStoneBrick.blockID, 2, 2);
		world.setBlock(x + 4, y + 4, z + 5, Block.glass.blockID);
		world.setBlock(x + 4, y + 4, z + 7, Block.glass.blockID);
		world.setBlock(x + 4, y + 4, z + 8, Block.stairsStoneBrick.blockID, 3, 2);
		world.setBlock(x + 5, y + 2, z + 3, Block.stoneBrick.blockID, 3, 2);
		world.setBlock(x + 5, y + 2, z + 9, Block.stoneBrick.blockID, 3, 2);
		world.setBlock(x + 5, y + 3, z + 3, Block.stoneBrick.blockID);
		world.setBlock(x + 5, y + 3, z + 9, Block.stoneBrick.blockID);
		world.setBlock(x + 5, y + 4, z + 5, Block.glass.blockID);
		world.setBlock(x + 5, y + 4, z + 6, Block.glowStone.blockID, 0, 2);
		world.setBlock(x + 5, y + 4, z + 7, Block.glass.blockID);
		world.setBlock(x + 5, y + 4, z + 8, Block.stairsStoneBrick.blockID, 3, 2);
		world.setBlock(x + 6, y + 0, z + 9, Block.stoneBrick.blockID);
		world.setBlock(x + 6, y + 1, z + 3, Block.stoneBrick.blockID);
		world.setBlock(x + 6, y + 1, z + 9, Block.stoneBrick.blockID);
		world.setBlock(x + 6, y + 2, z + 3, Block.stoneBrick.blockID);
		world.setBlock(x + 6, y + 2, z + 9, Block.stoneBrick.blockID, 1, 2);
		world.setBlock(x + 6, y + 3, z + 3, Block.stoneBrick.blockID, 1, 2);
		world.setBlock(x + 6, y + 4, z + 4, Block.stairsStoneBrick.blockID, 2, 2);
		world.setBlock(x + 6, y + 4, z + 6, Block.glass.blockID);
		world.setBlock(x + 6, y + 4, z + 7, Block.glass.blockID);
		world.setBlock(x + 7, y + 0, z + 0, Block.stoneBrick.blockID, 2, 2);
		world.setBlock(x + 7, y + 0, z + 3, Block.stoneBrick.blockID);
		world.setBlock(x + 7, y + 0, z + 9, Block.stoneBrick.blockID, 1, 2);
		world.setBlock(x + 7, y + 0, z + 11, Block.stoneBrick.blockID, 1, 2);
		world.setBlock(x + 7, y + 1, z + 3, Block.stoneBrick.blockID);
		world.setBlock(x + 7, y + 3, z + 9, Block.stoneBrick.blockID);
		world.setBlock(x + 7, y + 4, z + 4, Block.stoneSingleSlab.blockID, 5, 2);
		world.setBlock(x + 7, y + 4, z + 5, Block.stairsStoneBrick.blockID, 1, 2);
		world.setBlock(x + 7, y + 4, z + 6, Block.stairsStoneBrick.blockID, 1, 2);
		world.setBlock(x + 7, y + 4, z + 8, Block.stoneSingleSlab.blockID, 5, 2);
		world.setBlock(x + 8, y + 0, z + 3, Block.stoneBrick.blockID, 2, 2);
		world.setBlock(x + 8, y + 0, z + 4, Block.stoneBrick.blockID);
		world.setBlock(x + 8, y + 0, z + 7, Block.stoneBrick.blockID, 1, 2);
		world.setBlock(x + 8, y + 0, z + 8, Block.stoneBrick.blockID, 2, 2);
		world.setBlock(x + 8, y + 0, z + 9, Block.stoneBrick.blockID);
		world.setBlock(x + 8, y + 1, z + 4, Block.stoneBrick.blockID, 1, 2);
		world.setBlock(x + 8, y + 1, z + 9, Block.stoneBrick.blockID);
		world.setBlock(x + 8, y + 2, z + 3, Block.stoneBrick.blockID);
		world.setBlock(x + 8, y + 2, z + 4, Block.stoneBrick.blockID, 1, 2);
		world.setBlock(x + 8, y + 2, z + 5, Block.stoneBrick.blockID);
		world.setBlock(x + 8, y + 2, z + 6, Block.stoneBrick.blockID, 3, 2);
		world.setBlock(x + 8, y + 2, z + 8, Block.stoneBrick.blockID);
		world.setBlock(x + 8, y + 2, z + 9, Block.stoneBrick.blockID, 2, 2);
		world.setBlock(x + 8, y + 3, z + 4, Block.stoneBrick.blockID);
		world.setBlock(x + 8, y + 3, z + 5, Block.stoneBrick.blockID, 2, 2);
		world.setBlock(x + 8, y + 3, z + 6, Block.stoneBrick.blockID);
		world.setBlock(x + 8, y + 3, z + 8, Block.stoneBrick.blockID);
		world.setBlock(x + 9, y + 0, z + 2, Block.stoneBrick.blockID, 1, 2);

		return true;
	}
}