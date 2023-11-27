package com.zurragamez.wmm.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.zurragamez.wmm.common.WeirdMobsMod;

public class EntityStickMan extends EntityAnimal {

    public EntityStickMan(World par1World) {
        super(par1World);
        this.setSize(0.7F, 1.8F);
        this.tasks.addTask(0, new EntityAITempt(this, 1.2D, Items.book, false));
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
        return "WeirdMobsMod:stickman.living";
    }

    public String getHurtSound() {
        return "WeirdMobsMod:stickman.hurt";
    }

    public String getDeathSound() {
        return "WeirdMobsMod:stickman.death";
    }

    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.25D);
    }

    public boolean isBreedingItem(ItemStack item) {
        return item != null && item.getItem() == Items.book;
    }

    public Item getDropItem() {
        return Items.paper;
    }

    public void dropRareDrop(int i) {
        this.dropItem(WeirdMobsMod.stickManHead, 1);
    }

    public EntityAgeable createChild(EntityAgeable var1) {
        EntityStickManBaby smb = new EntityStickManBaby(this.worldObj);
        smb.correctLifeTime = true;
        return smb;
    }
}
