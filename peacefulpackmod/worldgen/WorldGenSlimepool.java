package peacefulpackmod.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import peacefulpackmod.PeacefulPack;

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
		
		Block block = PeacefulPack.slimeslab;
		if(world.func_147439_a(x, y, z).func_149688_o().isSolid() == true && rand.nextInt(4) == 1)
		{
			world.func_147465_d(x, y, z, block, 0, 2);
			if(world.func_147439_a(x + 1, y, z).func_149688_o().isSolid() == true)
			{
				world.func_147465_d(x+1, y, z, block, 0, 2);
			}
			if(world.func_147439_a(x - 1, y, z).func_149688_o().isSolid() == true)
			{
				world.func_147465_d(x - 1, y, z, block, 0, 2);
			}
			if(world.func_147439_a(x, y, z + 1).func_149688_o().isSolid() == true)
			{
				world.func_147465_d(x, y, z + 1, block, 0, 2);
			}
			if(world.func_147439_a(x, y, z - 1).func_149688_o().isSolid() == true)
			{
				world.func_147465_d(x, y, z - 1, block, 0, 2);
			}
			if(world.func_147439_a(x + 1, y, z + 1).func_149688_o().isSolid() == true)
			{
				world.func_147465_d(x + 1, y, z + 1, block, 0, 2);
			}
			if(world.func_147439_a(x + 1, y, z - 1).func_149688_o().isSolid() == true)
			{
				world.func_147465_d(x+1, y, z - 1, block, 0, 2);
			}
			if(world.func_147439_a(x - 1, y, z + 1).func_149688_o().isSolid() == true)
			{
				world.func_147465_d(x - 1, y, z + 1, block, 0, 2);
			}
			if(world.func_147439_a(x - 1, y, z - 1).func_149688_o().isSolid() == true)
			{
				world.func_147465_d(x - 1, y, z - 1, block, 0, 2);
			}
			if(world.func_147439_a(x + 2, y, z).func_149688_o().isSolid() == true && world.func_147439_a(x + 1, y, z) == block)
			{
				world.func_147465_d(x + 2, y, z, block, 0, 2);
			}
			return true;
		}
		else 
			return false;
	}
}
