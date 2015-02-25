package com.wuppy.frozen.blocks;

import com.wuppy.frozen.FrozenCraft;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ModBlocks
{
	public static Block iceVine;
	public static Block boltObsidian;
	public static Block hardIce;

	public static void loadBlocks()
	{
		iceVine = new BlockIceVine();
		boltObsidian = new BlockBoltObsidian();
		hardIce = new BlockHardIce();
	}

	public static void registerBlockRenders(FMLPostInitializationEvent event)
	{
		if (event.getSide() == Side.CLIENT)
		{
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

			renderItem.getItemModelMesher().register(Item.getItemFromBlock(iceVine), 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((BlockIceVine) iceVine).getName(), "inventory"));
			renderItem.getItemModelMesher().register(Item.getItemFromBlock(boltObsidian), 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((BlockBoltObsidian) boltObsidian).getName(), "inventory"));
			renderItem.getItemModelMesher().register(Item.getItemFromBlock(hardIce), 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((BlockHardIce) hardIce).getName(), "inventory"));
		}
	}
}