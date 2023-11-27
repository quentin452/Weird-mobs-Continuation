package com.zurragamez.wmm.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class EntityGooftile extends EntityAnimal {
   public EntityGooftile(World par1World) {
      super(par1World);
      this.setSize(1.0F, 1.5F);
   }

   public String getLivingSound() {
      return "WeirdMobsMod:gooftile.living";
   }

   public String getHurtSound() {
      return "WeirdMobsMod:gooftile.hurt";
   }

   public String getDeathSound() {
      return "WeirdMobsMod:gooftile.death";
   }

   public EntityAgeable createChild(EntityAgeable var1) {
      return null;
   }
}
