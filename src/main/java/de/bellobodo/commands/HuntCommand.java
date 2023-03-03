package de.bellobodo.commands;

import de.bellobodo.Manhunt;
import de.bellobodo.manager.SpeedrunnerManager;
import de.bellobodo.other.GameState;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HuntCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        switch (args[0]) {
            case "set": {
                if (!checkGamestatePending(sender)) {
                    break;
                }

                if (args.length != 2) {
                    sendUsage(sender);
                    break;
                }

                final Player player = Manhunt.getInstance().getServer().getPlayer(args[1]);

                if (player == null) {
                    sendEnterValidPlayer(sender);
                } else {
                    if (SpeedrunnerManager.setSpeedrunner(player)) {
                        sender.sendMessage(ChatColor.GREEN + "Der Spieler wurde erfolgreich hinzugefügt.");
                    } else {
                        sender.sendMessage(ChatColor.GREEN + "Der Spieler ist schon Speedrunner.");
                    }
                }

                break;
            }
            case "start": {
                //TODO cmd Start
                break;
            }
            case "stop": {
                //TODO cmd Stop
                break;
            }
            default:
                sendUsage(sender);
                break;
        }

        return false;
    }

    private boolean checkGamestatePending(final CommandSender sender) {
        if (Manhunt.getGameState() != GameState.PENDING) {
            sender.sendMessage(ChatColor.RED + "Das Spiel wurde bereits gestartet." + ChatColor.BLUE +
                    " Stoppe das Spiel mit" + ChatColor.GRAY + ": " + ChatColor.DARK_GRAY + "/hunt stop");
            return false;
        }
        return true;
    }

    private void sendEnterValidPlayer(final CommandSender sender) {
        sender.sendMessage(ChatColor.RED + "Du musst einen Spieler angeben.");
    }

    private void sendUsage(final CommandSender sender) {
        sender.sendMessage(ChatColor.BLUE + "Verwende" + ChatColor.GRAY + ": " + ChatColor.DARK_GRAY +
                "/hunt start [Zeit], /hunt (add/remove) [Spieler]");
    }
}
