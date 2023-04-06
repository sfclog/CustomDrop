package com.gmail.cubitverde.CustomDropsRevamped.listeners;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class LisDamaged implements Listener {
   @EventHandler
   private void setEvent(EntityDamageByEntityEvent var1) {
      if (var1.getDamager() instanceof Firework) {
         Firework var2 = (Firework)var1.getDamager();
         if (CustomDropsRevamped.dropFireworks.contains(var2)) {
            var1.setCancelled(true);
         }
      }

   }
}
