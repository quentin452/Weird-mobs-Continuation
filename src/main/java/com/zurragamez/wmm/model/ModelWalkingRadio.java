package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelWalkingRadio extends ModelBase {
   ModelRenderer Body;
   ModelRenderer Right_Leg;
   ModelRenderer Left_Leg;
   ModelRenderer Left_Foot;
   ModelRenderer Right_Foot;
   ModelRenderer Antenna;
   ModelRenderer Button;

   public ModelWalkingRadio() {
      this.textureWidth = 64;
      this.textureHeight = 64;
      this.Body = new ModelRenderer(this, 0, 0);
      this.Body.addBox(0.0F, 0.0F, 0.0F, 10, 6, 5);
      this.Body.setRotationPoint(-5.0F, 15.0F, -3.0F);
      this.Body.setTextureSize(64, 64);
      this.Body.mirror = true;
      this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
      this.Right_Leg = new ModelRenderer(this, 32, 0);
      this.Right_Leg.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
      this.Right_Leg.setRotationPoint(2.0F, 21.0F, -1.0F);
      this.Right_Leg.setTextureSize(64, 64);
      this.Right_Leg.mirror = true;
      this.setRotation(this.Right_Leg, 0.0F, 0.0F, 0.0F);
      this.Left_Leg = new ModelRenderer(this, 32, 0);
      this.Left_Leg.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
      this.Left_Leg.setRotationPoint(-3.0F, 21.0F, -1.0F);
      this.Left_Leg.setTextureSize(64, 64);
      this.Left_Leg.mirror = true;
      this.setRotation(this.Left_Leg, 0.0F, 0.0F, 0.0F);
      this.Left_Foot = new ModelRenderer(this, 38, 0);
      this.Left_Foot.addBox(0.0F, 2.0F, -1.0F, 1, 1, 2);
      this.Left_Foot.setRotationPoint(-3.0F, 21.0F, -1.0F);
      this.Left_Foot.setTextureSize(64, 64);
      this.Left_Foot.mirror = true;
      this.setRotation(this.Left_Foot, 0.0F, 0.0F, 0.0F);
      this.Right_Foot = new ModelRenderer(this, 38, 0);
      this.Right_Foot.addBox(0.0F, 2.0F, -1.0F, 1, 1, 2);
      this.Right_Foot.setRotationPoint(2.0F, 21.0F, -1.0F);
      this.Right_Foot.setTextureSize(64, 64);
      this.Right_Foot.mirror = true;
      this.setRotation(this.Right_Foot, 0.0F, 0.0F, 0.0F);
      this.Antenna = new ModelRenderer(this, 8, 13);
      this.Antenna.addBox(0.0F, -7.0F, 0.0F, 1, 7, 1);
      this.Antenna.setRotationPoint(-4.0F, 15.0F, -1.0F);
      this.Antenna.setTextureSize(64, 64);
      this.Antenna.mirror = true;
      this.setRotation(this.Antenna, 0.0F, 0.0F, 0.0F);
      this.Button = new ModelRenderer(this, 0, 13);
      this.Button.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 1);
      this.Button.setRotationPoint(3.0F, 18.0F, -4.0F);
      this.Button.setTextureSize(64, 64);
      this.Button.mirror = true;
      this.setRotation(this.Button, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5);
      this.Body.render(f5);
      this.Right_Leg.render(f5);
      this.Left_Leg.render(f5);
      this.Left_Foot.render(f5);
      this.Right_Foot.render(f5);
      this.Antenna.render(f5);
      this.Button.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
      this.Left_Leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      this.Right_Leg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
      this.Left_Foot.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      this.Right_Foot.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
      this.Button.rotateAngleZ = MathHelper.cos(f * 0.6662F) * 0.4F * f2;
   }
}
