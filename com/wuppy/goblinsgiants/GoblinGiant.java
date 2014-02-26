package com.wuppy.goblinsgiants;

import java.io.IOException;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.EnumHelper;

import com.wuppy.goblinsgiants.blocks.BlockCustomStone;
import com.wuppy.goblinsgiants.blocks.BlockCustomWood;
import com.wuppy.goblinsgiants.blocks.BlockGoblinPortal;
import com.wuppy.goblinsgiants.blocks.BlockOreBlock;
import com.wuppy.goblinsgiants.blocks.BlockRedCactus;
import com.wuppy.goblinsgiants.blocks.BlockSavannahTNT;
import com.wuppy.goblinsgiants.dimension.savannah.BiomeGenSavannah;
import com.wuppy.goblinsgiants.dimension.savannah.StructureMineshaftPiecesSavannah;
import com.wuppy.goblinsgiants.dimension.savannah.StructureMineshaftStartSavannah;
import com.wuppy.goblinsgiants.dimension.savannah.WorldProviderGoblinsGiantsSavannah;
import com.wuppy.goblinsgiants.entity.EntityBoneSpear;
import com.wuppy.goblinsgiants.entity.EntityDwarf;
import com.wuppy.goblinsgiants.entity.EntityExplosiveArrow;
import com.wuppy.goblinsgiants.entity.EntityGiant;
import com.wuppy.goblinsgiants.entity.EntityGoblin;
import com.wuppy.goblinsgiants.entity.EntityPigman;
import com.wuppy.goblinsgiants.entity.EntityRedCreeper;
import com.wuppy.goblinsgiants.entity.EntitySavannahTNTPrimed;
import com.wuppy.goblinsgiants.entity.EntityUruk;
import com.wuppy.goblinsgiants.entity.EntityVampire;
import com.wuppy.goblinsgiants.entity.EntityWerewolf;
import com.wuppy.goblinsgiants.items.ItemBoneSpear;
import com.wuppy.goblinsgiants.items.ItemComponent;
import com.wuppy.goblinsgiants.items.ItemCreeperBow;
import com.wuppy.goblinsgiants.items.ItemCustomStone;
import com.wuppy.goblinsgiants.items.ItemDagger;
import com.wuppy.goblinsgiants.items.ItemDiamondPoisonSword;
import com.wuppy.goblinsgiants.items.ItemGem;
import com.wuppy.goblinsgiants.items.ItemGoblinFood;
import com.wuppy.goblinsgiants.items.ItemGoldPoisonSword;
import com.wuppy.goblinsgiants.items.ItemIronPoisonSword;
import com.wuppy.goblinsgiants.items.ItemKey;
import com.wuppy.goblinsgiants.items.ItemOreBlock;
import com.wuppy.goblinsgiants.items.ItemPortalPlacer;
import com.wuppy.goblinsgiants.items.ItemStonePoisonSword;
import com.wuppy.goblinsgiants.items.ItemUrukSword;
import com.wuppy.goblinsgiants.items.ItemWaterHoe;
import com.wuppy.goblinsgiants.items.ItemWoodPoisonSword;
import com.wuppy.goblinsgiants.worldgen.GoblinGiantGenerater;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = GoblinGiant.modid, name = "Goblins and Giants", version = "1.0.3.0")
public class GoblinGiant
{
	public static final int VERSION = 3;
	public static String updates = "";
	public static boolean outdated = false;

	public static final String modid = "wuppy29_goblingiant";

	@SidedProxy(clientSide = "com.wuppy.goblinsgiants.ClientProxyGoblin", serverSide = "com.wuppy.goblinsgiants.CommonProxyGoblin")
	public static CommonProxyGoblin proxy;

	public static int dimension;
	static int startEntityId = 300;

	// blocks
	public static Block goblinportal;
	public static Block redcactus;
	public static Block oreblock;
	public static Block customstone;
	public static Block savannahtnt;
	public static Block customWood;

	// items
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

	// config
	public static boolean spawnVampire = true;
	public static boolean spawnDwarf = true;
	public static boolean spawnWerewolf = true;
	public static boolean spawnPigman = true;
	public static boolean spawnGoblin = true;
	public static boolean spawnGiant = true;
	public static boolean spawnUruk = true;
	public static boolean spawnRedCreeper = true;

	// materials
	static ToolMaterial uruk = EnumHelper.addToolMaterial("uruk", 2, 250, 6.0F, 2, 14);
	static ToolMaterial woodpoison = EnumHelper.addToolMaterial("woodpoison", 0, 60, 2.0F, 1, 15);
	static ToolMaterial stonepoison = EnumHelper.addToolMaterial("stonepoison", 1, 60, 4.0F, 2, 5);
	static ToolMaterial ironpoison = EnumHelper.addToolMaterial("ironpoison", 2, 60, 6.0F, 3, 14);
	static ToolMaterial goldpoison = EnumHelper.addToolMaterial("goldpoison", 0, 60, 12.0F, 1, 22);
	static ToolMaterial diamondpoison = EnumHelper.addToolMaterial("diamondpoison", 3, 60, 8.0F, 4, 10);
	static ToolMaterial waterhoematerial = EnumHelper.addToolMaterial("waterhoematerial", 2, 500, 7F, 2, 14);
	static ToolMaterial daggermaterial = EnumHelper.addToolMaterial("daggermaterial", 2, 250, 3.0F, 2.0F, 14);

	// biome
	public static BiomeGenBase savannah = new BiomeGenSavannah(52).setBiomeName("Savannah");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(this);

		ConfigLoader.loadConfig(event);

		try
		{
			UpdateChecker.checkForUpdates();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		proxy.registerRenderThings();

		// blocks
		goblinportal = new BlockGoblinPortal().setHardness(-1F).setStepSound(Block.soundTypeGrass).setLightLevel(0.75F).setBlockName("savportal");
		redcactus = new BlockRedCactus().setHardness(0.4F).setStepSound(Block.soundTypeCloth).setBlockName("red cactus");
		oreblock = new BlockOreBlock().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockName("oreblock");
		customstone = new BlockCustomStone().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockName("customstone");
		savannahtnt = new BlockSavannahTNT().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("savannahtnt");
		customWood = new BlockCustomWood().setHardness(2.0F).setStepSound(Block.soundTypeWood).setBlockName("customwood");

		// block register
		GameRegistry.registerBlock(goblinportal, "Wuppy29_GoblinPortal");
		GameRegistry.registerBlock(redcactus, "Wuppy29_RedCactus");
		GameRegistry.registerBlock(oreblock, ItemOreBlock.class, "Wuppy29_OreBlock");
		GameRegistry.registerBlock(customstone, ItemCustomStone.class, "Wuppy29_customstone");
		GameRegistry.registerBlock(savannahtnt, "Wuppy29_SavannahTnt");
		GameRegistry.registerBlock(customWood, "Wuppy29_customWood");

		// items
		component = new ItemComponent().setUnlocalizedName("component");
		bonespear = new ItemBoneSpear().setUnlocalizedName("bonespear");
		uruksword = new ItemUrukSword(uruk).setUnlocalizedName("uruksword");
		woodpoisonsword = new ItemWoodPoisonSword(woodpoison).setUnlocalizedName("wood poison");
		stonepoisonsword = new ItemStonePoisonSword(stonepoison).setUnlocalizedName("stone poison");
		ironpoisonsword = new ItemIronPoisonSword(ironpoison).setUnlocalizedName("iron poison");
		goldpoisonsword = new ItemGoldPoisonSword(goldpoison).setUnlocalizedName("gold poison");
		diamondpoisonsword = new ItemDiamondPoisonSword(diamondpoison).setUnlocalizedName("diamond poison");
		key = new ItemKey().setUnlocalizedName("key");
		cookedredcactus = new ItemGoblinFood(6, 0.6F, false).setUnlocalizedName("redcactusfood");
		gem = new ItemGem().setUnlocalizedName("gem");
		waterhoe = new ItemWaterHoe(waterhoematerial).setUnlocalizedName("waterhoe");
		creeperbow = new ItemCreeperBow().setUnlocalizedName("explosivebow");
		portalPlacer = new ItemPortalPlacer().setUnlocalizedName("portalPlacer");
		dagger = new ItemDagger(daggermaterial).setUnlocalizedName("dagger");
		
		//item register
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
		
		// entities
		EntityRegistry.registerModEntity(EntityBoneSpear.class, "bonespear", 35, this, 40, 1, true);
		EntityRegistry.registerModEntity(EntityExplosiveArrow.class, "explosivearrow", 36, this, 40, 1, true);

		EntityRegistry.registerGlobalEntityID(EntitySavannahTNTPrimed.class, "savannahtntprimed", 107);

		EntityRegistry.registerModEntity(EntityVampire.class, "vampire", 1, this, 80, 3, true);

		EntityRegistry.registerModEntity(EntityDwarf.class, "dwarf", 3, this, 80, 3, true);
		EntityRegistry.registerModEntity(EntityWerewolf.class, "werewolf", 4, this, 80, 3, true);
		EntityRegistry.registerModEntity(EntityPigman.class, "pigman", 5, this, 80, 3, true);
		EntityRegistry.registerModEntity(EntityGoblin.class, "goblin", 6, this, 80, 3, true);
		EntityRegistry.registerModEntity(EntityGiant.class, "giant", 7, this, 80, 3, true);
		EntityRegistry.registerModEntity(EntityUruk.class, "orc", 8, this, 80, 3, true);
		EntityRegistry.registerModEntity(EntityRedCreeper.class, "redcreeper", 9, this, 80, 3, true);

		// spawns
		for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++)
		{
			if (BiomeGenBase.getBiomeGenArray()[i] != null)
			{
				if (spawnVampire)
					EntityRegistry.addSpawn(EntityVampire.class, 10, 1, 3, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
				if (spawnWerewolf)
					EntityRegistry.addSpawn(EntityWerewolf.class, 5, 1, 2, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
				if (spawnPigman)
					EntityRegistry.addSpawn(EntityPigman.class, 10, 2, 4, EnumCreatureType.creature, BiomeGenBase.getBiomeGenArray()[i]);
				if (spawnGoblin)
					EntityRegistry.addSpawn(EntityGoblin.class, 10, 7, 15, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
				if (spawnGiant)
					EntityRegistry.addSpawn(EntityGiant.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
				if (spawnUruk)
					EntityRegistry.addSpawn(EntityUruk.class, 8, 2, 4, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
			}
		}

		if (spawnPigman)
			EntityRegistry.removeSpawn(EntityPigman.class, EnumCreatureType.creature, savannah);
		if (spawnRedCreeper)
			EntityRegistry.addSpawn(EntityRedCreeper.class, 4, 1, 2, EnumCreatureType.monster, savannah);

		// Entity Eggs
		registerEntityEgg(EntityVampire.class, 0x979797, 0x000000);

		registerEntityEgg(EntityDwarf.class, 0xd8bb9d, 0xa63c1a);
		registerEntityEgg(EntityWerewolf.class, 0xbbc2c2, 0x585957);
		registerEntityEgg(EntityPigman.class, 0xb09190, 0x7d4443);
		registerEntityEgg(EntityGoblin.class, 0x518b3b, 0x4a5618);
		registerEntityEgg(EntityGiant.class, 0x938d63, 0x6a5535);
		registerEntityEgg(EntityUruk.class, 0xa7a377, 0x5d4c35);
		registerEntityEgg(EntityRedCreeper.class, 0xF21111, 0x000000);
		
		//register MapGens Savannah
		MapGenStructureIO.registerStructure(StructureMineshaftStartSavannah.class, "Mineshaft_Savannah");
		StructureMineshaftPiecesSavannah.registerStructurePieces();
		
		// generation
		GameRegistry.registerWorldGenerator(new GoblinGiantGenerater(), 0);

		// dimension
		DimensionManager.registerProviderType(GoblinGiant.dimension, WorldProviderGoblinsGiantsSavannah.class, false);
		DimensionManager.registerDimension(GoblinGiant.dimension, GoblinGiant.dimension);
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		// recipes
		GameRegistry.addShapelessRecipe(new ItemStack(Items.redstone, 1), new Object[] { new ItemStack(component, 1, 0) });

		// bonespear
		GameRegistry.addShapelessRecipe(new ItemStack(component, 1, 3), new Object[] { new ItemStack(component, 1, 0), new ItemStack(component, 1, 2) });

		GameRegistry.addRecipe(new ItemStack(bonespear, 8), new Object[] { "X", "Z", "C", 'X', new ItemStack(component, 1, 1), 'Z', new ItemStack(component, 1, 3), 'C', Items.feather });

		// Poison swords and bottles
		GameRegistry.addShapelessRecipe(new ItemStack(component, 2, 4), new Object[] { new ItemStack(Items.spider_eye), new ItemStack(Items.potionitem, 1, 0), new ItemStack(component, 1, 0) });

		GameRegistry.addRecipe(new ItemStack(savannahtnt), new Object[] { "XCX", "CXC", "XCX", 'X', Blocks.sand, 'C', new ItemStack(component, 1, 5) });

		new PoisonSwordRecipeAdder();
	}

	public static int getUniqueEntityId()
	{
		do
		{
			startEntityId++;
		}
		while (EntityList.getStringFromID(startEntityId) != null);

		return startEntityId;
	}

	@SuppressWarnings("unchecked")
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor)
	{
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}

	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		if (outdated)
		{
			event.player.addChatComponentMessage(new ChatComponentText("Goblins and Giants is outdated."));
			event.player.addChatComponentMessage(new ChatComponentText("Changelog: "));
			event.player.addChatComponentMessage(new ChatComponentText(updates));
		}
	}
}
