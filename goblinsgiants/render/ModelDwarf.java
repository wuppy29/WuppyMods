package goblinsgiants.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDwarf extends ModelBase
{
	ModelRenderer Body;
	ModelRenderer armLeft;
	ModelRenderer armRight;
	ModelRenderer legLeft;
	ModelRenderer legRight;
	ModelRenderer head;
	ModelRenderer axeStick;
	ModelRenderer axe1;
	ModelRenderer helmetLeft1;
	ModelRenderer helmetRight1;
	ModelRenderer axe2;
	ModelRenderer helmetLeft2;
	ModelRenderer helmetRight2;

	public ModelDwarf()
	{
		textureWidth = 64;
		textureHeight = 32;

		Body = new ModelRenderer(this, 29, 12);
		Body.addBox(-3F, -4F, -2F, 7, 8, 4);
		Body.setRotationPoint(-1F, 15F, -1F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		armLeft = new ModelRenderer(this, 54, 12);
		armLeft.addBox(0F, 0F, -1F, 2, 6, 2);
		armLeft.setRotationPoint(3F, 11.5F, -1F);
		armLeft.setTextureSize(64, 32);
		armLeft.mirror = true;
		setRotation(armLeft, 0F, 0F, 0F);
		armRight = new ModelRenderer(this, 19, 12);
		armRight.addBox(-2F, 0F, -1F, 2, 6, 2);
		armRight.setRotationPoint(-4F, 11.5F, -1F);
		armRight.setTextureSize(64, 32);
		armRight.mirror = true;
		setRotation(armRight, 0F, 0F, 0F);
		legLeft = new ModelRenderer(this, 41, 25);
		legLeft.addBox(-1F, 0F, -1F, 2, 5, 2);
		legLeft.setRotationPoint(1F, 19F, -1F);
		legLeft.setTextureSize(64, 32);
		legLeft.mirror = true;
		setRotation(legLeft, 0F, 0F, 0F);
		legRight = new ModelRenderer(this, 27, 25);
		legRight.addBox(-1F, 0F, -1F, 2, 5, 2);
		legRight.setRotationPoint(-2F, 19F, -1F);
		legRight.setTextureSize(64, 32);
		legRight.mirror = true;
		setRotation(legRight, 0F, 0F, 0F);
		head = new ModelRenderer(this, 33, 3);
		head.addBox(-1F, 0F, -1F, 5, 5, 3);
		head.setRotationPoint(-2F, 6F, -1F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		axeStick = new ModelRenderer(this, 4, 17);
		axeStick.addBox(-1F, 0F, -3F, 1, 1, 6);
		axeStick.setRotationPoint(-5F, 14F, -3F);
		axeStick.setTextureSize(64, 32);
		axeStick.mirror = true;
		setRotation(axeStick, -0.6108652F, 0F, 0F);
		axe1 = new ModelRenderer(this, 0, 25);
		axe1.addBox(0F, -1F, -1F, 1, 3, 3);
		axe1.setRotationPoint(-6F, 12F, -7F);
		axe1.setTextureSize(64, 32);
		axe1.mirror = true;
		setRotation(axe1, -0.6108652F, 0F, 0F);
		helmetLeft1 = new ModelRenderer(this, 44, 0);
		helmetLeft1.addBox(-2F, 0.1F, 0F, 4, 1, 1);
		helmetLeft1.setRotationPoint(2F, 6F, -1F);
		helmetLeft1.setTextureSize(64, 32);
		helmetLeft1.mirror = true;
		setRotation(helmetLeft1, 0F, 0F, 0F);
		helmetRight1 = new ModelRenderer(this, 27, 0);
		helmetRight1.addBox(-2F, 0.1F, 0F, 4, 1, 1);
		helmetRight1.setRotationPoint(-3F, 6F, -1F);
		helmetRight1.setTextureSize(64, 32);
		helmetRight1.mirror = true;
		setRotation(helmetRight1, 0F, 0F, 0F);
		axe2 = new ModelRenderer(this, 9, 26);
		axe2.addBox(0F, -2F, 0F, 0, 4, 1);
		axe2.setRotationPoint(-5.5F, 14F, -8F);
		axe2.setTextureSize(64, 32);
		axe2.mirror = true;
		setRotation(axe2, 0.9599311F, 0F, 0F);
		helmetLeft2 = new ModelRenderer(this, 57, 0);
		helmetLeft2.addBox(0F, -0.9F, -1F, 1, 2, 1);
		helmetLeft2.setRotationPoint(3F, 5F, 0F);
		helmetLeft2.setTextureSize(64, 32);
		helmetLeft2.mirror = true;
		setRotation(helmetLeft2, 0F, 0F, 0F);
		helmetRight2 = new ModelRenderer(this, 21, 0);
		helmetRight2.addBox(0F, -0.9F, 0F, 1, 2, 1);
		helmetRight2.setRotationPoint(-5F, 5F, -1F);
		helmetRight2.setTextureSize(64, 32);
		helmetRight2.mirror = true;
		setRotation(helmetRight2, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Body.render(f5);
		armLeft.render(f5);
		armRight.render(f5);
		legLeft.render(f5);
		legRight.render(f5);
		head.render(f5);
		axeStick.render(f5);
		axe1.render(f5);
		helmetLeft1.render(f5);
		helmetRight1.render(f5);
		axe2.render(f5);
		helmetLeft2.render(f5);
		helmetRight2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
		this.legRight.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.legLeft.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float) Math.PI) * 1.4F * par2;
		this.legRight.rotateAngleY = 0.0F;
		this.legLeft.rotateAngleY = 0.0F;
	}
}
