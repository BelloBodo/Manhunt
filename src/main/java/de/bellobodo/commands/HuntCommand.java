package de.bellobodo.commands;

import de.bellobodo.Manhunt;
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

        switch (args[0]) {
            case "add": {
                newArrayList();
                if (args.length != 2) {
                    sendUsage(sender);
                    break;
                }

                Player player = Manhunt.getInstance().getServer().getPlayer(args[1]);
                if (player == null) {
                    sender.sendMessage(ChatColor.RED + "Du musst einen Spieler angeben!");
                } else {
                    speedrunner.add(player);
                }

                break;
            }
            case "remove": {
                if (args.length != 2) {
                    sendUsage(sender);
                    break;
                }

                Player player = Manhunt.getInstance().getServer().getPlayer(args[1]);

                if (player == null) {
                    sender.sendMessage(ChatColor.RED + "Du musst einen Spieler angeben!");
                } else {
                    speedrunner.forEach(players -> {
                        if (players == player) {
                            speedrunner.remove(player);
                        }
                    });
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
                "/hunt (start/add/remove) [Spieler]");
    }

    private void newArrayList() {
        if (speedrunner == null) {
            speedrunner = new ArrayList<>();
        }
    }

    public static ArrayList<Player> speedrunner;
}
