package com.gmail.cubitverde.CustomDropsRevamped.objects;

import com.gmail.cubitverde.CustomDropsRevamped.actions.Action;
import java.util.LinkedList;
import org.bukkit.inventory.ItemStack;

public class Icon {
   private ItemStack item;
   private LinkedList<Action> actions = new LinkedList();

   public Icon(ItemStack var1) {
      this.item = var1;
   }

   public void setItem(ItemStack var1) {
      this.item = var1;
   }

   public ItemStack getItem() {
      return this.item;
   }

   public void addAction(Action var1) {
      this.actions.add(var1);
   }

   public void setActions(LinkedList<Action> var1) {
      this.actions = var1;
   }

   public LinkedList<Action> getActions() {
      return this.actions;
   }
}
