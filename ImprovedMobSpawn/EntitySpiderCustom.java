package ImprovedMobSpawn;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SpiderEffectsGroupData;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntitySpiderCustom extends EntitySpider
{
    public EntitySpiderCustom(World par1World)
    {
        super(par1World);
    }

    public EntityLivingData func_110161_a(EntityLivingData par1EntityLivingData)
    {
        Object par1EntityLivingData1 = super.func_110161_a(par1EntityLivingData);

        if (this.worldObj.rand.nextInt(20) == 0)
        {
            EntitySkeleton entityskeleton = new EntitySkeleton(this.worldObj);
            entityskeleton.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
            entityskeleton.func_110161_a((EntityLivingData)null);
            this.worldObj.spawnEntityInWorld(entityskeleton);
            entityskeleton.mountEntity(this);
        }

        if (par1EntityLivingData1 == null)
        {
            par1EntityLivingData1 = new SpiderEffectsGroupData();

            if (this.worldObj.difficultySetting > 2 && this.worldObj.rand.nextFloat() < 0.1F * this.worldObj.func_110746_b(this.posX, this.posY, this.posZ))
            {
                ((SpiderEffectsGroupData)par1EntityLivingData1).func_111104_a(this.worldObj.rand);
            }
        }

        if (par1EntityLivingData1 instanceof SpiderEffectsGroupData)
        {
            int i = ((SpiderEffectsGroupData)par1EntityLivingData1).field_111105_a;

            if (i > 0 && Potion.potionTypes[i] != null)
            {
                this.addPotionEffect(new PotionEffect(i, Integer.MAX_VALUE));
            }
        }

        return (EntityLivingData)par1EntityLivingData1;
    }
}
