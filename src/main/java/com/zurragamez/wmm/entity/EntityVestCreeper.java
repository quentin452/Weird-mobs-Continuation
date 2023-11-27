package com.zurragamez.wmm.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityVestCreeper extends EntityCreeper {
   private int flameCooldown;
   private int timeFlaming;
   private int maxFlameTime;
   private boolean shouldDropItem = true;
   private int lastActiveTime;
   private int timeSinceIgnited;
   private int fuseTime = 30;
   private int explosionRadius = 9;
   private final int var20 = 10;
   private int var21 = 10;

   public EntityVestCreeper(World par1World) {
      super(par1World);
      this.tasks.addTask(1, new EntityAISwimming(this));
      this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, false));
      this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
      this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.tasks.addTask(6, new EntityAILookIdle(this));
      this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
      this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
      this.setSize(0.6F, 1.8F);
   }

   public void setCreeperState(int par1) {
      this.dataWatcher.updateObject(16, (byte)par1);
   }

   public int getCreeperState() {
      return this.dataWatcher.getWatchableObjectByte(16);
   }

   @SideOnly(Side.CLIENT)
   public float getCreeperFlashIntensity(float par1) {
      return ((float)this.lastActiveTime + (float)(this.timeSinceIgnited - this.lastActiveTime) * par1) / (float)(this.fuseTime - 2);
   }

   public void onUpdate() {
      if (this.isEntityAlive()) {
         this.lastActiveTime = this.timeSinceIgnited;
         if (this.func_146078_ca()) {
            this.setCreeperState(1);
         }

         int i = this.getCreeperState();
         if (i > 0 && this.timeSinceIgnited == 0) {
            this.playSound("creeper.primed", 1.0F, 0.5F);
         }

         this.timeSinceIgnited += i;
         if (this.timeSinceIgnited < 0) {
            this.timeSinceIgnited = 0;
         }

         if (this.timeSinceIgnited > 0) {
            for(int l = 0; l < this.var21; ++l) {
               this.worldObj.spawnParticle("smoke", this.posX + this.rand.nextGaussian() * 0.10000001192092896D, this.posY + (double)this.height + this.rand.nextGaussian() * 0.10000001192092896D, this.posZ + this.rand.nextGaussian() * 0.10000001192092896D, 0.0D, 0.0D, 0.0D);
            }

            if (this.timeSinceIgnited > this.fuseTime / 3 * 2) {
               this.var21 = 100;
               this.worldObj.spawnParticle("lava", this.posX, this.posY + (double)this.height, this.posZ, 0.0D, 10.0D, 0.0D);
            } else {
               this.var21 = 10;
            }
         }

         if (this.timeSinceIgnited >= this.fuseTime) {
            this.timeSinceIgnited = this.fuseTime;
            this.func_146077_cc();
         }
      }

      super.onUpdate();
   }

   public boolean interact(EntityPlayer player) {
      ItemStack item = player.inventory.getCurrentItem();
      if (item != null) {
         if (item.getItem() == Items.gunpowder) {
            this.explosionRadius = (int)((float)this.explosionRadius + 0.2F);
         }

         if (!player.capabilities.isCreativeMode && --item.stackSize <= 0) {
            player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
         }

         player.swingItem();
         return true;
      } else {
         return false;
      }
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
   }

   protected void entityInit() {
      super.entityInit();
      this.getDataWatcher().addObject(12, (byte)0);
      this.getDataWatcher().addObject(13, (byte)0);
      this.getDataWatcher().addObject(14, (byte)0);
   }

   public boolean isAIEnabled() {
      return true;
   }

   protected Item getDropItem() {
      return Item.getItemFromBlock(Blocks.tnt);
   }

   private void func_146077_cc() {
      if (!this.worldObj.isRemote) {
         boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
         this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, flag);
      }

   }

   public boolean func_146078_ca() {
      return this.dataWatcher.getWatchableObjectByte(18) != 0;
   }

   public void func_146079_cb() {
      this.dataWatcher.updateObject(18, (byte)1);
   }
}
