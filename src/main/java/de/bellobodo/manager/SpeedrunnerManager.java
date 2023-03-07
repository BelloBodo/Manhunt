package de.bellobodo.manager;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class SpeedrunnerManager {

    private static OfflinePlayer offlineSpeedrunner;

    private static Location overworldLocation;

    private static Location netherLocation;

    private static Location endLocation;

    private static Location customLocation;



    public static void updateLocation() {
        if (offlineSpeedrunner.isOnline()) {
            Player player = (Player) offlineSpeedrunner;

            switch (player.getWorld().getEnvironment()) {
                case NORMAL:
                    overworldLocation = player.getLocation();
                    break;
                case NETHER:
                    netherLocation = player.getLocation();
                    break;
                case THE_END:
                    endLocation = player.getLocation();
                    break;
                case CUSTOM:
                    customLocation = player.getLocation();
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
        return offlineSpeedrunner == player;
    }

    /**
    @return true if new Player was added
     */
    public static boolean setSpeedrunner(final Player player) {
        if (offlineSpeedrunner == player) {
            return false;
        } else {
            offlineSpeedrunner = player;
            return true;
        }
    }

    public static OfflinePlayer getOfflineSpeedrunner() {
        return offlineSpeedrunner;
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
