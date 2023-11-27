package com.zurragamez.wmm.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityTerrorTrickster extends EntityMob {

    public boolean hostile;

    public EntityTerrorTrickster(World par1World) {
        super(par1World);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 0.5D, true));
        this.tasks.addTask(2, new EntityAILookIdle(this));
        this.tasks.addTask(3, new EntityAIWander(this, 0.5D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.setSize(1.3F, 1.3F);
    }

    public boolean isAIEnabled() {
        return true;
    }

    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.3D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(15.0D);
    }

    public String getLivingSound() {
        return "WeirdMobsMod:terrortrickster.living";
    }

    public String getHurtSound() {
        return "WeirdMobsMod:terrortrickster.hurt";
    }

    public String getDeathSound() {
        return "WeirdMobsMod:terrortrickster.death";
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.getHealth() <= this.getMaxHealth() / 2.0F) {
            this.hostile = true;
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
                .setBaseValue(0.5D);
        }

    }
}
