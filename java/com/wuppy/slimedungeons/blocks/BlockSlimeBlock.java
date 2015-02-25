package com.wuppy.slimedungeons.blocks;

import com.wuppy.slimedungeons.SlimeDungeon;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

public class BlockSlimeBlock extends Block {
	private final String name = "slimeblock";

	public BlockSlimeBlock() {
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(soundTypeStone);
		setHardness(3F);
		setResistance(1.0F);
		setUnlocalizedName(SlimeDungeon.MODID + "_" + name);
	}

	public String getName() {
		return name;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.slime_ball;
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return 2;
	}
}