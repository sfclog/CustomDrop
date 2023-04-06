package com.gmail.cubitverde.CustomDropsRevamped.menus;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.ChangeModifierAmount;
import com.gmail.cubitverde.CustomDropsRevamped.actions.ChangeModifierType;
import com.gmail.cubitverde.CustomDropsRevamped.actions.ConfigPush;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.actions.ToggleBool;
import com.gmail.cubitverde.CustomDropsRevamped.menus.defaultDropMenus.DropSettings;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Icon;
import java.text.DecimalFormat;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class SettingsMenu implements Menu {
   private Player player;

   public SettingsMenu(Player var1) {
      this.player = var1;
   }

   public Inventory getMenu() {
      HashMap var1 = new HashMap();
      Icon var2 = new Icon(Utilities.CreateItem(Material.WRITABLE_BOOK, ChatColor.GREEN + "Default drop", ChatColor.DARK_GREEN + "Click here to change the default drop settings."));
      var2.addAction(new OpenMenu(this.player, new DropSettings(this.player)));
      var1.put(10, var2);
      if (CustomDropsRevamped.afkDrops) {
         var2 = new Icon(Utilities.CreateItem(Material.LAVA_BUCKET, ChatColor.GREEN + "Afk drops: Enabled", ChatColor.DARK_GREEN + "Custom drops will be able to drop even when the", ChatColor.DARK_GREEN + "cause of a mob's death is not a player, for example", ChatColor.DARK_GREEN + "due to lava or fall damage.", ChatColor.GREEN + "Click this item to disable afk drops."));
      } else {
         var2 = new Icon(Utilities.CreateItem(Material.LAVA_BUCKET, ChatColor.RED + "Afk drops: Disabled", ChatColor.DARK_RED + "Custom drops will only be able to drop when the", ChatColor.DARK_RED + "cause of a mob's death is a player, and not", ChatColor.DARK_RED + "other causes like lava or fall damage.", ChatColor.RED + "Click this item to enable afk drops."));
      }

      var2.addAction(new ToggleBool("afkDrops"));
      var2.addAction(new OpenMenu(this.player, new SettingsMenu(this.player)));
      var1.put(12, var2);
      var2 = new Icon(Utilities.CreateItem(Material.LANTERN, ChatColor.GREEN + "Push GUI to config", ChatColor.DARK_GREEN + "Click here to push any changes made in the GUI", ChatColor.DARK_GREEN + "to be updated in the config file.", ChatColor.GREEN + "Only use this if you know what you are doing!", ChatColor.DARK_GREEN + "Shift right click this item to use it."));
      var2.addAction(new ConfigPush(this.player, false));
      var1.put(15, var2);
      var2 = new Icon(Utilities.CreateItem(Material.SOUL_LANTERN, ChatColor.GREEN + "Push config to GUI", ChatColor.DARK_GREEN + "Click here to push any changes made to the config", ChatColor.DARK_GREEN + "to be updated in-game and in the GUI.", ChatColor.GREEN + "Only use this if you know what you are doing!", ChatColor.DARK_GREEN + "Shift right click this item to use it."));
      var2.addAction(new ConfigPush(this.player, true));
      var1.put(16, var2);
      if (CustomDropsRevamped.lootingModifier.isAdditive()) {
         var2 = new Icon(Utilities.CreateItem(Material.GOLDEN_SWORD, ChatColor.GREEN + "Looting effect", ChatColor.DARK_GREEN + "Current effect: " + ChatColor.GREEN + "+" + (new DecimalFormat("###.#")).format(CustomDropsRevamped.lootingModifier.getAddition()) + "% per level", ChatColor.DARK_GREEN + "Click here to change effect type."));
      } else {
         var2 = new Icon(Utilities.CreateItem(Material.GOLDEN_SWORD, ChatColor.GREEN + "Looting effect", ChatColor.DARK_GREEN + "Current effect: " + ChatColor.GREEN + "x" + (new DecimalFormat("##.#")).format(CustomDropsRevamped.lootingModifier.getMultiplication()) + " per level", ChatColor.DARK_GREEN + "Click here to change effect type."));
      }

      var2.addAction(new ChangeModifierType(CustomDropsRevamped.lootingModifier));
      var2.addAction(new OpenMenu(this.player, new SettingsMenu(this.player)));
      var1.put(21, var2);
      if (CustomDropsRevamped.lootingModifier.isAdditive() && CustomDropsRevamped.lootingModifier.getAddition() >= 1.0D || !CustomDropsRevamped.lootingModifier.isAdditive() && CustomDropsRevamped.lootingModifier.getMultiplication() >= 1.0D) {
         var2 = new Icon(Utilities.CreateItem(Material.RED_DYE, ChatColor.GREEN + "Looting effect -1"));
         var2.addAction(new ChangeModifierAmount(CustomDropsRevamped.lootingModifier, -1.0D));
         var2.addAction(new OpenMenu(this.player, new SettingsMenu(this.player)));
         var1.put(19, var2);
      }

      if (CustomDropsRevamped.lootingModifier.isAdditive() && CustomDropsRevamped.lootingModifier.getAddition() >= 0.1D || !CustomDropsRevamped.lootingModifier.isAdditive() && CustomDropsRevamped.lootingModifier.getMultiplication() >= 0.1D) {
         var2 = new Icon(Utilities.CreateItem(Material.ORANGE_DYE, ChatColor.GREEN + "Looting effect -0.1"));
         var2.addAction(new ChangeModifierAmount(CustomDropsRevamped.lootingModifier, -0.1D));
         var2.addAction(new OpenMenu(this.player, new SettingsMenu(this.player)));
         var1.put(20, var2);
      }

      if (CustomDropsRevamped.lootingModifier.isAdditive() && CustomDropsRevamped.lootingModifier.getAddition() <= 99.9D || !CustomDropsRevamped.lootingModifier.isAdditive() && CustomDropsRevamped.lootingModifier.getMultiplication() <= 99.9D) {
         var2 = new Icon(Utilities.CreateItem(Material.GREEN_DYE, ChatColor.GREEN + "Looting effect +0.1"));
         var2.addAction(new ChangeModifierAmount(CustomDropsRevamped.lootingModifier, 0.1D));
         var2.addAction(new OpenMenu(this.player, new SettingsMenu(this.player)));
         var1.put(22, var2);
      }

      if (CustomDropsRevamped.lootingModifier.isAdditive() && CustomDropsRevamped.lootingModifier.getAddition() <= 99.0D || !CustomDropsRevamped.lootingModifier.isAdditive() && CustomDropsRevamped.lootingModifier.getMultiplication() <= 99.0D) {
         var2 = new Icon(Utilities.CreateItem(Material.LIME_DYE, ChatColor.GREEN + "Looting effect +1"));
         var2.addAction(new ChangeModifierAmount(CustomDropsRevamped.lootingModifier, 1.0D));
         var2.addAction(new OpenMenu(this.player, new SettingsMenu(this.player)));
         var1.put(23, var2);
      }

      if (CustomDropsRevamped.fortuneModifier.isAdditive()) {
         var2 = new Icon(Utilities.CreateItem(Material.GOLDEN_PICKAXE, ChatColor.GREEN + "Fortune effect", ChatColor.DARK_GREEN + "Current effect: " + ChatColor.GREEN + "+" + (new DecimalFormat("###.#")).format(CustomDropsRevamped.fortuneModifier.getAddition()) + "% per level", ChatColor.DARK_GREEN + "Click here to change effect type."));
      } else {
         var2 = new Icon(Utilities.CreateItem(Material.GOLDEN_PICKAXE, ChatColor.GREEN + "Fortune effect", ChatColor.DARK_GREEN + "Current effect: " + ChatColor.GREEN + "x" + (new DecimalFormat("##.#")).format(CustomDropsRevamped.fortuneModifier.getMultiplication()) + " per level", ChatColor.DARK_GREEN + "Click here to change effect type."));
      }

      var2.addAction(new ChangeModifierType(CustomDropsRevamped.fortuneModifier));
      var2.addAction(new OpenMenu(this.player, new SettingsMenu(this.player)));
      var1.put(30, var2);
      if (CustomDropsRevamped.fortuneModifier.isAdditive() && CustomDropsRevamped.fortuneModifier.getAddition() >= 1.0D || !CustomDropsRevamped.fortuneModifier.isAdditive() && CustomDropsRevamped.fortuneModifier.getMultiplication() >= 1.0D) {
         var2 = new Icon(Utilities.CreateItem(Material.RED_DYE, ChatColor.GREEN + "Fortune effect -1"));
         var2.addAction(new ChangeModifierAmount(CustomDropsRevamped.fortuneModifier, -1.0D));
         var2.addAction(new OpenMenu(this.player, new SettingsMenu(this.player)));
         var1.put(28, var2);
      }

      if (CustomDropsRevamped.fortuneModifier.isAdditive() && CustomDropsRevamped.fortuneModifier.getAddition() >= 0.1D || !CustomDropsRevamped.fortuneModifier.isAdditive() && CustomDropsRevamped.fortuneModifier.getMultiplication() >= 0.1D) {
         var2 = new Icon(Utilities.CreateItem(Material.ORANGE_DYE, ChatColor.GREEN + "Fortune effect -0.1"));
         var2.addAction(new ChangeModifierAmount(CustomDropsRevamped.fortuneModifier, -0.1D));
         var2.addAction(new OpenMenu(this.player, new SettingsMenu(this.player)));
         var1.put(29, var2);
      }

      if (CustomDropsRevamped.fortuneModifier.isAdditive() && CustomDropsRevamped.fortuneModifier.getAddition() <= 99.9D || !CustomDropsRevamped.fortuneModifier.isAdditive() && CustomDropsRevamped.fortuneModifier.getMultiplication() <= 99.9D) {
         var2 = new Icon(Utilities.CreateItem(Material.GREEN_DYE, ChatColor.GREEN + "Fortune effect +0.1"));
         var2.addAction(new ChangeModifierAmount(CustomDropsRevamped.fortuneModifier, 0.1D));
         var2.addAction(new OpenMenu(this.player, new SettingsMenu(this.player)));
         var1.put(31, var2);
      }

      if (CustomDropsRevamped.fortuneModifier.isAdditive() && CustomDropsRevamped.fortuneModifier.getAddition() <= 99.0D || !CustomDropsRevamped.fortuneModifier.isAdditive() && CustomDropsRevamped.fortuneModifier.getMultiplication() <= 99.0D) {
         var2 = new Icon(Utilities.CreateItem(Material.LIME_DYE, ChatColor.GREEN + "Fortune effect +1"));
         var2.addAction(new ChangeModifierAmount(CustomDropsRevamped.fortuneModifier, 1.0D));
         var2.addAction(new OpenMenu(this.player, new SettingsMenu(this.player)));
         var1.put(32, var2);
      }

      Utilities.AddBackItem(this.player, (Menu)(new MainMenu(this.player)), var1, 45);
      Inventory var3 = Utilities.BuildInventory(this.player, var1, ChatColor.DARK_GREEN + "[Settings]", 45);
      return var3;
   }
}
