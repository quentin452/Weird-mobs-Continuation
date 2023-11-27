package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSpinningFeets extends ModelBase {

    ModelRenderer Plank;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    ModelRenderer RightFootDown;
    ModelRenderer RightFootUp;
    ModelRenderer LeftFootFront;
    ModelRenderer LeftFootBack;
    ModelRenderer Neck;
    ModelRenderer Head;
    ModelRenderer RightEar;
    ModelRenderer LeftEar;

    public ModelSpinningFeets() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Plank = new ModelRenderer(this, 0, 16);
        this.Plank.addBox(-6.0F, -1.5F, -1.5F, 12, 3, 3);
        this.Plank.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.Plank.setTextureSize(64, 32);
        this.Plank.mirror = true;
        this.setRotation(this.Plank, 0.0F, 0.0F, 0.0F);
        this.RightLeg = new ModelRenderer(this, 32, 0);
        this.RightLeg.addBox(0.0F, -4.5F, -1.0F, 1, 9, 2);
        this.RightLeg.setRotationPoint(-7.0F, 19.0F, 0.0F);
        this.RightLeg.setTextureSize(64, 32);
        this.RightLeg.mirror = true;
        this.setRotation(this.RightLeg, 0.0F, 0.0F, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 38, 0);
        this.LeftLeg.addBox(-1.0F, -1.0F, -4.5F, 1, 2, 9);
        this.LeftLeg.setRotationPoint(7.0F, 19.0F, 0.0F);
        this.LeftLeg.setTextureSize(64, 32);
        this.LeftLeg.mirror = true;
        this.setRotation(this.LeftLeg, 0.0F, 0.0F, 0.0F);
        this.RightFootDown = new ModelRenderer(this, 32, 11);
        this.RightFootDown.addBox(-1.0F, 4.0F, -1.1F, 3, 1, 4);
        this.RightFootDown.setRotationPoint(-7.0F, 19.0F, 0.0F);
        this.RightFootDown.setTextureSize(64, 32);
        this.RightFootDown.mirror = true;
        this.setRotation(this.RightFootDown, 0.0F, 0.0F, 0.0F);
        this.RightFootUp = new ModelRenderer(this, 32, 11);
        this.RightFootUp.addBox(-1.0F, -5.0F, -2.9F, 3, 1, 4);
        this.RightFootUp.setRotationPoint(-7.0F, 19.0F, 0.0F);
        this.RightFootUp.setTextureSize(64, 32);
        this.RightFootUp.mirror = true;
        this.setRotation(this.RightFootUp, 0.0F, 0.0F, 0.0F);
        this.LeftFootFront = new ModelRenderer(this, 30, 16);
        this.LeftFootFront.addBox(-2.0F, -2.9F, -5.0F, 3, 4, 1);
        this.LeftFootFront.setRotationPoint(7.0F, 19.0F, 0.0F);
        this.LeftFootFront.setTextureSize(64, 32);
        this.LeftFootFront.mirror = true;
        this.setRotation(this.LeftFootFront, 0.0F, 0.0F, 0.0F);
        this.LeftFootBack = new ModelRenderer(this, 30, 16);
        this.LeftFootBack.addBox(-2.0F, -1.1F, 4.0F, 3, 4, 1);
        this.LeftFootBack.setRotationPoint(7.0F, 19.0F, 0.0F);
        this.LeftFootBack.setTextureSize(64, 32);
        this.LeftFootBack.mirror = true;
        this.setRotation(this.LeftFootBack, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 46, 11);
        this.Neck.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
        this.Neck.setRotationPoint(-1.0F, 16.0F, -1.0F);
        this.Neck.setTextureSize(64, 32);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
        this.Head.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
        this.RightEar = new ModelRenderer(this, 38, 16);
        this.RightEar.addBox(-8.0F, -3.0F, -1.5F, 4, 1, 3);
        this.RightEar.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.RightEar.setTextureSize(64, 32);
        this.RightEar.mirror = true;
        this.setRotation(this.RightEar, 0.0F, 0.0F, 0.0F);
        this.LeftEar = new ModelRenderer(this, 38, 16);
        this.LeftEar.addBox(4.0F, -3.0F, -1.5F, 4, 1, 3);
        this.LeftEar.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.LeftEar.setTextureSize(64, 32);
        this.LeftEar.mirror = true;
        this.setRotation(this.LeftEar, 0.0F, 0.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.Plank.render(f5);
        this.RightLeg.render(f5);
        this.LeftLeg.render(f5);
        this.RightFootDown.render(f5);
        this.RightFootUp.render(f5);
        this.LeftFootFront.render(f5);
        this.LeftFootBack.render(f5);
        this.Neck.render(f5);
        this.Head.render(f5);
        this.RightEar.render(f5);
        this.LeftEar.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        this.Head.rotateAngleX = f4 / 57.295776F;
        this.Head.rotateAngleY = f5 / 57.295776F;
        this.RightEar.rotateAngleY = f5 / 57.295776F;
        this.LeftEar.rotateAngleX = f4 / 57.295776F;
        this.RightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.15F * f2;
        this.LeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.15F * f2;
        this.RightFootUp.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.15F * f2;
        this.RightFootDown.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.15F * f2;
        this.LeftFootFront.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.15F * f2;
        this.LeftFootBack.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.15F * f2;
    }
}
