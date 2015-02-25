package com.wuppy.frozen.items;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.wuppy.frozen.FrozenCraft;

public class ItemKristoffArmor extends ItemArmor
{
	private String name;
	
	public ItemKristoffArmor(ArmorMaterial material, int armorType, String name)
	{
		super(material, 0, armorType);
		this.name = name;
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(FrozenCraft.modid + "_" + name);
		setCreativeTab(FrozenCraft.fcArmor);
	}
	
	public String getName()
	{
		return name;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == ModItems.kristoffCap)
		{
			return FrozenCraft.modid + ":models/armor/kristoffArmorCap.png";
		}
		else if(stack.getItem() == ModItems.kristoffJacket)
		{
			return FrozenCraft.modid + ":models/armor/kristoffArmorJacket.png";
		}
		else if(stack.getItem() == ModItems.kristoffPants)
		{
			return FrozenCraft.modid + ":models/armor/kristoffArmorPants.png";
		}
		else if(stack.getItem() == ModItems.kristoffBoots)
		{
			return FrozenCraft.modid + ":models/armor/kristoffArmorBoots.png";
		}
		else
		{
			System.out.println("Invalid Item ItemKristoffArmor");
			return null;
		}
	}
}