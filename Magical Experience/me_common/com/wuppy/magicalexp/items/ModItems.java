package com.wuppy.magicalexp.items;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

import com.wuppy.magicalexp.MagicalExperience;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems
{
	public static Item components;
    public static Item xpbottlexl;
    public static Item thunderbottle;
    public static Item tntbottle;
    public static Item fuelbottle;
    public static Item exppick;
    public static Item expaxe;
    public static Item expshovel;
    public static Item expsword;
    public static Item exphoe;
    public static Item clusterbottle;
    public static Item thunderstaff;
    public static Item firestaff;
    public static Item earthstaff;
    public static Item firebottle;
    public static Item dirtbottle;
    public static Item bonebottle;
    public static Item airbottle;
    
    static ToolMaterial STAFF = EnumHelper.addToolMaterial("STAFF", 1, 500, 7F, 1, 14);
    static ToolMaterial experion = EnumHelper.addToolMaterial("experion", 2, 500, 7F, 2, 14);

	public static void loadItems()
	{
		//items
		components = new ItemMagicalComponents().setUnlocalizedName("components");
    	xpbottlexl = new ItemXPbottlexl().setUnlocalizedName("xpbottlexl").setTextureName(MagicalExperience.modid + ":" + "xpbottlexl");
    	thunderbottle = new ItemThunderbottle().setUnlocalizedName("thunderbottle").setTextureName(MagicalExperience.modid + ":" + "thunderbottle");
    	tntbottle = new ItemTntbottle().setUnlocalizedName("tntbottle").setTextureName(MagicalExperience.modid + ":" + "tntbottle");
    	fuelbottle = new ItemFuelbottle().setUnlocalizedName("fuelbottle").setTextureName(MagicalExperience.modid + ":" + "fuelbottle");
    	exppick = new ItemPickaxeExperion(experion).setUnlocalizedName("exppick").setTextureName(MagicalExperience.modid + ":" + "exppick");
    	expaxe = new ItemAxeExperion(experion).setUnlocalizedName("expaxe").setTextureName(MagicalExperience.modid + ":" + "expaxe");
    	expshovel = new ItemShovelExperion(experion).setUnlocalizedName("expshovel").setTextureName(MagicalExperience.modid + ":" + "expshovel");
    	expsword = new ItemSwordExperion(experion).setUnlocalizedName("expsword").setTextureName(MagicalExperience.modid + ":" + "expsword");
    	exphoe = new ItemHoeExperion(experion).setUnlocalizedName("exphoe").setTextureName(MagicalExperience.modid + ":" + "exphoe");
    	clusterbottle = new ItemClusterBottle().setUnlocalizedName("clusterbottle").setTextureName(MagicalExperience.modid + ":" + "clusterbottle");
    	thunderstaff = new ItemThunderStaff(STAFF).setUnlocalizedName("thunderstaff").setTextureName(MagicalExperience.modid + ":" + "thunderstaff");
    	firestaff = new ItemFireStaff(STAFF).setUnlocalizedName("firestaff").setTextureName(MagicalExperience.modid + ":" + "firestaff");
    	earthstaff = new ItemEarthStaff(STAFF).setUnlocalizedName("earthstaff").setTextureName(MagicalExperience.modid + ":" + "earthstaff");
    	firebottle = new ItemFireBottle().setUnlocalizedName("firebottle").setTextureName(MagicalExperience.modid + ":" + "firebottle");
    	dirtbottle = new ItemDirtBottle().setUnlocalizedName("dirtbottle").setTextureName(MagicalExperience.modid + ":" + "dirtbottle");
    	bonebottle = new ItemBonemealBottle().setUnlocalizedName("bonebottle").setTextureName(MagicalExperience.modid + ":" + "bonebottle");
    	airbottle = new ItemAirBottle().setUnlocalizedName("airbottle").setTextureName(MagicalExperience.modid + ":" + "airbottle");
    	
    	//registry
    	GameRegistry.registerItem(components, "Wuppy29_components");
    	GameRegistry.registerItem(xpbottlexl, "Wuppy29_xpbottlexl");
    	GameRegistry.registerItem(thunderbottle, "Wuppy29_thunderbottle");
    	GameRegistry.registerItem(tntbottle, "Wuppy29_tntbottle");
    	GameRegistry.registerItem(fuelbottle, "Wuppy29_fuelbottle");
    	GameRegistry.registerItem(exppick, "Wuppy29_exppick");
    	GameRegistry.registerItem(expaxe, "Wuppy29_expaxe");
    	GameRegistry.registerItem(expshovel, "Wuppy29_expshovel");
    	GameRegistry.registerItem(expsword, "Wuppy29_expsword");
    	GameRegistry.registerItem(exphoe, "Wuppy29_exphoe");
    	GameRegistry.registerItem(clusterbottle, "Wuppy29_clusterbottle");
    	GameRegistry.registerItem(thunderstaff, "Wuppy29_thunderstaff");
    	GameRegistry.registerItem(firestaff, "Wuppy29_firestaff");
    	GameRegistry.registerItem(earthstaff, "Wuppy29_earthstaff");
    	GameRegistry.registerItem(firebottle, "Wuppy29_firebottle");
    	GameRegistry.registerItem(dirtbottle, "Wuppy29_dirtbottle");
    	GameRegistry.registerItem(bonebottle, "Wuppy29_bonebottle");
    	GameRegistry.registerItem(airbottle, "Wuppy29_airbottle");
    	
    	//oredict
    	OreDictionary.registerOre("nuggetIron", new ItemStack(components, 1, 4));
	}
}