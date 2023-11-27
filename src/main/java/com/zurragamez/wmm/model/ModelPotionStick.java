package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelPotionStick extends ModelBase {
   ModelRenderer Shape1;

   public ModelPotionStick() {
      this.textureWidth = 32;
      this.textureHeight = 32;
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.addBox(-1.0F, -24.0F, -1.0F, 2, 24, 2);
      this.Shape1.setRotationPoint(0.0F, 24.0F, 0.0F);
      this.Shape1.setTextureSize(32, 32);
      this.Shape1.mirror = true;
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5);
      this.Shape1.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
      this.Shape1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
   }
}
