package com.zurragamez.wmm.render;

import com.zurragamez.wmm.entity.EntityWalkingPainting;
import com.zurragamez.wmm.model.ModelWalkingPainting;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderWalkingPainting extends RenderLiving {
   private static final ResourceLocation texture = new ResourceLocation("WeirdMobsMod:textures/mobs/WalkingPainting.png");
   protected ModelWalkingPainting model;

   public RenderWalkingPainting(ModelBase par1ModelBase, float par2) {
      super(par1ModelBase, par2);
      this.model = this.model;
   }

   public void renderWalkingPainting(EntityWalkingPainting e, double d1, double d2, double d3, float f1, float f2) {
      super.doRender(e, d1, d2, d3, f1, f2);
   }

   public void doRenderLiving(EntityLiving e, double d1, double d2, double d3, float f1, float f2) {
      this.renderWalkingPainting((EntityWalkingPainting)e, d1, d2, d3, f1, f2);
   }

   public void doRender(Entity e, double d1, double d2, double d3, float f1, float f2) {
      this.renderWalkingPainting((EntityWalkingPainting)e, d1, d2, d3, f1, f2);
   }

   protected ResourceLocation getEntityTexture(Entity e) {
      return texture;
   }
}
