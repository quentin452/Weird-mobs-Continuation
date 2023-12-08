package com.zurragamez.wmm.common;

import com.zurragamez.wmm.block.BlockTerrorTricksterBlock;
import com.zurragamez.wmm.entity.*;
import com.zurragamez.wmm.item.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.EnumHelper;

import java.util.List;

@Mod(modid = "Weird Mobs Mod 2", name = "Weird Mobs Mod", version = "2 Alpha 3")
public class WeirdMobsMod {

    @SidedProxy(
        clientSide = "com.zurragamez.wmm.common.ClientProxy",
        serverSide = "com.zurragamez.wmm.common.CommonProxy")
    public static CommonProxy proxy;
    public static boolean bigEarHasInitialized;
    public static int witherCreeperID = 299;
    private static int entityIdBase = 300;
    private static int BA1;
    private static int BA2;
    private static int BA3;
    private static int BA4;
    public static final ArmorMaterial bigEarArmor = EnumHelper
        .addArmorMaterial("BIGEARARMOR", 15, new int[] { 2, 4, 3, 1 }, 10);
    public static final ArmorMaterial stickManArmor = EnumHelper
        .addArmorMaterial("STICKMANARMOR", 1, new int[] { 1, 1, 1, 1 }, 0);
    public static final ToolMaterial potionStickTool = EnumHelper
        .addToolMaterial("POTIONSTICKTOOL", 0, 20, -3.0F, 0.0F, 10);
    public static final Item netherStarPiece = (new ItemNetherStarPiece(1000)).setUnlocalizedName("NetherStarPiece")
        .setTextureName("WeirdMobsMod:netherStarPiece");
    public static final Item bigEarSkin = (new ItemBigEarSkin(1001)).setUnlocalizedName("BigEarSkin")
        .setTextureName("WeirdMobsMod:bigEarSkin");
    public static final Item fly = (new ItemFly(1002)).setUnlocalizedName("Fly")
        .setTextureName("WeirdMobsMod:fly");
    public static final Item potionStick;
    public static final Item bigEarArmorHelmet;
    public static final Item bigEarArmorChestplate;
    public static final Item bigEarArmorLeggings;
    public static final Item bigEarArmorBoots;
    public static final Item stickManHead;
    public static final Item necklace;
    public static final Item crystal;
    public static final Item spawnWitherCreeper;
    public static final Item evilFly;
    public static final Item crazyBirdRaw;
    public static final Item crazyBirdCooked;
    public static final Item fatManRaw;
    public static final Item fatManCooked;
    public static final Block terrorTricksterBlock;

    public WeirdMobsMod() {
        GameRegistry.registerItem(netherStarPiece, "Nether Star Piece");
        GameRegistry.registerItem(bigEarSkin, "Big Ear Skin");
        GameRegistry.registerItem(fly, "Fly");
        GameRegistry.registerItem(potionStick, "Potion Stick");
        GameRegistry.registerItem(bigEarArmorHelmet, "Big Ear Armor Helmet");
        GameRegistry.registerItem(bigEarArmorChestplate, "Big Ear Armor Chestplate");
        GameRegistry.registerItem(bigEarArmorLeggings, "Big Ear Armor Leggings");
        GameRegistry.registerItem(bigEarArmorBoots, "Big Ear Armor Boots");
        GameRegistry.registerItem(necklace, "BigEar Necklace");
        GameRegistry.registerItem(crystal, "Crystal");
        GameRegistry.registerItem(spawnWitherCreeper, "Spawn Wither Creeper");
        GameRegistry.registerItem(evilFly, "Evil Fly");
        GameRegistry.registerItem(crazyBirdRaw, "Raw Crazy Bird");
        GameRegistry.registerItem(crazyBirdCooked, "Cooked Crazy Bird");
        GameRegistry.registerItem(fatManRaw, "Raw Fat Man");
        GameRegistry.registerItem(fatManCooked, "Cooked Fat Man");
        GameRegistry.registerItem(stickManHead, "Stick Man Head");
        GameRegistry.addRecipe(
            new ItemStack(Items.nether_star),
            new Object[] { " N ", "NDN", " N ", 'N', netherStarPiece, 'D', Items.diamond });
        GameRegistry.addRecipe(new ItemStack(Blocks.dirt), new Object[] { "FFF", "FFF", "FFF", 'F', fly });
        GameRegistry.addRecipe(
            new ItemStack(potionStick, 2),
            new Object[] { " P ", "S#W", " # ", 'P', new ItemStack(Items.potionitem, 1, 8196), 'S',
                new ItemStack(Items.potionitem, 1, 8234), 'W', new ItemStack(Items.potionitem, 1, 8232), '#',
                Items.stick });
        GameRegistry.addRecipe(new ItemStack(bigEarArmorHelmet), new Object[] { "BBB", "B B", 'B', bigEarSkin });
        GameRegistry
            .addRecipe(new ItemStack(bigEarArmorChestplate), new Object[] { "B B", "BBB", "BBB", 'B', bigEarSkin });
        GameRegistry
            .addRecipe(new ItemStack(bigEarArmorLeggings), new Object[] { "BBB", "B B", "B B", 'B', bigEarSkin });
        GameRegistry.addRecipe(new ItemStack(bigEarArmorBoots), new Object[] { "B B", "B B", 'B', bigEarSkin });
        GameRegistry.addRecipe(new ItemStack(crystal), new Object[] { "ede", 'e', Items.emerald, 'd', Items.diamond });
        GameRegistry.addRecipe(
            new ItemStack(necklace),
            new Object[] { " s ", "sgs", " c ", 's', Items.string, 'g', Items.gold_ingot, 'c', crystal });
        GameRegistry.addRecipe(
            new ItemStack(spawnWitherCreeper),
            new Object[] { "fff", "bgb", "fff", 'f', evilFly, 'b', Items.blaze_rod, 'g', Items.gold_ingot });
        GameRegistry.addRecipe(
            new ItemStack(evilFly),
            new Object[] { "nsn", "sfs", "nsn", 'f', fly, 'n', Items.nether_wart, 's', Items.spider_eye });
        GameRegistry.addSmelting(crazyBirdRaw, new ItemStack(crazyBirdCooked), 2.0F);
        GameRegistry.addSmelting(fatManRaw, new ItemStack(fatManCooked), 2.0F);
        EntityRegistry.registerGlobalEntityID(EntityBigEar.class, "Big Ear", EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntityBigEar.class, 1, 1, 1, EnumCreatureType.monster);
        this.registerSpawnEgg(EntityBigEar.class, 789516, 16712704);
        EntityRegistry
            .registerGlobalEntityID(EntityBigFish.class, "Big Fish", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.addSpawn(
            EntityBigFish.class,
            70,
            5,
            15,
            EnumCreatureType.waterCreature,
            new BiomeGenBase[] { BiomeGenBase.ocean });
        this.registerSpawnEgg(EntityBigFish.class, 3227729, 5316640);
        EntityRegistry
            .registerGlobalEntityID(EntityBUDRBot.class, "BUDR Bot", EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntityBUDRBot.class, 70, 2, 6, EnumCreatureType.creature);
        this.registerSpawnEgg(EntityBUDRBot.class, 6182967, 16577861);
        EntityRegistry.registerGlobalEntityID(
            EntityButterMonger.class,
            "Butter Monger",
            EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntityButterMonger.class, 70, 2, 6, EnumCreatureType.monster);
        this.registerSpawnEgg(EntityButterMonger.class, 12691762, 1446661);
        EntityRegistry
            .registerGlobalEntityID(EntityCoohBird.class, "Cooh Bird", EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntityCoohBird.class, 70, 2, 6, EnumCreatureType.creature);
        this.registerSpawnEgg(EntityCoohBird.class, 11879680, 5517082);
        EntityRegistry
            .registerGlobalEntityID(EntityCrazyBird.class, "Crazy Bird", EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntityCrazyBird.class, 70, 2, 6, EnumCreatureType.creature);
        this.registerSpawnEgg(EntityCrazyBird.class, 9276813, 16350478);
        EntityRegistry
            .registerGlobalEntityID(EntityCyclopsMan.class, "Cyclops Man", EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntityCyclopsMan.class, 70, 2, 6, EnumCreatureType.monster);
        this.registerSpawnEgg(EntityCyclopsMan.class, 12018726, 8618883);
        EntityRegistry.registerGlobalEntityID(
            EntityDistortedMan.class,
            "Distorted Man",
            EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntityDistortedMan.class, 70, 2, 6, EnumCreatureType.monster);
        this.registerSpawnEgg(EntityDistortedMan.class, 16756613, 7839281);
        EntityRegistry
            .registerGlobalEntityID(EntityFatFish.class, "Fat Fish", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.addSpawn(
            EntityFatFish.class,
            70,
            5,
            15,
            EnumCreatureType.waterCreature,
            new BiomeGenBase[] { BiomeGenBase.ocean });
        this.registerSpawnEgg(EntityFatFish.class, 8026746, 5987163);
        EntityRegistry.registerGlobalEntityID(EntityFatMan.class, "Fat Man", EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntityFatMan.class, 70, 2, 6, EnumCreatureType.monster);
        this.registerSpawnEgg(EntityFatMan.class, 12027505, 10905148);
        EntityRegistry
            .registerGlobalEntityID(EntityGooftile.class, "Gooftile", EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntityGooftile.class, 70, 2, 6, EnumCreatureType.creature);
        this.registerSpawnEgg(EntityGooftile.class, 3045098, 793659);
        EntityRegistry
            .registerGlobalEntityID(EntityKnifeMan.class, "Knife Man", EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntityKnifeMan.class, 70, 2, 6, EnumCreatureType.monster);
        this.registerSpawnEgg(EntityKnifeMan.class, 4605510, 7286832);
        EntityRegistry
            .registerGlobalEntityID(EntityPotionStick.class, "Potion Stick", EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntityPotionStick.class, 70, 2, 6, EnumCreatureType.monster);
        this.registerSpawnEgg(EntityPotionStick.class, 1622287, 6703385);
        EntityRegistry.registerGlobalEntityID(
            EntitySpiderCreeper.class,
            "Spider Creeper",
            EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntitySpiderCreeper.class, 70, 2, 6, EnumCreatureType.creature);
        this.registerSpawnEgg(EntitySpiderCreeper.class, 10230807, 4208688);
        EntityRegistry.registerGlobalEntityID(
            EntitySpinningFeets.class,
            "Spinning Feets",
            EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntitySpinningFeets.class, 70, 2, 6, EnumCreatureType.creature);
        this.registerSpawnEgg(EntitySpinningFeets.class, 2960685, 11696970);
        EntityRegistry
            .registerGlobalEntityID(EntityStickMan.class, "Stick Man", EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntityStickMan.class, 70, 2, 6, EnumCreatureType.creature);
        this.registerSpawnEgg(EntityStickMan.class, 16777215, 0);
        EntityRegistry.registerGlobalEntityID(
            EntityStickManBaby.class,
            "Stick Man Baby",
            EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry
            .registerGlobalEntityID(EntityTallMan.class, "Tall Man", EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntityTallMan.class, 70, 2, 6, EnumCreatureType.monster);
        this.registerSpawnEgg(EntityTallMan.class, 5329492, 15456628);
        EntityRegistry.registerGlobalEntityID(
            EntityTerrorTrickster.class,
            "Terror Trickster",
            EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawnOverWorld(EntityTerrorTrickster.class, 1, 2, 6, EnumCreatureType.ambient);
        this.registerSpawnEgg(EntityTerrorTrickster.class, 13027014, 14803425);
        EntityRegistry
            .registerGlobalEntityID(EntityTrinitope.class, "Trinitope", EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntityTrinitope.class, 70, 2, 6, EnumCreatureType.monster);
        this.registerSpawnEgg(EntityTrinitope.class, 8323072, 15687424);
        EntityRegistry
            .registerGlobalEntityID(EntityVestCreeper.class, "Vest Creeper", EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntityVestCreeper.class, 70, 2, 6, EnumCreatureType.monster);
        this.registerSpawnEgg(EntityVestCreeper.class, 6213708, 14369818);
        EntityRegistry.registerGlobalEntityID(
            EntityVillagerHead.class,
            "Villager Head",
            EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntityVillagerHead.class, 70, 2, 6, EnumCreatureType.monster);
        this.registerSpawnEgg(EntityVillagerHead.class, 12422002, 10335591);
        EntityRegistry.registerGlobalEntityID(
            EntityWalkingPainting.class,
            "Walking Painting",
            EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntityWalkingPainting.class, 70, 2, 6, EnumCreatureType.creature);
        this.registerSpawnEgg(EntityWalkingPainting.class, 18573, 4862504);
        EntityRegistry.registerGlobalEntityID(
            EntityWalkingRadio.class,
            "Walking Radio",
            EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawn(EntityWalkingRadio.class, 70, 2, 6, EnumCreatureType.creature);
        this.registerSpawnEgg(EntityWalkingRadio.class, 6250335, 16646915);
        EntityRegistry.registerGlobalEntityID(
            EntityWitherCreeper.class,
            "Wither Creeper",
            EntityRegistry.findGlobalUniqueEntityId());
        this.registerSpawnEgg(EntityWitherCreeper.class, 4671303, 12698049);
    }

    private void registerSpawnEgg(Class entity, int i, int j) {
        int id = this.getUniqueEntityId();
        EntityList.IDtoClassMapping.put(id, entity);
        EntityList.entityEggs.put(id, new EntityEggInfo(id, i, j));
    }

    private int getUniqueEntityId() {
        do {
            ++entityIdBase;
        } while (EntityList.getStringFromID(entityIdBase) != null);

        return entityIdBase++;
    }

    public void registerSpawn(Class c, int spawnNumber, int min, int max, EnumCreatureType type) {
        for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; ++i) {
            if (BiomeGenBase.getBiomeGenArray()[i] != null && (BiomeGenBase.getBiomeGenArray()[i] != BiomeGenBase.ocean
                || BiomeGenBase.getBiomeGenArray()[i] != BiomeGenBase.river)) {
                EntityRegistry.addSpawn(
                    c,
                    spawnNumber,
                    min,
                    max,
                    type,
                        BiomeGenBase.getBiomeGenArray()[i]);
            }
        }

    }
    @SuppressWarnings("unchecked")
    public void registerSpawnOverWorld(Class<?> entityClass, int spawnNumber, int min, int max, EnumCreatureType type) {
        for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; ++i) {
            BiomeGenBase biome = BiomeGenBase.getBiomeGenArray()[i];
            if(biome != null && biome.biomeID < 128 && contains(biome) && entityClass != null) {
                addSpawnOverworld((Class<? extends EntityLiving>) entityClass, spawnNumber, min, max, type, biome);
            }
        }
    }
    public boolean contains(BiomeGenBase biome) {
        for(BiomeGenBase authBiome : biomeListWhiteslistedbiomes) {
            if(authBiome == biome) {
                return true;
            }
        }
        return false;
    }

    BiomeGenBase[] biomeListWhiteslistedbiomes = {
        BiomeGenBase.forest,
        BiomeGenBase.plains,
        BiomeGenBase.forestHills,
        BiomeGenBase.taiga,
        BiomeGenBase.taigaHills,
        BiomeGenBase.swampland,
        BiomeGenBase.extremeHills,
        BiomeGenBase.jungle,
        BiomeGenBase.jungleEdge,
        BiomeGenBase.jungleHills,
        BiomeGenBase.beach,
        BiomeGenBase.mesa,
        BiomeGenBase.mesaPlateau,
        BiomeGenBase.mushroomIsland,
    };

    public static void addSpawnOverworld(Class<? extends EntityLiving> entityClass, int weightedProb, int min, int max, EnumCreatureType typeOfCreature, BiomeGenBase... biomes) {
        for (BiomeGenBase biome : biomes) {
            if (biome != BiomeGenBase.hell) {
                @SuppressWarnings("unchecked")
                List<BiomeGenBase.SpawnListEntry> spawns = biome.getSpawnableList(typeOfCreature);
                boolean found = false;
                for (BiomeGenBase.SpawnListEntry entry : spawns) {
                    if (entry.entityClass == entityClass) {
                        entry.itemWeight = weightedProb;
                        entry.minGroupCount = min;
                        entry.maxGroupCount = max;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    spawns.add(new BiomeGenBase.SpawnListEntry(entityClass, weightedProb, min, max));
                }
            }
        }
    }


    @EventHandler
    public void load(FMLInitializationEvent e) {
        proxy.RenderInformation();
    }

    static {
        potionStick = (new ItemPotionStick(1003, potionStickTool)).setUnlocalizedName("PotionStick")
            .setTextureName("WeirdMobsMod:potion_stick");
        bigEarArmorHelmet = (new ItemBigEarArmor(bigEarArmor, BA1, 0)).setUnlocalizedName("BigEarHelmet")
            .setTextureName("WeirdMobsMod:BigEarArmorHelmet");
        bigEarArmorChestplate = (new ItemBigEarArmor(bigEarArmor, BA2, 1)).setUnlocalizedName("BigEarChestplate")
            .setTextureName("WeirdMobsMod:BigEarArmorChestplate");
        bigEarArmorLeggings = (new ItemBigEarArmor(bigEarArmor, BA3, 2)).setUnlocalizedName("BigEarLeggings")
            .setTextureName("WeirdMobsMod:BigEarArmorLeggings");
        bigEarArmorBoots = (new ItemBigEarArmor(bigEarArmor, BA4, 3)).setUnlocalizedName("BigEarBoots")
            .setTextureName("WeirdMobsMod:BigEarArmorBoots");
        stickManHead = (new ItemStickManHead(stickManArmor, 1, 0)).setUnlocalizedName("Stick Man Head")
            .setTextureName("WeirdMobsMod:stickManHead");
        necklace = (new ItemNecklace(1004)).setUnlocalizedName("Necklace")
            .setTextureName("WeirdMobsMod:necklace");
        crystal = (new ItemCrystal(1005)).setUnlocalizedName("Crystal")
            .setTextureName("WeirdMobsMod:crystal");
        spawnWitherCreeper = (new ItemSpawnWitherCreeper(1006)).setUnlocalizedName("Spawn Wither Creeper")
            .setTextureName("WeirdMobsMod:spawnWitherCreeper");
        evilFly = (new ItemFly(1007)).setUnlocalizedName("Evil Fly")
            .setTextureName("WeirdMobsMod:evil_fly");
        crazyBirdRaw = (new ItemRawFood(1008, 2, false)).setUnlocalizedName("Raw Crazy Bird")
            .setTextureName("WeirdMobsMod:rawCrazyBird");
        crazyBirdCooked = (new ItemCookedFood(1009, 6, false)).setUnlocalizedName("Cooked Crazy Bird")
            .setTextureName("WeirdMobsMod:cookedCrazyBird");
        fatManRaw = (new ItemRawFood(1010, 2, false)).setUnlocalizedName("Raw Fat Man")
            .setTextureName("WeirdMobsMod:rawFatMan");
        fatManCooked = (new ItemCookedFood(1011, 6, false)).setUnlocalizedName("Cooked Fat Man")
            .setTextureName("WeirdMobsMod:cookedFatMan");
        terrorTricksterBlock = (new BlockTerrorTricksterBlock(300, Material.grass)).setBlockName("TerrorTricksterBlock")
            .setBlockTextureName("stone");
    }
}
