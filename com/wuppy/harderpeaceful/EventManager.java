package com.wuppy.harderpeaceful;

import java.lang.reflect.Field;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.FoodStats;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class EventManager 
{
	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		if(HarderPeaceful.outdated)
		{
			event.player.func_146105_b(new ChatComponentText("Harder Peaceful is outdated."));
			event.player.func_146105_b(new ChatComponentText("Changelog: "));
			event.player.func_146105_b(new ChatComponentText(HarderPeaceful.updates));
		}
	}
	
	@SubscribeEvent
	public void updateFood(EntityJoinWorldEvent event) 
	{
		if(event.entity instanceof EntityPlayer)
			setFoodStats((EntityPlayer) event.entity, new FoodStatsHP());
		
		if(event.world.getGameRules().getGameRuleBooleanValue("naturalRegeneration"))
		{
			event.world.getGameRules().setOrCreateGameRule("naturalRegeneration", "false");
		}
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
