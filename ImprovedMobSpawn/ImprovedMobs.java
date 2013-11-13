package ImprovedMobSpawn;

import java.io.IOException;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySpider;
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

@Mod(modid = ImprovedMobs.modid, name = "Improved Mob Spawn", version = "1.4.3")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ImprovedMobs
{
	public static final String modid = "wuppy29_improvedmobspawn";
	
	@SidedProxy(clientSide = "ImprovedMobSpawn.ClientProxyIMP", serverSide = "ImprovedMobSpawn.CommonProxyIMP")
	public static CommonProxyIMP proxy;
	
	public static final int VERSION = 1;
	public static String updates = "";
	public static boolean outdated = false;
	
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
		
		GameRegistry.registerWorldGenerator(new ImprovedMobsGenerater());
		
		EntityRegistry.registerModEntity(EntityCaveSpiderCustom.class, "cavespiderc", 1, this, 80, 3, true);
		EntityRegistry.registerModEntity(EntitySpiderCustom.class, "spiderc", 2, this, 80, 3, true);
		
		LanguageRegistry.instance().addStringLocalization("entity.Wuppy29_ImprovedMobSpawn.cavespiderc.name", "Cave Spider");
		LanguageRegistry.instance().addStringLocalization("entity.Wuppy29_ImprovedMobSpawn.spiderc.name", "Spider");
		
		EntityRegistry.addSpawn(EntityBlaze.class, 1, 1, 3, EnumCreatureType.monster, BiomeGenBase.hell);
		EntityRegistry.addSpawn(EntityMagmaCube.class, 2, 2, 4, EnumCreatureType.monster, BiomeGenBase.hell);
		
		//spawns
		for (int i = 0; i < BiomeGenBase.biomeList.length; i++)
		{
			if (BiomeGenBase.biomeList[i] != null)
			{
				EntityRegistry.removeSpawn(EntitySpider.class, EnumCreatureType.monster, BiomeGenBase.biomeList[i]);
				EntityRegistry.addSpawn(EntitySpiderCustom.class, 10, 4, 4, EnumCreatureType.monster, BiomeGenBase.biomeList[i]);
				EntityRegistry.addSpawn(EntityCaveSpiderCustom.class, 4, 3, 5, EnumCreatureType.monster, BiomeGenBase.biomeList[i]);
			}
		}
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		GameRegistry.registerPlayerTracker(new ImprovedMobSpawnLogin());
	}
}