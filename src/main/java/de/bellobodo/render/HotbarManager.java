package de.bellobodo.render;

import de.bellobodo.Manhunt;
import de.bellobodo.converter.Converter;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class HotbarManager {

    private static int gameSeconds;

    public static void updatePlayerHotbar() {
        int seconds = Manhunt.getGameCounter().getSeconds();
        if (seconds < 0) {
            seconds = seconds * -1;
        }
        gameSeconds = seconds;
        loopThroughPlayers();
    }

    private static void loopThroughPlayers() {
        Bukkit.getOnlinePlayers().forEach(players ->
                players.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(getHotbarMessage())));
    }

    private static String getHotbarMessage() {
        switch (Manhunt.getGameState()) {
            case PENDING: {
                return ChatColor.DARK_GRAY + "Es wurde kein Spiel gestartet.";
            }
            case HEADSTART: {
                return ChatColor.YELLOW + Converter.convertIntToTime(gameSeconds);
            }
            case IN_PROGRESS: {
                return ChatColor.BOLD + ChatColor.GOLD.toString() + Converter.convertIntToTime(gameSeconds);
            }
            case PAUSED: {
                return ChatColor.ITALIC + ChatColor.GREEN.toString() + "Das Spiel ist pausiert.";
            }
            default:
                return "";
        }
    }



}
