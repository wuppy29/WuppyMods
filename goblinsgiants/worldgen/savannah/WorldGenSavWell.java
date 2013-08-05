package goblinsgiants.worldgen.savannah;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSavWell extends WorldGenerator
{
	public WorldGenSavWell()
	{
	}

	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		if (world.getBlockId(x, y + 1, z) == 0 || world.getBlockId(x + 3, y + 1, z) == 0 || world.getBlockId(x, y + 1, z + 3) == 0 || world.getBlockId(x + 3, y + 1, z + 3) == 0)
		{
			return false;
		}
		if (world.getBlockId(x, y + 2, z) != 0 || world.getBlockId(x + 3, y + 2, z) != 0 || world.getBlockId(x, y + 2, z + 3) != 0 || world.getBlockId(x + 3, y + 2, z + 3) != 0)
		{
			return false;
		}

		world.setBlock(x + 0, y + 0, z + 0, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 0, y + 0, z + 1, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 0, y + 0, z + 2, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 0, y + 0, z + 3, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 0, y + 1, z + 0, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 0, y + 1, z + 1, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 0, y + 1, z + 2, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 0, y + 1, z + 3, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 0, y + 2, z + 0, Block.stoneSingleSlab.blockID, 1, 2);
		world.setBlock(x + 0, y + 2, z + 1, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 0, y + 2, z + 2, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 0, y + 2, z + 3, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 0, y + 3, z + 0, 0);
		world.setBlock(x + 0, y + 3, z + 1, 0);
		world.setBlock(x + 0, y + 3, z + 2, Block.fence.blockID);
		world.setBlock(x + 0, y + 3, z + 3, 0);
		world.setBlock(x + 0, y + 4, z + 0, 0);
		world.setBlock(x + 0, y + 4, z + 1, Block.stairsSandStone.blockID, 2, 2);
		world.setBlock(x + 0, y + 4, z + 2, Block.stoneDoubleSlab.blockID, 1, 2);
		world.setBlock(x + 0, y + 4, z + 3, Block.stairsSandStone.blockID, 3, 2);
		world.setBlock(x + 1, y + 0, z + 0, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 1, y + 0, z + 1, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 1, y + 0, z + 2, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 1, y + 0, z + 3, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 1, y + 1, z + 0, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 1, y + 1, z + 1, 0);
		world.setBlock(x + 1, y + 1, z + 2, 0);
		world.setBlock(x + 1, y + 1, z + 3, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 1, y + 2, z + 0, Block.stoneSingleSlab.blockID, 1, 2);
		world.setBlock(x + 1, y + 2, z + 1, 0);
		world.setBlock(x + 1, y + 2, z + 2, 0);
		world.setBlock(x + 1, y + 2, z + 3, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 1, y + 3, z + 0, 0);
		world.setBlock(x + 1, y + 3, z + 1, 0);
		world.setBlock(x + 1, y + 3, z + 2, 0);
		world.setBlock(x + 1, y + 3, z + 3, 0);
		world.setBlock(x + 1, y + 4, z + 0, 0);
		world.setBlock(x + 1, y + 4, z + 1, Block.stairsSandStone.blockID, 2, 2);
		world.setBlock(x + 1, y + 4, z + 2, Block.stoneDoubleSlab.blockID, 1, 2);
		world.setBlock(x + 1, y + 4, z + 3, Block.stairsSandStone.blockID, 3, 2);
		world.setBlock(x + 2, y + 0, z + 0, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 2, y + 0, z + 1, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 2, y + 0, z + 2, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 2, y + 0, z + 3, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 2, y + 1, z + 0, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 2, y + 1, z + 1, 0);
		world.setBlock(x + 2, y + 1, z + 2, 0);
		world.setBlock(x + 2, y + 1, z + 3, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 2, y + 2, z + 0, Block.stoneSingleSlab.blockID, 1, 2);
		world.setBlock(x + 2, y + 2, z + 1, 0);
		world.setBlock(x + 2, y + 2, z + 2, 0);
		world.setBlock(x + 2, y + 2, z + 3, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 2, y + 3, z + 0, 0);
		world.setBlock(x + 2, y + 3, z + 1, 0);
		world.setBlock(x + 2, y + 3, z + 2, 0);
		world.setBlock(x + 2, y + 3, z + 3, 0);
		world.setBlock(x + 2, y + 4, z + 0, 0);
		world.setBlock(x + 2, y + 4, z + 1, Block.stairsSandStone.blockID, 2, 2);
		world.setBlock(x + 2, y + 4, z + 2, Block.stoneDoubleSlab.blockID, 1, 2);
		world.setBlock(x + 2, y + 4, z + 3, Block.stairsSandStone.blockID, 3, 2);
		world.setBlock(x + 3, y + 0, z + 0, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 3, y + 0, z + 1, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 3, y + 0, z + 2, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 3, y + 0, z + 3, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 3, y + 1, z + 0, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 3, y + 1, z + 1, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 3, y + 1, z + 2, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 3, y + 1, z + 3, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 3, y + 2, z + 0, Block.stoneSingleSlab.blockID, 1, 2);
		world.setBlock(x + 3, y + 2, z + 1, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 3, y + 2, z + 2, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 3, y + 2, z + 3, Block.sandStone.blockID, 2, 2);
		world.setBlock(x + 3, y + 3, z + 0, 0);
		world.setBlock(x + 3, y + 3, z + 1, 0);
		world.setBlock(x + 3, y + 3, z + 2, Block.fence.blockID);
		world.setBlock(x + 3, y + 3, z + 3, 0);
		world.setBlock(x + 3, y + 4, z + 0, 0);
		world.setBlock(x + 3, y + 4, z + 1, Block.stairsSandStone.blockID, 2, 2);
		world.setBlock(x + 3, y + 4, z + 2, Block.stoneDoubleSlab.blockID, 1, 2);
		world.setBlock(x + 3, y + 4, z + 3, Block.stairsSandStone.blockID, 3, 2);

		return true;
	}
}