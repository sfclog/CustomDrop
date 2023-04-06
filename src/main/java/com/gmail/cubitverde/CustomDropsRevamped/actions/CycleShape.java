package com.gmail.cubitverde.CustomDropsRevamped.actions;

import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import org.bukkit.FireworkEffect.Type;

public class CycleShape implements Action {
   private Drop drop;

   public CycleShape(Drop var1) {
      this.drop = var1;
   }

   public void run() {
      Type var1 = this.drop.getShape();
      this.drop.setShape(Utilities.GetNextShape(var1));
   }
}
