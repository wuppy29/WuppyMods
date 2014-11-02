package com.wuppy.peacefulpackmod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.wuppy.peacefulpackmod.PeacefulPack;
import com.wuppy.peacefulpackmod.worldgen.WorldGenBlazeTrees;

public class BlockBlazeSapling extends Block implements IGrowable
{
    public BlockBlazeSapling()
    {
        super(Material.plants);
        setStepSound(soundTypeGrass);
        setHardness(0.0F);
        setBlockName("blazeSapling");
        setBlockTextureName(PeacefulPack.modid + ":" + "blazeSapling");
        setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.8F, 0.9F);
        setCreativeTab(PeacefulPack.ppBlocksTab);
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 1;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }
    
    @Override
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
    	if(par1World.getBlock(par2, par3 - 1, par4) == Blocks.netherrack)
    		return true;
    	else
    		return false;
    }
    
    @Override
    public void updateTick(World world, int i, int j, int k, Random random)
    {
        super.updateTick(world, i, j, k, random);
        
        if(world.getBlockLightValue(i, j + 1, k) < 7 && random.nextInt(7) == 0)
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
        world.setBlockToAir(i, j, k);
        Object obj = null;
        obj = new WorldGenBlazeTrees();
        
        if(!((WorldGenerator) (obj)).generate(world, random, i, j, k))
        {
            world.setBlock(i, j, k, ModBlocks.blazelog, l, 2);
        }
    }
    
    @Override
	public boolean func_149851_a(World world, int x, int y, int z, boolean p_149851_5_)
	{
		return true;
	}

	@Override
	public boolean func_149852_a(World world, Random rand, int x, int y, int z)
	{
		if(rand.nextInt(3) == 0)
			return true;
		else
			return false;
	}	

	@Override
	public void func_149853_b(World world, Random rand, int x, int y, int z)
	{
		growTree(world, x, y, z, rand);
	}
}
