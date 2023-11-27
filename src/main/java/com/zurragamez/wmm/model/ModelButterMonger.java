package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelButterMonger extends ModelBase {

    ModelRenderer HEAD;
    ModelRenderer BODY;
    ModelRenderer TEETH;
    ModelRenderer UPPER_LEG_LEFT;
    ModelRenderer UPPER_LEG_RIGHT;
    ModelRenderer LOWER_LEG_LEFT;
    ModelRenderer LOWER_LEG_RIGHT;
    ModelRenderer RIGHT_ARM;
    ModelRenderer LEFT_ARM;

    public ModelButterMonger() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.HEAD = new ModelRenderer(this, 32, 0);
        this.HEAD.addBox(0.0F, 0.0F, 0.0F, 8, 6, 8);
        this.HEAD.setRotationPoint(-4.0F, -1.0F, -10.0F);
        this.HEAD.setTextureSize(128, 128);
        this.HEAD.mirror = true;
        this.setRotation(this.HEAD, 0.0F, 0.0F, 0.0F);
        this.BODY = new ModelRenderer(this, 39, 15);
        this.BODY.addBox(0.0F, 0.0F, 0.0F, 8, 12, 5);
        this.BODY.setRotationPoint(-4.0F, 4.0F, -5.0F);
        this.BODY.setTextureSize(128, 128);
        this.BODY.mirror = true;
        this.setRotation(this.BODY, 0.4833219F, 0.0F, 0.0F);
        this.TEETH = new ModelRenderer(this, 0, 14);
        this.TEETH.addBox(0.0F, 0.0F, 0.0F, 8, 2, 1);
        this.TEETH.setRotationPoint(-4.0F, 5.0F, -11.0F);
        this.TEETH.setTextureSize(128, 128);
        this.TEETH.mirror = true;
        this.setRotation(this.TEETH, 0.0F, 0.0F, 0.0F);
        this.UPPER_LEG_LEFT = new ModelRenderer(this, 0, 0);
        this.UPPER_LEG_LEFT.addBox(0.0F, 0.0F, 0.0F, 3, 5, 5);
        this.UPPER_LEG_LEFT.setRotationPoint(4.0F, 9.0F, -1.0F);
        this.UPPER_LEG_LEFT.setTextureSize(128, 128);
        this.UPPER_LEG_LEFT.mirror = true;
        this.setRotation(this.UPPER_LEG_LEFT, 0.0F, 0.0F, 0.0F);
        this.UPPER_LEG_RIGHT = new ModelRenderer(this, 0, 35);
        this.UPPER_LEG_RIGHT.addBox(0.0F, 0.0F, 0.0F, 3, 5, 5);
        this.UPPER_LEG_RIGHT.setRotationPoint(-7.0F, 9.0F, -1.0F);
        this.UPPER_LEG_RIGHT.setTextureSize(128, 128);
        this.UPPER_LEG_RIGHT.mirror = true;
        this.setRotation(this.UPPER_LEG_RIGHT, 0.0F, 0.0F, 0.0F);
        this.LOWER_LEG_LEFT = new ModelRenderer(this, 27, 18);
        this.LOWER_LEG_LEFT.addBox(0.0F, 4.0F, 1.0F, 3, 11, 3);
        this.LOWER_LEG_LEFT.setRotationPoint(4.0F, 9.0F, -1.0F);
        this.LOWER_LEG_LEFT.setTextureSize(128, 128);
        this.LOWER_LEG_LEFT.mirror = true;
        this.setRotation(this.LOWER_LEG_LEFT, 0.0F, 0.0F, 0.0F);
        this.LOWER_LEG_RIGHT = new ModelRenderer(this, 20, 0);
        this.LOWER_LEG_RIGHT.addBox(0.0F, 4.0F, 1.0F, 3, 11, 3);
        this.LOWER_LEG_RIGHT.setRotationPoint(-7.0F, 9.0F, -1.0F);
        this.LOWER_LEG_RIGHT.setTextureSize(128, 128);
        this.LOWER_LEG_RIGHT.mirror = true;
        this.setRotation(this.LOWER_LEG_RIGHT, 0.0F, 0.0F, 0.0F);
        this.RIGHT_ARM = new ModelRenderer(this, 0, 17);
        this.RIGHT_ARM.addBox(0.0F, 0.0F, -3.0F, 3, 12, 3);
        this.RIGHT_ARM.setRotationPoint(-3.9F, 6.0F, 2.0F);
        this.RIGHT_ARM.setTextureSize(128, 128);
        this.RIGHT_ARM.mirror = true;
        this.setRotation(this.RIGHT_ARM, -0.3739991F, 0.0F, 0.0F);
        this.LEFT_ARM = new ModelRenderer(this, 12, 17);
        this.LEFT_ARM.addBox(0.0F, 0.0F, -3.0F, 3, 12, 3);
        this.LEFT_ARM.setRotationPoint(0.9F, 6.0F, 2.0F);
        this.LEFT_ARM.setTextureSize(128, 128);
        this.LEFT_ARM.mirror = true;
        this.setRotation(this.LEFT_ARM, -0.3739991F, 0.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.HEAD.render(f5);
        this.BODY.render(f5);
        this.TEETH.render(f5);
        this.UPPER_LEG_LEFT.render(f5);
        this.UPPER_LEG_RIGHT.render(f5);
        this.LOWER_LEG_LEFT.render(f5);
        this.LOWER_LEG_RIGHT.render(f5);
        this.RIGHT_ARM.render(f5);
        this.LEFT_ARM.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        this.LOWER_LEG_LEFT.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.UPPER_LEG_LEFT.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.LOWER_LEG_RIGHT.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
        this.UPPER_LEG_RIGHT.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
    }
}
