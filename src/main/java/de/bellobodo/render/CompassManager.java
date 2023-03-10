package de.bellobodo.render;

import de.bellobodo.manager.SpeedrunnerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;

public class CompassManager {

    private static CompassMeta compassMeta;

    public static void updatePlayerCompass() {
        Bukkit.getOnlinePlayers().forEach(players -> {

            if (players.getInventory().contains(Material.COMPASS)) {

                players.getInventory().all(Material.COMPASS).forEach((index, itemStacks) -> {

                    updateCompassMeta(players.getWorld().getEnvironment());

                    if (itemStacks.getType() == Material.COMPASS) {
                        itemStacks.setItemMeta(compassMeta);
                    }
                });
            }

        });
    }

    private static void updateCompassMeta(final World.Environment environment) {
        if (compassMeta == null) {
            ItemStack stack = new ItemStack(Material.COMPASS);

            compassMeta = (CompassMeta) stack.getItemMeta();
            compassMeta.setLodestoneTracked(false);
            compassMeta.setDisplayName(ChatColor.GREEN + "Speedrunner Tracker");
        }
        compassMeta.setLodestone(SpeedrunnerManager.getLocation(environment));
    }
}
