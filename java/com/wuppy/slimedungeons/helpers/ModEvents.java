package com.wuppy.slimedungeons.helpers;

import com.wuppy.slimedungeons.SlimeDungeon;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class ModEvents {
	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event) {
		if (SlimeDungeon.outdated) {
			event.player.addChatComponentMessage(new ChatComponentText("Magical Experience is outdated."));
			event.player.addChatComponentMessage(new ChatComponentText("Changelog: "));
			event.player.addChatComponentMessage(new ChatComponentText(SlimeDungeon.updates));
		}
	}
}