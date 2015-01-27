package com.wuppy.frozen.network;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.wuppy.frozen.FrozenData;

public class FrozenIceBoltRemoveMessageHandler implements IMessageHandler<FrozenIceBoltRemoveMessage, IMessage>
{
	@Override
	public IMessage onMessage(FrozenIceBoltRemoveMessage message, MessageContext ctx)
	{
		FrozenData.iceboltPlayers.remove(ctx.getServerHandler().playerEntity.getDisplayName());

		return null;
	}
}