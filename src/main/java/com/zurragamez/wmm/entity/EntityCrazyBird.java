package com.zurragamez.wmm.entity;

import com.zurragamez.wmm.common.WeirdMobsMod;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityCrazyBird extends EntityAnimal {
   private boolean isTriggered;
   private final EntityAITempt ai_diamond;
   private final EntityAITempt ai_goldIngot;
   private final EntityAITempt ai_ironIngot;

   public EntityCrazyBird(World par1World) {
      super(par1World);
      this.ai_diamond = new EntityAITempt(this, 1.2D, Items.diamond, false);
      this.ai_goldIngot = new EntityAITempt(this, 1.2D, Items.gold_ingot, false);
      this.ai_ironIngot = new EntityAITempt(this, 1.2D, Items.iron_ingot, false);
      this.getNavigator().setAvoidsWater(true);
      this.tasks.addTask(0, this.ai_ironIngot);
      this.tasks.addTask(1, this.ai_goldIngot);
      this.tasks.addTask(2, this.ai_diamond);
      this.setSize(1.0F, 1.0F);
   }

   public boolean isAIEnabled() {
      return true;
   }

   public void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
   }

   public String getLivingSound() {
      return "WeirdMobsMod:crazybird.living";
   }

   public String getHurtSound() {
      return "WeirdMobsMod:crazybird.hurt";
   }

   public String getDeathSound() {
      return "WeirdMobsMod:crazybird.death";
   }

   public void onLivingUpdate() {
      super.onLivingUpdate();
      if (this.isTriggered) {
         this.tasks.removeTask(this.ai_ironIngot);
         this.tasks.removeTask(this.ai_goldIngot);
         this.tasks.removeTask(this.ai_diamond);
      }

   }

   public void writeEntityToNBT(NBTTagCompound nbt) {
      super.writeEntityToNBT(nbt);
      nbt.setBoolean("isTriggered", this.isTriggered);
   }

   public void readEntityFromNBT(NBTTagCompound nbt) {
      super.readEntityFromNBT(nbt);
      if (nbt.getBoolean("isTriggered")) {
         System.out.println("Triggered!");
         this.isTriggered = true;
         this.tasks.removeTask(this.ai_ironIngot);
         this.tasks.removeTask(this.ai_goldIngot);
         this.tasks.removeTask(this.ai_diamond);
         this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityPlayer.class, 10000.0F, 1.0D, 2.0D));
      }

   }

   public boolean interact(EntityPlayer player) {
      ItemStack itemstack = player.inventory.getCurrentItem();
      if (itemstack == null || itemstack.getItem() != Items.diamond && itemstack.getItem() != Items.gold_ingot && itemstack.getItem() != Items.iron_ingot) {
         return super.interact(player);
      } else {
         this.isTriggered = true;
         this.tasks.removeTask(this.ai_ironIngot);
         this.tasks.removeTask(this.ai_goldIngot);
         this.tasks.removeTask(this.ai_diamond);
         this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityPlayer.class, 10000.0F, 1.0D, 2.0D));
         if (itemstack.stackSize-- == 1) {
            player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Items.wheat_seeds));
         } else if (!player.inventory.addItemStackToInventory(new ItemStack(Items.wheat_seeds))) {
            player.dropPlayerItemWithRandomChoice(new ItemStack(Items.wheat_seeds, 1, 0), false);
         }

         return true;
      }
   }

   public void dropFewItem(boolean par1, int par2) {
      this.dropItem(Items.feather, 2);
      this.dropItem(WeirdMobsMod.crazyBirdRaw, 1);
   }

   public EntityAgeable createChild(EntityAgeable var1) {
      return null;
   }
}
