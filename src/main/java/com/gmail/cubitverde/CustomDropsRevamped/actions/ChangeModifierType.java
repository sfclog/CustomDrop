package com.gmail.cubitverde.CustomDropsRevamped.actions;

import com.gmail.cubitverde.CustomDropsRevamped.objects.ChanceModifier;

public class ChangeModifierType implements Action {
   private ChanceModifier modifier;

   public ChangeModifierType(ChanceModifier var1) {
      this.modifier = var1;
   }

   public void run() {
      this.modifier.setAdditive(!this.modifier.isAdditive());
   }
}
