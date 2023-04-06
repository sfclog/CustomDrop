package com.gmail.cubitverde.CustomDropsRevamped.menus.mobMenus;

import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.NewDrop;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Icon;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Mob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MobDrops implements PageMenu {
   private Player player;
   private Mob mob;

   public MobDrops(Player var1, Mob var2) {
      this.player = var1;
      this.mob = var2;
   }

   public Inventory getMenu(int var1) {
      LinkedList var2 = this.mob.getDrops();
      LinkedList var3 = new LinkedList();
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         Drop var5 = (Drop)var4.next();
         ItemStack var6 = var5.getItem().clone();
         ItemMeta var7 = var6.getItemMeta();
         Object var8;
         if (var7.hasLore()) {
            var8 = var7.getLore();
         } else {
            var8 = new ArrayList();
         }

         ((List)var8).add(ChatColor.DARK_GRAY + "Drop ID: " + ChatColor.GRAY + var5.getId());
         var7.setLore((List)var8);
         var6.setItemMeta(var7);
         Icon var9 = new Icon(var6);
         var9.addAction(new OpenMenu(this.player, new DropSettings(this.player, this.mob, var5)));
         var3.add(var9);
      }

      return Utilities.BuildPagedInventory(this.player, var3, ChatColor.DARK_GREEN + "[Mob Drops]", 54, var1, new NewDrop(this.mob.getDrops()), false, this, new MobMenu(this.player, this.mob));
   }
}
