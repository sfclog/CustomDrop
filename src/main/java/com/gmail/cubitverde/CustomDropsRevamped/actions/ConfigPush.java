package com.gmail.cubitverde.CustomDropsRevamped.actions;

import com.gmail.cubitverde.CustomDropsRevamped.Config;
import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ConfigPush implements Action {
   Player player;
   boolean configToGui;

   public ConfigPush(Player var1, boolean var2) {
      this.player = var1;
      this.configToGui = var2;
   }

   public void run() {
      CustomDropsRevamped.plugin.reloadConfig();
      FileConfiguration var1 = CustomDropsRevamped.plugin.getConfig();
      if (this.configToGui) {
         Config.readConfig(var1);
         this.player.sendMessage(ChatColor.GREEN + "Current config file has been loaded in-game and to the GUI.");
      } else {
         Config.saveConfig(var1);
         this.player.sendMessage(ChatColor.GREEN + "Current GUI settings have been saved in the config file.");
      }

      this.player.closeInventory();
   }
}
