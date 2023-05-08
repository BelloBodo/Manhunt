package de.bellobodo.listeners;

import de.bellobodo.Manhunt;
import de.bellobodo.manager.player.HunterManager;
import de.bellobodo.manager.player.SpeedrunnerManager;
import de.bellobodo.gamestate.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if (!SpeedrunnerManager.isSpeedrunner(player)) {
            if (!(Manhunt.getGameState() == GameState.IN_PROGRESS || Manhunt.getGameState() == GameState.PAUSED)) {


            } else {
                player.sendMessage(String.valueOf(HunterManager.isRegisteredHunter(player)));

                if (!HunterManager.isRegisteredHunter(player)) {
                    HunterManager.setupHunter(player);

                    HunterManager.registerHunter(player);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerPreLoginEvent(AsyncPlayerPreLoginEvent event) {

    }
}
