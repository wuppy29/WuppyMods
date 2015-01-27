package com.wuppy.frozen.items;

import com.wuppy.frozen.FrozenCraft;

import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemKristoffPickaxe extends ItemPickaxe
{
	private final String name = "kristoffPickaxe";
	
	public ItemKristoffPickaxe()
	{
		super(FrozenCraft.gearMaterial);
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(FrozenCraft.modid + "_" + name);
	}
	
	public String getName()
	{
		return name;
	}
}