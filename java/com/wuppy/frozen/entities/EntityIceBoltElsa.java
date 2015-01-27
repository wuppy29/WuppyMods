package com.wuppy.frozen.entities;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.wuppy.frozen.blocks.ModBlocks;
import com.wuppy.frozen.entities.particles.FrozenParticles;

public class EntityIceBoltElsa extends EntityArrow
{
	private int ticksInAir;
	
	public EntityIceBoltElsa(World par1World)
	{
		super(par1World);
	}
	public EntityIceBoltElsa(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5)
    {
		super(par1World, par2EntityLivingBase, par3EntityLivingBase, par4, par5);
    }
	
	@SuppressWarnings("rawtypes")
	public void onUpdate()
    {
		super.onUpdate();
		
		for (int i = 0; i < 4; ++i)
		{
			if (worldObj.isRemote)
				FrozenParticles.spawnParticle("iceBolt", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		}
		
		Block block = worldObj.getBlockState(new BlockPos((int) (this.posX), (int) (this.posY), (int) (this.posZ))).getBlock();
		
		if(block == Blocks.lava || block == Blocks.flowing_lava)
		{
			worldObj.setBlockState(new BlockPos((int) (this.posX), (int) (this.posY), (int) (this.posZ)), ModBlocks.boltObsidian.getDefaultState());
			worldObj.scheduleUpdate(new BlockPos((int) (this.posX), (int) (this.posY), (int) (this.posZ)), ModBlocks.boltObsidian, 40);
			setDead();
		}
		else if(block != Blocks.air)
		{
			worldObj.setBlockState(new BlockPos((int) (this.posX), (int) (this.posY), (int) (this.posZ)), Blocks.ice.getDefaultState());
			setDead();
		}

		if (worldObj.rand.nextInt(5) == 0 && worldObj.isRemote)
		{
			FrozenParticles.spawnParticle("iceBolt", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		}
		
		//Entity collision
		++ticksInAir;
		Vec3 vec31 = new Vec3(this.posX, this.posY, this.posZ);
        Vec3 vec3 = new Vec3(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec31, vec3, false, true, false);
        vec31 = new Vec3(this.posX, this.posY, this.posZ);
        vec3 = new Vec3(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

        if (movingobjectposition != null)
        {
            vec3 = new Vec3(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
        }

        Entity entity = null;
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
        double d0 = 0.0D;
        int i;
        float f1;

        for (i = 0; i < list.size(); ++i)
        {
            Entity entity1 = (Entity)list.get(i);

            if (entity1.canBeCollidedWith() && (entity1 != this.shootingEntity || this.ticksInAir >= 5))
            {
                f1 = 0.3F;
                AxisAlignedBB axisalignedbb1 = entity1.getEntityBoundingBox().expand((double)f1, (double)f1, (double)f1);
                MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec31, vec3);

                if (movingobjectposition1 != null)
                {
                    double d1 = vec31.distanceTo(movingobjectposition1.hitVec);

                    if (d1 < d0 || d0 == 0.0D)
                    {
                        entity = entity1;
                        d0 = d1;
                    }
                }
            }
        }

        if (entity != null)
        {
            movingobjectposition = new MovingObjectPosition(entity);
        }

        if (movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.entityHit;

            if (entityplayer.capabilities.disableDamage || this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer))
            {
                movingobjectposition = null;
            }
        }

        if (movingobjectposition != null)
        {
            if (movingobjectposition.entityHit != null)
            {
            	movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeArrowDamage(this, this.shootingEntity), 6F);
            	this.setDead();
            }
        }
    }
}