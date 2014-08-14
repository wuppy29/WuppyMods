package com.wuppy.peacefulpackmod.worldgen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.wuppy.peacefulpackmod.block.ModBlocks;

public class WorldGenRottenplant extends WorldGenerator
{
	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        for (int i = 0; i < 64; i++)
        {
            int j = (par3 + par2Random.nextInt(8)) - par2Random.nextInt(8);
            int k = (par4 + par2Random.nextInt(4)) - par2Random.nextInt(4);
            int l = (par5 + par2Random.nextInt(8)) - par2Random.nextInt(8);

            if (par1World.isAirBlock(j, k, l) && par1World.getBlock(j, k - 1, l) == Blocks.netherrack)
            {
                par1World.setBlock(j, k, l, ModBlocks.rottenplant, 0, 2);
            }
        }

        return true;
    }
}
