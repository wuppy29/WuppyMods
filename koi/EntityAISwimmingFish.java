package koi;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAISwimmingFish extends EntityAIBase
{
    private EntityLiving field_46106_a;

    public EntityAISwimmingFish(EntityLiving par1EntityLiving)
    {
        field_46106_a = par1EntityLiving;
        setMutexBits(4);
        par1EntityLiving.getNavigator().setCanSwim(true);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return field_46106_a.isInWater() || field_46106_a.handleLavaMovement();
    }
    
    public void updateTask()
    {
        if (field_46106_a.getRNG().nextFloat() < 0.5F)
        {
            field_46106_a.getJumpHelper().setJumping();
        }
    }
}
