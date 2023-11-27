package com.zurragamez.wmm.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class EntityWalkingPainting extends EntityAnimal {

    public EntityWalkingPainting(World world) {
        super(world);
        this.setSize(1.0F, 1.2F);
    }

    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }
}
