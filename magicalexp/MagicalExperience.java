package magicalexp;

import java.io.IOException;

import magicalexp.entity.EntityBonemealBottle;
import magicalexp.entity.EntityClusterBottle;
import magicalexp.entity.EntityDirtBottle;
import magicalexp.entity.EntityExpBottlexl;
import magicalexp.entity.EntityFirebottle;
import magicalexp.entity.EntityMagicThunder;
import magicalexp.entity.EntityThunderbottle;
import magicalexp.entity.EntityTntbottle;
import magicalexp.items.ItemAirBottle;
import magicalexp.items.ItemAxeExperion;
import magicalexp.items.ItemBonemealBottle;
import magicalexp.items.ItemClusterBottle;
import magicalexp.items.ItemDirtBottle;
import magicalexp.items.ItemEarthStaff;
import magicalexp.items.ItemFireBottle;
import magicalexp.items.ItemFireStaff;
import magicalexp.items.ItemFuelbottle;
import magicalexp.items.ItemHoeExperion;
import magicalexp.items.ItemMagicalComponents;
import magicalexp.items.ItemMagicalOresblock;
import magicalexp.items.ItemPickaxeExperion;
import magicalexp.items.ItemShovelExperion;
import magicalexp.items.ItemSpellBlock;
import magicalexp.items.ItemSwordExperion;
import magicalexp.items.ItemThunderStaff;
import magicalexp.items.ItemThunderbottle;
import magicalexp.items.ItemTntbottle;
import magicalexp.items.ItemXPbottlexl;
import net.minecraft.block.Block;
import net.minecraft.block.EnumMobType;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = MagicalExperience.modid, name = "Magical Experience", version = "1.1.4.1b")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MagicalExperience 
{
	public static final String modid = "wuppy29_magicalexperience";
	
	public static final int VERSION = 2;
	public static String updates = "";
	public static boolean outdated = false;
	
	@SidedProxy(clientSide = "magicalexp.ClientProxyMagic", serverSide = "magicalexp.CommonProxyMagic")
    public static CommonProxyMagic proxy;
	
	//blocks
	public static int exporeID;
	public static int SpellID;
		
	//items
	public static int ComponentItemsID;
	public static int xpbottlexlID;
	public static int AirBottleID;
	public static int thunderbottleID;
	public static int tntbottleID;
	public static int fuelbottleID;
	public static int ExperionPickaxeID;
	public static int ExperionAxeID;
	public static int ExperionShovelID;
	public static int ExperionSwordID;
	public static int ExperionHoeID;
	public static int ClusterBottleID;
	public static int ThunderStaffID;
	public static int FireStaffID;
	public static int EarthStaffID;
	public static int FireBottleID;
	public static int DirtBottleID;
	public static int BonemealBottleID;
	
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
    
    static EnumToolMaterial STAFF = EnumHelper.addToolMaterial("STAFF", 1, 500, 7F, 1, 14);
    static EnumToolMaterial experion = EnumHelper.addToolMaterial("experion", 2, 500, 7F, 2, 14);
    
    @EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		exporeID = config.getBlock("Experience Ore ID", Configuration.CATEGORY_BLOCK, 304).getInt();
		SpellID = config.getBlock("Spell Blocks ID", Configuration.CATEGORY_BLOCK, 305).getInt();
		
		ComponentItemsID = config.getItem("Components ID", Configuration.CATEGORY_ITEM, 4017).getInt();
		xpbottlexlID = config.getItem("Large Experience Bottle ID", Configuration.CATEGORY_ITEM, 4018).getInt();
		AirBottleID = config.getItem("Air Bottle ID", Configuration.CATEGORY_ITEM, 4019).getInt();
		thunderbottleID = config.getItem("Thunder Bottle ID", Configuration.CATEGORY_ITEM, 4020).getInt();
		tntbottleID = config.getItem("Tnt Bottle ID", Configuration.CATEGORY_ITEM, 4021).getInt();
		fuelbottleID = config.getItem("Fuel Bottle ID", Configuration.CATEGORY_ITEM, 4022).getInt();
		ExperionPickaxeID = config.getItem("Experion Pickaxe ID", Configuration.CATEGORY_ITEM, 4023).getInt();
		ExperionAxeID = config.getItem("Experion Axe ID", Configuration.CATEGORY_ITEM, 4024).getInt();
		ExperionShovelID = config.getItem("Experion Shovel ID", Configuration.CATEGORY_ITEM, 4025).getInt();
		ExperionSwordID = config.getItem("Experion Sword ID", Configuration.CATEGORY_ITEM, 4026).getInt();
		ExperionHoeID = config.getItem("Experion Hoe ID", Configuration.CATEGORY_ITEM, 4027).getInt();
		ClusterBottleID = config.getItem("Cluster Bottle ID", Configuration.CATEGORY_ITEM, 4028).getInt();
		ThunderStaffID = config.getItem("Thunder Staff ID", Configuration.CATEGORY_ITEM, 4029).getInt();
		FireStaffID = config.getItem("Fire Staff ID", Configuration.CATEGORY_ITEM, 4030).getInt();
		EarthStaffID = config.getItem("Earth Staff ID", Configuration.CATEGORY_ITEM, 4031).getInt();
		FireBottleID = config.getItem("Fire Bottle ID", Configuration.CATEGORY_ITEM, 4032).getInt();
		DirtBottleID = config.getItem("Dirt Bottle ID", Configuration.CATEGORY_ITEM, 4033).getInt();
		BonemealBottleID = config.getItem("Bonemeal Bottle ID", Configuration.CATEGORY_ITEM, 4034).getInt();
		
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
	}
    
    @EventHandler
	public void load(FMLInitializationEvent event)
	{
		//other
		proxy.registerEntityRender();
		
		GameRegistry.registerFuelHandler(new MagicFuel());
		
		GameRegistry.registerWorldGenerator(new MagicGenerater());
		
		//blocks
    	expore = new BlockExp(exporeID).setHardness(3F).setResistance(1.0F).setUnlocalizedName("expore");
    	spell = new BlockSpell(SpellID, EnumMobType.everything, Material.wood).setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("spell");
		
    	Item.itemsList[exporeID] = new ItemMagicalOresblock(exporeID-256, expore).setUnlocalizedName("expore");
    	Item.itemsList[SpellID] = new ItemSpellBlock(SpellID-256, spell).setUnlocalizedName("spell");
    	
    	//block names
		LanguageRegistry.instance().addStringLocalization("tile.expore.expore.name", "Experience Ore");
		LanguageRegistry.instance().addStringLocalization("tile.expore.cobbleexpore.name", "Cobblestone Experience Ore");
		
		LanguageRegistry.instance().addStringLocalization("tile.spell.thunder.name", "Thunder Spell");
		LanguageRegistry.instance().addStringLocalization("tile.spell.explosion.name", "Explosion Spell");
		LanguageRegistry.instance().addStringLocalization("tile.spell.fire.name", "Fire Spell");
		LanguageRegistry.instance().addStringLocalization("tile.spell.water.name", "Water Spell");
		LanguageRegistry.instance().addStringLocalization("tile.spell.lava.name", "Lava Spell");
		
		//items
    	components = new ItemMagicalComponents(ComponentItemsID).setUnlocalizedName("components");
    	xpbottlexl = new ItemXPbottlexl(xpbottlexlID).setUnlocalizedName("xpbottlexl");
    	thunderbottle = new ItemThunderbottle(thunderbottleID).setUnlocalizedName("thunderbottle");
    	tntbottle = new ItemTntbottle(tntbottleID).setUnlocalizedName("Tntbottle");
    	fuelbottle = new ItemFuelbottle(fuelbottleID).setUnlocalizedName("fuelbottle");
    	exppick = new ItemPickaxeExperion(ExperionPickaxeID, experion).setUnlocalizedName("exppick");
    	expaxe = new ItemAxeExperion(ExperionAxeID, experion).setUnlocalizedName("expaxe");
    	expshovel = new ItemShovelExperion(ExperionShovelID, experion).setUnlocalizedName("expshovel");
    	expsword = new ItemSwordExperion(ExperionSwordID, experion).setUnlocalizedName("expsword");
    	exphoe = new ItemHoeExperion(ExperionHoeID, experion).setUnlocalizedName("exphoe");
    	clusterbottle = new ItemClusterBottle(ClusterBottleID).setUnlocalizedName("clusterbottle");
    	thunderstaff = new ItemThunderStaff(ThunderStaffID, STAFF).setUnlocalizedName("thunderstaff");
    	firestaff = new ItemFireStaff(FireStaffID, STAFF).setUnlocalizedName("firestaff");
    	earthstaff = new ItemEarthStaff(EarthStaffID, STAFF).setUnlocalizedName("earthstaff");
    	firebottle = new ItemFireBottle(FireBottleID).setUnlocalizedName("firebottle");
    	dirtbottle = new ItemDirtBottle(DirtBottleID).setUnlocalizedName("dirtbottle");
    	bonebottle = new ItemBonemealBottle(BonemealBottleID).setUnlocalizedName("bonebottle");
    	airbottle = new ItemAirBottle(AirBottleID).setUnlocalizedName("airbottle");
    	
    	//item names
    	LanguageRegistry.addName(new ItemStack(components, 1, 0), "Magic Powder");
		LanguageRegistry.addName(new ItemStack(components, 1, 1), "Experion");
    	LanguageRegistry.addName(new ItemStack(components, 1, 2), "Magical Stick");
    	LanguageRegistry.addName(new ItemStack(components, 1, 3), "Magical Dirt Stick");
    	LanguageRegistry.addName(new ItemStack(components, 1, 4), "Iron Nugget");
    	
    	LanguageRegistry.addName(xpbottlexl, "Large Experience Bottle");
    	LanguageRegistry.addName(thunderbottle, "Thunder Bottle");
    	LanguageRegistry.addName(tntbottle, "TNT Bottle");
    	LanguageRegistry.addName(fuelbottle, "Fuel Bottle");
    	LanguageRegistry.addName(exppick, "Experion Pickaxe");
    	LanguageRegistry.addName(expaxe, "Experion Axe");
    	LanguageRegistry.addName(expshovel, "Experion Shovel");
    	LanguageRegistry.addName(expsword, "Experion Sword");
    	LanguageRegistry.addName(exphoe, "Experion Hoe");
    	LanguageRegistry.addName(clusterbottle, "Cluster Bottle");
    	LanguageRegistry.addName(thunderstaff, "Thunder Staff");
    	LanguageRegistry.addName(firestaff, "Fire Staff");
    	LanguageRegistry.addName(earthstaff, "Earth Staff");
    	LanguageRegistry.addName(firebottle, "Fire Bottle");
    	LanguageRegistry.addName(dirtbottle, "Dirt Bottle");
    	LanguageRegistry.addName(bonebottle, "Bonemeal Bottle");
    	LanguageRegistry.addName(airbottle, "Air Bottle");
    	
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
    
    @EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		GameRegistry.registerPlayerTracker(new MagicalExperienceLogin());
	}
}
