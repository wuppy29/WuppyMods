package koi;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class Entitykoi extends EntityWaterMob
{
    public Entitykoi(World par1World)
    {
    	super (par1World);
    	tasks.addTask(0, new EntityAISwimmingFish(this));
    	tasks.addTask(1, new EntityAIPanic(this, 0.38F));
    	tasks.addTask(2, new EntityAIWander(this, 0.3F));
    }
    
    protected void func_110147_ax()
    {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(1D);
    }
    
    public boolean isAIEnabled()
    {
        return true;
    }

	public int getMaxHealth() 
	{
		return 10;
	}
	
	public boolean canBreatheUnderwater()
    {
        return true;
    }
	
	public void onLivingUpdate()
    {
		if(worldObj.getBlockId((int)this.posX, (int)this.posY, (int)this.posZ) == 0)
        {
			attackEntityFrom(DamageSource.drown, 1.0F);
        }
        super.onLivingUpdate();
    }
	
	protected boolean canDespawn()
    {
        return true;
    }
	
	protected boolean canspawn()
    {
        return true;
    }
	
	protected int getDropItemId()
    {
        return Item.fishRaw.itemID;
    }
	
	protected void dropFewItems(boolean par1, int par2)
    {
        int i = getDropItemId();
        dropItem(i, 1);
    }
	
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
    }
	
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
    }
    
    public boolean getCanSpawnHere()
    {
        return worldObj.checkNoEntityCollision(boundingBox);
    }
    
    protected int scoreValue()
    {
    	return 1;
    }
}
