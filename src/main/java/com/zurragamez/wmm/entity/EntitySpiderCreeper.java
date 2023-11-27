package com.zurragamez.wmm.entity;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntitySpiderCreeper extends EntityMob {
   private static final String __OBFID = "CL_00001699";
   private int fuseTime = 30;
   private int timeSinceIgnited;
   private boolean played = false;
   private final int var20 = 10;
   private int var21 = 10;

   public EntitySpiderCreeper(World par1World) {
      super(par1World);
      this.setSize(1.4F, 0.9F);
   }

   protected void entityInit() {
      super.entityInit();
      this.dataWatcher.addObject(16, new Byte((byte)0));
   }

   public void onUpdate() {
      super.onUpdate();
      if (!this.worldObj.isRemote) {
         this.setBesideClimbableBlock(this.isCollidedHorizontally);
      }

   }

   public void onLivingUpdate() {
      super.onLivingUpdate();
      Entity entity = this.getEntityToAttack();
      if (entity != null) {
         if (this.getDistanceToEntity(entity) < 4.0F) {
            if (!this.played) {
               this.playSound("creeper.primed", 1.0F, 0.5F);
               this.played = true;
            }

            for(int i = 0; i < 100; ++i) {
               System.out.println("Ignited!");
               double d10 = this.func_82214_u(0);
               double d2 = this.func_82208_v(0);
               double d4 = this.func_82213_w(0);
               this.worldObj.spawnParticle("smoke", d10 + this.rand.nextGaussian() * 0.30000001192092896D, d2 + this.rand.nextGaussian() * 0.1D, d4 + this.rand.nextGaussian() * 0.30000001192092896D, 0.0D, 0.0D, 0.0D);
            }

            if (++this.timeSinceIgnited >= this.fuseTime) {
               this.explode();
            }
         } else {
            this.timeSinceIgnited = 0;
            this.played = false;
         }
      }

   }

   private void explode() {
      if (!this.worldObj.isRemote) {
         boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
         this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3.0F, flag);
         this.setDead();
      }

   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16.0D);
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.800000011920929D);
   }

   protected Entity findPlayerToAttack() {
      float f = this.getBrightness(1.0F);
      if (f < 0.5F) {
         double d0 = 16.0D;
         return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
      } else {
         return null;
      }
   }

   protected String getLivingSound() {
      return "mob.spider.say";
   }

   protected String getHurtSound() {
      return "mob.spider.say";
   }

   protected String getDeathSound() {
      return "mob.spider.death";
   }

   protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
      this.playSound("mob.spider.step", 0.15F, 1.0F);
   }

   protected void attackEntity(Entity par1Entity, float par2) {
      float f1 = this.getBrightness(1.0F);
      if (f1 > 0.5F && this.rand.nextInt(100) == 0) {
         this.entityToAttack = null;
      } else if (par2 > 2.0F && par2 < 6.0F && this.rand.nextInt(10) == 0) {
         if (this.onGround) {
            double d0 = par1Entity.posX - this.posX;
            double d1 = par1Entity.posZ - this.posZ;
            float f2 = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
            this.motionX = d0 / (double)f2 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
            this.motionZ = d1 / (double)f2 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
            this.motionY = 0.4000000059604645D;
         }
      } else {
         super.attackEntity(par1Entity, par2);
      }

   }

   protected Item getDropItem() {
      return Items.string;
   }

   protected void dropFewItems(boolean par1, int par2) {
      super.dropFewItems(par1, par2);
      this.dropItem(Items.gunpowder, 1);
      if (par1 && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + par2) > 0)) {
         this.dropItem(Items.spider_eye, 1);
      }

   }

   public boolean isOnLadder() {
      return this.isBesideClimbableBlock();
   }

   public void setInWeb() {
   }

   private double func_82214_u(int par1) {
      if (par1 <= 0) {
         return this.posX;
      } else {
         float f = (this.renderYawOffset + (float)(180 * (par1 - 1))) / 180.0F * 3.1415927F;
         float f1 = MathHelper.cos(f);
         return this.posX + (double)f1 * 1.3D;
      }
   }

   private double func_82208_v(int par1) {
      return this.posY + 1.0D;
   }

   private double func_82213_w(int par1) {
      if (par1 <= 0) {
         return this.posZ;
      } else {
         float f = (this.renderYawOffset + (float)(180 * (par1 - 1))) / 180.0F * 3.1415927F;
         float f1 = MathHelper.sin(f);
         return this.posZ + (double)f1 * 1.3D;
      }
   }

   public EnumCreatureAttribute getCreatureAttribute() {
      return EnumCreatureAttribute.ARTHROPOD;
   }

   public boolean isPotionApplicable(PotionEffect par1PotionEffect) {
      return par1PotionEffect.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(par1PotionEffect);
   }

   public boolean isBesideClimbableBlock() {
      return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
   }

   public void setBesideClimbableBlock(boolean par1) {
      byte b0 = this.dataWatcher.getWatchableObjectByte(16);
      if (par1) {
         b0 = (byte)(b0 | 1);
      } else {
         b0 &= -2;
      }

      this.dataWatcher.updateObject(16, b0);
   }

   public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData) {
      Object p_110161_1_1 = super.onSpawnWithEgg(par1EntityLivingData);
      if (this.worldObj.rand.nextInt(100) == 0) {
         EntitySkeleton entityskeleton = new EntitySkeleton(this.worldObj);
         entityskeleton.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
         entityskeleton.onSpawnWithEgg((IEntityLivingData)null);
         this.worldObj.spawnEntityInWorld(entityskeleton);
         entityskeleton.mountEntity(this);
      }

      if (p_110161_1_1 == null) {
         p_110161_1_1 = new EntitySpiderCreeper.GroupData();
         if (this.worldObj.difficultySetting == EnumDifficulty.HARD && this.worldObj.rand.nextFloat() < 0.1F * this.worldObj.func_147462_b(this.posX, this.posY, this.posZ)) {
            ((EntitySpiderCreeper.GroupData)p_110161_1_1).func_111104_a(this.worldObj.rand);
         }
      }

      if (p_110161_1_1 instanceof EntitySpiderCreeper.GroupData) {
         int i = ((EntitySpiderCreeper.GroupData)p_110161_1_1).field_111105_a;
         if (i > 0 && Potion.potionTypes[i] != null) {
            this.addPotionEffect(new PotionEffect(i, Integer.MAX_VALUE));
         }
      }

      return (IEntityLivingData)p_110161_1_1;
   }

   public static class GroupData implements IEntityLivingData {
      public int field_111105_a;
      private static final String __OBFID = "CL_00001700";

      public void func_111104_a(Random par1Random) {
         int i = par1Random.nextInt(5);
         if (i <= 1) {
            this.field_111105_a = Potion.moveSpeed.id;
         } else if (i <= 2) {
            this.field_111105_a = Potion.damageBoost.id;
         } else if (i <= 3) {
            this.field_111105_a = Potion.regeneration.id;
         } else if (i <= 4) {
            this.field_111105_a = Potion.invisibility.id;
         }

      }
   }
}
