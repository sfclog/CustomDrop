package com.gmail.cubitverde.CustomDropsRevamped.menus;

import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.menus.blockMenus.BlocksList;
import com.gmail.cubitverde.CustomDropsRevamped.menus.mobMenus.MobsList;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Icon;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MainMenu implements Menu {
   private Player player;

   public MainMenu(Player var1) {
      this.player = var1;
   }

   public Inventory getMenu() {
      HashMap var1 = new HashMap();
      Icon var2 = new Icon(Utilities.CreateItem(Material.CREEPER_SPAWN_EGG, ChatColor.GREEN + "Mob drops"));
      var2.addAction(new OpenMenu(this.player, new MobsList(this.player), 1));
      var1.put(10, var2);
      var2 = new Icon(Utilities.CreateItem(Material.DIAMOND_ORE, ChatColor.GREEN + "Block drops"));
      var2.addAction(new OpenMenu(this.player, new BlocksList(this.player), 1));
      var1.put(12, var2);
      var2 = new Icon(Utilities.CreateItem(Material.COMMAND_BLOCK, ChatColor.GREEN + "Settings"));
      var2.addAction(new OpenMenu(this.player, new SettingsMenu(this.player)));
      var1.put(14, var2);
      var2 = new Icon(Utilities.CreateItem(Material.BARRIER, ChatColor.GRAY + "Coming soon?"));
      var1.put(16, var2);
      return Utilities.BuildInventory(this.player, var1, ChatColor.DARK_GREEN + "[Main Menu]", 27);
   }
}
