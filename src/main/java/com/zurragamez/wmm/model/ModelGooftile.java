package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGooftile extends ModelBase {
   ModelRenderer Right_Foot;
   ModelRenderer Left_Foot;
   ModelRenderer Body;
   ModelRenderer Left_Arm;
   ModelRenderer Right_Arm;
   ModelRenderer Kneck;
   ModelRenderer Head;
   ModelRenderer Teeth;
   ModelRenderer Tail;

   public ModelGooftile() {
      this.textureWidth = 128;
      this.textureHeight = 64;
      this.Right_Foot = new ModelRenderer(this, 0, 20);
      this.Right_Foot.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4);
      this.Right_Foot.setRotationPoint(-3.0F, 16.0F, 3.0F);
      this.Right_Foot.setTextureSize(128, 64);
      this.Right_Foot.mirror = true;
      this.setRotation(this.Right_Foot, 0.0F, 0.0F, 0.0F);
      this.Left_Foot = new ModelRenderer(this, 0, 20);
      this.Left_Foot.addBox(-2.0F, 0.0F, -2.0F, 4, 8, 4);
      this.Left_Foot.setRotationPoint(3.0F, 16.0F, 3.0F);
      this.Left_Foot.setTextureSize(128, 64);
      this.Left_Foot.mirror = true;
      this.setRotation(this.Left_Foot, 0.0F, 0.0F, 0.0F);
      this.Body = new ModelRenderer(this, 24, 0);
      this.Body.addBox(-5.0F, -5.0F, -5.0F, 10, 10, 10);
      this.Body.setRotationPoint(0.0F, 11.0F, 1.0F);
      this.Body.setTextureSize(128, 64);
      this.Body.mirror = true;
      this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
      this.Left_Arm = new ModelRenderer(this, 0, 0);
      this.Left_Arm.addBox(-2.0F, -2.0F, -3.0F, 4, 8, 3);
      this.Left_Arm.setRotationPoint(3.0F, 15.0F, -4.0F);
      this.Left_Arm.setTextureSize(128, 64);
      this.Left_Arm.mirror = true;
      this.setRotation(this.Left_Arm, 0.0F, 0.0F, 0.0F);
      this.Right_Arm = new ModelRenderer(this, 0, 0);
      this.Right_Arm.addBox(-2.0F, -1.0F, -3.0F, 4, 8, 3);
      this.Right_Arm.setRotationPoint(-3.0F, 14.0F, -4.0F);
      this.Right_Arm.setTextureSize(128, 64);
      this.Right_Arm.mirror = true;
      this.setRotation(this.Right_Arm, 0.0F, 0.0F, 0.0F);
      this.Kneck = new ModelRenderer(this, 0, 47);
      this.Kneck.addBox(-2.0F, -8.0F, -2.0F, 4, 8, 4);
      this.Kneck.setRotationPoint(0.0F, 10.0F, -2.0F);
      this.Kneck.setTextureSize(128, 64);
      this.Kneck.mirror = true;
      this.setRotation(this.Kneck, 0.8551081F, 0.0F, 0.0F);
      this.Head = new ModelRenderer(this, 30, 20);
      this.Head.addBox(-4.0F, -4.0F, -9.0F, 8, 8, 9);
      this.Head.setRotationPoint(0.0F, 4.0F, -6.0F);
      this.Head.setTextureSize(128, 64);
      this.Head.mirror = true;
      this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
      this.Teeth = new ModelRenderer(this, 0, 14);
      this.Teeth.addBox(-4.0F, -1.0F, -1.0F, 8, 3, 1);
      this.Teeth.setRotationPoint(0.0F, 7.0F, -15.0F);
      this.Teeth.setTextureSize(128, 64);
      this.Teeth.mirror = true;
      this.setRotation(this.Teeth, 0.0F, 0.0F, 0.0F);
      this.Tail = new ModelRenderer(this, 0, 33);
      this.Tail.addBox(-2.0F, -3.0F, 0.0F, 6, 6, 6);
      this.Tail.setRotationPoint(0.0F, 10.0F, 6.0F);
      this.Tail.setTextureSize(128, 64);
      this.Tail.mirror = true;
      this.setRotation(this.Tail, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5);
      this.Right_Foot.render(f5);
      this.Left_Foot.render(f5);
      this.Body.render(f5);
      this.Left_Arm.render(f5);
      this.Right_Arm.render(f5);
      this.Kneck.render(f5);
      this.Head.render(f5);
      this.Teeth.render(f5);
      this.Tail.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
      this.Left_Foot.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      this.Left_Arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      this.Right_Foot.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
      this.Right_Arm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
   }
}
