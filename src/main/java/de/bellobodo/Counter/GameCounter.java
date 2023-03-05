package de.bellobodo.Counter;

import de.bellobodo.render.CompassManager;
import de.bellobodo.render.HotbarManager;

public class GameCounter extends Counter {
    @Override
    public void onStart() {

    }

    @Override
    public void run() {
        HotbarManager.updateHotbar(getSeconds());
        CompassManager.updateCompass();
    }
}
