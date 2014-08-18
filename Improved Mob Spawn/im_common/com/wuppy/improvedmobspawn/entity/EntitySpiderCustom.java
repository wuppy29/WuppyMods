package com.wuppy.improvedmobspawn.entity;

import java.util.Random;

import com.wuppy.improvedmobspawn.Config;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntitySpiderCustom extends EntitySpider
{
	public EntitySpiderCustom(World par1World)
	{
		super(par1World);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData)
	{
		Object par1EntityLivingData1 = super.onSpawnWithEgg(par1EntityLivingData);

		int chance = 100 / Config.spiderJockeySpawnChance;

		if (this.worldObj.rand.nextInt(chance) == 0)
		{
			EntitySkeleton entityskeleton = new EntitySkeleton(this.worldObj);
			entityskeleton.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			entityskeleton.onSpawnWithEgg((IEntityLivingData) null);
			this.worldObj.spawnEntityInWorld(entityskeleton);
			entityskeleton.mountEntity(this);
		}

		if (par1EntityLivingData1 == null)
		{
			par1EntityLivingData1 = new EntitySpiderCustom.GroupData();

			if (this.worldObj.difficultySetting == EnumDifficulty.HARD && this.worldObj.rand.nextFloat() < 0.1F * this.worldObj.func_147462_b(this.posX, this.posY, this.posZ))
			{
				((EntitySpiderCustom.GroupData) par1EntityLivingData1).func_111104_a(this.worldObj.rand);
			}
		}

		if (par1EntityLivingData1 instanceof EntitySpiderCustom.GroupData)
		{
			int i = ((EntitySpiderCustom.GroupData) par1EntityLivingData1).field_111105_a;

			if (i > 0 && Potion.potionTypes[i] != null)
			{
				this.addPotionEffect(new PotionEffect(i, Integer.MAX_VALUE));
			}
		}

		return (IEntityLivingData) par1EntityLivingData1;
	}

	public static class GroupData implements IEntityLivingData
	{
		public int field_111105_a;

		public void func_111104_a(Random par1Random)
		{
			int i = par1Random.nextInt(5);

			if (i <= 1)
			{
				this.field_111105_a = Potion.moveSpeed.id;
			}
			else if (i <= 2)
			{
				this.field_111105_a = Potion.damageBoost.id;
			}
			else if (i <= 3)
			{
				this.field_111105_a = Potion.regeneration.id;
			}
			else if (i <= 4)
			{
				this.field_111105_a = Potion.invisibility.id;
			}
		}
	}
}
