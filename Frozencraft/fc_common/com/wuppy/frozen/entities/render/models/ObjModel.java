package com.wuppy.frozen.entities.render.models;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract class ObjModel
{
	private IModelCustom objModel;

	public ObjModel(ResourceLocation customModelLocation)
	{
		this.objModel = AdvancedModelLoader.loadModel(customModelLocation);
	}

	public void renderAll()
	{
		objModel.renderAll();
	}

	public void renderAllExcept(String... excludedGroupNames)
	{
		objModel.renderAllExcept(excludedGroupNames);
	}

	public void renderOnly(String... groupNames)
	{
		objModel.renderOnly(groupNames);
	}

	public void renderPart(String part)
	{
		objModel.renderPart(part);
	}
}