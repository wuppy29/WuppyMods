package com.wuppy.peacefulpackmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

import com.wuppy.peacefulpackmod.PeacefulPack;

public class ModBlocks
{
	public static Block oreBlock;
	public static Block flax;
	public static Block slimeSlab;
	public static Block rottenPlant;
	public static Block blazeLog;
	public static Block blazeLeaves;
	public static Block ghastOre;
	public static Block enderClam;
	public static Block blazeSapling;
	public static Block remains;

	public static void init(FMLPreInitializationEvent event)
	{
		oreBlock = new BlockPeacefulOres();
		flax = new BlockFlax();
		slimeSlab = new BlockSlimeSlab();
		rottenPlant = new BlockRottenPlant();
		blazeLog = new BlockBlazeLog();
		blazeLeaves = new BlockBlazeLeaves();
		ghastOre = new BlockGhastOre();
		enderClam = new BlockEnderclam();
		blazeSapling = new BlockBlazeSapling();
		remains = new BlockRemains();

		if (event.getSide() == Side.CLIENT)
		{
			BlockPeacefulOres.OreType.registerVariants();
		}
	}

	public static void postInit(FMLPostInitializationEvent event)
	{
		if (event.getSide() == Side.CLIENT)
		{
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

			BlockPeacefulOres.OreType.registerRenders();
			
			renderItem.getItemModelMesher().register(Item.getItemFromBlock(flax), 0, new ModelResourceLocation(PeacefulPack.modid + ":" + ((BlockFlax) flax).getName(), "inventory"));

			renderItem.getItemModelMesher().register(Item.getItemFromBlock(slimeSlab), 0, new ModelResourceLocation(PeacefulPack.modid + ":" + ((BlockSlimeSlab) slimeSlab).getName(), "inventory"));
			renderItem.getItemModelMesher().register(Item.getItemFromBlock(rottenPlant), 0, new ModelResourceLocation(PeacefulPack.modid + ":" + ((BlockRottenPlant) rottenPlant).getName(), "inventory"));
			renderItem.getItemModelMesher().register(Item.getItemFromBlock(blazeLog), 0, new ModelResourceLocation(PeacefulPack.modid + ":" + ((BlockBlazeLog) blazeLog).getName(), "inventory"));

			renderItem.getItemModelMesher().register(Item.getItemFromBlock(blazeLeaves), 0, new ModelResourceLocation(PeacefulPack.modid + ":" + ((BlockBlazeLeaves) blazeLeaves).getName(), "inventory"));
			
			renderItem.getItemModelMesher().register(Item.getItemFromBlock(ghastOre), 0, new ModelResourceLocation(PeacefulPack.modid + ":" + ((BlockGhastOre) ghastOre).getName(), "inventory"));
			renderItem.getItemModelMesher().register(Item.getItemFromBlock(enderClam), 0, new ModelResourceLocation(PeacefulPack.modid + ":" + ((BlockEnderclam) enderClam).getName(), "inventory"));
			renderItem.getItemModelMesher().register(Item.getItemFromBlock(blazeSapling), 0, new ModelResourceLocation(PeacefulPack.modid + ":" + ((BlockBlazeSapling) blazeSapling).getName(), "inventory"));
			renderItem.getItemModelMesher().register(Item.getItemFromBlock(remains), 0, new ModelResourceLocation(PeacefulPack.modid + ":" + ((BlockRemains) remains).getName(), "inventory"));
		}
	}
}