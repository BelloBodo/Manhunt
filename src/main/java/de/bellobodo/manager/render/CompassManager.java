package de.bellobodo.manager.render;

import de.bellobodo.manager.player.SpeedrunnerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.CompassMeta;

public class CompassManager {

    private static CompassMeta compassMeta;

    private static ItemStack compass = new ItemStack(Material.COMPASS);

    public static void updatePlayerCompass() {
        Bukkit.getOnlinePlayers().forEach(players -> {

            PlayerInventory inventory = players.getInventory();

            if (inventory.contains(Material.COMPASS)) {

                updateCompassMeta(players.getWorld().getEnvironment());

                inventory.all(Material.COMPASS).forEach((index, itemStacks) -> {
                    if (itemStacks.getType() == Material.COMPASS) {
                        itemStacks.setItemMeta(compassMeta);
                    }
                });

                if (inventory.getItemInOffHand().getType() == Material.COMPASS) {
                    inventory.getItemInOffHand().setItemMeta(compassMeta);
                }
            }

        });
    }

    private static void updateCompassMeta(final World.Environment environment) {
        if (compassMeta == null) {
            compass.getItemMeta();

            compassMeta = (CompassMeta) compass.getItemMeta();
            compassMeta.setLodestoneTracked(false);
            compassMeta.setDisplayName(ChatColor.GREEN + "Speedrunner Tracker");
        }
        compassMeta.setLodestone(SpeedrunnerManager.getLocation(environment));
    }
}
