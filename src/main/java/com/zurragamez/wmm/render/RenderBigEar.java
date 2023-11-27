package com.zurragamez.wmm.render;

import com.zurragamez.wmm.entity.EntityBigEar;
import com.zurragamez.wmm.model.ModelBigEar;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderBigEar extends RenderLiving {
   private static final ResourceLocation texture = new ResourceLocation("WeirdMobsMod:textures/mobs/BigEar.png");
   private static final ResourceLocation texture_tamed = new ResourceLocation("WeirdMobsMod:textures/mobs/BigEar_Tamed.png");
   private static final ResourceLocation texture_sitting = new ResourceLocation("WeirdMobsMod:textures/mobs/BigEar_Sitting.png");
   private static final ResourceLocation texture_tamed_necklace = new ResourceLocation("WeirdMobsMod:textures/mobs/BigEar_Tamed_Necklace.png");
   private static final ResourceLocation texture_sitting_necklace = new ResourceLocation("WeirdMobsMod:textures/mobs/BigEar_Sitting_Necklace.png");
   protected ModelBigEar model;

   public RenderBigEar(ModelBase par1ModelBase, float par2) {
      super(par1ModelBase, par2);
      this.model = this.model;
   }

   public void renderBigEar(EntityBigEar e, double d1, double d2, double d3, float f1, float f2) {
      super.doRender(e, d1, d2, d3, f1, f2);
   }

   public void doRenderLiving(EntityLiving e, double d1, double d2, double d3, float f1, float f2) {
      this.renderBigEar((EntityBigEar)e, d1, d2, d3, f1, f2);
   }

   public void doRender(Entity e, double d1, double d2, double d3, float f1, float f2) {
      this.renderBigEar((EntityBigEar)e, d1, d2, d3, f1, f2);
   }

   protected ResourceLocation getEntityTexture(Entity var1) {
      EntityBigEar be = (EntityBigEar)var1;
      if (be.getDataWatcher().getWatchableObjectByte(24) == 0) {
         if (be.isSitting()) {
            return texture_sitting;
         }

         if (be.isTamed()) {
            return texture_tamed;
         }
      } else {
         if (be.isSitting()) {
            return texture_sitting_necklace;
         }

         if (be.isTamed()) {
            return texture_tamed_necklace;
         }
      }

      return texture;
   }
}
