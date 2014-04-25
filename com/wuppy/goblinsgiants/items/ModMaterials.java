package com.wuppy.goblinsgiants.items;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterials
{
	public static ToolMaterial uruk = EnumHelper.addToolMaterial("uruk", 2, 250, 6.0F, 2, 14);
	
	public static ToolMaterial woodpoison = EnumHelper.addToolMaterial("woodpoison", 0, 60, 2.0F, 1, 15);
	public static ToolMaterial stonepoison = EnumHelper.addToolMaterial("stonepoison", 1, 60, 4.0F, 2, 5);
	public static ToolMaterial ironpoison = EnumHelper.addToolMaterial("ironpoison", 2, 60, 6.0F, 3, 14);
	public static ToolMaterial goldpoison = EnumHelper.addToolMaterial("goldpoison", 0, 60, 12.0F, 1, 22);
	public static ToolMaterial diamondpoison = EnumHelper.addToolMaterial("diamondpoison", 3, 60, 8.0F, 4, 10);
	
	public static ToolMaterial waterhoematerial = EnumHelper.addToolMaterial("waterhoematerial", 2, 500, 7F, 2, 14);
	public static ToolMaterial daggermaterial = EnumHelper.addToolMaterial("daggermaterial", 2, 250, 3.0F, 2.0F, 14);
}