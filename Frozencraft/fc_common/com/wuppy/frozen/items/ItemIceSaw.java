package com.wuppy.frozen.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.wuppy.frozen.FrozenCraft;
import com.wuppy.frozen.blocks.ModBlocks;

public class ItemIceSaw extends ItemAxe
{
	protected ItemIceSaw()
	{
		super(FrozenCraft.iceSawMaterial);
		setUnlocalizedName("iceSaw");
		setTextureName(FrozenCraft.modid + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabMisc);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.block;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 72000;
	}

	@Override
	public boolean func_150897_b(Block block)
	{
		return block == Blocks.web;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		return true;
	}

	@Override
	public float getDigSpeed(ItemStack stack, Block block, int meta)
	{
		if (block == ModBlocks.hardIce)
			return 500F;

		return super.getDigSpeed(stack, block, meta);
	}
}