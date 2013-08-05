package peacefulpackmod.worldgen;

import java.util.Random;

import peacefulpackmod.PeacefulPack;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenFlax extends WorldGenerator
{
	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        for (int i = 0; i < 64; i++)
        {
            int j = (par3 + par2Random.nextInt(6)) - par2Random.nextInt(6);
            int k = (par4 + par2Random.nextInt(4)) - par2Random.nextInt(4);
            int l = (par5 + par2Random.nextInt(6)) - par2Random.nextInt(6);

            if (par1World.isAirBlock(j, k, l) && par1World.getBlockId(j, k - 1, l) == Block.grass.blockID)
            {
                par1World.setBlock(j, k, l, PeacefulPack.flax.blockID);
            }
        }

        return true;
    }
}
