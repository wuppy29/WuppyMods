package com.wuppy.peacefulpackmod.item;

import com.wuppy.peacefulpackmod.PeacefulPack;
import com.wuppy.peacefulpackmod.block.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ModItems
{
	public static Item peacefulMaterial;

	public static Item flaxSeed;
	public static Item cookedFlesh;
	public static Item rottenSeed;

	public static void init(FMLPreInitializationEvent event)
	{
		peacefulMaterial = new ItemPeacefulMaterial();
		flaxSeed = new ItemPeacefulSeed(ModBlocks.flax, Blocks.grass, "flaxseed");
		cookedFlesh = new ItemCookedFlesh(4, 5, true);
		rottenSeed = new ItemPeacefulSeed(ModBlocks.rottenPlant, Blocks.netherrack, "rottenseed");
		
		if(event.getSide() == Side.CLIENT)
		{
			ItemPeacefulMaterial.registerVariants();
		}
	}

	public static void postInit(FMLPostInitializationEvent event)
	{
		if (event.getSide() == Side.CLIENT)
		{
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

			renderItem.getItemModelMesher().register(peacefulMaterial, 0, new ModelResourceLocation(PeacefulPack.modid + ":" + ((ItemPeacefulMaterial) peacefulMaterial).getNameFromDamage(0), "inventory"));
			renderItem.getItemModelMesher().register(peacefulMaterial, 1, new ModelResourceLocation(PeacefulPack.modid + ":" + ((ItemPeacefulMaterial) peacefulMaterial).getNameFromDamage(1), "inventory"));
			renderItem.getItemModelMesher().register(peacefulMaterial, 2, new ModelResourceLocation(PeacefulPack.modid + ":" + ((ItemPeacefulMaterial) peacefulMaterial).getNameFromDamage(2), "inventory"));
			renderItem.getItemModelMesher().register(peacefulMaterial, 3, new ModelResourceLocation(PeacefulPack.modid + ":" + ((ItemPeacefulMaterial) peacefulMaterial).getNameFromDamage(3), "inventory"));
			renderItem.getItemModelMesher().register(peacefulMaterial, 4, new ModelResourceLocation(PeacefulPack.modid + ":" + ((ItemPeacefulMaterial) peacefulMaterial).getNameFromDamage(4), "inventory"));

			renderItem.getItemModelMesher().register(flaxSeed, 0, new ModelResourceLocation(PeacefulPack.modid + ":" + ((ItemPeacefulSeed) flaxSeed).getName(), "inventory"));
			renderItem.getItemModelMesher().register(cookedFlesh, 0, new ModelResourceLocation(PeacefulPack.modid + ":" + ((ItemCookedFlesh) cookedFlesh).getName(), "inventory"));
			renderItem.getItemModelMesher().register(rottenSeed, 0, new ModelResourceLocation(PeacefulPack.modid + ":" + ((ItemPeacefulSeed) rottenSeed).getName(), "inventory"));
		}
	}
}