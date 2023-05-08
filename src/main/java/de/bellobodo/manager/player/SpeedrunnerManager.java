package de.bellobodo.manager.player;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.UUID;

public class SpeedrunnerManager {

    private static UUID speedrunner;

    private static Location overworldLocation;

    private static Location netherLocation;

    private static Location endLocation;

    private static Location customLocation;

    public static void updateLocation() {
        Player player = Bukkit.getPlayer(speedrunner);

        if (player == null) { return; }

        if (player.isOnline()) {
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
        customLocation = null;
    }

    /**
     @return true if Player is a Speedrunner
     */
    public static boolean isSpeedrunner(final Player player) {
        try {
            return speedrunner.equals(player.getUniqueId());
        } catch (NullPointerException exception) {
            return false;
        }
    }

    /**
    @return true if new Player was added
     */
    public static boolean setSpeedrunner(final Player player) {
        if (speedrunner == null) {
            speedrunner = player.getUniqueId();
            return true;
        } else if (speedrunner.equals(player.getUniqueId())){
            return false;
        } else {
            speedrunner = player.getUniqueId();
            return true;
        }
    }

    public static Player getSpeedrunner() {
        return Bukkit.getPlayer(speedrunner);
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

        PlayerInventory inventory = player.getInventory();

        inventory.clear();
    }
}
