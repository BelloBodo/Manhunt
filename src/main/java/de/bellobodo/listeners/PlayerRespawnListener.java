package de.bellobodo.listeners;

import de.bellobodo.Manhunt;
import de.bellobodo.gamestate.GameState;
import de.bellobodo.manager.player.HunterManager;
import de.bellobodo.manager.player.SpeedrunnerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener {

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if (Manhunt.getGameState() != GameState.PENDING) {
            if (!SpeedrunnerManager.isSpeedrunner(player)) {
                HunterManager.setupHunters(player);
            }
        }
    }
}
