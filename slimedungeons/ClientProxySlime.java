package slimedungeons;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxySlime extends CommonProxySlime
{
    @Override
    public void registerRenderThings()
    {
    	RenderingRegistry.registerEntityRenderingHandler(EntitySlimeZombie.class, new RenderSlimeZombie(new ModelBiped(), 0.5F));
    }
}
