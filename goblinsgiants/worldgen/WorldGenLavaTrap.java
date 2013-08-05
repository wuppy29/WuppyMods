package goblinsgiants.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLavaTrap extends WorldGenerator
{
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        int sand = Block.sand.blockID;

        if(par1World.getBlockId(par3, par4 + 1, par5) == 0 &&
           par1World.getBlockId(par3 + 1, par4, par5) == sand && par1World.getBlockId(par3 - 1, par4, par5) == sand &&
           par1World.getBlockId(par3, par4, par5 + 1) == sand && par1World.getBlockId(par3, par4, par5 - 1) == sand &&
           par1World.getBlockMaterial(par3 + 1, par4 - 1, par5).isSolid() && par1World.getBlockMaterial(par3 - 1, par4 - 1, par5).isSolid() &&
           par1World.getBlockMaterial(par3, par4 - 1, par5 + 1).isSolid() && par1World.getBlockMaterial(par3, par4 - 1, par5 - 1).isSolid() &&
           par1World.getBlockMaterial(par3 + 1, par4 - 2, par5).isSolid() && par1World.getBlockMaterial(par3 - 1, par4 - 2, par5).isSolid() &&
           par1World.getBlockMaterial(par3, par4 - 2, par5 + 1).isSolid() && par1World.getBlockMaterial(par3, par4 - 2, par5 - 1).isSolid()
           )
        {
        	par1World.setBlock(par3, par4, par5, sand);
        	par1World.setBlock(par3, par4 - 1, par5, 0);
        	par1World.setBlock(par3, par4 - 2, par5, Block.lavaStill.blockID);
        	return true;
        }

        else
        	return false;
    }
}
