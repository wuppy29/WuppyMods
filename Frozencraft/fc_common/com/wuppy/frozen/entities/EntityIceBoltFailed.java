package com.wuppy.frozen.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.wuppy.frozen.entities.particles.FrozenParticles;

public class EntityIceBoltFailed extends EntityThrowable
{
	public EntityIceBoltFailed(World par1World)
	{
		super(par1World);
	}

	public EntityIceBoltFailed(World par1World, EntityLivingBase par2EntityLivingBase)
	{
		super(par1World, par2EntityLivingBase);
	}

	public EntityIceBoltFailed(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (worldObj.isRemote)
		{
			for (int i = 0; i < 3; ++i)
			{
				FrozenParticles.spawnParticle("iceBolt", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
			}
		}

		if (!worldObj.isRemote)
		{
			this.setDead();
		}
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
	{
		setDead();
	}
}