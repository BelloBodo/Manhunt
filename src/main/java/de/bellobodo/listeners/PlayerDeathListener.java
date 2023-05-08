package de.bellobodo.listeners;

import de.bellobodo.Manhunt;
import de.bellobodo.gamestate.ChangeGameState;
import de.bellobodo.gamestate.WinType;
import de.bellobodo.manager.player.SpeedrunnerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        if (SpeedrunnerManager.isSpeedrunner(player)) {
            ChangeGameState.toPENDING(WinType.HUNTER);
        }

        event.setDeathMessage(ChatColor.BLUE + player.getName() + ChatColor.GRAY + " ist nun Tod.");
    }
}
