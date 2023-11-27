package com.zurragamez.wmm.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityWalkingRadio extends EntityAnimal {
   private boolean hasPlayed = false;

   public EntityWalkingRadio(World par1World) {
      super(par1World);
      this.setSize(0.5F, 0.5F);
      this.getNavigator().setAvoidsWater(true);
      this.tasks.addTask(0, new EntityAIWander(this, 0.8D));
      this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
      this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.tasks.addTask(3, new EntityAILookIdle(this));
   }

   public void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
   }

   public void onLivingUpdate() {
      super.onLivingUpdate();
      if (this.isInWater()) {
         if (!this.hasPlayed) {
            this.worldObj.playSoundAtEntity(this, "WeirdMobsMod:walkingradio.water", 1.0F, 1.0F);
            this.hasPlayed = true;
         }

         this.setHealth(0.0F);
      }

   }

   public Item getDropItem() {
      switch(this.rand.nextInt(11)) {
      case 0:
         return Items.record_strad;
      case 1:
         return Items.record_cat;
      case 2:
         return Items.record_far;
      case 3:
         return Items.record_chirp;
      case 4:
         return Items.record_mall;
      case 5:
         return Items.record_mellohi;
      case 6:
         return Items.record_stal;
      case 7:
         return Items.record_wait;
      case 8:
         return Items.record_ward;
      case 9:
         return Items.record_11;
      case 10:
         return Items.record_13;
      default:
         return Items.record_blocks;
      }
   }

   public String getLivingSound() {
      return "WeirdMobsMod:walkingradio.living";
   }

   public String getHurtSound() {
      return "WeirdMobsMod:walkingradio.hurt";
   }

   public String getDeathSound() {
      return "WeirdMobsMod:walkingradio.death";
   }

   public EntityAgeable createChild(EntityAgeable var1) {
      return null;
   }
}
