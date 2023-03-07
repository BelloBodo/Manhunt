package de.bellobodo.manager;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

public class SpeedrunnerManager {

    private static Player speedrunner;

    private static Location overworldLocation;

    private static Location netherLocation;

    private static Location endLocation;

    private static Location customLocation;



    public static void updateLocation() {
        if (speedrunner.isOnline()) {
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
                case CUSTOM:
                    customLocation = speedrunner.getLocation();
                    break;
            }
        }
    }

    public static void resetLocation() {
        overworldLocation = null;
        netherLocation = null;
        endLocation = null;
    }

    /**
     @return true if Player is a Speedrunner
     */
    public static boolean isSpeedrunner(final Player player) {
        try {
            return speedrunner.getUniqueId().equals(player.getUniqueId());
        } catch (NullPointerException exception) {
            return false;
        }
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

    public static Location getLocation(final World.Environment environment) {
        switch (environment) {
            case NORMAL:
                return overworldLocation;
            case NETHER:
                return netherLocation;
            case THE_END:
                return endLocation;
            case CUSTOM:
                return customLocation;
        }
        return null;
    }
}
