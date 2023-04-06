package com.gmail.cubitverde.CustomDropsRevamped.actions;

import com.gmail.cubitverde.CustomDropsRevamped.menus.PageMenu;
import org.bukkit.entity.Player;

public class ChangePage implements Action {
   private Player player;
   private PageMenu pageMenu;
   private int page;

   public ChangePage(Player var1, PageMenu var2, int var3) {
      this.player = var1;
      this.pageMenu = var2;
      this.page = var3;
   }

   public void run() {
      this.player.openInventory(this.pageMenu.getMenu(this.page));
   }
}
