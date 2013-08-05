package koi;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKoi extends ModelBase
{
	// fields
	ModelRenderer body;
	ModelRenderer head;
	ModelRenderer right_vin;
	ModelRenderer left_vin;
	ModelRenderer tail;
	ModelRenderer tail_2;
	
	public ModelKoi()
	{
		textureWidth = 32;
		textureHeight = 32;
		
		body = new ModelRenderer(this, 9, 0);
		body.addBox(0F, 0F, 0F, 4, 4, 7);
		body.setRotationPoint(-1F, 13F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		head = new ModelRenderer(this, 0, 4);
		head.addBox(0F, 0F, 0F, 2, 2, 2);
		head.setRotationPoint(0F, 13F, -2F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		right_vin = new ModelRenderer(this, 0, 17);
		right_vin.addBox(0F, 0F, 0F, 3, 0, 1);
		right_vin.setRotationPoint(-1F, 15F, 1F);
		right_vin.setTextureSize(64, 32);
		right_vin.mirror = true;
		setRotation(right_vin, 1.561502F, -2.082002F, 0F);
		left_vin = new ModelRenderer(this, 0, 20);
		left_vin.addBox(0F, 0F, 0F, 3, 0, 1);
		left_vin.setRotationPoint(3F, 15F, 1F);
		left_vin.setTextureSize(64, 32);
		left_vin.mirror = true;
		setRotation(left_vin, 1.561502F, -1.189716F, 0F);
		tail = new ModelRenderer(this, 0, 0);
		tail.addBox(0F, 0F, 0F, 2, 1, 2);
		tail.setRotationPoint(0F, 14F, 7F);
		tail.setTextureSize(64, 32);
		tail.mirror = true;
		setRotation(tail, 0F, 0F, 0F);
		tail_2 = new ModelRenderer(this, 0, 9);
		tail_2.addBox(0F, 0F, 0F, 0, 2, 2);
		tail_2.setRotationPoint(1F, 13F, 8F);
		tail_2.setTextureSize(64, 32);
		tail_2.mirror = true;
		setRotation(tail_2, 0F, 0F, 0F);
	}
	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		body.render(f5);
		head.render(f5);
		right_vin.render(f5);
		left_vin.render(f5);
		tail.render(f5);
		tail_2.render(f5);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity par6Entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, par6Entity);
	}
}
