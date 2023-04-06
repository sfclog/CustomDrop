package com.gmail.cubitverde.CustomDropsRevamped.objects;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.inventory.ItemStack;

public class Conditions {
   private String mobName;
   private boolean checkMobName;
   private ItemStack itemUsed;
   private boolean checkItemUsed;
   private boolean checkItemUsedMeta;
   private String permission;
   private boolean checkPermission;
   private List<String> bannedWorlds;
   private boolean checkBannedWorlds;
   private int minPlayers;
   private boolean checkMinPlayers;
   private int maxPlayers;
   private boolean checkMaxPlayers;
   private boolean lootingModifier;
   private boolean fortuneModifier;

   public Conditions() {
   }

   public Conditions(boolean var1) {
      this.mobName = CustomDropsRevamped.defaultConditions.getMobName();
      this.checkMobName = var1;
      this.itemUsed = CustomDropsRevamped.defaultConditions.getItemUsed();
      this.checkItemUsed = var1;
      this.checkItemUsedMeta = var1;
      this.permission = CustomDropsRevamped.defaultConditions.getPermission();
      this.checkPermission = var1;
      this.bannedWorlds = new ArrayList(CustomDropsRevamped.defaultConditions.getBannedWorlds());
      this.checkBannedWorlds = var1;
      this.minPlayers = CustomDropsRevamped.defaultConditions.getMinPlayers();
      this.checkMinPlayers = var1;
      this.maxPlayers = CustomDropsRevamped.defaultConditions.getMaxPlayers();
      this.checkMaxPlayers = var1;
      this.lootingModifier = false;
      this.fortuneModifier = false;
   }

   public Conditions(Conditions var1) {
      this.mobName = var1.getMobName();
      this.checkMobName = var1.getCheckMobName();
      this.itemUsed = var1.getItemUsed();
      this.checkItemUsed = var1.getCheckItemUsed();
      this.checkItemUsedMeta = var1.getCheckItemUsedMeta();
      this.permission = var1.getPermission();
      this.checkPermission = var1.getCheckPermission();
      this.bannedWorlds = new ArrayList(var1.getBannedWorlds());
      this.checkBannedWorlds = var1.getCheckBannedWorlds();
      this.minPlayers = var1.getMinPlayers();
      this.checkMinPlayers = var1.getCheckMinPlayers();
      this.maxPlayers = var1.getMaxPlayers();
      this.checkMaxPlayers = var1.getCheckMaxPlayers();
      this.lootingModifier = var1.getLootingModifier();
      this.fortuneModifier = var1.getFortuneModifier();
   }

   public void toggleBool(String var1) {
      byte var3 = -1;
      switch(var1.hashCode()) {
      case -1509662457:
         if (var1.equals("checkBannedWorlds")) {
            var3 = 4;
         }
         break;
      case -777185736:
         if (var1.equals("fortuneModifier")) {
            var3 = 8;
         }
         break;
      case -702752104:
         if (var1.equals("checkItemUsed")) {
            var3 = 1;
         }
         break;
      case 61237800:
         if (var1.equals("checkMinPlayers")) {
            var3 = 5;
         }
         break;
      case 686218487:
         if (var1.equals("checkPermission")) {
            var3 = 3;
         }
         break;
      case 1163759491:
         if (var1.equals("checkMobName")) {
            var3 = 0;
         }
         break;
      case 1327037745:
         if (var1.equals("lootingModifier")) {
            var3 = 7;
         }
         break;
      case 1884205782:
         if (var1.equals("checkMaxPlayers")) {
            var3 = 6;
         }
         break;
      case 1889687741:
         if (var1.equals("checkItemUsedMeta")) {
            var3 = 2;
         }
      }

      switch(var3) {
      case 0:
         this.checkMobName = !this.checkMobName;
         return;
      case 1:
         this.checkItemUsed = !this.checkItemUsed;
         return;
      case 2:
         this.checkItemUsedMeta = !this.checkItemUsedMeta;
         return;
      case 3:
         this.checkPermission = !this.checkPermission;
         return;
      case 4:
         this.checkBannedWorlds = !this.checkBannedWorlds;
         return;
      case 5:
         this.checkMinPlayers = !this.checkMinPlayers;
         return;
      case 6:
         this.checkMaxPlayers = !this.checkMaxPlayers;
         return;
      case 7:
         this.lootingModifier = !this.lootingModifier;
         return;
      case 8:
         this.fortuneModifier = !this.fortuneModifier;
         return;
      default:
      }
   }

   public String getMobName() {
      return this.mobName;
   }

   public void setMobName(String var1) {
      if (var1 != null) {
         this.mobName = var1;
      }

   }

   public boolean getCheckMobName() {
      return this.checkMobName;
   }

   public void setCheckMobName(boolean var1) {
      this.checkMobName = var1;
   }

   public ItemStack getItemUsed() {
      return this.itemUsed;
   }

   public void setItemUsed(ItemStack var1) {
      if (var1 != null) {
         this.itemUsed = var1;
      }

   }

   public boolean getCheckItemUsed() {
      return this.checkItemUsed;
   }

   public void setCheckItemUsed(boolean var1) {
      this.checkItemUsed = var1;
   }

   public boolean getCheckItemUsedMeta() {
      return this.checkItemUsedMeta;
   }

   public void setCheckItemUsedMeta(boolean var1) {
      this.checkItemUsedMeta = var1;
   }

   public String getPermission() {
      return this.permission;
   }

   public void setPermission(String var1) {
      if (var1 != null) {
         this.permission = var1;
      }

   }

   public boolean getCheckPermission() {
      return this.checkPermission;
   }

   public void setCheckPermission(boolean var1) {
      this.checkPermission = var1;
   }

   public List<String> getBannedWorlds() {
      return this.bannedWorlds;
   }

   public void setBannedWorlds(List<String> var1) {
      if (var1 != null) {
         this.bannedWorlds = var1;
      }

   }

   public boolean getCheckBannedWorlds() {
      return this.checkBannedWorlds;
   }

   public void setCheckBannedWorlds(boolean var1) {
      this.checkBannedWorlds = var1;
   }

   public int getMinPlayers() {
      return this.minPlayers;
   }

   public void setMinPlayers(int var1) {
      this.minPlayers = var1;
   }

   public boolean getCheckMinPlayers() {
      return this.checkMinPlayers;
   }

   public void setCheckMinPlayers(boolean var1) {
      this.checkMinPlayers = var1;
   }

   public int getMaxPlayers() {
      return this.maxPlayers;
   }

   public void setMaxPlayers(int var1) {
      this.maxPlayers = var1;
   }

   public boolean getCheckMaxPlayers() {
      return this.checkMaxPlayers;
   }

   public void setCheckMaxPlayers(boolean var1) {
      this.checkMaxPlayers = var1;
   }

   public boolean getLootingModifier() {
      return this.lootingModifier;
   }

   public void setLootingModifier(boolean var1) {
      this.lootingModifier = var1;
   }

   public boolean getFortuneModifier() {
      return this.fortuneModifier;
   }

   public void setFortuneModifier(boolean var1) {
      this.fortuneModifier = var1;
   }
}
