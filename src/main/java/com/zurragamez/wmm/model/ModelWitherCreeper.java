package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWitherCreeper extends ModelBase {
   ModelRenderer head1;
   ModelRenderer body;
   ModelRenderer leg1;
   ModelRenderer head2;
   ModelRenderer leg2;

   public ModelWitherCreeper() {
      this.textureWidth = 64;
      this.textureHeight = 32;
      this.head1 = new ModelRenderer(this, 0, 0);
      this.head1.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
      this.head1.setRotationPoint(-6.0F, 6.0F, -1.0F);
      this.head1.setTextureSize(64, 32);
      this.head1.mirror = true;
      this.setRotation(this.head1, 0.0F, 0.0F, 0.0F);
      this.body = new ModelRenderer(this, 40, 16);
      this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 10, 4);
      this.body.setRotationPoint(0.0F, 6.0F, 0.0F);
      this.body.setTextureSize(64, 32);
      this.body.mirror = true;
      this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
      this.leg1 = new ModelRenderer(this, 17, 19);
      this.leg1.addBox(-3.0F, 0.0F, -2.0F, 6, 6, 4);
      this.leg1.setRotationPoint(0.0F, 16.0F, 0.0F);
      this.leg1.setTextureSize(64, 32);
      this.leg1.mirror = true;
      this.setRotation(this.leg1, 0.2974289F, 0.0F, 0.0F);
      this.head2 = new ModelRenderer(this, 0, 0);
      this.head2.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
      this.head2.setRotationPoint(6.0F, 6.0F, -1.0F);
      this.head2.setTextureSize(64, 32);
      this.head2.mirror = true;
      this.setRotation(this.head2, 0.0F, 0.0F, 0.0F);
      this.leg2 = new ModelRenderer(this, 0, 23);
      this.leg2.addBox(-1.0F, 3.0F, -5.0F, 4, 4, 4);
      this.leg2.setRotationPoint(-1.0F, 17.0F, 0.0F);
      this.leg2.setTextureSize(64, 32);
      this.leg2.mirror = true;
      this.setRotation(this.leg2, 1.264073F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5);
      this.head1.render(f5);
      this.body.render(f5);
      this.leg1.render(f5);
      this.head2.render(f5);
      this.leg2.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
      this.head1.rotateAngleY = f5 / 57.295776F;
      this.head1.rotateAngleX = f5 / 57.295776F;
      this.head2.rotateAngleY = f5 / 57.295776F;
      this.head2.rotateAngleX = f5 / 57.295776F;
   }
}
