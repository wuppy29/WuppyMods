package com.wuppy.koi;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKoi extends ModelBase {
	// fields
	ModelRenderer Koi_Body;
	ModelRenderer Koi_Nose;
	ModelRenderer Mouth;
	ModelRenderer Tail1;
	ModelRenderer Tail2;
	ModelRenderer Tail3;
	ModelRenderer Tail_Fin;
	ModelRenderer Fin_1;
	ModelRenderer Fin_2;
	ModelRenderer Top_Fin;

	public ModelKoi() {
		textureWidth = 32;
		textureHeight = 32;

		Koi_Body = new ModelRenderer(this, 9, 10);
		Koi_Body.addBox(0F, 0F, 0F, 5, 2, 2);
		Koi_Body.setRotationPoint(-2F, 7F, -1F);
		Koi_Body.setTextureSize(64, 32);
		Koi_Body.mirror = true;
		setRotation(Koi_Body, 0F, 0F, 0F);
		Koi_Nose = new ModelRenderer(this, 0, 11);
		Koi_Nose.addBox(0F, 0F, 0F, 2, 1, 2);
		Koi_Nose.setRotationPoint(3F, 7F, -1F);
		Koi_Nose.setTextureSize(64, 32);
		Koi_Nose.mirror = true;
		setRotation(Koi_Nose, 0F, 0F, 0.7807508F);
		Mouth = new ModelRenderer(this, 0, 16);
		Mouth.addBox(0F, 0F, 0F, 1, 1, 2);
		Mouth.setRotationPoint(3F, 8F, -1F);
		Mouth.setTextureSize(64, 32);
		Mouth.mirror = true;
		setRotation(Mouth, 0F, 0F, 0F);
		Tail1 = new ModelRenderer(this, 24, 15);
		Tail1.addBox(0F, 0F, 0F, 2, 2, 1);
		Tail1.setRotationPoint(-3F, 7F, -0.6F);
		Tail1.setTextureSize(64, 32);
		Tail1.mirror = true;
		setRotation(Tail1, 0F, 0.1995252F, 0F);
		Tail1.mirror = false;
		Tail2 = new ModelRenderer(this, 24, 7);
		Tail2.addBox(0F, 0F, 0F, 2, 2, 1);
		Tail2.setRotationPoint(-2.7F, 7F, -0.4F);
		Tail2.setTextureSize(64, 32);
		Tail2.mirror = true;
		setRotation(Tail2, 0F, -0.2230717F, 0F);
		Tail3 = new ModelRenderer(this, 24, 11);
		Tail3.addBox(0F, 0F, 0F, 1, 2, 1);
		Tail3.setRotationPoint(-3F, 7F, -0.5F);
		Tail3.setTextureSize(64, 32);
		Tail3.mirror = true;
		setRotation(Tail3, 0F, 0F, 0F);
		Tail_Fin = new ModelRenderer(this, 26, 21);
		Tail_Fin.addBox(0F, 0F, 0F, 2, 4, 0);
		Tail_Fin.setRotationPoint(-5F, 6F, 0F);
		Tail_Fin.setTextureSize(64, 32);
		Tail_Fin.mirror = true;
		setRotation(Tail_Fin, 0F, 0F, 0F);
		Fin_1 = new ModelRenderer(this, 11, 16);
		Fin_1.addBox(0F, 0F, 0F, 3, 1, 1);
		Fin_1.setRotationPoint(-1F, 7.5F, 0.5F);
		Fin_1.setTextureSize(64, 32);
		Fin_1.mirror = true;
		setRotation(Fin_1, 0F, 0F, 0F);
		Fin_2 = new ModelRenderer(this, 11, 7);
		Fin_2.addBox(0F, 0F, 0F, 3, 1, 1);
		Fin_2.setRotationPoint(-1F, 7.5F, -1.5F);
		Fin_2.setTextureSize(64, 32);
		Fin_2.mirror = true;
		setRotation(Fin_2, 0F, 0F, 0F);
		Top_Fin = new ModelRenderer(this, 10, 3);
		Top_Fin.addBox(0F, 0F, 0F, 5, 2, 0);
		Top_Fin.setRotationPoint(-2F, 6F, 0F);
		Top_Fin.setTextureSize(64, 32);
		Top_Fin.mirror = true;
		setRotation(Top_Fin, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Koi_Body.render(f5);
		Koi_Nose.render(f5);
		Mouth.render(f5);
		Tail1.render(f5);
		Tail2.render(f5);
		Tail3.render(f5);
		Tail_Fin.render(f5);
		Fin_1.render(f5);
		Fin_2.render(f5);
		Top_Fin.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity par6Entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, par6Entity);
	}
}