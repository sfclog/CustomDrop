package com.gmail.cubitverde.CustomDropsRevamped;

import com.gmail.cubitverde.CustomDropsRevamped.actions.OpenMenu;
import com.gmail.cubitverde.CustomDropsRevamped.listeners.*;
import com.gmail.cubitverde.CustomDropsRevamped.menus.MainMenu;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Block;
import com.gmail.cubitverde.CustomDropsRevamped.objects.ChanceModifier;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Conditions;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Drop;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Mob;
import com.gmail.cubitverde.CustomDropsRevamped.objects.Speaker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomDropsRevamped extends JavaPlugin implements CommandExecutor {
   public static int dropId = 0;
   public static LinkedList<Block> editedBlocks = new LinkedList();
   public static boolean afkDrops;
   public static List<Firework> dropFireworks = new ArrayList();
   public static Conditions defaultConditions = new Conditions();
   public static Drop defaultDrop = new Drop();
   public static Map<UUID, Speaker> speakers = new HashMap();
   public static ChanceModifier lootingModifier = new ChanceModifier();
   public static Map<Material, Material> cropToItem = new HashMap();
   public static List<Material> damageables = new ArrayList();
   public static Map<Material, Material> itemToCrop = new HashMap();
   public static List<Mob> editedMobs = new ArrayList();
   public static ChanceModifier fortuneModifier = new ChanceModifier();
   public static List<org.bukkit.block.Block> placedBlocks = new ArrayList();
   public int e1e26c18f10443;
   public static Map<String, Material> mobIcons = new HashMap();
   public static CustomDropsRevamped plugin;
   public static List<UUID> spawnereggMobs = new ArrayList();
   public static List<UUID> spawnerMobs = new ArrayList();


   static {
      CustomDropsRevamped.mobIcons = new HashMap<String, Material>();
      CustomDropsRevamped.editedMobs = new ArrayList<Mob>();
      CustomDropsRevamped.editedBlocks = new LinkedList<Block>();
      CustomDropsRevamped.defaultDrop = new Drop();
      CustomDropsRevamped.defaultConditions = new Conditions();
      CustomDropsRevamped.dropId = 0;
      CustomDropsRevamped.damageables = new ArrayList<Material>();
      CustomDropsRevamped.itemToCrop = new HashMap<Material, Material>();
      CustomDropsRevamped.cropToItem = new HashMap<Material, Material>();
      CustomDropsRevamped.speakers = new HashMap<UUID, Speaker>();
      CustomDropsRevamped.dropFireworks = new ArrayList<Firework>();
      CustomDropsRevamped.spawnerMobs = new ArrayList<UUID>();
      CustomDropsRevamped.spawnereggMobs = new ArrayList<UUID>();
      CustomDropsRevamped.placedBlocks = new ArrayList<org.bukkit.block.Block>();
      CustomDropsRevamped.fortuneModifier = new ChanceModifier();
      CustomDropsRevamped.lootingModifier = new ChanceModifier();
   }

   @Override
   public void onEnable() {
      CustomDropsRevamped.plugin = this;
      getServer().getPluginManager().registerEvents(new LisInventory(), this);
      getServer().getPluginManager().registerEvents(new LisChat(), this);
      getServer().getPluginManager().registerEvents(new LisMobdeath(), this);
      getServer().getPluginManager().registerEvents(new LisMobspawn(), this);
      getServer().getPluginManager().registerEvents(new LisBlockplace(), this);
      getServer().getPluginManager().registerEvents(new LisBlockbreak(), this);
      getServer().getPluginManager().registerEvents(new LisDamaged(), this);

      //reg comand
      getServer().getPluginCommand("customdrops").setExecutor(this);
   }

   public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] array) {
      if (!(commandSender instanceof Player)) {
         commandSender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "This plugin can only be used by players.");
         return true;
      }
      final Player player = (Player)commandSender;
      new OpenMenu(player, new MainMenu(player)).run();
      return true;
   }
}
