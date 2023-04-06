package com.gmail.cubitverde.CustomDropsRevamped.objects;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bukkit.entity.EntityType;

public class Mob {
   private EntityType type;
   private LinkedList<Drop> drops;
   private boolean vanillaDrops;
   private List<String> inactiveWorlds;

   public Mob(EntityType var1) {
      this.type = var1;
      this.drops = new LinkedList();
      this.vanillaDrops = true;
      this.inactiveWorlds = new ArrayList();
   }

   public Mob(Mob var1) {
      this.type = var1.getType();
      this.drops = var1.getDrops();
      this.vanillaDrops = var1.getVanillaDrops();
      this.inactiveWorlds = var1.getInactiveWorlds();
   }

   public void toggleBool(String var1) {
      byte var3 = -1;
      switch(var1.hashCode()) {
      case -1950099287:
         if (var1.equals("vanillaDrops")) {
            var3 = 0;
         }
      default:
         switch(var3) {
         case 0:
            this.vanillaDrops = !this.vanillaDrops;
            return;
         default:
         }
      }
   }

   public EntityType getType() {
      return this.type;
   }

   public void setType(EntityType var1) {
      if (var1 != null) {
         this.type = var1;
      }

   }

   public LinkedList<Drop> getDrops() {
      return this.drops;
   }

   public void setDrops(LinkedList<Drop> var1) {
      if (var1 != null) {
         this.drops = var1;
      }

   }

   public boolean getVanillaDrops() {
      return this.vanillaDrops;
   }

   public void setVanillaDrops(boolean var1) {
      this.vanillaDrops = var1;
   }

   public List<String> getInactiveWorlds() {
      return this.inactiveWorlds;
   }

   public void setInactiveWorlds(List<String> var1) {
      if (var1 != null) {
         this.inactiveWorlds = var1;
      }

   }
}
