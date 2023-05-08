package de.bellobodo.gamestate;

import de.bellobodo.Manhunt;
import de.bellobodo.manager.player.HunterManager;
import de.bellobodo.manager.player.SpeedrunnerManager;
import de.bellobodo.manager.render.HotbarManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;

public class ChangeGameState {

    public static boolean PENDINGtoIN_PROGRESS(final boolean reset) {
        if (Manhunt.getGameState() == GameState.PENDING) {

            Bukkit.getOnlinePlayers().forEach(players -> {
                if (reset) {
                    if (SpeedrunnerManager.isSpeedrunner(players)) {
                        SpeedrunnerManager.setupSpeedrunner(players);
                    } else {
                        HunterManager.registerHunter(players);
                        HunterManager.setupHunter(players);
                    }
                }

                players.sendTitle(ChatColor.BOLD + ChatColor.DARK_RED.toString() +
                        "Die Hunter", ChatColor.DARK_RED + "wurden freigelassen", 10, 20, 10);

                players.playSound(players, Sound.ITEM_GOAT_HORN_SOUND_0, 1, 1);
            });

            HotbarManager.stopHotbar();

            if (reset) {
                SpeedrunnerManager.resetLocation();
                HunterManager.clearHunters();
            }

            Manhunt.setGameState(GameState.IN_PROGRESS);
            return true;
        } else {
            return false;
        }
    }

    public static boolean PENDINGtoHEADSTART(final boolean reset) {
        if (Manhunt.getGameState() == GameState.PENDING) {

            Bukkit.getOnlinePlayers().forEach(players -> {
                if (reset) {
                    if (SpeedrunnerManager.isSpeedrunner(players)) {
                        SpeedrunnerManager.setupSpeedrunner(players);
                    } else {
                        HunterManager.registerHunter(players);
                        HunterManager.setupHunter(players);
                    }
                }


                players.sendTitle(ChatColor.BOLD + ChatColor.DARK_AQUA.toString() + "Das Spiel",
                        ChatColor.DARK_AQUA + "wurde gestartet", 10, 20, 10);

                players.playSound(players, Sound.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON, 1, 1);
            });

            HotbarManager.stopHotbar();

            if (reset) {
                SpeedrunnerManager.resetLocation();
                HunterManager.clearHunters();
            }

            Manhunt.setGameState(GameState.HEADSTART);
            return true;
        } else {
            return false;
        }
    }

    public static boolean HEADSTARTtoIN_PROGRESS() {
        if (Manhunt.getGameState() == GameState.HEADSTART) {

            Bukkit.getOnlinePlayers().forEach(players -> {
                players.sendTitle(ChatColor.BOLD + ChatColor.DARK_RED.toString() +
                        "Die Hunter", ChatColor.DARK_RED + "wurden freigelassen", 10, 20, 10);

                players.playSound(players, Sound.ITEM_GOAT_HORN_SOUND_0, 1, 1);
            });

            Manhunt.setGameState(GameState.IN_PROGRESS);
            return true;
        } else {
            return false;
        }
    }

    public static boolean toPENDING(final WinType winType) {
        if (Manhunt.getGameState() != GameState.PENDING) {

            String title;
            String subtitle;

            switch (winType) {
                case SPEEDRUNNER:
                    title = ChatColor.BOLD + ChatColor.GREEN.toString() + "Der Speedrunner";
                    subtitle = ChatColor.GREEN + "hat gewonnen";
                    break;
                case HUNTER:
                    title = ChatColor.BOLD + ChatColor.RED.toString() + "Die Hunter";
                    subtitle = ChatColor.RED + "haben gewonnen";
                    break;
                case STOPPED:
                    title = ChatColor.BOLD + ChatColor.DARK_AQUA.toString() + "Das Spiel";
                    subtitle = ChatColor.DARK_AQUA + "wurde abgebrochen";
                    break;
                default:
                    title = "";
                    subtitle = "";
            }

            Bukkit.getOnlinePlayers().forEach(players -> {
                players.sendTitle(title, subtitle, 10, 40, 10);
                players.sendMessage(title + " " + subtitle);
            });

            Manhunt.getGameCounter().stopCounter();

            HotbarManager.startHotbar();

            Manhunt.setGameState(GameState.PENDING);
            return true;
        } else {
            return false;
        }
    }
}
