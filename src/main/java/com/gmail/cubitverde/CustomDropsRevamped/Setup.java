package com.gmail.cubitverde.CustomDropsRevamped;

import java.util.ArrayList;
import java.util.LinkedList;
import org.bukkit.Material;
import org.bukkit.FireworkEffect.Type;

public class Setup {
   static void setupMobIcons(String var0) {
      if (var0.contains("1.16")) {
         CustomDropsRevamped.mobIcons.put("Bat", Material.BAT_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Bee", Material.BEE_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Blaze", Material.BLAZE_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Cat", Material.CAT_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Cave Spider", Material.CAVE_SPIDER_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Chicken", Material.CHICKEN_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Cod", Material.COD_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Cow", Material.COW_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Creeper", Material.CREEPER_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Dolphin", Material.DOLPHIN_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Donkey", Material.DONKEY_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Drowned", Material.DROWNED_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Elder Guardian", Material.ELDER_GUARDIAN_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Ender Dragon", Material.DRAGON_HEAD);
         CustomDropsRevamped.mobIcons.put("Enderman", Material.ENDERMAN_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Endermite", Material.ENDERMITE_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Evoker", Material.EVOKER_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Fox", Material.FOX_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Ghast", Material.GHAST_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Giant", Material.ZOMBIE_HEAD);
         CustomDropsRevamped.mobIcons.put("Guardian", Material.GUARDIAN_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Hoglin", Material.HOGLIN_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Horse", Material.HORSE_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Husk", Material.HUSK_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Iron Golem", Material.IRON_BLOCK);
         CustomDropsRevamped.mobIcons.put("Llama", Material.LLAMA_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Magma Cube", Material.MAGMA_CUBE_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Mule", Material.MULE_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Mushroom Cow", Material.MOOSHROOM_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Ocelot", Material.OCELOT_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Panda", Material.PANDA_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Parrot", Material.PARROT_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Phantom", Material.PHANTOM_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Pig", Material.PIG_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Piglin", Material.PIGLIN_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Piglin Brute", Material.PIGLIN_BRUTE_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Pillager", Material.PILLAGER_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Polar Bear", Material.POLAR_BEAR_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Pufferfish", Material.PUFFERFISH_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Rabbit", Material.RABBIT_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Ravager", Material.RAVAGER_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Salmon", Material.SALMON_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Sheep", Material.SHEEP_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Shulker", Material.SHULKER_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Silverfish", Material.SILVERFISH_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Skeleton", Material.SKELETON_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Skeleton Horse", Material.SKELETON_HORSE_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Slime", Material.SLIME_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Snowman", Material.SNOW_BLOCK);
         CustomDropsRevamped.mobIcons.put("Spider", Material.SPIDER_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Squid", Material.SQUID_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Stray", Material.STRAY_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Strider", Material.STRIDER_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Trader Llama", Material.TRADER_LLAMA_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Tropical Fish", Material.TROPICAL_FISH_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Turtle", Material.TURTLE_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Vex", Material.VEX_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Villager", Material.VILLAGER_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Vindicator", Material.VINDICATOR_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Wandering Trader", Material.WANDERING_TRADER_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Witch", Material.WITCH_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Wither", Material.WITHER_SKELETON_SKULL);
         CustomDropsRevamped.mobIcons.put("Wither Skeleton", Material.WITHER_SKELETON_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Wolf", Material.WOLF_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Zoglin", Material.ZOGLIN_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Zombie", Material.ZOMBIE_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Zombie Horse", Material.ZOMBIE_HORSE_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Zombie Villager", Material.ZOMBIE_VILLAGER_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Zombified Piglin", Material.ZOMBIFIED_PIGLIN_SPAWN_EGG);
      } else if (var0.contains("1.17")) {
         setupMobIcons("1.16");
         CustomDropsRevamped.mobIcons.put("Axolotl", Material.AXOLOTL_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Glow Squid", Material.GLOW_SQUID_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Goat", Material.GOAT_SPAWN_EGG);
      } else if (var0.contains("1.18")) {
         setupMobIcons("1.17");
      } else if (var0.contains("1.19")) {
         setupMobIcons("1.18");
         CustomDropsRevamped.mobIcons.put("Allay", Material.ALLAY_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Frog", Material.FROG_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Tadpole", Material.TADPOLE_SPAWN_EGG);
         CustomDropsRevamped.mobIcons.put("Warden", Material.WARDEN_SPAWN_EGG);
      }

   }

   static void setupDefaultConditions() {
      CustomDropsRevamped.defaultConditions.setMobName("josh");
      CustomDropsRevamped.defaultConditions.setCheckMobName(false);
      CustomDropsRevamped.defaultConditions.setPermission("droppermission.get");
      CustomDropsRevamped.defaultConditions.setCheckPermission(false);
      CustomDropsRevamped.defaultConditions.setItemUsed(Utilities.CreateItem(Material.DIAMOND_SWORD, "Drops sword"));
      CustomDropsRevamped.defaultConditions.setCheckItemUsed(false);
      CustomDropsRevamped.defaultConditions.setCheckItemUsedMeta(false);
      CustomDropsRevamped.defaultConditions.setBannedWorlds(new ArrayList());
      CustomDropsRevamped.defaultConditions.setCheckBannedWorlds(false);
      CustomDropsRevamped.defaultConditions.setMinPlayers(1);
      CustomDropsRevamped.defaultConditions.setCheckMinPlayers(false);
      CustomDropsRevamped.defaultConditions.setMaxPlayers(10);
      CustomDropsRevamped.defaultConditions.setCheckMaxPlayers(false);
      CustomDropsRevamped.defaultConditions.setLootingModifier(false);
      CustomDropsRevamped.defaultConditions.setFortuneModifier(false);
   }

   static void setupDefaultDrop() {
      CustomDropsRevamped.defaultDrop.setItem(Utilities.CreateItem(Material.STONE, "New Item"));
      CustomDropsRevamped.defaultDrop.setChance(0.1D);
      CustomDropsRevamped.defaultDrop.setColor("LIME");
      CustomDropsRevamped.defaultDrop.setShape(Type.BURST);
      CustomDropsRevamped.defaultDrop.setEffect(true);
      CustomDropsRevamped.defaultDrop.setDefaultDrops(true);
      CustomDropsRevamped.defaultDrop.setSpawnerDrops(false);
      CustomDropsRevamped.defaultDrop.setEggDrops(false);
      CustomDropsRevamped.defaultDrop.setPlacedDrops(false);
      CustomDropsRevamped.defaultDrop.setConditions(CustomDropsRevamped.defaultConditions);
      CustomDropsRevamped.defaultDrop.setCommands(new LinkedList());
   }

   static void setupDamageables() {
      CustomDropsRevamped.damageables.add(Material.WOODEN_SWORD);
      CustomDropsRevamped.damageables.add(Material.STONE_SWORD);
      CustomDropsRevamped.damageables.add(Material.IRON_SWORD);
      CustomDropsRevamped.damageables.add(Material.GOLDEN_SWORD);
      CustomDropsRevamped.damageables.add(Material.DIAMOND_SWORD);
      CustomDropsRevamped.damageables.add(Material.NETHERITE_SWORD);
      CustomDropsRevamped.damageables.add(Material.WOODEN_AXE);
      CustomDropsRevamped.damageables.add(Material.STONE_AXE);
      CustomDropsRevamped.damageables.add(Material.IRON_AXE);
      CustomDropsRevamped.damageables.add(Material.GOLDEN_AXE);
      CustomDropsRevamped.damageables.add(Material.DIAMOND_AXE);
      CustomDropsRevamped.damageables.add(Material.NETHERITE_AXE);
      CustomDropsRevamped.damageables.add(Material.WOODEN_PICKAXE);
      CustomDropsRevamped.damageables.add(Material.STONE_PICKAXE);
      CustomDropsRevamped.damageables.add(Material.IRON_PICKAXE);
      CustomDropsRevamped.damageables.add(Material.GOLDEN_PICKAXE);
      CustomDropsRevamped.damageables.add(Material.DIAMOND_PICKAXE);
      CustomDropsRevamped.damageables.add(Material.NETHERITE_PICKAXE);
      CustomDropsRevamped.damageables.add(Material.WOODEN_SHOVEL);
      CustomDropsRevamped.damageables.add(Material.STONE_SHOVEL);
      CustomDropsRevamped.damageables.add(Material.IRON_SHOVEL);
      CustomDropsRevamped.damageables.add(Material.GOLDEN_SHOVEL);
      CustomDropsRevamped.damageables.add(Material.DIAMOND_SHOVEL);
      CustomDropsRevamped.damageables.add(Material.NETHERITE_SHOVEL);
      CustomDropsRevamped.damageables.add(Material.WOODEN_HOE);
      CustomDropsRevamped.damageables.add(Material.STONE_HOE);
      CustomDropsRevamped.damageables.add(Material.IRON_HOE);
      CustomDropsRevamped.damageables.add(Material.GOLDEN_HOE);
      CustomDropsRevamped.damageables.add(Material.DIAMOND_HOE);
      CustomDropsRevamped.damageables.add(Material.NETHERITE_HOE);
      CustomDropsRevamped.damageables.add(Material.TRIDENT);
      CustomDropsRevamped.damageables.add(Material.SHEARS);
   }

   static void setupCrops() {
      CustomDropsRevamped.itemToCrop.put(Material.POTATO, Material.POTATOES);
      CustomDropsRevamped.itemToCrop.put(Material.BEETROOT, Material.BEETROOTS);
      CustomDropsRevamped.itemToCrop.put(Material.CARROT, Material.CARROTS);
      CustomDropsRevamped.itemToCrop.put(Material.COCOA_BEANS, Material.COCOA);
      CustomDropsRevamped.cropToItem.put(Material.POTATOES, Material.POTATO);
      CustomDropsRevamped.cropToItem.put(Material.BEETROOTS, Material.BEETROOT);
      CustomDropsRevamped.cropToItem.put(Material.CARROTS, Material.CARROT);
      CustomDropsRevamped.cropToItem.put(Material.COCOA, Material.COCOA_BEANS);
   }
}
