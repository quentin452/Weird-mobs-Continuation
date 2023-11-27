package com.zurragamez.wmm.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityStickManBaby extends EntityAnimal {

    private int lifeTime;
    private int life;
    public boolean correctLifeTime;

    public EntityStickManBaby(World par1World) {
        super(par1World);
        this.life = this.rand.nextInt(1000) + 7000;
        this.correctLifeTime = false;
        this.setSize(0.25F, 1.3F);
        this.tasks.addTask(0, new EntityAITempt(this, 2.1D, Items.paper, false));
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
            .setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.3D);
    }

    public void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
        nbt.setInteger("lifeTime", this.getLifeTime());
    }

    public void readEntityFromNBT(NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);
        this.setLifeTime(nbt.getInteger("lifeTime"));
        this.correctLifeTime = true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.correctLifeTime) {
            this.setLifeTime(this.getLifeTime() + 1);
        }

        if (this.getLifeTime() >= this.life) {
            EntityStickMan stickMan = new EntityStickMan(this.worldObj);
            stickMan.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);

            for (int i = 0; i < this.rand.nextInt(50) + 100; ++i) {
                this.worldObj.spawnParticle(
                    "smoke",
                    this.posX + this.rand.nextGaussian() * 0.3D,
                    this.posY + this.rand.nextGaussian() * 0.3D,
                    this.posZ + this.rand.nextGaussian() * 0.3D,
                    0.0D,
                    0.0D,
                    0.0D);
            }

            this.worldObj.spawnEntityInWorld(stickMan);
            this.setDead();
        }

    }

    public boolean interact(EntityPlayer player) {
        ItemStack item = player.inventory.getCurrentItem();
        if (!this.isSpeedUpItem(item)) {
            return false;
        } else {
            for (int i = 0; i < 10; ++i) {
                this.worldObj.spawnParticle(
                    "happyVillager",
                    this.posX + this.rand.nextGaussian() * 0.1D,
                    this.posY + this.rand.nextGaussian() * 0.1D + (double) (this.height / 2.0F),
                    this.posZ + this.rand.nextGaussian() * 0.1D,
                    0.1D,
                    0.0D,
                    0.1D);
            }

            this.lifeTime += 300;
            if (--item.stackSize <= 0) {
                item = null;
            }

            return true;
        }
    }

    public Item getDropItem() {
        return Items.paper;
    }

    public boolean isSpeedUpItem(ItemStack item) {
        return item != null && item.getItem() == Items.paper;
    }

    public void setCorrectLifeTime() {
        this.correctLifeTime = true;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public int getLifeTime() {
        return this.lifeTime;
    }

    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }
}
