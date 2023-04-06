package com.gmail.cubitverde.CustomDropsRevamped.menus.mobMenus;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.Action;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.actions.ToggleWorld;
import com.gmail.cubitverde.CustomDropsRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Icon;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Mob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MobWorlds implements PageMenu {
   private Player player;
   private Mob mob;

   public MobWorlds(Player var1, Mob var2) {
      this.player = var1;
      this.mob = var2;
   }

   public Inventory getMenu(int var1) {
      ArrayList var2 = new ArrayList();
      List var3 = this.mob.getInactiveWorlds();
      LinkedList var4 = new LinkedList();
      Iterator var5 = CustomDropsRevamped.plugin.getServer().getWorlds().iterator();

      while(var5.hasNext()) {
         World var6 = (World)var5.next();
         var2.add(var6.getName().toLowerCase());
      }

      var5 = var2.iterator();

      while(var5.hasNext()) {
         String var9 = (String)var5.next();
         Icon var7;
         if (var3.contains(var9)) {
            var7 = new Icon(Utilities.CreateItem(Material.RED_BANNER, ChatColor.RED + var9, ChatColor.DARK_RED + "Changes to this mob are currently disabled", ChatColor.DARK_RED + "in this world. Click to enable them."));
         } else {
            var7 = new Icon(Utilities.CreateItem(Material.LIME_BANNER, ChatColor.GREEN + var9, ChatColor.DARK_GREEN + "Changes to this mob are currently enabled", ChatColor.DARK_GREEN + "in this world. Click to disable them."));
         }

         var7.addAction(new ToggleWorld(var9, var3));
         var7.addAction(new OpenMenu(this.player, new MobWorlds(this.player, this.mob), var1));
         var4.add(var7);
      }

      Inventory var8 = Utilities.BuildPagedInventory(this.player, var4, ChatColor.DARK_GREEN + "[Mob worlds]", 54, var1, (Action)null, false, this, new MobMenu(this.player, this.mob));
      Utilities.AddCornerInfo(var8, (Mob)this.mob, (Drop)null);
      return var8;
   }
}
