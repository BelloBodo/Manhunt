package de.bellobodo.listeners;

import de.bellobodo.Manhunt;
import de.bellobodo.manager.player.HunterManager;
import de.bellobodo.gamestate.GameState;
import de.bellobodo.manager.player.SpeedrunnerManager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class MoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.getGameMode() == GameMode.SURVIVAL) {
            if (!SpeedrunnerManager.isSpeedrunner(player)) {
                if (Manhunt.getGameState() != GameState.IN_PROGRESS) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
