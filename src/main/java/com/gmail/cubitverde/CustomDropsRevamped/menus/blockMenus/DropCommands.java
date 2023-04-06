package com.gmail.cubitverde.CustomDropsRevamped.menus.blockMenus;

import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.NewSpeaker;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.actions.RemoveList;
import com.gmail.cubitverde.CustomDropsRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Block;
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
   private Block block;
   private Drop drop;

   public DropCommands(Player var1, Block var2, Drop var3) {
      this.player = var1;
      this.block = var2;
      this.drop = var3;
   }

   public Inventory getMenu(int var1) {
      LinkedList var2 = this.drop.getCommands();
      LinkedList var3 = new LinkedList();
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         String var5 = (String)var4.next();
         Icon var6 = new Icon(Utilities.CreateItem(Material.COMMAND_BLOCK, ChatColor.GREEN + var5, ChatColor.RED + "Shift right click to delete this command."));
         var6.addAction(new RemoveList(var2, var5));
         var6.addAction(new OpenMenu(this.player, new DropCommands(this.player, this.block, this.drop), 1));
         var3.add(var6);
      }

      return Utilities.BuildPagedInventory(this.player, var3, ChatColor.DARK_GREEN + "[Drop Commands]", 54, var1, new NewSpeaker(this.player, this.block, this.drop, "dropCommand"), true, this, new DropSettings(this.player, this.block, this.drop));
   }
}
