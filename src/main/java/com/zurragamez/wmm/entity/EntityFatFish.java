package com.zurragamez.wmm.entity;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Items;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFatFish extends EntityWaterMob {

    public float fatFishPitch;
    public float prevfatFishPitch;
    public float fatFishYaw;
    public float prevfatFishYaw;
    public float fatFishRotation;
    public float prevfatFishRotation;
    public float tentacleAngle;
    public float lastTentacleAngle;
    private float randomMotionSpeed;
    private float rotationVelocity;
    private float field_70871_bB;
    private float randomMotionVecX;
    private float randomMotionVecY;
    private float randomMotionVecZ;

    public EntityFatFish(World par1World) {
        super(par1World);
        this.setSize(0.95F, 0.95F);
        this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(10.0D);
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return null;
    }

    protected String getDeathSound() {
        return null;
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    protected void dropFewItems(boolean par1, int par2) {
        int j = this.rand.nextInt(3 + par2) + 1;

        for (int k = 0; k < j; ++k) {
            this.dropItem(Items.fish, 1);
        }

    }

    public boolean isInWater() {
        return this.worldObj.handleMaterialAcceleration(
            this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D),
            Material.water,
            this);
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.prevfatFishPitch = this.fatFishPitch;
        this.prevfatFishYaw = this.fatFishYaw;
        this.prevfatFishRotation = this.fatFishRotation;
        this.lastTentacleAngle = this.tentacleAngle;
        this.fatFishRotation += this.rotationVelocity;
        if (!this.worldObj.isRemote) {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(
                this,
                this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ)
                    .expand(1.0D, 1.0D, 1.0D));

            for (int i = 0; i < list.size(); ++i) {
                Entity e = (Entity) list.get(i);
                if (e instanceof EntityFishHook) {
                    this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3.0F, false);
                    this.setDead();
                }
            }
        }

        if (this.fatFishRotation > 6.2831855F) {
            this.fatFishRotation -= 6.2831855F;
            if (this.rand.nextInt(10) == 0) {
                this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
            }
        }

        if (this.isInWater()) {
            float f;
            if (this.fatFishRotation < 3.1415927F) {
                f = this.fatFishRotation / 3.1415927F;
                this.tentacleAngle = MathHelper.sin(f * f * 3.1415927F) * 3.1415927F * 0.25F;
                if ((double) f > 0.75D) {
                    this.randomMotionSpeed = 1.0F;
                    this.field_70871_bB = 1.0F;
                } else {
                    this.field_70871_bB *= 0.8F;
                }
            } else {
                this.tentacleAngle = 0.0F;
                this.randomMotionSpeed *= 0.9F;
                this.field_70871_bB *= 0.99F;
            }

            if (!this.worldObj.isRemote) {
                this.motionX = (double) (this.randomMotionVecX * this.randomMotionSpeed);
                this.motionY = (double) (this.randomMotionVecY * this.randomMotionSpeed);
                this.motionZ = (double) (this.randomMotionVecZ * this.randomMotionSpeed);
            }

            f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.renderYawOffset += (-((float) Math.atan2(this.motionX, this.motionZ)) * 180.0F / 3.1415927F
                - this.renderYawOffset) * 0.1F;
            this.rotationYaw = this.renderYawOffset;
            this.fatFishYaw += 3.1415927F * this.field_70871_bB * 1.5F;
            this.fatFishPitch += (-((float) Math.atan2((double) f, this.motionY)) * 180.0F / 3.1415927F
                - this.fatFishPitch) * 0.1F;
        } else {
            this.tentacleAngle = MathHelper.abs(MathHelper.sin(this.fatFishRotation)) * 3.1415927F * 0.25F;
            if (!this.worldObj.isRemote) {
                this.motionX = 0.0D;
                this.motionY -= 0.08D;
                this.motionY *= 0.9800000190734863D;
                this.motionZ = 0.0D;
            }

            this.fatFishPitch = (float) ((double) this.fatFishPitch + (double) (-90.0F - this.fatFishPitch) * 0.02D);
        }

    }

    public void moveEntityWithHeading(float par1, float par2) {
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
    }

    protected void updateEntityActionState() {
        ++this.entityAge;
        if (this.entityAge > 100) {
            this.randomMotionVecX = this.randomMotionVecY = this.randomMotionVecZ = 0.0F;
        } else if (this.rand.nextInt(50) == 0 || !this.inWater
            || this.randomMotionVecX == 0.0F && this.randomMotionVecY == 0.0F && this.randomMotionVecZ == 0.0F) {
                float f = this.rand.nextFloat() * 3.1415927F * 2.0F;
                this.randomMotionVecX = MathHelper.cos(f) * 0.2F;
                this.randomMotionVecY = -0.1F + this.rand.nextFloat() * 0.2F;
                this.randomMotionVecZ = MathHelper.sin(f) * 0.2F;
            }

        this.despawnEntity();
    }

    public boolean getCanSpawnHere() {
        return this.posY > 45.0D && this.posY < 63.0D && super.getCanSpawnHere();
    }
}
