package peacefulpackmod.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import peacefulpackmod.PeacefulPack;

public class WorldGenBlazeTrees extends WorldGenerator
{
	public WorldGenBlazeTrees()
	{		
	}
	
	public boolean generate(World world, Random random, int i, int j, int k)
    {
        int l = random.nextInt(3) + 4;
        boolean flag = true;
        if(j < 1)
        {
            return false;
        }
        for(int i1 = j; i1 <= j + 1 + l; i1++)
        {
            byte byte0 = 1;
            if(i1 == j)
            {
                byte0 = 0;
            }
            if(i1 >= (j + 1 + l) - 2)
            {
                byte0 = 2;
            }
            for(int i2 = i - byte0; i2 <= i + byte0 && flag; i2++)
            {
                for(int l2 = k - byte0; l2 <= k + byte0 && flag; l2++)
                {
                    if(i1 >= 0)
                    {
                        Block j3 = world.func_147439_a(i2, i1, l2);
                        if(j3 != null && j3 != PeacefulPack.blazeleaves)  
                        {
                            flag = false;
                        }
                    } else
                    {
                        flag = false;
                    }
                }

            }

        }

        if(!flag)
        {
            return false;
        }
        Block j1 = world.func_147439_a(i, j - 1, k);
        if(j1 != Blocks.netherrack)
        {
            return false;
        }
        world.func_147465_d(i, j - 1, k, Blocks.netherrack, 0, 2); 
        for(int k1 = (j - 3) + l; k1 <= j + l; k1++)
        {
            int j2 = k1 - (j + l);
            int i3 = 1 - j2 / 2;
            for(int k3 = i - i3; k3 <= i + i3; k3++)
            {
                int l3 = k3 - i;
                for(int i4 = k - i3; i4 <= k + i3; i4++)
                {
                    int j4 = i4 - k;
                    if((Math.abs(l3) != i3 || Math.abs(j4) != i3 || random.nextInt(2) != 0 && j2 != 0))
                    {
                    	world.func_147465_d(k3, k1, i4, PeacefulPack.blazeleaves, 0, 2);
                    }
                }

            }

        }

        for(int l1 = 0; l1 < l; l1++)
        {
            Block k2 = world.func_147439_a(i, j + l1, k);
            if(k2 == null || k2 == PeacefulPack.blazeleaves) 
            {
            	world.func_147465_d(i, j + l1, k, PeacefulPack.blazelog, 0, 2); 
            }
        }

        return true;
    }
}
