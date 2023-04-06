package com.gmail.cubitverde.CustomDropsRevamped.actions;

import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;

public class CycleColor implements Action {
   private Drop drop;

   public CycleColor(Drop var1) {
      this.drop = var1;
   }

   public void run() {
      String var1 = this.drop.getColor();
      this.drop.setColor(Utilities.GetNextColor(var1));
   }
}
