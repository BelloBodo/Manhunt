package de.bellobodo.listeners;

import de.bellobodo.Manhunt;
import de.bellobodo.manager.SpeedrunnerManager;
import de.bellobodo.other.GameState;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageListener implements Listener {

    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(entityIsPlayer(event.getEntity().getType())) || !(entityIsPlayer(event.getDamager().getType()))) {
            return;
        }

        final Player player = (Player) event.getEntity();
        final Player damager = (Player) event.getDamager();



        if (Manhunt.getGameState() == GameState.HEADSTART ||
                (SpeedrunnerManager.isSpeedrunner(player) == SpeedrunnerManager.isSpeedrunner(damager))) {
            event.setCancelled(true);
        }
    }

    private boolean entityIsPlayer(EntityType entityType) {
        return entityType == EntityType.PLAYER;
    }
}
