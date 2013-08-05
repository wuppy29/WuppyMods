package ImprovedMobSpawn;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityCaveSpiderCustom extends EntityCaveSpider
{
    public EntityCaveSpiderCustom(World par1World) 
    {
		super(par1World);
	}

	public boolean getCanSpawnHere()
    {
		if(this.posY < 40.0)
			return true;
		else
			return false;
    }
}
