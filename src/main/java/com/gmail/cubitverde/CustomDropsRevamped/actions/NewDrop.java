package com.gmail.cubitverde.CustomDropsRevamped.actions;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import java.util.LinkedList;

public class NewDrop implements Action {
   private LinkedList<Drop> drops;

   public NewDrop(LinkedList<Drop> var1) {
      this.drops = var1;
   }

   public void run() {
      this.drops.add(new Drop(CustomDropsRevamped.defaultDrop.getItem().clone()));
   }
}
