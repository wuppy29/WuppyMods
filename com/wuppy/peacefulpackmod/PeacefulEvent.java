package com.wuppy.peacefulpackmod;

import com.wuppy.peacefulpackmod.block.BlockBlazeSapling;
import com.wuppy.peacefulpackmod.block.BlockRottenPlant;
import com.wuppy.peacefulpackmod.block.Blockflax;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class PeacefulEvent 
{
	@SubscribeEvent
    public void bonemealUsed(BonemealEvent event)
    {
		if(event.world.getBlock(event.x, event.y, event.z)== PeacefulPack.flax)
        {
        	((Blockflax)PeacefulPack.flax).fertilize(event.world, event.x, event.y, event.z);
        }
        if(event.world.getBlock(event.x, event.y, event.z)== PeacefulPack.rottenplant)
        {
        	((BlockRottenPlant)PeacefulPack.rottenplant).fertilize(event.world, event.x, event.y, event.z);
        }
        if(event.world.getBlock(event.x, event.y, event.z)== PeacefulPack.blazeSapling)
        {
        	event.world.setBlockToAir(event.x, event.y, event.z);
        	((BlockBlazeSapling)PeacefulPack.blazeSapling).growTree(event.world, event.x, event.y, event.z, event.world.rand);
        }
    }
	
	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		if(PeacefulPack.outdated)
		{
			event.player.addChatComponentMessage(new ChatComponentText("Peacefulpack is outdated."));
			event.player.addChatComponentMessage(new ChatComponentText("Changelog: "));
			event.player.addChatComponentMessage(new ChatComponentText(PeacefulPack.updates));
		}
	}
	
	@SubscribeEvent
	public void dropSpiderEyes(HarvestDropsEvent event)
	{
		if(PeacefulPack.changeWeb)
		{
			if(event.block == Blocks.web)
			{
				event.drops.add(new ItemStack(Items.spider_eye));
			}
		}
	}
}