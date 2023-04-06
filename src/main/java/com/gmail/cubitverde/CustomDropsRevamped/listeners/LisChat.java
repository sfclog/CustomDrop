package com.gmail.cubitverde.CustomDropsRevamped.listeners;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Speaker;
import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class LisChat implements Listener {
   @EventHandler
   private void setEvent(AsyncPlayerChatEvent var1) {
      Player var2 = var1.getPlayer();
      UUID var3 = var2.getUniqueId();
      if (CustomDropsRevamped.speakers.containsKey(var3)) {
         var1.setCancelled(true);
         Speaker var4 = (Speaker)CustomDropsRevamped.speakers.get(var3);
         var4.trigger(var1.getMessage());
      }
   }
}
