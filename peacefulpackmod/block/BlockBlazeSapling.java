package peacefulpackmod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import peacefulpackmod.PeacefulPack;
import peacefulpackmod.worldgen.WorldGenBlazeTrees;

public class BlockBlazeSapling extends Block
{
    public BlockBlazeSapling()
    {
        super(Material.field_151585_k);
        float f = 0.4F;
        func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.func_149675_a(true);
    }
    
    public boolean func_149742_c(World par1World, int par2, int par3, int par4)
    {
    	if(par1World.func_147439_a(par2, par3 - 1, par4) == Blocks.netherrack)
    		return true;
    	else
    		return false;
    }
    
    public void func_149674_a(World world, int i, int j, int k, Random random)
    {
        super.func_149674_a(world, i, j, k, random);
        
        if(world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(7) == 0)
        {
            int l = world.getBlockMetadata(i, j, k);
            if((l & 8) == 0)
            {
                world.setBlockMetadataWithNotify(i, j, k, l | 8, 2);
            } else
            {
                growTree(world, i, j, k, random);
            }
        }
    }

    public void growTree(World world, int i, int j, int k, Random random)
    {
        int l = world.getBlockMetadata(i, j, k);
        world.func_147468_f(i, j, k);
        Object obj = null;
        obj = new WorldGenBlazeTrees();
        
        if(!((WorldGenerator) (obj)).generate(world, random, i, j, k))
        {
            world.func_147465_d(i, j, k, PeacefulPack.blazelog, l, 2);
        }
    }
}
