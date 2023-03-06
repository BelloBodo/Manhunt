package de.bellobodo.game;

import de.bellobodo.manager.HunterManager;
import de.bellobodo.manager.SpeedrunnerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Start {

    public static void gameCounterStart() {
        Bukkit.getOnlinePlayers().forEach(players -> {
            players.getInventory().clear();

            if (!SpeedrunnerManager.isSpeedrunner(players)) {
                HunterManager.giveCompass(players.getInventory());
            }


            players.sendTitle(ChatColor.BOLD + ChatColor.DARK_AQUA.toString() + "Das Spiel wurde gestartet.", "", 10, 20, 10);
        });
    }
}