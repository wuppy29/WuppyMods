package medicine;

import medicine.core.CommonProxyHealth;
import medicine.item.ItemHealthFood;
import medicine.item.ItemMaterials;
import medicine.table.BlockMedicTable;
import medicine.table.TileEntityMedicTable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Medicine.modid, name = "Medicine Mod", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Medicine
{
	public static final String modid = "wuppy29_medicinemod";
	
	@SidedProxy(clientSide = "medicine.core.ClientProxyHealth", serverSide = "medicine.core.CommonProxyHealth")
    public static CommonProxyHealth proxy;
	
	@Instance("Medicine Mod")
	public static Medicine instance;

	public static int HealthPackID;
	public static int RegenerationPackID;
	public static int MaterialID;
	public static int NormalSteroidSyringeID;
	public static int MediumSteroidSyringeID;
	public static int UltraSteroidSyringeID;
	public static int NormalAdrenalinSyringeID;
	public static int MediumAdrenalinSyringeID;
	public static int UltraAdrenalinSyringeID;
	
	public static int MedicTableID;

	public static Item healthPack;
	public static Item regenPack;
	public static Item material;
	public static Item normalsyringe;
	public static Item mediumsyringe;
	public static Item ultrasyringe;
	public static Item normaladrensyringe;
	public static Item mediumadrensyringe;
	public static Item ultraadrensyringe;
	
	public static Block medictable;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();
		HealthPackID = config.getItem("Health Pack ID", Configuration.CATEGORY_ITEM, 4015).getInt();
		RegenerationPackID = config.getItem("Regeneration Pack ID", Configuration.CATEGORY_ITEM, 4016).getInt();
		MaterialID = config.getItem("Material Items ID", Configuration.CATEGORY_ITEM, 4044).getInt();
		
		NormalSteroidSyringeID = config.getItem("Normal Steroid Syringe ID", Configuration.CATEGORY_ITEM, 4045).getInt();
		MediumSteroidSyringeID = config.getItem("Medium Steroid Syringe ID", Configuration.CATEGORY_ITEM, 4046).getInt();
		UltraSteroidSyringeID = config.getItem("Ultra Steroid Syringe ID", Configuration.CATEGORY_ITEM, 4047).getInt();
		
		NormalAdrenalinSyringeID = config.getItem("Normal Adrenalin Syringe ID", Configuration.CATEGORY_ITEM, 4048).getInt();
		MediumAdrenalinSyringeID = config.getItem("Medium Adrenalin Syringe ID", Configuration.CATEGORY_ITEM, 4049).getInt();
		UltraAdrenalinSyringeID = config.getItem("Ultra Steroid Syringe ID", Configuration.CATEGORY_ITEM, 4050).getInt();
		
		MedicTableID = config.getBlock("Medic Table ID", Configuration.CATEGORY_BLOCK, 3010).getInt();
		
		config.save();
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();

		//Items
		healthPack = new ItemHealthFood(HealthPackID, 10, false).setAlwaysEdible().setPotionEffect(Potion.heal.id, 1, 1, 1F).setUnlocalizedName("healthPack");
		regenPack = new ItemHealthFood(RegenerationPackID, 10, false).setAlwaysEdible().setPotionEffect(Potion.regeneration.id, 5, 2, 1F).setUnlocalizedName("regenPack");
		material = new ItemMaterials(MaterialID).setUnlocalizedName("material");
		
		normalsyringe = new ItemHealthFood(NormalSteroidSyringeID, 0, true).setAlwaysEdible().setPotionEffect(Potion.damageBoost.id, 20, 1, 1.0F).setUnlocalizedName("normalsyringe");
		mediumsyringe = new ItemHealthFood(MediumSteroidSyringeID, 0, true).setAlwaysEdible().setPotionEffect(Potion.damageBoost.id, 40, 2, 1.0F).setUnlocalizedName("mediumsyringe");
		ultrasyringe = new ItemHealthFood(UltraSteroidSyringeID, 0, true).setAlwaysEdible().setPotionEffect(Potion.damageBoost.id, 300, 2, 1.0F).setUnlocalizedName("ultrasyringe");
		
		normaladrensyringe = new ItemHealthFood(NormalAdrenalinSyringeID, 0, true).setAlwaysEdible().setPotionEffect(Potion.moveSpeed.id, 20, 1, 1.0F).setSecondPotionEffect(Potion.digSpeed.id, 20, 1, 1.0F).setUnlocalizedName("normaladrensyringe");
		mediumadrensyringe = new ItemHealthFood(MediumAdrenalinSyringeID, 0, true).setAlwaysEdible().setPotionEffect(Potion.moveSpeed.id, 40, 1, 1.0F).setSecondPotionEffect(Potion.digSpeed.id, 40, 2, 1.0F).setUnlocalizedName("mediumadrensyringe");
		ultraadrensyringe = new ItemHealthFood(UltraAdrenalinSyringeID, 0, true).setAlwaysEdible().setPotionEffect(Potion.moveSpeed.id, 120, 2, 1.0F).setSecondPotionEffect(Potion.digSpeed.id, 120, 3, 1.0F).setUnlocalizedName("ultraadrensyringe");
		
		LanguageRegistry.addName(healthPack, "Health Pack");
		LanguageRegistry.addName(regenPack, "Regeneration Pack");
		
		LanguageRegistry.addName(new ItemStack(material, 1, 0), "Empty Normal Syringe");
		LanguageRegistry.addName(new ItemStack(material, 1, 1), "Empty Medium Syringe");
		LanguageRegistry.addName(new ItemStack(material, 1, 2), "Empty Ultra Syringe");
		LanguageRegistry.addName(new ItemStack(material, 1, 3), "Medical Golden Apple");
		LanguageRegistry.addName(new ItemStack(material, 1, 4), "Blue Apple");
		LanguageRegistry.addName(new ItemStack(material, 1, 5), "Diamond Apple");
		LanguageRegistry.addName(new ItemStack(material, 1, 6), "Normal Adrenaline Dust");
		LanguageRegistry.addName(new ItemStack(material, 1, 7), "Medium Adrenaline Dust");
		LanguageRegistry.addName(new ItemStack(material, 1, 8), "Ultra Adrenaline Dust");
		LanguageRegistry.addName(new ItemStack(material, 1, 9), "Second Syringe Normal");
		LanguageRegistry.addName(new ItemStack(material, 1, 10), "Second Syringe High");
		
		LanguageRegistry.addName(normalsyringe, "Normal Steroid Syringe");
		LanguageRegistry.addName(mediumsyringe, "Medium Steroid Syringe");
		LanguageRegistry.addName(ultrasyringe, "Ultra Steroid Syringe");
		
		LanguageRegistry.addName(normaladrensyringe, "Normal Adrenalin Syringe");
		LanguageRegistry.addName(mediumadrensyringe, "Medium Adrenalin Syringe");
		LanguageRegistry.addName(ultraadrensyringe, "Ultra Adrenalin Syringe");
		
		//Block
		medictable = new BlockMedicTable(MedicTableID, Material.iron).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("medictable");
		
		GameRegistry.registerBlock(medictable, "Wuppy29_MedicTable");
		LanguageRegistry.addName(medictable, "Medic Table");
		
		GameRegistry.registerTileEntity(TileEntityMedicTable.class, "TileEntityMedicTable");
		
		MedicCrafter.registerCrafting();
		
		//NetworkRegistry.instance().registerGuiHandler(instance, proxy);
	}
}
