package com.wuppy.frozen.entities.particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityBreakingFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public class FrozenParticles 
{
	private static Minecraft mc = Minecraft.getMinecraft();
	private static World world = mc.theWorld;
	
	public static EntityFX spawnParticle(String particleName, double par2, double par4, double par6, double par8, double par10, double par12)
	{
		if (mc != null && mc.getRenderViewEntity() != null && mc.effectRenderer != null)
		{
			int particleSetting = mc.gameSettings.particleSetting;

			if (particleSetting == 1 && world.rand.nextInt(3) == 0)
			{
				particleSetting = 2;
			}

			double x = mc.getRenderViewEntity().posX - par2;
			double y = mc.getRenderViewEntity().posY - par4;
			double z = mc.getRenderViewEntity().posZ - par6;
			EntityFX particle = null;
			double var22 = 16.0D;

			if (x * x + y * y + z * z > var22 * var22)
			{
				return null;
			}
			else if (particleSetting > 1)
			{
				return null;
			}
			else
			{
				if (particleName.equals("iceBolt"))
				{
					particle = new EntityBreakingFX.SnowballFactory().getEntityFX(0, world, par2, par4, par6, 0, 0, 0, 0);
					
					particle.setRBGColorF(0.75F, 1F, 1F);
				}
				
				if(particle != null)
					mc.effectRenderer.addEffect(particle);
				
				return particle;
			}
		}
		return null;
	}
}