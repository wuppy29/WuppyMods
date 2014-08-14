package com.wuppy.peacefulpackmod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.wuppy.peacefulpackmod.PeacefulPack;

public class BlockBuriedRemains extends Block
{
	public BlockBuriedRemains()
	{
		super(Material.ground);
		setCreativeTab(PeacefulPack.ppBlocksTab);
		setStepSound(soundTypeGravel);
		setHardness(0.5F);
		setBlockName("remains");
		setBlockTextureName(PeacefulPack.modid + ":" + "remains");
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
		return Items.rotten_flesh;
	}
}
