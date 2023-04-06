package com.gmail.cubitverde.CustomDropsRevamped.actions;

import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import org.bukkit.inventory.ItemStack;

public class ChangeCondItem implements Action {
   private Drop drop;
   private ItemStack item;

   public ChangeCondItem(Drop var1, ItemStack var2) {
      this.drop = var1;
      this.item = var2;
   }

   public void run() {
      this.drop.getConditions().setItemUsed(this.item.clone());
   }
}
