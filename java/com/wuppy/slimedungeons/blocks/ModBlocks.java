package com.wuppy.slimedungeons.blocks;

import com.wuppy.slimedungeons.SlimeDungeon;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class ModBlocks
{
	public static Block slimeCobble;
	public static Block slimeBlock;
	
	public static void init()
	{
		slimeCobble = new BlockSlimeCobble();
		slimeBlock = new BlockSlimeBlock();
	}
	
	public static void registerModels(FMLPostInitializationEvent event)
	{
		if(event.getSide() == Side.CLIENT)
		{
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
	        
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(slimeBlock), 0, new ModelResourceLocation(SlimeDungeon.MODID + ":" + ((BlockSlimeBlock) slimeBlock).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(slimeCobble), 0, new ModelResourceLocation(SlimeDungeon.MODID + ":" + ((BlockSlimeCobble) slimeCobble).getName(), "inventory"));
		}
	}
}