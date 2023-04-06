package com.gmail.cubitverde.CustomDropsRevamped.menus.defaultDropMenus;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.NewSpeaker;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.actions.ToggleBool;
import com.gmail.cubitverde.CustomDropsRevamped.menus.Menu;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Conditions;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Icon;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class DropConditions implements Menu {
   private Player player;

   public DropConditions(Player var1) {
      this.player = var1;
   }

   public Inventory getMenu() {
      HashMap var1 = new HashMap();
      Drop var2 = CustomDropsRevamped.defaultDrop;
      Conditions var3 = var2.getConditions();
      Icon var4 = new Icon(Utilities.CreateItem(Material.NAME_TAG, ChatColor.GREEN + "Mob name", ChatColor.DARK_GREEN + "Current mob name: " + ChatColor.GREEN + var3.getMobName(), ChatColor.DARK_GREEN + "Click to change the name the mob must have", ChatColor.DARK_GREEN + "in order for this drop to be active."));
      var4.addAction(new NewSpeaker(this.player, "condName"));
      var1.put(10, var4);
      if (var3.getCheckMobName()) {
         var4 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Mob name enabled", ChatColor.DARK_GREEN + "Click to disable mob name check."));
      } else {
         var4 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Mob name disabled", ChatColor.DARK_RED + "Click to enable mob name check."));
      }

      var4.addAction(new ToggleBool(var3, "checkMobName"));
      var4.addAction(new OpenMenu(this.player, new DropConditions(this.player)));
      var1.put(19, var4);
      var4 = new Icon(Utilities.CreateItem(var3.getItemUsed().getType(), ChatColor.GREEN + "Used item", ChatColor.DARK_GREEN + "Click to change the item that must be used", ChatColor.DARK_GREEN + "in order for this drop to be active."));
      var4.addAction(new OpenMenu(this.player, new ChangeUsedItem(this.player)));
      var1.put(11, var4);
      if (var3.getCheckItemUsed()) {
         var4 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Used item enabled", ChatColor.DARK_GREEN + "Click to disable used item check."));
      } else {
         var4 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Used item disabled", ChatColor.DARK_RED + "Click to enable used item check."));
      }

      var4.addAction(new ToggleBool(var3, "checkItemUsed"));
      var4.addAction(new OpenMenu(this.player, new DropConditions(this.player)));
      var1.put(20, var4);
      var4 = new Icon(var3.getItemUsed().clone());
      var1.put(12, var4);
      if (var3.getCheckItemUsedMeta()) {
         var4 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Used item meta enabled", ChatColor.DARK_GREEN + "Click to disable used item meta check."));
      } else {
         var4 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Used item meta disabled", ChatColor.DARK_RED + "Click to enable used item meta check."));
      }

      var4.addAction(new ToggleBool(var3, "checkItemUsedMeta"));
      var4.addAction(new OpenMenu(this.player, new DropConditions(this.player)));
      var1.put(21, var4);
      var4 = new Icon(Utilities.CreateItem(Material.COMMAND_BLOCK, ChatColor.GREEN + "Permission", ChatColor.DARK_GREEN + "Current permission: " + ChatColor.GREEN + var3.getPermission(), ChatColor.DARK_GREEN + "Click to change the permission the player must have", ChatColor.DARK_GREEN + "in order for this drop to be active."));
      var4.addAction(new NewSpeaker(this.player, "condPermission"));
      var1.put(13, var4);
      if (var3.getCheckPermission()) {
         var4 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Permission enabled", ChatColor.DARK_GREEN + "Click to disable permission check."));
      } else {
         var4 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Permission disabled", ChatColor.DARK_RED + "Click to enable permission check."));
      }

      var4.addAction(new ToggleBool(var3, "checkPermission"));
      var4.addAction(new OpenMenu(this.player, new DropConditions(this.player)));
      var1.put(22, var4);
      var4 = new Icon(Utilities.CreateItem(Material.BOOKSHELF, ChatColor.GREEN + "Banned worlds", ChatColor.DARK_GREEN + "Click to add or remove banned worlds.", ChatColor.DARK_GREEN + "in which this drop will not be active."));
      var4.addAction(new OpenMenu(this.player, new ConditionWorlds(this.player), 1));
      var1.put(14, var4);
      if (var3.getCheckBannedWorlds()) {
         var4 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Banned worlds enabled", ChatColor.DARK_GREEN + "Click to disable banned worlds check."));
      } else {
         var4 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Banned worlds disabled", ChatColor.DARK_RED + "Click to enable banned worlds check."));
      }

      var4.addAction(new ToggleBool(var3, "checkBannedWorlds"));
      var4.addAction(new OpenMenu(this.player, new DropConditions(this.player)));
      var1.put(23, var4);
      var4 = new Icon(Utilities.CreateItem(Material.ZOMBIE_HEAD, ChatColor.GREEN + "Minimum players", ChatColor.DARK_GREEN + "Current minimum players: " + ChatColor.GREEN + var3.getMinPlayers(), ChatColor.DARK_GREEN + "Click to change the minimum amount of players", ChatColor.DARK_GREEN + "that must be online for this drop to be active."));
      var4.addAction(new NewSpeaker(this.player, "condMinPlayers"));
      var1.put(15, var4);
      if (var3.getCheckMinPlayers()) {
         var4 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Minimum players enabled", ChatColor.DARK_GREEN + "Click to disable minimum players check."));
      } else {
         var4 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Minimum players disabled", ChatColor.DARK_RED + "Click to enable minimum players check."));
      }

      var4.addAction(new ToggleBool(var3, "checkMinPlayers"));
      var4.addAction(new OpenMenu(this.player, new DropConditions(this.player)));
      var1.put(24, var4);
      var4 = new Icon(Utilities.CreateItem(Material.SKELETON_SKULL, ChatColor.GREEN + "Maximum players", ChatColor.DARK_GREEN + "Current maximum players: " + ChatColor.GREEN + var3.getMaxPlayers(), ChatColor.DARK_GREEN + "Click to change the maximum amount of players", ChatColor.DARK_GREEN + "that can be online for this drop to be active."));
      var4.addAction(new NewSpeaker(this.player, "condMaxPlayers"));
      var1.put(16, var4);
      if (var3.getCheckMaxPlayers()) {
         var4 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Maximum players enabled", ChatColor.DARK_GREEN + "Click to disable maximum players check."));
      } else {
         var4 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Maximum players disabled", ChatColor.DARK_RED + "Click to enable maximum players check."));
      }

      var4.addAction(new ToggleBool(var3, "checkMaxPlayers"));
      var4.addAction(new OpenMenu(this.player, new DropConditions(this.player)));
      var1.put(25, var4);
      var4 = new Icon(Utilities.CreateItem(Material.GOLDEN_PICKAXE, ChatColor.GREEN + "Fortune modifier"));
      var1.put(28, var4);
      if (var3.getFortuneModifier()) {
         var4 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Fortune modifier enabled", ChatColor.DARK_GREEN + "Click to disable the fortune modifier."));
      } else {
         var4 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Fortune modifier disabled", ChatColor.DARK_RED + "Click to enable the fortune modifier."));
      }

      var4.addAction(new ToggleBool(var3, "fortuneModifier"));
      var4.addAction(new OpenMenu(this.player, new DropConditions(this.player)));
      var1.put(37, var4);
      var4 = new Icon(Utilities.CreateItem(Material.GOLDEN_SWORD, ChatColor.GREEN + "Looting modifier"));
      var1.put(29, var4);
      if (var3.getLootingModifier()) {
         var4 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Looting modifier enabled", ChatColor.DARK_GREEN + "Click to disable the looting modifier."));
      } else {
         var4 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Looting modifier disabled", ChatColor.DARK_RED + "Click to enable the looting modifier."));
      }

      var4.addAction(new ToggleBool(var3, "lootingModifier"));
      var4.addAction(new OpenMenu(this.player, new DropConditions(this.player)));
      var1.put(38, var4);
      Utilities.AddBackItem(this.player, (Menu)(new DropSettings(this.player)), var1, 54);
      Inventory var5 = Utilities.BuildInventory(this.player, var1, ChatColor.DARK_GREEN + "[Default Conditions]", 54);
      return var5;
   }
}
