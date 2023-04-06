package com.gmail.cubitverde.CustomDropsRevamped.menus.mobMenus;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.Action;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.actions.ToggleWorld;
import com.gmail.cubitverde.CustomDropsRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Conditions;
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

public class ConditionWorlds implements PageMenu {
   private Player player;
   private Mob mob;
   private Drop drop;

   public ConditionWorlds(Player var1, Mob var2, Drop var3) {
      this.player = var1;
      this.mob = var2;
      this.drop = var3;
   }

   public Inventory getMenu(int var1) {
      Conditions var2 = this.drop.getConditions();
      LinkedList var3 = new LinkedList();
      ArrayList var4 = new ArrayList();
      List var5 = var2.getBannedWorlds();
      Iterator var6 = CustomDropsRevamped.plugin.getServer().getWorlds().iterator();

      while(var6.hasNext()) {
         World var7 = (World)var6.next();
         var4.add(var7.getName().toLowerCase());
      }

      var6 = var4.iterator();

      while(var6.hasNext()) {
         String var10 = (String)var6.next();
         Icon var8;
         if (var5.contains(var10)) {
            var8 = new Icon(Utilities.CreateItem(Material.RED_BANNER, ChatColor.RED + var10, ChatColor.DARK_RED + "This world is currently banned.", ChatColor.DARK_RED + "Click to enable it."));
         } else {
            var8 = new Icon(Utilities.CreateItem(Material.LIME_BANNER, ChatColor.GREEN + var10, ChatColor.DARK_GREEN + "This world is currently not banned.", ChatColor.DARK_GREEN + "Click to disable it."));
         }

         var8.addAction(new ToggleWorld(var10, var5));
         var8.addAction(new OpenMenu(this.player, new ConditionWorlds(this.player, this.mob, this.drop), var1));
         var3.add(var8);
      }

      Inventory var9 = Utilities.BuildPagedInventory(this.player, var3, ChatColor.DARK_GREEN + "[Drop worlds]", 54, var1, (Action)null, false, this, new DropConditions(this.player, this.mob, this.drop));
      Utilities.AddCornerInfo(var9, this.mob, this.drop);
      return var9;
   }
}
