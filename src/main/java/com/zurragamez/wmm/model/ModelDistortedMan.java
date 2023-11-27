package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDistortedMan extends ModelBase {

    ModelRenderer Head;
    ModelRenderer Nose;
    ModelRenderer Neck;
    ModelRenderer Hips;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    ModelRenderer LeftFoot;
    ModelRenderer RightFoot;
    ModelRenderer LeftArm1;
    ModelRenderer RightArm1;
    ModelRenderer LeftArm2;
    ModelRenderer RightArm2;
    ModelRenderer LeftHand;
    ModelRenderer RightHand;
    ModelRenderer Hair;

    public ModelDistortedMan() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
        this.Nose = new ModelRenderer(this, 32, 0);
        this.Nose.addBox(-1.0F, -4.0F, -7.0F, 2, 2, 3);
        this.Nose.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Nose.setTextureSize(64, 32);
        this.Nose.mirror = true;
        this.setRotation(this.Nose, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 42, 0);
        this.Neck.addBox(0.0F, 0.0F, 0.0F, 2, 16, 2);
        this.Neck.setRotationPoint(-1.0F, 0.0F, -1.0F);
        this.Neck.setTextureSize(64, 32);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, 0.0F, 0.0F, 0.0F);
        this.Hips = new ModelRenderer(this, 20, 16);
        this.Hips.addBox(0.0F, 0.0F, 0.0F, 8, 1, 2);
        this.Hips.setRotationPoint(-4.0F, 16.0F, -1.0F);
        this.Hips.setTextureSize(64, 32);
        this.Hips.mirror = true;
        this.setRotation(this.Hips, 0.0F, 0.0F, 0.0F);
        this.RightLeg = new ModelRenderer(this, 50, 0);
        this.RightLeg.addBox(0.0F, 0.0F, -1.0F, 2, 6, 2);
        this.RightLeg.setRotationPoint(-4.0F, 16.0F, 0.0F);
        this.RightLeg.setTextureSize(64, 32);
        this.RightLeg.mirror = true;
        this.setRotation(this.RightLeg, 0.0F, 0.0F, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 42, 18);
        this.LeftLeg.addBox(0.0F, 0.0F, -1.0F, 2, 6, 2);
        this.LeftLeg.setRotationPoint(2.0F, 16.0F, 0.0F);
        this.LeftLeg.setTextureSize(64, 32);
        this.LeftLeg.mirror = true;
        this.setRotation(this.LeftLeg, 0.0F, 0.0F, 0.0F);
        this.LeftFoot = new ModelRenderer(this, 30, 19);
        this.LeftFoot.addBox(0.0F, 6.0F, -3.0F, 2, 2, 4);
        this.LeftFoot.setRotationPoint(2.0F, 16.0F, 0.0F);
        this.LeftFoot.setTextureSize(64, 32);
        this.LeftFoot.mirror = true;
        this.setRotation(this.LeftFoot, 0.0F, 0.0F, 0.0F);
        this.RightFoot = new ModelRenderer(this, 18, 19);
        this.RightFoot.addBox(0.0F, 6.0F, -3.0F, 2, 2, 4);
        this.RightFoot.setRotationPoint(-4.0F, 16.0F, 0.0F);
        this.RightFoot.setTextureSize(64, 32);
        this.RightFoot.mirror = true;
        this.setRotation(this.RightFoot, 0.0F, 0.0F, 0.0F);
        this.LeftArm1 = new ModelRenderer(this, 50, 8);
        this.LeftArm1.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
        this.LeftArm1.setRotationPoint(2.0F, 8.0F, -1.0F);
        this.LeftArm1.setTextureSize(64, 32);
        this.LeftArm1.mirror = true;
        this.setRotation(this.LeftArm1, 0.0F, 0.0F, 0.0F);
        this.RightArm1 = new ModelRenderer(this, 50, 18);
        this.RightArm1.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
        this.RightArm1.setRotationPoint(-4.0F, 8.0F, -1.0F);
        this.RightArm1.setTextureSize(64, 32);
        this.RightArm1.mirror = true;
        this.setRotation(this.RightArm1, 0.0F, 0.0F, 0.0F);
        this.LeftArm2 = new ModelRenderer(this, 0, 16);
        this.LeftArm2.addBox(-1.0F, 0.0F, -1.0F, 8, 1, 2);
        this.LeftArm2.setRotationPoint(3.0F, 7.0F, 0.0F);
        this.LeftArm2.setTextureSize(64, 32);
        this.LeftArm2.mirror = true;
        this.setRotation(this.LeftArm2, 0.0F, 0.0F, 0.0F);
        this.RightArm2 = new ModelRenderer(this, 0, 24);
        this.RightArm2.addBox(-7.0F, 0.0F, -1.0F, 8, 1, 2);
        this.RightArm2.setRotationPoint(-3.0F, 7.0F, 0.0F);
        this.RightArm2.setTextureSize(64, 32);
        this.RightArm2.mirror = true;
        this.setRotation(this.RightArm2, 0.0F, 0.0F, 0.0F);
        this.LeftHand = new ModelRenderer(this, 36, 5);
        this.LeftHand.addBox(6.0F, -1.0F, -1.0F, 1, 1, 2);
        this.LeftHand.setRotationPoint(3.0F, 7.0F, 0.0F);
        this.LeftHand.setTextureSize(64, 32);
        this.LeftHand.mirror = true;
        this.setRotation(this.LeftHand, 0.0F, 0.0F, 0.0F);
        this.RightHand = new ModelRenderer(this, 36, 8);
        this.RightHand.addBox(-7.0F, -1.0F, -1.0F, 1, 1, 2);
        this.RightHand.setRotationPoint(-3.0F, 7.0F, 0.0F);
        this.RightHand.setTextureSize(64, 32);
        this.RightHand.mirror = true;
        this.setRotation(this.RightHand, 0.0F, 0.0F, 0.0F);
        this.Hair = new ModelRenderer(this, 32, 5);
        this.Hair.addBox(-0.5F, -10.0F, -0.5F, 1, 2, 1);
        this.Hair.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hair.setTextureSize(64, 32);
        this.Hair.mirror = true;
        this.setRotation(this.Hair, 0.0F, 0.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Head.render(f5);
        this.Nose.render(f5);
        this.Neck.render(f5);
        this.Hips.render(f5);
        this.RightLeg.render(f5);
        this.LeftLeg.render(f5);
        this.LeftFoot.render(f5);
        this.RightFoot.render(f5);
        this.LeftArm1.render(f5);
        this.RightArm1.render(f5);
        this.LeftArm2.render(f5);
        this.RightArm2.render(f5);
        this.LeftHand.render(f5);
        this.RightHand.render(f5);
        this.Hair.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.Head.rotateAngleY = f3 / 57.295776F;
        this.Head.rotateAngleX = f4 / 57.295776F;
        this.Nose.rotateAngleY = f3 / 57.295776F;
        this.Nose.rotateAngleX = f4 / 57.295776F;
        this.Hair.rotateAngleY = f3 / 57.295776F;
        this.Hair.rotateAngleX = f4 / 57.295776F;
        this.RightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
        this.LeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.0F * f1;
        this.RightFoot.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
        this.LeftFoot.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.0F * f1;
        this.RightArm2.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
        this.LeftArm2.rotateAngleY = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.0F * f1;
        this.RightHand.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
        this.LeftHand.rotateAngleY = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.0F * f1;
    }
}
