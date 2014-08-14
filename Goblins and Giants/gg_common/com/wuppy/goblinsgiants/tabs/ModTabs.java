package com.wuppy.goblinsgiants.tabs;

import net.minecraft.creativetab.CreativeTabs;

public class ModTabs
{
	public static CreativeTabs ggWeaponsTab = new GoblinGiantTab(CreativeTabs.getNextID(), "gg_weapons");
	public static CreativeTabs ggBlocksTab = new GoblinGiantTab(CreativeTabs.getNextID(), "gg_blocks");
	public static CreativeTabs ggMaterialTab = new GoblinGiantTab(CreativeTabs.getNextID(), "gg_materials");
	public static CreativeTabs ggMiscTab = new GoblinGiantTab(CreativeTabs.getNextID(), "gg_misc");
}