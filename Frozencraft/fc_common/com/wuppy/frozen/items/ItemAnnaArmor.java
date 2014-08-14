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

public class ItemAnnaArmor extends ItemArmor
{
	public ItemAnnaArmor(ArmorMaterial material, int armorType, String name)
	{
		super(material, 0, armorType);
		setCreativeTab(FrozenCraft.fcArmor);
		setUnlocalizedName(name);
		setTextureName(FrozenCraft.modid + ":" + getUnlocalizedName().substring(5));
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == ModItems.annaCap)
		{
			return FrozenCraft.modid + ":models/armor/annaArmorCap.png";
		}
		else if(stack.getItem() == ModItems.annaBodice)
		{
			return FrozenCraft.modid + ":models/armor/annaArmorBodice.png";
		}
		else if(stack.getItem() == ModItems.annaSkirt)
		{
			return FrozenCraft.modid + ":models/armor/annaArmorSkirt.png";
		}
		else if(stack.getItem() == ModItems.annaBoots)
		{
			return FrozenCraft.modid + ":models/armor/annaArmorBoots.png";
		}
		else
		{
			System.out.println("Invalid Item ItemAnnaArmor");
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
			if (itemstack.getItem() instanceof ItemAnnaArmor && itemstack.getItem() != ModItems.annaCap)
			{
				float f = 0.12F;
				
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