package com.zurragamez.wmm.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityTallMan extends EntityMob {
   public EntityTallMan(World par1World) {
      super(par1World);
      this.setSize(0.6F, 5.5F);
   }

   public void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.13D);
      this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
   }

   public String getLivingSound() {
      return "WeirdMobsMod:tallman.living";
   }

   public String getHurtSound() {
      return "WeirdMobsMod:tallman.hurt";
   }

   public String getDeathSound() {
      return "WeirdMobsMod:tallman.death";
   }

   public void dropRareDrop(int i) {
      this.dropItem(Items.ender_eye, 1);
   }
}
