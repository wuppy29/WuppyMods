package com.wuppy.peacefulpackmod.block;

import com.wuppy.peacefulpackmod.PeacefulPack;
import com.wuppy.peacefulpackmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.List;
import java.util.Random;

public class BlockRottenPlant extends BlockBush implements IGrowable
{
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 1);

	private final String name = "rottenPlant";

	public BlockRottenPlant()
	{
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(PeacefulPack.modid + "_" + name);

		setStepSound(soundTypeGrass);
		setBlockBounds(0F, 0.0F, 0F, 1F, 0.25F, 1F);
		setHardness(0.0F);
		disableStats();

		setCreativeTab(null);
	}

	public String getName()
	{
		return name;
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(AGE, meta);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return (Integer) state.getValue(AGE);
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, AGE);
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		return worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).getBlock() == Blocks.netherrack;
	}

	@Override
	public boolean canPlaceBlockOn(Block ground)
	{
		return ground == Blocks.netherrack;
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		super.updateTick(worldIn, pos, state, rand);

		if (worldIn.getLightFromNeighbors(pos.up()) < 6)
		{
			int i = (Integer) state.getValue(AGE);

			if (i < 1)
			{
				float f = getGrowthChance(this, worldIn, pos);

				if (rand.nextInt((int) (25.0F / f) + 1) == 0)
				{
					worldIn.setBlockState(pos, state.withProperty(AGE, i + 1), 2);
				}
			}
		}
	}

	protected static float getGrowthChance(Block blockIn, World worldIn, BlockPos pos)
	{
		float f = 1.0F;
		BlockPos blockpos1 = pos.down();

		for (int i = -1; i <= 1; ++i)
		{
			for (int j = -1; j <= 1; ++j)
			{
				float f1 = 0.0F;
				IBlockState iblockstate = worldIn.getBlockState(blockpos1.add(i, 0, j));

				if (iblockstate.getBlock().canSustainPlant(worldIn, blockpos1.add(i, 0, j), net.minecraft.util.EnumFacing.UP, (net.minecraftforge.common.IPlantable) blockIn))
				{
					f1 = 1.0F;

					if (iblockstate.getBlock().isFertile(worldIn, blockpos1.add(i, 0, j)))
					{
						f1 = 3.0F;
					}
				}

				if (i != 0 || j != 0)
				{
					f1 /= 4.0F;
				}

				f += f1;
			}
		}

		BlockPos blockpos2 = pos.north();
		BlockPos blockpos3 = pos.south();
		BlockPos blockpos4 = pos.west();
		BlockPos blockpos5 = pos.east();
		boolean flag = blockIn == worldIn.getBlockState(blockpos4).getBlock() || blockIn == worldIn.getBlockState(blockpos5).getBlock();
		boolean flag1 = blockIn == worldIn.getBlockState(blockpos2).getBlock() || blockIn == worldIn.getBlockState(blockpos3).getBlock();

		if (flag && flag1)
		{
			f /= 2.0F;
		} else
		{
			boolean flag2 = blockIn == worldIn.getBlockState(blockpos4.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos5.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos5.south()).getBlock() || blockIn == worldIn.getBlockState(blockpos4.south()).getBlock();

			if (flag2)
			{
				f /= 2.0F;
			}
		}

		return f;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	{
		List<ItemStack> ret = super.getDrops(world, pos, state, fortune);

		int age = (Integer) state.getValue(AGE);
		Random rand = world instanceof World ? ((World) world).rand : new Random();

		if (age > 0)
		{
			ret.add(new ItemStack(Items.rotten_flesh));
		}
		if (rand.nextInt(2) == 0)
		{
			ret.add(new ItemStack(ModItems.rottenSeed));
		}

		return ret;
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
	{
		return (Integer) state.getValue(AGE) < 2;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		return true;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		worldIn.setBlockState(pos, state.withProperty(AGE, 1), 2);
	}
}