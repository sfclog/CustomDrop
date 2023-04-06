package com.gmail.cubitverde.CustomDropsRevamped.actions;

import java.util.List;

public class ToggleWorld implements Action {
   private String name;
   private List<String> worlds;

   public ToggleWorld(String var1, List<String> var2) {
      this.name = var1.toLowerCase();
      this.worlds = var2;
   }

   public void run() {
      if (this.worlds.contains(this.name)) {
         this.worlds.remove(this.name);
      } else {
         this.worlds.add(this.name);
      }

   }
}
