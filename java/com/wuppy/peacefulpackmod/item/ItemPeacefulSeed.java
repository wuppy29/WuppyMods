package com.wuppy.peacefulpackmod.item;

import com.wuppy.peacefulpackmod.PeacefulPack;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemPeacefulSeed extends Item implements IPlantable
{
	/**
	 * the type of block this seed turns into (wheat or pumpkin stems for instance)
	 */
	private Block blockType;

	/**
	 * BlockID of the block the seeds can be planted on.
	 */
	private Block soilBlock;

	private final String name;

	public ItemPeacefulSeed(Block block, Block soil, String name)
	{
		this.name = name;

		GameRegistry.registerItem(this, name);
		setUnlocalizedName(PeacefulPack.modid + "_" + name);

		blockType = block;
		soilBlock = soil;

		setCreativeTab(PeacefulPack.ppMaterialTab);
	}

	public String getName()
	{
		return name;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (side != EnumFacing.UP)
		{
			return false;
		}
		else if (!playerIn.canPlayerEdit(pos.offset(side), side, stack))
		{
			return false;
		}
		else if (worldIn.getBlockState(pos).getBlock() == soilBlock && worldIn.isAirBlock(pos.up()))
		{
			worldIn.setBlockState(pos.up(), this.blockType.getDefaultState());
			--stack.stackSize;
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos)
	{
		return blockType.getDefaultState();
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
	{
		return EnumPlantType.Crop;
	}
}
