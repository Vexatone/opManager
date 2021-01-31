package com.vexatone.opmanager.opmanager;

// Import Zone
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class OPManager extends JavaPlugin {
    CommandSender console = Bukkit.getConsoleSender();

    @Override
    public void onEnable() {
        // Plugin startup logic
        console.sendMessage(ChatColor.BLUE + "Plugin Enabled!");

        // Command Setup
        Objects.requireNonNull(this.getCommand("opall")).setExecutor(new CMDopall(this));
        Objects.requireNonNull(this.getCommand("deopall")).setExecutor(new CMDdeopall(this));
        Objects.requireNonNull(this.getCommand("checkop")).setExecutor(new CMDcheckop(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        console.sendMessage(ChatColor.RED + "Plugin Disabled!");
    }
}