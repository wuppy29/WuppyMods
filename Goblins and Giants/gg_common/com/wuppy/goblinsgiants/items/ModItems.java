package com.wuppy.goblinsgiants.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;


import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems
{
	public static Item component;
	public static Item bonespear;
	public static Item uruksword;
	public static Item woodpoisonsword;
	public static Item stonepoisonsword;
	public static Item ironpoisonsword;
	public static Item goldpoisonsword;
	public static Item diamondpoisonsword;
	public static Item key;
	public static Item cookedredcactus;
	public static Item gem;
	public static Item waterhoe;
	public static Item creeperbow;
	public static Item portalPlacer;
	public static Item dagger;

	public static void init()
	{
		component = new ItemComponent();
		bonespear = new ItemBoneSpear();
		uruksword = new ItemUrukSword(ModMaterials.uruk);
		woodpoisonsword = new ItemPoisonSword(ModMaterials.woodpoison, Items.wooden_sword, "wood poison");
		stonepoisonsword = new ItemPoisonSword(ModMaterials.stonepoison, Items.stone_sword, "stone poison");
		ironpoisonsword = new ItemPoisonSword(ModMaterials.ironpoison, Items.iron_sword, "iron poison");
		goldpoisonsword = new ItemPoisonSword(ModMaterials.goldpoison, Items.golden_sword, "gold poison");
		diamondpoisonsword = new ItemPoisonSword(ModMaterials.diamondpoison, Items.diamond_sword, "diamond poison");
		key = new ItemKey();
		cookedredcactus = new ItemGoblinFood(6, 0.6F, false, "redcactusfood");
		gem = new ItemGem();
		waterhoe = new ItemWaterHoe(ModMaterials.waterhoematerial);
		creeperbow = new ItemCreeperBow();
		portalPlacer = new ItemPortalPlacer();
		dagger = new ItemDagger(ModMaterials.daggermaterial);

		GameRegistry.registerItem(component, "Wuppy29_component");
		GameRegistry.registerItem(bonespear, "Wuppy29_bonespear");
		GameRegistry.registerItem(uruksword, "Wuppy29_uruksword");
		GameRegistry.registerItem(woodpoisonsword, "Wuppy29_woodpoisonsword");
		GameRegistry.registerItem(stonepoisonsword, "Wuppy29_stonepoisonsword");
		GameRegistry.registerItem(ironpoisonsword, "Wuppy29_ironpoisonsword");
		GameRegistry.registerItem(goldpoisonsword, "Wuppy29_goldpoisonsword");
		GameRegistry.registerItem(diamondpoisonsword, "Wuppy29_diamondpoisonsword");
		GameRegistry.registerItem(key, "Wuppy29_key");
		GameRegistry.registerItem(cookedredcactus, "Wuppy29_cookedredcactus");
		GameRegistry.registerItem(gem, "Wuppy29_gem");
		GameRegistry.registerItem(waterhoe, "Wuppy29_waterhoe");
		GameRegistry.registerItem(creeperbow, "Wuppy29_creeperbow");
		GameRegistry.registerItem(portalPlacer, "Wuppy29_portalPlacer");
		GameRegistry.registerItem(dagger, "Wuppy29_dagger");
	}
}