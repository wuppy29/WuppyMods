package com.wuppy.magicalexp;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import com.wuppy.magicalexp.blocks.ModBlocks;

import cpw.mods.fml.common.IWorldGenerator;

public class MagicGenerater implements IWorldGenerator
{
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	public void generateSurface(World world, Random random, int blockX, int blockZ)
	{
		int Xcoord = blockX + random.nextInt(16);
		int Ycoord = random.nextInt(60);
		int Zcoord = blockZ + random.nextInt(16);
		(new WorldGenMEOres(ModBlocks.expore, 0, 10)).generate(world, random, Xcoord, Ycoord, Zcoord);

		int Xcoord1 = blockX + random.nextInt(2);
		int Ycoord1 = random.nextInt(60);
		int Zcoord1 = blockZ + random.nextInt(3);
		(new WorldGenMEOres(ModBlocks.expore, 1, 15)).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
	}
}
