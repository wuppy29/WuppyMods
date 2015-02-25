package com.wuppy.frozen.blocks;

import com.wuppy.frozen.FrozenCraft;
import com.wuppy.frozen.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

public class BlockHardIce extends Block
{
	private final String name = "hardIce";

	public BlockHardIce()
	{
		super(Material.ice);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(FrozenCraft.modid + "_" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(500F);
		setLightOpacity(3);
		setStepSound(soundTypeGlass);
	}

	public String getName()
	{
		return name;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		if (rand.nextInt(20) == 0)
			return ModItems.frozenHeart;
		else
			return null;
	}

	@Override
	public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player)
	{
		return player.getHeldItem().getItem() == ModItems.iceSaw;
	}
}