package com.wuppy.peacefulpackmod.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.wuppy.peacefulpackmod.block.ModBlocks;

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
		
		Block block = ModBlocks.slimeslab;
		if(world.getBlock(x, y, z).getMaterial().isSolid() == true && rand.nextInt(4) == 1)
		{
			world.setBlock(x, y, z, block, 0, 2);
			if(world.getBlock(x + 1, y, z).getMaterial().isSolid() == true)
			{
				world.setBlock(x+1, y, z, block, 0, 2);
			}
			if(world.getBlock(x - 1, y, z).getMaterial().isSolid() == true)
			{
				world.setBlock(x - 1, y, z, block, 0, 2);
			}
			if(world.getBlock(x, y, z + 1).getMaterial().isSolid() == true)
			{
				world.setBlock(x, y, z + 1, block, 0, 2);
			}
			if(world.getBlock(x, y, z - 1).getMaterial().isSolid() == true)
			{
				world.setBlock(x, y, z - 1, block, 0, 2);
			}
			if(world.getBlock(x + 1, y, z + 1).getMaterial().isSolid() == true)
			{
				world.setBlock(x + 1, y, z + 1, block, 0, 2);
			}
			if(world.getBlock(x + 1, y, z - 1).getMaterial().isSolid() == true)
			{
				world.setBlock(x+1, y, z - 1, block, 0, 2);
			}
			if(world.getBlock(x - 1, y, z + 1).getMaterial().isSolid() == true)
			{
				world.setBlock(x - 1, y, z + 1, block, 0, 2);
			}
			if(world.getBlock(x - 1, y, z - 1).getMaterial().isSolid() == true)
			{
				world.setBlock(x - 1, y, z - 1, block, 0, 2);
			}
			if(world.getBlock(x + 2, y, z).getMaterial().isSolid() == true && world.getBlock(x + 1, y, z) == block)
			{
				world.setBlock(x + 2, y, z, block, 0, 2);
			}
			return true;
		}
		else 
			return false;
	}
}
