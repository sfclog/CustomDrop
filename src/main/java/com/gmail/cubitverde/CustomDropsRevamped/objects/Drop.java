package com.gmail.cubitverde.CustomDropsRevamped.objects;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import java.util.LinkedList;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.inventory.ItemStack;

public class Drop {
   private int id;
   private ItemStack item;
   private double chance;
   private String color;
   private Type shape;
   private boolean effect;
   private boolean defaultDrops;
   private boolean spawnerDrops;
   private boolean eggDrops;
   private boolean placedDrops;
   private Conditions conditions;
   private LinkedList<String> commands;

   public Drop() {
   }

   public Drop(ItemStack var1) {
      this.id = CustomDropsRevamped.dropId++;
      this.item = var1;
      this.chance = CustomDropsRevamped.defaultDrop.getChance();
      this.color = CustomDropsRevamped.defaultDrop.getColor();
      this.shape = CustomDropsRevamped.defaultDrop.getShape();
      this.effect = CustomDropsRevamped.defaultDrop.getEffect();
      this.conditions = new Conditions(CustomDropsRevamped.defaultConditions);
      this.defaultDrops = CustomDropsRevamped.defaultDrop.getDefaultDrops();
      this.spawnerDrops = CustomDropsRevamped.defaultDrop.getSpawnerDrops();
      this.eggDrops = CustomDropsRevamped.defaultDrop.getEggDrops();
      this.placedDrops = CustomDropsRevamped.defaultDrop.getPlacedDrops();
      this.commands = new LinkedList(CustomDropsRevamped.defaultDrop.getCommands());
   }

   public Drop(Drop var1) {
      this.id = CustomDropsRevamped.dropId++;
      this.item = var1.getItem();
      this.chance = var1.getChance();
      this.color = var1.getColor();
      this.shape = var1.getShape();
      this.effect = var1.getEffect();
      this.conditions = new Conditions(var1.getConditions());
      this.defaultDrops = var1.getDefaultDrops();
      this.spawnerDrops = var1.getSpawnerDrops();
      this.eggDrops = var1.getEggDrops();
      this.placedDrops = var1.getPlacedDrops();
      this.commands = new LinkedList(var1.getCommands());
   }

   public void toggleBool(String var1) {
      byte var3 = -1;
      switch(var1.hashCode()) {
      case -1306084975:
         if (var1.equals("effect")) {
            var3 = 0;
         }
         break;
      case -675239517:
         if (var1.equals("defaultDrops")) {
            var3 = 1;
         }
         break;
      case -131108257:
         if (var1.equals("eggDrops")) {
            var3 = 3;
         }
         break;
      case 444208423:
         if (var1.equals("placedDrops")) {
            var3 = 4;
         }
         break;
      case 1553060572:
         if (var1.equals("spawnerDrops")) {
            var3 = 2;
         }
      }

      switch(var3) {
      case 0:
         this.effect = !this.effect;
         return;
      case 1:
         this.defaultDrops = !this.defaultDrops;
         return;
      case 2:
         this.spawnerDrops = !this.spawnerDrops;
         return;
      case 3:
         this.eggDrops = !this.eggDrops;
         return;
      case 4:
         this.placedDrops = !this.placedDrops;
         return;
      default:
      }
   }

   public int getId() {
      return this.id;
   }

   public void setId(int var1) {
      this.id = var1;
   }

   public ItemStack getItem() {
      return this.item;
   }

   public void setItem(ItemStack var1) {
      if (var1 != null) {
         this.item = var1;
      }

   }

   public double getChance() {
      return this.chance;
   }

   public void setChance(double var1) {
      this.chance = var1;
   }

   public String getColor() {
      return this.color;
   }

   public void setColor(String var1) {
      if (var1 != null) {
         this.color = var1;
      }

   }

   public Type getShape() {
      return this.shape;
   }

   public void setShape(Type var1) {
      if (var1 != null) {
         this.shape = var1;
      }

   }

   public boolean getEffect() {
      return this.effect;
   }

   public void setEffect(boolean var1) {
      this.effect = var1;
   }

   public boolean getDefaultDrops() {
      return this.defaultDrops;
   }

   public void setDefaultDrops(boolean var1) {
      this.defaultDrops = var1;
   }

   public boolean getSpawnerDrops() {
      return this.spawnerDrops;
   }

   public void setSpawnerDrops(boolean var1) {
      this.spawnerDrops = var1;
   }

   public boolean getEggDrops() {
      return this.eggDrops;
   }

   public void setEggDrops(boolean var1) {
      this.eggDrops = var1;
   }

   public boolean getPlacedDrops() {
      return this.placedDrops;
   }

   public void setPlacedDrops(boolean var1) {
      this.placedDrops = var1;
   }

   public Conditions getConditions() {
      return this.conditions;
   }

   public void setConditions(Conditions var1) {
      if (var1 != null) {
         this.conditions = var1;
      }

   }

   public LinkedList<String> getCommands() {
      return this.commands;
   }

   public void setCommands(LinkedList<String> var1) {
      if (var1 != null) {
         this.commands = var1;
      }

   }
}
