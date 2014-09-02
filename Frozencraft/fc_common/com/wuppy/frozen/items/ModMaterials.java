package com.wuppy.frozen.items;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterials
{
	public static ArmorMaterial elsa = EnumHelper.addArmorMaterial("elsa", 40, new int[]{4, 10, 7, 4}, 9);
	public static ArmorMaterial anna = EnumHelper.addArmorMaterial("anna", 33, new int[]{3, 9, 7, 4}, 9);
	public static ArmorMaterial kristoff = EnumHelper.addArmorMaterial("kristoff", 33, new int[]{3, 9, 7, 4}, 9);
	public static ArmorMaterial hans = EnumHelper.addArmorMaterial("hans", 20, new int[]{3, 8, 6, 3}, 9);
}