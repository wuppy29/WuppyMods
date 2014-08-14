package com.wuppy.improvedmobspawn;

import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.world.World;

public class EntityCaveSpiderCustom extends EntityCaveSpider
{
    public EntityCaveSpiderCustom(World par1World) 
    {
		super(par1World);
	}

    @Override
	public boolean getCanSpawnHere()
    {
		if(this.posY < 40.0)
			return true;
		else
			return false;
    }
}
