package com.wuppy.goblinsgiants.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.wuppy.goblinsgiants.GoblinGiant;
import com.wuppy.goblinsgiants.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRedCactus extends BlockCactus
{
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public BlockRedCactus()
	{
		super();
		this.setCreativeTab(ModTabs.ggBlocksTab);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		icons = new IIcon[3];

		for (int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(GoblinGiant.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
		}
	}

	@Override
	public IIcon getIcon(int par1, int par2)
	{
		if (par1 == 0)
			return icons[0];
		else if (par1 == 1)
			return icons[1];
		else
			return icons[2];
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been cleared to be reused)
	 */
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		float f = 0.0625F;
		return AxisAlignedBB.getAABBPool().getAABB((double) ((float) par2 + f), (double) par3, (double) ((float) par4 + f), (double) ((float) (par2 + 1) - f), (double) ((float) (par3 + 1) - f), (double) ((float) (par4 + 1) - f));
	}

	/**
	 * Can this block stay at this position. Similar to canPlaceBlockAt except gets checked often with plants.
	 */
	@Override
	public boolean canBlockStay(World par1World, int par2, int par3, int par4)
	{
		if (par1World.getBlock(par2 - 1, par3, par4).getMaterial().isSolid())
		{
			return false;
		}
		else if (par1World.getBlock(par2 + 1, par3, par4).getMaterial().isSolid())
		{
			return false;
		}
		else if (par1World.getBlock(par2, par3, par4 - 1).getMaterial().isSolid())
		{
			return false;
		}
		else if (par1World.getBlock(par2, par3, par4 + 1).getMaterial().isSolid())
		{
			return false;
		}
		else
		{
			Block var5 = par1World.getBlock(par2, par3 - 1, par4);
			return var5 == this || var5 == Blocks.sand;
		}
	}
}