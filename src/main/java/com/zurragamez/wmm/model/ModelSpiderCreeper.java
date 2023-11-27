package com.zurragamez.wmm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSpiderCreeper extends ModelBase {
   ModelRenderer spider_head;
   ModelRenderer legs_body;
   ModelRenderer huge_body;
   ModelRenderer Leg8;
   ModelRenderer Leg6;
   ModelRenderer Leg4;
   ModelRenderer Leg2;
   ModelRenderer Leg7;
   ModelRenderer Leg5;
   ModelRenderer Leg3;
   ModelRenderer Leg1;
   ModelRenderer creeper_head_trot;
   ModelRenderer crep_back_head;
   ModelRenderer pan_crep;
   ModelRenderer chin_crpp;
   ModelRenderer chin_crep_l;
   ModelRenderer nose_crep;
   ModelRenderer teht_crep;
   ModelRenderer diveder_aye_crep_l;
   ModelRenderer diveder_aye_crep;
   ModelRenderer orgin_chin_l;
   ModelRenderer orgin_chin;

   public ModelSpiderCreeper() {
      this.textureWidth = 128;
      this.textureHeight = 128;
      float h = 4.0F;
      this.spider_head = new ModelRenderer(this, 72, 13);
      this.spider_head.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8);
      this.spider_head.setRotationPoint(0.0F, 20.0F - h, -3.0F);
      this.spider_head.setTextureSize(128, 128);
      this.spider_head.mirror = true;
      this.setRotation(this.spider_head, 0.0F, 0.0F, 0.0F);
      this.legs_body = new ModelRenderer(this, 1, 40);
      this.legs_body.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6);
      this.legs_body.setRotationPoint(0.0F, 20.0F - h, 0.0F);
      this.legs_body.setTextureSize(128, 128);
      this.legs_body.mirror = true;
      this.setRotation(this.legs_body, 0.0F, 0.0F, 0.0F);
      this.huge_body = new ModelRenderer(this, 0, 12);
      this.huge_body.addBox(-5.0F, -4.0F, -6.0F, 10, 8, 18);
      this.huge_body.setRotationPoint(0.0F, 15.0F - h, 6.0F);
      this.huge_body.setTextureSize(128, 128);
      this.huge_body.mirror = true;
      this.setRotation(this.huge_body, 0.8179294F, 0.0F, 0.0F);
      this.Leg8 = new ModelRenderer(this, 18, 0);
      this.Leg8.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2);
      this.Leg8.setRotationPoint(4.0F, 20.0F - h, -1.0F);
      this.Leg8.setTextureSize(128, 128);
      this.Leg8.mirror = true;
      this.setRotation(this.Leg8, 0.0F, 0.5759587F, 0.1919862F);
      this.Leg6 = new ModelRenderer(this, 18, 0);
      this.Leg6.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2);
      this.Leg6.setRotationPoint(4.0F, 20.0F - h, 0.0F);
      this.Leg6.setTextureSize(128, 128);
      this.Leg6.mirror = true;
      this.setRotation(this.Leg6, 0.0F, 0.2792527F, 0.1919862F);
      this.Leg4 = new ModelRenderer(this, 18, 0);
      this.Leg4.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2);
      this.Leg4.setRotationPoint(4.0F, 20.0F - h, 1.0F);
      this.Leg4.setTextureSize(128, 128);
      this.Leg4.mirror = true;
      this.setRotation(this.Leg4, 0.0F, -0.2792527F, 0.1919862F);
      this.Leg2 = new ModelRenderer(this, 18, 0);
      this.Leg2.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2);
      this.Leg2.setRotationPoint(4.0F, 20.0F - h, 2.0F);
      this.Leg2.setTextureSize(128, 128);
      this.Leg2.mirror = true;
      this.setRotation(this.Leg2, 0.0F, -0.5759587F, 0.1919862F);
      this.Leg7 = new ModelRenderer(this, 18, 0);
      this.Leg7.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2);
      this.Leg7.setRotationPoint(-4.0F, 20.0F - h, -1.0F);
      this.Leg7.setTextureSize(128, 128);
      this.Leg7.mirror = true;
      this.setRotation(this.Leg7, 0.0F, -0.5759587F, -0.1919862F);
      this.Leg5 = new ModelRenderer(this, 18, 0);
      this.Leg5.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2);
      this.Leg5.setRotationPoint(-4.0F, 20.0F - h, 0.0F);
      this.Leg5.setTextureSize(128, 128);
      this.Leg5.mirror = true;
      this.setRotation(this.Leg5, 0.0F, -0.2792527F, -0.1919862F);
      this.Leg3 = new ModelRenderer(this, 18, 0);
      this.Leg3.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2);
      this.Leg3.setRotationPoint(-4.0F, 20.0F - h, 1.0F);
      this.Leg3.setTextureSize(128, 128);
      this.Leg3.mirror = true;
      this.setRotation(this.Leg3, 0.0F, 0.2792527F, -0.1919862F);
      this.Leg1 = new ModelRenderer(this, 18, 0);
      this.Leg1.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2);
      this.Leg1.setRotationPoint(-4.0F, 20.0F - h, 2.0F);
      this.Leg1.setTextureSize(128, 128);
      this.Leg1.mirror = true;
      this.setRotation(this.Leg1, 0.0F, 0.5759587F, -0.1919862F);
      this.creeper_head_trot = new ModelRenderer(this, 1, 14);
      this.creeper_head_trot.addBox(0.0F, 0.0F, 0.0F, 3, 10, 3);
      this.creeper_head_trot.setRotationPoint(-2.0F, 6.0F - h, 0.0F);
      this.creeper_head_trot.setTextureSize(128, 128);
      this.creeper_head_trot.mirror = true;
      this.setRotation(this.creeper_head_trot, 1.375609F, 0.0F, 0.0F);
      this.crep_back_head = new ModelRenderer(this, 39, 13);
      this.crep_back_head.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 7);
      this.crep_back_head.setRotationPoint(-0.5F, 4.5F - h, 2.0F);
      this.crep_back_head.setTextureSize(128, 128);
      this.crep_back_head.mirror = true;
      this.setRotation(this.crep_back_head, 0.0F, 0.0F, 0.0F);
      this.pan_crep = new ModelRenderer(this, 56, 40);
      this.pan_crep.addBox(-4.0F, -4.0F, -8.0F, 8, 2, 1);
      this.pan_crep.setRotationPoint(-0.5F, 4.5F - h, 1.0F);
      this.pan_crep.setTextureSize(128, 128);
      this.pan_crep.mirror = true;
      this.setRotation(this.pan_crep, 0.0F, 0.0F, 0.0F);
      this.chin_crpp = new ModelRenderer(this, 52, 44);
      this.chin_crpp.addBox(-4.0F, -2.0F, -7.0F, 1, 6, 1);
      this.chin_crpp.setRotationPoint(-0.5F, 4.5F - h, 0.0F);
      this.chin_crpp.setTextureSize(128, 128);
      this.chin_crpp.mirror = true;
      this.setRotation(this.chin_crpp, 0.0F, 0.0F, 0.0F);
      this.chin_crep_l = new ModelRenderer(this, 75, 44);
      this.chin_crep_l.addBox(3.0F, -2.0F, -7.0F, 1, 6, 1);
      this.chin_crep_l.setRotationPoint(-0.5F, 4.5F - h, 0.0F);
      this.chin_crep_l.setTextureSize(128, 128);
      this.chin_crep_l.mirror = true;
      this.setRotation(this.chin_crep_l, 0.0F, 0.0F, 0.0F);
      this.nose_crep = new ModelRenderer(this, 60, 35);
      this.nose_crep.addBox(-1.0F, -2.0F, -7.0F, 2, 2, 1);
      this.nose_crep.setRotationPoint(-0.5F, 4.5F - h, 0.0F);
      this.nose_crep.setTextureSize(128, 128);
      this.nose_crep.mirror = true;
      this.setRotation(this.nose_crep, 0.0F, 0.0F, 0.0F);
      this.teht_crep = new ModelRenderer(this, 61, 52);
      this.teht_crep.addBox(-1.0F, 3.0F, -7.0F, 2, 1, 1);
      this.teht_crep.setRotationPoint(-0.5F, 4.5F - h, 0.0F);
      this.teht_crep.setTextureSize(128, 128);
      this.teht_crep.mirror = true;
      this.setRotation(this.teht_crep, 0.0F, 0.0F, 0.0F);
      this.diveder_aye_crep_l = new ModelRenderer(this, 65, 45);
      this.diveder_aye_crep_l.addBox(1.0F, 0.0F, -8.0F, 1, 1, 1);
      this.diveder_aye_crep_l.setRotationPoint(-0.5F, 4.5F - h, 1.0F);
      this.diveder_aye_crep_l.setTextureSize(128, 128);
      this.diveder_aye_crep_l.mirror = true;
      this.setRotation(this.diveder_aye_crep_l, 0.0F, 0.0F, 0.0F);
      this.diveder_aye_crep = new ModelRenderer(this, 63, 48);
      this.diveder_aye_crep.addBox(-2.0F, 0.0F, -8.0F, 1, 1, 1);
      this.diveder_aye_crep.setRotationPoint(-0.5F, 4.5F - h, 1.0F);
      this.diveder_aye_crep.setTextureSize(128, 128);
      this.diveder_aye_crep.mirror = true;
      this.setRotation(this.diveder_aye_crep, 0.0F, 0.0F, 0.0F);
      this.orgin_chin_l = new ModelRenderer(this, 70, 44);
      this.orgin_chin_l.addBox(2.0F, 0.0F, -8.0F, 1, 4, 1);
      this.orgin_chin_l.setRotationPoint(-0.5F, 4.5F - h, 1.0F);
      this.orgin_chin_l.setTextureSize(128, 128);
      this.orgin_chin_l.mirror = true;
      this.setRotation(this.orgin_chin_l, 0.0F, 0.0F, 0.0F);
      this.orgin_chin = new ModelRenderer(this, 57, 45);
      this.orgin_chin.addBox(-3.0F, 0.0F, -8.0F, 1, 4, 1);
      this.orgin_chin.setRotationPoint(-0.5F, 4.5F - h, 1.0F);
      this.orgin_chin.setTextureSize(128, 128);
      this.orgin_chin.mirror = true;
      this.setRotation(this.orgin_chin, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.spider_head.render(f5);
      this.legs_body.render(f5);
      this.huge_body.render(f5);
      this.Leg8.render(f5);
      this.Leg6.render(f5);
      this.Leg4.render(f5);
      this.Leg2.render(f5);
      this.Leg7.render(f5);
      this.Leg5.render(f5);
      this.Leg3.render(f5);
      this.Leg1.render(f5);
      this.creeper_head_trot.render(f5);
      this.crep_back_head.render(f5);
      this.pan_crep.render(f5);
      this.chin_crpp.render(f5);
      this.chin_crep_l.render(f5);
      this.nose_crep.render(f5);
      this.teht_crep.render(f5);
      this.diveder_aye_crep_l.render(f5);
      this.diveder_aye_crep.render(f5);
      this.orgin_chin_l.render(f5);
      this.orgin_chin.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
      this.spider_head.rotateAngleY = par4 / 57.295776F;
      this.spider_head.rotateAngleX = par5 / 57.295776F;
      float f6 = 0.7853982F;
      this.Leg1.rotateAngleZ = -f6;
      this.Leg2.rotateAngleZ = f6;
      this.Leg3.rotateAngleZ = -f6 * 0.74F;
      this.Leg4.rotateAngleZ = f6 * 0.74F;
      this.Leg5.rotateAngleZ = -f6 * 0.74F;
      this.Leg6.rotateAngleZ = f6 * 0.74F;
      this.Leg7.rotateAngleZ = -f6;
      this.Leg8.rotateAngleZ = f6;
      float f7 = -0.0F;
      float f8 = 0.3926991F;
      this.Leg1.rotateAngleY = f8 * 2.0F + f7;
      this.Leg2.rotateAngleY = -f8 * 2.0F - f7;
      this.Leg3.rotateAngleY = f8 * 1.0F + f7;
      this.Leg4.rotateAngleY = -f8 * 1.0F - f7;
      this.Leg5.rotateAngleY = -f8 * 1.0F + f7;
      this.Leg6.rotateAngleY = f8 * 1.0F - f7;
      this.Leg7.rotateAngleY = -f8 * 2.0F + f7;
      this.Leg8.rotateAngleY = f8 * 2.0F - f7;
      float f9 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + 0.0F) * 0.4F) * par2;
      float f10 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + 3.1415927F) * 0.4F) * par2;
      float f11 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + 1.5707964F) * 0.4F) * par2;
      float f12 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + 4.712389F) * 0.4F) * par2;
      float f13 = Math.abs(MathHelper.sin(par1 * 0.6662F + 0.0F) * 0.4F) * par2;
      float f14 = Math.abs(MathHelper.sin(par1 * 0.6662F + 3.1415927F) * 0.4F) * par2;
      float f15 = Math.abs(MathHelper.sin(par1 * 0.6662F + 1.5707964F) * 0.4F) * par2;
      float f16 = Math.abs(MathHelper.sin(par1 * 0.6662F + 4.712389F) * 0.4F) * par2;
      ModelRenderer var10000 = this.Leg1;
      var10000.rotateAngleY += f9;
      var10000 = this.Leg2;
      var10000.rotateAngleY += -f9;
      var10000 = this.Leg3;
      var10000.rotateAngleY += f10;
      var10000 = this.Leg4;
      var10000.rotateAngleY += -f10;
      var10000 = this.Leg5;
      var10000.rotateAngleY += f11;
      var10000 = this.Leg6;
      var10000.rotateAngleY += -f11;
      var10000 = this.Leg7;
      var10000.rotateAngleY += f12;
      var10000 = this.Leg8;
      var10000.rotateAngleY += -f12;
      var10000 = this.Leg1;
      var10000.rotateAngleZ += f13;
      var10000 = this.Leg2;
      var10000.rotateAngleZ += -f13;
      var10000 = this.Leg3;
      var10000.rotateAngleZ += f14;
      var10000 = this.Leg4;
      var10000.rotateAngleZ += -f14;
      var10000 = this.Leg5;
      var10000.rotateAngleZ += f15;
      var10000 = this.Leg6;
      var10000.rotateAngleZ += -f15;
      var10000 = this.Leg7;
      var10000.rotateAngleZ += f16;
      var10000 = this.Leg8;
      var10000.rotateAngleZ += -f16;
   }
}
