package com.wuppy.goblinsgiants.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelWerewolf extends ModelBase
{
	ModelRenderer Mane;
	ModelRenderer Body;
	ModelRenderer WolfHead;
	ModelRenderer Ear2;
	ModelRenderer Ear1;
	ModelRenderer Nose;
	ModelRenderer Leg4;
	ModelRenderer Leg3;
	ModelRenderer Tail;
	ModelRenderer Leg2;
	ModelRenderer Leg1;

	public ModelWerewolf()
	{
		textureWidth = 64;
		textureHeight = 32;

		Mane = new ModelRenderer(this, 21, 0);
		Mane.addBox(-4F, -3F, -3F, 8, 6, 7);
		Mane.setRotationPoint(-1F, 7F, 1F);
		Mane.setTextureSize(64, 32);
		Mane.mirror = true;
		setRotation(Mane, 1.239184F, 0F, 0F);
		Body = new ModelRenderer(this, 18, 14);
		Body.addBox(-4F, -2F, -3F, 6, 11, 6);
		Body.setRotationPoint(0F, 8F, 3F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 0.5235988F, 0F, 0F);
		WolfHead = new ModelRenderer(this, 0, 0);
		WolfHead.addBox(-3F, -3F, -2F, 6, 6, 4);
		WolfHead.setRotationPoint(-1F, 5.5F, -2.5F);
		WolfHead.setTextureSize(64, 32);
		WolfHead.mirror = true;
		setRotation(WolfHead, 0F, 0F, 0F);
		Ear2 = new ModelRenderer(this, 16, 14);
		Ear2.addBox(1F, -5F, 0F, 2, 2, 1);
		Ear2.setRotationPoint(-1F, 5.5F, -3F);
		Ear2.setTextureSize(64, 32);
		Ear2.mirror = true;
		setRotation(Ear2, 0F, 0F, 0F);
		Ear1 = new ModelRenderer(this, 16, 14);
		Ear1.addBox(-3F, -5F, 0F, 2, 2, 1);
		Ear1.setRotationPoint(-1F, 5.5F, -3F);
		Ear1.setTextureSize(64, 32);
		Ear1.mirror = true;
		setRotation(Ear1, 0F, 0F, 0F);
		Nose = new ModelRenderer(this, 0, 10);
		Nose.addBox(-2F, 0F, -5F, 3, 3, 4);
		Nose.setRotationPoint(-0.5F, 5.5F, -3F);
		Nose.setTextureSize(64, 32);
		Nose.mirror = true;
		setRotation(Nose, 0F, 0F, 0F);
		Leg4 = new ModelRenderer(this, 0, 18);
		Leg4.addBox(-1F, 0F, -1F, 2, 6, 2);
		Leg4.setRotationPoint(0.5F, 9F, -1F);
		Leg4.setTextureSize(64, 32);
		Leg4.mirror = true;
		setRotation(Leg4, 0F, 0F, 0F);
		Leg3 = new ModelRenderer(this, 0, 18);
		Leg3.addBox(-1F, 0F, -1F, 2, 6, 2);
		Leg3.setRotationPoint(-2.5F, 9F, -1F);
		Leg3.setTextureSize(64, 32);
		Leg3.mirror = true;
		setRotation(Leg3, 0F, 0F, 0F);
		Tail = new ModelRenderer(this, 9, 18);
		Tail.addBox(-1F, 0F, -1F, 2, 8, 2);
		Tail.setRotationPoint(-1F, 15F, 7F);
		Tail.setTextureSize(64, 32);
		Tail.mirror = true;
		setRotation(Tail, 1.117011F, 0F, 0F);
		Leg2 = new ModelRenderer(this, 0, 18);
		Leg2.addBox(-1F, 0F, -1F, 2, 8, 2);
		Leg2.setRotationPoint(0.5F, 16F, 6F);
		Leg2.setTextureSize(64, 32);
		Leg2.mirror = true;
		setRotation(Leg2, 0F, 0F, 0F);
		Leg1 = new ModelRenderer(this, 0, 18);
		Leg1.addBox(-1F, 0F, -1F, 2, 8, 2);
		Leg1.setRotationPoint(-2.5F, 16F, 6F);
		Leg1.setTextureSize(64, 32);
		Leg1.mirror = true;
		setRotation(Leg1, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Mane.render(f5);
		Body.render(f5);
		WolfHead.render(f5);
		Ear2.render(f5);
		Ear1.render(f5);
		Nose.render(f5);
		Leg4.render(f5);
		Leg3.render(f5);
		Tail.render(f5);
		Leg2.render(f5);
		Leg1.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
	{
		this.Leg1.rotateAngleX = MathHelper.cos(par1 * 0.6F) * 0.4F * par2;
		this.Leg2.rotateAngleX = MathHelper.cos(par1 * 0.6F + (float) Math.PI) * 0.4F * par2;

		this.Tail.rotateAngleX = MathHelper.sin(par2 * 1.4F) + 0.5F;
	}
}
