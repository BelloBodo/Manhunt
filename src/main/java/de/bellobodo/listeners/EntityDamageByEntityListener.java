package de.bellobodo.listeners;

import de.bellobodo.Manhunt;
import de.bellobodo.manager.player.SpeedrunnerManager;
import de.bellobodo.gamestate.GameState;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntityListener implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (Manhunt.getGameState() == GameState.PENDING) {
            event.setCancelled(true);
            return;
        }

        if (!(entityIsPlayer(event.getDamager().getType()))) {
            return;
        }

        final Player damager = (Player) event.getDamager();

        if (Manhunt.getGameState() == GameState.IN_PROGRESS) {

            if (!(entityIsPlayer(event.getEntity().getType()))) {
                return;
            }

            final Player player = (Player) event.getEntity();

            if (isSameTeam(player, damager)) {
                event.setCancelled(true);
            }
        } else {
            if (!SpeedrunnerManager.isSpeedrunner(damager)) {
                event.setCancelled(true);
            }
        }
    }

    private boolean isSameTeam(Player player, Player damager) {
        return SpeedrunnerManager.isSpeedrunner(player) == SpeedrunnerManager.isSpeedrunner(damager);
    }

    private boolean entityIsPlayer(EntityType entityType) {
        return entityType == EntityType.PLAYER;
    }
}
