package com.zurragamez.wmm.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemPotionStick extends ItemSword {
   public ItemPotionStick(int i, ToolMaterial p_i45356_1_) {
      super(p_i45356_1_);
   }

   public boolean onLeftClickEntity(ItemStack item, EntityPlayer player, Entity entity) {
      if (entity != null && item != null && item.getItem() == this) {
         ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.weakness.id, 300, 0));
         ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 300, 0));
         ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 300, 0));
      }

      return false;
   }
}
