package com.gmail.cubitverde.CustomDropsRevamped.listeners;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class LisMobspawn implements Listener {
   @EventHandler
   private void setEvent(CreatureSpawnEvent var1) {
      if (!var1.isCancelled()) {
         if (var1.getSpawnReason().equals(SpawnReason.SPAWNER)) {
            CustomDropsRevamped.spawnerMobs.add(var1.getEntity().getUniqueId());
         } else if (var1.getSpawnReason().equals(SpawnReason.SPAWNER_EGG)) {
            CustomDropsRevamped.spawnereggMobs.add(var1.getEntity().getUniqueId());
         }

         if (var1.getSpawnReason().equals(SpawnReason.SLIME_SPLIT)) {
            CustomDropsRevamped.spawnerMobs.add(var1.getEntity().getUniqueId());
         }

      }
   }
}
