package de.bellobodo.manager.player;

import de.bellobodo.guilibrary.builder.SimpleGUIBuilder;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.UUID;

public class HunterManager {

    private static ArrayList<UUID> registeredHunters = new ArrayList<>();


    /**
     * @return false if Player is a Speedrunner
     */
    public static boolean registerHunter(Player player) {
        if (SpeedrunnerManager.isSpeedrunner(player)) {
            return false;
        } else {
            registeredHunters.add(player.getUniqueId());
            return true;
        }
    }

    public static boolean isRegisteredHunter(Player player) {
        return registeredHunters.contains(player.getUniqueId());
    }

    public static void clearHunters() {
        registeredHunters.clear();
    }

    public static void setupHunter(Player player) {
        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
        player.setFoodLevel(40);
        player.setExp(0);
        player.setLevel(0);

        PlayerInventory inventory = player.getInventory();

        inventory.clear();

        inventory.setItem(0, new ItemStack(Material.COMPASS));
    }

}
