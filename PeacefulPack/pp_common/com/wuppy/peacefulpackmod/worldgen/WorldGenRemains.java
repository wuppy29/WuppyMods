package com.wuppy.peacefulpackmod.worldgen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.wuppy.peacefulpackmod.block.ModBlocks;

public class WorldGenRemains extends WorldGenerator
{
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        for (int i = 0; i < 32; i++)
        {
            int j = (par3 + par2Random.nextInt(6)) - par2Random.nextInt(6);
            int k = (par4 + par2Random.nextInt(4)) - par2Random.nextInt(4);
            int l = (par5 + par2Random.nextInt(6)) - par2Random.nextInt(6);

            if (par1World.getBlock(j, k, l) == Blocks.dirt && par1World.getBlock(j, k + 1, l) == Blocks.grass)
            {
                par1World.setBlock(j, k, l, ModBlocks.remains, 0, 2);
            }
        }

        return true;
    }
}
