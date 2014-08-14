package com.wuppy.tutorial;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTutorial extends Item
{
	public ItemTutorial()
	{
		setUnlocalizedName(Reference.MODID + "_" + "tutorialItem");
		setTextureName(Reference.MODID + ":" + "tutorialItem");
		setCreativeTab(CreativeTabs.tabMisc);
	}
}