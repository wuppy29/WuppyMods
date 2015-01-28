package com.wuppy.frozen.handlers;

import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import com.wuppy.frozen.FrozenCraft;
import com.wuppy.frozen.items.ItemElsaArmor;
import com.wuppy.frozen.network.FrozenIceBoltSpawnMessage;

public class ModEvents
{
	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		if (UpdateChecker.outdated)
		{
			event.player.addChatComponentMessage(new ChatComponentText("Frozencraft is outdated."));
			event.player.addChatComponentMessage(new ChatComponentText("Changelog: "));
			event.player.addChatComponentMessage(new ChatComponentText(UpdateChecker.updates));
		}
	}

	@SubscribeEvent
	public void shootIceBolt(PlayerInteractEvent event)
	{
		if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_AIR)
		{
			if (event.entityPlayer.getCurrentEquippedItem() == null)
			{
				System.out.println("si");
				boolean fullSuit = true;

				for (int i = 0; i < 4; i++)
				{
					if (event.entityPlayer.getCurrentArmor(i) == null)
					{
						fullSuit = false;
						return;
					}
					else if (!(event.entityPlayer.getCurrentArmor(i).getItem() instanceof ItemElsaArmor))
					{
						fullSuit = false;
					}
				}

				if (fullSuit)
				{
					System.out.println("wot");
					//send packet to server
					FrozenCraft.frozenCraftNetworkManager.sendToServer(new FrozenIceBoltSpawnMessage());
				}
			}
		}
	}
}