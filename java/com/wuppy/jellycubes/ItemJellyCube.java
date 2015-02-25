package com.wuppy.jellycubes;

import net.minecraft.item.ItemFood;

public class ItemJellyCube extends ItemFood
{
	public ItemJellyCube(int heal, float sat, boolean wolf)
	{
		super(heal, sat, wolf);
		setAlwaysEdible();
	}
}