package com.wuppy.frozen.items;

import com.wuppy.frozen.FrozenCraft;

import net.minecraft.item.ItemPickaxe;

public class ItemKristoffPickaxe extends ItemPickaxe
{
	protected ItemKristoffPickaxe()
	{
		super(FrozenCraft.gearMaterial);
		setUnlocalizedName("kristoffPickaxe");
		setTextureName(FrozenCraft.modid + ":" + getUnlocalizedName().substring(5));
	}
}