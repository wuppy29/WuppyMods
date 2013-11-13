package slimedungeons;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSlimeZombie extends RenderLiving
{
    private static ResourceLocation texture = new ResourceLocation(SlimeDungeon.modid, "textures/models/slime zombie.png");
    
    public RenderSlimeZombie(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }
    
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return texture;
	}
}