package de.bellobodo.Counter;

import de.bellobodo.Manhunt;
import de.bellobodo.gamestate.ChangeGameState;
import de.bellobodo.manager.HunterManager;
import de.bellobodo.manager.SpeedrunnerManager;
import de.bellobodo.gamestate.GameState;
import de.bellobodo.render.CompassManager;
import de.bellobodo.render.HotbarManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class GameCounter extends Counter {
    @Override
    public void onStart() {
        HotbarManager.updatePlayerHotbar();
    }

    @Override
    public void run() {
        if (getSeconds() >= 0 && Manhunt.getGameState() == GameState.HEADSTART) {
            ChangeGameState.HEADSTARTtoIN_PROGRESS();
        }

        SpeedrunnerManager.updateLocation();
        HotbarManager.updatePlayerHotbar();
        CompassManager.updatePlayerCompass();
    }
}
