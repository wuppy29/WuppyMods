package com.wuppy.improvedmobspawn;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class ImprovedMobsGenerater implements IWorldGenerator 
{
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
			case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
		}
	}

	public void generateSurface(World world, Random random, int blockX, int blockZ)
	{
		for(int i = 0; i < 5; i++)
		{
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(60);
			int Zcoord = blockZ + random.nextInt(16);
			(new WorldGenMinable(Blocks.monster_egg, 2)).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
	}
}
