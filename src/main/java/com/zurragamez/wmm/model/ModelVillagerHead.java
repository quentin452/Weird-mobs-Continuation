package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelVillagerHead extends ModelBase {

    ModelRenderer head_top;
    ModelRenderer body;
    ModelRenderer nose_top;
    ModelRenderer head_bot;
    ModelRenderer axilla_right;
    ModelRenderer axilla_left;
    ModelRenderer right_arm;
    ModelRenderer left_arm;
    ModelRenderer nose_bot;

    public ModelVillagerHead() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.head_top = new ModelRenderer(this, 0, 0);
        this.head_top.addBox(-4.0F, -14.0F, -4.0F, 8, 10, 8);
        this.head_top.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.head_top.setTextureSize(128, 128);
        this.head_top.mirror = true;
        this.setRotation(this.head_top, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 19);
        this.body.addBox(-4.0F, -4.0F, -3.0F, 8, 12, 6);
        this.body.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.body.setTextureSize(128, 128);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
        this.nose_top = new ModelRenderer(this, 47, 26);
        this.nose_top.addBox(-1.0F, -7.0F, -6.0F, 2, 4, 2);
        this.nose_top.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.nose_top.setTextureSize(128, 128);
        this.nose_top.mirror = true;
        this.setRotation(this.nose_top, 0.0F, 0.0F, 0.0F);
        this.head_bot = new ModelRenderer(this, 32, 0);
        this.head_bot.addBox(-4.0F, 8.0F, -4.0F, 8, 10, 8);
        this.head_bot.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.head_bot.setTextureSize(128, 128);
        this.head_bot.mirror = true;
        this.setRotation(this.head_bot, 0.0F, 0.0F, 0.0F);
        this.axilla_right = new ModelRenderer(this, 0, 38);
        this.axilla_right.addBox(-1.0F, -2.0F, -2.0F, 1, 4, 4);
        this.axilla_right.setRotationPoint(-4.0F, 1.0F, 0.0F);
        this.axilla_right.setTextureSize(128, 128);
        this.axilla_right.mirror = true;
        this.setRotation(this.axilla_right, 0.0F, 0.0F, 0.0F);
        this.axilla_left = new ModelRenderer(this, 11, 38);
        this.axilla_left.addBox(0.0F, -2.0F, -2.0F, 1, 4, 4);
        this.axilla_left.setRotationPoint(4.0F, 1.0F, 0.0F);
        this.axilla_left.setTextureSize(128, 128);
        this.axilla_left.mirror = true;
        this.setRotation(this.axilla_left, 0.0F, 0.0F, 0.0F);
        this.right_arm = new ModelRenderer(this, 29, 19);
        this.right_arm.addBox(-2.0F, -1.0F, -1.0F, 2, 24, 2);
        this.right_arm.setRotationPoint(-5.0F, 1.0F, 0.0F);
        this.right_arm.setTextureSize(128, 128);
        this.right_arm.mirror = true;
        this.setRotation(this.right_arm, 0.0F, 0.0F, 0.0F);
        this.left_arm = new ModelRenderer(this, 38, 19);
        this.left_arm.addBox(0.0F, -1.0F, -1.0F, 2, 24, 2);
        this.left_arm.setRotationPoint(5.0F, 1.0F, 0.0F);
        this.left_arm.setTextureSize(128, 128);
        this.left_arm.mirror = true;
        this.setRotation(this.left_arm, 0.0F, 0.0F, 0.0F);
        this.nose_bot = new ModelRenderer(this, 47, 26);
        this.nose_bot.addBox(-1.0F, 11.0F, -6.0F, 2, 4, 2);
        this.nose_bot.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.nose_bot.setTextureSize(128, 128);
        this.nose_bot.mirror = true;
        this.setRotation(this.nose_bot, 0.0F, 0.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.head_top.render(f5);
        this.body.render(f5);
        this.nose_top.render(f5);
        this.head_bot.render(f5);
        this.axilla_right.render(f5);
        this.axilla_left.render(f5);
        this.right_arm.render(f5);
        this.left_arm.render(f5);
        this.nose_bot.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.body.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
        this.head_top.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
        this.nose_top.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
        this.head_bot.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
        this.nose_bot.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
        this.axilla_right.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
        this.axilla_left.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
    }
}
