package com.zurragamez.wmm.block;

import com.zurragamez.wmm.entity.EntityTerrorTrickster;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockTerrorTricksterBlock extends Block {
   public BlockTerrorTricksterBlock(int i, Material p_i45394_1_) {
      super(p_i45394_1_);
      this.setCreativeTab(CreativeTabs.tabBlock);
   }

   @SideOnly(Side.CLIENT)
   public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
      return Blocks.stone.getBlockTextureFromSide(p_149691_1_);
   }

   public void onBlockDestroyedByPlayer(World p_149664_1_, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_) {
      if (!p_149664_1_.isRemote) {
         EntityTerrorTrickster terrortrickster = new EntityTerrorTrickster(p_149664_1_);
         terrortrickster.setLocationAndAngles((double)p_149664_2_ + 0.5D, (double)p_149664_3_, (double)p_149664_4_ + 0.5D, 0.0F, 0.0F);
         p_149664_1_.spawnEntityInWorld(terrortrickster);
         terrortrickster.spawnExplosionParticle();
      }

      super.onBlockDestroyedByPlayer(p_149664_1_, p_149664_2_, p_149664_3_, p_149664_4_, p_149664_5_);
   }
}
