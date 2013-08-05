package goblinsgiants;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;

public class ConfigLoader
{
	public static void loadConfig(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();
		GoblinGiant.dimension = config.get("Dimension ID", Configuration.CATEGORY_GENERAL, 12).getInt();

		//Blocks config
		GoblinGiant.GoblinPortalBlockID = config.getBlock("Savannah Portal ID", Configuration.CATEGORY_BLOCK, 300).getInt();
		GoblinGiant.RedCactusBlockID = config.getBlock("Red Cactus ID", Configuration.CATEGORY_BLOCK, 301).getInt();
		GoblinGiant.OreBlockID = config.getBlock("Ore Blocks ID", Configuration.CATEGORY_BLOCK, 302).getInt();
		GoblinGiant.CustomStoneID = config.getBlock("Custom Stone ID", Configuration.CATEGORY_BLOCK, 303).getInt();
		GoblinGiant.SavannahTNTID = config.getBlock("Savannah TNT ID", Configuration.CATEGORY_BLOCK, 318).getInt();
		GoblinGiant.CustomWoodID = config.getBlock("Custom Wood ID", Configuration.CATEGORY_BLOCK, 319).getInt();

		//Item config
		GoblinGiant.VampireBloodID = config.getItem("Vampire Blood ID", Configuration.CATEGORY_ITEM, 4001).getInt();
		GoblinGiant.BoneSpearID = config.getItem("Bone Spear ID", Configuration.CATEGORY_ITEM, 4002).getInt();
		GoblinGiant.UrukSwordID = config.getItem("Uruk Sword ID", Configuration.CATEGORY_ITEM, 4003).getInt();
		GoblinGiant.WoodPoisonSwordID = config.getItem("Wooden Poison Sword ID", Configuration.CATEGORY_ITEM, 4004).getInt();
		GoblinGiant.StonePoisonSwordID = config.getItem("Stone Poison Sword ID", Configuration.CATEGORY_ITEM, 4005).getInt();
		GoblinGiant.IronPoisonSwordID = config.getItem("Iron Poison Sword ID", Configuration.CATEGORY_ITEM, 4006).getInt();
		GoblinGiant.GoldPoisonSwordID = config.getItem("Gold Poison Sword ID", Configuration.CATEGORY_ITEM, 4007).getInt();
		GoblinGiant.DiamondPoisonSwordID = config.getItem("Diamond Poison Sword ID", Configuration.CATEGORY_ITEM, 4008).getInt();
		GoblinGiant.KeyID = config.getItem("Key ID", Configuration.CATEGORY_ITEM, 4009).getInt();
		GoblinGiant.CookedRedCactusID = config.getItem("Cooked Red Cactus ID", Configuration.CATEGORY_ITEM, 4010).getInt();
		GoblinGiant.GemID = config.getItem("Gem ID", Configuration.CATEGORY_ITEM, 4011).getInt();
		GoblinGiant.WaterHoeID = config.getItem("Water Hoe ID", Configuration.CATEGORY_ITEM, 4012).getInt();
		GoblinGiant.CreeperBowID = config.getItem("Creeper Bow ID", Configuration.CATEGORY_ITEM, 4013).getInt();
		GoblinGiant.PortalPlacerID = config.getItem("Portal Placer ID", Configuration.CATEGORY_ITEM, 4014).getInt();

		config.save();
	}
}
