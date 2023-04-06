package com.gmail.cubitverde.CustomDropsRevamped.objects;

public class ChanceModifier {
   private boolean isAdditive = false;
   private double addition = 5.0D;
   private double multiplication = 1.5D;

   public boolean isAdditive() {
      return this.isAdditive;
   }

   public void setAdditive(boolean var1) {
      this.isAdditive = var1;
   }

   public double getAddition() {
      return this.addition;
   }

   public void setAddition(double var1) {
      this.addition = var1;
   }

   public double getMultiplication() {
      return this.multiplication;
   }

   public void setMultiplication(double var1) {
      this.multiplication = var1;
   }
}
