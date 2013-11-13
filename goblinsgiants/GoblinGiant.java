package goblinsgiants;

import goblinsgiants.blocks.BlockCustomStone;
import goblinsgiants.blocks.BlockCustomWood;
import goblinsgiants.blocks.BlockGoblinPortal;
import goblinsgiants.blocks.BlockOreBlock;
import goblinsgiants.blocks.BlockRedCactus;
import goblinsgiants.blocks.BlockSavannahTNT;
import goblinsgiants.dimension.savannah.BiomeGenSavannah;
import goblinsgiants.dimension.savannah.ComponentMineshaftRoomSavannah;
import goblinsgiants.dimension.savannah.StructureMineshaftPiecesSavannah;
import goblinsgiants.dimension.savannah.StructureMineshaftStartSavannah;
import goblinsgiants.dimension.savannah.WorldProviderGoblinsGiantsSavannah;
import goblinsgiants.entity.EntityBoneSpear;
import goblinsgiants.entity.EntityDwarf;
import goblinsgiants.entity.EntityExplosiveArrow;
import goblinsgiants.entity.EntityGiant;
import goblinsgiants.entity.EntityGoblin;
import goblinsgiants.entity.EntityPigman;
import goblinsgiants.entity.EntityRedCreeper;
import goblinsgiants.entity.EntitySavannahTNTPrimed;
import goblinsgiants.entity.EntityUruk;
import goblinsgiants.entity.EntityVampire;
import goblinsgiants.entity.EntityWerewolf;
import goblinsgiants.items.ItemBoneSpear;
import goblinsgiants.items.ItemComponent;
import goblinsgiants.items.ItemCreeperBow;
import goblinsgiants.items.ItemCustomStone;
import goblinsgiants.items.ItemDiamondPoisonSword;
import goblinsgiants.items.ItemGem;
import goblinsgiants.items.ItemGoblinFood;
import goblinsgiants.items.ItemGoldPoisonSword;
import goblinsgiants.items.ItemIronPoisonSword;
import goblinsgiants.items.ItemKey;
import goblinsgiants.items.ItemOreBlock;
import goblinsgiants.items.ItemPortalPlacer;
import goblinsgiants.items.ItemStonePoisonSword;
import goblinsgiants.items.ItemUrukSword;
import goblinsgiants.items.ItemWaterHoe;
import goblinsgiants.items.ItemWoodPoisonSword;
import goblinsgiants.worldgen.GoblinGiantGenerater;

import java.io.IOException;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = GoblinGiant.modid, name = "Goblins and Giants", version = "1.0.2.6")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class GoblinGiant
{
	/*
	 * 1.0.2.6 
	 * - Fixed Sword Render issue with orcs 
	 * - Improved Orc AI 
	 * - Updated all AI
	 * - Added online update checking support
	 * - Fixed damage from swords
	 * - Fixed the dimension not working
	 */
	
	public static final int VERSION = 1;
	public static String updates = "";
	public static boolean outdated = false;
	
	public static final String modid = "wuppy29_goblingiant";
	
	@SidedProxy(clientSide = "goblinsgiants.ClientProxyGoblin", serverSide = "goblinsgiants.CommonProxyGoblin")
	public static CommonProxyGoblin proxy;
	
	public static int dimension;
	static int startEntityId = 300;
	
	// block id's
	public static int GoblinPortalBlockID;
	public static int RedCactusBlockID;
	public static int OreBlockID;
	public static int CustomStoneID;
	public static int SavannahTNTID;
	public static int CustomWoodID;
	
	// blocks
	public static Block goblinportal;
	public static Block redcactus;
	public static Block oreblock;
	public static Block customstone;
	public static Block savannahtnt;
	public static Block customWood;
	
	// item id's
	public static int VampireBloodID;
	public static int BoneSpearID;
	public static int UrukSwordID;
	public static int WoodPoisonSwordID;
	public static int StonePoisonSwordID;
	public static int IronPoisonSwordID;
	public static int GoldPoisonSwordID;
	public static int DiamondPoisonSwordID;
	public static int KeyID;
	public static int CookedRedCactusID;
	public static int GemID;
	public static int WaterHoeID;
	public static int CreeperBowID;
	public static int PortalPlacerID;
	
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
	
	// materials
	static EnumToolMaterial uruk = EnumHelper.addToolMaterial("uruk", 2, 250, 6.0F, 2, 14);
	static EnumToolMaterial woodpoison = EnumHelper.addToolMaterial("woodpoison", 0, 60, 2.0F, 1, 15);
	static EnumToolMaterial stonepoison = EnumHelper.addToolMaterial("stonepoison", 1, 60, 4.0F, 2, 5);
	static EnumToolMaterial ironpoison = EnumHelper.addToolMaterial("ironpoison", 2, 60, 6.0F, 3, 14);
	static EnumToolMaterial goldpoison = EnumHelper.addToolMaterial("goldpoison", 0, 60, 12.0F, 1, 22);
	static EnumToolMaterial diamondpoison = EnumHelper.addToolMaterial("diamondpoison", 3, 60, 8.0F, 4, 10);
	static EnumToolMaterial waterhoematerial = EnumHelper.addToolMaterial("waterhoematerial", 2, 500, 7F, 2, 14);
	
	// biome
	public static BiomeGenBase savannah = new BiomeGenSavannah(52).setBiomeName("Savannah");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigLoader.loadConfig(event);
		
		try
		{
			UpdateChecker.checkForUpdates();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		MapGenStructureIO.func_143034_b(StructureMineshaftStartSavannah.class, "MineshaftSavannah");
		MapGenStructureIO.func_143031_a(ComponentMineshaftRoomSavannah.class, "MSRoomSavannah");
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		
		// blocks
		goblinportal = new BlockGoblinPortal(GoblinPortalBlockID).setHardness(-1F).setStepSound(Block.soundGlassFootstep).setLightValue(0.75F).setUnlocalizedName("savportal");
		redcactus = new BlockRedCactus(RedCactusBlockID).setHardness(0.4F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("red cactus");
		oreblock = new BlockOreBlock(OreBlockID).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreblock");
		customstone = new BlockCustomStone(CustomStoneID).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("customstone");
		savannahtnt = new BlockSavannahTNT(SavannahTNTID).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("savannahtnt");
		customWood = new BlockCustomWood(CustomWoodID).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("customwood");
		
		MinecraftForge.setBlockHarvestLevel(oreblock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(customstone, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(customWood, "axe", 1);
		
		// block register
		GameRegistry.registerBlock(goblinportal, "Wuppy29_GoblinPortal");
		GameRegistry.registerBlock(redcactus, "Wuppy29_RedCactus");
		GameRegistry.registerBlock(savannahtnt, "Wuppy29_SavannahTnt");
		GameRegistry.registerBlock(customWood, "Wuppy29_customWood");
		
		// block metadata
		Item.itemsList[OreBlockID] = new ItemOreBlock(OreBlockID - 256, oreblock).setUnlocalizedName("oreblock");
		Item.itemsList[CustomStoneID] = new ItemCustomStone(CustomStoneID - 256, customstone).setUnlocalizedName("customstone");
		
		// block names
		LanguageRegistry.addName(goblinportal, "Savannah Portal");
		LanguageRegistry.addName(redcactus, "Red Cactus");
		
		LanguageRegistry.addName(new ItemStack(oreblock, 1, 0), "Citrine Ore");
		LanguageRegistry.addName(new ItemStack(oreblock, 1, 1), "Kyanite Ore");
		LanguageRegistry.addName(new ItemStack(oreblock, 1, 2), "Moonstone Ore");
		LanguageRegistry.addName(new ItemStack(oreblock, 1, 3), "Lepidolite Ore");
		LanguageRegistry.addName(new ItemStack(oreblock, 1, 4), "Aquamarine Ore");
		LanguageRegistry.addName(new ItemStack(oreblock, 1, 5), "Hematite Ore");
		LanguageRegistry.addName(new ItemStack(oreblock, 1, 6), "Ruby Ore");
		
		LanguageRegistry.addName(new ItemStack(customstone, 1, 0), "Sandstone Gold Ore");
		LanguageRegistry.addName(new ItemStack(customstone, 1, 1), "Sandstone Iron Ore");
		LanguageRegistry.addName(new ItemStack(customstone, 1, 2), "Sandstone Coal Ore");
		LanguageRegistry.addName(new ItemStack(customstone, 1, 3), "Sandstone Diamond Ore");
		LanguageRegistry.addName(new ItemStack(customstone, 1, 4), "Sandstone Redstone Ore");
		LanguageRegistry.addName(new ItemStack(customstone, 1, 5), "Sandstone Lapis Lazuli Ore");
		
		LanguageRegistry.addName(savannahtnt, "Savannah TNT");
		LanguageRegistry.addName(customWood, "Sausage Wood");
		
		// items
		component = new ItemComponent(VampireBloodID).setUnlocalizedName("component");
		bonespear = new ItemBoneSpear(BoneSpearID).setUnlocalizedName("bonespear");
		uruksword = new ItemUrukSword(UrukSwordID, uruk).setUnlocalizedName("uruksword");
		woodpoisonsword = new ItemWoodPoisonSword(WoodPoisonSwordID, woodpoison).setUnlocalizedName("wood poison");
		stonepoisonsword = new ItemStonePoisonSword(StonePoisonSwordID, stonepoison).setUnlocalizedName("stone poison");
		ironpoisonsword = new ItemIronPoisonSword(IronPoisonSwordID, ironpoison).setUnlocalizedName("iron poison");
		goldpoisonsword = new ItemGoldPoisonSword(GoldPoisonSwordID, goldpoison).setUnlocalizedName("gold poison");
		diamondpoisonsword = new ItemDiamondPoisonSword(DiamondPoisonSwordID, diamondpoison).setUnlocalizedName("diamond poison");
		key = new ItemKey(KeyID).setUnlocalizedName("key");
		cookedredcactus = new ItemGoblinFood(CookedRedCactusID, 6, 0.6F, false).setUnlocalizedName("redcactusfood");
		gem = new ItemGem(GemID).setUnlocalizedName("gem");
		waterhoe = new ItemWaterHoe(WaterHoeID, waterhoematerial).setUnlocalizedName("waterhoe");
		creeperbow = new ItemCreeperBow(CreeperBowID).setUnlocalizedName("explosivebow");
		portalPlacer = new ItemPortalPlacer(PortalPlacerID).setUnlocalizedName("portalPlacer");
		
		// item names
		LanguageRegistry.addName(new ItemStack(component, 1, 0), "Vampire Blood");
		LanguageRegistry.addName(new ItemStack(component, 1, 1), "Spear Tip");
		LanguageRegistry.addName(new ItemStack(component, 1, 2), "Giant Bone");
		LanguageRegistry.addName(new ItemStack(component, 1, 3), "Bloody Giant Bone");
		LanguageRegistry.addName(new ItemStack(component, 1, 4), "Poison Bottle");
		LanguageRegistry.addName(new ItemStack(component, 1, 5), "Savannah Gunpowder");
		
		LanguageRegistry.addName(bonespear, "Bone Spear");
		LanguageRegistry.addName(uruksword, "Uruk Hai Sword");
		
		LanguageRegistry.addName(woodpoisonsword, "Wooden Poison Sword");
		LanguageRegistry.addName(stonepoisonsword, "Stone Poison Sword");
		LanguageRegistry.addName(ironpoisonsword, "Iron Poison Sword");
		LanguageRegistry.addName(goldpoisonsword, "Gold Poison Sword");
		LanguageRegistry.addName(diamondpoisonsword, "Diamond Poison Sword");
		
		LanguageRegistry.addName(new ItemStack(key, 1, 0), "Yellow Key");
		LanguageRegistry.addName(new ItemStack(key, 1, 1), "Blue Key");
		LanguageRegistry.addName(new ItemStack(key, 1, 2), "White Key");
		LanguageRegistry.addName(new ItemStack(key, 1, 3), "Gray Key");
		LanguageRegistry.addName(new ItemStack(key, 1, 4), "Light Blue Key");
		LanguageRegistry.addName(new ItemStack(key, 1, 5), "Brown Key");
		LanguageRegistry.addName(new ItemStack(key, 1, 6), "Red Key");
		
		LanguageRegistry.addName(cookedredcactus, "Cooked Red Cactus");
		
		LanguageRegistry.addName(new ItemStack(gem, 1, 0), "Citrine");
		LanguageRegistry.addName(new ItemStack(gem, 1, 1), "Kyanite");
		LanguageRegistry.addName(new ItemStack(gem, 1, 2), "Moonstone");
		LanguageRegistry.addName(new ItemStack(gem, 1, 3), "Lepidolite");
		LanguageRegistry.addName(new ItemStack(gem, 1, 4), "Aquamarine");
		LanguageRegistry.addName(new ItemStack(gem, 1, 5), "Hematite");
		LanguageRegistry.addName(new ItemStack(gem, 1, 6), "Ruby");
		
		LanguageRegistry.addName(waterhoe, "Hoe Of Watering");
		LanguageRegistry.addName(creeperbow, "Creepers' Soul Bow");
		LanguageRegistry.addName(portalPlacer, "Portal Placer");
		
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
		for (int i = 0; i < BiomeGenBase.biomeList.length; i++)
		{
			if (BiomeGenBase.biomeList[i] != null)
			{
				EntityRegistry.addSpawn(EntityVampire.class, 10, 1, 3, EnumCreatureType.monster, BiomeGenBase.biomeList[i]);
				EntityRegistry.addSpawn(EntityWerewolf.class, 5, 1, 2, EnumCreatureType.monster, BiomeGenBase.biomeList[i]);
				EntityRegistry.addSpawn(EntityPigman.class, 10, 2, 4, EnumCreatureType.creature, BiomeGenBase.biomeList[i]);
				EntityRegistry.addSpawn(EntityGoblin.class, 10, 7, 15, EnumCreatureType.monster, BiomeGenBase.biomeList[i]);
				EntityRegistry.addSpawn(EntityGiant.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.biomeList[i]);
				EntityRegistry.addSpawn(EntityUruk.class, 8, 2, 4, EnumCreatureType.monster, BiomeGenBase.biomeList[i]);
			}
		}
		EntityRegistry.removeSpawn(EntityPigman.class, EnumCreatureType.creature, savannah);
		
		EntityRegistry.addSpawn(EntityRedCreeper.class, 4, 1, 2, EnumCreatureType.monster, savannah);
		
		// entity names
		LanguageRegistry.instance().addStringLocalization("entity.wuppy29_goblingiant.vampire.name", "Vampire");
		LanguageRegistry.instance().addStringLocalization("entity.wuppy29_goblingiant.vampirebat.name", "Vampire Bat");
		LanguageRegistry.instance().addStringLocalization("entity.wuppy29_goblingiant.dwarf.name", "Dwarf");
		LanguageRegistry.instance().addStringLocalization("entity.wuppy29_goblingiant.werewolf.name", "Werewolf");
		LanguageRegistry.instance().addStringLocalization("entity.wuppy29_goblingiant.pigman.name", "Pigman");
		LanguageRegistry.instance().addStringLocalization("entity.wuppy29_goblingiant.goblin.name", "Goblin");
		LanguageRegistry.instance().addStringLocalization("entity.wuppy29_goblingiant.giant.name", "Giant");
		LanguageRegistry.instance().addStringLocalization("entity.wuppy29_goblingiant.orc.name", "Orc");
		LanguageRegistry.instance().addStringLocalization("entity.wuppy29_goblingiant.redcreeper.name", "Red Creeper");
		
		// Entity Eggs
		registerEntityEgg(EntityVampire.class, 0x979797, 0x000000);
		
		registerEntityEgg(EntityDwarf.class, 0xd8bb9d, 0xa63c1a);
		registerEntityEgg(EntityWerewolf.class, 0xbbc2c2, 0x585957);
		registerEntityEgg(EntityPigman.class, 0xb09190, 0x7d4443);
		registerEntityEgg(EntityGoblin.class, 0x518b3b, 0x4a5618);
		registerEntityEgg(EntityGiant.class, 0x938d63, 0x6a5535);
		registerEntityEgg(EntityUruk.class, 0xa7a377, 0x5d4c35);
		registerEntityEgg(EntityRedCreeper.class, 0xF21111, 0x000000);
		
		// generation
		GameRegistry.registerWorldGenerator(new GoblinGiantGenerater());
		
		// dimension
		DimensionManager.registerProviderType(GoblinGiant.dimension, WorldProviderGoblinsGiantsSavannah.class, false);
		DimensionManager.registerDimension(GoblinGiant.dimension, GoblinGiant.dimension);
		
		// recipes
		GameRegistry.addShapelessRecipe(new ItemStack(Item.redstone, 1), new Object[] { new ItemStack(component, 1, 0) });
		
		// bonespear
		GameRegistry.addShapelessRecipe(new ItemStack(component, 1, 3), new Object[] { new ItemStack(component, 1, 0), new ItemStack(component, 1, 2) });
		
		GameRegistry.addRecipe(new ItemStack(bonespear, 8), new Object[] { "X", "Z", "C", 'X', new ItemStack(component, 1, 1), 'Z', new ItemStack(component, 1, 3), 'C', Item.feather });
		
		// Poison swords and bottles
		GameRegistry.addShapelessRecipe(new ItemStack(component, 2, 4), new Object[] { new ItemStack(Item.spiderEye), new ItemStack(Item.potion, 1, 0), new ItemStack(component, 1, 0) });
		
		GameRegistry.addRecipe(new ItemStack(savannahtnt), new Object[] { "XCX", "CXC", "XCX", 'X', Block.sand, 'C', new ItemStack(component, 1, 5) });
		
		new PoisonSwordRecipeAdder();
	}
	
	 @EventHandler
     public void postInit(FMLPostInitializationEvent event) 
	 {
		 GameRegistry.registerPlayerTracker(new GoblinGiantLogin());
	 }
	
	public static int getUniqueEntityId()
	{
		do
		{
			startEntityId++;
		} while (EntityList.getStringFromID(startEntityId) != null);
		
		return startEntityId;
	}
	
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor)
	{
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
}
