package com.gmail.cubitverde.CustomDropsRevamped.listeners;

import com.gmail.cubitverde.CustomDropsRevamped.CustomDropsRevamped;
import com.gmail.cubitverde.CustomDropsRevamped.Utilities;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Conditions;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Mob;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class LisMobdeath implements Listener {
   @EventHandler
   private void setEvent(EntityDeathEvent var1) {
      EntityType var2 = var1.getEntityType();
      LivingEntity var3 = var1.getEntity();
      List var4 = var1.getDrops();
      Player var5 = var3.getKiller();
      Location var6 = var3.getLocation();
      Mob var7 = null;
      Iterator var8 = CustomDropsRevamped.editedMobs.iterator();

      while(var8.hasNext()) {
         Mob var9 = (Mob)var8.next();
         if (var9.getType().equals(var2)) {
            var7 = var9;
            break;
         }
      }

      if (var7 != null) {
         if (!var7.getInactiveWorlds().contains(var3.getWorld().getName().toLowerCase())) {
            if (!var7.getVanillaDrops()) {
               var4.clear();
            }

            LinkedList var23 = var7.getDrops();
            Iterator var24 = var23.iterator();

            label215:
            while(true) {
               Drop var10;
               boolean var25;
               do {
                  Conditions var11;
                  double var12;
                  do {
                     do {
                        do {
                           do {
                              do {
                                 do {
                                    do {
                                       while(true) {
                                          do {
                                             do {
                                                do {
                                                   if (!var24.hasNext()) {
                                                      return;
                                                   }

                                                   var10 = (Drop)var24.next();
                                                   var11 = var10.getConditions();
                                                   var12 = var10.getChance();
                                                } while(!var10.getSpawnerDrops() && CustomDropsRevamped.spawnerMobs.contains(var3.getUniqueId()));
                                             } while(!var10.getEggDrops() && CustomDropsRevamped.spawnereggMobs.contains(var3.getUniqueId()));
                                          } while(!CustomDropsRevamped.spawnerMobs.contains(var3.getUniqueId()) && !CustomDropsRevamped.spawnereggMobs.contains(var3.getUniqueId()) && !var10.getDefaultDrops());

                                          if (!var11.getCheckMobName()) {
                                             break;
                                          }

                                          try {
                                             String var14 = var3.getName().toLowerCase().substring(var3.getName().length() - var11.getMobName().length());
                                             String var15 = var11.getMobName().toLowerCase();
                                             if (!var14.equals(var15)) {
                                                continue;
                                             }
                                             break;
                                          } catch (Exception var21) {
                                          }
                                       }
                                    } while(var11.getCheckItemUsed() && (var5 == null || !var5.getInventory().getItemInMainHand().getType().equals(var11.getItemUsed().getType())));
                                 } while(var11.getCheckItemUsedMeta() && (var5 == null || var5.getInventory().getItemInMainHand().getItemMeta() == null || !var5.getInventory().getItemInMainHand().getItemMeta().equals(var11.getItemUsed().getItemMeta())));
                              } while(var11.getCheckPermission() && (var5 == null || !var5.hasPermission(var11.getPermission())));
                           } while(var11.getCheckBannedWorlds() && var11.getBannedWorlds().contains(var3.getWorld().getName().toLowerCase()));
                        } while(var11.getCheckMinPlayers() && CustomDropsRevamped.plugin.getServer().getOnlinePlayers().size() < var11.getMinPlayers());
                     } while(var11.getCheckMaxPlayers() && CustomDropsRevamped.plugin.getServer().getOnlinePlayers().size() > var11.getMaxPlayers());
                  } while(!CustomDropsRevamped.afkDrops && var5 == null);

                  var25 = false;
                  if (Math.random() < var12) {
                     if (var10.getItem().getType() != Material.BARRIER) {
                        var4.add(var10.getItem().clone());
                     }

                     var25 = true;
                  }

                  if (var11.getLootingModifier()) {
                     try {
                        int var26 = var5.getItemInHand().getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_MOBS);

                        for(int var16 = 0; var16 < var26; ++var16) {
                           if (CustomDropsRevamped.lootingModifier.isAdditive()) {
                              if (Math.random() < CustomDropsRevamped.lootingModifier.getAddition() / 100.0D && !var10.getItem().getType().equals(Material.BARRIER)) {
                                 var4.add(var10.getItem().clone());
                                 var25 = true;
                              }
                           } else if (Math.random() < (CustomDropsRevamped.lootingModifier.getMultiplication() - 1.0D) * var12 && !var10.getItem().getType().equals(Material.BARRIER)) {
                              var4.add(var10.getItem().clone());
                              var25 = true;
                           }
                        }
                     } catch (Exception var22) {
                     }
                  }
               } while(!var25);

               if (var10.getEffect()) {
                  Firework var27 = (Firework)var3.getLocation().getWorld().spawnEntity(var6, EntityType.FIREWORK);
                  FireworkMeta var29 = var27.getFireworkMeta();
                  var29.setPower(0);
                  var29.addEffect(FireworkEffect.builder().withColor(Utilities.GetColorFromString(var10.getColor())).with(var10.getShape()).build());
                  var27.setFireworkMeta(var29);
                  var27.detonate();
                  CustomDropsRevamped.dropFireworks.add(var27);
               }

               Iterator var28 = var10.getCommands().iterator();

               while(true) {
                  ConsoleCommandSender var17;
                  List var18;
                  do {
                     if (!var28.hasNext()) {
                        continue label215;
                     }

                     String var30 = (String)var28.next();
                     var17 = CustomDropsRevamped.plugin.getServer().getConsoleSender();
                     var18 = Utilities.ReadMobCommandPlaceholders(var30, var5, var6);
                  } while(var18 == null);

                  Iterator var19 = var18.iterator();

                  while(var19.hasNext()) {
                     String var20 = (String)var19.next();
                     CustomDropsRevamped.plugin.getServer().dispatchCommand(var17, var20);
                  }
               }
            }
         }
      }
   }
}
