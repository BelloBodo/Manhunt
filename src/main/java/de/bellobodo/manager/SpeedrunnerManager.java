package de.bellobodo.manager;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SpeedrunnerManager {

    private static Player speedrunner;

    private static Location overworldLocation;

    private static Location netherLocation;

    private static Location endLocation;


    public static void updateLocation() {
        switch (speedrunner.getWorld().getEnvironment()) {
            case NORMAL:
                overworldLocation = speedrunner.getLocation();
                break;
            case NETHER:
                netherLocation = speedrunner.getLocation();
                break;
            case THE_END:
                endLocation = speedrunner.getLocation();
                break;
            default:
                break;
        }
    }

    public static void resetLocation() {
        switch (speedrunner.getWorld().getEnvironment()) {
            case NORMAL:
                break;
            case NETHER:
                break;
            case THE_END:
                break;
            default:
                break;
        }
    }

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

    public static Player getSpeedrunner() {
        return speedrunner;
    }
}
