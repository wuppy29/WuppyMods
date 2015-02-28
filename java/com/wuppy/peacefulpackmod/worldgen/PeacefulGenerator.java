package com.wuppy.peacefulpackmod.worldgen;

import com.wuppy.peacefulpackmod.block.ModBlocks;
import com.wuppy.peacefulpackmod.config.Config;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class PeacefulGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.getDimensionId())
		{
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}

	public static void generateSurface(World world, Random random, int blockX, int blockZ)
	{
		if (Config.spawnSulphurNiter)
		{
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(60);
			int Zcoord = blockZ + random.nextInt(16);
			new WorldGenMinable(ModBlocks.oreBlock.getDefaultState(), 10, BlockHelper.forBlock(Blocks.stone)).generate(world, random, new BlockPos(Xcoord, Ycoord, Zcoord));

			int Xcoord1 = blockX + random.nextInt(16);
			int Ycoord1 = random.nextInt(60);
			int Zcoord1 = blockZ + random.nextInt(16);
			new WorldGenMinable(ModBlocks.oreBlock.getStateFromMeta(1), 10, BlockHelper.forBlock(Blocks.stone)).generate(world, random, new BlockPos(Xcoord1, Ycoord1, Zcoord1));
		}

		if (Config.spawnFossils)
		{
			int Xcoord2 = blockX + random.nextInt(16);
			int Ycoord2 = random.nextInt(60);
			int Zcoord2 = blockZ + random.nextInt(16);
			new WorldGenMinableFossil(ModBlocks.oreBlock.getStateFromMeta(2), 15, BlockHelper.forBlock(Blocks.stone)).generate(world, random, new BlockPos(Xcoord2, Ycoord2, Zcoord2));
		}

		if (Config.spawnFlax)
		{
			int Xcoord3 = blockX + random.nextInt(16);
			int Ycoord3 = random.nextInt(80);
			int Zcoord3 = blockZ + random.nextInt(16);
			new WorldGenFlax().generate(world, random, new BlockPos(Xcoord3, Ycoord3, Zcoord3));
		}

		if (Config.spawnSlimePool)
		{
			int Xcoord5 = blockX + random.nextInt(16);
			int Ycoord5 = random.nextInt(45);
			int Zcoord5 = blockZ + random.nextInt(16);
			new WorldGenSlimepool().generate(world, random, new BlockPos(Xcoord5, Ycoord5, Zcoord5));
		}

		if (Config.spawnEnderClams)
		{
			for (int i = 0; i < 5; i++)
			{
				int Xcoord7 = blockX + random.nextInt(16);
				int Ycoord7 = 40 + random.nextInt(40);
				int Zcoord7 = blockZ + random.nextInt(16);
				new WorldGenEnderclam(ModBlocks.enderClam).generate(world, random, new BlockPos(Xcoord7, Ycoord7, Zcoord7));
			}
		}

		if (random.nextInt(2) == 0 && Config.spawnRemains)
		{
			int Xcoord8 = blockX + random.nextInt(16);
			int Ycoord8 = 55 + random.nextInt(30);
			int Zcoord8 = blockZ + random.nextInt(16);
			new WorldGenRemains().generate(world, random, new BlockPos(Xcoord8, Ycoord8, Zcoord8));
		}
	}

	public static void generateNether(World world, Random random, int blockX, int blockZ)
	{
		if (Config.spawnRottenPlants)
		{
			int Xcoord4 = blockX + random.nextInt(16);
			int Ycoord4 = 20 + random.nextInt(120);
			int Zcoord4 = blockZ + random.nextInt(16);
			new WorldGenRottenplant().generate(world, random, new BlockPos(Xcoord4, Ycoord4, Zcoord4));
		}

		if (Config.spawnBlazeTrees)
		{
			for (int i = 0; i < 2; i++)
			{
				int Xcoord8 = blockX + random.nextInt(16);
				int Ycoord8 = 20 + random.nextInt(120);
				int Zcoord8 = blockZ + random.nextInt(16);
				(new WorldGenBlazeTrees()).generate(world, random, new BlockPos(Xcoord8, Ycoord8, Zcoord8));
			}
		}

		if (Config.spawnGhastOre)
		{
			int Xcoord9 = blockX + random.nextInt(16);
			int Ycoord9 = 20 + random.nextInt(128);
			int Zcoord9 = blockZ + random.nextInt(16);
			new WorldGenMinable(ModBlocks.ghastOre.getDefaultState(), 15, BlockHelper.forBlock(Blocks.netherrack)).generate(world, random, new BlockPos(Xcoord9, Ycoord9, Zcoord9));
		}
	}
}