package com.wuppy.peacefulpackmod.block;

import com.wuppy.peacefulpackmod.PeacefulPack;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

public class BlockRemains extends Block
{
	private final String name = "remains";

	public BlockRemains()
	{
		super(Material.ground);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(PeacefulPack.modid + "_" + name);

		setStepSound(soundTypeGravel);
		setHardness(0.5F);

		setCreativeTab(PeacefulPack.ppBlocksTab);
	}

	public String getName()
	{
		return name;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Items.rotten_flesh;
	}
}