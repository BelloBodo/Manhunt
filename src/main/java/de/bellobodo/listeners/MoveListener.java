package de.bellobodo.listeners;

import de.bellobodo.Manhunt;
import de.bellobodo.manager.SpeedrunnerManager;
import de.bellobodo.gamestate.GameState;
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
        //TODO Von anfangan nicht bewegen (Spectator Manager hinzufügen)
    }
}
