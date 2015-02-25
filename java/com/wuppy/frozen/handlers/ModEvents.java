package com.wuppy.frozen.handlers;

import com.wuppy.frozen.FrozenCraft;
import com.wuppy.frozen.items.ItemElsaArmor;
import com.wuppy.frozen.network.FrozenIceBoltSpawnMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.MouseInputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import org.lwjgl.input.Mouse;

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
	public void shootIceBolt(MouseInputEvent event)
	{
		if (Mouse.getEventButton() == 1 && Mouse.getEventButtonState())
		{
			EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;

			if (player.getCurrentEquippedItem() == null)
			{
				boolean fullSuit = true;

				for (int i = 0; i < 4; i++)
				{
					if (player.getCurrentArmor(i) == null)
					{
						return;
					} else if (!(player.getCurrentArmor(i).getItem() instanceof ItemElsaArmor))
					{
						fullSuit = false;
					}
				}

				if (fullSuit)
				{
					// send packet to server
					FrozenCraft.frozenCraftNetworkManager.sendToServer(new FrozenIceBoltSpawnMessage());
				}
			}
		}
	}
}