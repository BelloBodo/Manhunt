package de.bellobodo.listeners;

import de.bellobodo.gamestate.ChangeGameState;
import de.bellobodo.gamestate.WinType;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeathListener implements Listener {

    @EventHandler
    public void onEntityDeathEvent(EntityDeathEvent event) {
        if (event.getEntityType() == EntityType.ENDER_DRAGON) {
            ChangeGameState.toPENDING(WinType.SPEEDRUNNER);
        }
    }
}
