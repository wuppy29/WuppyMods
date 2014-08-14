package com.wuppy.goblinsgiants.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLavaTrap extends WorldGenerator
{
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        Block sand = Blocks.sand;

        if(par1World.getBlock(par3, par4 + 1, par5) == Blocks.air &&
           par1World.getBlock(par3 + 1, par4, par5) == sand && par1World.getBlock(par3 - 1, par4, par5) == sand &&
           par1World.getBlock(par3, par4, par5 + 1) == sand && par1World.getBlock(par3, par4, par5 - 1) == sand &&
           par1World.getBlock(par3 + 1, par4 - 1, par5).getMaterial().isSolid() && par1World.getBlock(par3 - 1, par4 - 1, par5).getMaterial().isSolid() &&
           par1World.getBlock(par3, par4 - 1, par5 + 1).getMaterial().isSolid() && par1World.getBlock(par3, par4 - 1, par5 - 1).getMaterial().isSolid() &&
           par1World.getBlock(par3 + 1, par4 - 2, par5).getMaterial().isSolid() && par1World.getBlock(par3 - 1, par4 - 2, par5).getMaterial().isSolid() &&
           par1World.getBlock(par3, par4 - 2, par5 + 1).getMaterial().isSolid() && par1World.getBlock(par3, par4 - 2, par5 - 1).getMaterial().isSolid()
           )
        {
        	par1World.setBlock(par3, par4, par5, sand);
        	par1World.setBlock(par3, par4 - 1, par5, Blocks.air);
        	par1World.setBlock(par3, par4 - 2, par5, Blocks.lava);
        	return true;
        }

        else
        	return false;
    }
}
