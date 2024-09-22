package com.joblessgod.jawake.Commands;

import com.joblessgod.jawake.JAwake;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Stop implements CommandExecutor {

    private final JAwake plugin;

    public Stop(JAwake plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("jawake.stop")) {
                player.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
                return true;
            }
        }

        stopAwakeEvent();

        // Feedback after stopping the event
        sender.sendMessage(ChatColor.RED + "Jawake plugin events have been stopped.");
        return true;
    }

    private void stopAwakeEvent() {
        // Unregister the Awake event listener
        PlayerBedEnterEvent.getHandlerList().unregister(plugin);
        PlayerJoinEvent.getHandlerList().unregister(plugin);
    }
}
