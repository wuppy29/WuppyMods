package com.wuppy.slimedungeons.generation;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class SlimeGenerator implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimensionId()) {
			case 0:
				generateSurface(world, random, chunkX * 16, chunkZ * 16); //To make these values the same as ModLoader they need to be multiplied by 16
		}
	}

	public void generateSurface(World world, Random random, int blockX, int blockZ) {
		int Xcoord = blockX + random.nextInt(16);
		int Ycoord = random.nextInt(60);
		int Zcoord = blockZ + random.nextInt(16);
		(new WorldGenSlimeDungeon()).generate(world, random, new BlockPos(Xcoord, Ycoord, Zcoord));
	}
}
