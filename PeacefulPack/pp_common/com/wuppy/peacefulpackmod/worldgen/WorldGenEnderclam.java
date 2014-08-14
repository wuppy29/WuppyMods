package com.wuppy.peacefulpackmod.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenEnderclam extends WorldGenerator
{
    private Block enderclam;

    public WorldGenEnderclam(Block par1)
    {
        enderclam = par1;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
    	if (par1World.getBlock(par3, par4 - 1, par5) == Blocks.sand || par1World.getBlock(par3, par4 - 1, par5) == Blocks.dirt || par1World.getBlock(par3, par4 - 1, par5) == Blocks.clay)
    	{
    		if (par1World.getBlock(par3, par4 + 1, par5) == Blocks.water || par1World.getBlock(par3, par4 + 1, par5) == Blocks.flowing_water)
    		{
    			par1World.setBlock(par3, par4, par5, enderclam, 0, 2);
    		}
    	}
        return true;
    }
}