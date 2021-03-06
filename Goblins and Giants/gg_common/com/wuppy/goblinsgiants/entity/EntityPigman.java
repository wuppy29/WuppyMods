package com.wuppy.goblinsgiants.entity;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityPigman extends EntityAnimal
{
	float moveSpeed = 0.25F;
	
    public EntityPigman(World par1World)
    {
        super(par1World);
        this.setSize(1.0F, 2.0F);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }
    
    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15D);
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    @Override
    protected boolean isAIEnabled()
    {
        return true;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    @Override
    protected String getLivingSound()
    {
        return "mob.zombiepig.zpig";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound()
    {
        return "mob.zombiepig.zpighurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    @Override
    protected String getDeathSound()
    {
        return "mob.zombiepig.zpigdeath";
    }

    @Override
    protected void dropFewItems(boolean par1, int par2)
    {
    	if(this.isBurning())
    	{
    		this.dropItem(Items.cooked_porkchop, 2);
    	}
    	else
    	{
    		this.dropItem(Items.porkchop, 2);
    	}
    }

    @Override
    public void onStruckByLightning(EntityLightningBolt par1EntityLightningBolt)
    {
        if (!this.worldObj.isRemote)
        {
            EntityPigZombie var2 = new EntityPigZombie(this.worldObj);
            var2.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.worldObj.spawnEntityInWorld(var2);
            this.setDead();
        }
    }

    @Override
    protected void dropRareDrop(int par1)
    {
        if (par1 > 0)
        {
            ItemStack var2 = new ItemStack(Items.golden_sword);
            EnchantmentHelper.addRandomEnchantment(this.rand, var2, 5);
            this.entityDropItem(var2, 0.0F);
        }
        else
        {
            int var3 = this.rand.nextInt(3);

            if (var3 == 0)
            {
                this.dropItem(Items.gold_ingot, 1);
            }
            else if (var3 == 1)
            {
                this.dropItem(Items.golden_sword, 1);
            }
            else if (var3 == 2)
            {
                this.dropItem(Items.golden_helmet, 1);
            }
        }
    }
    
    @Override
	public EntityAgeable createChild(EntityAgeable entityageable) 
	{
		return null;
	}
}
