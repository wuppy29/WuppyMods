package slimedungeons;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = SlimeDungeon.modid, name = "Slime Dungeons", version = "1.5.5")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class SlimeDungeon 
{
	public static final String modid = "wuppy29_slimedungeon";
	
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
}