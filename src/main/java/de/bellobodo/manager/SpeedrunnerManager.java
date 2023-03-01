package de.bellobodo.manager;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class SpeedrunnerManager {

    private static ArrayList<Player> speedrunner = new ArrayList<Player>();

    /**
     @return true if Player is a Speedrunner
     */
    public static boolean isSpeedrunner(Player player) {
        return speedrunner.contains(player);
    }

    /**
    @return true if new Player was added
     */
    public static boolean addSpeedrunner(Player player) {
        if (speedrunner.contains(player)) {
            return false;
        } else {
            speedrunner.add(player);
            return true;
        }
    }

    /**
     @return true if Player was removed
     */
    public static boolean removeSpeedrunner(Player player) {
        if (speedrunner.contains(player)) {
            speedrunner.remove(player);
            return true;
        } else {
            return false;
        }
    }
}
