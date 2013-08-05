package pp_t_addon;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenGraveyard extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks()
	{
		return new int[] { Block.dirt.blockID, Block.grass.blockID, Block.stone.blockID };
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

	public WorldGenGraveyard()
	{
	}

	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		//check that each corner is one of the valid spawn blocks
		if (!LocationIsValidSpawn(world, x, y, z) || !LocationIsValidSpawn(world, x + 11, y, z) || !LocationIsValidSpawn(world, x + 11, y, z + 10) || !LocationIsValidSpawn(world, x, y, z + 10))
		{
			return false;
		}
		if (y < 55 || y > 80)
		{
			return false;
		}

		world.setBlock(x + 0, y + 0, z + 0, Block.grass.blockID);
		world.setBlock(x + 0, y + 0, z + 1, Block.grass.blockID);
		world.setBlock(x + 0, y + 0, z + 2, Block.grass.blockID);
		world.setBlock(x + 0, y + 0, z + 3, Block.grass.blockID);
		world.setBlock(x + 0, y + 0, z + 4, Block.grass.blockID);
		world.setBlock(x + 0, y + 0, z + 6, Block.grass.blockID);
		world.setBlock(x + 0, y + 0, z + 7, Block.grass.blockID);
		world.setBlock(x + 0, y + 0, z + 8, Block.grass.blockID);
		world.setBlock(x + 0, y + 0, z + 9, Block.grass.blockID);
		world.setBlock(x + 0, y + 0, z + 10, Block.grass.blockID);
		world.setBlock(x + 0, y + 1, z + 0, Block.fenceIron.blockID);
		world.setBlock(x + 0, y + 1, z + 1, Block.fenceIron.blockID);
		world.setBlock(x + 0, y + 1, z + 2, Block.fenceIron.blockID);
		world.setBlock(x + 0, y + 1, z + 3, Block.fenceIron.blockID);
		world.setBlock(x + 0, y + 1, z + 4, Block.fenceIron.blockID);
		world.setBlock(x + 0, y + 1, z + 5, 0);
		world.setBlock(x + 0, y + 1, z + 6, Block.fenceIron.blockID);
		world.setBlock(x + 0, y + 1, z + 7, Block.fenceIron.blockID);
		world.setBlock(x + 0, y + 1, z + 8, Block.fenceIron.blockID);
		world.setBlock(x + 0, y + 1, z + 9, Block.fenceIron.blockID);
		world.setBlock(x + 0, y + 1, z + 10, Block.fenceIron.blockID);
		world.setBlock(x + 1, y + 0, z + 0, Block.grass.blockID);
		world.setBlock(x + 1, y + 0, z + 1, Block.grass.blockID);
		world.setBlock(x + 1, y + 0, z + 2, Block.grass.blockID);
		world.setBlock(x + 1, y + 0, z + 3, Block.grass.blockID);
		world.setBlock(x + 1, y + 0, z + 4, Block.grass.blockID);
		world.setBlock(x + 1, y + 0, z + 6, Block.grass.blockID);
		world.setBlock(x + 1, y + 0, z + 7, Block.grass.blockID);
		world.setBlock(x + 1, y + 0, z + 8, Block.grass.blockID);
		world.setBlock(x + 1, y + 0, z + 9, Block.grass.blockID);
		world.setBlock(x + 1, y + 0, z + 10, Block.grass.blockID);
		world.setBlock(x + 1, y + 1, z + 0, Block.fenceIron.blockID);
		world.setBlock(x + 1, y + 1, z + 1, 0);
		world.setBlock(x + 1, y + 1, z + 2, 0);
		world.setBlock(x + 1, y + 1, z + 3, 0);
		world.setBlock(x + 1, y + 1, z + 4, 0);
		world.setBlock(x + 1, y + 1, z + 5, 0);
		world.setBlock(x + 1, y + 1, z + 6, 0);
		world.setBlock(x + 1, y + 1, z + 7, 0);
		world.setBlock(x + 1, y + 1, z + 8, 0);
		world.setBlock(x + 1, y + 1, z + 9, 0);
		world.setBlock(x + 1, y + 1, z + 10, Block.fenceIron.blockID);
		world.setBlock(x + 2, y + 0, z + 0, Block.grass.blockID);
		world.setBlock(x + 2, y + 0, z + 1, Block.grass.blockID);
		world.setBlock(x + 2, y + 0, z + 2, 0);
		world.setBlock(x + 2, y + 0, z + 3, 0);
		world.setBlock(x + 2, y + 0, z + 4, Block.grass.blockID);
		world.setBlock(x + 2, y + 0, z + 6, Block.grass.blockID);
		world.setBlock(x + 2, y + 0, z + 7, 0);
		world.setBlock(x + 2, y + 0, z + 8, 0);
		world.setBlock(x + 2, y + 0, z + 9, Block.grass.blockID);
		world.setBlock(x + 2, y + 0, z + 10, Block.grass.blockID);
		world.setBlock(x + 2, y + 1, z + 0, Block.fenceIron.blockID);
		world.setBlock(x + 2, y + 1, z + 1, 0);
		world.setBlock(x + 2, y + 1, z + 2, Block.stoneSingleSlab.blockID);
		world.setBlock(x + 2, y + 1, z + 3, Block.stoneSingleSlab.blockID);

		if (rand.nextInt(7) == 0)
			world.setBlock(x + 2, y, z + 2, PeacefulPackThaumcraftAddon.grave.blockID);

		world.setBlock(x + 2, y + 1, z + 4, 0);
		world.setBlock(x + 2, y + 1, z + 5, 0);
		world.setBlock(x + 2, y + 1, z + 6, 0);
		world.setBlock(x + 2, y + 1, z + 7, Block.stoneSingleSlab.blockID);
		world.setBlock(x + 2, y + 1, z + 8, Block.stoneSingleSlab.blockID);

		if (rand.nextInt(7) == 0)
			world.setBlock(x + 2, y, z + 8, PeacefulPackThaumcraftAddon.grave.blockID);
		world.setBlock(x + 2, y + 1, z + 9, 0);

		world.setBlock(x + 2, y + 1, z + 10, Block.fenceIron.blockID);
		world.setBlock(x + 3, y + 0, z + 0, Block.grass.blockID);
		world.setBlock(x + 3, y + 0, z + 1, Block.grass.blockID);
		world.setBlock(x + 3, y + 0, z + 2, Block.grass.blockID);
		world.setBlock(x + 3, y + 0, z + 3, Block.grass.blockID);
		world.setBlock(x + 3, y + 0, z + 4, Block.grass.blockID);
		world.setBlock(x + 3, y + 0, z + 6, Block.grass.blockID);
		world.setBlock(x + 3, y + 0, z + 7, Block.grass.blockID);
		world.setBlock(x + 3, y + 0, z + 8, Block.grass.blockID);
		world.setBlock(x + 3, y + 0, z + 9, Block.grass.blockID);
		world.setBlock(x + 3, y + 0, z + 10, Block.grass.blockID);
		world.setBlock(x + 3, y + 1, z + 0, Block.fenceIron.blockID);
		world.setBlock(x + 3, y + 1, z + 1, 0);
		world.setBlock(x + 3, y + 1, z + 2, 0);
		world.setBlock(x + 3, y + 1, z + 3, 0);
		world.setBlock(x + 3, y + 1, z + 4, 0);
		world.setBlock(x + 3, y + 1, z + 5, 0);
		world.setBlock(x + 3, y + 1, z + 6, 0);
		world.setBlock(x + 3, y + 1, z + 7, 0);
		world.setBlock(x + 3, y + 1, z + 8, 0);
		world.setBlock(x + 3, y + 1, z + 9, 0);
		if (rand.nextInt(2) == 0)
			world.setBlock(x + 3, y + 1, z + 5, Block.web.blockID);
		world.setBlock(x + 3, y + 1, z + 10, Block.fenceIron.blockID);
		world.setBlock(x + 4, y + 0, z + 0, Block.grass.blockID);
		world.setBlock(x + 4, y + 0, z + 1, Block.grass.blockID);
		world.setBlock(x + 4, y + 0, z + 2, Block.grass.blockID);
		world.setBlock(x + 4, y + 0, z + 3, Block.grass.blockID);
		world.setBlock(x + 4, y + 0, z + 4, Block.grass.blockID);
		world.setBlock(x + 4, y + 0, z + 6, Block.grass.blockID);
		world.setBlock(x + 4, y + 0, z + 7, Block.grass.blockID);
		world.setBlock(x + 4, y + 0, z + 8, Block.grass.blockID);
		world.setBlock(x + 4, y + 0, z + 9, Block.grass.blockID);
		world.setBlock(x + 4, y + 0, z + 10, Block.grass.blockID);
		world.setBlock(x + 4, y + 1, z + 0, Block.fenceIron.blockID);
		world.setBlock(x + 4, y + 1, z + 1, 0);
		world.setBlock(x + 4, y + 1, z + 2, 0);
		world.setBlock(x + 4, y + 1, z + 3, 0);
		world.setBlock(x + 4, y + 1, z + 4, 0);
		world.setBlock(x + 4, y + 1, z + 5, 0);
		world.setBlock(x + 4, y + 1, z + 6, 0);
		world.setBlock(x + 4, y + 1, z + 7, 0);
		world.setBlock(x + 4, y + 1, z + 8, 0);
		world.setBlock(x + 4, y + 1, z + 9, 0);
		world.setBlock(x + 4, y + 1, z + 10, Block.fenceIron.blockID);
		world.setBlock(x + 5, y + 0, z + 0, Block.grass.blockID);
		world.setBlock(x + 5, y + 0, z + 1, Block.grass.blockID);
		world.setBlock(x + 5, y + 0, z + 2, 0);
		world.setBlock(x + 5, y + 0, z + 3, 0);
		world.setBlock(x + 5, y + 0, z + 4, Block.grass.blockID);
		world.setBlock(x + 5, y + 0, z + 6, Block.grass.blockID);
		world.setBlock(x + 5, y + 0, z + 7, 0);
		world.setBlock(x + 5, y + 0, z + 8, 0);
		world.setBlock(x + 5, y + 0, z + 9, Block.grass.blockID);
		world.setBlock(x + 5, y + 0, z + 10, Block.grass.blockID);
		world.setBlock(x + 5, y + 1, z + 0, Block.fenceIron.blockID);
		world.setBlock(x + 5, y + 1, z + 1, 0);
		world.setBlock(x + 5, y + 1, z + 2, Block.stoneSingleSlab.blockID);
		world.setBlock(x + 5, y + 1, z + 3, Block.stoneSingleSlab.blockID);

		if (rand.nextInt(7) == 0)
			world.setBlock(x + 5, y, z + 2, PeacefulPackThaumcraftAddon.grave.blockID);

		world.setBlock(x + 5, y + 1, z + 4, 0);
		world.setBlock(x + 5, y + 1, z + 5, 0);
		world.setBlock(x + 5, y + 1, z + 6, 0);
		world.setBlock(x + 5, y + 1, z + 7, Block.stoneSingleSlab.blockID);
		world.setBlock(x + 5, y + 1, z + 8, Block.stoneSingleSlab.blockID);

		if (rand.nextInt(7) == 0)
			world.setBlock(x + 5, y, z + 7, PeacefulPackThaumcraftAddon.grave.blockID);

		world.setBlock(x + 5, y + 1, z + 9, 0);
		world.setBlock(x + 5, y + 1, z + 10, Block.fenceIron.blockID);
		world.setBlock(x + 6, y + 0, z + 0, Block.grass.blockID);
		world.setBlock(x + 6, y + 0, z + 1, Block.grass.blockID);
		world.setBlock(x + 6, y + 0, z + 2, Block.grass.blockID);
		world.setBlock(x + 6, y + 0, z + 3, Block.grass.blockID);
		world.setBlock(x + 6, y + 0, z + 4, Block.grass.blockID);
		world.setBlock(x + 6, y + 0, z + 6, Block.grass.blockID);
		world.setBlock(x + 6, y + 0, z + 7, Block.grass.blockID);
		world.setBlock(x + 6, y + 0, z + 8, Block.grass.blockID);
		world.setBlock(x + 6, y + 0, z + 9, Block.grass.blockID);
		world.setBlock(x + 6, y + 0, z + 10, Block.grass.blockID);
		world.setBlock(x + 6, y + 1, z + 0, Block.fenceIron.blockID);
		world.setBlock(x + 6, y + 1, z + 1, 0);
		world.setBlock(x + 6, y + 1, z + 2, 0);
		world.setBlock(x + 6, y + 1, z + 3, 0);
		world.setBlock(x + 6, y + 1, z + 4, 0);
		world.setBlock(x + 6, y + 1, z + 5, 0);
		world.setBlock(x + 6, y + 1, z + 6, 0);
		world.setBlock(x + 6, y + 1, z + 7, 0);
		world.setBlock(x + 6, y + 1, z + 8, 0);
		world.setBlock(x + 6, y + 1, z + 9, 0);
		world.setBlock(x + 6, y + 1, z + 10, Block.fenceIron.blockID);
		world.setBlock(x + 7, y + 0, z + 0, Block.grass.blockID);
		world.setBlock(x + 7, y + 0, z + 1, Block.grass.blockID);
		world.setBlock(x + 7, y + 0, z + 2, Block.grass.blockID);
		world.setBlock(x + 7, y + 0, z + 3, Block.grass.blockID);
		world.setBlock(x + 7, y + 0, z + 4, Block.grass.blockID);
		world.setBlock(x + 7, y + 0, z + 6, Block.grass.blockID);
		world.setBlock(x + 7, y + 0, z + 7, Block.grass.blockID);
		world.setBlock(x + 7, y + 0, z + 8, Block.grass.blockID);
		world.setBlock(x + 7, y + 0, z + 9, Block.grass.blockID);
		world.setBlock(x + 7, y + 0, z + 10, Block.grass.blockID);
		world.setBlock(x + 7, y + 1, z + 0, Block.fenceIron.blockID);
		world.setBlock(x + 7, y + 1, z + 1, 0);
		world.setBlock(x + 7, y + 1, z + 2, 0);
		world.setBlock(x + 7, y + 1, z + 3, 0);
		world.setBlock(x + 7, y + 1, z + 4, 0);
		world.setBlock(x + 7, y + 1, z + 5, 0);
		world.setBlock(x + 7, y + 1, z + 6, 0);
		world.setBlock(x + 7, y + 1, z + 7, 0);
		world.setBlock(x + 7, y + 1, z + 8, 0);
		world.setBlock(x + 7, y + 1, z + 9, 0);
		world.setBlock(x + 7, y + 1, z + 10, Block.fenceIron.blockID);
		if (rand.nextInt(2) == 0)
			world.setBlock(x + 6, y + 1, z + 10, Block.web.blockID);
		world.setBlock(x + 8, y + 0, z + 0, Block.grass.blockID);
		world.setBlock(x + 8, y + 0, z + 1, Block.grass.blockID);
		world.setBlock(x + 8, y + 0, z + 2, 0);
		world.setBlock(x + 8, y + 0, z + 3, 0);
		world.setBlock(x + 8, y + 0, z + 4, Block.grass.blockID);
		world.setBlock(x + 8, y + 0, z + 6, Block.grass.blockID);
		world.setBlock(x + 8, y + 0, z + 7, 0);
		world.setBlock(x + 8, y + 0, z + 8, 0);
		world.setBlock(x + 8, y + 0, z + 9, Block.grass.blockID);
		world.setBlock(x + 8, y + 0, z + 10, Block.grass.blockID);
		world.setBlock(x + 8, y + 1, z + 0, Block.fenceIron.blockID);
		world.setBlock(x + 8, y + 1, z + 1, 0);
		world.setBlock(x + 8, y + 1, z + 2, Block.stoneSingleSlab.blockID);
		world.setBlock(x + 8, y + 1, z + 3, Block.stoneSingleSlab.blockID);

		if (rand.nextInt(7) == 0)
			world.setBlock(x + 8, y, z + 2, PeacefulPackThaumcraftAddon.grave.blockID);

		world.setBlock(x + 8, y + 1, z + 4, 0);
		world.setBlock(x + 8, y + 1, z + 5, 0);
		world.setBlock(x + 8, y + 1, z + 6, 0);
		world.setBlock(x + 8, y + 1, z + 7, Block.stoneSingleSlab.blockID);
		world.setBlock(x + 8, y + 1, z + 8, Block.stoneSingleSlab.blockID);

		if (rand.nextInt(7) == 0)
			world.setBlock(x + 8, y, z + 8, PeacefulPackThaumcraftAddon.grave.blockID);

		world.setBlock(x + 8, y + 1, z + 9, 0);
		world.setBlock(x + 8, y + 1, z + 10, Block.fenceIron.blockID);
		world.setBlock(x + 9, y + 0, z + 0, Block.grass.blockID);
		world.setBlock(x + 9, y + 0, z + 1, Block.grass.blockID);
		world.setBlock(x + 9, y + 0, z + 2, Block.grass.blockID);
		world.setBlock(x + 9, y + 0, z + 3, Block.grass.blockID);
		world.setBlock(x + 9, y + 0, z + 4, Block.grass.blockID);
		world.setBlock(x + 9, y + 0, z + 6, Block.grass.blockID);
		world.setBlock(x + 9, y + 0, z + 7, Block.grass.blockID);
		world.setBlock(x + 9, y + 0, z + 8, Block.grass.blockID);
		world.setBlock(x + 9, y + 0, z + 9, Block.grass.blockID);
		world.setBlock(x + 9, y + 0, z + 10, Block.grass.blockID);
		world.setBlock(x + 9, y + 1, z + 0, Block.fenceIron.blockID);
		world.setBlock(x + 9, y + 1, z + 1, 0);
		world.setBlock(x + 9, y + 1, z + 2, 0);
		world.setBlock(x + 9, y + 1, z + 3, 0);
		world.setBlock(x + 9, y + 1, z + 4, 0);
		world.setBlock(x + 9, y + 1, z + 5, 0);
		world.setBlock(x + 9, y + 1, z + 6, 0);
		world.setBlock(x + 9, y + 1, z + 7, 0);
		world.setBlock(x + 9, y + 1, z + 8, 0);
		world.setBlock(x + 9, y + 1, z + 9, 0);
		world.setBlock(x + 9, y + 1, z + 10, Block.fenceIron.blockID);
		world.setBlock(x + 10, y + 0, z + 0, Block.grass.blockID);
		world.setBlock(x + 10, y + 0, z + 1, Block.grass.blockID);
		if (rand.nextInt(2) == 0)
			world.setBlock(x + 10, y + 1, z + 6, Block.web.blockID);
		world.setBlock(x + 10, y + 0, z + 2, Block.grass.blockID);
		world.setBlock(x + 10, y + 0, z + 3, Block.grass.blockID);
		world.setBlock(x + 10, y + 0, z + 4, Block.grass.blockID);
		world.setBlock(x + 10, y + 0, z + 6, Block.grass.blockID);
		world.setBlock(x + 10, y + 0, z + 7, Block.grass.blockID);
		world.setBlock(x + 10, y + 0, z + 8, Block.grass.blockID);
		world.setBlock(x + 10, y + 0, z + 9, Block.grass.blockID);
		world.setBlock(x + 10, y + 0, z + 10, Block.grass.blockID);
		world.setBlock(x + 10, y + 1, z + 0, Block.fenceIron.blockID);
		world.setBlock(x + 10, y + 1, z + 1, Block.fenceIron.blockID);
		world.setBlock(x + 10, y + 1, z + 2, Block.fenceIron.blockID);
		world.setBlock(x + 10, y + 1, z + 3, Block.fenceIron.blockID);
		world.setBlock(x + 10, y + 1, z + 4, Block.fenceIron.blockID);
		world.setBlock(x + 10, y + 1, z + 5, 0);
		world.setBlock(x + 10, y + 1, z + 6, Block.fenceIron.blockID);
		world.setBlock(x + 10, y + 1, z + 7, Block.fenceIron.blockID);
		world.setBlock(x + 10, y + 1, z + 8, Block.fenceIron.blockID);
		world.setBlock(x + 10, y + 1, z + 9, Block.fenceIron.blockID);
		world.setBlock(x + 10, y + 1, z + 10, Block.fenceIron.blockID);
		world.setBlock(x + 11, y + 0, z + 0, Block.grass.blockID);
		world.setBlock(x + 11, y + 0, z + 1, Block.grass.blockID);
		world.setBlock(x + 11, y + 0, z + 2, Block.grass.blockID);
		world.setBlock(x + 11, y + 0, z + 3, Block.grass.blockID);
		world.setBlock(x + 11, y + 0, z + 4, Block.grass.blockID);
		world.setBlock(x + 11, y + 0, z + 5, Block.grass.blockID);
		world.setBlock(x + 11, y + 0, z + 6, Block.grass.blockID);
		world.setBlock(x + 11, y + 0, z + 7, Block.grass.blockID);
		world.setBlock(x + 11, y + 0, z + 8, Block.grass.blockID);
		world.setBlock(x + 11, y + 0, z + 9, Block.grass.blockID);
		world.setBlock(x + 11, y + 0, z + 10, Block.grass.blockID);
		world.setBlock(x + 11, y + 1, z + 0, 0);
		world.setBlock(x + 11, y + 1, z + 1, 0);
		world.setBlock(x + 11, y + 1, z + 3, 0);
		world.setBlock(x + 11, y + 1, z + 4, 0);
		world.setBlock(x + 11, y + 1, z + 6, 0);
		world.setBlock(x + 11, y + 1, z + 7, 0);
		world.setBlock(x + 0, y + 0, z + 5, Block.gravel.blockID);
		if (rand.nextInt(2) == 0)
			world.setBlock(x, y + 1, z + 5, Block.web.blockID);
		world.setBlock(x + 1, y + 0, z + 5, Block.gravel.blockID);
		world.setBlock(x + 2, y + 0, z + 5, Block.gravel.blockID);
		world.setBlock(x + 3, y + 0, z + 5, Block.gravel.blockID);
		world.setBlock(x + 4, y + 0, z + 5, Block.gravel.blockID);
		world.setBlock(x + 5, y + 0, z + 5, Block.gravel.blockID);
		world.setBlock(x + 6, y + 0, z + 5, Block.gravel.blockID);

		if (rand.nextInt(2) == 0)
			world.setBlock(x + 6, y + 1, z + 5, Block.web.blockID);

		world.setBlock(x + 7, y + 0, z + 5, Block.gravel.blockID);
		world.setBlock(x + 8, y + 0, z + 5, Block.gravel.blockID);
		world.setBlock(x + 9, y + 0, z + 5, Block.gravel.blockID);
		world.setBlock(x + 10, y + 0, z + 5, Block.gravel.blockID);

		return true;
	}
}