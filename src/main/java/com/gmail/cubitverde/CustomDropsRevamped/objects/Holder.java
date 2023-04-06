package com.gmail.cubitverde.CustomDropsRevamped.objects;

import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.actions.Action;
import com.gmail.cubitverde.CustomDropsRevamped.actions.ConfigPush;
import com.gmail.cubitverde.CustomDropsRevamped.actions.RemoveList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class Holder implements InventoryHolder {
   private Player player;
   private Map<Integer, Icon> icons;
   private String title;
   private int size;

   public Holder(Player var1, Map<Integer, Icon> var2, String var3, int var4) {
      this.player = var1;
      this.icons = var2;
      this.title = var3;
      this.size = var4;
   }

   public Inventory getInventory() {
      return Utilities.BuildInventory(this.player, this.icons, this.title, this.size);
   }

   public void trigger(int var1, boolean var2) {
      if (this.icons.containsKey(var1)) {
         LinkedList var3 = ((Icon)this.icons.get(var1)).getActions();
         boolean var4 = false;
         Iterator var5 = var3.iterator();

         Action var6;
         label34: {
            do {
               if (!var5.hasNext()) {
                  break label34;
               }

               var6 = (Action)var5.next();
            } while(!(var6 instanceof RemoveList) && !(var6 instanceof ConfigPush));

            var4 = true;
         }

         if (var2 || !var4) {
            var5 = var3.iterator();

            while(var5.hasNext()) {
               var6 = (Action)var5.next();
               var6.run();
            }
         }
      }

   }

   public Player getPlayer() {
      return this.player;
   }

   public void setPlayer(Player var1) {
      this.player = var1;
   }

   public Map<Integer, Icon> getIcons() {
      return this.icons;
   }

   public void setIcons(Map<Integer, Icon> var1) {
      this.icons = var1;
   }

   public String getTitle() {
      return this.title;
   }

   public void setTitle(String var1) {
      this.title = var1;
   }

   public int getSize() {
      return this.size;
   }

   public void setSize(int var1) {
      this.size = var1;
   }
}
