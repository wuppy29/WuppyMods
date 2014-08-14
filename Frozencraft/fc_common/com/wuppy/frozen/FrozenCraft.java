package com.wuppy.frozen;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

import com.wuppy.frozen.blocks.ModBlocks;
import com.wuppy.frozen.entities.ModEntities;
import com.wuppy.frozen.generation.ModGeneration;
import com.wuppy.frozen.handlers.Config;
import com.wuppy.frozen.handlers.ModEvents;
import com.wuppy.frozen.handlers.ModRecipes;
import com.wuppy.frozen.handlers.UpdateChecker;
import com.wuppy.frozen.items.ModItems;
import com.wuppy.frozen.items.ModMaterials;
import com.wuppy.frozen.network.FrozenIceBoltRemoveMessage;
import com.wuppy.frozen.network.FrozenIceBoltRemoveMessageHandler;
import com.wuppy.frozen.network.FrozenIceBoltSpawnMessage;
import com.wuppy.frozen.network.FrozenIceBoltSpawnMessageHandler;
import com.wuppy.frozen.proxies.CommonProxyFrozen;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = FrozenCraft.modid, name = "Frozencraft", version = "1.0.0.0")
public class FrozenCraft
{
	public static final int VERSION = 1;
	
	public static final String modid = "wuppy29_frozencraft";
	
	@SidedProxy(clientSide = "com.wuppy.frozen.proxies.ClientProxyFrozen", serverSide = "com.wuppy.frozen.proxies.CommonProxyFrozen")
	public static CommonProxyFrozen proxy;

	ModEvents events = new ModEvents();
	
	public static SimpleNetworkWrapper frozenCraftNetworkManager;
	
	public static CreativeTabs fcArmor = new FrozenCraftTab(CreativeTabs.getNextID(), "fc_armor");
	
	public static ToolMaterial iceSawMaterial = EnumHelper.addToolMaterial("iceSawMaterial", 2, 250, 6.0F, 2.0F, 14);
	public static ToolMaterial gearMaterial = EnumHelper.addToolMaterial("gearMaterial", 2, 350, 7.0F, 2.5F, 14);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//Event registry
		FMLCommonHandler.instance().bus().register(events);
		MinecraftForge.EVENT_BUS.register(events);
		
		//Packet registry
		frozenCraftNetworkManager = NetworkRegistry.INSTANCE.newSimpleChannel(modid);
		frozenCraftNetworkManager.registerMessage(FrozenIceBoltSpawnMessageHandler.class, FrozenIceBoltSpawnMessage.class, 0, Side.SERVER);
		frozenCraftNetworkManager.registerMessage(FrozenIceBoltRemoveMessageHandler.class, FrozenIceBoltRemoveMessage.class, 1, Side.SERVER);
		
		//pre setup stuff
		Config.loadConfig(event);
		
		if(Config.checkForUpdates)
			UpdateChecker.checkForUpdates();
		
		proxy.registerRenders();
		
		//setup
		new ModMaterials();
		
		ModBlocks.loadBlocks();
		
		ModItems.loadItems();
		
		ModEntities.loadEntities(this);
		
		ModGeneration.generate();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		ModRecipes.loadRecipes();
		
		FrozenData.init();
	}
}