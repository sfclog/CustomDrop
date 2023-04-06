package com.gmail.cubitverde.CustomDropsRevamped.menus.defaultDropMenus;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.ChangeCondItem;
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

public class ChangeUsedItem implements Menu {
   private Player player;

   public ChangeUsedItem(Player var1) {
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
            var5.addAction(new ChangeCondItem(var2, var4));
            var5.addAction(new OpenMenu(this.player, new DropConditions(this.player)));
            var1.put(var3 + 9, var5);
         } else {
            var5 = new Icon(Utilities.CreateItem(Material.LIGHT_GRAY_STAINED_GLASS_PANE, " "));
            var1.put(var3 + 9, var5);
         }
      }

      Utilities.AddBackItem(this.player, (Menu)(new DropConditions(this.player)), var1, 54);
      Inventory var6 = Utilities.BuildInventory(this.player, var1, ChatColor.DARK_GREEN + "[Change Used Item]", 54);
      return var6;
   }
}
