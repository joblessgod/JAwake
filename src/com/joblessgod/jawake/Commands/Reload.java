package com.joblessgod.jawake.Commands;

import com.joblessgod.jawake.JAwake;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reload implements CommandExecutor {

    private final JAwake plugin;

    public Reload(JAwake plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("jreload")) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("jawake.reload")) {
                player.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
                return true;
            }
        }

        plugin.reload();
        sender.sendMessage(ChatColor.GREEN + "Jawake plugin has been reloaded.");
        return true;
        }
        return true;
    }
}
