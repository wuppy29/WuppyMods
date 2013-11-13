package ImprovedMobSpawn;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.IPlayerTracker;

public class ImprovedMobSpawnLogin implements IPlayerTracker
{
	@Override
	public void onPlayerLogin(EntityPlayer player)
	{
		if (ImprovedMobs.outdated)
		{
			player.addChatMessage("Improved Mob Spawn is outdated. \nChangelog: \n" + ImprovedMobs.updates);
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