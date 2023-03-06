package de.bellobodo.listeners;

import de.bellobodo.Manhunt;
import de.bellobodo.manager.SpeedrunnerManager;
import de.bellobodo.other.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class MoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (!SpeedrunnerManager.isSpeedrunner(event.getPlayer())) {
            if (Manhunt.getGameState() == GameState.HEADSTART) {
                event.setCancelled(true);
            }
        }
        //TODO FIX Bug wenn Speedrunner leaft das er ein Hunter ist
    }
}
