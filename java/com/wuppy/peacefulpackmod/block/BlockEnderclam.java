package com.wuppy.peacefulpackmod.block;

import com.wuppy.peacefulpackmod.PeacefulPack;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

public class BlockEnderclam extends Block
{
	private final String name = "enderclam";

	public BlockEnderclam()
	{
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(PeacefulPack.modid + "_" + name);

		setStepSound(soundTypeStone);
		setLightLevel(0.8F);
		setHardness(3F);
		setResistance(1.0F);

		setCreativeTab(PeacefulPack.ppBlocksTab);
	}

	public String getName()
	{
		return name;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Items.ender_pearl;
	}

	@Override
	public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune)
	{
		Random rand = world instanceof World ? ((World) world).rand : new Random();

		return MathHelper.getRandomIntegerInRange(rand, 3, 7);
	}
}