package de.bellobodo.listeners;

import de.bellobodo.Manhunt;
import de.bellobodo.manager.SpeedrunnerManager;
import de.bellobodo.other.GameState;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageListener implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(entityIsPlayer(event.getDamager().getType()))) {
            return;
        }

        final Player damager = (Player) event.getDamager();

        if (Manhunt.getGameState() == GameState.IN_PROGRESS) {

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
