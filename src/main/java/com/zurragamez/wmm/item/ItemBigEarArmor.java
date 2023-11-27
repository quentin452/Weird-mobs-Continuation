package com.zurragamez.wmm.item;

import com.zurragamez.wmm.common.WeirdMobsMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ItemBigEarArmor extends ItemArmor {
   public ItemBigEarArmor(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
      super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
      this.setCreativeTab(CreativeTabs.tabCombat);
   }

   public String getArmorTexture(ItemStack item, Entity e, int slot, String type) {
      if (item.getItem() != WeirdMobsMod.bigEarArmorHelmet && item.getItem() != WeirdMobsMod.bigEarArmorChestplate && item.getItem() != WeirdMobsMod.bigEarArmorBoots) {
         return item.getItem() == WeirdMobsMod.bigEarArmorLeggings ? "WeirdMobsMod:textures/models/armor/BigEarArmor_2.png" : null;
      } else {
         System.out.println("Finding Texture!");
         return "WeirdMobsMod:textures/models/armor/BigEarArmor_1.png";
      }
   }
}
