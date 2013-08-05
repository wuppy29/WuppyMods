package goblinsgiants.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGiant extends ModelBase
{
	// fields
	ModelRenderer rigthLeg;
	ModelRenderer legleft;
	ModelRenderer body;
	ModelRenderer armright;
	ModelRenderer armleft;
	ModelRenderer head;

	public ModelGiant()
	{
		textureWidth = 128;
		textureHeight = 128;

		rigthLeg = new ModelRenderer(this, 10, 90);
		rigthLeg.addBox(-4F, 0F, -4F, 8, 24, 8);
		rigthLeg.setRotationPoint(-4F, 0F, 0F);
		rigthLeg.setTextureSize(128, 128);
		rigthLeg.mirror = true;
		setRotation(rigthLeg, 0F, 0F, 0F);
		legleft = new ModelRenderer(this, 80, 90);
		legleft.addBox(-4F, 0F, -4F, 8, 24, 8);
		legleft.setRotationPoint(4F, 0F, 0F);
		legleft.setTextureSize(128, 128);
		legleft.mirror = true;
		setRotation(legleft, 0F, 0F, 0F);
		body = new ModelRenderer(this, 35, 50);
		body.addBox(-8F, -24F, -4F, 16, 24, 8);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(128, 128);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		armright = new ModelRenderer(this, 0, 50);
		armright.addBox(-6F, -3F, -4F, 8, 24, 8);
		armright.setRotationPoint(-10F, -21F, 0F);
		armright.setTextureSize(128, 128);
		armright.mirror = true;
		setRotation(armright, 0F, 0F, 0F);
		armleft = new ModelRenderer(this, 90, 50);
		armleft.addBox(-1F, -3F, -4F, 8, 24, 8);
		armleft.setRotationPoint(9F, -21F, 0F);
		armleft.setTextureSize(128, 128);
		armleft.mirror = true;
		setRotation(armleft, 0F, 0F, 0F);
		head = new ModelRenderer(this, 25, 10);
		head.addBox(-8F, -16F, -8F, 16, 16, 16);
		head.setRotationPoint(0F, -24F, 0F);
		head.setTextureSize(128, 128);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		rigthLeg.render(f5);
		legleft.render(f5);
		body.render(f5);
		armright.render(f5);
		armleft.render(f5);
		head.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
	{
		this.head.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.head.rotateAngleX = par5 / (180F / (float) Math.PI);
		this.armright.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float) Math.PI) * 2.0F * par2 * 0.5F;
		this.armleft.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
		this.armright.rotateAngleZ = 0.0F;
		this.armleft.rotateAngleZ = 0.0F;
		this.rigthLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.legleft.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float) Math.PI) * 1.4F * par2;
		this.rigthLeg.rotateAngleY = 0.0F;
		this.legleft.rotateAngleY = 0.0F;
	}
}
