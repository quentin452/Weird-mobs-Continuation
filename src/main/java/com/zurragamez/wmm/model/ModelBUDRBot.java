package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBUDRBot extends ModelBase {
   ModelRenderer Right_Leg;
   ModelRenderer Left_Leg;
   ModelRenderer Body;
   ModelRenderer Head;
   ModelRenderer Right_Arm;
   ModelRenderer Left_Arm;
   ModelRenderer Gem;
   ModelRenderer Right_Shade;
   ModelRenderer Left_Shade;
   ModelRenderer Middle_Shade;
   ModelRenderer Antenna;

   public ModelBUDRBot() {
      this.textureWidth = 64;
      this.textureHeight = 32;
      this.Right_Leg = new ModelRenderer(this, 6, 9);
      this.Right_Leg.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
      this.Right_Leg.setRotationPoint(-1.0F, 20.0F, -0.5F);
      this.Right_Leg.setTextureSize(64, 32);
      this.Right_Leg.mirror = true;
      this.setRotation(this.Right_Leg, 0.0F, 0.0F, 0.0F);
      this.Left_Leg = new ModelRenderer(this, 6, 9);
      this.Left_Leg.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
      this.Left_Leg.setRotationPoint(1.0F, 20.0F, -0.5F);
      this.Left_Leg.setTextureSize(64, 32);
      this.Left_Leg.mirror = true;
      this.setRotation(this.Left_Leg, 0.0F, 0.0F, 0.0F);
      this.Body = new ModelRenderer(this, 20, 0);
      this.Body.addBox(-2.0F, -5.0F, -2.0F, 4, 5, 3);
      this.Body.setRotationPoint(0.0F, 20.0F, 0.0F);
      this.Body.setTextureSize(64, 32);
      this.Body.mirror = true;
      this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
      this.Head = new ModelRenderer(this, 0, 0);
      this.Head.addBox(-2.5F, -5.0F, -2.5F, 5, 5, 5);
      this.Head.setRotationPoint(0.0F, 15.0F, -0.5F);
      this.Head.setTextureSize(64, 32);
      this.Head.mirror = true;
      this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
      this.Right_Arm = new ModelRenderer(this, 0, 18);
      this.Right_Arm.addBox(-1.0F, -1.0F, -1.0F, 1, 5, 2);
      this.Right_Arm.setRotationPoint(-2.0F, 16.0F, 0.0F);
      this.Right_Arm.setTextureSize(64, 32);
      this.Right_Arm.mirror = true;
      this.setRotation(this.Right_Arm, 0.0F, 0.0F, 0.0F);
      this.Left_Arm = new ModelRenderer(this, 0, 18);
      this.Left_Arm.addBox(0.0F, -1.0F, -1.0F, 1, 5, 2);
      this.Left_Arm.setRotationPoint(2.0F, 16.0F, 0.0F);
      this.Left_Arm.setTextureSize(64, 32);
      this.Left_Arm.mirror = true;
      this.setRotation(this.Left_Arm, 0.0F, 0.0F, 0.0F);
      this.Gem = new ModelRenderer(this, 15, 11);
      this.Gem.addBox(-1.0F, -1.0F, -0.5F, 2, 2, 1);
      this.Gem.setRotationPoint(0.0F, 17.0F, -2.0F);
      this.Gem.setTextureSize(64, 32);
      this.Gem.mirror = true;
      this.setRotation(this.Gem, 0.0F, 0.0F, 0.0F);
      this.Right_Shade = new ModelRenderer(this, 10, 15);
      this.Right_Shade.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 1);
      this.Right_Shade.setRotationPoint(-1.5F, 12.0F, -3.0F);
      this.Right_Shade.setTextureSize(64, 32);
      this.Right_Shade.mirror = true;
      this.setRotation(this.Right_Shade, 0.0F, 0.0F, 0.0F);
      this.Left_Shade = new ModelRenderer(this, 4, 15);
      this.Left_Shade.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 1);
      this.Left_Shade.setRotationPoint(1.5F, 12.0F, -3.0F);
      this.Left_Shade.setTextureSize(64, 32);
      this.Left_Shade.mirror = true;
      this.setRotation(this.Left_Shade, 0.0F, 0.0F, 0.0F);
      this.Middle_Shade = new ModelRenderer(this, 16, 15);
      this.Middle_Shade.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Middle_Shade.setRotationPoint(-0.5F, 11.0F, -4.0F);
      this.Middle_Shade.setTextureSize(64, 32);
      this.Middle_Shade.mirror = true;
      this.setRotation(this.Middle_Shade, 0.0F, 0.0F, 0.0F);
      this.Antenna = new ModelRenderer(this, 0, 15);
      this.Antenna.addBox(-0.5F, -2.0F, 0.0F, 1, 2, 1);
      this.Antenna.setRotationPoint(-2.0F, 10.0F, 0.0F);
      this.Antenna.setTextureSize(64, 32);
      this.Antenna.mirror = true;
      this.setRotation(this.Antenna, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5);
      this.Right_Leg.render(f5);
      this.Left_Leg.render(f5);
      this.Body.render(f5);
      this.Head.render(f5);
      this.Right_Arm.render(f5);
      this.Left_Arm.render(f5);
      this.Gem.render(f5);
      this.Right_Shade.render(f5);
      this.Left_Shade.render(f5);
      this.Middle_Shade.render(f5);
      this.Antenna.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
      this.Left_Leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      this.Right_Leg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
      this.Left_Arm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
      this.Right_Arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
   }
}
