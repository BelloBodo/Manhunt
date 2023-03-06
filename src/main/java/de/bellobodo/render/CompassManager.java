package de.bellobodo.render;

import de.bellobodo.manager.SpeedrunnerManager;
import org.bukkit.Bukkit;
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
            compassMeta = (CompassMeta) new ItemStack(Material.COMPASS);
        }
        compassMeta.setLodestone(SpeedrunnerManager.getLocation(environment));
        compassMeta.setLodestoneTracked(false);
    }
}
