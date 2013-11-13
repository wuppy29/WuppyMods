package peacefulpackmod;

import java.io.IOException;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import peacefulpackmod.block.BlockBlazeSapling;
import peacefulpackmod.block.BlockBlazeleaves;
import peacefulpackmod.block.BlockBlazelog;
import peacefulpackmod.block.BlockBuriedRemains;
import peacefulpackmod.block.BlockCustomWeb;
import peacefulpackmod.block.BlockEnderclam;
import peacefulpackmod.block.BlockGhastOre;
import peacefulpackmod.block.BlockPeacefulOres;
import peacefulpackmod.block.BlockRottenPlant;
import peacefulpackmod.block.Blockflax;
import peacefulpackmod.block.Blockslime;
import peacefulpackmod.item.ItemDust;
import peacefulpackmod.item.ItemPeacefulFood;
import peacefulpackmod.item.ItemPeacefulOresblock;
import peacefulpackmod.item.Itemseed;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = PeacefulPack.modid, name = "Peacefulpack", version = "1.1.6.3")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class PeacefulPack 
{
	public static final String modid = "wuppy29_peacefulpack";
	
	public static final int VERSION = 1;
	public static String updates = "";
	public static boolean outdated = false;
	
	// block config
	public static int OreBlockID;
	public static int FlaxID;
	public static int SlimeslabID;
	public static int RottenPlantID;
	public static int BlazelogID;
	public static int BlazeLeavesID;
	public static int GhastOreID;
	public static int EnderClamID;
	public static int BlazeSaplingID;
	public static int RemainsID;
	
	public static int customWebID = Block.web.blockID;

	// item config
	public static int SulphurCrystalID;
	public static int NiterCrystalID;
	public static int FlaxFibreID;
	public static int ClothID;
	public static int FlaxSeedID;
	public static int CookedfleshID;
	public static int ChainID;
	public static int RottenPlantSeedID;
	
	// blocks
	public static Block oreblock;
	public static Block flax;
	public static Block slimeslab;
	public static Block rottenplant;
	public static Block blazelog;
	public static Block blazeleaves;
	public static Block ghastore;
	public static Block enderclam;
	public static Block blazeSapling;
	public static Block remains;
	
	public static Block customWeb;

	// items
	public static Item sulphDust;
	public static Item niterDust;
	public static Item flaxfibre;
	public static Item cloth;
	public static Item flaxseed;
	public static Item cookedflesh;
	public static Item chain;
	public static Item rottenseed;

	Random rand = new Random();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		OreBlockID = config.getBlock("Ore Blocks ID", Configuration.CATEGORY_BLOCK, 306).getInt();
		FlaxID = config.getBlock("Flax ID", Configuration.CATEGORY_BLOCK, 307).getInt();
		SlimeslabID = config.getBlock("Slime Slab ID", Configuration.CATEGORY_BLOCK, 308).getInt();
		RottenPlantID = config.getBlock("Rotten Plant ID", Configuration.CATEGORY_BLOCK, 309).getInt();
		BlazelogID = config.getBlock("Blaze Log ID", Configuration.CATEGORY_BLOCK, 310).getInt();
		BlazeLeavesID = config.getBlock("Blaze Leaves ID", Configuration.CATEGORY_BLOCK, 311).getInt();
		GhastOreID = config.getBlock("Ghast Ore ID", Configuration.CATEGORY_BLOCK, 312).getInt();
		EnderClamID = config.getBlock("Ender Clam ID", Configuration.CATEGORY_BLOCK, 313).getInt();
		BlazeSaplingID = config.getBlock("Blaze Sapling ID", Configuration.CATEGORY_BLOCK, 314).getInt();
		RemainsID = config.getBlock("Buried remains ID", Configuration.CATEGORY_BLOCK, 315).getInt();
		
		SulphurCrystalID = config.getItem("Sulphur Crystal ID", Configuration.CATEGORY_ITEM, 4036).getInt();
		NiterCrystalID = config.getItem("Niter Crystal ID", Configuration.CATEGORY_ITEM, 4037).getInt();
		FlaxFibreID = config.getItem("Flax Fibre ID", Configuration.CATEGORY_ITEM, 4038).getInt();
		ClothID = config.getItem("Cloth ID", Configuration.CATEGORY_ITEM, 4039).getInt();
		FlaxSeedID = config.getItem("Flax Seed ID", Configuration.CATEGORY_ITEM, 4040).getInt();
		CookedfleshID = config.getItem("Cooked Flesh ID", Configuration.CATEGORY_ITEM, 4041).getInt();
		ChainID = config.getItem("Chain ID", Configuration.CATEGORY_ITEM, 4042).getInt();
		RottenPlantSeedID = config.getItem("Rotten Plant Seed ID", Configuration.CATEGORY_ITEM, 4043).getInt();
		
		config.save();
		
		try
		{
			UpdateChecker.checkForUpdates();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) 
	{
		//blocks 
		oreblock = new BlockPeacefulOres(OreBlockID).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setUnlocalizedName("oreblock");
		flax = new Blockflax(FlaxID).setStepSound(Block.soundGrassFootstep).setHardness(0.0F).setUnlocalizedName("flax");
		slimeslab = new Blockslime(SlimeslabID).setHardness(1F).setLightValue(0.5F).setResistance(1.0F).setUnlocalizedName("slime");
		rottenplant = new BlockRottenPlant(RottenPlantID, PeacefulPack.modid + ":rotten plant 1").setStepSound(Block.soundGrassFootstep).setHardness(0.0F).setUnlocalizedName("rottenplant");
		blazelog = new BlockBlazelog(BlazelogID).setStepSound(Block.soundWoodFootstep).setHardness(2F).setResistance(1.0F).setUnlocalizedName("blazelog");
		blazeleaves = new BlockBlazeleaves(BlazeLeavesID).setLightValue(0.7F).setStepSound(Block.soundGrassFootstep).setHardness(0.2F).setLightOpacity(1).setUnlocalizedName("blazeleaves");
		ghastore = new BlockGhastOre(GhastOreID).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setUnlocalizedName("ghastore");
		enderclam = new BlockEnderclam(EnderClamID).setStepSound(Block.soundStoneFootstep).setLightValue(0.5F).setHardness(3F).setResistance(1.0F).setUnlocalizedName("enderclam");;
		blazeSapling = new BlockBlazeSapling(BlazeSaplingID).setStepSound(Block.soundGrassFootstep).setHardness(0.0F).setUnlocalizedName("blazeSapling");
		remains = new BlockBuriedRemains(RemainsID).setStepSound(Block.soundGravelFootstep).setHardness(0.5F).setUnlocalizedName("remains");
		
		Block.blocksList[customWebID] = null;
		customWeb = new BlockCustomWeb(customWebID).setLightOpacity(1).setHardness(4.0F).setUnlocalizedName("web").setTextureName("web");
		
		//items
		sulphDust = new ItemDust(SulphurCrystalID).setUnlocalizedName("sulphdust");
		niterDust = new ItemDust(NiterCrystalID).setUnlocalizedName("niterdust");
		flaxfibre = new ItemDust(FlaxFibreID).setUnlocalizedName("flaxfibre");
		cloth = new ItemDust(ClothID).setUnlocalizedName("cloth");
		flaxseed = new Itemseed(FlaxSeedID, flax.blockID, Block.grass.blockID).setUnlocalizedName("flaxseed");
		cookedflesh = new ItemPeacefulFood(CookedfleshID, 5, true).setUnlocalizedName("cookedflesh");
		chain = new ItemDust(ChainID).setUnlocalizedName("chain");
		rottenseed = new Itemseed(RottenPlantSeedID, rottenplant.blockID, Block.netherrack.blockID).setUnlocalizedName("rottenseed");
		
		//block register
		GameRegistry.registerBlock(flax, "Wuppy29_Flax");
		GameRegistry.registerBlock(slimeslab, "Wuppy29_SlimeSlab");		
		GameRegistry.registerBlock(rottenplant, "Wuppy29_ RottenPlant");
		GameRegistry.registerBlock(blazelog, "Wuppy29_BlazeLog");
		GameRegistry.registerBlock(blazeleaves, "Wuppy29_BlazeLeaves");
		GameRegistry.registerBlock(ghastore, "Wuppy29_GhastOre");
		GameRegistry.registerBlock(enderclam, "Wuppy29_EnderClam");
		GameRegistry.registerBlock(blazeSapling, "Wuppy29_BlazeSapling");
		GameRegistry.registerBlock(remains, "Wuppy29_Remains");
		
		//fuel
		GameRegistry.registerFuelHandler(new PeacefulFuel());
		
		GameRegistry.registerWorldGenerator(new PeacefulGenerator());
		
		//block names
		int namer = rand.nextInt(6);
		
		String name = "Goo";
		
		if(namer == 0)
		{
			name = "Goo";
		}
		else if(namer == 1)
		{
			name = "Yuck";
		}
		else if(namer == 2)
		{
			name = "Slime";
		}
		else if(namer == 3)
		{
			name = "Eww";
		}
		else if (namer == 4)
		{
			name = "Gel";
		}
	    else if (namer == 5)
	    {
	    	name = "Blech";
	    }
		
		LanguageRegistry.addName(slimeslab, name);
		
		LanguageRegistry.instance().addStringLocalization("tile.flax.name", "en_US", "Flax");
		LanguageRegistry.instance().addStringLocalization("tile.flax.name", "nl_NL", "vlas");
		LanguageRegistry.instance().addStringLocalization("tile.rottenplant.name", "en_US", "Rotten Plant");
		LanguageRegistry.instance().addStringLocalization("tile.rottenplant.name", "nl_NL", "Verrotte Plant");
		LanguageRegistry.instance().addStringLocalization("tile.blazelog.name", "en_US", "Blaze Log");
		LanguageRegistry.instance().addStringLocalization("tile.blazelog.name", "nl_NL", "Blaze Hout");
		LanguageRegistry.instance().addStringLocalization("tile.blazeleaves.name", "en_US", "Blaze Leaves");
		LanguageRegistry.instance().addStringLocalization("tile.blazeleaves.name", "nl_NL", "Blaze Bladeren");
		LanguageRegistry.instance().addStringLocalization("tile.ghastore.name", "en_US", "Ghast Ore");
		LanguageRegistry.instance().addStringLocalization("tile.ghastore.name", "nl_NL", "Ghast Erts");
		LanguageRegistry.instance().addStringLocalization("tile.enderclam.name", "en_US", "Ender Clam");
		LanguageRegistry.instance().addStringLocalization("tile.enderclam.name", "nl_NL", "Ender Oester");
		LanguageRegistry.instance().addStringLocalization("tile.blazeSapling.name", "en_US", "Blaze Sapling");
		LanguageRegistry.instance().addStringLocalization("tile.blazeSapling.name", "nl_NL", "Blaze Kiemplant");
		LanguageRegistry.instance().addStringLocalization("tile.oreblock.sulphur.name", "en_US", "Sulphur Ore");
		LanguageRegistry.instance().addStringLocalization("tile.oreblock.sulphur.name", "nl_NL", "Zwavel Erts");
		LanguageRegistry.instance().addStringLocalization("tile.oreblock.niter.name", "en_US", "Niter Ore");
		LanguageRegistry.instance().addStringLocalization("tile.oreblock.niter.name", "nl_NL", "Salpeter Erts");
		LanguageRegistry.instance().addStringLocalization("tile.oreblock.fossil.name", "en_US", "Fossils");
		LanguageRegistry.instance().addStringLocalization("tile.oreblock.fossil.name", "nl_NL", "Fossiel");
		LanguageRegistry.instance().addStringLocalization("tile.remains.name", "en_US", "Buried Remains");
		LanguageRegistry.instance().addStringLocalization("tile.remains.name", "nl_NL", "Begraven Restanten");
		
		//item names
		LanguageRegistry.instance().addStringLocalization(sulphDust.getUnlocalizedName() + ".name", "en_US", "Sulphur Crystal");
		LanguageRegistry.instance().addStringLocalization(sulphDust.getUnlocalizedName() + ".name", "nl_NL", "Zwavel Kristal");
		LanguageRegistry.instance().addStringLocalization(niterDust.getUnlocalizedName() + ".name", "en_US", "Niter Crystal");
		LanguageRegistry.instance().addStringLocalization(niterDust.getUnlocalizedName() + ".name", "nl_NL", "Salpeter Kristal");
		LanguageRegistry.instance().addStringLocalization(flaxfibre.getUnlocalizedName() + ".name", "en_US", "Flax Fibre");
		LanguageRegistry.instance().addStringLocalization(flaxfibre.getUnlocalizedName() + ".name", "nl_NL", "Vlas Vezel");
		LanguageRegistry.instance().addStringLocalization(cloth.getUnlocalizedName() + ".name", "en_US", "Cloth");
		LanguageRegistry.instance().addStringLocalization(cloth.getUnlocalizedName() + ".name", "nl_NL", "Doek");
		LanguageRegistry.instance().addStringLocalization(flaxseed.getUnlocalizedName() + ".name", "en_US", "Flax Seed");
		LanguageRegistry.instance().addStringLocalization(flaxseed.getUnlocalizedName() + ".name", "nl_NL", "Vlas Zaad");
		LanguageRegistry.instance().addStringLocalization(cookedflesh.getUnlocalizedName() + ".name", "en_US", "Cooked Flesh");
		LanguageRegistry.instance().addStringLocalization(cookedflesh.getUnlocalizedName() + ".name", "nl_NL", "Gekookt Vlees");
		LanguageRegistry.instance().addStringLocalization(chain.getUnlocalizedName() + ".name", "en_US", "Chain Material");
		LanguageRegistry.instance().addStringLocalization(chain.getUnlocalizedName() + ".name", "nl_NL", "Keten Materiaal");
		LanguageRegistry.instance().addStringLocalization(rottenseed.getUnlocalizedName() + ".name", "en_US", "Rotten Seed");
		LanguageRegistry.instance().addStringLocalization(rottenseed.getUnlocalizedName() + ".name", "nl_NL", "Verrot Zaad");
		
		Item.itemsList[OreBlockID] = new ItemPeacefulOresblock(OreBlockID-256, oreblock).setUnlocalizedName("oreblock");
		
		//bonemeal
		MinecraftForge.EVENT_BUS.register(new PeacefulEvent());
		
		GameRegistry.addSmelting(Item.rottenFlesh.itemID, new ItemStack(cookedflesh, 1), 1F);
		
		//recipes
		GameRegistry.addRecipe(new ItemStack(slimeslab, 1), new Object[]
		        {
		        	"XX", "XX", 'X', Item.slimeBall
		        });
		GameRegistry.addShapelessRecipe(new ItemStack(Item.gunpowder, 2), new Object[]
		        {
		        	new ItemStack(sulphDust), new ItemStack(niterDust), new ItemStack(Item.coal)
		        });
		GameRegistry.addShapelessRecipe(new ItemStack(Item.gunpowder, 2), new Object[]
		        {
		        	new ItemStack(sulphDust), new ItemStack(niterDust), new ItemStack(Item.coal, 1)
		        });
		        
		GameRegistry.addRecipe(new ItemStack(Block.torchWood, 4), new Object[]
		        {
		        	"X", "Z", 'X', sulphDust, 'Z', Item.stick
		        });
		        
		GameRegistry.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 15), new Object[]
		        {
		        	new ItemStack(Item.dyePowder, 1, 15), new ItemStack(niterDust)
		        });   
		        
		GameRegistry.addShapelessRecipe(new ItemStack(Item.silk, 2), new Object[]
		        {
		        	new ItemStack(flaxfibre), new ItemStack(flaxfibre)
		        });
		        
		GameRegistry.addShapelessRecipe(new ItemStack(flaxseed, 3), new Object[]
				{
					new ItemStack(flaxfibre)
				});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Block.cloth, 1, 0), new Object[]
		       {
		        	new ItemStack(cloth), new ItemStack(cloth)
		       });
		        
		GameRegistry.addShapelessRecipe(new ItemStack(cloth, 1), new Object[]
		       {
		        	new ItemStack(Item.silk), new ItemStack(Item.silk)
		       });
		GameRegistry.addRecipe(new ItemStack(chain, 6), new Object[]
				{
					"XXX", "XXX", "XXX", 'X', Block.fenceIron
				});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.book), new Object[]
				{
					new ItemStack(Item.paper), new ItemStack(Item.paper), new ItemStack(Item.paper), new ItemStack(cloth)
				});
		
		//leather armor
		GameRegistry.addRecipe(new ItemStack(Item.helmetLeather, 1), new Object[]
		       {
		       		"XXX", "X X", 'X', cloth
		       });
		GameRegistry.addRecipe(new ItemStack(Item.plateLeather, 1), new Object[]
		       {
		        	"X X", "XXX", "XXX", 'X', cloth
		       });
		GameRegistry.addRecipe(new ItemStack(Item.bootsLeather, 1), new Object[]
		       {
		        	"X X", "X X", 'X', cloth
		       });
		GameRegistry.addRecipe(new ItemStack(Item.legsLeather, 1), new Object[]
		        {
		        	"XXX", "X X", "X X", 'X', cloth
		        });
		
		//chain armor
		GameRegistry.addRecipe(new ItemStack(Item.helmetChain, 1), new Object[]
			    {
			    	"XXX", "X X", 'X', chain
			    });
		GameRegistry.addRecipe(new ItemStack(Item.plateChain, 1), new Object[]
			    {
			     	"X X", "XXX", "XXX", 'X', chain
			    });
		GameRegistry.addRecipe(new ItemStack(Item.bootsChain, 1), new Object[]
			    {
			     	"X X", "X X", 'X', chain
			    });
		GameRegistry.addRecipe(new ItemStack(Item.legsChain, 1), new Object[]
			    {
			      	"XXX", "X X", "X X", 'X', chain
			    });
		
		GameRegistry.addRecipe(new ItemStack(Item.ghastTear, 4), new Object[]
				{
					"XXX", "XZX", "XXX", 'Z', Item.bucketLava, 'X', ghastore
				});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Item.leather), new Object[]
				{
					new ItemStack(cookedflesh), new ItemStack(cookedflesh)
				});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.writableBook, 1), new Object[]
				{
					new ItemStack(Item.book), new ItemStack(niterDust), new ItemStack(Item.feather)
				});
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		GameRegistry.registerPlayerTracker(new PeacefulPackLogin());
	}
}
