package com.gmail.cubitverde.CustomDropsRevamped.menus.mobMenus;

import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.NewSpeaker;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.actions.ToggleBool;
import com.gmail.cubitverde.CustomDropsRevamped.menus.Menu;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Conditions;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Icon;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Mob;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class DropConditions implements Menu {
   private Player player;
   private Mob mob;
   private Drop drop;

   public DropConditions(Player var1, Mob var2, Drop var3) {
      this.player = var1;
      this.mob = var2;
      this.drop = var3;
   }

   public Inventory getMenu() {
      HashMap var1 = new HashMap();
      Conditions var2 = this.drop.getConditions();
      Icon var3 = new Icon(Utilities.CreateItem(Material.NAME_TAG, ChatColor.GREEN + "Mob name", ChatColor.DARK_GREEN + "Current mob name: " + ChatColor.GREEN + var2.getMobName(), ChatColor.DARK_GREEN + "Click to change the name the mob must have", ChatColor.DARK_GREEN + "in order for this drop to be active."));
      var3.addAction(new NewSpeaker(this.player, this.mob, this.drop, "condName"));
      var1.put(10, var3);
      if (var2.getCheckMobName()) {
         var3 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Mob name enabled", ChatColor.DARK_GREEN + "Click to disable mob name check."));
      } else {
         var3 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Mob name disabled", ChatColor.DARK_RED + "Click to enable mob name check."));
      }

      var3.addAction(new ToggleBool(var2, "checkMobName"));
      var3.addAction(new OpenMenu(this.player, new DropConditions(this.player, this.mob, this.drop)));
      var1.put(19, var3);
      var3 = new Icon(Utilities.CreateItem(var2.getItemUsed().getType(), ChatColor.GREEN + "Used item", ChatColor.DARK_GREEN + "Click to change the item that must be used", ChatColor.DARK_GREEN + "in order for this drop to be active."));
      var3.addAction(new OpenMenu(this.player, new ChangeUsedItem(this.player, this.mob, this.drop)));
      var1.put(11, var3);
      if (var2.getCheckItemUsed()) {
         var3 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Used item enabled", ChatColor.DARK_GREEN + "Click to disable used item check."));
      } else {
         var3 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Used item disabled", ChatColor.DARK_RED + "Click to enable used item check."));
      }

      var3.addAction(new ToggleBool(var2, "checkItemUsed"));
      var3.addAction(new OpenMenu(this.player, new DropConditions(this.player, this.mob, this.drop)));
      var1.put(20, var3);
      var3 = new Icon(var2.getItemUsed().clone());
      var1.put(12, var3);
      if (var2.getCheckItemUsedMeta()) {
         var3 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Used item meta enabled", ChatColor.DARK_GREEN + "Click to disable used item meta check."));
      } else {
         var3 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Used item meta disabled", ChatColor.DARK_RED + "Click to enable used item meta check."));
      }

      var3.addAction(new ToggleBool(var2, "checkItemUsedMeta"));
      var3.addAction(new OpenMenu(this.player, new DropConditions(this.player, this.mob, this.drop)));
      var1.put(21, var3);
      var3 = new Icon(Utilities.CreateItem(Material.COMMAND_BLOCK, ChatColor.GREEN + "Permission", ChatColor.DARK_GREEN + "Current permission: " + ChatColor.GREEN + var2.getPermission(), ChatColor.DARK_GREEN + "Click to change the permission the player must have", ChatColor.DARK_GREEN + "in order for this drop to be active."));
      var3.addAction(new NewSpeaker(this.player, this.mob, this.drop, "condPermission"));
      var1.put(13, var3);
      if (var2.getCheckPermission()) {
         var3 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Permission enabled", ChatColor.DARK_GREEN + "Click to disable permission check."));
      } else {
         var3 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Permission disabled", ChatColor.DARK_RED + "Click to enable permission check."));
      }

      var3.addAction(new ToggleBool(var2, "checkPermission"));
      var3.addAction(new OpenMenu(this.player, new DropConditions(this.player, this.mob, this.drop)));
      var1.put(22, var3);
      var3 = new Icon(Utilities.CreateItem(Material.BOOKSHELF, ChatColor.GREEN + "Banned worlds", ChatColor.DARK_GREEN + "Click to add or remove banned worlds", ChatColor.DARK_GREEN + "in which this drop will not be active."));
      var3.addAction(new OpenMenu(this.player, new ConditionWorlds(this.player, this.mob, this.drop), 1));
      var1.put(14, var3);
      if (var2.getCheckBannedWorlds()) {
         var3 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Banned worlds enabled", ChatColor.DARK_GREEN + "Click to disable banned worlds check."));
      } else {
         var3 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Banned worlds disabled", ChatColor.DARK_RED + "Click to enable banned worlds check."));
      }

      var3.addAction(new ToggleBool(var2, "checkBannedWorlds"));
      var3.addAction(new OpenMenu(this.player, new DropConditions(this.player, this.mob, this.drop)));
      var1.put(23, var3);
      var3 = new Icon(Utilities.CreateItem(Material.ZOMBIE_HEAD, ChatColor.GREEN + "Minimum players", ChatColor.DARK_GREEN + "Current minimum players: " + ChatColor.GREEN + var2.getMinPlayers(), ChatColor.DARK_GREEN + "Click to change the minimum amount of players", ChatColor.DARK_GREEN + "that must be online for this drop to be active."));
      var3.addAction(new NewSpeaker(this.player, this.mob, this.drop, "condMinPlayers"));
      var1.put(15, var3);
      if (var2.getCheckMinPlayers()) {
         var3 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Minimum players enabled", ChatColor.DARK_GREEN + "Click to disable minimum players check."));
      } else {
         var3 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Minimum players disabled", ChatColor.DARK_RED + "Click to enable minimum players check."));
      }

      var3.addAction(new ToggleBool(var2, "checkMinPlayers"));
      var3.addAction(new OpenMenu(this.player, new DropConditions(this.player, this.mob, this.drop)));
      var1.put(24, var3);
      var3 = new Icon(Utilities.CreateItem(Material.SKELETON_SKULL, ChatColor.GREEN + "Maximum players", ChatColor.DARK_GREEN + "Current maximum players: " + ChatColor.GREEN + var2.getMaxPlayers(), ChatColor.DARK_GREEN + "Click to change the maximum amount of players", ChatColor.DARK_GREEN + "that can be online for this drop to be active."));
      var3.addAction(new NewSpeaker(this.player, this.mob, this.drop, "condMaxPlayers"));
      var1.put(16, var3);
      if (var2.getCheckMaxPlayers()) {
         var3 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Maximum players enabled", ChatColor.DARK_GREEN + "Click to disable maximum players check."));
      } else {
         var3 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Maximum players disabled", ChatColor.DARK_RED + "Click to enable maximum players check."));
      }

      var3.addAction(new ToggleBool(var2, "checkMaxPlayers"));
      var3.addAction(new OpenMenu(this.player, new DropConditions(this.player, this.mob, this.drop)));
      var1.put(25, var3);
      var3 = new Icon(Utilities.CreateItem(Material.GOLDEN_SWORD, ChatColor.GREEN + "Looting modifier"));
      var1.put(29, var3);
      if (var2.getLootingModifier()) {
         var3 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Looting modifier enabled", ChatColor.DARK_GREEN + "Click to disable the looting modifier."));
      } else {
         var3 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Looting modifier disabled", ChatColor.DARK_RED + "Click to enable the looting modifier."));
      }

      var3.addAction(new ToggleBool(var2, "lootingModifier"));
      var3.addAction(new OpenMenu(this.player, new DropConditions(this.player, this.mob, this.drop)));
      var1.put(38, var3);
      var3 = new Icon(Utilities.CreateItem(Material.BLACK_STAINED_GLASS_PANE, " "));
      var1.put(28, var3);
      var1.put(37, var3);
      Utilities.AddBackItem(this.player, (Menu)(new DropSettings(this.player, this.mob, this.drop)), var1, 54);
      Inventory var4 = Utilities.BuildInventory(this.player, var1, ChatColor.DARK_GREEN + "[Drop Conditions]", 54);
      Utilities.AddCornerInfo(var4, this.mob, this.drop);
      return var4;
   }
}
