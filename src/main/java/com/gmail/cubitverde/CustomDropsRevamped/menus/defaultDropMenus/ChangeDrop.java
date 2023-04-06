package com.gmail.cubitverde.CustomDropsRevamped.menus.defaultDropMenus;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.ChangeDropItem;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.menus.Menu;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Icon;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ChangeDrop implements Menu {
   private Player player;

   public ChangeDrop(Player var1) {
      this.player = var1;
   }

   public Inventory getMenu() {
      HashMap var1 = new HashMap();
      Drop var2 = CustomDropsRevamped.defaultDrop;

      for(int var3 = 0; var3 < 36; ++var3) {
         ItemStack var4 = this.player.getInventory().getItem(var3);
         Icon var5;
         if (var4 != null && var4.getType() != Material.AIR) {
            var5 = new Icon(var4.clone());
            var5.addAction(new ChangeDropItem(var2, var4));
            var5.addAction(new OpenMenu(this.player, new DropSettings(this.player)));
            var1.put(var3 + 9, var5);
         } else {
            var5 = new Icon(Utilities.CreateItem(Material.LIGHT_GRAY_STAINED_GLASS_PANE, " "));
            var1.put(var3 + 9, var5);
         }
      }

      Icon var6 = new Icon(Utilities.CreateItem(Material.BARRIER, ChatColor.DARK_RED + "Special setting: " + ChatColor.RED + "BARRIER", ChatColor.RED + "Setting a barrier as the drop will drop no item.", ChatColor.RED + "Any commands, effects, etc. added will still be run."));
      var1.put(53, var6);
      Utilities.AddBackItem(this.player, (Menu)(new DropSettings(this.player)), var1, 54);
      Inventory var7 = Utilities.BuildInventory(this.player, var1, ChatColor.DARK_GREEN + "[Change Default Drop]", 54);
      return var7;
   }
}
