package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTerrorTrickster extends ModelBase {

    ModelRenderer Body;
    ModelRenderer Right_Foot;
    ModelRenderer Left_Foot;
    ModelRenderer Right_Arm;
    ModelRenderer Left_Arm;

    public ModelTerrorTrickster() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.addBox(-8.0F, -8.0F, -8.0F, 16, 16, 16);
        this.Body.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.Body.setTextureSize(128, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
        this.Right_Foot = new ModelRenderer(this, 18, 33);
        this.Right_Foot.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4);
        this.Right_Foot.setRotationPoint(-4.0F, 16.0F, 0.0F);
        this.Right_Foot.setTextureSize(128, 64);
        this.Right_Foot.mirror = true;
        this.setRotation(this.Right_Foot, 0.0F, 0.0F, 0.0F);
        this.Left_Foot = new ModelRenderer(this, 18, 33);
        this.Left_Foot.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4);
        this.Left_Foot.setRotationPoint(3.0F, 16.0F, 0.0F);
        this.Left_Foot.setTextureSize(128, 64);
        this.Left_Foot.mirror = true;
        this.setRotation(this.Left_Foot, 0.0F, 0.0F, 0.0F);
        this.Right_Arm = new ModelRenderer(this, 0, 33);
        this.Right_Arm.addBox(-4.0F, -1.0F, -2.0F, 4, 16, 4);
        this.Right_Arm.setRotationPoint(-8.0F, 6.0F, 0.0F);
        this.Right_Arm.setTextureSize(128, 64);
        this.Right_Arm.mirror = true;
        this.setRotation(this.Right_Arm, 0.0F, 0.0F, 0.0F);
        this.Left_Arm = new ModelRenderer(this, 0, 33);
        this.Left_Arm.addBox(0.0F, -1.0F, -2.0F, 4, 16, 4);
        this.Left_Arm.setRotationPoint(8.0F, 6.0F, 0.0F);
        this.Left_Arm.setTextureSize(128, 64);
        this.Left_Arm.mirror = true;
        this.setRotation(this.Left_Arm, 0.0F, 0.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.Body.render(f5);
        this.Right_Foot.render(f5);
        this.Left_Foot.render(f5);
        this.Right_Arm.render(f5);
        this.Left_Arm.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        this.Right_Foot.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
        this.Left_Foot.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.0F * f1;
        this.Left_Arm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
        this.Right_Arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    }
}
