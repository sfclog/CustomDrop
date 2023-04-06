package com.gmail.cubitverde.CustomDropsRevamped.listeners;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class LisBlockplace implements Listener {
   @EventHandler
   private void setEvent(BlockPlaceEvent var1) {
      if (!var1.isCancelled()) {
         CustomDropsRevamped.placedBlocks.add(var1.getBlockPlaced());
      }
   }
}
