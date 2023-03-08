package de.bellobodo.listeners;

import de.bellobodo.Manhunt;
import de.bellobodo.gamestate.ChangeGameState;
import de.bellobodo.gamestate.WinType;
import de.bellobodo.manager.SpeedrunnerManager;
import de.bellobodo.gamestate.GameState;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void PlayerDeathEvent(PlayerDeathEvent event) {

        if (event.getEntity() == SpeedrunnerManager.getSpeedrunner()) {
            ChangeGameState.toPENDING(WinType.HUNTER);
        }

        Bukkit.getScheduler().runTaskLater(Manhunt.getInstance(), () -> {
            event.getEntity().spigot().respawn();
        }, 10);
    }
}
