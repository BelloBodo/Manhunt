package de.bellobodo.countdowns;

import de.bellobodo.Manhunt;
import de.bellobodo.other.GameState;
import org.bukkit.ChatColor;

public class StartCountdown extends Countdown{
    @Override
    public void onStart() {
        Manhunt.getInstance().getServer().getOnlinePlayers().forEach(players -> {
            players.sendMessage(ChatColor.GREEN + "Das Spiel wurde gestartet.");
        });
    }

    @Override
    public void onEnd() {
        Manhunt.setGameState(GameState.STARTED);
    }

    @Override
    public void run() {

    }
}
