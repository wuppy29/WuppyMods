package com.wuppy.peacefulpackmod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.wuppy.peacefulpackmod.PeacefulPack;
import com.wuppy.peacefulpackmod.worldgen.WorldGenBlazeTrees;

public class BlockBlazeSapling extends Block implements IGrowable
{
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	
	private final String name = "blazeSapling";
	
    public BlockBlazeSapling()
    {
        super(Material.plants);
        GameRegistry.registerBlock(this, name);
		setUnlocalizedName(PeacefulPack.modid + "_" + name);
        
        setStepSound(soundTypeGrass);
        setHardness(0.0F);
        setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.8F, 0.9F);
        
        setCreativeTab(PeacefulPack.ppBlocksTab);
    }

    public String getName()
	{
		return name;
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
    public boolean canPlaceBlockAt(World world, BlockPos pos)
    {
    	if(world.getBlockState(pos).getBlock() == Blocks.netherrack)
    		return true;
    	else
    		return false;
    }
    
    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random random)
    {
        super.updateTick(world, pos, state, random);
        
        if(world.getLightFromNeighbors(pos.up()) < 7 && random.nextInt(7) == 0)
        {
        	if (((Integer)state.getValue(STAGE)).intValue() == 0)
            {
                world.setBlockState(pos, state.cycleProperty(STAGE), 4);
            }
        	else
            {
                growTree(world, pos, random);
            }
        }
    }

    public void growTree(World world, BlockPos pos, Random random)
    {
    	world.setBlockState(pos, Blocks.air.getDefaultState());
    	
    	WorldGenBlazeTrees generator = new WorldGenBlazeTrees();
    	if(!((WorldGenerator) (generator)).generate(world, random, pos))
        {
            world.setBlockState(pos, ModBlocks.blazeLog.getDefaultState(), 2);
        }
    }

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) 
	{
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		if(rand.nextInt(3) == 0)
			return true;
		else
			return false;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		growTree(worldIn, pos, rand);
	}
}