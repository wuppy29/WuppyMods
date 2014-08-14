package com.wuppy.frozen.items;

import com.wuppy.frozen.handlers.RegisterHelper;

import net.minecraft.item.Item;

public class ModItems
{
	//standard item objects
	public static Item frozenHeart;
	public static Item iceSaw;
	public static Item elsaGlove;
	public static Item hansSword;
	public static Item kristoffPickaxe;
	
	//armor item objects
	public static Item elsaTiara;
	public static Item elsaBodice;
	public static Item elsaSkirt;
	public static Item elsaHeels;
	
	public static Item annaCap;
	public static Item annaBodice;
	public static Item annaSkirt;
	public static Item annaBoots;
	
	public static Item kristoffCap;
	public static Item kristoffJacket;
	public static Item kristoffPants;
	public static Item kristoffBoots;
	
	public static Item hansHair;
	public static Item hansTop;
	public static Item hansPants;
	public static Item hansBoots;
	
	public static void loadItems()
	{
		//standard item init
		frozenHeart = new ItemFrozenHeart();
		iceSaw = new ItemIceSaw();
		elsaGlove = new ItemElsaGlove();
		hansSword = new ItemHansSword();
		kristoffPickaxe = new ItemKristoffPickaxe();
		
		//armor item init
		elsaTiara = new ItemElsaArmor(ModMaterials.elsa, 0, "elsaTiara");
		elsaBodice = new ItemElsaArmor(ModMaterials.elsa, 1, "elsaBodice");
		elsaSkirt = new ItemElsaArmor(ModMaterials.elsa, 2, "elsaSkirt");
		elsaHeels = new ItemElsaArmor(ModMaterials.elsa, 3, "elsaHeels");
		
		annaCap = new ItemAnnaArmor(ModMaterials.anna, 0, "annaCap");
		annaBodice = new ItemAnnaArmor(ModMaterials.anna, 1, "annaBodice");
		annaSkirt = new ItemAnnaArmor(ModMaterials.anna, 2, "annaSkirt");
		annaBoots = new ItemAnnaArmor(ModMaterials.anna, 3, "annaBoots");
		
		kristoffCap = new ItemKristoffArmor(ModMaterials.kristoff, 0, "kristoffCap");
		kristoffJacket = new ItemKristoffArmor(ModMaterials.kristoff, 1, "kristoffJacket");
		kristoffPants = new ItemKristoffArmor(ModMaterials.kristoff, 2, "kristoffPants");
		kristoffBoots = new ItemKristoffArmor(ModMaterials.kristoff, 3, "kristoffBoots");
		
		hansHair = new ItemHansArmor(ModMaterials.hans, 0, "hansHair");
		hansTop = new ItemHansArmor(ModMaterials.hans, 1, "hansTop");
		hansPants = new ItemHansArmor(ModMaterials.hans, 2, "hansPants");
		hansBoots = new ItemHansArmor(ModMaterials.hans, 3, "hansBoots");
		
		//standard item registry
		RegisterHelper.registerItem(frozenHeart);
		RegisterHelper.registerItem(iceSaw);
		RegisterHelper.registerItem(elsaGlove);
		RegisterHelper.registerItem(hansSword);
		RegisterHelper.registerItem(kristoffPickaxe);
		
		//armor item registry
		RegisterHelper.registerItem(elsaTiara);
		RegisterHelper.registerItem(elsaBodice);
		RegisterHelper.registerItem(elsaSkirt);
		RegisterHelper.registerItem(elsaHeels);
		
		RegisterHelper.registerItem(annaCap);
		RegisterHelper.registerItem(annaBodice);
		RegisterHelper.registerItem(annaSkirt);
		RegisterHelper.registerItem(annaBoots);
		
		RegisterHelper.registerItem(kristoffCap);
		RegisterHelper.registerItem(kristoffJacket);
		RegisterHelper.registerItem(kristoffPants);
		RegisterHelper.registerItem(kristoffBoots);
		
		RegisterHelper.registerItem(hansHair);
		RegisterHelper.registerItem(hansTop);
		RegisterHelper.registerItem(hansPants);
		RegisterHelper.registerItem(hansBoots);
	}
}