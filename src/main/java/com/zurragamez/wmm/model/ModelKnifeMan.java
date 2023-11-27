package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelKnifeMan extends ModelBase {
   ModelRenderer Body;
   ModelRenderer Knife_1;
   ModelRenderer Knife_2;
   ModelRenderer Top_1;
   ModelRenderer Top_2;
   ModelRenderer Top_3;
   ModelRenderer Top_4;

   public ModelKnifeMan() {
      this.textureWidth = 64;
      this.textureHeight = 32;
      this.Body = new ModelRenderer(this, 0, 10);
      this.Body.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
      this.Body.setRotationPoint(0.0F, 23.0F, 0.0F);
      this.Body.setTextureSize(64, 32);
      this.Body.mirror = true;
      this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
      this.Knife_1 = new ModelRenderer(this, 14, 11);
      this.Knife_1.addBox(-1.0F, -3.0F, -10.0F, 2, 1, 20);
      this.Knife_1.setRotationPoint(0.0F, 23.0F, 0.0F);
      this.Knife_1.setTextureSize(64, 32);
      this.Knife_1.mirror = true;
      this.setRotation(this.Knife_1, 0.0F, 0.0F, 0.0F);
      this.Knife_2 = new ModelRenderer(this, 0, 0);
      this.Knife_2.addBox(-10.0F, -3.0F, -1.0F, 20, 1, 2);
      this.Knife_2.setRotationPoint(0.0F, 23.0F, 0.0F);
      this.Knife_2.setTextureSize(64, 32);
      this.Knife_2.mirror = true;
      this.setRotation(this.Knife_2, 0.0F, 0.0F, 0.0F);
      this.Top_1 = new ModelRenderer(this, 45, 0);
      this.Top_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4);
      this.Top_1.setRotationPoint(-3.0F, 14.0F, -2.0F);
      this.Top_1.setTextureSize(64, 32);
      this.Top_1.mirror = true;
      this.setRotation(this.Top_1, 0.0F, 0.0F, 0.0F);
      this.Top_2 = new ModelRenderer(this, 45, 0);
      this.Top_2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4);
      this.Top_2.setRotationPoint(2.0F, 14.0F, -2.0F);
      this.Top_2.setTextureSize(64, 32);
      this.Top_2.mirror = true;
      this.setRotation(this.Top_2, 0.0F, 0.0F, 0.0F);
      this.Top_3 = new ModelRenderer(this, 45, 6);
      this.Top_3.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1);
      this.Top_3.setRotationPoint(-2.0F, 14.0F, -3.0F);
      this.Top_3.setTextureSize(64, 32);
      this.Top_3.mirror = true;
      this.setRotation(this.Top_3, 0.0F, 0.0F, 0.0F);
      this.Top_4 = new ModelRenderer(this, 45, 6);
      this.Top_4.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1);
      this.Top_4.setRotationPoint(-2.0F, 14.0F, 2.0F);
      this.Top_4.setTextureSize(64, 32);
      this.Top_4.mirror = true;
      this.setRotation(this.Top_4, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5);
      this.Body.render(f5);
      this.Knife_1.render(f5);
      this.Knife_2.render(f5);
      this.Top_1.render(f5);
      this.Top_2.render(f5);
      this.Top_3.render(f5);
      this.Top_4.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
      this.Knife_1.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.4F * f2;
      this.Knife_2.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.4F * f2;
   }
}
