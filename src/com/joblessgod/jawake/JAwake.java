package com.joblessgod.jawake;
import com.joblessgod.jawake.Events.Awake;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class JAwake extends JavaPlugin{
    @Override
    public void onEnable() {
        Awake eventHandler = new Awake();
        getServer().getPluginManager().registerEvents(eventHandler, this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[JAwake] plugin has enabled!");
    }

    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[JAwake] plugin has disabled!");
    }
    }
