package com.wuppy.goblinsgiants.worldgen.savannah;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCreeperTemple extends WorldGenerator
{
	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
	{
		if (par1World.rand.nextInt(10) == 0)
		{
			while (par1World.isAirBlock(par3, par4, par5) && par4 > 55)
			{
				--par4;
			}
			Block mossy = Blocks.mossy_cobblestone;
			Block cobble = Blocks.cobblestone;

			par1World.setBlock(par3, par4 + 1, par5, mossy);
			par1World.setBlock(par3, par4 + 2, par5, cobble);
			par1World.setBlock(par3, par4 + 3, par5, mossy);

			par1World.setBlock(par3, par4 + 1, par5 + 1, cobble);
			par1World.setBlock(par3, par4 + 2, par5 + 1, mossy);
			par1World.setBlock(par3, par4 + 3, par5 + 1, cobble);

			par1World.setBlock(par3, par4 + 3, par5 + 2, mossy);
			par1World.setBlock(par3, par4 + 4, par5 + 2, Blocks.stone_stairs, 0, 2);

			par1World.setBlock(par3, par4 + 3, par5 + 3, mossy);

			par1World.setBlock(par3, par4 + 1, par5 + 4, cobble);
			par1World.setBlock(par3, par4 + 2, par5 + 4, mossy);
			par1World.setBlock(par3, par4 + 3, par5 + 4, cobble);
			par1World.setBlock(par3, par4 + 4, par5 + 4, Blocks.stone_stairs, 0, 2);

			par1World.setBlock(par3, par4 + 1, par5 + 5, mossy);
			par1World.setBlock(par3, par4 + 2, par5 + 5, cobble);
			par1World.setBlock(par3, par4 + 3, par5 + 5, mossy);

			par1World.setBlock(par3 + 1, par4 + 1, par5, cobble);
			par1World.setBlock(par3 + 1, par4 + 2, par5, mossy);
			par1World.setBlock(par3 + 1, par4 + 3, par5, cobble);
			par1World.setBlock(par3 + 1, par4 + 4, par5, Blocks.stone_stairs, 2, 2);

			par1World.setBlock(par3 + 1, par4 + 1, par5 + 5, cobble);
			par1World.setBlock(par3 + 1, par4 + 2, par5 + 5, mossy);
			par1World.setBlock(par3 + 1, par4 + 3, par5 + 5, cobble);
			par1World.setBlock(par3 + 1, par4 + 4, par5 + 5, Blocks.stone_stairs, 3, 2);

			par1World.setBlock(par3 + 2, par4 + 3, par5 + 5, cobble);
			par1World.setBlock(par3 + 2, par4 + 4, par5 + 5, Blocks.stone_stairs, 3, 2);

			par1World.setBlock(par3 + 3, par4 + 3, par5 + 5, mossy);

			par1World.setBlock(par3 + 4, par4 + 1, par5 + 5, mossy);
			par1World.setBlock(par3 + 4, par4 + 2, par5 + 5, cobble);
			par1World.setBlock(par3 + 4, par4 + 3, par5 + 5, mossy);
			par1World.setBlock(par3 + 4, par4 + 4, par5 + 5, Blocks.stone_stairs, 3, 2);

			par1World.setBlock(par3 + 5, par4 + 1, par5 + 5, cobble);
			par1World.setBlock(par3 + 5, par4 + 2, par5 + 5, mossy);
			par1World.setBlock(par3 + 5, par4 + 3, par5 + 5, cobble);

			par1World.setBlock(par3 + 2, par4 + 3, par5, mossy);
			par1World.setBlock(par3 + 2, par4 + 4, par5, Blocks.stone_stairs, 2, 2);

			par1World.setBlock(par3 + 3, par4 + 3, par5, cobble);

			par1World.setBlock(par3 + 4, par4 + 1, par5, cobble);
			par1World.setBlock(par3 + 4, par4 + 2, par5, mossy);
			par1World.setBlock(par3 + 4, par4 + 3, par5, mossy);
			par1World.setBlock(par3 + 4, par4 + 4, par5, Blocks.stone_stairs, 2, 2);

			par1World.setBlock(par3 + 5, par4 + 1, par5, mossy);
			par1World.setBlock(par3 + 5, par4 + 2, par5, cobble);
			par1World.setBlock(par3 + 5, par4 + 3, par5, cobble);

			par1World.setBlock(par3 + 5, par4 + 1, par5 + 1, cobble);
			par1World.setBlock(par3 + 5, par4 + 2, par5 + 1, mossy);
			par1World.setBlock(par3 + 5, par4 + 3, par5 + 1, cobble);
			par1World.setBlock(par3 + 5, par4 + 4, par5 + 1, Blocks.stone_stairs, 1, 2);

			par1World.setBlock(par3 + 5, par4 + 3, par5 + 2, mossy);

			par1World.setBlock(par3 + 5, par4 + 3, par5 + 3, mossy);
			par1World.setBlock(par3 + 5, par4 + 4, par5 + 3, Blocks.stone_stairs, 1, 2);

			par1World.setBlock(par3 + 5, par4 + 1, par5 + 4, mossy);
			par1World.setBlock(par3 + 5, par4 + 2, par5 + 4, mossy);
			par1World.setBlock(par3 + 5, par4 + 3, par5 + 4, cobble);

			// entrance roof
			par1World.setBlock(par3 + 1, par4 + 4, par5 + 1, mossy);
			par1World.setBlock(par3 + 1, par4 + 4, par5 + 2, cobble);
			par1World.setBlock(par3 + 2, par4 + 4, par5 + 2, mossy);
			par1World.setBlock(par3 + 2, par4 + 4, par5 + 3, cobble);
			par1World.setBlock(par3 + 2, par4 + 4, par5 + 4, mossy);
			par1World.setBlock(par3 + 3, par4 + 4, par5 + 1, cobble);
			par1World.setBlock(par3 + 3, par4 + 4, par5 + 3, mossy);
			par1World.setBlock(par3 + 4, par4 + 4, par5 + 1, mossy);
			par1World.setBlock(par3 + 4, par4 + 4, par5 + 4, cobble);

			// entrance floor
			par1World.setBlock(par3, par4, par5 + 2, cobble);
			par1World.setBlock(par3, par4, par5 + 3, mossy);
			par1World.setBlock(par3 + 1, par4, par5 + 1, mossy);
			par1World.setBlock(par3 + 1, par4, par5 + 2, cobble);
			par1World.setBlock(par3 + 1, par4, par5 + 3, mossy);
			par1World.setBlock(par3 + 1, par4, par5 + 4, cobble);
			par1World.setBlock(par3 + 2, par4, par5, mossy);
			par1World.setBlock(par3 + 2, par4, par5 + 1, cobble);
			par1World.setBlock(par3 + 2, par4, par5 + 2, Blocks.air);
			par1World.setBlock(par3 + 2, par4, par5 + 3, Blocks.air);
			par1World.setBlock(par3 + 2, par4, par5 + 4, cobble);
			par1World.setBlock(par3 + 2, par4, par5 + 5, mossy);
			par1World.setBlock(par3 + 3, par4, par5, cobble);
			par1World.setBlock(par3 + 3, par4, par5 + 1, mossy);
			par1World.setBlock(par3 + 3, par4, par5 + 2, Blocks.air);
			par1World.setBlock(par3 + 3, par4, par5 + 3, Blocks.air);
			par1World.setBlock(par3 + 3, par4, par5 + 4, mossy);
			par1World.setBlock(par3 + 3, par4, par5 + 5, cobble);
			par1World.setBlock(par3 + 4, par4, par5 + 1, mossy);
			par1World.setBlock(par3 + 4, par4, par5 + 2, cobble);
			par1World.setBlock(par3 + 4, par4, par5 + 3, mossy);
			par1World.setBlock(par3 + 4, par4, par5 + 4, cobble);
			par1World.setBlock(par3 + 5, par4, par5 + 2, mossy);
			par1World.setBlock(par3 + 5, par4, par5 + 3, cobble);

			return true;
		}
		else
			return false;
	}
}
