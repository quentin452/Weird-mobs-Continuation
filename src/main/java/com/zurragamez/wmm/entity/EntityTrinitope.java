package com.zurragamez.wmm.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityTrinitope extends EntityMob {
   public EntityTrinitope(World par1World) {
      super(par1World);
      this.tasks.addTask(1, new EntityAISwimming(this));
      this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0D, true));
      this.tasks.addTask(2, new EntityAILookIdle(this));
      this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
      this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
   }

   public boolean isAIEnabled() {
      return true;
   }

   public String getLivingSound() {
      return "WeirdMobsMod:trinitope.living";
   }

   public String getHurtSound() {
      return "WeirdMobsMod:trinitope.hurt";
   }

   public String getDeathSound() {
      return "WeirdMobsMod:trinitope.death";
   }

   public void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
      this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
   }
}
