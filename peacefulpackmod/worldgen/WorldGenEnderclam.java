package peacefulpackmod.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenEnderclam extends WorldGenerator
{
    private int enderclamID;

    public WorldGenEnderclam(int par1)
    {
        enderclamID = par1;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
    	if (par1World.getBlockId(par3, par4 - 1, par5) == Block.sand.blockID || par1World.getBlockId(par3, par4 - 1, par5) == Block.dirt.blockID || par1World.getBlockId(par3, par4 - 1, par5) == Block.blockClay.blockID)
    	{
    		if (par1World.getBlockId(par3, par4 + 1, par5) == Block.waterStill.blockID || par1World.getBlockId(par3, par4 + 1, par5) == Block.waterMoving.blockID)
    		{
    			par1World.setBlock(par3, par4, par5, enderclamID);
    		}
    	}
        return true;
    }
}