package com.gmail.cubitverde.CustomDropsRevamped.menus.blockMenus;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.menus.MainMenu;
import com.gmail.cubitverde.CustomDropsRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Block;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Icon;
import java.util.Iterator;
import java.util.LinkedList;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class BlocksList implements PageMenu {
   private Player player;

   public BlocksList(Player var1) {
      this.player = var1;
   }

   public Inventory getMenu(int var1) {
      LinkedList var2 = new LinkedList();
      Iterator var3 = CustomDropsRevamped.editedBlocks.iterator();

      while(var3.hasNext()) {
         Block var4 = (Block)var3.next();
         Icon var5 = new Icon(Utilities.CreateItem(var4.getMaterial(), ChatColor.GREEN + var4.getMaterial().toString()));
         var5.addAction(new OpenMenu(this.player, new BlockMenu(this.player, var4)));
         var2.add(var5);
      }

      return Utilities.BuildPagedInventory(this.player, var2, ChatColor.DARK_GREEN + "[Blocks List]", 54, var1, new OpenMenu(this.player, new NewBlock(this.player)), true, this, new MainMenu(this.player));
   }
}
