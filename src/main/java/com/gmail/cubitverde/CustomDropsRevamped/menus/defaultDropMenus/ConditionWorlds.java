package com.gmail.cubitverde.CustomDropsRevamped.menus.defaultDropMenus;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.Action;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.actions.ToggleWorld;
import com.gmail.cubitverde.CustomDropsRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Conditions;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Icon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ConditionWorlds implements PageMenu {
   private Player player;

   public ConditionWorlds(Player var1) {
      this.player = var1;
   }

   public Inventory getMenu(int var1) {
      Drop var2 = CustomDropsRevamped.defaultDrop;
      Conditions var3 = var2.getConditions();
      LinkedList var4 = new LinkedList();
      ArrayList var5 = new ArrayList();
      List var6 = var3.getBannedWorlds();
      Iterator var7 = CustomDropsRevamped.plugin.getServer().getWorlds().iterator();

      while(var7.hasNext()) {
         World var8 = (World)var7.next();
         var5.add(var8.getName().toLowerCase());
      }

      var7 = var5.iterator();

      while(var7.hasNext()) {
         String var11 = (String)var7.next();
         Icon var9;
         if (var6.contains(var11)) {
            var9 = new Icon(Utilities.CreateItem(Material.RED_BANNER, ChatColor.RED + var11, ChatColor.DARK_RED + "This world is currently banned.", ChatColor.DARK_RED + "Click to enable it."));
         } else {
            var9 = new Icon(Utilities.CreateItem(Material.LIME_BANNER, ChatColor.GREEN + var11, ChatColor.DARK_GREEN + "This world is currently not banned.", ChatColor.DARK_GREEN + "Click to disable it."));
         }

         var9.addAction(new ToggleWorld(var11, var6));
         var9.addAction(new OpenMenu(this.player, new ConditionWorlds(this.player), var1));
         var4.add(var9);
      }

      Inventory var10 = Utilities.BuildPagedInventory(this.player, var4, ChatColor.DARK_GREEN + "[Drop worlds]", 54, var1, (Action)null, false, this, new DropConditions(this.player));
      return var10;
   }
}
