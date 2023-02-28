package de.bellobodo.listeners;

import de.bellobodo.commands.HuntCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.concurrent.atomic.AtomicBoolean;

public class MoveListener implements Listener {

    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        AtomicBoolean playerIsSpeedrunner = new AtomicBoolean(false);

        HuntCommand.speedrunner.forEach(players -> {
            if (players == player) {
                playerIsSpeedrunner.set(true);
            }
        });

        if (!playerIsSpeedrunner.get()) {
            event.setCancelled(true);
        }
    }
}
