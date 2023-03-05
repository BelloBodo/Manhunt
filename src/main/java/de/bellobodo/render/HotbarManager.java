package de.bellobodo.render;

import de.bellobodo.Manhunt;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class HotbarManager {

    private static int gameSeconds;

    private static String pendingMessage = ChatColor.DARK_GRAY + "Das Spiel wurde noch nicht gestartet.";

    public static void updateHotbar() {
        loopThroughPlayers();
    }

    public static void updateHotbar(final int seconds) {
        gameSeconds = seconds;
        loopThroughPlayers();
    }

    private static void loopThroughPlayers() {
        Bukkit.getOnlinePlayers().forEach(players -> {
            players.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(getHotbarMessage()));
        });
    }

    private static String getHotbarMessage() {
        switch (Manhunt.getGameState()) {
            case PENDING: {
                return pendingMessage;
            }
            case HEADSTART: {
                return "";
            }
            case IN_PROGRESS: {
                return "";
            }
            case PAUSED: {
                return "";
            }
            case FINISHED: {
                return "";
            }
            default:
                return "";
        }
        //TODO unterschiedliche Fälle der Hotbar eintragen



    }



}
