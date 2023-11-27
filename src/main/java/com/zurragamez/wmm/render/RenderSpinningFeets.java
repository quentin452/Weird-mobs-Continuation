package com.zurragamez.wmm.render;

import com.zurragamez.wmm.entity.EntitySpinningFeets;
import com.zurragamez.wmm.model.ModelSpinningFeets;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderSpinningFeets extends RenderLiving {
   private static final ResourceLocation texture = new ResourceLocation("WeirdMobsMod:textures/mobs/SpinningFeets.png");
   protected ModelSpinningFeets model;

   public RenderSpinningFeets(ModelBase par1ModelBase, float par2) {
      super(par1ModelBase, par2);
      this.model = this.model;
   }

   public void renderSpinningFeets(EntitySpinningFeets e, double d1, double d2, double d3, float f1, float f2) {
      super.doRender(e, d1, d2, d3, f1, f2);
   }

   public void doRenderLiving(EntityLiving e, double d1, double d2, double d3, float f1, float f2) {
      this.renderSpinningFeets((EntitySpinningFeets)e, d1, d2, d3, f1, f2);
   }

   public void doRender(Entity e, double d1, double d2, double d3, float f1, float f2) {
      this.renderSpinningFeets((EntitySpinningFeets)e, d1, d2, d3, f1, f2);
   }

   protected ResourceLocation getEntityTexture(Entity var1) {
      return texture;
   }
}
