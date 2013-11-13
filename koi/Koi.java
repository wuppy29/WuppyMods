package koi;

import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
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

@Mod(modid = Koi.modid, name = "Koi", version = "1.10.4")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Koi
{
	public static final String modid = "wuppy29_koi";
	
	public static final int VERSION = 1;
	public static String updates = "";
	public static boolean outdated = false;
	
	@SidedProxy(clientSide = "koi.ClientProxyKoi", serverSide = "koi.CommonProxyKoi")
	public static CommonProxyKoi proxy;
	
	static int startEntityId = 300;
	
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
		
		EntityRegistry.registerModEntity(Entitykoi.class, "Koi", 44, this, 40, 1, true);
		EntityRegistry.addSpawn(Entitykoi.class, 10, 2, 4, EnumCreatureType.waterCreature, BiomeGenBase.beach, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.ocean, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.swampland);
		LanguageRegistry.instance().addStringLocalization("entity.wuppy29_koi.Koi.name", "Koi");
		
		registerEntityEgg(Entitykoi.class, 0x4A8FFF, 0xFFDB4A);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		GameRegistry.registerPlayerTracker(new KoiLogin());
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