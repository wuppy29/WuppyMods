package snowgolem;

import java.io.IOException;

import net.minecraft.block.Block;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = CleanSnowGolem.modid, name = "Clean Snow Golem", version = "1.5.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class CleanSnowGolem 
{
	public static final String modid = "wuppy29_snowgolem";
	
	public static final int VERSION = 1;
	public static String updates = "";
	public static boolean outdated = false;
	
	@SidedProxy(clientSide = "snowgolem.ClientProxySG", serverSide = "snowgolem.CommonProxySG")
	public static CommonProxySG proxy;
	
	public static int customPumpkinID = Block.pumpkin.blockID;
	public static Block customPumpkin;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
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
		proxy.registerRenderThings();
		
		Block.blocksList[customPumpkinID] = null;
		
		customPumpkin = (new BlockCustomPumpkin(customPumpkinID, false)).setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("pumpkin").setTextureName("pumpkin");
		
		EntityRegistry.registerModEntity(EntityCleanSnowGolem.class, "snow golem", 1, this, 80, 3, true);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		GameRegistry.registerPlayerTracker(new SnowGolemLogin());
	}
}
