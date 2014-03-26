package com.wuppy.magicalexp;

import java.io.IOException;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;

import com.wuppy.magicalexp.entity.EntityBonemealBottle;
import com.wuppy.magicalexp.entity.EntityClusterBottle;
import com.wuppy.magicalexp.entity.EntityDirtBottle;
import com.wuppy.magicalexp.entity.EntityExpBottlexl;
import com.wuppy.magicalexp.entity.EntityFirebottle;
import com.wuppy.magicalexp.entity.EntityMagicThunder;
import com.wuppy.magicalexp.entity.EntityThunderbottle;
import com.wuppy.magicalexp.entity.EntityTntbottle;
import com.wuppy.magicalexp.items.ItemAirBottle;
import com.wuppy.magicalexp.items.ItemAxeExperion;
import com.wuppy.magicalexp.items.ItemBonemealBottle;
import com.wuppy.magicalexp.items.ItemClusterBottle;
import com.wuppy.magicalexp.items.ItemDirtBottle;
import com.wuppy.magicalexp.items.ItemEarthStaff;
import com.wuppy.magicalexp.items.ItemFireBottle;
import com.wuppy.magicalexp.items.ItemFireStaff;
import com.wuppy.magicalexp.items.ItemFuelbottle;
import com.wuppy.magicalexp.items.ItemHoeExperion;
import com.wuppy.magicalexp.items.ItemMagicalComponents;
import com.wuppy.magicalexp.items.ItemMagicalOresblock;
import com.wuppy.magicalexp.items.ItemPickaxeExperion;
import com.wuppy.magicalexp.items.ItemShovelExperion;
import com.wuppy.magicalexp.items.ItemSpellBlock;
import com.wuppy.magicalexp.items.ItemSwordExperion;
import com.wuppy.magicalexp.items.ItemThunderStaff;
import com.wuppy.magicalexp.items.ItemThunderbottle;
import com.wuppy.magicalexp.items.ItemTntbottle;
import com.wuppy.magicalexp.items.ItemXPbottlexl;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = MagicalExperience.modid, name = "Magical Experience", version = "1.1.4.2")
public class MagicalExperience 
{
	public static final String modid = "wuppy29_magicalexperience";
	
	public static final int VERSION = 2;
	public static String updates = "";
	public static boolean outdated = false;
	
	@SidedProxy(clientSide = "com.wuppy.magicalexp.ClientProxyMagic", serverSide = "com.wuppy.magicalexp.CommonProxyMagic")
    public static CommonProxyMagic proxy;
	
	public static Block expore;
    public static Block spell;
	
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
    
    public static boolean checkForUpdates = true;
    
    static ToolMaterial STAFF = EnumHelper.addToolMaterial("STAFF", 1, 500, 7F, 1, 14);
    static ToolMaterial experion = EnumHelper.addToolMaterial("experion", 2, 500, 7F, 2, 14);
    
    @EventHandler
	public void load(FMLPreInitializationEvent event)
    {
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		checkForUpdates = config.get(Configuration.CATEGORY_GENERAL, "Check Updates", true).getBoolean(true);
		
		config.save();
		
		if (checkForUpdates)
		{
			try
			{
				UpdateChecker.checkForUpdates();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
    	FMLCommonHandler.instance().bus().register(this);
		//other
		proxy.registerEntityRender();
		
		GameRegistry.registerFuelHandler(new MagicFuel());
		
		GameRegistry.registerWorldGenerator(new MagicGenerater(), 0);
		
		//blocks
    	expore = new BlockExp().setHardness(3F).setResistance(1.0F).setBlockName("expore");
    	spell = new BlockSpell(BlockPressurePlate.Sensitivity.everything, Material.wood).setHardness(0.5F).setStepSound(Block.soundTypeWood).setBlockName("spell");
		
    	GameRegistry.registerBlock(expore, ItemMagicalOresblock.class, "expore");
    	GameRegistry.registerBlock(spell, ItemSpellBlock.class, "spell");
		
		//items
    	components = new ItemMagicalComponents().setUnlocalizedName("components");
    	xpbottlexl = new ItemXPbottlexl().setUnlocalizedName("xpbottlexl").setTextureName(modid + ":" + "xpbottlexl");
    	thunderbottle = new ItemThunderbottle().setUnlocalizedName("thunderbottle").setTextureName(modid + ":" + "thunderbottle");
    	tntbottle = new ItemTntbottle().setUnlocalizedName("tntbottle").setTextureName(modid + ":" + "tntbottle");
    	fuelbottle = new ItemFuelbottle().setUnlocalizedName("fuelbottle").setTextureName(modid + ":" + "fuelbottle");
    	exppick = new ItemPickaxeExperion(experion).setUnlocalizedName("exppick").setTextureName(modid + ":" + "exppick");
    	expaxe = new ItemAxeExperion(experion).setUnlocalizedName("expaxe").setTextureName(modid + ":" + "expaxe");
    	expshovel = new ItemShovelExperion(experion).setUnlocalizedName("expshovel").setTextureName(modid + ":" + "expshovel");
    	expsword = new ItemSwordExperion(experion).setUnlocalizedName("expsword").setTextureName(modid + ":" + "expsword");
    	exphoe = new ItemHoeExperion(experion).setUnlocalizedName("exphoe").setTextureName(modid + ":" + "exphoe");
    	clusterbottle = new ItemClusterBottle().setUnlocalizedName("clusterbottle").setTextureName(modid + ":" + "clusterbottle");
    	thunderstaff = new ItemThunderStaff(STAFF).setUnlocalizedName("thunderstaff").setTextureName(modid + ":" + "thunderstaff");
    	firestaff = new ItemFireStaff(STAFF).setUnlocalizedName("firestaff").setTextureName(modid + ":" + "firestaff");
    	earthstaff = new ItemEarthStaff(STAFF).setUnlocalizedName("earthstaff").setTextureName(modid + ":" + "earthstaff");
    	firebottle = new ItemFireBottle().setUnlocalizedName("firebottle").setTextureName(modid + ":" + "firebottle");
    	dirtbottle = new ItemDirtBottle().setUnlocalizedName("dirtbottle").setTextureName(modid + ":" + "dirtbottle");
    	bonebottle = new ItemBonemealBottle().setUnlocalizedName("bonebottle").setTextureName(modid + ":" + "bonebottle");
    	airbottle = new ItemAirBottle().setUnlocalizedName("airbottle").setTextureName(modid + ":" + "airbottle");
    	
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
    	
    	EntityRegistry.registerModEntity(EntityExpBottlexl.class, "expbottlexl", 35, this, 40, 40, true);
    	EntityRegistry.registerModEntity(EntityThunderbottle.class, "thunderbottle", 36, this, 40, 40, true);
    	EntityRegistry.registerModEntity(EntityTntbottle.class, "tntbottle", 37, this, 40, 40, true);
    	EntityRegistry.registerModEntity(EntityClusterBottle.class, "clusterbottle", 38, this, 40, 40, true);
    	EntityRegistry.registerModEntity(EntityMagicThunder.class, "magicthunder", 39, this, 0, 40, true);
    	EntityRegistry.registerModEntity(EntityFirebottle.class, "firebottle", 40, this, 40, 40, true);
    	EntityRegistry.registerModEntity(EntityDirtBottle.class, "dirtbottle", 41, this, 40, 40, true);
    	EntityRegistry.registerModEntity(EntityBonemealBottle.class, "bonemealbottle", 42, this, 40, 40, true);
    	
    	//recipes
    	new MagicalRecipes();
    	
    	proxy.registerItemRender();
	}
    
    @SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		if(outdated)
		{
			event.player.addChatComponentMessage(new ChatComponentText("Magical Experience is outdated."));
			event.player.addChatComponentMessage(new ChatComponentText("Changelog: "));
			event.player.addChatComponentMessage(new ChatComponentText(updates));
		}
	}
}
