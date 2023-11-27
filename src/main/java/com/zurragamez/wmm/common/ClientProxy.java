package com.zurragamez.wmm.common;

import com.zurragamez.wmm.entity.*;
import com.zurragamez.wmm.model.*;
import com.zurragamez.wmm.render.*;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    public void RenderInformation() {
        RenderingRegistry.registerEntityRenderingHandler(EntityBigEar.class, new RenderBigEar(new ModelBigEar(), 0.3F));
        RenderingRegistry
            .registerEntityRenderingHandler(EntityBigFish.class, new RenderBigFish(new ModelBigFish(), 0.3F));
        RenderingRegistry
            .registerEntityRenderingHandler(EntityBUDRBot.class, new RenderBUDRBot(new ModelBUDRBot(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(
            EntityButterMonger.class,
            new RenderButterMonger(new ModelButterMonger(), 0.3F));
        RenderingRegistry
            .registerEntityRenderingHandler(EntityCoohBird.class, new RenderCoohBird(new ModelCoohBird(), 0.3F));
        RenderingRegistry
            .registerEntityRenderingHandler(EntityCrazyBird.class, new RenderCrazyBird(new ModelCrazyBird(), 0.3F));
        RenderingRegistry
            .registerEntityRenderingHandler(EntityCyclopsMan.class, new RenderCyclopsMan(new ModelCyclopsMan(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(
            EntityDistortedMan.class,
            new RenderDistortedMan(new ModelDistortedMan(), 0.3F));
        RenderingRegistry
            .registerEntityRenderingHandler(EntityFatFish.class, new RenderFatFish(new ModelFatFish(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityFatMan.class, new RenderFatMan(new ModelFatMan(), 0.3F));
        RenderingRegistry
            .registerEntityRenderingHandler(EntityGooftile.class, new RenderGooftile(new ModelGooftile(), 0.3F));
        RenderingRegistry
            .registerEntityRenderingHandler(EntityKnifeMan.class, new RenderKnifeMan(new ModelKnifeMan(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(
            EntityPotionStick.class,
            new RenderPotionStick(new ModelPotionStick(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(
            EntitySpiderCreeper.class,
            new RenderSpiderCreeper(new ModelSpiderCreeper(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(
            EntitySpinningFeets.class,
            new RenderSpinningFeets(new ModelSpinningFeets(), 0.3F));
        RenderingRegistry
            .registerEntityRenderingHandler(EntityStickMan.class, new RenderStickMan(new ModelStickMan(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(
            EntityStickManBaby.class,
            new RenderStickManBaby(new ModelStickManBaby(), 0.3F));
        RenderingRegistry
            .registerEntityRenderingHandler(EntityTallMan.class, new RenderTallMan(new ModelTallMan(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(
            EntityTerrorTrickster.class,
            new RenderTerrorTrickster(new ModelTerrorTrickster(), 0.3F));
        RenderingRegistry
            .registerEntityRenderingHandler(EntityTrinitope.class, new RenderTrinitope(new ModelTrinitope(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(
            EntityVestCreeper.class,
            new RenderVestCreeper(new ModelVestCreeper(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(
            EntityVillagerHead.class,
            new RenderVillagerHead(new ModelVillagerHead(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(
            EntityWalkingPainting.class,
            new RenderWalkingPainting(new ModelWalkingPainting(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(
            EntityWalkingRadio.class,
            new RenderWalkingRadio(new ModelWalkingRadio(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(
            EntityWitherCreeper.class,
            new RenderWitherCreeper(new ModelWitherCreeper(), 0.3F));
    }
}
