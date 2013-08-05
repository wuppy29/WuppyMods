package jellycubes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = JellyCube.modid, name = "Jelly Cubes", version = "1.12.3")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class JellyCube 
{
	public static final String modid = "wuppy29_jellycubes";
	
	public static int JellyCubeID;
	
	public static Item jellycube;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		JellyCubeID = config.getItem("Jelly Cube ID", Configuration.CATEGORY_ITEM, 4000).getInt();
		config.save();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) 
	{
		jellycube = new ItemJellyFood(JellyCubeID, 6, false).setUnlocalizedName("jelly cube");
		
		LanguageRegistry.addName(jellycube, "Jelly Cube");
		
		GameRegistry.addShapelessRecipe(new ItemStack(jellycube, 1), new Object[]
				{
					new ItemStack(Item.slimeBall), new ItemStack(Item.slimeBall)
				});
	}
}
