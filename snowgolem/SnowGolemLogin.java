package snowgolem;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.IPlayerTracker;

public class SnowGolemLogin implements IPlayerTracker
{
	@Override
	public void onPlayerLogin(EntityPlayer player)
	{
		if(CleanSnowGolem.outdated)
		{
			player.addChatMessage("Snow Golem is outdated. \nChangelog: \n" + CleanSnowGolem.updates);
		}
	}
	
	@Override
	public void onPlayerLogout(EntityPlayer player)
	{
		
	}
	
	@Override
	public void onPlayerChangedDimension(EntityPlayer player)
	{
		
	}
	
	@Override
	public void onPlayerRespawn(EntityPlayer player)
	{
		
	}
}