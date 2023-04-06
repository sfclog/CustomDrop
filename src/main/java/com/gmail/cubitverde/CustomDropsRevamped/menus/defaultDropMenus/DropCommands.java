package com.gmail.cubitverde.CustomDropsRevamped.menus.defaultDropMenus;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.NewSpeaker;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.actions.RemoveList;
import com.gmail.cubitverde.CustomDropsRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Icon;
import java.util.Iterator;
import java.util.LinkedList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class DropCommands implements PageMenu {
   private Player player;

   public DropCommands(Player var1) {
      this.player = var1;
   }

   public Inventory getMenu(int var1) {
      Drop var2 = CustomDropsRevamped.defaultDrop;
      LinkedList var3 = var2.getCommands();
      LinkedList var4 = new LinkedList();
      Iterator var5 = var3.iterator();

      while(var5.hasNext()) {
         String var6 = (String)var5.next();
         Icon var7 = new Icon(Utilities.CreateItem(Material.COMMAND_BLOCK, ChatColor.GREEN + var6, ChatColor.RED + "Shift right click to delete this command."));
         var7.addAction(new RemoveList(var3, var6));
         var7.addAction(new OpenMenu(this.player, new DropCommands(this.player), 1));
         var4.add(var7);
      }

      return Utilities.BuildPagedInventory(this.player, var4, ChatColor.DARK_GREEN + "[Default Commands]", 54, var1, new NewSpeaker(this.player, "dropCommand"), true, this, new DropSettings(this.player));
   }
}
