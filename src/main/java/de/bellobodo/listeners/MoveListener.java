package de.bellobodo.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class MoveListener implements Listener {

    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        //TODO Abfrage wann man sich bewegen darf
    }
}
