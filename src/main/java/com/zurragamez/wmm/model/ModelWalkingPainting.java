package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelWalkingPainting extends ModelBase {

    ModelRenderer Body;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    ModelRenderer TopFrame;
    ModelRenderer BottomFrame;
    ModelRenderer RightFrame;
    ModelRenderer LeftFrame;

    public ModelWalkingPainting() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.addBox(-5.0F, -16.0F, 0.0F, 10, 16, 0);
        this.Body.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
        this.RightLeg = new ModelRenderer(this, 24, 0);
        this.RightLeg.addBox(0.0F, 0.0F, -0.5F, 1, 3, 1);
        this.RightLeg.setRotationPoint(-5.0F, 21.0F, 0.0F);
        this.RightLeg.setTextureSize(64, 32);
        this.RightLeg.mirror = true;
        this.setRotation(this.RightLeg, 0.0F, 0.0F, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 24, 0);
        this.LeftLeg.addBox(0.0F, 0.0F, -0.5F, 1, 3, 1);
        this.LeftLeg.setRotationPoint(4.0F, 21.0F, 0.0F);
        this.LeftLeg.setTextureSize(64, 32);
        this.LeftLeg.mirror = true;
        this.setRotation(this.LeftLeg, 0.0F, 0.0F, 0.0F);
        this.TopFrame = new ModelRenderer(this, 0, 19);
        this.TopFrame.addBox(-5.0F, -17.0F, -0.5F, 10, 1, 1);
        this.TopFrame.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.TopFrame.setTextureSize(64, 32);
        this.TopFrame.mirror = true;
        this.setRotation(this.TopFrame, 0.0F, 0.0F, 0.0F);
        this.BottomFrame = new ModelRenderer(this, 0, 19);
        this.BottomFrame.addBox(-5.0F, 0.0F, -0.5F, 10, 1, 1);
        this.BottomFrame.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.BottomFrame.setTextureSize(64, 32);
        this.BottomFrame.mirror = true;
        this.setRotation(this.BottomFrame, 0.0F, 0.0F, 0.0F);
        this.RightFrame = new ModelRenderer(this, 20, 0);
        this.RightFrame.addBox(-6.0F, -17.0F, -0.5F, 1, 18, 1);
        this.RightFrame.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.RightFrame.setTextureSize(64, 32);
        this.RightFrame.mirror = true;
        this.setRotation(this.RightFrame, 0.0F, 0.0F, 0.0F);
        this.LeftFrame = new ModelRenderer(this, 20, 0);
        this.LeftFrame.addBox(5.0F, -17.0F, -0.5F, 1, 18, 1);
        this.LeftFrame.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.LeftFrame.setTextureSize(64, 32);
        this.LeftFrame.mirror = true;
        this.setRotation(this.LeftFrame, 0.0F, 0.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.Body.render(f5);
        this.RightLeg.render(f5);
        this.LeftLeg.render(f5);
        this.TopFrame.render(f5);
        this.BottomFrame.render(f5);
        this.RightFrame.render(f5);
        this.LeftFrame.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        this.RightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.LeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
    }
}
