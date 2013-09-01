package harderpeaceful;

import java.lang.reflect.Field;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.FoodStats;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class EventManager 
{
	@ForgeSubscribe
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
