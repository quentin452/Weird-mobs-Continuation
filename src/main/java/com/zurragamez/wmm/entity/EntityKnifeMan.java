package com.zurragamez.wmm.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityKnifeMan extends EntityMob {

    private int flameCooldown;

    public EntityKnifeMan(World par1World) {
        super(par1World);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(2, new EntityAILookIdle(this));
        this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.setSize(0.8F, 0.5F);
    }

    public boolean isAIEnabled() {
        return true;
    }

    public String getLivingSound() {
        return "WeirdMobsMod:knifeman.living";
    }

    public String getHurtSound() {
        return "WeirdMobsMod:knifeman.hurt";
    }

    public String getDeathSound() {
        return "WeirdMobsMod:knifeman.death";
    }

    public void onLivingUpdate() {
        if (!this.onGround && this.motionY < 0.0D) {
            this.motionY *= 0.8D;
        }

        for (int i = 0; i < 10; ++i) {
            this.worldObj
                .spawnParticle("smoke", this.posX, this.posY + (double) this.height, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        this.worldObj.spawnParticle("lava", this.posX, this.posY + (double) this.height, this.posZ, 0.0D, 0.0D, 0.0D);
        super.onLivingUpdate();
    }

    public Item getDropItem() {
        return (new ItemStack(Items.iron_sword, 2)).getItem();
    }

    protected void fall(float par1) {}

    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.25D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(4.0D);
    }
}
