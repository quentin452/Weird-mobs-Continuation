package com.zurragamez.wmm.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class EntityBUDRBot extends EntityAnimal {

    public EntityBUDRBot(World par1World) {
        super(par1World);
        this.setSize(0.6F, 1.0F);
    }

    protected String getLivingSound() {
        return "WeirdMobsMod:budrbot.living";
    }

    protected String getHurtSound() {
        return "WeirdMobsMod:budrbot.hurt";
    }

    protected String getDeathSound() {
        return "WeirdMobsMod:budrbot.death";
    }

    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }
}
