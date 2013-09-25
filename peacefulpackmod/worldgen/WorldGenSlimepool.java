package peacefulpackmod.worldgen;

import java.util.Random;

import peacefulpackmod.PeacefulPack;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSlimepool extends WorldGenerator
{
	public WorldGenSlimepool()
	{		
	}
	
	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		if (y > 45 || y < 1)
		{
			return false;
		}
		
		int block = PeacefulPack.slimeslab.blockID;
		
		if(world.getBlockMaterial(x, y, z).isSolid() == true && rand.nextInt(4) == 1)
		{
			world.setBlock(x, y, z, block);
			if(world.getBlockMaterial(x + 1, y, z). isSolid() == true)
			{
				world.setBlock(x+1, y, z, block);
			}
			if(world.getBlockMaterial(x - 1, y, z). isSolid() == true)
			{
				world.setBlock(x - 1, y, z, block);
			}
			if(world.getBlockMaterial(x, y, z + 1). isSolid() == true)
			{
				world.setBlock(x, y, z + 1, block);
			}
			if(world.getBlockMaterial(x, y, z - 1). isSolid() == true)
			{
				world.setBlock(x, y, z - 1, block);
			}
			if(world.getBlockMaterial(x + 1, y, z + 1). isSolid() == true)
			{
				world.setBlock(x + 1, y, z + 1, block);
			}
			if(world.getBlockMaterial(x + 1, y, z - 1). isSolid() == true)
			{
				world.setBlock(x+1, y, z - 1, block);
			}
			if(world.getBlockMaterial(x - 1, y, z + 1). isSolid() == true)
			{
				world.setBlock(x - 1, y, z + 1, block);
			}
			if(world.getBlockMaterial(x - 1, y, z - 1). isSolid() == true)
			{
				world.setBlock(x - 1, y, z - 1, block);
			}
			if(world.getBlockMaterial(x + 2, y, z).isSolid() == true && world.getBlockId(x + 1, y, z) == block)
			{
				world.setBlock(x + 2, y, z, block);
			}
			return true;
		}
		else 
			return false;
	}
}
