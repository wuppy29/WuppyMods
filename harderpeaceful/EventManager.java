package harderpeaceful;

import java.lang.reflect.Field;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.FoodStats;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventManager 
{
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
