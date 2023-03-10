package de.bellobodo.commands;

import de.bellobodo.Manhunt;
import de.bellobodo.gamestate.ChangeGameState;
import de.bellobodo.gamestate.WinType;
import de.bellobodo.manager.SpeedrunnerManager;
import de.bellobodo.gamestate.GameState;
import de.bellobodo.render.HotbarManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HuntCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sendUsage(sender);
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "set": {
                if (isGamestateIngame(sender)) {
                    return true;
                }

                if (args.length != 2) {
                    sendUsage(sender);
                    return true;
                }

                final Player player = Manhunt.getInstance().getServer().getPlayer(args[1]);

                if (player == null) {
                    sendEnterValidPlayer(sender);
                } else {
                    if (SpeedrunnerManager.setSpeedrunner(player)) {
                        sender.sendMessage(ChatColor.GREEN + "Der Spieler wurde erfolgreich gesetzt.");
                    } else {
                        sender.sendMessage(ChatColor.RED + "Der Spieler ist schon Speedrunner.");
                    }
                }

                break;
            }
            case "start": {
                if (isGamestateIngame(sender)) {

                } else {
                    if (args.length != 2) {
                        sendUsage(sender);
                        return true;
                    }

                    if (SpeedrunnerManager.getSpeedrunner() == null) {
                        sendEnterValidPlayer(sender);
                        return true;
                    }

                    int headstartSeconds;

                    try {
                        headstartSeconds = Integer.parseInt(args[1]);
                    } catch (NumberFormatException exception) {
                        sender.sendMessage(ChatColor.RED + "Du musst eine Zahl angeben.");
                        break;
                    }

                    if (headstartSeconds > 0) {
                        headstartSeconds = headstartSeconds * -1;
                    }

                    if (headstartSeconds == 0) {
                        ChangeGameState.PENDINGtoIN_PROGRESS();
                    }

                    Manhunt.getGameCounter().startCounter(headstartSeconds);
                    ChangeGameState.PENDINGtoHEADSTART();
                }
                break;
            }
            case "stop": {
                if (isGamestatePending(sender)) {

                } else {
                    ChangeGameState.toPENDING(WinType.STOPPED);
                }
                break;
            }
            default:
                sendUsage(sender);
                break;
        }
        return true;
    }

    private boolean isGamestatePending(final CommandSender sender) {
        if (Manhunt.getGameState() == GameState.PENDING) {
            sender.sendMessage(ChatColor.RED + "Das Spiel wurde noch nicht gestartet." + ChatColor.BLUE +
                    " Starte das Spiel mit" + ChatColor.GRAY + ": " + ChatColor.DARK_GRAY + "/hunt start");
            return true;
        }
        return false;
    }

    private boolean isGamestateIngame(final CommandSender sender) {
        if (Manhunt.getGameState() != GameState.PENDING) {
            sender.sendMessage(ChatColor.RED + "Das Spiel wurde bereits gestartet." + ChatColor.BLUE +
                    " Stoppe das Spiel mit" + ChatColor.GRAY + ": " + ChatColor.DARK_GRAY + "/hunt stop");
            return true;
        }
        return false;
    }

    private void sendEnterValidPlayer(final CommandSender sender) {
        sender.sendMessage(ChatColor.RED + "Du musst einen Spieler angeben.");
    }

    private void sendUsage(final CommandSender sender) {
        sender.sendMessage(ChatColor.BLUE + "Verwende" + ChatColor.GRAY + ": " + ChatColor.DARK_GRAY +
                "/hunt start [Zeit], /hunt (add/remove) [Spieler]");
    }
}
