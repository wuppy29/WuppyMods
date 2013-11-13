package slimedungeons;

import java.io.IOException;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
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

@Mod(modid = SlimeDungeon.modid, name = "Slime Dungeons", version = "1.5.6")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class SlimeDungeon 
{
	public static final String modid = "wuppy29_slimedungeon";
	
	public static final int VERSION = 1;
	public static String updates = "";
	public static boolean outdated = false;
	
	static int startEntityId = 300;
	
	@SidedProxy(clientSide = "slimedungeons.ClientProxySlime", serverSide = "slimedungeons.CommonProxySlime")
    public static CommonProxySlime proxy;
	
	public static int SlimeCobbleStoneId;
	public static int SlimeBlockID;
	
	public static Block SlimeCobble;
	public static Block SlimeBlock;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		SlimeCobbleStoneId = config.getBlock("Slime Cobblestone ID", Configuration.CATEGORY_BLOCK, 315).getInt();
		SlimeBlockID = config.getBlock("Slime Block ID", Configuration.CATEGORY_BLOCK, 316).getInt();
		
		config.save();
		
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
		
		SlimeCobble = new BlockSlimeCobble(SlimeCobbleStoneId).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setUnlocalizedName("slimecobble");
		SlimeBlock = new BlockSlimeBlock(SlimeBlockID).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setUnlocalizedName("slimeblock");
		
		GameRegistry.registerBlock(SlimeBlock, "Wuppy29_SlimeBlock");
		GameRegistry.registerBlock(SlimeCobble, "Wuppy29_SlimeCobble");
		
		LanguageRegistry.instance().addStringLocalization("tile.slimecobble.name", "en_US", "Slime Cobblestone");
		LanguageRegistry.instance().addStringLocalization("tile.slimecobble.name", "nl_NL", "Slijmerige Kiezelsteen");
		LanguageRegistry.instance().addStringLocalization("tile.slimeblock.name", "en_US", "Slime Block");
		LanguageRegistry.instance().addStringLocalization("tile.slimeblock.name", "nl_NL", "Slijmerig Blok");
		
		EntityRegistry.registerModEntity(EntitySlimeZombie.class, "SlimeZombie", 44, this, 40, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.wuppy29_slimedungeon.SlimeZombie.name", "Slime Zombie");
		registerEntityEgg(EntitySlimeZombie.class, 0x009696, 0x478c36);
		
		GameRegistry.registerWorldGenerator(new SlimeGenerator());
		
		GameRegistry.addShapelessRecipe(new ItemStack(SlimeCobble), new Object[]
				{
					new ItemStack(Block.cobblestone), new ItemStack(Item.slimeBall)
				});
		
		GameRegistry.addRecipe(new ItemStack(SlimeBlock, 2), new Object[]
				{
					"XXX", "XXX", "XXX", 'X', Item.slimeBall
				});
		
		GameRegistry.addSmelting(SlimeCobble.blockID, new ItemStack(Item.slimeBall), 0.2F);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		GameRegistry.registerPlayerTracker(new SlimeDungeonLogin());
	}
	
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
		} while (EntityList.getStringFromID(startEntityId) != null);
		
		return startEntityId;
	}
}