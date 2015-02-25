package com.wuppy.peacefulpackmod.block;

import com.wuppy.peacefulpackmod.PeacefulPack;
import com.wuppy.peacefulpackmod.worldgen.WorldGenBlazeTrees;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

public class BlockBlazeSapling extends BlockBush implements IGrowable
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

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(STAGE, meta);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return (Integer) state.getValue(STAGE);
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, STAGE);
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	{
		return null;
	}

	@Override
	public boolean canPlaceBlockOn(Block ground)
	{
		return ground == Blocks.netherrack;
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random random)
	{
		super.updateTick(world, pos, state, random);

		if (world.getLightFromNeighbors(pos.up()) < 7 && random.nextInt(7) == 0)
		{
			if ((Integer) state.getValue(STAGE) == 0)
			{
				world.setBlockState(pos, state.cycleProperty(STAGE), 4);
			} else
			{
				growTree(world, pos, random);
			}
		}
	}

	public void growTree(World world, BlockPos pos, Random random)
	{
		world.setBlockState(pos, Blocks.air.getDefaultState());

		WorldGenBlazeTrees generator = new WorldGenBlazeTrees();
		generator.generate(world, random, pos);
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
	{
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		return rand.nextInt(3) == 0;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		growTree(worldIn, pos, rand);
	}
}