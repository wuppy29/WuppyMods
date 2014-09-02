package com.wuppy.improvedmobspawn;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.biome.BiomeGenBase;

import com.wuppy.improvedmobspawn.entity.EntityCaveSpiderCustom;
import com.wuppy.improvedmobspawn.entity.EntitySpiderCustom;
import com.wuppy.improvedmobspawn.entity.EntityWitherSkeleton;
import com.wuppy.improvedmobspawn.proxies.CommonProxyIMP;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ImprovedMobs.modid, name = "Improved Mob Spawn", version = "1.5.3")
public class ImprovedMobs
{
	public static final String modid = "wuppy29_improvedmobspawn";

	@SidedProxy(clientSide = "com.wuppy.improvedmobspawn.proxies.ClientProxyIMP", serverSide = "com.wuppy.improvedmobspawn.proxies.CommonProxyIMP")
	public static CommonProxyIMP proxy;

	public static final int VERSION = 4;
	public static String updates = "";
	public static boolean outdated = false;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(this);
		
		Config.loadConfig(event);
		
		if(Config.checkForUpdates)
			UpdateChecker.checkForUpdates();

		proxy.registerRenderThings();

		GameRegistry.registerWorldGenerator(new ImprovedMobsGenerator(), 0);

		EntityRegistry.registerModEntity(EntityCaveSpiderCustom.class, "cavespiderc", 1, this, 80, 3, true);
		EntityRegistry.registerModEntity(EntitySpiderCustom.class, "spiderc", 2, this, 80, 3, true);
		EntityRegistry.registerModEntity(EntityWitherSkeleton.class, "witherskeleton", 3, this, 80, 3, true);

		EntityRegistry.addSpawn(EntityBlaze.class, Config.blazeSpawnChance, 1, 3, EnumCreatureType.monster, BiomeGenBase.hell);
		EntityRegistry.addSpawn(EntityMagmaCube.class, Config.magmaCubeSpawnChance, 2, 4, EnumCreatureType.monster, BiomeGenBase.hell);
		EntityRegistry.addSpawn(EntityWitherSkeleton.class, Config.witherSkeletonSpawnChance, 1, 2, EnumCreatureType.monster, BiomeGenBase.hell);

		// spawns
		for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++)
		{
			if (BiomeGenBase.getBiomeGenArray()[i] != null)
			{
				EntityRegistry.removeSpawn(EntitySpider.class, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
				EntityRegistry.addSpawn(EntitySpiderCustom.class, 10, 4, 4, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
				EntityRegistry.addSpawn(EntityCaveSpiderCustom.class, 4, 3, 5, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
			}
		}
	}

	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		if(outdated)
		{
			event.player.addChatComponentMessage(new ChatComponentText("Koi is outdated."));
			event.player.addChatComponentMessage(new ChatComponentText("Changelog: "));
			event.player.addChatComponentMessage(new ChatComponentText(updates));
		}
	}
}