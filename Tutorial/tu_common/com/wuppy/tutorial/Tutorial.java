package com.wuppy.tutorial;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class Tutorial
{
    public static Block tutorialBlock;
    
    public static Item tutorialItem;
    
    TutorialEventHandler handler = new TutorialEventHandler();
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	FMLCommonHandler.instance().bus().register(handler);
    	MinecraftForge.EVENT_BUS.register(handler);
    	
    	tutorialBlock = new BlockTutorial();
    	
    	GameRegistry.registerBlock(tutorialBlock, "tutorialBlock");
    	
    	tutorialItem = new ItemTutorial();
    	
    	GameRegistry.registerItem(tutorialItem, "tutorialItem");
    	
    	GameRegistry.addRecipe(new ItemStack(Blocks.obsidian), new Object[]{
    		"AAA",
    		"AAA",
    		"AAA",
    		'A', Items.cookie
    	});
    	GameRegistry.addRecipe(new ItemStack(Items.apple, 4), new Object[]{
    		"AA",
    		"AA",
    		'A', Blocks.cobblestone
    	});
    	GameRegistry.addRecipe(new ItemStack(Items.dye, 2, 15), new Object[]{
    		"AB ",
    		"AAC",
    		"A  ",
    		'A', Items.cookie, 'B', Blocks.dirt, 'C', new ItemStack(Items.dye, 1, 1)
    	});
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, 1), new Object[]
    	{
    		new ItemStack(Items.dye, 1, 1), Items.redstone
    	});
    	
    	GameRegistry.addSmelting(new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 11), 0.1F);
    }
}