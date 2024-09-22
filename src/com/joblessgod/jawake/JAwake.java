package com.joblessgod.jawake;
import com.joblessgod.jawake.Commands.Reload;
import com.joblessgod.jawake.Commands.Start;
import com.joblessgod.jawake.Commands.Stop;
import com.joblessgod.jawake.Events.Awake;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class JAwake extends JavaPlugin{
    private Awake awakeEvent;

    @Override
    public void onEnable() {
        awakeEvent = new Awake();
        Awake eventHandler = new Awake();
        getServer().getPluginManager().registerEvents(eventHandler, this);
        getCommand("jreload").setExecutor(new Reload(this));
        getCommand("jawakestop").setExecutor(new Stop(this));
        getCommand("jawakestart").setExecutor(new Start(this));
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[JAwake] plugin has enabled!");
    }

    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[JAwake] plugin has disabled!");
    }

    public void reload() {
    }
}
