package de.bellobodo.listeners;

import de.bellobodo.Manhunt;
import de.bellobodo.manager.player.SpeedrunnerManager;
import de.bellobodo.gamestate.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        final Player player = event.getPlayer();

        if (!SpeedrunnerManager.isSpeedrunner(player) && Manhunt.getGameState() != GameState.IN_PROGRESS) {
            event.setCancelled(true);
        }

    }
}
