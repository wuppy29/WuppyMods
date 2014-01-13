package peacefulpackmod.worldgen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import peacefulpackmod.PeacefulPack;

public class WorldGenFlax extends WorldGenerator
{
	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        for (int i = 0; i < 64; i++)
        {
            int j = (par3 + par2Random.nextInt(6)) - par2Random.nextInt(6);
            int k = (par4 + par2Random.nextInt(4)) - par2Random.nextInt(4);
            int l = (par5 + par2Random.nextInt(6)) - par2Random.nextInt(6);

            if (par1World.func_147437_c(j, k, l) && par1World.func_147439_a(j, k - 1, l) == Blocks.grass)
            {
                par1World.func_147465_d(j, k, l, PeacefulPack.flax, 0, 2);
            }
        }

        return true;
    }
}
