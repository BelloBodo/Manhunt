package de.bellobodo.gamestate;

import de.bellobodo.Manhunt;
import de.bellobodo.manager.HunterManager;
import de.bellobodo.manager.SpeedrunnerManager;
import de.bellobodo.render.HotbarManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;

public class ChangeGameState {

    public static boolean PENDINGtoIN_PROGRESS() {
        if (Manhunt.getGameState() == GameState.PENDING) {

            Bukkit.getOnlinePlayers().forEach(player -> {
                player.sendTitle(ChatColor.BOLD + ChatColor.DARK_RED.toString() +
                        "Die Hunter", ChatColor.DARK_RED + "wurden freigelassen", 10, 20, 10);
                player.playSound(player, Sound.ITEM_GOAT_HORN_SOUND_0, 1, 1);
            });

            HotbarManager.stopHotbar();

            Manhunt.setGameState(GameState.IN_PROGRESS);
            return true;
        } else {
            return false;
        }
    }

    public static boolean PENDINGtoHEADSTART() {
        if (Manhunt.getGameState() == GameState.PENDING) {

            Bukkit.getOnlinePlayers().forEach(players -> {
                if (!SpeedrunnerManager.isSpeedrunner(players)) {
                    HunterManager.setupHunters(players);
                }

                players.sendTitle(ChatColor.BOLD + ChatColor.DARK_AQUA.toString() + "Das Spiel",
                        ChatColor.DARK_AQUA + "wurde gestartet", 10, 20, 10);
            });

            HotbarManager.stopHotbar();

            Manhunt.setGameState(GameState.HEADSTART);
            return true;
        } else {
            return false;
        }
    }

    public static boolean HEADSTARTtoIN_PROGRESS() {
        if (Manhunt.getGameState() == GameState.HEADSTART) {

            Bukkit.getOnlinePlayers().forEach(player -> {
                player.sendTitle(ChatColor.BOLD + ChatColor.DARK_RED.toString() +
                        "Die Hunter", ChatColor.DARK_RED + "wurden freigelassen", 10, 20, 10);
            });

            Manhunt.setGameState(GameState.IN_PROGRESS);
            return true;
        } else {
            return false;
        }
    }

    public static boolean toPENDING() {
        if (Manhunt.getGameState() != GameState.PENDING) {

            Bukkit.getOnlinePlayers().forEach(players -> {
                players.sendTitle(ChatColor.BOLD + ChatColor.DARK_AQUA.toString() +
                        "Das Spiel", ChatColor.DARK_AQUA + "wurde beendet", 10, 20, 10);
            });

            Manhunt.getGameCounter().stopCounter();

            HunterManager.clearHunters();

            HotbarManager.startHotbar();

            Manhunt.setGameState(GameState.PENDING);
            return true;
        } else {
            return false;
        }
    }
}
