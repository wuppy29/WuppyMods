package com.wuppy.goblinsgiants.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.DimensionManager;

import com.wuppy.goblinsgiants.dimension.savannah.BiomeGenSavannah;
import com.wuppy.goblinsgiants.dimension.savannah.StructureMineshaftPiecesSavannah;
import com.wuppy.goblinsgiants.dimension.savannah.StructureMineshaftStartSavannah;
import com.wuppy.goblinsgiants.dimension.savannah.WorldProviderGoblinsGiantsSavannah;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModGeneration implements IWorldGenerator
{
	public static int dimension = DimensionManager.getNextFreeDimId();

	// biome
	public static BiomeGenBase savannah = new BiomeGenSavannah(52).setBiomeName("Savannah");

	public static void init()
	{
		//register MapGens Savannah
		MapGenStructureIO.registerStructure(StructureMineshaftStartSavannah.class, "Mineshaft_Savannah");
		StructureMineshaftPiecesSavannah.registerStructurePieces();

		// generation
		GameRegistry.registerWorldGenerator(new ModGeneration(), 0);

		// dimension
		DimensionManager.registerProviderType(dimension, WorldProviderGoblinsGiantsSavannah.class, false);
		DimensionManager.registerDimension(dimension, dimension);
	}

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
		int PosX = blockX + random.nextInt(5);
		int PosY = random.nextInt(128);
		int PosZ = blockZ + random.nextInt(5);
		(new WorldGenDwarfHouse()).generate(world, random, PosX, PosY, PosZ);

		int RandPosX = blockX + random.nextInt(5);
		int RandPosY = random.nextInt(128);
		int RandPosZ = blockZ + random.nextInt(5);
		(new WorldGenDwarfVillage()).generate(world, random, RandPosX, RandPosY, RandPosZ);

		int RandPosX1 = blockX + random.nextInt(5);
		int RandPosY1 = random.nextInt(128);
		int RandPosZ1 = blockZ + random.nextInt(5);
		(new WorldGenSavannahEntranceTemple()).generate(world, random, RandPosX1, RandPosY1, RandPosZ1);

		/*for(int k = 0; k < 2; k++)
		{
			int RandPosX = blockX + random.nextInt(16);
		    int RandPosY = random.nextInt(128);
		    int RandPosZ = blockZ + random.nextInt(16);
		    (new WorldGenCreeperTemple()).generate(world, random, RandPosX, RandPosY, RandPosZ);
		}*/
	}
}