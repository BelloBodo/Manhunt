package de.bellobodo.counter;

import de.bellobodo.Manhunt;
import de.bellobodo.gamestate.ChangeGameState;
import de.bellobodo.manager.player.SpeedrunnerManager;
import de.bellobodo.gamestate.GameState;
import de.bellobodo.manager.render.CompassManager;
import de.bellobodo.manager.render.HotbarManager;

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
