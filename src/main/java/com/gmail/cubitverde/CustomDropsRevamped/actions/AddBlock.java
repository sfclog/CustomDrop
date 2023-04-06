package com.gmail.cubitverde.CustomDropsRevamped.actions;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Block;
import java.util.Iterator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class AddBlock implements Action {
   private Player player;
   private Material material;

   public AddBlock(Player var1, Material var2) {
      this.player = var1;
      this.material = var2;
   }

   public void run() {
      if (!this.material.isBlock() && !CustomDropsRevamped.itemToCrop.containsKey(this.material)) {
         this.player.sendMessage(ChatColor.DARK_RED + "The material " + ChatColor.RED + this.material.toString() + ChatColor.DARK_RED + " is not a block.");
      } else {
         Iterator var1 = CustomDropsRevamped.editedBlocks.iterator();

         Block var2;
         do {
            if (!var1.hasNext()) {
               Block var3 = new Block(this.material);
               CustomDropsRevamped.editedBlocks.add(var3);
               return;
            }

            var2 = (Block)var1.next();
         } while(!var2.getMaterial().equals(this.material));

         this.player.sendMessage(ChatColor.DARK_RED + "The block material " + ChatColor.RED + this.material.toString() + ChatColor.DARK_RED + " had already been added.");
      }
   }
}
