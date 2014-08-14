package com.wuppy.goblinsgiants.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.wuppy.goblinsgiants.GoblinGiant;
import com.wuppy.goblinsgiants.render.RenderCustomWood;
import com.wuppy.goblinsgiants.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCustomWood extends Block
{
	public BlockCustomWood()
	{
		super(Material.wood);
		setHardness(2.0F);
		setStepSound(soundTypeWood);
		setBlockName("customwood");
		setCreativeTab(ModTabs.ggBlocksTab);
		setHarvestLevel("axe", 1);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		setBlockBounds(0.33f, 0.33f, 0.33f, 0.66f, 0.66f, 0.66f);
	}

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
	public int getRenderType()
	{
		return RenderCustomWood.renderId;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return true;
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return Items.stick;
	}

	/**
	 * ejects contained items into the world, and notifies neighbours of an update, as appropriate
	 */
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta)
    {
        byte b0 = 4;
        int i1 = b0 + 1;

        if (world.checkChunksExist(x - i1, y - i1, z - i1, x + i1, y + i1, z + i1))
        {
            for (int j1 = -b0; j1 <= b0; ++j1)
            {
                for (int k1 = -b0; k1 <= b0; ++k1)
                {
                    for (int l1 = -b0; l1 <= b0; ++l1)
                    {
                        Block blockleave = world.getBlock(x + j1, y + k1, z + l1);
                        if (blockleave.isLeaves(world, x + j1, y + k1, z + l1))
                        {
                            blockleave.beginLeavesDecay(world, x + j1, y + k1, z + l1);
                        }
                    }
                }
            }
        }
    }

	@SideOnly(Side.CLIENT)
	@Override
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		blockIcon = par1IconRegister.registerIcon(GoblinGiant.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}