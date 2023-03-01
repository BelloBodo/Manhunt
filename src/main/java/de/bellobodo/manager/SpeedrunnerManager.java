package de.bellobodo.manager;

import org.bukkit.entity.Player;

public class SpeedrunnerManager {

    private static Player speedrunner;

    /**
     @return true if Player is a Speedrunner
     */
    public static boolean isSpeedrunner(final Player player) {
        return speedrunner == player;
    }

    /**
    @return true if new Player was added
     */
    public static boolean setSpeedrunner(final Player player) {
        if (speedrunner == player) {
            return false;
        } else {
            speedrunner = player;
            return true;
        }
    }
}
