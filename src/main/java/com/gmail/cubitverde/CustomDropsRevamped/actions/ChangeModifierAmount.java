package com.gmail.cubitverde.CustomDropsRevamped.actions;

import com.gmail.cubitverde.CustomDropsRevamped.objects.ChanceModifier;

public class ChangeModifierAmount implements Action {
   private ChanceModifier modifier;
   private double change;

   public ChangeModifierAmount(ChanceModifier var1, double var2) {
      this.modifier = var1;
      this.change = var2;
   }

   public void run() {
      if (this.modifier.isAdditive()) {
         this.modifier.setAddition(this.modifier.getAddition() + this.change);
      } else {
         this.modifier.setMultiplication(this.modifier.getMultiplication() + this.change);
      }

   }
}
