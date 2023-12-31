package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTrinitope extends ModelBase {

    ModelRenderer Left_Horn_Part_2;
    ModelRenderer Right_Horn_Part_2;
    ModelRenderer Right_Tooth;
    ModelRenderer Left_Tooth;
    ModelRenderer Tail_Part_2;
    ModelRenderer Ball_of_Pain_part_1;
    ModelRenderer Ball_of_Pain_part_2;
    ModelRenderer Head;
    ModelRenderer Body;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Tail;
    ModelRenderer Right_Horn_Part_1;
    ModelRenderer Left_Horn_Part_1;
    ModelRenderer Nose;
    boolean goingForward1 = true;
    boolean goingForward2 = true;

    public ModelTrinitope() {
        this.textureWidth = 128;
        this.textureHeight = 32;
        this.Left_Horn_Part_2 = new ModelRenderer(this, 46, 0);
        this.Left_Horn_Part_2.addBox(-1.0F, -3.0F, -1.0F, 2, 3, 1);
        this.Left_Horn_Part_2.setRotationPoint(1.1F, 8.0F, -7.5F);
        this.Left_Horn_Part_2.setTextureSize(128, 32);
        this.Left_Horn_Part_2.mirror = true;
        this.setRotation(this.Left_Horn_Part_2, -0.669215F, 0.0F, 0.0F);
        this.Right_Horn_Part_2 = new ModelRenderer(this, 46, 0);
        this.Right_Horn_Part_2.addBox(-1.0F, -3.0F, -1.0F, 2, 3, 1);
        this.Right_Horn_Part_2.setRotationPoint(-3.1F, 8.0F, -7.5F);
        this.Right_Horn_Part_2.setTextureSize(128, 32);
        this.Right_Horn_Part_2.mirror = true;
        this.setRotation(this.Right_Horn_Part_2, -0.669215F, 0.0F, 0.0F);
        this.Right_Tooth = new ModelRenderer(this, 0, 17);
        this.Right_Tooth.addBox(-1.0F, 0.0F, -1.0F, 1, 1, 1);
        this.Right_Tooth.setRotationPoint(-2.5F, 15.6F, -12.0F);
        this.Right_Tooth.setTextureSize(128, 32);
        this.Right_Tooth.mirror = true;
        this.setRotation(this.Right_Tooth, 0.0F, 0.0F, 0.0F);
        this.Left_Tooth = new ModelRenderer(this, 0, 17);
        this.Left_Tooth.addBox(0.0F, 0.0F, -1.0F, 1, 1, 1);
        this.Left_Tooth.setRotationPoint(0.5F, 15.6F, -12.0F);
        this.Left_Tooth.setTextureSize(128, 32);
        this.Left_Tooth.mirror = true;
        this.setRotation(this.Left_Tooth, 0.0F, 0.0F, 0.0F);
        this.Tail_Part_2 = new ModelRenderer(this, 45, 6);
        this.Tail_Part_2.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 4);
        this.Tail_Part_2.setRotationPoint(-1.0F, 17.5F, 7.0F);
        this.Tail_Part_2.setTextureSize(128, 32);
        this.Tail_Part_2.mirror = true;
        this.setRotation(this.Tail_Part_2, 0.1115358F, 0.0F, 0.0F);
        this.Ball_of_Pain_part_1 = new ModelRenderer(this, 27, 8);
        this.Ball_of_Pain_part_1.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4);
        this.Ball_of_Pain_part_1.setRotationPoint(-1.0F, 17.0F, 13.0F);
        this.Ball_of_Pain_part_1.setTextureSize(128, 32);
        this.Ball_of_Pain_part_1.mirror = true;
        this.setRotation(this.Ball_of_Pain_part_1, 0.0F, 0.0F, 0.0F);
        this.Ball_of_Pain_part_2 = new ModelRenderer(this, 27, 8);
        this.Ball_of_Pain_part_2.addBox(-2.0F, -2.0F, -1.0F, 4, 4, 4);
        this.Ball_of_Pain_part_2.setRotationPoint(-1.01F, 16.5F, 12.4F);
        this.Ball_of_Pain_part_2.setTextureSize(128, 32);
        this.Ball_of_Pain_part_2.mirror = true;
        this.setRotation(this.Ball_of_Pain_part_2, -0.7807508F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.addBox(-3.0F, -3.0F, -4.5F, 6, 6, 7);
        this.Head.setRotationPoint(-1.0F, 12.5F, -7.0F);
        this.Head.setTextureSize(128, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 17, 16);
        this.Body.addBox(-4.0F, -2.0F, -3.0F, 8, 10, 6);
        this.Body.setRotationPoint(-1.0F, 15.0F, -3.0F);
        this.Body.setTextureSize(128, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 1.570796F, 0.0F, 0.0F);
        this.Leg1 = new ModelRenderer(this, 9, 22);
        this.Leg1.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2);
        this.Leg1.setRotationPoint(-4.5F, 16.0F, 3.0F);
        this.Leg1.setTextureSize(128, 32);
        this.Leg1.mirror = true;
        this.setRotation(this.Leg1, 0.0F, 0.0F, 0.0F);
        this.Leg2 = new ModelRenderer(this, 9, 22);
        this.Leg2.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2);
        this.Leg2.setRotationPoint(2.5F, 16.0F, 3.0F);
        this.Leg2.setTextureSize(128, 32);
        this.Leg2.mirror = true;
        this.setRotation(this.Leg2, 0.0F, 0.0F, 0.0F);
        this.Leg3 = new ModelRenderer(this, 0, 21);
        this.Leg3.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2);
        this.Leg3.setRotationPoint(-3.5F, 15.0F, -4.0F);
        this.Leg3.setTextureSize(128, 32);
        this.Leg3.mirror = true;
        this.setRotation(this.Leg3, 0.0F, 0.0F, 0.0F);
        this.Leg4 = new ModelRenderer(this, 0, 21);
        this.Leg4.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2);
        this.Leg4.setRotationPoint(1.5F, 15.0F, -4.0F);
        this.Leg4.setTextureSize(128, 32);
        this.Leg4.mirror = true;
        this.setRotation(this.Leg4, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 27, 0);
        this.Tail.addBox(-1.0F, 0.0F, -1.0F, 4, 4, 4);
        this.Tail.setRotationPoint(-2.0F, 17.0F, 4.0F);
        this.Tail.setTextureSize(128, 32);
        this.Tail.mirror = true;
        this.setRotation(this.Tail, 1.315962F, 0.0F, 0.0F);
        this.Right_Horn_Part_1 = new ModelRenderer(this, 47, 14);
        this.Right_Horn_Part_1.addBox(-3.0F, -5.0F, 0.0F, 2, 4, 1);
        this.Right_Horn_Part_1.setRotationPoint(-1.1F, 11.5F, -10.0F);
        this.Right_Horn_Part_1.setTextureSize(128, 32);
        this.Right_Horn_Part_1.mirror = true;
        this.setRotation(this.Right_Horn_Part_1, -0.4089647F, 0.0F, 0.0F);
        this.Left_Horn_Part_1 = new ModelRenderer(this, 47, 14);
        this.Left_Horn_Part_1.addBox(1.0F, -5.0F, 0.0F, 2, 4, 1);
        this.Left_Horn_Part_1.setRotationPoint(-0.9F, 11.5F, -10.0F);
        this.Left_Horn_Part_1.setTextureSize(128, 32);
        this.Left_Horn_Part_1.mirror = true;
        this.setRotation(this.Left_Horn_Part_1, -0.4089656F, 0.0F, 0.0F);
        this.Nose = new ModelRenderer(this, 45, 24);
        this.Nose.addBox(-2.0F, 0.0F, -5.0F, 5, 3, 5);
        this.Nose.setRotationPoint(-1.5F, 12.6F, -9.0F);
        this.Nose.setTextureSize(128, 32);
        this.Nose.mirror = true;
        this.setRotation(this.Nose, 0.0F, 0.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.Left_Horn_Part_2.render(f5);
        this.Right_Horn_Part_2.render(f5);
        this.Right_Tooth.render(f5);
        this.Left_Tooth.render(f5);
        this.Tail_Part_2.render(f5);
        this.Ball_of_Pain_part_1.render(f5);
        this.Ball_of_Pain_part_2.render(f5);
        this.Head.render(f5);
        this.Body.render(f5);
        this.Leg1.render(f5);
        this.Leg2.render(f5);
        this.Leg3.render(f5);
        this.Leg4.render(f5);
        this.Tail.render(f5);
        this.Right_Horn_Part_1.render(f5);
        this.Left_Horn_Part_1.render(f5);
        this.Nose.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        this.Leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
        this.Leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
        this.Leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.Right_Tooth.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.Left_Tooth.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
        ModelRenderer var10000 = this.Ball_of_Pain_part_1;
        var10000.rotateAngleX += 10.0F;
        var10000 = this.Ball_of_Pain_part_2;
        var10000.rotateAngleX += 10.0F;
    }
}
