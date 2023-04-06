package com.gmail.cubitverde.CustomDropsRevamped.listeners;

import com.gmail.cubitverde.CustomDropsRevamped.objects.Holder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class LisInventory implements Listener {
   @EventHandler
   private void setEvent(InventoryClickEvent var1) {
      if (var1.getCurrentItem() != null && var1.getCurrentItem().getType() != Material.AIR) {
         if (var1.getInventory().getHolder() instanceof Holder) {
            var1.setCancelled(true);
            Inventory var2 = var1.getInventory();
            Holder var3 = (Holder)var2.getHolder();
            if (!var2.getType().equals(InventoryType.PLAYER)) {
               if (var1.getWhoClicked() instanceof Player) {
                  Player var4 = (Player)var1.getWhoClicked();
                  if (!var4.hasPermission("customdrops.admin")) {
                     var4.closeInventory();
                  } else {
                     boolean var5 = false;
                     if (var1.isRightClick() && var1.isShiftClick()) {
                        var5 = true;
                     }

                     var3.trigger(var1.getSlot(), var5);
                  }
               }
            }
         }
      }
   }
}
