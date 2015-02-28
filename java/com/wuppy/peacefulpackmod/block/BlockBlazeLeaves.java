package com.wuppy.peacefulpackmod.block;

import com.wuppy.peacefulpackmod.PeacefulPack;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockBlazeLeaves extends BlockLeaves
{
	private final String name = "blazeLeaves";

	public BlockBlazeLeaves()
	{
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(PeacefulPack.modid + "_" + name);

		setLightLevel(0.7F);

		setCreativeTab(PeacefulPack.ppBlocksTab);
	}

	public String getName()
	{
		return name;
	}

	@SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return 16777215;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderColor(IBlockState state)
    {
        return 16777215;
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass)
    {
        return 16777215;
    }

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		IBlockState state = getDefaultState();

		if (meta < 2)
			state.withProperty(DECAYABLE, true);
		else
			state.withProperty(DECAYABLE, false);

		if (meta == 0 || meta == 2)
			state.withProperty(CHECK_DECAY, true);
		else
			state.withProperty(CHECK_DECAY, false);

		return state;
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		if ((Boolean) state.getValue(DECAYABLE))
		{
			if ((Boolean) state.getValue(CHECK_DECAY))
			{
				return 0;
			} else
				return 1;
		} else
		{
			if ((Boolean) state.getValue(CHECK_DECAY))
			{
				return 2;
			} else
				return 3;
		}
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, DECAYABLE, CHECK_DECAY);
	}

	@Override
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		super.randomDisplayTick(worldIn, pos, state, rand);

		if (rand.nextInt(2) == 0)
		{
			double pX = (double) ((float) pos.getX() + worldIn.rand.nextFloat());
			double pY = (double) ((float) pos.getY() + worldIn.rand.nextFloat());
			double pZ = (double) ((float) pos.getZ() + worldIn.rand.nextFloat());
			worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, pX, pY, pZ, 0.0D, 0.0D, 0.0D);
			worldIn.spawnParticle(EnumParticleTypes.FLAME, pX, pY, pZ, 0.0D, 0.0D, 0.0D);
		}
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	{
		List<ItemStack> ret = super.getDrops(world, pos, state, fortune);

		Random rand = world instanceof World ? ((World) world).rand : new Random();

		if (rand.nextInt(10) == 0)
		{
			ret.add(new ItemStack(ModBlocks.blazeSapling));
		}
		if (rand.nextInt(5) == 0)
		{
			ret.add(new ItemStack(Items.blaze_rod));
		}

		return ret;
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1));
		return ret;
	}

	@Override
	public EnumType getWoodType(int meta)
	{
		return null;
	}
}