package com.zurragamez.wmm.item;

import com.zurragamez.wmm.common.WeirdMobsMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ItemStickManHead extends ItemArmor {
   public ItemStickManHead(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
      super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
      this.setCreativeTab(CreativeTabs.tabCombat);
   }

   public String getArmorTexture(ItemStack item, Entity e, int slot, String type) {
      if (item.getItem() == WeirdMobsMod.stickManHead) {
         System.out.println("Finding Texture!");
         return "WeirdMobsMod:textures/models/armor/StickManArmor.png";
      } else {
         return null;
      }
   }
}
