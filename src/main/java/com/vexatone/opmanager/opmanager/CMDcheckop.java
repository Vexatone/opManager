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

public final class CMDcheckop implements CommandExecutor {
    private final OPManager plugin;

    public CMDcheckop(OPManager plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Checks if sender is player
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command cannot be executed on console!");
            return true;
        }

        // Body Part
        if (args.length == 0) {
            List<Player> onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
            ArrayList<String> opNames = new ArrayList<>();
            StringBuilder outString = new StringBuilder();

            if (onlinePlayers.size() == 0) {
                sender.sendMessage(ChatColor.RED + "There are no players to get OP information!");
                return true;
            }

            // Gets OP names
            for (Player iPlayer : onlinePlayers) {
                if (iPlayer.isOp()) {
                    opNames.add(iPlayer.getName());
                }
            }

            if (opNames.size() == 0) {
                sender.sendMessage(ChatColor.GREEN + "There are no OP in this server.");
                return true;
            } else {
                for (String opName : opNames) {
                    outString.append(String.format(", %s", opName));
                }

                sender.sendMessage(ChatColor.GREEN + String.format("Names of OP:%s", outString.substring(1)));
            }
        } else {
            if (args[0].equalsIgnoreCase("help")) {
                // Sends Help Message
                sender.sendMessage(ChatColor.DARK_GREEN + "Help Guide for Command 'checkop'");
                sender.sendMessage(ChatColor.DARK_GREEN + "-----------------------------------------");
                sender.sendMessage(ChatColor.GREEN      + "This command returns a single list of players who have OP permission.");
                sender.sendMessage(ChatColor.GREEN      + "Permissions: Everyone can use this command.");
                sender.sendMessage(ChatColor.GREEN      + "Usage: /checkop [help]");
            } else {
                sender.sendMessage(ChatColor.RED + "Wrong arguments provided!");
            }
        }
        return true;
    }
}