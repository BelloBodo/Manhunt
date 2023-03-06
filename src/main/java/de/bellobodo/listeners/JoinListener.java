package de.bellobodo.listeners;

import de.bellobodo.Manhunt;
import de.bellobodo.manager.HunterManager;
import de.bellobodo.manager.SpeedrunnerManager;
import de.bellobodo.other.GameState;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();

       if (!HunterManager.isRegisteredHunter(player) && !SpeedrunnerManager.isSpeedrunner(player)) {
           player.getInventory().clear();

           HunterManager.giveCompass(player.getInventory());
           
           HunterManager.registerHunter(player);
       }
    }
}
