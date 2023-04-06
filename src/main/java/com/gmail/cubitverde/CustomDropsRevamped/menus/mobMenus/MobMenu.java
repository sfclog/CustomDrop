package com.gmail.cubitverde.CustomDropsRevamped.menus.mobMenus;

import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.actions.ToggleBool;
import com.gmail.cubitverde.CustomDropsRevamped.menus.Menu;
import com.gmail.cubitverde.CustomDropsRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Icon;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Mob;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MobMenu implements Menu {
   private Player player;
   private Mob mob;

   public MobMenu(Player var1, Mob var2) {
      this.player = var1;
      this.mob = var2;
   }

   public Inventory getMenu() {
      HashMap var1 = new HashMap();
      Icon var2;
      if (this.mob.getVanillaDrops()) {
         var2 = new Icon(Utilities.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Toggle vanilla drops", ChatColor.DARK_GREEN + "Vanilla drops are currently enabled.", ChatColor.DARK_GREEN + "Click this to disable them."));
      } else {
         var2 = new Icon(Utilities.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Toggle vanilla drops", ChatColor.DARK_RED + "Vanilla drops are currently disabled.", ChatColor.DARK_RED + "Click this to enable them."));
      }

      var2.addAction(new ToggleBool(this.mob, "vanillaDrops"));
      var2.addAction(new OpenMenu(this.player, new MobMenu(this.player, this.mob)));
      var1.put(11, var2);
      var2 = new Icon(Utilities.CreateItem(Material.GOLD_INGOT, ChatColor.GREEN + "Edit custom drops"));
      var2.addAction(new OpenMenu(this.player, new MobDrops(this.player, this.mob), 1));
      var1.put(13, var2);
      var2 = new Icon(Utilities.CreateItem(Material.BOOKSHELF, ChatColor.GREEN + "Toggle active worlds", ChatColor.DARK_GREEN + "Select in which worlds changes done", ChatColor.DARK_GREEN + "to this mob will be active"));
      var2.addAction(new OpenMenu(this.player, new MobWorlds(this.player, this.mob), 1));
      var1.put(15, var2);
      Utilities.AddBackItem(this.player, (PageMenu)(new MobsList(this.player)), var1, 27);
      Inventory var3 = Utilities.BuildInventory(this.player, var1, ChatColor.DARK_GREEN + "[Mob Menu]", 27);
      Utilities.AddCornerInfo(var3, (Mob)this.mob, (Drop)null);
      return var3;
   }
}
