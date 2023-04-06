package com.gmail.cubitverde.CustomDropsRevamped.actions;

import java.util.List;

public class RemoveList<T> implements Action {
   private List<T> list;
   T object;

   public RemoveList(List<T> var1, T var2) {
      this.list = var1;
      this.object = var2;
   }

   public void run() {
      this.list.remove(this.object);
   }
}
