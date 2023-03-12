package de.bellobodo.listeners;

import de.bellobodo.Manhunt;
import de.bellobodo.manager.player.HunterManager;
import de.bellobodo.manager.player.SpeedrunnerManager;
import de.bellobodo.gamestate.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if (SpeedrunnerManager.isSpeedrunner(event.getPlayer())) {
            SpeedrunnerManager.setSpeedrunner(event.getPlayer());
        } else if (Manhunt.getGameState() != GameState.PENDING) {

            if (!HunterManager.isRegisteredHunter(player)) {
                HunterManager.setupHunters(player);

                HunterManager.registerHunter(player);
            }
        }
    }
}
