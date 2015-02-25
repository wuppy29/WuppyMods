package com.wuppy.frozen.entities.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.wuppy.frozen.FrozenCraft;
import com.wuppy.frozen.entities.EntityIceBoltFailed;

@SideOnly(Side.CLIENT)
public class RenderIceBoltFailed extends Render
{
	private static final ResourceLocation texture = new ResourceLocation(FrozenCraft.modid, "textures/models/icebolt.png");

    public RenderIceBoltFailed() 
    {
		super(Minecraft.getMinecraft().getRenderManager());
	}
	
    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    @Override
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.render((EntityIceBoltFailed) par1Entity, par2, par4, par6, par8, par9);
    }
    
    public void render(EntityIceBoltFailed par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		 return texture;
	}
}