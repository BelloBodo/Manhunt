package de.bellobodo.listeners;

import de.bellobodo.Manhunt;
import de.bellobodo.manager.SpeedrunnerManager;
import de.bellobodo.other.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    @EventHandler
    public void PlayerDeathEvents(PlayerDeathEvent event) {

        if (event.getEntity() == SpeedrunnerManager.getOfflineSpeedrunner()) {
            if (Manhunt.getGameState() == GameState.IN_PROGRESS) {
                Manhunt.setGameState(GameState.PENDING);
            }
        }


        event.getEntity().spigot().respawn();
    }
}
