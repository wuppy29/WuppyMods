package com.wuppy.frozen.generation;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

public class ModGeneration implements IWorldGenerator {
	public static void generate() {
		GameRegistry.registerWorldGenerator(new ModGeneration(), 0);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimensionId()) {
			case 0:
				generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	public void generateSurface(World world, Random random, int blockX, int blockZ) {
		int posX, posY, posZ;

		for (int i = 0; i < 8; i++) {
			posX = blockX + random.nextInt(16);
			posY = 64 + random.nextInt(75);
			posZ = blockZ + random.nextInt(16);
			(new WorldGenIceVines()).generate(world, random, new BlockPos(posX, posY, posZ));
		}

		for (int i = 0; i < 2; i++) {
			if (world.getBiomeGenForCoords(new BlockPos(blockX, 0, blockZ)).getTempCategory() == BiomeGenBase.TempCategory.COLD) {
				int posX1 = blockX + random.nextInt(16);
				int posY1 = 60 + random.nextInt(40);
				int posZ1 = blockZ + random.nextInt(16);
				(new WorldGenHardIce()).generate(world, random, new BlockPos(posX1, posY1, posZ1));
			}
		}
	}
}