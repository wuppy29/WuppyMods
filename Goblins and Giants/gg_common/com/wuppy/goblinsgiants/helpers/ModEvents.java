package com.wuppy.goblinsgiants.helpers;

import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class ModEvents
{
	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		if (UpdateChecker.outdated)
		{
			event.player.addChatComponentMessage(new ChatComponentText("Goblins and Giants is outdated."));
			event.player.addChatComponentMessage(new ChatComponentText("Changelog: "));
			event.player.addChatComponentMessage(new ChatComponentText(UpdateChecker.updates));
		}
	}
}