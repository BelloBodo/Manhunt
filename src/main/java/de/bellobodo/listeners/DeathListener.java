package de.bellobodo.listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    public void PlayerDeathEvents(PlayerDeathEvent event) {
    event.getEntity().spigot().respawn();
    }
}
