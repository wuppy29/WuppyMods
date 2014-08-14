package com.wuppy.frozen.items;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.wuppy.frozen.FrozenCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHansArmor extends ItemArmor
{
	public ItemHansArmor(ArmorMaterial material, int armorType, String name)
	{
		super(material, 0, armorType);
		setCreativeTab(FrozenCraft.fcArmor);
		setUnlocalizedName(name);
		setTextureName(FrozenCraft.modid + ":" + getUnlocalizedName().substring(5));
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == ModItems.hansHair)
		{
			return FrozenCraft.modid + ":models/armor/hansArmorHair.png";
		}
		else if(stack.getItem() == ModItems.hansTop)
		{
			return FrozenCraft.modid + ":models/armor/hansArmorTop.png";
		}
		else if(stack.getItem() == ModItems.hansPants)
		{
			return FrozenCraft.modid + ":models/armor/hansArmorPants.png";
		}
		else if(stack.getItem() == ModItems.hansBoots)
		{
			return FrozenCraft.modid + ":models/armor/hansArmorBoots.png";
		}
		else
		{
			System.out.println("Invalid Item ItemHansArmor");
			return null;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot)
	{
		ModelBiped armourModel = null;
		if (itemstack != null)
		{
			if (itemstack.getItem() instanceof ItemHansArmor && itemstack.getItem() != ModItems.hansHair)
			{
				float f = 0.12F;
				
				if(itemstack.getItem() == ModItems.hansTop)
					f = 0.15f;
				
				armourModel = new ModelBiped(f);
				ItemStack itemstack2 = ((EntityPlayer) entityLiving).inventory.getCurrentItem();
				armourModel.heldItemRight = itemstack2 != null ? 1 : 0;
				armourModel.isSneak = entityLiving.isSneaking();
				if (itemstack2 != null && ((EntityPlayer) entityLiving).getItemInUseCount() > 0)
				{
					EnumAction enumaction = itemstack2.getItemUseAction();
					if (enumaction == EnumAction.block)
					{
						armourModel.heldItemRight = 3;
					}
					else if (enumaction == EnumAction.bow)
					{
						armourModel.aimedBow = true;
					}
				}
			}
		}
		return armourModel;
	}
}