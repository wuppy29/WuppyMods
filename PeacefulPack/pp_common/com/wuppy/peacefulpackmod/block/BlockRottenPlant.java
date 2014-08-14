package com.wuppy.peacefulpackmod.block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.wuppy.peacefulpackmod.PeacefulPack;
import com.wuppy.peacefulpackmod.item.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRottenPlant extends BlockMushroom implements IGrowable
{
	public BlockRottenPlant()
	{
		super();
		setStepSound(soundTypeGrass);
		setBlockBounds(0F, 0.0F, 0F, 1F, 0.25F, 1F);
		setHardness(0.0F);
		setBlockName("rottenplant");
		disableStats();
		setCreativeTab((CreativeTabs) null);
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		iconArray = new IIcon[2];
		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return iconArray[par2];
	}

	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		if (par1World.getBlock(par2, par3 - 1, par4) == Blocks.netherrack)
			return true;
		else
			return false;
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		super.updateTick(par1World, par2, par3, par4, par5Random);

		if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 9)
		{
			int i = par1World.getBlockMetadata(par2, par3, par4);

			if (i < 1)
			{
				float f = getGrowth(par1World, par2, par3, par4);

				if (par5Random.nextInt((int) (25F / f) + 1) == 0)
				{
					i++;
					par1World.setBlockMetadataWithNotify(par2, par3, par4, i, 2);
				}
			}
		}
	}

	/**
	 * Gets the growth rate for the crop. Setup to encourage rows by halving growth rate if there is diagonals, crops on
	 * different sides that aren't opposing, and by adding growth for every crop next to this one (and for crop below
	 * this one). Args: x, y, z
	 */
	private float getGrowth(World p_149864_1_, int p_149864_2_, int p_149864_3_, int p_149864_4_)
	{
		float f = 1.0F;
		Block block = p_149864_1_.getBlock(p_149864_2_, p_149864_3_, p_149864_4_ - 1);
		Block block1 = p_149864_1_.getBlock(p_149864_2_, p_149864_3_, p_149864_4_ + 1);
		Block block2 = p_149864_1_.getBlock(p_149864_2_ - 1, p_149864_3_, p_149864_4_);
		Block block3 = p_149864_1_.getBlock(p_149864_2_ + 1, p_149864_3_, p_149864_4_);
		Block block4 = p_149864_1_.getBlock(p_149864_2_ - 1, p_149864_3_, p_149864_4_ - 1);
		Block block5 = p_149864_1_.getBlock(p_149864_2_ + 1, p_149864_3_, p_149864_4_ - 1);
		Block block6 = p_149864_1_.getBlock(p_149864_2_ + 1, p_149864_3_, p_149864_4_ + 1);
		Block block7 = p_149864_1_.getBlock(p_149864_2_ - 1, p_149864_3_, p_149864_4_ + 1);
		boolean flag = block2 == this || block3 == this;
		boolean flag1 = block == this || block1 == this;
		boolean flag2 = block4 == this || block5 == this || block6 == this || block7 == this;

		for (int l = p_149864_2_ - 1; l <= p_149864_2_ + 1; ++l)
		{
			for (int i1 = p_149864_4_ - 1; i1 <= p_149864_4_ + 1; ++i1)
			{
				float f1 = 0.0F;

				if (p_149864_1_.getBlock(l, p_149864_3_ - 1, i1).canSustainPlant(p_149864_1_, l, p_149864_3_ - 1, i1, ForgeDirection.UP, this))
				{
					f1 = 1.0F;

					if (p_149864_1_.getBlock(l, p_149864_3_ - 1, i1).isFertile(p_149864_1_, l, p_149864_3_ - 1, i1))
					{
						f1 = 3.0F;
					}
				}

				if (l != p_149864_2_ || i1 != p_149864_4_)
				{
					f1 /= 4.0F;
				}

				f += f1;
			}
		}

		if (flag2 || flag && flag1)
		{
			f /= 2.0F;
		}

		return f;
	}

	/**
	 * The type of render function that is called for this block
	 */

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> ret = super.getDrops(world, x, y, z, metadata, fortune);

		if (metadata > 0)
		{
			ret.add(new ItemStack(Items.rotten_flesh));
		}
		if (world.rand.nextInt(2) == 0)
		{
			ret.add(new ItemStack(ModItems.rottenseed));
		}

		return ret;
	}
	
	@Override
	public boolean func_149851_a(World world, int x, int y, int z, boolean p_149851_5_)
	{
		if(world.getBlockMetadata(x, y, z) < 1)
			return true;
		else
			return false;
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
		world.setBlockMetadataWithNotify(x, y, z, 1, 2);
	}
}