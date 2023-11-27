package com.zurragamez.wmm.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.zurragamez.wmm.common.WeirdMobsMod;

public class EntityPotionStick extends EntityMob {

    public EntityPotionStick(World par1World) {
        super(par1World);
        this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
        this.setSize(0.08F, 1.4F);
    }

    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(3.0D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.25D);
    }

    public String getLivingSound() {
        return "WeirdMobsMod:potionstick.living";
    }

    public String getHurtSound() {
        return "WeirdMobsMod:potionstick.hurt";
    }

    public String getDeathSound() {
        return "WeirdMobsMod:potionstick.death";
    }

    public Item getDropItem() {
        return WeirdMobsMod.potionStick;
    }

    public void addPotionEffect(PotionEffect par1PotionEffect) {}

    public boolean attackEntityAsMob(Entity e) {
        super.attackEntityAsMob(e);
        if (e instanceof EntityLivingBase) {
            byte b = 0;
            if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
                b = 11;
            } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                b = 31;
            }

            if (e instanceof EntityPlayer) {
                EntityPlayer p = (EntityPlayer) e;
                if (!p.capabilities.isCreativeMode && b > 0) {
                    ((EntityLivingBase) e).addPotionEffect(new PotionEffect(Potion.weakness.id, b * 20, 0));
                    ((EntityLivingBase) e).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, b * 20, 0));
                    ((EntityLivingBase) e).addPotionEffect(new PotionEffect(Potion.poison.id, b * 20, 0));
                }
            } else if (b > 0) {
                ((EntityLivingBase) e).addPotionEffect(new PotionEffect(Potion.weakness.id, b * 20, 0));
                ((EntityLivingBase) e).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, b * 20, 0));
                ((EntityLivingBase) e).addPotionEffect(new PotionEffect(Potion.poison.id, b * 20, 0));
            }

            return true;
        } else {
            return false;
        }
    }
}
