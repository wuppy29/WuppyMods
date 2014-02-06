package com.wuppy.peacefulpackmod.block;

import java.util.ArrayList;
import java.util.Random;

import com.wuppy.peacefulpackmod.PeacefulPack;

import net.minecraft.block.BlockLeaves;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlazeleaves extends BlockLeaves
{
	int adjacentTreeBlocks[];

	@SideOnly(Side.CLIENT)
	public int func_149635_D()
	{
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		super.randomDisplayTick(par1World, par2, par3, par4, par5Random);

		if (par5Random.nextInt(2) == 0)
		{
			double var1 = (double) ((float) par2 + par1World.rand.nextFloat());
			double var2 = (double) ((float) par3 + par1World.rand.nextFloat());
			double var3 = (double) ((float) par4 + par1World.rand.nextFloat());
			par1World.spawnParticle("smoke", var1, var2, var3, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", var1, var2, var3, 0.0D, 0.0D, 0.0D);
		}
	}

	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
	{
		if (par1World.rand.nextInt(12) == 0)
		{
			this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(PeacefulPack.blazeSapling, 1));
		}
		else if (par1World.rand.nextInt(5) == 0)
		{
			this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(Items.blaze_rod));
		}
	}

	public int damageDropped(int par1)
	{
		return par1 & 3;
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z)
	{
		return false;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune)
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1));
		return ret;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int var1, int var2)
	{
		return this.blockIcon;
	}

	@Override
	public String[] func_150125_e()
	{
		return new String[] { "Blaze" };
	}
}
