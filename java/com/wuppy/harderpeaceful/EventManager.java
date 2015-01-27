package com.wuppy.harderpeaceful;

import java.lang.reflect.Field;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.FoodStats;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventManager 
{
	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		if(HarderPeaceful.outdated)
		{
			event.player.addChatComponentMessage(new ChatComponentText("Harder Peaceful is outdated."));
			event.player.addChatComponentMessage(new ChatComponentText("Changelog: "));
			event.player.addChatComponentMessage(new ChatComponentText(HarderPeaceful.updates));
		}
	}
	
	@SubscribeEvent
	public void saveFood(PlayerEvent.PlayerLoggedOutEvent event)
	{
		event.player.getEntityData().setInteger("hpfoodlevel", event.player.getFoodStats().getFoodLevel());
		event.player.getEntityData().setFloat("hpsaturationlevel", event.player.getFoodStats().getSaturationLevel());
	}
	
	@SubscribeEvent
	public void updateFood(EntityJoinWorldEvent event) 
	{
		if(event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = ((EntityPlayer) event.entity);
			
			setFoodStats(player, new FoodStatsHP());
			
			if(player.getFoodStats() instanceof FoodStatsHP)
			{
				if(player.getEntityData().hasKey("hpfoodlevel"))
				{
					player.getFoodStats().setFoodLevel(player.getEntityData().getInteger(("hpfoodlevel")));
					player.getFoodStats().setFoodSaturationLevel(player.getEntityData().getInteger(("hpsaturationlevel")));
				}
			}
		}
		
		if(event.world.getGameRules().getGameRuleBooleanValue("naturalRegeneration"))
			event.world.getGameRules().setOrCreateGameRule("naturalRegeneration", "false");
	}

	public static void setFoodStats(EntityPlayer player, FoodStats stats) 
	{
		Field[] fields = EntityPlayer.class.getDeclaredFields();

		for (Field f : fields) 
		{
			if (f.getType() == FoodStats.class) 
			{
				f.setAccessible(true);
				try 
				{
					f.set(player, stats);
				} 
				catch (Exception e) 
				{
					System.out.println(e);
				}
			}
		}
	}
}
