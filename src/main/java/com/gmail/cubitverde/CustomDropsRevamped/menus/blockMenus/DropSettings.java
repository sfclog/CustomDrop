package com.gmail.cubitverde.CustomDropsRevamped.menus.blockMenus;

import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.CycleColor;
import com.gmail.cubitverde.CustomDropsRevamped.actions.CycleShape;
import com.gmail.cubitverde.CustomDropsRevamped.actions.NewSpeaker;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.actions.RemoveList;
import com.gmail.cubitverde.CustomDropsRevamped.actions.ToggleBool;
import com.gmail.cubitverde.CustomDropsRevamped.menus.Menu;
import com.gmail.cubitverde.CustomDropsRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Block;
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
   private Block block;
   private Drop drop;

   public DropSettings(Player var1, Block var2, Drop var3) {
      this.player = var1;
      this.block = var2;
      this.drop = var3;
   }

   public Inventory getMenu() {
      HashMap var1 = new HashMap();
      Icon var2 = new Icon(this.drop.getItem().clone());
      var1.put(10, var2);
      var2 = new Icon(Utilities.CreateItem(Material.CHEST, ChatColor.GREEN + "Change drop item", ChatColor.DARK_GREEN + "Click here to change the item."));
      var2.addAction(new OpenMenu(this.player, new ChangeDrop(this.player, this.block, this.drop)));
      var1.put(11, var2);
      var2 = new Icon(Utilities.CreateItem(Material.NAME_TAG, ChatColor.GREEN + "Item drop chance", ChatColor.DARK_GREEN + "Current drop chance: " + ChatColor.GREEN + (new DecimalFormat("#%.##########")).format(this.drop.getChance()), ChatColor.DARK_GREEN + "Click here to change the chance."));
      var2.addAction(new NewSpeaker(this.player, this.block, this.drop, "dropChance"));
      var1.put(12, var2);
      var2 = new Icon(Utilities.CreateItem(Material.BARRIER, ChatColor.RED + "Delete drop", ChatColor.DARK_RED + "Shift right click this item to delete this drop."));
      var2.addAction(new RemoveList(this.block.getDrops(), this.drop));
      var2.addAction(new OpenMenu(this.player, new BlockDrops(this.player, this.block), 1));
      var1.put(25, var2);
      var2 = new Icon(Utilities.CreateItem(Material.COMPARATOR, ChatColor.GREEN + "Drop conditions", ChatColor.DARK_GREEN + "Click here to edit the conditions that", ChatColor.DARK_GREEN + "must be met for the item to drop."));
      var2.addAction(new OpenMenu(this.player, new DropConditions(this.player, this.block, this.drop)));
      var1.put(16, var2);
      var2 = new Icon(Utilities.CreateItem(Material.COMMAND_BLOCK, ChatColor.GREEN + "Drop commands", ChatColor.DARK_GREEN + "Click here to edit the commands that", ChatColor.DARK_GREEN + "will be executed when the item drops."));
      var2.addAction(new OpenMenu(this.player, new DropCommands(this.player, this.block, this.drop), 1));
      var1.put(15, var2);
      if (this.drop.getDefaultDrops()) {
         var2 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Default block drops", ChatColor.DARK_GREEN + "This item will drop from default blocks.", ChatColor.DARK_GREEN + "Click here to disable default block drops."));
      } else {
         var2 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Default block drops", ChatColor.DARK_RED + "This item will not drop from default blocks.", ChatColor.DARK_RED + "Click here to enable default block drops."));
      }

      var2.addAction(new ToggleBool(this.drop, "defaultDrops"));
      var2.addAction(new OpenMenu(this.player, new DropSettings(this.player, this.block, this.drop)));
      var1.put(28, var2);
      if (this.drop.getPlacedDrops()) {
         var2 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Placed block drops", ChatColor.DARK_GREEN + "This item will drop from placed blocks.", ChatColor.DARK_GREEN + "Click here to disable placed block drops."));
      } else {
         var2 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Placed block drops", ChatColor.DARK_RED + "This item will not drop from placed blocks.", ChatColor.DARK_RED + "Click here to enable placed block drops."));
      }

      var2.addAction(new ToggleBool(this.drop, "placedDrops"));
      var2.addAction(new OpenMenu(this.player, new DropSettings(this.player, this.block, this.drop)));
      var1.put(29, var2);
      Material var4 = Material.valueOf(this.drop.getColor() + "_CONCRETE_POWDER");
      Icon var3 = new Icon(Utilities.CreateItem(var4, ChatColor.GREEN + "Drop effect color", ChatColor.DARK_GREEN + "Current effect color: " + ChatColor.GREEN + this.drop.getColor(), ChatColor.DARK_GREEN + "Click here to change the effect color."));
      var3.addAction(new CycleColor(this.drop));
      var3.addAction(new OpenMenu(this.player, new DropSettings(this.player, this.block, this.drop)));
      var1.put(32, var3);
      var2 = new Icon(Utilities.CreateItem(Material.FIREWORK_STAR, ChatColor.GREEN + "Drop effect shape", ChatColor.DARK_GREEN + "Current effect shape: " + ChatColor.GREEN + this.drop.getShape().toString(), ChatColor.DARK_GREEN + "Click here to change the drop effect shape."));
      var2.addAction(new CycleShape(this.drop));
      var2.addAction(new OpenMenu(this.player, new DropSettings(this.player, this.block, this.drop)));
      var1.put(33, var2);
      if (this.drop.getEffect()) {
         var2 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Toggle drop effects", ChatColor.DARK_GREEN + "Drop effects are currently enabled.", ChatColor.DARK_GREEN + "Click here to disable them."));
      } else {
         var2 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Toggle drop effects", ChatColor.DARK_RED + "Drop effects are currently disabled.", ChatColor.DARK_RED + "Click here to enable them."));
      }

      var2.addAction(new ToggleBool(this.drop, "effect"));
      var2.addAction(new OpenMenu(this.player, new DropSettings(this.player, this.block, this.drop)));
      var1.put(34, var2);
      Utilities.AddBackItem(this.player, (PageMenu)(new BlockDrops(this.player, this.block)), var1, 45);
      Inventory var5 = Utilities.BuildInventory(this.player, var1, ChatColor.DARK_GREEN + "[Drop Settings]", 45);
      Utilities.AddCornerInfo(var5, this.block, this.drop);
      return var5;
   }
}
