package de.bellobodo.listeners;

import de.bellobodo.commands.HuntCommand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.concurrent.atomic.AtomicBoolean;

public class DamageListener implements Listener {

    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        if (event.getEntityType() != EntityType.PLAYER) {
            return;
        }
        if (event.getDamager().getType() != EntityType.PLAYER) {return;}

        Player player = (Player) event.getEntity();
        Player damager = (Player) event.getDamager();

        AtomicBoolean playerIsSpeedrunner = new AtomicBoolean(false);

        AtomicBoolean damagerIsSpeedrunner = new AtomicBoolean(false);

        HuntCommand.speedrunner.forEach(players -> {
            if (players == player) {
                playerIsSpeedrunner.set(true);
            }
            if (players == damager) {
                damagerIsSpeedrunner.set(true);
            }
        });

        if (playerIsSpeedrunner == damagerIsSpeedrunner) {
            event.setCancelled(true);
        }


    }
}
