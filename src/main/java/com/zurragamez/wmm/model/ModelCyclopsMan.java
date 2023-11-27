package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCyclopsMan extends ModelBase {

    ModelRenderer Head;
    ModelRenderer Glass1;
    ModelRenderer Glass2;
    ModelRenderer Body;
    ModelRenderer Right_arm;
    ModelRenderer Left_Arm;
    ModelRenderer Left_Leg;
    ModelRenderer Right_Leg;
    ModelRenderer Back;
    ModelRenderer Back_1;

    public ModelCyclopsMan() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Head = new ModelRenderer(this, 29, 0);
        this.Head.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8);
        this.Head.setRotationPoint(-3.0F, 0.0F, -4.0F);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
        this.Glass1 = new ModelRenderer(this, 0, 26);
        this.Glass1.addBox(0.0F, 0.0F, 0.0F, 5, 5, 1);
        this.Glass1.setRotationPoint(-1.5F, 1.5F, -5.0F);
        this.Glass1.setTextureSize(64, 32);
        this.Glass1.mirror = true;
        this.setRotation(this.Glass1, 0.0F, 0.0F, 0.0F);
        this.Glass2 = new ModelRenderer(this, 15, 28);
        this.Glass2.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1);
        this.Glass2.setRotationPoint(-0.5F, 2.5F, -5.5F);
        this.Glass2.setTextureSize(64, 32);
        this.Glass2.mirror = true;
        this.setRotation(this.Glass2, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 8, 8, 6);
        this.Body.setRotationPoint(-3.0F, 8.0F, 0.0F);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
        this.Right_arm = new ModelRenderer(this, 25, 19);
        this.Right_arm.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2);
        this.Right_arm.setRotationPoint(-5.0F, 8.0F, 2.0F);
        this.Right_arm.setTextureSize(64, 32);
        this.Right_arm.mirror = true;
        this.setRotation(this.Right_arm, 0.0F, 0.0F, 0.0F);
        this.Left_Arm = new ModelRenderer(this, 15, 16);
        this.Left_Arm.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2);
        this.Left_Arm.setRotationPoint(5.0F, 8.0F, 2.0F);
        this.Left_Arm.setTextureSize(64, 32);
        this.Left_Arm.mirror = true;
        this.setRotation(this.Left_Arm, 0.0F, 0.0F, 0.0F);
        this.Left_Leg = new ModelRenderer(this, 43, 20);
        this.Left_Leg.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
        this.Left_Leg.setRotationPoint(2.0F, 16.0F, 2.0F);
        this.Left_Leg.setTextureSize(64, 32);
        this.Left_Leg.mirror = true;
        this.setRotation(this.Left_Leg, 0.0F, 0.0F, 0.0F);
        this.Right_Leg = new ModelRenderer(this, 35, 20);
        this.Right_Leg.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
        this.Right_Leg.setRotationPoint(-2.0F, 16.0F, 2.0F);
        this.Right_Leg.setTextureSize(64, 32);
        this.Right_Leg.mirror = true;
        this.setRotation(this.Right_Leg, 0.0F, 0.0F, 0.0F);
        this.Back = new ModelRenderer(this, 52, 17);
        this.Back.addBox(0.0F, 0.0F, 0.0F, 4, 10, 2);
        this.Back.setRotationPoint(-1.0F, 6.0F, 6.0F);
        this.Back.setTextureSize(64, 32);
        this.Back.mirror = true;
        this.setRotation(this.Back, 0.0F, 0.0F, 0.0F);
        this.Back_1 = new ModelRenderer(this, 2, 1);
        this.Back_1.addBox(0.0F, 0.0F, 0.0F, 8, 2, 2);
        this.Back_1.setRotationPoint(-3.0F, 6.0F, 4.0F);
        this.Back_1.setTextureSize(64, 32);
        this.Back_1.mirror = true;
        this.setRotation(this.Back_1, 0.0F, 0.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.Head.render(f5);
        this.Glass1.render(f5);
        this.Glass2.render(f5);
        this.Body.render(f5);
        this.Right_arm.render(f5);
        this.Left_Arm.render(f5);
        this.Left_Leg.render(f5);
        this.Right_Leg.render(f5);
        this.Back.render(f5);
        this.Back_1.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        this.Left_Leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.Right_Leg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
        this.Left_Arm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
        this.Right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    }
}
