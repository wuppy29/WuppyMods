package com.wuppy.peacefulpackmod.helper;

import com.wuppy.peacefulpackmod.PeacefulPack;
import com.wuppy.peacefulpackmod.config.Config;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class PeacefulEvent
{
	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		if (PeacefulPack.outdated)
		{
			event.player.addChatComponentMessage(new ChatComponentText("Peacefulpack is outdated."));
			event.player.addChatComponentMessage(new ChatComponentText("Changelog: "));
			event.player.addChatComponentMessage(new ChatComponentText(PeacefulPack.updates));
		}
	}

	@SubscribeEvent
	public void dropSpiderEyes(HarvestDropsEvent event)
	{
		if (Config.changeWeb)
		{
			if (event.state.getBlock() == Blocks.web)
			{
				event.drops.add(new ItemStack(Items.spider_eye));
			}
		}
	}
}