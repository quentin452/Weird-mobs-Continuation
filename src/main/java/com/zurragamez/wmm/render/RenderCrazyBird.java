package com.zurragamez.wmm.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.zurragamez.wmm.entity.EntityCrazyBird;
import com.zurragamez.wmm.model.ModelCrazyBird;

public class RenderCrazyBird extends RenderLiving {

    private static final ResourceLocation texture = new ResourceLocation("WeirdMobsMod:textures/mobs/CrazyBird.png");
    protected ModelCrazyBird model;

    public RenderCrazyBird(ModelBase par1ModelBase, float par2) {
        super(par1ModelBase, par2);
        this.model = this.model;
    }

    public void renderCrazyBird(EntityCrazyBird e, double d1, double d2, double d3, float f1, float f2) {
        super.doRender(e, d1, d2, d3, f1, f2);
    }

    public void doRenderLiving(EntityLiving e, double d1, double d2, double d3, float f1, float f2) {
        this.renderCrazyBird((EntityCrazyBird) e, d1, d2, d3, f1, f2);
    }

    public void doRender(Entity e, double d1, double d2, double d3, float f1, float f2) {
        this.renderCrazyBird((EntityCrazyBird) e, d1, d2, d3, f1, f2);
    }

    protected ResourceLocation getEntityTexture(Entity e) {
        return texture;
    }
}
