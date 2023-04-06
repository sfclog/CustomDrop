package com.gmail.cubitverde.CustomDropsRevamped.actions;

import com.gmail.cubitverde.CustomDropsRevamped.menus.Menu;
import com.gmail.cubitverde.CustomDropsRevamped.menus.PageMenu;
import org.bukkit.entity.Player;

public class OpenMenu implements Action {
   private Player player;
   private Menu menu;
   private PageMenu pageMenu;
   private int page;

   public OpenMenu(Player var1, Menu var2) {
      this.player = var1;
      this.menu = var2;
   }

   public OpenMenu(Player var1, PageMenu var2, int var3) {
      this.player = var1;
      this.pageMenu = var2;
      this.page = var3;
   }

   public void run() {
      if (this.menu != null) {
         this.player.openInventory(this.menu.getMenu());
      } else if (this.pageMenu != null) {
         this.player.openInventory(this.pageMenu.getMenu(this.page));
      }

   }
}
