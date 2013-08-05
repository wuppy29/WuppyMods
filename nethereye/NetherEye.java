package nethereye;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = NetherEye.modid, name = "Nether Eye", version = "1.2.5")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class NetherEye 
{
	public static final String modid = "wuppy29_nethereye";
	
	public static int NetherEyeID;
	
	public static Item nethereye;
	
	@SidedProxy(clientSide = "nethereye.ClientProxyNetherEye", serverSide = "nethereye.CommonProxyNetherEye")
    public static CommonProxyNetherEye proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		NetherEyeID = config.getItem("Nether Eye ID", Configuration.CATEGORY_ITEM, 4035).getInt();
		
		config.save();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) 
	{
		nethereye = new ItemNetherEye(NetherEyeID).setUnlocalizedName("nethereye");
		
		LanguageRegistry.addName(nethereye, "Nether Eye");
		
		GameRegistry.addShapelessRecipe(new ItemStack(nethereye, 1), new Object[]
				{
					new ItemStack(Item.enderPearl), new ItemStack(Item.magmaCream)
				});
		GameRegistry.addRecipe(new ItemStack(nethereye, 1), new Object[]
				{
					" X ", "CVC", " X ", 'X', Item.goldNugget, 'C', Item.glowstone, 'V', Item.enderPearl
				});
		GameRegistry.addRecipe(new ItemStack(nethereye, 1), new Object[]
				{
					" X ", "CVC", " X ", 'C', Item.goldNugget, 'X', Item.glowstone, 'V', Item.enderPearl
				});
		
		EntityRegistry.registerModEntity(EntityNetherEye.class, "Nether Eye", 44, this, 40, 1, true);
		
		DimensionManager.unregisterProviderType(-1);
		DimensionManager.registerProviderType(-1, WorldProviderCustomHell.class, false);
		
		proxy.registerEntityRender();
	}
}
