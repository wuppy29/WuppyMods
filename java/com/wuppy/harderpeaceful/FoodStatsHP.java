package com.wuppy.harderpeaceful;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.FoodStats;
import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FoodStatsHP extends FoodStats {
	private int foodLevel = 20;
	private float foodSaturationLevel = 5.0F;
	private float foodExhaustionLevel;
	private int foodTimer;
	private int prevFoodLevel = 20;
	private static final String __OBFID = "CL_00001729";

	@Override
	public void addStats(int p_75122_1_, float p_75122_2_) {
		this.foodLevel = Math.min(p_75122_1_ + this.foodLevel, 20);
		this.foodSaturationLevel = Math.min(this.foodSaturationLevel + (float) p_75122_1_ * p_75122_2_ * 2.0F, (float) this.foodLevel);
	}

	@Override
	public void addStats(ItemFood p_151686_1_, ItemStack p_151686_2_) {
		this.addStats(p_151686_1_.getHealAmount(p_151686_2_), p_151686_1_.getSaturationModifier(p_151686_2_));
	}

	@Override
	public void onUpdate(EntityPlayer p_75118_1_) {
		EnumDifficulty enumdifficulty = p_75118_1_.worldObj.getDifficulty();
		this.prevFoodLevel = this.foodLevel;

		if (this.foodExhaustionLevel > 4.0F) {
			this.foodExhaustionLevel -= 4.0F;

			if (this.foodSaturationLevel > 0.0F) {
				this.foodSaturationLevel = Math.max(this.foodSaturationLevel - 1.0F, 0.0F);
			} else {
				this.foodLevel = Math.max(this.foodLevel - 1, 0);
			}
		}

		if (this.foodLevel >= 18 && p_75118_1_.shouldHeal()) {
			++this.foodTimer;

			if (this.foodTimer >= 80) {
				p_75118_1_.heal(1.0F);
				this.addExhaustion(3.0F);
				this.foodTimer = 0;
			}
		} else if (this.foodLevel <= 0) {
			++this.foodTimer;

			if (this.foodTimer >= 80) {
				if (p_75118_1_.getHealth() > 10.0F || enumdifficulty == EnumDifficulty.HARD || p_75118_1_.getHealth() > 1.0F && enumdifficulty == EnumDifficulty.NORMAL) {
					p_75118_1_.attackEntityFrom(DamageSource.starve, 1.0F);
				}
				//custom starve check
				if (enumdifficulty == EnumDifficulty.PEACEFUL) {
					if (p_75118_1_.getHealth() > 1.0F || HarderPeaceful.starveToDeath) {
						p_75118_1_.attackEntityFrom(DamageSource.starve, 1.0F);
					}
				}


				this.foodTimer = 0;
			}
		} else {
			this.foodTimer = 0;
		}
	}

	@Override
	public int getFoodLevel() {
		return this.foodLevel;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getPrevFoodLevel() {
		return this.prevFoodLevel;
	}

	@Override
	public boolean needFood() {
		return this.foodLevel < 20;
	}

	@Override
	public void addExhaustion(float p_75113_1_) {
		this.foodExhaustionLevel = Math.min(this.foodExhaustionLevel + p_75113_1_, 40.0F);
	}

	@Override
	public float getSaturationLevel() {
		return this.foodSaturationLevel;
	}

	@Override
	public void setFoodLevel(int p_75114_1_) {
		this.foodLevel = p_75114_1_;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void setFoodSaturationLevel(float p_75119_1_) {
		this.foodSaturationLevel = p_75119_1_;
	}
}