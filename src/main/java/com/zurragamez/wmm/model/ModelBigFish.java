package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBigFish extends ModelBase {
   ModelRenderer Body;
   ModelRenderer Head;
   ModelRenderer Bum;
   ModelRenderer Jaw;
   ModelRenderer Right_Eye;
   ModelRenderer Left_Eye;
   ModelRenderer Fin;
   ModelRenderer Left_Flipper;
   ModelRenderer Right_Flipper;
   ModelRenderer Bum_end;

   public ModelBigFish() {
      this.textureWidth = 64;
      this.textureHeight = 32;
      this.Body = new ModelRenderer(this, 0, 19);
      this.Body.addBox(-2.0F, -2.0F, -6.0F, 4, 4, 6);
      this.Body.setRotationPoint(0.0F, 21.0F, 0.0F);
      this.Body.setTextureSize(64, 32);
      this.Body.mirror = true;
      this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
      this.Head = new ModelRenderer(this, 22, 0);
      this.Head.addBox(-2.0F, -2.0F, -2.0F, 4, 3, 3);
      this.Head.setRotationPoint(0.0F, 21.0F, -6.0F);
      this.Head.setTextureSize(64, 32);
      this.Head.mirror = true;
      this.setRotation(this.Head, 0.1858931F, 0.0F, 0.0F);
      this.Bum = new ModelRenderer(this, 8, 0);
      this.Bum.addBox(-1.0F, 0.0F, 0.0F, 3, 3, 3);
      this.Bum.setRotationPoint(-0.5F, 19.5F, 0.0F);
      this.Bum.setTextureSize(64, 32);
      this.Bum.mirror = true;
      this.setRotation(this.Bum, 0.0F, 0.0F, 0.0F);
      this.Jaw = new ModelRenderer(this, 22, 8);
      this.Jaw.addBox(-2.0F, 0.0F, -3.0F, 4, 1, 2);
      this.Jaw.setRotationPoint(0.0F, 21.0F, -5.0F);
      this.Jaw.setTextureSize(64, 32);
      this.Jaw.mirror = true;
      this.setRotation(this.Jaw, 0.5948578F, 0.0F, 0.0F);
      this.Right_Eye = new ModelRenderer(this, 0, 13);
      this.Right_Eye.addBox(-1.0F, -1.0F, -1.0F, 1, 2, 1);
      this.Right_Eye.setRotationPoint(-1.0F, 21.0F, -7.5F);
      this.Right_Eye.setTextureSize(64, 32);
      this.Right_Eye.mirror = true;
      this.setRotation(this.Right_Eye, 0.2230705F, 0.0F, 0.0F);
      this.Left_Eye = new ModelRenderer(this, 0, 13);
      this.Left_Eye.addBox(0.0F, -1.0F, -1.0F, 1, 2, 1);
      this.Left_Eye.setRotationPoint(1.0F, 21.0F, -7.5F);
      this.Left_Eye.setTextureSize(64, 32);
      this.Left_Eye.mirror = true;
      this.setRotation(this.Left_Eye, 0.2230717F, 0.0F, 0.0F);
      this.Fin = new ModelRenderer(this, 6, 12);
      this.Fin.addBox(-0.5F, -3.0F, -2.0F, 1, 3, 3);
      this.Fin.setRotationPoint(0.0F, 20.0F, -3.333333F);
      this.Fin.setTextureSize(64, 32);
      this.Fin.mirror = true;
      this.setRotation(this.Fin, -0.5948578F, 0.0F, 0.0F);
      this.Left_Flipper = new ModelRenderer(this, 0, 7);
      this.Left_Flipper.addBox(0.0F, 0.0F, -1.0F, 3, 1, 2);
      this.Left_Flipper.setRotationPoint(2.0F, 22.0F, -4.0F);
      this.Left_Flipper.setTextureSize(64, 32);
      this.Left_Flipper.mirror = true;
      this.setRotation(this.Left_Flipper, 0.0F, 0.0F, 0.0F);
      this.Right_Flipper = new ModelRenderer(this, 0, 7);
      this.Right_Flipper.addBox(-3.0F, 0.0F, -1.0F, 3, 1, 2);
      this.Right_Flipper.setRotationPoint(-2.0F, 22.0F, -4.0F);
      this.Right_Flipper.setTextureSize(64, 32);
      this.Right_Flipper.mirror = true;
      this.setRotation(this.Right_Flipper, 0.0F, 0.0F, 0.0F);
      this.Bum_end = new ModelRenderer(this, 0, 0);
      this.Bum_end.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 1);
      this.Bum_end.setRotationPoint(0.0F, 21.0F, 3.0F);
      this.Bum_end.setTextureSize(64, 32);
      this.Bum_end.mirror = true;
      this.setRotation(this.Bum_end, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5);
      this.Body.render(f5);
      this.Head.render(f5);
      this.Bum.render(f5);
      this.Jaw.render(f5);
      this.Right_Eye.render(f5);
      this.Left_Eye.render(f5);
      this.Fin.render(f5);
      this.Left_Flipper.render(f5);
      this.Right_Flipper.render(f5);
      this.Bum_end.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
   }
}
