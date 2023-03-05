package de.bellobodo.Counter;

import de.bellobodo.Manhunt;
import de.bellobodo.other.GameState;
import de.bellobodo.render.CompassManager;
import de.bellobodo.render.HotbarManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class GameCounter extends Counter {
    @Override
    public void onStart() {

    }

    @Override
    public void run() {
        if (getSeconds() >= 0 && Manhunt.getGameState() == GameState.HEADSTART) {
            Manhunt.setGameState(GameState.IN_PROGRESS);

            Bukkit.getOnlinePlayers().forEach(player -> {
                player.sendTitle(ChatColor.BOLD + ChatColor.DARK_AQUA.toString() + "Das Spiel beginnt.", "", 10, 20, 10);
            });
        }


        HotbarManager.updateHotbar(getSeconds());
        CompassManager.updateCompass();
    }
}
