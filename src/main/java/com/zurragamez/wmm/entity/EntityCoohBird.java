package com.zurragamez.wmm.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityCoohBird extends EntityAnimal {
   public EntityCoohBird(World par1World) {
      super(par1World);
      this.setSize(0.7F, 1.8F);
      this.tasks.addTask(1, new EntityAISwimming(this));
      this.tasks.addTask(2, new EntityAILookIdle(this));
      this.tasks.addTask(3, new EntityAIPanic(this, 1.5D));
      this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
      this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
      this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.tasks.addTask(7, new EntityAIMate(this, 1.0D));
   }

   public boolean isAIEnabled() {
      return true;
   }

   public String getLivingSound() {
      return "WeirdMobsMod:coohbird.living";
   }

   public String getHurtSound() {
      return "WeirdMobsMod:coohbird.hurt";
   }

   public String getDeathSound() {
      return "WeirdMobsMod:coohbird.death";
   }

   public void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
   }

   public EntityAgeable createChild(EntityAgeable var1) {
      return null;
   }
}
