package de.bellobodo.commands;

import de.bellobodo.Manhunt;
import de.bellobodo.manager.SpeedrunnerManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class HuntCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Du musst ein Spieler sein!");
        }

        Player player = Manhunt.getInstance().getServer().getPlayer(args[1]);

        switch (args[0]) {
            case "add": {
                if (args.length != 2) {
                    sendUsage(sender);
                    break;
                }

                if (player == null) {
                    sender.sendMessage(ChatColor.RED + "Du musst einen Spieler angeben!");
                } else {
                    if (SpeedrunnerManager.addSpeedrunner(player)) {
                        sender.sendMessage(ChatColor.GREEN + "Der Spieler wurde erfolgreich hinzugefügt.");
                    } else {
                        sender.sendMessage(ChatColor.GREEN + "Der Spieler konnte nicht hinzugefügt werden werden.");
                    }
                }

                break;
            }
            case "remove": {
                if (args.length != 2) {
                    sendUsage(sender);
                    break;
                }

                if (player == null) {
                    sender.sendMessage(ChatColor.RED + "Du musst einen Spieler angeben!");
                } else {
                    if (SpeedrunnerManager.removeSpeedrunner(player)) {
                        sender.sendMessage(ChatColor.GREEN + "Der Spieler wurde erfolgreich entfernt.");
                    } else {
                        sender.sendMessage(ChatColor.GREEN + "Der Spieler konnte nicht entfernt werden.");
                    }
                }

                break;
            }
            case "start": {

                break;
            }
            default:
                sendUsage(sender);
                break;
        }

        return false;
    }

    private void sendUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.BLUE + "Verwende" + ChatColor.GRAY + ": " + ChatColor.DARK_GRAY +
                "/hunt start [Zeit], /hunt (add/remove) [Spieler]");
    }
}
