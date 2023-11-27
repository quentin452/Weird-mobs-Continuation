package com.zurragamez.wmm.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.zurragamez.wmm.common.WeirdMobsMod;

public class EntityFatMan extends EntityMob {

    public EntityFatMan(World par1World) {
        super(par1World);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(2, new EntityAILookIdle(this));
        this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.setSize(0.7F, 0.7F);
    }

    public boolean isAIEnabled() {
        return true;
    }

    protected String getLivingSound() {
        return "WeirdMobsMod:fatman.living";
    }

    protected String getHurtSound() {
        return "WeirdMobsMod:fatman.hurt";
    }

    protected String getDeathSound() {
        return "WeirdMobsMod:fatman.death";
    }

    public Item getDropItem() {
        return WeirdMobsMod.fatManRaw;
    }

    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.35D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(2.0D);
    }
}
