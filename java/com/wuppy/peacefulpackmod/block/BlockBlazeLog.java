package com.wuppy.peacefulpackmod.block;

import com.wuppy.peacefulpackmod.PeacefulPack;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockBlazeLog extends BlockLog
{
	private final String name = "blazeLog";

	public BlockBlazeLog()
	{
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(PeacefulPack.modid + "_" + name);

		setCreativeTab(PeacefulPack.ppBlocksTab);
	}

	public String getName()
	{
		return name;
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		switch (meta)
		{
		case 0:
			return this.getDefaultState().withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
		case 1:
			return this.getDefaultState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
		case 2:
			return this.getDefaultState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
		default:
			return this.getDefaultState().withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
		}
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		switch (BlockBlazeLog.SwitchEnumAxis.AXIS_LOOKUP[((BlockLog.EnumAxis) state.getValue(LOG_AXIS)).ordinal()])
		{
		case 0:
			return 1;
		case 1:
			return 0;
		case 2:
			return 2;
		default:
			return 3;
		}
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, LOG_AXIS);
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(LOG_AXIS, BlockLog.EnumAxis.fromFacingAxis(facing.getAxis()));
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return 0;
	}

	static final class SwitchEnumAxis
	{
		static final int[] AXIS_LOOKUP = new int[BlockLog.EnumAxis.values().length];
		private static final String __OBFID = "CL_00002083";

		static
		{
			try
			{
				AXIS_LOOKUP[BlockLog.EnumAxis.X.ordinal()] = 1;
			} catch (NoSuchFieldError var3)
			{
			}

			try
			{
				AXIS_LOOKUP[BlockLog.EnumAxis.Z.ordinal()] = 2;
			} catch (NoSuchFieldError var2)
			{
			}

			try
			{
				AXIS_LOOKUP[BlockLog.EnumAxis.NONE.ordinal()] = 3;
			} catch (NoSuchFieldError var1)
			{
			}
		}
	}
}