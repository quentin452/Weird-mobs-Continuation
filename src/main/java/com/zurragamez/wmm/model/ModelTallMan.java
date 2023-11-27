package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTallMan extends ModelBase {

    ModelRenderer Leg_2;
    ModelRenderer Leg_1;
    ModelRenderer Body;
    ModelRenderer Arm_1;
    ModelRenderer Arm_2;
    ModelRenderer Neck;
    ModelRenderer Head;
    ModelRenderer Arrow_1;

    public ModelTallMan() {
        this.textureWidth = 64;
        this.textureHeight = 128;
        this.Leg_2 = new ModelRenderer(this, 0, 0);
        this.Leg_2.addBox(-1.0F, 0.0F, -1.0F, 2, 36, 2);
        this.Leg_2.setRotationPoint(-2.0F, -13.0F, 1.0F);
        this.Leg_2.setTextureSize(64, 128);
        this.Leg_2.mirror = true;
        this.setRotation(this.Leg_2, 0.0F, 0.0F, 0.0F);
        this.Leg_1 = new ModelRenderer(this, 0, 0);
        this.Leg_1.addBox(-1.0F, 0.0F, -1.0F, 2, 36, 2);
        this.Leg_1.setRotationPoint(2.0F, -13.0F, 1.0F);
        this.Leg_1.setTextureSize(64, 128);
        this.Leg_1.mirror = true;
        this.setRotation(this.Leg_1, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 15, 23);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 10, 35, 8);
        this.Body.setRotationPoint(-5.0F, -48.0F, -3.0F);
        this.Body.setTextureSize(64, 128);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
        this.Arm_1 = new ModelRenderer(this, 53, 17);
        this.Arm_1.addBox(-1.0F, 0.0F, -1.0F, 2, 40, 2);
        this.Arm_1.setRotationPoint(-6.0F, -48.0F, 0.0F);
        this.Arm_1.setTextureSize(64, 128);
        this.Arm_1.mirror = true;
        this.setRotation(this.Arm_1, 0.0F, 0.0F, 0.0F);
        this.Arm_2 = new ModelRenderer(this, 53, 17);
        this.Arm_2.addBox(-1.0F, 0.0F, -1.0F, 2, 40, 2);
        this.Arm_2.setRotationPoint(6.0F, -48.0F, 1.0F);
        this.Arm_2.setTextureSize(64, 128);
        this.Arm_2.mirror = true;
        this.setRotation(this.Arm_2, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 45, 1);
        this.Neck.addBox(0.0F, 0.0F, -0.4666667F, 4, 7, 5);
        this.Neck.setRotationPoint(-2.0F, -55.0F, -1.0F);
        this.Neck.setTextureSize(64, 128);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 26, 88);
        this.Head.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8);
        this.Head.setRotationPoint(-4.0F, -63.0F, -3.0F);
        this.Head.setTextureSize(64, 128);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
        this.Arrow_1 = new ModelRenderer(this, 8, 74);
        this.Arrow_1.addBox(0.0F, 0.0F, 0.0F, 17, 1, 1);
        this.Arrow_1.setRotationPoint(-8.0F, -62.0F, 0.0F);
        this.Arrow_1.setTextureSize(64, 128);
        this.Arrow_1.mirror = true;
        this.setRotation(this.Arrow_1, 0.0F, 0.0F, 0.2443461F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.Leg_2.render(f5);
        this.Leg_1.render(f5);
        this.Body.render(f5);
        this.Arm_1.render(f5);
        this.Arm_2.render(f5);
        this.Neck.render(f5);
        this.Head.render(f5);
        this.Arrow_1.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        this.Leg_1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.Leg_2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
        this.Arm_1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.Arm_2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
    }
}
