package com.wuppy.frozen.blocks;

import com.wuppy.frozen.FrozenCraft;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

public class BlockBoltObsidian extends BlockObsidian {
	private final String name = "obsidian";

	public BlockBoltObsidian() {
		super();
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(FrozenCraft.modid + "_" + name);
		setCreativeTab(null);
		setHardness(50.0F);
		setResistance(2000.0F);
		setStepSound(soundTypePiston);
	}

	public String getName() {
		return name;
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		world.setBlockState(new BlockPos(x, y, z), Blocks.obsidian.getDefaultState());
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(Blocks.obsidian);
	}
}