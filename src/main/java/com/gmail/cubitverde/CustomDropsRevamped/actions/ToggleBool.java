package com.gmail.cubitverde.CustomDropsRevamped.actions;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Block;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Conditions;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Mob;

public class ToggleBool implements Action {
   private Mob mob;
   private Block block;
   private Drop drop;
   private Conditions conditions;
   private String toggle;

   public ToggleBool(Mob var1, String var2) {
      this.mob = var1;
      this.toggle = var2;
   }

   public ToggleBool(Block var1, String var2) {
      this.block = var1;
      this.toggle = var2;
   }

   public ToggleBool(Drop var1, String var2) {
      this.drop = var1;
      this.toggle = var2;
   }

   public ToggleBool(Conditions var1, String var2) {
      this.conditions = var1;
      this.toggle = var2;
   }

   public ToggleBool(String var1) {
      this.toggle = var1;
   }

   public void run() {
      if (this.mob != null) {
         this.mob.toggleBool(this.toggle);
      } else if (this.block != null) {
         this.block.toggleBool(this.toggle);
      } else if (this.drop != null) {
         this.drop.toggleBool(this.toggle);
      } else if (this.conditions != null) {
         this.conditions.toggleBool(this.toggle);
      } else {
         String var1 = this.toggle;
         byte var2 = -1;
         switch(var1.hashCode()) {
         case 714597918:
            if (var1.equals("afkDrops")) {
               var2 = 0;
            }
         default:
            switch(var2) {
            case 0:
               CustomDropsRevamped.afkDrops = !CustomDropsRevamped.afkDrops;
               return;
            }
         }
      }

   }
}
