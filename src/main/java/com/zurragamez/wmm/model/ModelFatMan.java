package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelFatMan extends ModelBase {

    ModelRenderer Body;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Arm1;
    ModelRenderer Arm2;

    public ModelFatMan() {
        this.textureWidth = 64;
        this.textureHeight = 128;
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 10, 9, 10);
        this.Body.setRotationPoint(-5.0F, 10.0F, -5.0F);
        this.Body.setTextureSize(64, 128);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
        this.Leg1 = new ModelRenderer(this, 51, 2);
        this.Leg1.addBox(0.0F, 0.0F, 0.0F, 3, 5, 3);
        this.Leg1.setRotationPoint(1.0F, 19.0F, -1.0F);
        this.Leg1.setTextureSize(64, 128);
        this.Leg1.mirror = true;
        this.setRotation(this.Leg1, 0.0F, 0.0F, 0.0F);
        this.Leg2 = new ModelRenderer(this, 51, 2);
        this.Leg2.addBox(-3.0F, 0.0F, 0.0F, 3, 5, 3);
        this.Leg2.setRotationPoint(-1.0F, 19.0F, -1.0F);
        this.Leg2.setTextureSize(64, 128);
        this.Leg2.mirror = true;
        this.setRotation(this.Leg2, 0.0F, 0.0F, 0.0F);
        this.Arm1 = new ModelRenderer(this, 31, 27);
        this.Arm1.addBox(0.0F, 0.0F, -14.0F, 2, 2, 14);
        this.Arm1.setRotationPoint(5.0F, 15.0F, -1.0F);
        this.Arm1.setTextureSize(64, 128);
        this.Arm1.mirror = true;
        this.setRotation(this.Arm1, 0.0F, 0.0F, 0.0F);
        this.Arm2 = new ModelRenderer(this, 31, 27);
        this.Arm2.addBox(-2.0F, 0.0F, -14.0F, 2, 2, 14);
        this.Arm2.setRotationPoint(-5.0F, 15.0F, -1.0F);
        this.Arm2.setTextureSize(64, 128);
        this.Arm2.mirror = true;
        this.setRotation(this.Arm2, 0.0F, 0.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.Body.render(f5);
        this.Leg1.render(f5);
        this.Leg2.render(f5);
        this.Arm1.render(f5);
        this.Arm2.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, (Entity) null);
        this.Leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
        this.Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.0F * f1;
        this.Arm1.rotateAngleY = MathHelper.cos(f * 2.1985F) * 1.5F * f5;
        this.Arm2.rotateAngleY = MathHelper.cos(f * 2.9985F + 3.1415927F) * 1.5F * f5;
        this.Arm1.rotateAngleZ = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
        this.Arm2.rotateAngleZ = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.0F * f1;
    }
}
