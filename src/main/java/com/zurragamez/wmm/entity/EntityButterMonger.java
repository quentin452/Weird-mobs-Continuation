package com.zurragamez.wmm.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityButterMonger extends EntityMob {

    public EntityButterMonger(World par1World) {
        super(par1World);
        this.setSize(1.0F, 1.5F);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.5D, false));
        this.tasks.addTask(4, new EntityAIWander(this, 0.5D));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }

    public boolean isAIEnabled() {
        return true;
    }

    public String getLivingSound() {
        return "WeirdMobsMod:buttermonger.living";
    }

    public String getHurtSound() {
        return "WeirdMobsMod:buttermonger.hurt";
    }

    public String getDeathSound() {
        return "WeirdMobsMod:buttermonger.death";
    }

    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.25D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(2.0D);
    }
}
