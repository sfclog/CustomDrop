package com.gmail.cubitverde.CustomDropsRevamped.menus.defaultDropMenus;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.CycleColor;
import com.gmail.cubitverde.CustomDropsRevamped.actions.CycleShape;
import com.gmail.cubitverde.CustomDropsRevamped.actions.NewSpeaker;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.actions.ToggleBool;
import com.gmail.cubitverde.CustomDropsRevamped.menus.MainMenu;
import com.gmail.cubitverde.CustomDropsRevamped.menus.Menu;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Icon;
import java.text.DecimalFormat;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class DropSettings implements Menu {
   private Player player;

   public DropSettings(Player var1) {
      this.player = var1;
   }

   public Inventory getMenu() {
      HashMap var1 = new HashMap();
      Drop var2 = CustomDropsRevamped.defaultDrop;
      Icon var3 = new Icon(var2.getItem().clone());
      var1.put(10, var3);
      var3 = new Icon(Utilities.CreateItem(Material.CHEST, ChatColor.GREEN + "Change drop item", ChatColor.DARK_GREEN + "Click here to change the item."));
      var3.addAction(new OpenMenu(this.player, new ChangeDrop(this.player)));
      var1.put(11, var3);
      var3 = new Icon(Utilities.CreateItem(Material.NAME_TAG, ChatColor.GREEN + "Item drop chance", ChatColor.DARK_GREEN + "Current drop chance: " + ChatColor.GREEN + (new DecimalFormat("#%.##########")).format(var2.getChance()), ChatColor.DARK_GREEN + "Click here to change the chance."));
      var3.addAction(new NewSpeaker(this.player, "dropChance"));
      var1.put(12, var3);
      var3 = new Icon(Utilities.CreateItem(Material.COMPARATOR, ChatColor.GREEN + "Drop conditions", ChatColor.DARK_GREEN + "Click here to edit the conditions that", ChatColor.DARK_GREEN + "must be met for the item to drop."));
      var3.addAction(new OpenMenu(this.player, new DropConditions(this.player)));
      var1.put(16, var3);
      var3 = new Icon(Utilities.CreateItem(Material.COMMAND_BLOCK, ChatColor.GREEN + "Drop commands", ChatColor.DARK_GREEN + "Click here to edit the commands that", ChatColor.DARK_GREEN + "will be executed when the item drops."));
      var3.addAction(new OpenMenu(this.player, new DropCommands(this.player), 1));
      var1.put(15, var3);
      if (var2.getDefaultDrops()) {
         var3 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Default mob drops", ChatColor.DARK_GREEN + "This item will drop from default mobs.", ChatColor.DARK_GREEN + "Click here to disable default mob drops."));
      } else {
         var3 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Default mob drops", ChatColor.DARK_RED + "This item will not drop from default mobs.", ChatColor.DARK_RED + "Click here to enable default mob drops."));
      }

      var3.addAction(new ToggleBool(var2, "defaultDrops"));
      var3.addAction(new OpenMenu(this.player, new DropSettings(this.player)));
      var1.put(28, var3);
      if (var2.getSpawnerDrops()) {
         var3 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Spawner mob drops", ChatColor.DARK_GREEN + "This item will drop from spawner mobs.", ChatColor.DARK_GREEN + "Click here to disable spawner mob drops."));
      } else {
         var3 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Spawner mob drops", ChatColor.DARK_RED + "This item will not drop from spawner mobs.", ChatColor.DARK_RED + "Click here to enable spawner mob drops."));
      }

      var3.addAction(new ToggleBool(var2, "spawnerDrops"));
      var3.addAction(new OpenMenu(this.player, new DropSettings(this.player)));
      var1.put(29, var3);
      if (var2.getEggDrops()) {
         var3 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Spawn egg mob drops", ChatColor.DARK_GREEN + "This item will drop from spawn egg mobs.", ChatColor.DARK_GREEN + "Click here to disable spawn egg mob drops."));
      } else {
         var3 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Spawn egg mob drops", ChatColor.DARK_RED + "This item will not drop from spawn egg mobs.", ChatColor.DARK_RED + "Click here to enable spawn egg mob drops."));
      }

      var3.addAction(new ToggleBool(var2, "eggDrops"));
      var3.addAction(new OpenMenu(this.player, new DropSettings(this.player)));
      var1.put(30, var3);
      if (var2.getPlacedDrops()) {
         var3 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Placed block drops", ChatColor.DARK_GREEN + "This item will drop from placed blocks.", ChatColor.DARK_GREEN + "Click here to disable placed block drops."));
      } else {
         var3 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Placed block drops", ChatColor.DARK_RED + "This item will not drop from placed blocks.", ChatColor.DARK_RED + "Click here to enable placed block drops."));
      }

      var3.addAction(new ToggleBool(var2, "placedDrops"));
      var3.addAction(new OpenMenu(this.player, new DropSettings(this.player)));
      var1.put(31, var3);
      Material var5 = Material.valueOf(var2.getColor() + "_CONCRETE_POWDER");
      Icon var4 = new Icon(Utilities.CreateItem(var5, ChatColor.GREEN + "Drop effect color", ChatColor.DARK_GREEN + "Current effect color: " + ChatColor.GREEN + var2.getColor(), ChatColor.DARK_GREEN + "Click here to change the effect color."));
      var4.addAction(new CycleColor(var2));
      var4.addAction(new OpenMenu(this.player, new DropSettings(this.player)));
      var1.put(32, var4);
      var3 = new Icon(Utilities.CreateItem(Material.FIREWORK_STAR, ChatColor.GREEN + "Drop effect shape", ChatColor.DARK_GREEN + "Current effect shape: " + ChatColor.GREEN + var2.getShape().toString(), ChatColor.DARK_GREEN + "Click here to change the drop effect shape."));
      var3.addAction(new CycleShape(var2));
      var3.addAction(new OpenMenu(this.player, new DropSettings(this.player)));
      var1.put(33, var3);
      if (var2.getEffect()) {
         var3 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Toggle drop effects", ChatColor.DARK_GREEN + "Drop effects are currently enabled.", ChatColor.DARK_GREEN + "Click here to disable them."));
      } else {
         var3 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Toggle drop effects", ChatColor.DARK_RED + "Drop effects are currently disabled.", ChatColor.DARK_RED + "Click here to enable them."));
      }

      var3.addAction(new ToggleBool(var2, "effect"));
      var3.addAction(new OpenMenu(this.player, new DropSettings(this.player)));
      var1.put(34, var3);
      Utilities.AddBackItem(this.player, (Menu)(new MainMenu(this.player)), var1, 45);
      Inventory var6 = Utilities.BuildInventory(this.player, var1, ChatColor.DARK_GREEN + "[Default Drop]", 45);
      return var6;
   }
}
