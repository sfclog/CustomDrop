package com.gmail.cubitverde.CustomDropsRevamped.objects;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.menus.mobMenus.DropCommands;
import com.gmail.cubitverde.CustomDropsRevamped.menus.mobMenus.DropConditions;
import com.gmail.cubitverde.CustomDropsRevamped.menus.mobMenus.DropSettings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Speaker {
   private Player player;
   private Mob mob;
   private Block block;
   private Drop drop;
   private String changing;

   public Speaker(Player var1, Mob var2, Drop var3, String var4) {
      this.player = var1;
      this.mob = var2;
      this.drop = var3;
      this.changing = var4;
   }

   public Speaker(Player var1, Block var2, Drop var3, String var4) {
      this.player = var1;
      this.block = var2;
      this.drop = var3;
      this.changing = var4;
   }

   public Speaker(Player var1, String var2) {
      this.player = var1;
      this.changing = var2;
   }

   public void trigger(String var1) {
      if (this.drop == null) {
         this.drop = CustomDropsRevamped.defaultDrop;
      }

      String var2 = this.changing;
      byte var3 = -1;
      switch(var2.hashCode()) {
      case -1825091951:
         if (var2.equals("condPermission")) {
            var3 = 3;
         }
         break;
      case -627104656:
         if (var2.equals("condMaxPlayers")) {
            var3 = 5;
         }
         break;
      case -582796083:
         if (var2.equals("condName")) {
            var3 = 2;
         }
         break;
      case 448921347:
         if (var2.equals("dropChance")) {
            var3 = 0;
         }
         break;
      case 1243114844:
         if (var2.equals("dropCommand")) {
            var3 = 1;
         }
         break;
      case 1844894658:
         if (var2.equals("condMinPlayers")) {
            var3 = 4;
         }
      }

      String var9;
      switch(var3) {
      case 0:
         var9 = Utilities.CheckStringValidity(var1, true);

         try {
            double var10 = Double.parseDouble(var9);
            if (var10 < 0.0D || var10 > 1.0D) {
               throw new Exception();
            }

            this.drop.setChance(var10);
         } catch (Exception var8) {
            this.player.sendMessage(ChatColor.DARK_RED + "Invalid number: " + ChatColor.RED + var9);
            this.player.sendMessage(ChatColor.DARK_RED + "The drop chance must be given as " + ChatColor.RED + "a number between 0 and 1" + ChatColor.DARK_RED + ".");
         }

         Bukkit.getScheduler().runTask(CustomDropsRevamped.plugin, () -> {
            if (this.mob != null) {
               (new OpenMenu(this.player, new DropSettings(this.player, this.mob, this.drop))).run();
            } else if (this.block != null) {
               (new OpenMenu(this.player, new com.gmail.cubitverde.CustomDropsRevamped.menus.blockMenus.DropSettings(this.player, this.block, this.drop))).run();
            } else {
               (new OpenMenu(this.player, new com.gmail.cubitverde.CustomDropsRevamped.menus.defaultDropMenus.DropSettings(this.player))).run();
            }

            CustomDropsRevamped.speakers.remove(this.player.getUniqueId());
         });
         return;
      case 1:
         var9 = Utilities.CheckStringValidity(var1);
         this.drop.getCommands().add(var9);
         this.player.sendMessage(ChatColor.DARK_GREEN + "Command added: " + ChatColor.GREEN + var9);
         Bukkit.getScheduler().runTask(CustomDropsRevamped.plugin, () -> {
            if (this.mob != null) {
               (new OpenMenu(this.player, new DropCommands(this.player, this.mob, this.drop), 1)).run();
            } else if (this.block != null) {
               (new OpenMenu(this.player, new com.gmail.cubitverde.CustomDropsRevamped.menus.blockMenus.DropCommands(this.player, this.block, this.drop), 1)).run();
            } else {
               (new OpenMenu(this.player, new com.gmail.cubitverde.CustomDropsRevamped.menus.defaultDropMenus.DropCommands(this.player), 1)).run();
            }

            CustomDropsRevamped.speakers.remove(this.player.getUniqueId());
         });
         return;
      case 2:
      case 3:
      case 4:
      case 5:
         Conditions var4 = this.drop.getConditions();
         String var5;
         if (this.changing.equals("condName")) {
            var5 = Utilities.CheckStringValidity(var1);
            var4.setMobName(var5);
            this.player.sendMessage(ChatColor.DARK_GREEN + "Mob name condition changed: " + ChatColor.GREEN + var5);
         } else if (this.changing.equals("condPermission")) {
            var5 = Utilities.CheckStringValidity(var1, false);
            var4.setPermission(var5);
            this.player.sendMessage(ChatColor.DARK_GREEN + "Permission condition changed: " + ChatColor.GREEN + var5);
         } else {
            var5 = Utilities.CheckStringValidity(var1, true);

            try {
               int var6 = Integer.parseInt(var5);
               if (var6 < 0) {
                  throw new Exception();
               }

               if (this.changing.equals("condMinPlayers")) {
                  var4.setMinPlayers(var6);
                  this.player.sendMessage(ChatColor.DARK_GREEN + "Minimum players condition changed: " + ChatColor.GREEN + var5);
               } else {
                  var4.setMaxPlayers(var6);
                  this.player.sendMessage(ChatColor.DARK_GREEN + "Maximum players condition changed: " + ChatColor.GREEN + var5);
               }
            } catch (Exception var7) {
               this.player.sendMessage(ChatColor.DARK_RED + "Invalid number: " + ChatColor.RED + var5);
               this.player.sendMessage(ChatColor.DARK_RED + "The player count must be given as " + ChatColor.RED + "a non-negative number" + ChatColor.DARK_RED + ".");
            }
         }

         Bukkit.getScheduler().runTask(CustomDropsRevamped.plugin, () -> {
            if (this.mob != null) {
               (new OpenMenu(this.player, new DropConditions(this.player, this.mob, this.drop))).run();
            } else if (this.block != null) {
               (new OpenMenu(this.player, new com.gmail.cubitverde.CustomDropsRevamped.menus.blockMenus.DropConditions(this.player, this.block, this.drop))).run();
            } else {
               (new OpenMenu(this.player, new com.gmail.cubitverde.CustomDropsRevamped.menus.defaultDropMenus.DropConditions(this.player))).run();
            }

            CustomDropsRevamped.speakers.remove(this.player.getUniqueId());
         });
         return;
      default:
      }
   }
}
