package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelFatFish extends ModelBase {

    ModelRenderer Head;
    ModelRenderer Back;
    ModelRenderer Back_1;
    ModelRenderer Left_Eye;
    ModelRenderer Right_Eye;
    ModelRenderer Back_2;

    public ModelFatFish() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 4);
        this.Head.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
        this.Back = new ModelRenderer(this, 17, 0);
        this.Back.addBox(-1.0F, -3.0F, 2.0F, 2, 2, 1);
        this.Back.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Back.setTextureSize(64, 32);
        this.Back.mirror = true;
        this.setRotation(this.Back, 0.0F, 0.0F, 0.0F);
        this.Back_1 = new ModelRenderer(this, 24, 0);
        this.Back_1.addBox(0.0F, -0.5F, 0.0F, 0, 1, 1);
        this.Back_1.setRotationPoint(0.0F, 21.0F, 3.0F);
        this.Back_1.setTextureSize(64, 32);
        this.Back_1.mirror = true;
        this.setRotation(this.Back_1, 0.0F, 0.0F, 0.0F);
        this.Left_Eye = new ModelRenderer(this, 0, 9);
        this.Left_Eye.addBox(0.5F, -3.0F, -2.5F, 1, 1, 1);
        this.Left_Eye.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Left_Eye.setTextureSize(64, 32);
        this.Left_Eye.mirror = true;
        this.setRotation(this.Left_Eye, 0.0F, 0.0F, 0.0F);
        this.Right_Eye = new ModelRenderer(this, 0, 9);
        this.Right_Eye.addBox(-1.5F, -3.0F, -2.5F, 1, 1, 1);
        this.Right_Eye.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Right_Eye.setTextureSize(64, 32);
        this.Right_Eye.mirror = true;
        this.setRotation(this.Right_Eye, 0.0F, 0.0F, 0.0F);
        this.Back_2 = new ModelRenderer(this, 27, 0);
        this.Back_2.addBox(0.0F, 0.0F, 1.0F, 0, 1, 1);
        this.Back_2.setRotationPoint(0.0F, 21.0F, 3.0F);
        this.Back_2.setTextureSize(64, 32);
        this.Back_2.mirror = true;
        this.setRotation(this.Back_2, 0.0F, 0.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.Head.render(f5);
        this.Back.render(f5);
        this.Back_1.render(f5);
        this.Left_Eye.render(f5);
        this.Right_Eye.render(f5);
        this.Back_2.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        this.Back_1.rotateAngleY = MathHelper.cos(f * 0.9662F + 3.1415927F) * 4.4F * f1;
        this.Back_2.rotateAngleY = MathHelper.cos(f * 0.9662F + 3.1415927F) * 4.4F * f1;
    }
}
