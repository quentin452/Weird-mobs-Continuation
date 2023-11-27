package com.zurragamez.wmm.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySpinningFeets extends EntityAnimal {
   private double x;
   private double y;
   private double z;
   private int waitingTime = 0;

   public EntitySpinningFeets(World par1World) {
      super(par1World);
      this.setSize(1.0F, 1.0F);
      this.tasks.addTask(0, new EntityAISwimming(this));
      this.tasks.addTask(1, new EntityAIWander(this, 0.8D));
      this.tasks.addTask(3, new EntityAIPanic(this, 1.2D));
      this.tasks.addTask(3, new EntityAILookIdle(this));
   }

   public boolean isAIEnabled() {
      return true;
   }

   public String getLivingSound() {
      return "WeirdMobsMod:spinningfeets.living";
   }

   public String getHurtSound() {
      return "WeirdMobsMod:spinningfeets.hurt";
   }

   public String getDeathSound() {
      return "WeirdMobsMod:spinningfeets.death";
   }

   public void onLivingUpdate() {
      super.onLivingUpdate();
      int j = MathHelper.floor_double(this.posX);
      int i = MathHelper.floor_double(this.posY - 0.20000000298023224D - (double)this.yOffset);
      int k = MathHelper.floor_double(this.posZ);
      double x = this.posX;
      double y = this.posY;
      double z = this.posZ;
      Block block = this.worldObj.getBlock(j, i, k);
      int a;
      if (this.onGround && !this.inWater && block != Blocks.air) {
         for(a = 0; a < 2; ++a) {
            this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_" + this.worldObj.getBlockMetadata(j, i, k), this.posX + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, this.boundingBox.minY + 0.1D, this.posZ + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, -this.motionX * 4.0D, 1.5D, -this.motionZ * 4.0D);
         }
      }

      if (this.inWater && block != Blocks.air) {
         for(a = 0; a < 2; ++a) {
            this.worldObj.spawnParticle("bubble", this.posX + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, this.boundingBox.minY + 0.1D, this.posZ + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
         }
      }

      if (this.x == x && this.y == y && this.z == z) {
         if (++this.waitingTime >= 100 && block == Blocks.grass) {
            this.worldObj.setBlock(j, i, k, Blocks.dirt);
         }
      } else {
         this.waitingTime = 0;
      }

      this.x = x;
      this.y = y;
      this.z = z;
   }

   public void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
   }

   public EntityAgeable createChild(EntityAgeable var1) {
      return null;
   }
}
