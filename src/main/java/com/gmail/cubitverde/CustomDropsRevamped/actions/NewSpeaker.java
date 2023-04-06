package com.gmail.cubitverde.CustomDropsRevamped.actions;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Block;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Conditions;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Mob;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Speaker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class NewSpeaker implements Action {
   Player player;
   Mob mob;
   Block block;
   Drop drop;
   Conditions conditions;
   String changing;

   public NewSpeaker(Player var1, Mob var2, Drop var3, String var4) {
      this.player = var1;
      this.mob = var2;
      this.drop = var3;
      this.changing = var4;
   }

   public NewSpeaker(Player var1, Block var2, Drop var3, String var4) {
      this.player = var1;
      this.block = var2;
      this.drop = var3;
      this.changing = var4;
   }

   public NewSpeaker(Player var1, String var2) {
      this.player = var1;
      this.changing = var2;
   }

   public void run() {
      Speaker var1;
      if (this.mob != null) {
         var1 = new Speaker(this.player, this.mob, this.drop, this.changing);
         CustomDropsRevamped.speakers.put(this.player.getUniqueId(), var1);
      } else if (this.block != null) {
         var1 = new Speaker(this.player, this.block, this.drop, this.changing);
         CustomDropsRevamped.speakers.put(this.player.getUniqueId(), var1);
      } else {
         var1 = new Speaker(this.player, this.changing);
         CustomDropsRevamped.speakers.put(this.player.getUniqueId(), var1);
      }

      String var3 = this.changing;
      byte var2 = -1;
      switch(var3.hashCode()) {
      case -1825091951:
         if (var3.equals("condPermission")) {
            var2 = 3;
         }
         break;
      case -627104656:
         if (var3.equals("condMaxPlayers")) {
            var2 = 5;
         }
         break;
      case -582796083:
         if (var3.equals("condName")) {
            var2 = 2;
         }
         break;
      case 448921347:
         if (var3.equals("dropChance")) {
            var2 = 0;
         }
         break;
      case 1243114844:
         if (var3.equals("dropCommand")) {
            var2 = 1;
         }
         break;
      case 1844894658:
         if (var3.equals("condMinPlayers")) {
            var2 = 4;
         }
      }

      switch(var2) {
      case 0:
         this.player.sendMessage(ChatColor.DARK_GREEN + "Type in chat the new " + ChatColor.GREEN + "drop chance " + ChatColor.DARK_GREEN + "you want this item to have.");
         this.player.sendMessage(ChatColor.DARK_GREEN + "It must be a number " + ChatColor.GREEN + "bewteen 0 and 1 " + ChatColor.DARK_GREEN + "(both included).");
         break;
      case 1:
         this.player.sendMessage(ChatColor.DARK_GREEN + "Type in chat the " + ChatColor.GREEN + "new command " + ChatColor.DARK_GREEN + "you want this drop to have.");
         this.player.sendMessage(ChatColor.DARK_GREEN + "The initial bar " + ChatColor.GREEN + "should not be included" + ChatColor.DARK_GREEN + ".");
         this.player.sendMessage(ChatColor.DARK_GREEN + "The following placeholders are supported:");
         this.player.sendMessage(ChatColor.DARK_GREEN + "- " + ChatColor.GREEN + "<player>" + ChatColor.DARK_GREEN + ": Name of the player.");
         this.player.sendMessage(ChatColor.DARK_GREEN + "- " + ChatColor.GREEN + "<coords>" + ChatColor.DARK_GREEN + ": Coordinates of the location with format 'x y z'.");
         this.player.sendMessage(ChatColor.DARK_GREEN + "- " + ChatColor.GREEN + "<x>, <y> and <z>" + ChatColor.DARK_GREEN + ": Specific coordinate of the location.");
         this.player.sendMessage(ChatColor.DARK_GREEN + "- " + ChatColor.GREEN + "<world>" + ChatColor.DARK_GREEN + ": World name of the location.");
         this.player.sendMessage(ChatColor.DARK_GREEN + "- " + ChatColor.GREEN + "<all>" + ChatColor.DARK_GREEN + ": Name of all online players.");
         break;
      case 2:
         this.player.sendMessage(ChatColor.DARK_GREEN + "Type in chat the new " + ChatColor.GREEN + "mob name " + ChatColor.DARK_GREEN + "condition.");
         break;
      case 3:
         this.player.sendMessage(ChatColor.DARK_GREEN + "Type in chat the new " + ChatColor.GREEN + "permission " + ChatColor.DARK_GREEN + "condition.");
         break;
      case 4:
         this.player.sendMessage(ChatColor.DARK_GREEN + "Type in chat the new " + ChatColor.GREEN + "minimum players " + ChatColor.DARK_GREEN + "condition.");
         break;
      case 5:
         this.player.sendMessage(ChatColor.DARK_GREEN + "Type in chat the new " + ChatColor.GREEN + "maximum players " + ChatColor.DARK_GREEN + "condition.");
      }

      this.player.closeInventory();
   }
}
