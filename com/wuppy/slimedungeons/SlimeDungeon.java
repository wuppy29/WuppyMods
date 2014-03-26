package com.wuppy.slimedungeons;

import java.io.IOException;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = SlimeDungeon.modid, name = "Slime Dungeons", version = "1.6.0")
public class SlimeDungeon
{
	public static final String modid = "wuppy29_slimedungeon";

	public static final int VERSION = 2;
	public static String updates = "";
	public static boolean outdated = false;

	static int startEntityId = 300;

	@SidedProxy(clientSide = "com.wuppy.slimedungeons.ClientProxySlime", serverSide = "com.wuppy.slimedungeons.CommonProxySlime")
	public static CommonProxySlime proxy;

	public static Block SlimeCobble;
	public static Block SlimeBlock;

	public static boolean checkForUpdates = true;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(this);
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		checkForUpdates = config.get(Configuration.CATEGORY_GENERAL, "Check Updates", true).getBoolean(true);

		config.save();

		if (checkForUpdates)
		{
			try
			{
				UpdateChecker.checkForUpdates();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		proxy.registerRenderThings();

		SlimeCobble = new BlockSlimeCobble().setStepSound(Block.soundTypeStone).setHardness(3F).setResistance(1.0F).setBlockName("slimecobble").setBlockTextureName(modid + ":" + "slimecobble");
		SlimeBlock = new BlockSlimeBlock().setStepSound(Block.soundTypeStone).setHardness(3F).setResistance(1.0F).setBlockName("slimeblock").setBlockTextureName(modid + ":" + "slimeblock");

		GameRegistry.registerBlock(SlimeBlock, "Wuppy29_SlimeBlock");
		GameRegistry.registerBlock(SlimeCobble, "Wuppy29_SlimeCobble");

		EntityRegistry.registerModEntity(EntitySlimeZombie.class, "SlimeZombie", 44, this, 40, 1, true);
		registerEntityEgg(EntitySlimeZombie.class, 0x009696, 0x478c36);

		GameRegistry.registerWorldGenerator(new SlimeGenerator(), 1);

		GameRegistry.addShapelessRecipe(new ItemStack(SlimeCobble), new Object[] { new ItemStack(Blocks.cobblestone), new ItemStack(Items.slime_ball) });

		GameRegistry.addRecipe(new ItemStack(SlimeBlock, 2), new Object[] { "XXX", "XXX", "XXX", 'X', Items.slime_ball });

		GameRegistry.addSmelting(SlimeCobble, new ItemStack(Items.slime_ball), 0.2F);
	}

	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		if(outdated)
		{
			event.player.addChatComponentMessage(new ChatComponentText("Magical Experience is outdated."));
			event.player.addChatComponentMessage(new ChatComponentText("Changelog: "));
			event.player.addChatComponentMessage(new ChatComponentText(updates));
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor)
	{
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}

	public static int getUniqueEntityId()
	{
		do
		{
			startEntityId++;
		}
		while (EntityList.getStringFromID(startEntityId) != null);

		return startEntityId;
	}
}