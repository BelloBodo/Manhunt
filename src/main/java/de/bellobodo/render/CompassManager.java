package de.bellobodo.render;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;

public class CompassManager {

    private static ItemStack compass;

    public static void updatePlayerCompass() {
        Bukkit.getOnlinePlayers().forEach(players -> {
            if (players.getInventory().contains(Material.COMPASS)) {
                players.getInventory().all(Material.COMPASS);
                //TODO Alle Compass mit neuem Wert aktualisieren
            }

        });
    }

    private static ItemStack getCompass() {
        if (compass == null) {
            compass = new ItemStack(Material.COMPASS);
            CompassMeta compassMeta = (CompassMeta) compass.getItemMeta();
            compassMeta.setLodestone(); //TODO Passende Location auswählen
        }
    }
}
