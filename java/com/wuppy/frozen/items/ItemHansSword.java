package com.wuppy.frozen.items;

import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.wuppy.frozen.FrozenCraft;

public class ItemHansSword extends ItemSword
{
	private final String name = "hansSword";
	
	public ItemHansSword()
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