package com.gmail.cubitverde.CustomDropsRevamped.menus.mobMenus;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.Action;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.menus.MainMenu;
import com.gmail.cubitverde.CustomDropsRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Icon;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Mob;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MobsList implements PageMenu {
   private Player player;

   public MobsList(Player var1) {
      this.player = var1;
   }

   public Inventory getMenu(int var1) {
      LinkedList var2 = new LinkedList();
      LinkedList var3 = new LinkedList();
      LinkedList var4 = new LinkedList(CustomDropsRevamped.mobIcons.keySet());
      Collections.sort(var4);
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         String var6 = (String)var5.next();
         var3.add(Utilities.CreateItem((Material)CustomDropsRevamped.mobIcons.get(var6), ChatColor.GREEN + var6));
      }

      var5 = var3.iterator();

      while(var5.hasNext()) {
         ItemStack var9 = (ItemStack)var5.next();
         Mob var7 = Utilities.GetObjMob(var9.getItemMeta().getDisplayName().substring(2));
         Icon var8 = new Icon(var9);
         var8.addAction(new OpenMenu(this.player, new MobMenu(this.player, var7)));
         var2.add(var8);
      }

      return Utilities.BuildPagedInventory(this.player, var2, ChatColor.DARK_GREEN + "[Mobs List]", 54, var1, (Action)null, false, this, new MainMenu(this.player));
   }
}
