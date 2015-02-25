package com.wuppy.frozen.items;

import com.wuppy.frozen.FrozenCraft;
import com.wuppy.frozen.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemIceSaw extends ItemAxe {
	private final String name = "iceSaw";

	public ItemIceSaw() {
		super(FrozenCraft.iceSawMaterial);
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(FrozenCraft.modid + "_" + name);
		setCreativeTab(CreativeTabs.tabMisc);
	}

	public String getName() {
		return name;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.BLOCK;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 72000;
	}

	@Override
	public boolean canHarvestBlock(Block block) {
		return block == Blocks.web;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		return true;
	}

	@Override
	public float getStrVsBlock(ItemStack stack, Block block) {
		if (block == ModBlocks.hardIce)
			return 500F;

		return super.getStrVsBlock(stack, block);
	}
}