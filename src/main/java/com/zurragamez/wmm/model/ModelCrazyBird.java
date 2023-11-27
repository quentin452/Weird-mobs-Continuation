package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCrazyBird extends ModelBase {
   ModelRenderer Head;
   ModelRenderer Body;
   ModelRenderer Left_Leg;
   ModelRenderer Right_Leg;
   ModelRenderer Back_Wing;
   ModelRenderer Nose;
   ModelRenderer Left_foot;
   ModelRenderer Right_foot;
   ModelRenderer Top_Wing;

   public ModelCrazyBird() {
      this.textureWidth = 64;
      this.textureHeight = 64;
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.addBox(-3.0F, -12.0F, -3.0F, 6, 12, 6);
      this.Head.setRotationPoint(0.0F, 10.0F, -4.0F);
      this.Head.setTextureSize(64, 64);
      this.Head.mirror = true;
      this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
      this.Body = new ModelRenderer(this, 25, 0);
      this.Body.addBox(-2.0F, 0.0F, -1.0F, 4, 5, 13);
      this.Body.setRotationPoint(0.0F, 10.0F, -4.0F);
      this.Body.setTextureSize(64, 64);
      this.Body.mirror = true;
      this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
      this.Left_Leg = new ModelRenderer(this, 0, 19);
      this.Left_Leg.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1);
      this.Left_Leg.setRotationPoint(2.0F, 14.0F, 1.0F);
      this.Left_Leg.setTextureSize(64, 64);
      this.Left_Leg.mirror = true;
      this.setRotation(this.Left_Leg, 0.0F, 0.0F, 0.0F);
      this.Right_Leg = new ModelRenderer(this, 0, 19);
      this.Right_Leg.addBox(-1.0F, 0.0F, 0.0F, 1, 10, 1);
      this.Right_Leg.setRotationPoint(-2.0F, 14.0F, 1.0F);
      this.Right_Leg.setTextureSize(64, 64);
      this.Right_Leg.mirror = true;
      this.setRotation(this.Right_Leg, 0.0F, 0.0F, 0.0F);
      this.Back_Wing = new ModelRenderer(this, 5, 19);
      this.Back_Wing.addBox(-3.0F, 0.0F, 0.0F, 6, 0, 4);
      this.Back_Wing.setRotationPoint(0.0F, 15.0F, 8.0F);
      this.Back_Wing.setTextureSize(64, 64);
      this.Back_Wing.mirror = true;
      this.setRotation(this.Back_Wing, -0.7853982F, 0.0F, 0.0F);
      this.Nose = new ModelRenderer(this, 26, 19);
      this.Nose.addBox(-1.0F, -6.0F, -5.0F, 2, 9, 2);
      this.Nose.setRotationPoint(0.0F, 10.0F, -4.0F);
      this.Nose.setTextureSize(64, 64);
      this.Nose.mirror = true;
      this.setRotation(this.Nose, 0.0F, 0.0F, 0.0F);
      this.Left_foot = new ModelRenderer(this, 9, 24);
      this.Left_foot.addBox(-1.0F, 10.0F, -2.0F, 3, 0, 3);
      this.Left_foot.setRotationPoint(2.0F, 14.0F, 1.0F);
      this.Left_foot.setTextureSize(64, 64);
      this.Left_foot.mirror = true;
      this.setRotation(this.Left_foot, 0.0F, 0.0F, 0.0F);
      this.Right_foot = new ModelRenderer(this, 9, 24);
      this.Right_foot.addBox(-2.0F, 10.0F, -2.0F, 3, 0, 3);
      this.Right_foot.setRotationPoint(-2.0F, 14.0F, 1.0F);
      this.Right_foot.setTextureSize(64, 64);
      this.Right_foot.mirror = true;
      this.setRotation(this.Right_foot, 0.0F, 0.0F, 0.0F);
      this.Top_Wing = new ModelRenderer(this, 37, 19);
      this.Top_Wing.addBox(0.0F, -3.0F, -3.0F, 0, 3, 7);
      this.Top_Wing.setRotationPoint(0.0F, 10.0F, 3.0F);
      this.Top_Wing.setTextureSize(64, 64);
      this.Top_Wing.mirror = true;
      this.setRotation(this.Top_Wing, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5);
      this.Head.render(f5);
      this.Body.render(f5);
      this.Left_Leg.render(f5);
      this.Right_Leg.render(f5);
      this.Back_Wing.render(f5);
      this.Nose.render(f5);
      this.Left_foot.render(f5);
      this.Right_foot.render(f5);
      this.Top_Wing.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
      this.Left_Leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      this.Right_Leg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
      this.Left_foot.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      this.Right_foot.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
      this.Head.rotateAngleY = f5 / 57.295776F;
      this.Head.rotateAngleX = f5 / 57.295776F;
      this.Nose.rotateAngleY = f5 / 57.295776F;
      this.Nose.rotateAngleX = f5 / 57.295776F;
      this.Back_Wing.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.5F * f1;
      this.Top_Wing.rotateAngleZ = MathHelper.cos(f * 0.3662F) * 0.5F * f1;
   }
}
