package com.joblessgod.jawake.Commands;

import com.joblessgod.jawake.JAwake;
import com.joblessgod.jawake.Events.Awake;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

public class Start implements CommandExecutor {

    private final JAwake plugin;

    public Start(JAwake plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("jawake.start")) {
                player.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
                return true;
            }
        }

        startAwakeEvent();
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendTitle(
                    ChatColor.RED + "Danger!!", // Title
                    ChatColor.RED + "Don't sleep!!", // Subtitle
                    10, // Fade in time
                    70, // Stay time
                    20  // Fade out time
            );
        }
        // Feedback after starting the event
        sender.sendMessage(ChatColor.GREEN + "Jawake plugin events have been started.");
        return true;
    }

    private void startAwakeEvent() {
        PluginManager pm = plugin.getServer().getPluginManager();
        pm.registerEvents(new Awake(), plugin);
    }
}
