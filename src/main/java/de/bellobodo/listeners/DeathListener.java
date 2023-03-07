package de.bellobodo.listeners;

import de.bellobodo.Manhunt;
import de.bellobodo.gamestate.ChangeGameState;
import de.bellobodo.manager.SpeedrunnerManager;
import de.bellobodo.gamestate.GameState;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    @EventHandler
    public void PlayerDeathEvents(PlayerDeathEvent event) {

        if (event.getEntity() == SpeedrunnerManager.getSpeedrunner()) {
            if (Manhunt.getGameState() == GameState.IN_PROGRESS) {
                ChangeGameState.toPENDING();
            }
        }

        Bukkit.getScheduler().runTaskLater(Manhunt.getInstance(), () -> {
            event.getEntity().spigot().respawn();
        }, 10);
    }
}
