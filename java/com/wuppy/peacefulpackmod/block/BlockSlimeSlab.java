package com.wuppy.peacefulpackmod.block;

import com.wuppy.peacefulpackmod.PeacefulPack;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

public class BlockSlimeSlab extends Block
{
	private final String name = "slimeSlab";

	public BlockSlimeSlab()
	{
		super(Material.ground);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(PeacefulPack.modid + "_" + name);

		setHardness(1F);
		setLightLevel(0.5F);
		setResistance(1.0F);
		setHardness(2.0F);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);

		setCreativeTab(PeacefulPack.ppBlocksTab);

		setTickRandomly(true);
	}

	public String getName()
	{
		return name;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Items.slime_ball;
	}

	@Override
	public void randomDisplayTick(World par1World, BlockPos pos, IBlockState state, Random par5Random)
	{
		super.randomDisplayTick(par1World, pos, state, par5Random);

		if (par5Random.nextInt(2) == 0)
		{
			double dX = (double) ((float) pos.getX() + par1World.rand.nextFloat());
			double dY = (double) ((float) pos.getY() + par1World.rand.nextFloat());
			double dZ = (double) ((float) pos.getZ() + par1World.rand.nextFloat());
			par1World.spawnParticle(EnumParticleTypes.SLIME, dX, dY, dZ, 0.0D, 0.0D, 0.0D);
		}
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean isFullCube()
	{
		return false;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, Entity entity)
	{
		entity.motionX *= 0.00001D;
		entity.motionY *= 0.0D;
		entity.motionZ *= 0.00001D;
	}
}
