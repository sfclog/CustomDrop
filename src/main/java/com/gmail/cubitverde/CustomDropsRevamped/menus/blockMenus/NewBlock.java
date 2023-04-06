package com.gmail.cubitverde.CustomDropsRevamped.menus.blockMenus;

import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.AddBlock;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.menus.Menu;
import com.gmail.cubitverde.CustomDropsRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Icon;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class NewBlock implements Menu {
   private Player player;

   public NewBlock(Player var1) {
      this.player = var1;
   }

   public Inventory getMenu() {
      HashMap var1 = new HashMap();

      for(int var2 = 0; var2 < 36; ++var2) {
         ItemStack var3 = this.player.getInventory().getItem(var2);
         Icon var4;
         if (var3 != null && var3.getType() != Material.AIR) {
            var4 = new Icon(var3.clone());
            var4.addAction(new AddBlock(this.player, var3.getType()));
            var4.addAction(new OpenMenu(this.player, new BlocksList(this.player), 1));
            var1.put(var2 + 9, var4);
         } else {
            var4 = new Icon(Utilities.CreateItem(Material.LIGHT_GRAY_STAINED_GLASS_PANE, " "));
            var1.put(var2 + 9, var4);
         }
      }

      Utilities.AddBackItem(this.player, (PageMenu)(new BlocksList(this.player)), var1, 54);
      Inventory var5 = Utilities.BuildInventory(this.player, var1, ChatColor.DARK_GREEN + "[Add New Block]", 54);
      return var5;
   }
}
