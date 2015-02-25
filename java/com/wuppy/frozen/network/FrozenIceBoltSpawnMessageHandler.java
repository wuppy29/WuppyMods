package com.wuppy.frozen.network;

import com.wuppy.frozen.FrozenData;
import com.wuppy.frozen.entities.EntityIceBoltFailed;
import com.wuppy.frozen.entities.EntityIceBoltPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class FrozenIceBoltSpawnMessageHandler implements IMessageHandler<FrozenIceBoltSpawnMessage, IMessage> {
	EntityPlayer player;

	@Override
	public IMessage onMessage(FrozenIceBoltSpawnMessage message, MessageContext ctx) {
		player = ctx.getServerHandler().playerEntity;

		if (!player.worldObj.isRemote) {
			if (!FrozenData.iceboltPlayers.contains(player.getDisplayName())) {
				FrozenData.iceboltPlayers.add(player.getDisplayName().getUnformattedText());

				player.worldObj.spawnEntityInWorld(new EntityIceBoltPlayer(player.worldObj, player));
			} else {
				player.worldObj.spawnEntityInWorld(new EntityIceBoltFailed(player.worldObj, player));
			}
		}

		return null;
	}
}