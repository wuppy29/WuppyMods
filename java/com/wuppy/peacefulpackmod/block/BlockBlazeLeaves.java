package com.wuppy.peacefulpackmod.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
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

import com.wuppy.peacefulpackmod.PeacefulPack;

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

	/*
	@Override
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
	{
		if (par1World.rand.nextInt(12) == 0)
		{
			this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(ModBlocks.blazeSapling, 1));
		}
		else if (par1World.rand.nextInt(5) == 0)
		{
			this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(Items.blaze_rod));
		}
	}*/

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