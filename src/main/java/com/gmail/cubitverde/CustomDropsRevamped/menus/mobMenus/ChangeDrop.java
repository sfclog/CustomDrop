package com.gmail.cubitverde.CustomDropsRevamped.menus.mobMenus;

import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.ChangeDropItem;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.menus.Menu;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Icon;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Mob;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ChangeDrop implements Menu {
   private Player player;
   private Mob mob;
   private Drop drop;

   public ChangeDrop(Player var1, Mob var2, Drop var3) {
      this.player = var1;
      this.mob = var2;
      this.drop = var3;
   }

   public Inventory getMenu() {
      HashMap var1 = new HashMap();

      for(int var2 = 0; var2 < 36; ++var2) {
         ItemStack var3 = this.player.getInventory().getItem(var2);
         Icon var4;
         if (var3 != null && var3.getType() != Material.AIR) {
            var4 = new Icon(var3.clone());
            var4.addAction(new ChangeDropItem(this.drop, var3));
            var4.addAction(new OpenMenu(this.player, new DropSettings(this.player, this.mob, this.drop)));
            var1.put(var2 + 9, var4);
         } else {
            var4 = new Icon(Utilities.CreateItem(Material.LIGHT_GRAY_STAINED_GLASS_PANE, " "));
            var1.put(var2 + 9, var4);
         }
      }

      Icon var5 = new Icon(Utilities.CreateItem(Material.BARRIER, ChatColor.DARK_RED + "Special setting: " + ChatColor.RED + "BARRIER", ChatColor.RED + "Setting a barrier as the drop will drop no item.", ChatColor.RED + "Any commands, effects, etc. added will still be run."));
      var1.put(53, var5);
      Utilities.AddBackItem(this.player, (Menu)(new DropSettings(this.player, this.mob, this.drop)), var1, 54);
      Inventory var6 = Utilities.BuildInventory(this.player, var1, ChatColor.DARK_GREEN + "[Change Drop]", 54);
      Utilities.AddCornerInfo(var6, this.mob, this.drop);
      return var6;
   }
}
