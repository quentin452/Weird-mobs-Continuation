package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelStickMan extends ModelBase {
   ModelRenderer Head;
   ModelRenderer Left_Arm;
   ModelRenderer Body;
   ModelRenderer Right_Arm;
   ModelRenderer Right_Leg;
   ModelRenderer Left_Leg;

   public ModelStickMan() {
      this.textureWidth = 64;
      this.textureHeight = 32;
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
      this.Head.setRotationPoint(0.0F, 1.0F, 0.0F);
      this.Head.setTextureSize(64, 32);
      this.Head.mirror = true;
      this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
      this.Left_Arm = new ModelRenderer(this, 33, 0);
      this.Left_Arm.addBox(-1.0F, 0.0F, 0.0F, 1, 10, 1);
      this.Left_Arm.setRotationPoint(0.5F, 5.0F, -0.5F);
      this.Left_Arm.setTextureSize(64, 32);
      this.Left_Arm.mirror = true;
      this.setRotation(this.Left_Arm, 0.0F, 0.0F, -0.7853982F);
      this.Body = new ModelRenderer(this, 38, 0);
      this.Body.addBox(-0.5F, 0.0F, -0.5F, 1, 15, 1);
      this.Body.setRotationPoint(0.0F, 1.0F, 0.0F);
      this.Body.setTextureSize(64, 32);
      this.Body.mirror = true;
      this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
      this.Right_Arm = new ModelRenderer(this, 33, 0);
      this.Right_Arm.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1);
      this.Right_Arm.setRotationPoint(-0.5F, 5.0F, -0.5F);
      this.Right_Arm.setTextureSize(64, 32);
      this.Right_Arm.mirror = true;
      this.setRotation(this.Right_Arm, 0.0F, 0.0F, 0.7853982F);
      this.Right_Leg = new ModelRenderer(this, 33, 12);
      this.Right_Leg.addBox(-1.0F, 0.0F, 0.0F, 1, 8, 1);
      this.Right_Leg.setRotationPoint(0.0F, 16.0F, -0.5F);
      this.Right_Leg.setTextureSize(64, 32);
      this.Right_Leg.mirror = true;
      this.setRotation(this.Right_Leg, 0.0F, 0.0F, 0.1570796F);
      this.Left_Leg = new ModelRenderer(this, 33, 12);
      this.Left_Leg.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
      this.Left_Leg.setRotationPoint(0.0F, 16.0F, -0.5F);
      this.Left_Leg.setTextureSize(64, 32);
      this.Left_Leg.mirror = true;
      this.setRotation(this.Left_Leg, 0.0F, 0.0F, -0.1570796F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5);
      this.Head.render(f5);
      this.Left_Arm.render(f5);
      this.Body.render(f5);
      this.Right_Arm.render(f5);
      this.Right_Leg.render(f5);
      this.Left_Leg.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
      this.Head.rotateAngleX = f4 / 57.295776F;
      this.Head.rotateAngleY = f5 / 57.295776F;
      this.Left_Leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      this.Right_Leg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
      this.Left_Arm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
      this.Right_Arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
   }
}
