package com.zurragamez.wmm.entity;

import com.zurragamez.wmm.common.WeirdMobsMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityWitherCreeper extends EntityMob implements IBossDisplayData, IRangedAttackMob {
   private float[] field_82220_d = new float[2];
   private float[] field_82221_e = new float[2];
   private float[] field_82217_f = new float[2];
   private float[] field_82218_g = new float[2];
   private int[] field_82223_h = new int[2];
   private int[] field_82224_i = new int[2];
   private int field_82222_j;
   private static final IEntitySelector attackEntitySelector = new IEntitySelector() {

      public boolean isEntityApplicable(Entity par1Entity) {
         return par1Entity instanceof EntityLivingBase && ((EntityLivingBase)par1Entity).getCreatureAttribute() != EnumCreatureAttribute.UNDEAD;
      }
   };
   public EntityWitherCreeper(World par1World) {
      super(par1World);
      this.setHealth(this.getMaxHealth());
      this.setSize(1.0F, 1.5F);
      this.isImmuneToFire = true;
      this.getNavigator().setCanSwim(true);
      this.tasks.addTask(0, new EntityAISwimming(this));
      this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.0D, 40, 20.0F));
      this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
      this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.tasks.addTask(7, new EntityAILookIdle(this));
      this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
      this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, false, attackEntitySelector));
      this.experienceValue = 50;
   }

   protected void entityInit() {
      super.entityInit();
      this.dataWatcher.addObject(17, new Integer(0));
      this.dataWatcher.addObject(18, new Integer(0));
      this.dataWatcher.addObject(19, new Integer(0));
      this.dataWatcher.addObject(20, new Integer(0));
   }

   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
      super.writeEntityToNBT(par1NBTTagCompound);
      par1NBTTagCompound.setInteger("Invul", this.func_82212_n());
   }

   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
      super.readEntityFromNBT(par1NBTTagCompound);
      this.func_82215_s(par1NBTTagCompound.getInteger("Invul"));
   }

   @SideOnly(Side.CLIENT)
   public float getShadowSize() {
      return this.height / 8.0F;
   }

   protected String getLivingSound() {
      return "mob.wither.idle";
   }

   protected String getHurtSound() {
      return "mob.wither.hurt";
   }

   protected String getDeathSound() {
      return "mob.wither.death";
   }

   public void onLivingUpdate() {
      double d1;
      double d3;
      double d5;
      if (!this.worldObj.isRemote && this.getWatchedTargetId(0) > 0) {
         Entity entity = this.worldObj.getEntityByID(this.getWatchedTargetId(0));
         if (entity != null) {
            double d0 = entity.posX - this.posX;
            d1 = entity.posZ - this.posZ;
            d3 = d0 * d0 + d1 * d1;
            if (d3 > 9.0D) {
               d5 = (double)MathHelper.sqrt_double(d3);
               this.motionX += (d0 / d5 * 0.5D - this.motionX) * 0.6000000238418579D;
               this.motionZ += (d1 / d5 * 0.5D - this.motionZ) * 0.6000000238418579D;
            }
         }
      }

      if (this.motionX * this.motionX + this.motionZ * this.motionZ > 0.05000000074505806D) {
         this.rotationYaw = (float)Math.atan2(this.motionZ, this.motionX) * 57.295776F - 90.0F;
      }

      super.onLivingUpdate();

      int i;
      for(i = 0; i < 2; ++i) {
         this.field_82218_g[i] = this.field_82221_e[i];
         this.field_82217_f[i] = this.field_82220_d[i];
      }

      double d10;
      double d2;
      double d4;
      int j;
      for(i = 0; i < 2; ++i) {
         j = this.getWatchedTargetId(i + 1);
         Entity entity1 = null;
         if (j > 0) {
            entity1 = this.worldObj.getEntityByID(j);
         }

         if (entity1 != null) {
            d1 = this.func_82214_u(i + 1);
            d3 = this.func_82208_v(i + 1);
            d5 = this.func_82213_w(i + 1);
            d10 = entity1.posX - d1;
            d2 = entity1.posY + (double)entity1.getEyeHeight() - d3;
            d4 = entity1.posZ - d5;
            double d9 = (double)MathHelper.sqrt_double(d10 * d10 + d4 * d4);
            float f = (float)(Math.atan2(d4, d10) * 180.0D / 3.141592653589793D) - 90.0F;
            float f1 = (float)(-(Math.atan2(d2, d9) * 180.0D / 3.141592653589793D));
            this.field_82220_d[i] = this.func_82204_b(this.field_82220_d[i], f1, 40.0F);
            this.field_82221_e[i] = this.func_82204_b(this.field_82221_e[i], f, 10.0F);
         } else {
            this.field_82221_e[i] = this.func_82204_b(this.field_82221_e[i], this.renderYawOffset, 10.0F);
         }
      }

      boolean flag = this.isArmored();

      for(j = 0; j < 3; ++j) {
         d10 = this.func_82214_u(j);
         d2 = this.func_82208_v(j);
         d4 = this.func_82213_w(j);
         this.worldObj.spawnParticle("smoke", d10 + this.rand.nextGaussian() * 0.3D, d2 + this.rand.nextGaussian() * 0.2D, d4 + this.rand.nextGaussian() * 0.3D, 0.0D, 0.0D, 0.0D);
         if (flag && this.worldObj.rand.nextInt(4) == 0) {
            this.worldObj.spawnParticle("mobSpell", d10 + this.rand.nextGaussian() * 0.30000001192092896D, d2 + this.rand.nextGaussian() * 0.1D, d4 + this.rand.nextGaussian() * 0.30000001192092896D, 0.699999988079071D, 0.699999988079071D, 0.5D);
         }
      }

      if (this.func_82212_n() > 0) {
         for(j = 0; j < 3; ++j) {
            this.worldObj.spawnParticle("mobSpell", this.posX + this.rand.nextGaussian() * 1.0D, this.posY + this.rand.nextGaussian() * 0.1D, this.posZ + this.rand.nextGaussian() * 1.0D, 0.699999988079071D, 0.699999988079071D, 0.8999999761581421D);
         }
      }

   }

   protected void updateAITasks() {
      int i;
      if (this.func_82212_n() > 0) {
         i = this.func_82212_n() - 1;
         if (i <= 0) {
            this.worldObj.newExplosion(this, this.posX, this.posY + (double)this.getEyeHeight(), this.posZ, 7.0F, false, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
            this.worldObj.playBroadcastSound(1013, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
         }

         this.func_82215_s(i);
         if (this.ticksExisted % 10 == 0) {
            this.heal(10.0F);
         }
      } else {
         super.updateAITasks();

         int i1;
         int j1;
         for(i = 1; i < 3; ++i) {
            if (this.ticksExisted >= this.field_82223_h[i - 1]) {
               this.field_82223_h[i - 1] = this.ticksExisted + 10 + this.rand.nextInt(10);
               int k1;
               if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL || this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                  j1 = i - 1;
                  k1 = this.field_82224_i[i - 1];
                  this.field_82224_i[j1] = this.field_82224_i[i - 1] + 1;
                  if (k1 > 50) {
                     float f = 10.0F;
                     float f1 = 5.0F;
                     double d0 = MathHelper.getRandomDoubleInRange(this.rand, this.posX - (double)f, this.posX + (double)f);
                     double d1 = MathHelper.getRandomDoubleInRange(this.rand, this.posY - (double)f1, this.posY + (double)f1);
                     double d2 = MathHelper.getRandomDoubleInRange(this.rand, this.posZ - (double)f, this.posZ + (double)f);
                     this.func_82209_a(i + 1, d0, d1, d2, true);
                     this.field_82224_i[i - 1] = 0;
                  }
               }

               i1 = this.getWatchedTargetId(i);
               if (i1 > 0) {
                  Entity entity = this.worldObj.getEntityByID(i1);
                  if (entity != null && entity.isEntityAlive() && this.getDistanceSqToEntity(entity) <= 900.0D && this.canEntityBeSeen(entity)) {
                     this.func_82216_a(i + 1, (EntityLivingBase)entity);
                     this.field_82223_h[i - 1] = this.ticksExisted + 40 + this.rand.nextInt(20);
                     this.field_82224_i[i - 1] = 0;
                  } else {
                     this.func_82211_c(i, 0);
                  }
               } else {
                  List list = this.worldObj.selectEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(20.0D, 8.0D, 20.0D), attackEntitySelector);

                  for(k1 = 0; k1 < 10 && !list.isEmpty(); ++k1) {
                     EntityLivingBase entitylivingbase = (EntityLivingBase)list.get(this.rand.nextInt(list.size()));
                     if (entitylivingbase != this && entitylivingbase.isEntityAlive() && this.canEntityBeSeen(entitylivingbase)) {
                        if (entitylivingbase instanceof EntityPlayer) {
                           if (!((EntityPlayer)entitylivingbase).capabilities.disableDamage) {
                              this.func_82211_c(i, entitylivingbase.getEntityId());
                           }
                        } else {
                           this.func_82211_c(i, entitylivingbase.getEntityId());
                        }
                        break;
                     }

                     list.remove(entitylivingbase);
                  }
               }
            }
         }

         if (this.getAttackTarget() != null) {
            this.func_82211_c(0, this.getAttackTarget().getEntityId());
         } else {
            this.func_82211_c(0, 0);
         }

         if (this.field_82222_j > 0) {
            --this.field_82222_j;
            if (this.field_82222_j == 0 && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
               i = MathHelper.floor_double(this.posY);
               i1 = MathHelper.floor_double(this.posX);
               j1 = MathHelper.floor_double(this.posZ);
               boolean flag = false;
               int l1 = -1;

               while(true) {
                  if (l1 > 1) {
                     if (flag) {
                        this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1012, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                     }
                     break;
                  }

                  for(int i2 = -1; i2 <= 1; ++i2) {
                     for(int j = 0; j <= 3; ++j) {
                        int j2 = i1 + l1;
                        int k = i + j;
                        int l = j1 + i2;
                        Block block = this.worldObj.getBlock(j2, k, l);
                        if (!block.isAir(this.worldObj, j2, k, l) && block.canEntityDestroy(this.worldObj, j2, k, l, this)) {
                           flag = this.worldObj.func_147480_a(j2, k, l, true) || flag;
                        }
                     }
                  }

                  ++l1;
               }
            }
         }

         if (this.ticksExisted % 20 == 0) {
            this.heal(1.0F);
         }
      }

   }

   public void func_82206_m() {
      this.func_82215_s(220);
      this.setHealth(this.getMaxHealth() / 3.0F);
   }

   public void setInWeb() {
   }

   public int getTotalArmorValue() {
      return 4;
   }

   private double func_82214_u(int par1) {
      if (par1 <= 0) {
         return this.posX;
      } else {
         float f = (this.renderYawOffset + (float)(180 * (par1 - 1))) / 180.0F * 3.1415927F;
         float f1 = MathHelper.cos(f);
         return this.posX + (double)f1 * 1.3D * 0.3D;
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
         return this.posZ + (double)f1 * 1.3D * 0.3D;
      }
   }

   private float func_82204_b(float par1, float par2, float par3) {
      float f3 = MathHelper.wrapAngleTo180_float(par2 - par1);
      if (f3 > par3) {
         f3 = par3;
      }

      if (f3 < -par3) {
         f3 = -par3;
      }

      return par1 + f3;
   }

   private void func_82216_a(int par1, EntityLivingBase par2EntityLivingBase) {
      this.func_82209_a(par1, par2EntityLivingBase.posX, par2EntityLivingBase.posY + (double)par2EntityLivingBase.getEyeHeight() * 0.5D, par2EntityLivingBase.posZ, par1 == 0 && this.rand.nextFloat() < 0.001F);
   }

   private void func_82209_a(int par1, double par2, double par4, double par6, boolean par8) {
      this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1014, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
      double d3 = this.func_82214_u(par1);
      double d4 = this.func_82208_v(par1);
      double d5 = this.func_82213_w(par1);
      double d6 = par2 - d3;
      double d7 = par4 - d4;
      double d8 = par6 - d5;
      EntityWitherSkull entitywitherskull = new EntityWitherSkull(this.worldObj, this, d6, d7, d8);
      if (par8) {
         entitywitherskull.setInvulnerable(true);
      }

      entitywitherskull.posY = d4;
      entitywitherskull.posX = d3;
      entitywitherskull.posZ = d5;
      this.worldObj.spawnEntityInWorld(entitywitherskull);
   }

   public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2) {
      this.func_82216_a(0, par1EntityLivingBase);
   }

   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
      if (this.isEntityInvulnerable()) {
         return false;
      } else if (par1DamageSource == DamageSource.drown) {
         return false;
      } else if (this.func_82212_n() > 0) {
         return false;
      } else {
         Entity entity;
         if (this.isArmored()) {
            entity = par1DamageSource.getSourceOfDamage();
            if (entity instanceof EntityArrow) {
               return false;
            }
         }

         entity = par1DamageSource.getEntity();
         if (entity != null && !(entity instanceof EntityPlayer) && entity instanceof EntityLivingBase && ((EntityLivingBase)entity).getCreatureAttribute() == this.getCreatureAttribute()) {
            return false;
         } else {
            if (this.field_82222_j <= 0) {
               this.field_82222_j = 20;
            }

            for(int i = 0; i < this.field_82224_i.length; ++i) {
               int[] var10000 = this.field_82224_i;
               var10000[i] += 3;
            }

            return super.attackEntityFrom(par1DamageSource, par2);
         }
      }
   }

   protected void dropFewItems(boolean par1, int par2) {
      this.dropItem(WeirdMobsMod.netherStarPiece, 1);
   }

   protected void despawnEntity() {
      this.entityAge = 0;
   }

   @SideOnly(Side.CLIENT)
   public int getBrightnessForRender(float par1) {
      return 15728880;
   }

   protected void fall(float par1) {
   }

   public void addPotionEffect(PotionEffect par1PotionEffect) {
   }

   protected boolean isAIEnabled() {
      return true;
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
      this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
   }

   @SideOnly(Side.CLIENT)
   public float func_82207_a(int par1) {
      return this.field_82221_e[par1];
   }

   @SideOnly(Side.CLIENT)
   public float func_82210_r(int par1) {
      return this.field_82220_d[par1];
   }

   public int func_82212_n() {
      return this.dataWatcher.getWatchableObjectInt(20);
   }

   public void func_82215_s(int par1) {
      this.dataWatcher.updateObject(20, par1);
   }

   public int getWatchedTargetId(int par1) {
      return this.dataWatcher.getWatchableObjectInt(17 + par1);
   }

   public void func_82211_c(int par1, int par2) {
      this.dataWatcher.updateObject(17 + par1, par2);
   }

   public boolean isArmored() {
      return this.getHealth() <= this.getMaxHealth() / 2.0F;
   }

   public EnumCreatureAttribute getCreatureAttribute() {
      return EnumCreatureAttribute.UNDEAD;
   }

   public void mountEntity(Entity par1Entity) {
      this.ridingEntity = null;
   }
}
