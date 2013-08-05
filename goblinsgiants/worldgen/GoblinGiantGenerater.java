package goblinsgiants.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class GoblinGiantGenerater implements IWorldGenerator
{
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
			case -1: generateNether(world, random, chunkX*16, chunkZ*16); //Forge provides true chunk coordinates, while ModLoader provides block coordinates and calls them chunkX & chunkZ
			case 0: generateSurface(world, random, chunkX*16, chunkZ*16); //To make these values the same as ModLoader they need to be multiplied by 16
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

	public void generateNether(World world, Random random, int blockX, int blockZ)
	{
	}
}
