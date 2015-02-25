package com.wuppy.frozen.entities;

import com.wuppy.frozen.FrozenCraft;
import com.wuppy.frozen.blocks.ModBlocks;
import com.wuppy.frozen.entities.particles.FrozenParticles;
import com.wuppy.frozen.network.FrozenIceBoltRemoveMessage;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class EntityIceBoltPlayer extends EntityThrowable {
	public EntityIceBoltPlayer(World par1World) {
		super(par1World);
	}

	public EntityIceBoltPlayer(World par1World, EntityLivingBase par2EntityLivingBase) {
		super(par1World, par2EntityLivingBase);
	}

	public EntityIceBoltPlayer(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		Block block = worldObj.getBlockState(new BlockPos((int) (this.posX), (int) (this.posY), (int) (this.posZ))).getBlock();

		if (block == Blocks.water || block == Blocks.flowing_water) {
			worldObj.setBlockState(new BlockPos((int) (this.posX), (int) (this.posY), (int) (this.posZ)), Blocks.ice.getDefaultState());
			setDead();
			FrozenCraft.frozenCraftNetworkManager.sendToServer(new FrozenIceBoltRemoveMessage());
		}
		if (block == Blocks.lava || block == Blocks.flowing_lava) {
			worldObj.setBlockState(new BlockPos((int) (this.posX), (int) (this.posY), (int) (this.posZ)), ModBlocks.boltObsidian.getDefaultState());
			worldObj.scheduleUpdate(new BlockPos((int) (this.posX), (int) (this.posY), (int) (this.posZ)), ModBlocks.boltObsidian, 40);
			setDead();
			FrozenCraft.frozenCraftNetworkManager.sendToServer(new FrozenIceBoltRemoveMessage());
		}

		if (worldObj.rand.nextInt(5) == 0 && worldObj.isRemote) {
			FrozenParticles.spawnParticle("iceBolt", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		}

		if (ticksExisted > 40) {
			//send package for player removal
			FrozenCraft.frozenCraftNetworkManager.sendToServer(new FrozenIceBoltRemoveMessage());
		}
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
		if (par1MovingObjectPosition.entityHit != null) {
			par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 6F);
		} else if (par1MovingObjectPosition.typeOfHit == MovingObjectType.BLOCK) {
			if (!(worldObj.getBlockState(par1MovingObjectPosition.getBlockPos()).getBlock() == Blocks.ice) && !(worldObj.getBlockState(par1MovingObjectPosition.getBlockPos()).getBlock() == ModBlocks.boltObsidian))
				worldObj.setBlockState(par1MovingObjectPosition.getBlockPos(), Blocks.ice.getDefaultState());
		}

		for (int i = 0; i < 4; ++i) {
			if (worldObj.isRemote)
				FrozenParticles.spawnParticle("iceBolt", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		}

		setDead();

		//send package for player removal
		FrozenCraft.frozenCraftNetworkManager.sendToServer(new FrozenIceBoltRemoveMessage());
	}
}