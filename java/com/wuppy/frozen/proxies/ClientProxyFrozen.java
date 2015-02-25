package com.wuppy.frozen.proxies;

import com.wuppy.frozen.entities.*;
import com.wuppy.frozen.entities.render.RenderBipedFrozenCraft;
import com.wuppy.frozen.entities.render.RenderIceBolt;
import com.wuppy.frozen.entities.render.RenderThug;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxyFrozen extends CommonProxyFrozen
{
	@Override
	public void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityIceBoltElsa.class, new RenderIceBolt());
		RenderingRegistry.registerEntityRenderingHandler(EntityIceBoltFailed.class, new RenderIceBolt());
		RenderingRegistry.registerEntityRenderingHandler(EntityIceBoltPlayer.class, new RenderIceBolt());

		RenderingRegistry.registerEntityRenderingHandler(EntityElsa.class, new RenderBipedFrozenCraft(new ModelBiped(), 0.5F, "textures/models/elsa.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityAnna.class, new RenderBipedFrozenCraft(new ModelBiped(), 0.5F, "textures/models/anna.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityKristoff.class, new RenderBipedFrozenCraft(new ModelBiped(), 0.5F, "textures/models/kristoff.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityHans.class, new RenderBipedFrozenCraft(new ModelBiped(), 0.5F, "textures/models/hans.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityDuke.class, new RenderBipedFrozenCraft(new ModelBiped(), 0.5F, "textures/models/duke.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityThug.class, new RenderThug());
	}
}