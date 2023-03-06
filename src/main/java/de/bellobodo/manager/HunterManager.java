package de.bellobodo.manager;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;

public class HunterManager {

    private static ArrayList<Player> registeredHunters = new ArrayList<Player>();


    /**
     *
     * @return false if Player is a Speedrunner
     */
    public static boolean registerHunter(Player player) {
        if (SpeedrunnerManager.isSpeedrunner(player)) {
            return false;
        } else {
            registeredHunters.add(player);
            return true;
        }
    }

    public static boolean isRegisteredHunter(Player player) {
        if (registeredHunters.contains(player)) {
            return true;
        } else {
            return false;
        }
    }

    public static void clearHunters() {
        registeredHunters.clear();
    }

    public static PlayerInventory giveCompass(PlayerInventory inventory) {
        inventory.setItem(0, new ItemStack(Material.COMPASS));
        return inventory;
    }

}
