package goblinsgiants.render;

import goblinsgiants.GoblinGiant;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGGMob extends RenderLiving
{
    private ResourceLocation texture;

    public RenderGGMob(ModelBase par1ModelBase, float par2, String string)
    {
        super(par1ModelBase, par2);
        texture = new ResourceLocation(GoblinGiant.modid, string);
    }

    protected ResourceLocation func_110832_a(Entity par1Entity)
    {
        return texture;
    }

    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return this.func_110832_a(par1Entity);
    }
}
