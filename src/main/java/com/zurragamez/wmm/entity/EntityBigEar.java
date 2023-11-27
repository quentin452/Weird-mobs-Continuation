package com.zurragamez.wmm.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.zurragamez.wmm.common.WeirdMobsMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityBigEar extends EntityTameable {

    private float field_70926_e;
    private float field_70924_f;
    private boolean necklace;
    private String ownerName;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwner(String name) {
        ownerName = name;
    }

    public EntityBigEar(World par1World) {
        super(par1World);
        this.setSize(0.6F, 1.3F);
        this.getNavigator()
            .setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.25D);
        if (this.isTamed()) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
                .setBaseValue(20.0D);
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
                .setBaseValue(8.0D);
        }

    }

    public boolean isAIEnabled() {
        return true;
    }

    public Item getDropItem() {
        return WeirdMobsMod.bigEarSkin;
    }

    public void setAttackTarget(EntityLivingBase par1EntityLivingBase) {
        super.setAttackTarget(par1EntityLivingBase);
        if (par1EntityLivingBase == null) {
            this.setAngry(false);
        } else if (!this.isTamed()) {
            this.setAngry(true);
        }

    }

    protected void updateAITick() {
        this.dataWatcher.updateObject(18, this.getHealth());
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(18, new Float(this.getHealth()));
        this.dataWatcher.addObject(19, new Byte((byte) 0));
        this.dataWatcher.addObject(20, new Byte((byte) BlockColored.func_150032_b(1)));
        this.dataWatcher.addObject(24, new Byte((byte) 0));
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        this.playSound("mob.wolf.step", 0.15F, 1.0F);
    }

    protected String getLivingSound() {
        return "WeirdMobsMod:bigear.living";
    }

    protected String getHurtSound() {
        return "WeirdMobsMod:bigear.hurt";
    }

    protected String getDeathSound() {
        return "WeirdMobsMod:bigear.death";
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    public void onUpdate() {
        super.onUpdate();
        this.field_70924_f = this.field_70926_e;
        if (this.func_70922_bv()) {
            this.field_70926_e += (1.0F - this.field_70926_e) * 0.4F;
        } else {
            this.field_70926_e += (0.0F - this.field_70926_e) * 0.4F;
        }

        if (this.func_70922_bv()) {
            this.numTicksToChaseTarget = 10;
        }

        if (!this.isTamed() && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }

    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        if (this.isEntityInvulnerable()) {
            return false;
        } else {
            Entity entity = par1DamageSource.getEntity();
            this.aiSit.setSitting(false);
            if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
                par2 = (par2 + 1.0F) / 2.0F;
            }

            return super.attackEntityFrom(par1DamageSource, par2);
        }
    }

    public boolean attackEntityAsMob(Entity par1Entity) {
        int i = this.isTamed() ? 4 : 2;
        return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) i);
    }

    public void setTamed(boolean par1) {
        super.setTamed(par1);
        if (par1) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
                .setBaseValue(20.0D);
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
                .setBaseValue(8.0D);
        }

    }

    public boolean interact(EntityPlayer par1EntityPlayer) {
        ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
        if (this.isTamed()) {
            if (par1EntityPlayer.getCommandSenderName()
                .equalsIgnoreCase(this.getOwnerName()) && !this.worldObj.isRemote
                && !this.isHealingFood(itemstack)) {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.setPathToEntity((PathEntity) null);
                this.setTarget((Entity) null);
                this.setAttackTarget((EntityLivingBase) null);
                if (itemstack != null && itemstack.getItem() == WeirdMobsMod.necklace && !this.hasNecklace()) {
                    if (--itemstack.stackSize <= 0) {
                        itemstack = null;
                    }

                    this.setNecklace(true);
                }

                if (par1EntityPlayer.isSneaking() && this.hasNecklace()) {
                    this.setNecklace(false);
                    if (!par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(WeirdMobsMod.necklace))) {
                        par1EntityPlayer
                            .dropPlayerItemWithRandomChoice(new ItemStack(WeirdMobsMod.necklace, 1, 0), false);
                    }
                }
            } else if (this.isHealingFood(itemstack) && !this.worldObj.isRemote
                && this.getHealth() < this.getMaxHealth()) {
                    this.setHealth(this.getHealth() + 4.0F);
                    if (--itemstack.stackSize <= 0 && !par1EntityPlayer.capabilities.isCreativeMode) {
                        itemstack = null;
                    }

                    return true;
                }
        } else if (itemstack != null && itemstack.getItem() == Items.gold_ingot && !this.worldObj.isRemote) {
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                --itemstack.stackSize;
            }

            if (itemstack.stackSize <= 0) {
                par1EntityPlayer.inventory
                    .setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack) null);
            }

            if (!this.worldObj.isRemote) {
                if (this.rand.nextInt(3) == 0) {
                    this.setTamed(true);
                    this.setPathToEntity((PathEntity) null);
                    this.setAttackTarget((EntityLivingBase) null);
                    this.setHealth(20.0F);
                    this.setOwner(par1EntityPlayer.getCommandSenderName());
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte) 7);
                } else {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState(this, (byte) 6);
                }
            }

            return true;
        }

        return super.interact(par1EntityPlayer);
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte par1) {
        super.handleHealthUpdate(par1);
    }

    public int getMaxSpawnedInChunk() {
        return 8;
    }

    public void readEntityFromNBT(NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);
        this.setNecklace(nbt.getBoolean("Test"));
    }

    public void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
        nbt.setBoolean("Test", this.hasNecklace());
    }

    public boolean isAngry() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
    }

    public boolean hasNecklace() {
        return this.necklace;
    }

    public void setAngry(boolean par1) {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);
        if (par1) {
            this.dataWatcher.updateObject(16, (byte) (b0 | 2));
        } else {
            this.dataWatcher.updateObject(16, (byte) (b0 & -3));
        }

    }

    public void setNecklace(boolean par1) {
        this.necklace = par1;
        if (par1) {
            this.dataWatcher.updateObject(24, (byte) 1);
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
                .setBaseValue(30.0D);
            this.setHealth(this.getMaxHealth());
        } else {
            this.dataWatcher.updateObject(24, (byte) 0);
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
                .setBaseValue(20.0D);
            if (this.getHealth() > this.getMaxHealth()) {
                this.setHealth(this.getMaxHealth());
            }
        }

    }

    private boolean isHealingFood(ItemStack item) {
        if (item != null) {
            return item.getItem() == Items.apple;
        } else {
            return false;
        }
    }

    public boolean func_70922_bv() {
        return this.dataWatcher.getWatchableObjectByte(19) == 1;
    }

    protected boolean canDespawn() {
        return !this.isTamed() && this.ticksExisted > 2400;
    }

    public boolean func_142018_a(EntityLivingBase par1EntityLivingBase, EntityLivingBase par2EntityLivingBase) {
        if (!(par1EntityLivingBase instanceof EntityCreeper) && !(par1EntityLivingBase instanceof EntityGhast)) {
            if (par1EntityLivingBase instanceof EntityBigEar) {
                EntityBigEar entitybigear = (EntityBigEar) par1EntityLivingBase;
                if (entitybigear.isTamed() && entitybigear.getOwner() == par2EntityLivingBase) {
                    return false;
                }
            }

            return par1EntityLivingBase instanceof EntityPlayer && par2EntityLivingBase instanceof EntityPlayer
                && !((EntityPlayer) par2EntityLivingBase).canAttackPlayer((EntityPlayer) par1EntityLivingBase) ? false
                    : !(par1EntityLivingBase instanceof EntityHorse) || !((EntityHorse) par1EntityLivingBase).isTame();
        } else {
            return false;
        }
    }

    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }
}
