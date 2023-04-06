package com.gmail.cubitverde.CustomDropsRevamped;

import com.gmail.cubitverde.CustomDropsRevamped.actions.Action;
import com.gmail.cubitverde.CustomDropsRevamped.actions.ChangePage;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.menus.Menu;
import com.gmail.cubitverde.CustomDropsRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Block;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Holder;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Icon;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Mob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Utilities {
   public static List<Integer> InventoryFrame(int var0) {
      ArrayList var1 = new ArrayList();

      for(int var2 = 0; var2 < var0; ++var2) {
         if (var2 < 9 || var0 - var2 < 9 || var2 % 9 == 0 || var2 % 9 == 8) {
            var1.add(var2);
         }
      }

      return var1;
   }

   public static LinkedList<Integer> InventoryInside(int var0) {
      LinkedList var1 = new LinkedList();
      List var2 = InventoryFrame(var0);

      for(int var3 = 0; var3 < var0; ++var3) {
         if (!var2.contains(var3)) {
            var1.add(var3);
         }
      }

      return var1;
   }

   public static ItemStack CreateItem(Material var0, String var1) {
      ItemStack var2 = new ItemStack(var0);
      ItemMeta var3 = var2.getItemMeta();
      var3.setDisplayName(var1);
      var2.setItemMeta(var3);
      return var2;
   }

   public static ItemStack CreateItem(Material var0, String var1, String... var2) {
      ItemStack var3 = CreateItem(var0, var1);
      ItemMeta var4 = var3.getItemMeta();
      ArrayList var5 = new ArrayList();

      for(int var6 = 0; var6 < var2.length; ++var6) {
         var5.add(var2[var6]);
      }

      var4.setLore(var5);
      var3.setItemMeta(var4);
      return var3;
   }

   public static void AddGreenFrame(Inventory var0) {
      int var1 = var0.getSize();

      for(int var2 = 0; var2 < var1; ++var2) {
         var0.setItem(var2, CreateItem(Material.LIGHT_GRAY_STAINED_GLASS_PANE, " "));
      }

      Iterator var4 = InventoryFrame(var1).iterator();

      while(var4.hasNext()) {
         int var3 = (Integer)var4.next();
         var0.setItem(var3, CreateItem(Material.LIME_STAINED_GLASS_PANE, " "));
      }

      var0.setItem(4, CreateItem(Material.WHITE_STAINED_GLASS_PANE, ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "Custom Drops Revamped" + ChatColor.DARK_GREEN + "]", ChatColor.DARK_GREEN + "Created by: " + ChatColor.GREEN + "cubitoverde"));
   }

   public static Inventory BuildInventory(Player var0, Map<Integer, Icon> var1, String var2, int var3) {
      Holder var4 = new Holder(var0, var1, var2, var3);
      Inventory var5 = Bukkit.createInventory(var4, var3, var2);
      AddGreenFrame(var5);
      Iterator var6 = var1.keySet().iterator();

      while(var6.hasNext()) {
         int var7 = (Integer)var6.next();
         var5.setItem(var7, ((Icon)var1.get(var7)).getItem().clone());
      }

      return var5;
   }

   public static Inventory BuildPagedInventory(Player var0, LinkedList<Icon> var1, String var2, int var3, int var4, Action var5, boolean var6, PageMenu var7, Menu var8) {
      LinkedList var9 = InventoryInside(var3);
      int var10 = var9.size();
      int var11 = var1.size();
      HashMap var12 = new HashMap();
      boolean var13 = false;
      int var14 = (var4 - 1) * var10;

      Icon var16;
      for(int var15 = 0; var15 < var10; ++var15) {
         if (var14 + var15 >= var11) {
            if (var5 != null) {
               var16 = new Icon(CreateItem(Material.LIME_DYE, ChatColor.GREEN + "Add new"));
               var16.addAction(var5);
               if (!var6) {
                  var16.addAction(new OpenMenu(var0, var7, var4));
               }

               var12.put((Integer)var9.get(var15), var16);
            }
            break;
         }

         var12.put((Integer)var9.get(var15), (Icon)var1.get(var14 + var15));
         if (var15 == var10 - 1) {
            var13 = true;
         }
      }

      Icon var17 = new Icon(CreateItem(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.DARK_GREEN + "Current page: " + ChatColor.GREEN + var4));
      var12.put(var3 - 2, var17);
      if (var4 > 1) {
         var16 = new Icon(CreateItem(Material.ORANGE_STAINED_GLASS_PANE, ChatColor.GREEN + "Previous page"));
         var16.addAction(new ChangePage(var0, var7, var4 - 1));
         var12.put(var3 - 3, var16);
      }

      if (var5 != null) {
         if (var13) {
            var16 = new Icon(CreateItem(Material.ORANGE_STAINED_GLASS_PANE, ChatColor.GREEN + "Next page"));
            var16.addAction(new ChangePage(var0, var7, var4 + 1));
            var12.put(var3 - 1, var16);
         }
      } else if (var13 && var14 + var10 < var11) {
         var16 = new Icon(CreateItem(Material.ORANGE_STAINED_GLASS_PANE, ChatColor.GREEN + "Next page"));
         var16.addAction(new ChangePage(var0, var7, var4 + 1));
         var12.put(var3 - 1, var16);
      }

      if (var8 != null) {
         AddBackItem(var0, (Menu)var8, var12, var3);
      }

      return BuildInventory(var0, var12, var2, var3);
   }

   public static void AddCornerInfo(Inventory var0, Mob var1, Drop var2) {
      ItemStack var3 = var0.getItem(0);
      ItemMeta var4 = var3.getItemMeta();
      ArrayList var5 = new ArrayList();
      var5.add(ChatColor.DARK_GRAY + "Editing mob: " + ChatColor.GRAY + var1.getType().toString());
      if (var2 != null) {
         var5.add(ChatColor.DARK_GRAY + "Drop ID: " + ChatColor.GRAY + var2.getId());
      }

      var4.setLore(var5);
      var3.setItemMeta(var4);
      var0.setItem(0, var3);
   }

   public static void AddCornerInfo(Inventory var0, Block var1, Drop var2) {
      ItemStack var3 = var0.getItem(0);
      ItemMeta var4 = var3.getItemMeta();
      ArrayList var5 = new ArrayList();
      var5.add(ChatColor.DARK_GRAY + "Editing block: " + ChatColor.GRAY + var1.getMaterial().toString());
      if (var2 != null) {
         var5.add(ChatColor.DARK_GRAY + "Drop ID: " + ChatColor.GRAY + var2.getId());
      }

      var4.setLore(var5);
      var3.setItemMeta(var4);
      var0.setItem(0, var3);
   }

   public static EntityType ConvertMobNameToType(String var0) {
      String var1 = var0.toUpperCase();
      var1 = var1.replace(' ', '_');
      return EntityType.valueOf(var1);
   }

   public static Mob GetObjMob(String var0) {
      EntityType var1 = ConvertMobNameToType(var0);
      Iterator var2 = CustomDropsRevamped.editedMobs.iterator();

      Mob var3;
      do {
         if (!var2.hasNext()) {
            Mob var4 = new Mob(var1);
            CustomDropsRevamped.editedMobs.add(var4);
            return var4;
         }

         var3 = (Mob)var2.next();
      } while(!var3.getType().equals(var1));

      return var3;
   }

   public static void AddBackItem(Player var0, Menu var1, Map<Integer, Icon> var2, int var3) {
      Icon var4 = new Icon(CreateItem(Material.RED_STAINED_GLASS_PANE, ChatColor.RED + "Go back"));
      var4.addAction(new OpenMenu(var0, var1));
      var2.put(var3 - 9, var4);
   }

   public static void AddBackItem(Player var0, PageMenu var1, Map<Integer, Icon> var2, int var3) {
      Icon var4 = new Icon(CreateItem(Material.RED_STAINED_GLASS_PANE, ChatColor.RED + "Go back"));
      var4.addAction(new OpenMenu(var0, var1, 1));
      var2.put(var3 - 9, var4);
   }

   public static String GetNextColor(String var0) {
      LinkedList var1 = new LinkedList();
      var1.add("BLACK");
      var1.add("BLUE");
      var1.add("BROWN");
      var1.add("CYAN");
      var1.add("GRAY");
      var1.add("GREEN");
      var1.add("LIGHT_BLUE");
      var1.add("LIGHT_GRAY");
      var1.add("LIME");
      var1.add("MAGENTA");
      var1.add("ORANGE");
      var1.add("PINK");
      var1.add("PURPLE");
      var1.add("RED");
      var1.add("WHITE");
      var1.add("YELLOW");
      int var2 = 0;

      for(Iterator var3 = var1.iterator(); var3.hasNext(); ++var2) {
         String var4 = (String)var3.next();
         if (var4.equals(var0)) {
            if (var2 == var1.size() - 1) {
               return (String)var1.get(0);
            }

            ++var2;
            return (String)var1.get(var2);
         }
      }

      return null;
   }

   public static Type GetNextShape(Type var0) {
      LinkedList var1 = new LinkedList();
      var1.add(Type.BURST);
      var1.add(Type.BALL_LARGE);
      var1.add(Type.BALL);
      var1.add(Type.STAR);
      var1.add(Type.CREEPER);
      int var2 = 0;

      for(Iterator var3 = var1.iterator(); var3.hasNext(); ++var2) {
         Type var4 = (Type)var3.next();
         if (var4.equals(var0)) {
            if (var4.equals(var1.get(var1.size() - 1))) {
               return (Type)var1.get(0);
            }

            return (Type)var1.get(var2 + 1);
         }
      }

      return null;
   }

   public static Color GetColorFromString(String var0) {
      String var1 = var0.toLowerCase();
      byte var3 = -1;
      switch(var1.hashCode()) {
      case -1008851410:
         if (var1.equals("orange")) {
            var3 = 10;
         }
         break;
      case -976943172:
         if (var1.equals("purple")) {
            var3 = 12;
         }
         break;
      case -734239628:
         if (var1.equals("yellow")) {
            var3 = 15;
         }
         break;
      case -209096221:
         if (var1.equals("light_blue")) {
            var3 = 6;
         }
         break;
      case -208942100:
         if (var1.equals("light_gray")) {
            var3 = 7;
         }
         break;
      case 112785:
         if (var1.equals("red")) {
            var3 = 13;
         }
         break;
      case 3027034:
         if (var1.equals("blue")) {
            var3 = 1;
         }
         break;
      case 3068707:
         if (var1.equals("cyan")) {
            var3 = 3;
         }
         break;
      case 3181155:
         if (var1.equals("gray")) {
            var3 = 4;
         }
         break;
      case 3321813:
         if (var1.equals("lime")) {
            var3 = 8;
         }
         break;
      case 3441014:
         if (var1.equals("pink")) {
            var3 = 11;
         }
         break;
      case 93818879:
         if (var1.equals("black")) {
            var3 = 0;
         }
         break;
      case 94011702:
         if (var1.equals("brown")) {
            var3 = 2;
         }
         break;
      case 98619139:
         if (var1.equals("green")) {
            var3 = 5;
         }
         break;
      case 113101865:
         if (var1.equals("white")) {
            var3 = 14;
         }
         break;
      case 828922025:
         if (var1.equals("magenta")) {
            var3 = 9;
         }
      }

      switch(var3) {
      case 0:
         return Color.fromBGR(33, 29, 29);
      case 1:
         return Color.fromBGR(169, 68, 60);
      case 2:
         return Color.fromBGR(50, 84, 130);
      case 3:
         return Color.fromBGR(157, 156, 22);
      case 4:
         return Color.fromBGR(82, 79, 71);
      case 5:
         return Color.fromBGR(21, 124, 93);
      case 6:
         return Color.fromBGR(218, 179, 58);
      case 7:
         return Color.fromBGR(151, 157, 156);
      case 8:
         return Color.fromBGR(31, 199, 128);
      case 9:
         return Color.fromBGR(189, 79, 198);
      case 10:
         return Color.fromBGR(29, 128, 249);
      case 11:
         return Color.fromBGR(170, 140, 243);
      case 12:
         return Color.fromBGR(183, 50, 137);
      case 13:
         return Color.fromBGR(38, 46, 176);
      case 14:
         return Color.fromBGR(255, 255, 249);
      case 15:
         return Color.fromBGR(61, 216, 255);
      default:
         return null;
      }
   }

   public static List<String> ReadMobCommandPlaceholders(String var0, Player var1, Location var2) {
      ArrayList var3 = new ArrayList();
      LinkedHashMap var4 = new LinkedHashMap();
      LinkedHashMap var5 = new LinkedHashMap();

      int var6;
      for(var6 = 0; var6 < var0.length(); ++var6) {
         if (var0.charAt(var6) == '<') {
            for(int var7 = var6 + 1; var7 < var0.length(); ++var7) {
               if (var0.charAt(var7) == '>') {
                  var4.put(var6, var7);
                  var6 = var7;
                  break;
               }
            }
         }
      }

      var6 = 0;
      Iterator var13 = var4.keySet().iterator();

      int var8;
      int var9;
      String var12;
      while(var13.hasNext()) {
         var8 = (Integer)var13.next();
         var9 = (Integer)var4.get(var8);
         String var10 = var0.substring(var8 + 1 + var6, var9 + var6);
         byte var11 = -1;
         switch(var10.hashCode()) {
         case -1354750946:
            if (var10.equals("coords")) {
               var11 = 1;
            }
            break;
         case -985752863:
            if (var10.equals("player")) {
               var11 = 0;
            }
            break;
         case 120:
            if (var10.equals("x")) {
               var11 = 2;
            }
            break;
         case 121:
            if (var10.equals("y")) {
               var11 = 3;
            }
            break;
         case 122:
            if (var10.equals("z")) {
               var11 = 4;
            }
            break;
         case 96673:
            if (var10.equals("all")) {
               var11 = 6;
            }
            break;
         case 113318802:
            if (var10.equals("world")) {
               var11 = 5;
            }
         }

         switch(var11) {
         case 0:
            if (var1 == null) {
               return null;
            }

            var0 = var0.substring(0, var8 + var6) + var1.getName() + var0.substring(var9 + 1 + var6);
            var6 = var6 - 8 + var1.getName().length();
            break;
         case 1:
            var12 = var2.getBlockX() + " " + var2.getBlockY() + " " + var2.getBlockZ();
            var0 = var0.substring(0, var8 + var6) + var12 + var0.substring(var9 + 1 + var6);
            var6 = var6 - 8 + var12.length();
            break;
         case 2:
            var12 = "" + var2.getBlockX();
            var0 = var0.substring(0, var8 + var6) + var12 + var0.substring(var9 + 1 + var6);
            var6 = var6 - 3 + var12.length();
            break;
         case 3:
            var12 = "" + var2.getBlockY();
            var0 = var0.substring(0, var8 + var6) + var12 + var0.substring(var9 + 1 + var6);
            var6 = var6 - 3 + var12.length();
            break;
         case 4:
            var12 = "" + var2.getBlockZ();
            var0 = var0.substring(0, var8 + var6) + var12 + var0.substring(var9 + 1 + var6);
            var6 = var6 - 3 + var12.length();
            break;
         case 5:
            var0 = var0.substring(0, var8 + var6) + var2.getWorld().getName() + var0.substring(var9 + 1 + var6);
            var6 = var6 - 7 + var2.getWorld().getName().length();
            break;
         case 6:
            var5.put(var8, var9);
         }
      }

      var13 = var5.keySet().iterator();

      while(var13.hasNext()) {
         var8 = (Integer)var13.next();
         var9 = (Integer)var5.get(var8);
         Iterator var14 = CustomDropsRevamped.plugin.getServer().getOnlinePlayers().iterator();

         while(var14.hasNext()) {
            Player var15 = (Player)var14.next();
            var12 = var0.substring(0, var8 + var6) + var15.getName() + var0.substring(var9 + 1 + var6);
            var3.add(var12);
         }
      }

      if (var5.keySet().size() == 0) {
         var3.add(var0);
      }

      return var3;
   }

   public static String CheckStringValidity(String var0, boolean var1) {
      ArrayList var2 = new ArrayList();
      var2.add("0");
      var2.add("1");
      var2.add("2");
      var2.add("3");
      var2.add("4");
      var2.add("5");
      var2.add("6");
      var2.add("7");
      var2.add("8");
      var2.add("9");
      var2.add(".");
      var2.add(",");
      var2.add("_");
      var2.add("-");
      String var3 = "";
      int var4;
      if (var1) {
         for(var4 = 0; var4 < var0.length(); ++var4) {
            if (!var2.contains(var0.substring(var4, var4 + 1))) {
               ++var4;
            } else {
               var3 = var3.concat(var0.substring(var4, var4 + 1));
            }
         }
      } else {
         for(var4 = 0; var4 < var0.length(); ++var4) {
            char var5 = var0.charAt(var4);
            if ((var5 < 'A' || var5 > 'Z') && (var5 < 'a' || var5 > 'z') && !var2.contains(var0.substring(var4, var4 + 1))) {
               ++var4;
            } else {
               var3 = var3.concat(var0.substring(var4, var4 + 1));
            }
         }
      }

      return var3;
   }

   public static String CheckStringValidity(String var0) {
      String var1 = "";

      for(int var2 = 0; var2 < var0.length(); ++var2) {
         char var3 = var0.charAt(var2);
         if (var3 <= 127) {
            var1 = var1.concat(var0.substring(var2, var2 + 1));
         } else {
            ++var2;
         }
      }

      return var1;
   }
}
