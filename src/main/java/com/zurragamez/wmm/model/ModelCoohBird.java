package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCoohBird extends ModelBase {

    ModelRenderer Body;
    ModelRenderer Left_quad;
    ModelRenderer Leg_leg;
    ModelRenderer Leg_foot;
    ModelRenderer Right_quad;
    ModelRenderer Right_leg;
    ModelRenderer Right_foot;
    ModelRenderer Head;
    ModelRenderer Left_Ear;
    ModelRenderer Upper_beak;
    ModelRenderer Lower_beak;
    ModelRenderer Right_Ear;
    ModelRenderer Tail;

    public ModelCoohBird() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Body = new ModelRenderer(this, 54, 37);
        this.Body.addBox(-6.0F, -6.0F, -6.0F, 12, 12, 15);
        this.Body.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.Body.setTextureSize(128, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
        this.Left_quad = new ModelRenderer(this, 54, 18);
        this.Left_quad.addBox(0.0F, -3.0F, -3.0F, 5, 7, 7);
        this.Left_quad.setRotationPoint(6.0F, 7.0F, 3.0F);
        this.Left_quad.setTextureSize(128, 64);
        this.Left_quad.mirror = true;
        this.setRotation(this.Left_quad, 0.0F, 0.0F, 0.0F);
        this.Leg_leg = new ModelRenderer(this, 0, 30);
        this.Leg_leg.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4);
        this.Leg_leg.setRotationPoint(8.0F, 10.0F, 4.0F);
        this.Leg_leg.setTextureSize(128, 64);
        this.Leg_leg.mirror = true;
        this.setRotation(this.Leg_leg, -0.5576851F, 0.0F, 0.0F);
        this.Leg_foot = new ModelRenderer(this, 20, 30);
        this.Leg_foot.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4);
        this.Leg_foot.setRotationPoint(8.0F, 16.0F, 0.0F);
        this.Leg_foot.setTextureSize(128, 64);
        this.Leg_foot.mirror = true;
        this.setRotation(this.Leg_foot, 0.0F, 0.0F, 0.0F);
        this.Right_quad = new ModelRenderer(this, 54, 18);
        this.Right_quad.addBox(-5.0F, -3.0F, -3.0F, 5, 7, 7);
        this.Right_quad.setRotationPoint(-6.0F, 7.0F, 3.0F);
        this.Right_quad.setTextureSize(128, 64);
        this.Right_quad.mirror = true;
        this.setRotation(this.Right_quad, 0.0F, 0.0F, 0.0F);
        this.Right_leg = new ModelRenderer(this, 0, 30);
        this.Right_leg.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4);
        this.Right_leg.setRotationPoint(-8.0F, 10.0F, 4.0F);
        this.Right_leg.setTextureSize(128, 64);
        this.Right_leg.mirror = true;
        this.setRotation(this.Right_leg, -0.5576851F, 0.0F, 0.0F);
        this.Right_foot = new ModelRenderer(this, 20, 30);
        this.Right_foot.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4);
        this.Right_foot.setRotationPoint(-8.0F, 16.0F, 0.0F);
        this.Right_foot.setTextureSize(128, 64);
        this.Right_foot.mirror = true;
        this.setRotation(this.Right_foot, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.addBox(-4.0F, -8.0F, -7.0F, 8, 12, 8);
        this.Head.setRotationPoint(0.0F, 1.0F, -6.0F);
        this.Head.setTextureSize(128, 64);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
        this.Left_Ear = new ModelRenderer(this, 58, 0);
        this.Left_Ear.addBox(1.0F, -5.0F, 0.0F, 4, 4, 5);
        this.Left_Ear.setRotationPoint(1.0F, -6.0F, -5.0F);
        this.Left_Ear.setTextureSize(128, 64);
        this.Left_Ear.mirror = true;
        this.setRotation(this.Left_Ear, 0.0F, 0.0F, 0.0F);
        this.Upper_beak = new ModelRenderer(this, 104, 26);
        this.Upper_beak.addBox(-4.0F, -1.0F, -4.0F, 8, 2, 4);
        this.Upper_beak.setRotationPoint(0.0F, -1.0F, -13.0F);
        this.Upper_beak.setTextureSize(128, 64);
        this.Upper_beak.mirror = true;
        this.setRotation(this.Upper_beak, 0.0F, 0.0F, 0.0F);
        this.Lower_beak = new ModelRenderer(this, 79, 26);
        this.Lower_beak.addBox(-4.0F, -1.0F, -4.0F, 8, 2, 4);
        this.Lower_beak.setRotationPoint(0.0F, 1.0F, -13.0F);
        this.Lower_beak.setTextureSize(128, 64);
        this.Lower_beak.mirror = true;
        this.setRotation(this.Lower_beak, 0.0F, 0.0F, 0.0F);
        this.Right_Ear = new ModelRenderer(this, 58, 0);
        this.Right_Ear.addBox(-6.0F, -5.0F, 0.0F, 4, 4, 5);
        this.Right_Ear.setRotationPoint(0.0F, -6.0F, -5.0F);
        this.Right_Ear.setTextureSize(128, 64);
        this.Right_Ear.mirror = true;
        this.setRotation(this.Right_Ear, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 78, 0);
        this.Tail.addBox(-5.0F, -5.0F, 0.0F, 10, 10, 14);
        this.Tail.setRotationPoint(0.0F, 4.0F, 7.0F);
        this.Tail.setTextureSize(128, 64);
        this.Tail.mirror = true;
        this.setRotation(this.Tail, 0.4461433F, 0.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.Body.render(f5);
        this.Left_quad.render(f5);
        this.Leg_leg.render(f5);
        this.Leg_foot.render(f5);
        this.Right_quad.render(f5);
        this.Right_leg.render(f5);
        this.Right_foot.render(f5);
        this.Head.render(f5);
        this.Left_Ear.render(f5);
        this.Upper_beak.render(f5);
        this.Lower_beak.render(f5);
        this.Right_Ear.render(f5);
        this.Tail.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        this.Leg_foot.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
        this.Right_foot.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        if (MathHelper.cos(f * 0.6662F) * 1.4F * f1 < 0.0F) {
            this.Upper_beak.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.5F * f1;
        }

        if (MathHelper.cos(f * 0.6662F) * 1.4F * -f1 > 0.0F) {
            this.Lower_beak.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.5F * -f1;
        }

        this.Tail.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    }
}
