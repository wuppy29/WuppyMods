package com.wuppy.frozen.items;

import net.minecraft.item.ItemSword;

import com.wuppy.frozen.FrozenCraft;

public class ItemHansSword extends ItemSword
{
	public ItemHansSword()
	{
		super(FrozenCraft.gearMaterial);
		setUnlocalizedName("hansSword");
		setTextureName(FrozenCraft.modid + ":" + getUnlocalizedName().substring(5));
	}
}