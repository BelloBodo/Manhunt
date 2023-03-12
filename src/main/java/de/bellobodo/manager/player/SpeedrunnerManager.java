package de.bellobodo.manager.player;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

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
        customLocation = null;
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
        if (speedrunner == null) {
            speedrunner = player;
            return true;
        } else if (speedrunner.getUniqueId().equals(player.getUniqueId())){
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

    public static void setupSpeedrunner(Player player) {
        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
        player.setFoodLevel(40);
        player.setExp(0);
        player.setLevel(0);
    }
}
