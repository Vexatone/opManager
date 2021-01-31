package com.vexatone.opmanager.opmanager;

// Import Zone
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public final class CMDdeopall implements CommandExecutor {
    private final OPManager plugin;

    public CMDdeopall(OPManager plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Checks if sender is OP or Console
        if (sender instanceof Player) {
            if (!(sender.isOp())) {
                sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command!");
                return true;
            }
        }

        // Body Part
        if (args.length == 0) {
            List<Player> onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());

            if (onlinePlayers.size() == 0) {
                sender.sendMessage(ChatColor.RED + "There are no players to remove OP permission!");
            } else {
                for (Player iPlayer : onlinePlayers) {
                    iPlayer.setOp(false);
                }
                sender.sendMessage(ChatColor.BLUE + String.format("Successfully removed permission from %d players.", onlinePlayers.size()));
            }

        } else {
            if (args[0].equalsIgnoreCase("help")) {
                // Sends Help Message
                sender.sendMessage(ChatColor.DARK_GREEN + "Help Guide for Command 'deopall'");
                sender.sendMessage(ChatColor.DARK_GREEN + "-----------------------------------------");
                sender.sendMessage(ChatColor.GREEN      + "This command removes OP permission from everyone.");
                sender.sendMessage(ChatColor.GREEN      + "Permission: Only OP players can use this command.");
                sender.sendMessage(ChatColor.GREEN      + "Usage: /deopall [help]");
            } else {
                sender.sendMessage(ChatColor.RED + "Wrong arguments provided!");
            }
        }

        return true;
    }
}