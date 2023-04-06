package com.gmail.cubitverde.CustomDropsRevamped.listeners;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Conditions;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class LisBlockbreak implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   private void setEvent(BlockBreakEvent var1) {
      if (!var1.isCancelled()) {
         Player var2 = var1.getPlayer();
         Block var3 = var1.getBlock();
         Location var4 = var3.getLocation();
         com.gmail.cubitverde.CustomDropsRevamped.objects.Block var5 = null;
         Iterator var6 = CustomDropsRevamped.editedBlocks.iterator();

         while(var6.hasNext()) {
            com.gmail.cubitverde.CustomDropsRevamped.objects.Block var7 = (com.gmail.cubitverde.CustomDropsRevamped.objects.Block)var6.next();
            Material var8 = var3.getType();
            if (CustomDropsRevamped.cropToItem.containsKey(var8)) {
               var8 = (Material)CustomDropsRevamped.cropToItem.get(var8);
            }

            if (var7.getMaterial().equals(var8)) {
               var5 = var7;
               break;
            }
         }

         if (var5 != null) {
            if (!var2.getGameMode().equals(GameMode.CREATIVE)) {
               if (!var5.getInactiveWorlds().contains(var3.getWorld().getName().toLowerCase())) {
                  if (var3.getBlockData() instanceof Ageable) {
                     Ageable var21 = (Ageable)var3.getBlockData();
                     if (var21.getAge() != var21.getMaximumAge() && !var3.getType().equals(Material.SUGAR_CANE)) {
                        return;
                     }
                  }

                  if (!var5.getVanillaDrops()) {
                     var1.setDropItems(false);
                  }

                  LinkedList var22 = var5.getDrops();
                  Iterator var23 = var22.iterator();

                  label182:
                  while(true) {
                     Location var12;
                     boolean var13;
                     Drop var24;
                     do {
                        Conditions var9;
                        double var10;
                        do {
                           do {
                              do {
                                 do {
                                    do {
                                       do {
                                          do {
                                             if (!var23.hasNext()) {
                                                return;
                                             }

                                             var24 = (Drop)var23.next();
                                             var9 = var24.getConditions();
                                             var10 = var24.getChance();
                                          } while(!var24.getPlacedDrops() && CustomDropsRevamped.placedBlocks.contains(var3));
                                       } while(var9.getCheckItemUsed() && !var2.getInventory().getItemInMainHand().getType().equals(var9.getItemUsed().getType()));
                                    } while(var9.getCheckItemUsedMeta() && (var2.getInventory().getItemInMainHand().getItemMeta() == null || !var2.getInventory().getItemInMainHand().getItemMeta().equals(var9.getItemUsed().getItemMeta())));
                                 } while(var9.getCheckPermission() && !var2.hasPermission(var9.getPermission()));
                              } while(var9.getCheckBannedWorlds() && var9.getBannedWorlds().contains(var2.getWorld().getName().toLowerCase()));
                           } while(var9.getCheckMinPlayers() && CustomDropsRevamped.plugin.getServer().getOnlinePlayers().size() < var9.getMinPlayers());
                        } while(var9.getCheckMaxPlayers() && CustomDropsRevamped.plugin.getServer().getOnlinePlayers().size() > var9.getMaxPlayers());

                        var12 = new Location(var4.getWorld(), var4.getX() + 0.5D, var4.getY() + 0.5D, var4.getZ() + 0.5D);
                        var13 = false;
                        if (Math.random() < var10) {
                           if (!var24.getItem().getType().equals(Material.BARRIER)) {
                              var4.getWorld().dropItem(var12, var24.getItem());
                           }

                           var13 = true;
                        }

                        if (var9.getFortuneModifier()) {
                           try {
                              int var14 = var2.getItemInHand().getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);

                              for(int var15 = 0; var15 < var14; ++var15) {
                                 if (CustomDropsRevamped.fortuneModifier.isAdditive()) {
                                    if (Math.random() < CustomDropsRevamped.fortuneModifier.getAddition() / 100.0D && !var24.getItem().getType().equals(Material.BARRIER)) {
                                       var4.getWorld().dropItem(var12, var24.getItem());
                                       var13 = true;
                                    }
                                 } else if (Math.random() < (CustomDropsRevamped.fortuneModifier.getMultiplication() - 1.0D) * var10 && !var24.getItem().getType().equals(Material.BARRIER)) {
                                    var4.getWorld().dropItem(var12, var24.getItem());
                                    var13 = true;
                                 }
                              }
                           } catch (Exception var20) {
                           }
                        }
                     } while(!var13);

                     if (var24.getEffect()) {
                        Firework var25 = (Firework)var12.getWorld().spawnEntity(var12, EntityType.FIREWORK);
                        FireworkMeta var27 = var25.getFireworkMeta();
                        var27.setPower(0);
                        var27.addEffect(FireworkEffect.builder().withColor(Utilities.GetColorFromString(var24.getColor())).with(var24.getShape()).build());
                        var25.setFireworkMeta(var27);
                        var25.detonate();
                        CustomDropsRevamped.dropFireworks.add(var25);
                     }

                     Iterator var26 = var24.getCommands().iterator();

                     while(true) {
                        ConsoleCommandSender var16;
                        List var17;
                        do {
                           if (!var26.hasNext()) {
                              continue label182;
                           }

                           String var28 = (String)var26.next();
                           var16 = CustomDropsRevamped.plugin.getServer().getConsoleSender();
                           var17 = Utilities.ReadMobCommandPlaceholders(var28, var2, var4);
                        } while(var17 == null);

                        Iterator var18 = var17.iterator();

                        while(var18.hasNext()) {
                           String var19 = (String)var18.next();
                           CustomDropsRevamped.plugin.getServer().dispatchCommand(var16, var19);
                        }
                     }
                  }
               }
            }
         }
      }
   }
}
