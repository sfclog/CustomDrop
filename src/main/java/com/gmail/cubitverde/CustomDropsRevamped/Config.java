package com.gmail.cubitverde.CustomDropsRevamped;

import com.gmail.cubitverde.CustomDropsRevamped.objects.Block;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Conditions;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Mob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.bukkit.Material;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {
   public static void readConfig(FileConfiguration var0) {
      CustomDropsRevamped.mobIcons = new HashMap();
      CustomDropsRevamped.editedMobs = new ArrayList();
      CustomDropsRevamped.editedBlocks = new LinkedList();
      CustomDropsRevamped.defaultDrop = new Drop();
      CustomDropsRevamped.defaultConditions = new Conditions();
      CustomDropsRevamped.dropId = 0;
      CustomDropsRevamped.damageables = new ArrayList();
      CustomDropsRevamped.itemToCrop = new HashMap();
      Setup.setupMobIcons(CustomDropsRevamped.plugin.getServer().getVersion());
      Setup.setupDefaultConditions();
      Setup.setupDefaultDrop();
      Setup.setupDamageables();
      Setup.setupCrops();
      if (var0.getConfigurationSection("CustomDropsRevamped") != null) {
         Iterator var1;
         String var2;
         Mob var3;
         String var11;
         Iterator var29;
         if (var0.getConfigurationSection("CustomDropsRevamped.editedMobs") != null) {
            for(var1 = var0.getConfigurationSection("CustomDropsRevamped.editedMobs").getKeys(false).iterator(); var1.hasNext(); CustomDropsRevamped.editedMobs.add(var3)) {
               var2 = (String)var1.next();
               var3 = new Mob(Utilities.ConvertMobNameToType(var2));
               var3.setVanillaDrops(var0.getBoolean("CustomDropsRevamped.editedMobs." + var2 + ".vanillaDrops"));
               Iterator var5;
               String var6;
               if (var0.getConfigurationSection("CustomDropsRevamped.editedMobs." + var2 + ".inactiveWorlds") != null) {
                  ArrayList var4 = new ArrayList();
                  var5 = var0.getConfigurationSection("CustomDropsRevamped.editedMobs." + var2 + ".inactiveWorlds").getKeys(false).iterator();

                  while(var5.hasNext()) {
                     var6 = (String)var5.next();
                     var4.add(var0.getString("CustomDropsRevamped.editedMobs." + var2 + ".inactiveWorlds." + var6));
                  }

                  var3.setInactiveWorlds(var4);
               }

               if (var0.getConfigurationSection("CustomDropsRevamped.editedMobs." + var2 + ".drops") != null) {
                  LinkedList var18 = new LinkedList();
                  var5 = var0.getConfigurationSection("CustomDropsRevamped.editedMobs." + var2 + ".drops").getKeys(false).iterator();

                  while(var5.hasNext()) {
                     var6 = (String)var5.next();
                     Drop var7 = new Drop(CustomDropsRevamped.defaultDrop.getItem());
                     var7.setId(Integer.parseInt(var6));
                     var7.setItem(var0.getItemStack("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".item"));
                     var7.setChance(var0.getDouble("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".chance"));
                     var7.setColor(var0.getString("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".color"));
                     var7.setShape(Type.valueOf(var0.getString("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".shape")));
                     var7.setEffect(var0.getBoolean("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".effect"));
                     var7.setDefaultDrops(var0.getBoolean("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".defaultDrops"));
                     var7.setSpawnerDrops(var0.getBoolean("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".spawnerDrops"));
                     var7.setEggDrops(var0.getBoolean("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".eggDrops"));
                     var7.setPlacedDrops(var0.getBoolean("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".placedDrops"));
                     if (var0.getConfigurationSection("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".commands") != null) {
                        LinkedList var8 = new LinkedList();
                        Iterator var9 = var0.getConfigurationSection("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".commands").getKeys(false).iterator();

                        while(var9.hasNext()) {
                           String var10 = (String)var9.next();
                           var8.add(var0.getString("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".commands." + var10));
                        }

                        var7.setCommands(var8);
                     }

                     Conditions var24 = new Conditions(false);
                     var24.setMobName(var0.getString("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".conditions.mobName"));
                     var24.setCheckMobName(var0.getBoolean("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".conditions.checkMobName"));
                     var24.setItemUsed(var0.getItemStack("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".conditions.itemUsed"));
                     var24.setCheckItemUsed(var0.getBoolean("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".conditions.checkItemUsed"));
                     var24.setCheckItemUsedMeta(var0.getBoolean("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".conditions.checkItemUsedMeta"));
                     var24.setPermission(var0.getString("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".conditions.permission"));
                     var24.setCheckPermission(var0.getBoolean("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".conditions.checkPermission"));
                     if (var0.getConfigurationSection("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".conditions.bannedWorlds") != null) {
                        ArrayList var26 = new ArrayList();
                        var29 = var0.getConfigurationSection("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".conditions.bannedWorlds").getKeys(false).iterator();

                        while(var29.hasNext()) {
                           var11 = (String)var29.next();
                           var26.add(var0.getString("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".conditions.bannedWorlds." + var11));
                        }

                        var24.setBannedWorlds(var26);
                     }

                     var24.setCheckBannedWorlds(var0.getBoolean("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".conditions.checkBannedWorlds"));
                     var24.setMinPlayers(var0.getInt("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".conditions.minPlayers"));
                     var24.setCheckMinPlayers(var0.getBoolean("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".conditions.checkMinPlayers"));
                     var24.setMaxPlayers(var0.getInt("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".conditions.maxPlayers"));
                     var24.setCheckMaxPlayers(var0.getBoolean("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".conditions.checkMaxPlayers"));
                     var24.setLootingModifier(var0.getBoolean("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".conditions.lootingModifier"));
                     var24.setFortuneModifier(var0.getBoolean("CustomDropsRevamped.editedMobs." + var2 + ".drops." + var6 + ".conditions.fortuneModifier"));
                     var7.setConditions(var24);
                     var18.add(var7);
                  }

                  var3.setDrops(var18);
               }
            }
         }

         Block var19;
         if (var0.getConfigurationSection("CustomDropsRevamped.editedBlocks") != null) {
            for(var1 = var0.getConfigurationSection("CustomDropsRevamped.editedBlocks").getKeys(false).iterator(); var1.hasNext(); CustomDropsRevamped.editedBlocks.add(var19)) {
               var2 = (String)var1.next();
               Material var16 = Material.valueOf(var2);
               var19 = new Block(var16);
               var19.setVanillaDrops(var0.getBoolean("CustomDropsRevamped.editedBlocks." + var2 + ".vanillaDrops"));
               Iterator var22;
               String var23;
               if (var0.getConfigurationSection("CustomDropsRevamped.editedBlocks." + var2 + ".inactiveWorlds") != null) {
                  ArrayList var20 = new ArrayList();
                  var22 = var0.getConfigurationSection("CustomDropsRevamped.editedBlocks." + var2 + ".inactiveWorlds").getKeys(false).iterator();

                  while(var22.hasNext()) {
                     var23 = (String)var22.next();
                     var20.add(var0.getString("CustomDropsRevamped.editedBlocks." + var2 + ".inactiveWorlds." + var23));
                  }

                  var19.setInactiveWorlds(var20);
               }

               if (var0.getConfigurationSection("CustomDropsRevamped.editedBlocks." + var2 + ".drops") != null) {
                  LinkedList var21 = new LinkedList();
                  var22 = var0.getConfigurationSection("CustomDropsRevamped.editedBlocks." + var2 + ".drops").getKeys(false).iterator();

                  while(var22.hasNext()) {
                     var23 = (String)var22.next();
                     Drop var25 = new Drop(CustomDropsRevamped.defaultDrop.getItem());
                     var25.setId(Integer.parseInt(var23));
                     var25.setItem(var0.getItemStack("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".item"));
                     var25.setChance(var0.getDouble("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".chance"));
                     var25.setColor(var0.getString("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".color"));
                     var25.setShape(Type.valueOf(var0.getString("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".shape")));
                     var25.setEffect(var0.getBoolean("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".effect"));
                     var25.setDefaultDrops(var0.getBoolean("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".defaultDrops"));
                     var25.setSpawnerDrops(var0.getBoolean("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".spawnerDrops"));
                     var25.setEggDrops(var0.getBoolean("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".eggDrops"));
                     var25.setPlacedDrops(var0.getBoolean("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".placedDrops"));
                     if (var0.getConfigurationSection("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".commands") != null) {
                        LinkedList var27 = new LinkedList();
                        var29 = var0.getConfigurationSection("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".commands").getKeys(false).iterator();

                        while(var29.hasNext()) {
                           var11 = (String)var29.next();
                           var27.add(var0.getString("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".commands." + var11));
                        }

                        var25.setCommands(var27);
                     }

                     Conditions var28 = new Conditions(false);
                     var28.setMobName(var0.getString("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".conditions.mobName"));
                     var28.setCheckMobName(var0.getBoolean("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".conditions.checkMobName"));
                     var28.setItemUsed(var0.getItemStack("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".conditions.itemUsed"));
                     var28.setCheckItemUsed(var0.getBoolean("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".conditions.checkItemUsed"));
                     var28.setCheckItemUsedMeta(var0.getBoolean("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".conditions.checkItemUsedMeta"));
                     var28.setPermission(var0.getString("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".conditions.permission"));
                     var28.setCheckPermission(var0.getBoolean("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".conditions.checkPermission"));
                     if (var0.getConfigurationSection("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".conditions.bannedWorlds") != null) {
                        ArrayList var30 = new ArrayList();
                        Iterator var31 = var0.getConfigurationSection("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".conditions.bannedWorlds").getKeys(false).iterator();

                        while(var31.hasNext()) {
                           String var12 = (String)var31.next();
                           var30.add(var0.getString("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".conditions.bannedWorlds." + var12));
                        }

                        var28.setBannedWorlds(var30);
                     }

                     var28.setCheckBannedWorlds(var0.getBoolean("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".conditions.checkBannedWorlds"));
                     var28.setMinPlayers(var0.getInt("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".conditions.minPlayers"));
                     var28.setCheckMinPlayers(var0.getBoolean("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".conditions.checkMinPlayers"));
                     var28.setMaxPlayers(var0.getInt("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".conditions.maxPlayers"));
                     var28.setCheckMaxPlayers(var0.getBoolean("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".conditions.checkMaxPlayers"));
                     var28.setLootingModifier(var0.getBoolean("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".conditions.lootingModifier"));
                     var28.setFortuneModifier(var0.getBoolean("CustomDropsRevamped.editedBlocks." + var2 + ".drops." + var23 + ".conditions.fortuneModifier"));
                     var25.setConditions(var28);
                     var21.add(var25);
                  }

                  var19.setDrops(var21);
               }
            }
         }

         if (var0.getConfigurationSection("CustomDropsRevamped.defaultDrop") != null) {
            CustomDropsRevamped.defaultDrop.setItem(var0.getItemStack("CustomDropsRevamped.defaultDrop.item"));
            CustomDropsRevamped.defaultDrop.setChance(var0.getDouble("CustomDropsRevamped.defaultDrop.chance"));
            CustomDropsRevamped.defaultDrop.setColor(var0.getString("CustomDropsRevamped.defaultDrop.color"));
            CustomDropsRevamped.defaultDrop.setShape(Type.valueOf(var0.getString("CustomDropsRevamped.defaultDrop.shape")));
            CustomDropsRevamped.defaultDrop.setEffect(var0.getBoolean("CustomDropsRevamped.defaultDrop.effect"));
            CustomDropsRevamped.defaultDrop.setDefaultDrops(var0.getBoolean("CustomDropsRevamped.defaultDrop.defaultDrops"));
            CustomDropsRevamped.defaultDrop.setSpawnerDrops(var0.getBoolean("CustomDropsRevamped.defaultDrop.spawnerDrops"));
            CustomDropsRevamped.defaultDrop.setEggDrops(var0.getBoolean("CustomDropsRevamped.defaultDrop.eggDrops"));
            CustomDropsRevamped.defaultDrop.setPlacedDrops(var0.getBoolean("CustomDropsRevamped.defaultDrop.placedDrops"));
            Iterator var15;
            String var17;
            if (var0.getConfigurationSection("CustomDropsRevamped.defaultDrop.commands") != null) {
               LinkedList var13 = new LinkedList();
               var15 = var0.getConfigurationSection("CustomDropsRevamped.defaultDrop.commands").getKeys(false).iterator();

               while(var15.hasNext()) {
                  var17 = (String)var15.next();
                  var13.add(var0.getString("CustomDropsRevamped.defaultDrop.commands." + var17));
               }

               CustomDropsRevamped.defaultDrop.setCommands(var13);
            }

            CustomDropsRevamped.defaultConditions.setMobName(var0.getString("CustomDropsRevamped.defaultDrop.conditions.mobName"));
            CustomDropsRevamped.defaultConditions.setCheckMobName(var0.getBoolean("CustomDropsRevamped.defaultDrop.conditions.checkMobName"));
            CustomDropsRevamped.defaultConditions.setItemUsed(var0.getItemStack("CustomDropsRevamped.defaultDrop.conditions.itemUsed"));
            CustomDropsRevamped.defaultConditions.setCheckItemUsed(var0.getBoolean("CustomDropsRevamped.defaultDrop.conditions.checkItemUsed"));
            CustomDropsRevamped.defaultConditions.setCheckItemUsedMeta(var0.getBoolean("CustomDropsRevamped.defaultDrop.conditions.checkItemUsedMeta"));
            CustomDropsRevamped.defaultConditions.setPermission(var0.getString("CustomDropsRevamped.defaultDrop.conditions.permission"));
            CustomDropsRevamped.defaultConditions.setCheckPermission(var0.getBoolean("CustomDropsRevamped.defaultDrop.conditions.checkPermission"));
            if (var0.getConfigurationSection("CustomDropsRevamped.editedBlocks.defaultDrop.conditions.bannedWorlds") != null) {
               ArrayList var14 = new ArrayList();
               var15 = var0.getConfigurationSection("CustomDropsRevamped.defaultDrop.conditions.bannedWorlds").getKeys(false).iterator();

               while(var15.hasNext()) {
                  var17 = (String)var15.next();
                  var14.add(var0.getString("CustomDropsRevamped.defaultDrop.conditions.bannedWorlds" + var17));
               }

               CustomDropsRevamped.defaultConditions.setBannedWorlds(var14);
            }

            CustomDropsRevamped.defaultConditions.setMinPlayers(var0.getInt("CustomDropsRevamped.defaultDrop.conditions.minPlayers"));
            CustomDropsRevamped.defaultConditions.setCheckMinPlayers(var0.getBoolean("CustomDropsRevamped.defaultDrop.conditions.checkMinPlayers"));
            CustomDropsRevamped.defaultConditions.setMaxPlayers(var0.getInt("CustomDropsRevamped.defaultDrop.conditions.maxPlayers"));
            CustomDropsRevamped.defaultConditions.setCheckMaxPlayers(var0.getBoolean("CustomDropsRevamped.defaultDrop.conditions.checkMaxPlayers"));
            CustomDropsRevamped.defaultConditions.setLootingModifier(var0.getBoolean("CustomDropsRevamped.defaultDrop.conditions.lootingModifier"));
            CustomDropsRevamped.defaultConditions.setFortuneModifier(var0.getBoolean("CustomDropsRevamped.defaultDrop.conditions.fortuneModifier"));
         }

         CustomDropsRevamped.defaultDrop.setConditions(CustomDropsRevamped.defaultConditions);
         CustomDropsRevamped.afkDrops = var0.getBoolean("CustomDropsRevamped.afkDrops");
         CustomDropsRevamped.lootingModifier.setAdditive(var0.getBoolean("CustomDropsRevamped.lootingModifier.isAdditive"));
         CustomDropsRevamped.lootingModifier.setAddition(var0.getDouble("CustomDropsRevamped.lootingModifier.addition"));
         CustomDropsRevamped.lootingModifier.setMultiplication(var0.getDouble("CustomDropsRevamped.lootingModifier.multiplication"));
         CustomDropsRevamped.fortuneModifier.setAdditive(var0.getBoolean("CustomDropsRevamped.fortuneModifier.isAdditive"));
         CustomDropsRevamped.fortuneModifier.setAddition(var0.getDouble("CustomDropsRevamped.fortuneModifier.addition"));
         CustomDropsRevamped.fortuneModifier.setMultiplication(var0.getDouble("CustomDropsRevamped.fortuneModifier.multiplication"));
         if (var0.getConfigurationSection("CustomDropsRevamped.dropId") != null) {
            CustomDropsRevamped.dropId = var0.getInt("CustomDropsRevamped.dropId");
         }
      }

   }

   public static void saveConfig(FileConfiguration var0) {
      var0.set("CustomDropsRevamped", (Object)null);
      var0.set("CustomDropsRevamped.dropId", CustomDropsRevamped.dropId);
      var0.set("CustomDropsRevamped.afkDrops", CustomDropsRevamped.afkDrops);
      var0.set("CustomDropsRevamped.lootingModifier.isAdditive", CustomDropsRevamped.lootingModifier.isAdditive());
      var0.set("CustomDropsRevamped.lootingModifier.addition", CustomDropsRevamped.lootingModifier.getAddition());
      var0.set("CustomDropsRevamped.lootingModifier.multiplication", CustomDropsRevamped.lootingModifier.getMultiplication());
      var0.set("CustomDropsRevamped.fortuneModifier.isAdditive", CustomDropsRevamped.fortuneModifier.isAdditive());
      var0.set("CustomDropsRevamped.fortuneModifier.addition", CustomDropsRevamped.fortuneModifier.getAddition());
      var0.set("CustomDropsRevamped.fortuneModifier.multiplication", CustomDropsRevamped.fortuneModifier.getMultiplication());
      Iterator var1 = CustomDropsRevamped.editedMobs.iterator();

      String var3;
      int var4;
      Iterator var5;
      String var6;
      int var7;
      Iterator var8;
      String var9;
      String var10;
      Drop var16;
      Conditions var18;
      Iterator var19;
      while(var1.hasNext()) {
         Mob var2 = (Mob)var1.next();
         var3 = var2.getType().toString();
         var0.set("CustomDropsRevamped.editedMobs." + var3 + ".vanillaDrops", var2.getVanillaDrops());
         var4 = 0;
         var5 = var2.getInactiveWorlds().iterator();

         while(var5.hasNext()) {
            var6 = (String)var5.next();
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".inactiveWorlds." + var4++, var6);
         }

         var5 = var2.getDrops().iterator();

         while(var5.hasNext()) {
            var16 = (Drop)var5.next();
            var7 = var16.getId();
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".item", var16.getItem());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".chance", var16.getChance());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".color", var16.getColor());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".shape", var16.getShape().toString());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".effect", var16.getEffect());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".defaultDrops", var16.getDefaultDrops());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".spawnerDrops", var16.getSpawnerDrops());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".eggDrops", var16.getEggDrops());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".placedDrops", var16.getPlacedDrops());
            var4 = 0;
            var8 = var16.getCommands().iterator();

            while(var8.hasNext()) {
               var9 = (String)var8.next();
               var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".commands." + var4++, var9);
            }

            var18 = var16.getConditions();
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".conditions.mobName", var18.getMobName());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".conditions.checkMobName", var18.getCheckMobName());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".conditions.itemUsed", var18.getItemUsed());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".conditions.checkItemUsed", var18.getCheckItemUsed());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".conditions.checkItemUsedMeta", var18.getCheckItemUsedMeta());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".conditions.permission", var18.getPermission());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".conditions.checkPermission", var18.getCheckPermission());
            var4 = 0;
            var19 = var18.getBannedWorlds().iterator();

            while(var19.hasNext()) {
               var10 = (String)var19.next();
               var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".conditions.bannedWorlds." + var4++, var10);
            }

            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".conditions.checkBannedWorlds", var18.getCheckBannedWorlds());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".conditions.minPlayers", var18.getMinPlayers());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".conditions.checkMinPlayers", var18.getCheckMinPlayers());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".conditions.maxPlayers", var18.getMaxPlayers());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".conditions.checkMaxPlayers", var18.getCheckMaxPlayers());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".conditions.lootingModifier", var18.getLootingModifier());
            var0.set("CustomDropsRevamped.editedMobs." + var3 + ".drops." + var7 + ".conditions.fortuneModifier", var18.getFortuneModifier());
         }
      }

      var1 = CustomDropsRevamped.editedBlocks.iterator();

      while(var1.hasNext()) {
         Block var12 = (Block)var1.next();
         var3 = var12.getMaterial().toString();
         var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".vanillaDrops", var12.getVanillaDrops());
         var4 = 0;
         var5 = var12.getInactiveWorlds().iterator();

         while(var5.hasNext()) {
            var6 = (String)var5.next();
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".inactiveWorlds." + var4++, var6);
         }

         var5 = var12.getDrops().iterator();

         while(var5.hasNext()) {
            var16 = (Drop)var5.next();
            var7 = var16.getId();
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".item", var16.getItem());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".chance", var16.getChance());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".color", var16.getColor());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".shape", var16.getShape().toString());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".effect", var16.getEffect());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".defaultDrops", var16.getDefaultDrops());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".spawnerDrops", var16.getSpawnerDrops());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".eggDrops", var16.getEggDrops());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".placedDrops", var16.getPlacedDrops());
            var4 = 0;
            var8 = var16.getCommands().iterator();

            while(var8.hasNext()) {
               var9 = (String)var8.next();
               var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".commands." + var4++, var9);
            }

            var18 = var16.getConditions();
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".conditions.mobName", var18.getMobName());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".conditions.checkMobName", var18.getCheckMobName());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".conditions.itemUsed", var18.getItemUsed());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".conditions.checkItemUsed", var18.getCheckItemUsed());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".conditions.checkItemUsedMeta", var18.getCheckItemUsedMeta());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".conditions.permission", var18.getPermission());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".conditions.checkPermission", var18.getCheckPermission());
            var4 = 0;
            var19 = var18.getBannedWorlds().iterator();

            while(var19.hasNext()) {
               var10 = (String)var19.next();
               var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".conditions.bannedWorlds." + var4++, var10);
            }

            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".conditions.checkBannedWorlds", var18.getCheckBannedWorlds());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".conditions.minPlayers", var18.getMinPlayers());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".conditions.checkMinPlayers", var18.getCheckMinPlayers());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".conditions.maxPlayers", var18.getMaxPlayers());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".conditions.checkMaxPlayers", var18.getCheckMaxPlayers());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".conditions.lootingModifier", var18.getLootingModifier());
            var0.set("CustomDropsRevamped.editedBlocks." + var3 + ".drops." + var7 + ".conditions.fortuneModifier", var18.getFortuneModifier());
         }
      }

      var0.set("CustomDropsRevamped.defaultDrop.item", CustomDropsRevamped.defaultDrop.getItem());
      var0.set("CustomDropsRevamped.defaultDrop.chance", CustomDropsRevamped.defaultDrop.getChance());
      var0.set("CustomDropsRevamped.defaultDrop.color", CustomDropsRevamped.defaultDrop.getColor());
      var0.set("CustomDropsRevamped.defaultDrop.shape", CustomDropsRevamped.defaultDrop.getShape().toString());
      var0.set("CustomDropsRevamped.defaultDrop.effect", CustomDropsRevamped.defaultDrop.getEffect());
      var0.set("CustomDropsRevamped.defaultDrop.defaultDrops", CustomDropsRevamped.defaultDrop.getDefaultDrops());
      var0.set("CustomDropsRevamped.defaultDrop.spawnerDrops", CustomDropsRevamped.defaultDrop.getSpawnerDrops());
      var0.set("CustomDropsRevamped.defaultDrop.eggDrops", CustomDropsRevamped.defaultDrop.getEggDrops());
      var0.set("CustomDropsRevamped.defaultDrop.placedDrops", CustomDropsRevamped.defaultDrop.getPlacedDrops());
      int var11 = 0;
      Iterator var13 = CustomDropsRevamped.defaultDrop.getCommands().iterator();

      while(var13.hasNext()) {
         var3 = (String)var13.next();
         var0.set("CustomDropsRevamped.defaultDrop.commands." + var11++, var3);
      }

      Conditions var14 = CustomDropsRevamped.defaultDrop.getConditions();
      var0.set("CustomDropsRevamped.defaultDrop.conditions.mobName", var14.getMobName());
      var0.set("CustomDropsRevamped.defaultDrop.conditions.checkMobName", var14.getCheckMobName());
      var0.set("CustomDropsRevamped.defaultDrop.conditions.itemUsed", var14.getItemUsed());
      var0.set("CustomDropsRevamped.defaultDrop.conditions.checkItemUsed", var14.getCheckItemUsed());
      var0.set("CustomDropsRevamped.defaultDrop.conditions.checkItemUsedMeta", var14.getCheckItemUsedMeta());
      var0.set("CustomDropsRevamped.defaultDrop.conditions.permission", var14.getPermission());
      var0.set("CustomDropsRevamped.defaultDrop.conditions.checkPermission", var14.getCheckPermission());
      var11 = 0;
      Iterator var15 = var14.getBannedWorlds().iterator();

      while(var15.hasNext()) {
         String var17 = (String)var15.next();
         var0.set("CustomDropsRevamped.defaultDrop.conditions.bannedWorlds." + var11++, var17);
      }

      var0.set("CustomDropsRevamped.defaultDrop.conditions.checkBannedWorlds", var14.getCheckBannedWorlds());
      var0.set("CustomDropsRevamped.defaultDrop.conditions.minPlayers", var14.getMinPlayers());
      var0.set("CustomDropsRevamped.defaultDrop.conditions.checkMinPlayers", var14.getCheckMinPlayers());
      var0.set("CustomDropsRevamped.defaultDrop.conditions.maxPlayers", var14.getMaxPlayers());
      var0.set("CustomDropsRevamped.defaultDrop.conditions.checkMaxPlayers", var14.getCheckMaxPlayers());
      var0.set("CustomDropsRevamped.defaultDrop.conditions.lootingModifier", var14.getLootingModifier());
      var0.set("CustomDropsRevamped.defaultDrop.conditions.fortuneModifier", var14.getFortuneModifier());
      CustomDropsRevamped.plugin.saveConfig();
   }
}
