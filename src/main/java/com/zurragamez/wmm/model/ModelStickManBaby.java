package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelStickManBaby extends ModelBase {

    ModelRenderer LegLeft;
    ModelRenderer LegRight;
    ModelRenderer Body;
    ModelRenderer ArmLeft;
    ModelRenderer ArmRight;
    ModelRenderer Head;

    public ModelStickManBaby() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.LegLeft = new ModelRenderer(this, 22, 0);
        this.LegLeft.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
        this.LegLeft.setRotationPoint(0.5F, 21.0F, 0.0F);
        this.LegLeft.setTextureSize(64, 32);
        this.LegLeft.mirror = true;
        this.setRotation(this.LegLeft, 0.0F, 0.0F, -0.2268928F);
        this.LegRight = new ModelRenderer(this, 22, 0);
        this.LegRight.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 1);
        this.LegRight.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.LegRight.setTextureSize(64, 32);
        this.LegRight.mirror = true;
        this.setRotation(this.LegRight, 0.0F, 0.0F, 0.2268928F);
        this.Body = new ModelRenderer(this, 0, 9);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
        this.Body.setRotationPoint(-0.25F, 16.0F, 0.0F);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
        this.ArmLeft = new ModelRenderer(this, 17, 0);
        this.ArmLeft.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
        this.ArmLeft.setRotationPoint(0.5F, 17.0F, 0.0F);
        this.ArmLeft.setTextureSize(64, 32);
        this.ArmLeft.mirror = true;
        this.setRotation(this.ArmLeft, 0.0F, 0.0F, -0.5585054F);
        this.ArmRight = new ModelRenderer(this, 17, 0);
        this.ArmRight.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 1);
        this.ArmRight.setRotationPoint(0.0F, 17.0F, 0.0F);
        this.ArmRight.setTextureSize(64, 32);
        this.ArmRight.mirror = true;
        this.setRotation(this.ArmRight, 0.0F, 0.0F, 0.5585054F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 4);
        this.Head.setRotationPoint(0.25F, 16.0F, 0.5F);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.LegLeft.render(f5);
        this.LegRight.render(f5);
        this.Body.render(f5);
        this.ArmLeft.render(f5);
        this.ArmRight.render(f5);
        this.Head.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        this.Head.rotateAngleX = f4 / 57.295776F;
        this.Head.rotateAngleY = f5 / 57.295776F;
        this.LegLeft.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.LegRight.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
        this.ArmLeft.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
        this.ArmRight.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    }
}
