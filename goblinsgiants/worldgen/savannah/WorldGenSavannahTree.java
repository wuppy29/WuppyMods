package goblinsgiants.worldgen.savannah;


import goblinsgiants.GoblinGiant;

import java.util.Random;


import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSavannahTree extends WorldGenerator
{
	int height;
	int wood = GoblinGiant.customWood.blockID;
	int leaf = Block.leaves.blockID;

	public boolean generate(World world, Random random, int x, int y, int z)
	{
		if (world.rand.nextInt(10) == 0)
		{
			while (world.isAirBlock(x, y - 1, z) && y > 55)
			{
				--y;
			}
			if (!world.isAirBlock(x, y, z))
				return false;

			height = 2 + random.nextInt(5);

			for (int i = 0; i < height; i++)
			{
				world.setBlock(x, y + i, z, wood);
			}

			int top = 1 + random.nextInt(3);

			int left = 2 + random.nextInt(3);
			int right = 2 + random.nextInt(3);
			int front = 2 + random.nextInt(3);
			int back = 2 + random.nextInt(3);

			for (int i = 0; i < top; i++)
			{
				setBlock(world, x, y + i, z, wood);

				if (i > 0)
				{
					setBlock(world, x + 1, y + i, z, leaf);
					setBlock(world, x - 1, y + i, z, leaf);
					setBlock(world, x, y + i, z + 1, leaf);
					setBlock(world, x, y + i, z - 1, leaf);
					setBlock(world, x, y + i + 1, z, leaf);
				}
			}

			for (int i = 0; i < left; i++)
			{
				setBlock(world, x + i, y, z, wood);
				setBlock(world, x + i, y + 1, z, leaf);
				if (i > 0)
				{
					setBlock(world, x + i, y, z + 1, leaf);
					setBlock(world, x + i, y, z - 1, leaf);
				}
			}
			for (int i = 0; i < right; i++)
			{
				setBlock(world, x - i, y, z, wood);
				setBlock(world, x - i, y + 1, z, leaf);
				if (i > 0)
				{
					setBlock(world, x - i, y, z + 1, leaf);
					setBlock(world, x - i, y, z - 1, leaf);
				}
			}
			for (int i = 0; i < front; i++)
			{
				setBlock(world, x, y, z + i, wood);
				setBlock(world, x, y + 1, z + i, leaf);
				if (i > 0)
				{
					setBlock(world, x - 1, y, z + i, leaf);
					setBlock(world, x + 1, y, z + i, leaf);
				}
			}
			for (int i = 0; i < back; i++)
			{
				setBlock(world, x, y, z - i, wood);
				setBlock(world, x, y + 1, z - i, leaf);
				if (i > 0)
				{
					setBlock(world, x - 1, y, z - i, leaf);
					setBlock(world, x + 1, y, z - i, leaf);
				}
			}

			setBlock(world, x + left, y, z, leaf);
			setBlock(world, x - right, y, z, leaf);
			setBlock(world, x, y, z + front, leaf);
			setBlock(world, x, y, z - back, leaf);

			return true;
		}
		else
			return false;
	}

	public void setBlock(World world, int x, int y, int z, int blockid)
	{
		world.setBlock(x, y + height, z, blockid);
	}
}