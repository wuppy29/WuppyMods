package peacefulpackmod;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.IPlayerTracker;

public class PeacefulPackLogin implements IPlayerTracker
{
	@Override
	public void onPlayerLogin(EntityPlayer player)
	{
		if(PeacefulPack.outdated)
		{
			player.addChatMessage("PeacefulPack is outdated. \nChangelog: \n" + PeacefulPack.updates);
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