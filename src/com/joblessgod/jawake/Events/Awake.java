package com.joblessgod.jawake.Events;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class Awake implements Listener {

    @EventHandler
    public void onEnterBed(PlayerBedEnterEvent e) {
        Player player = e.getPlayer();
        Location location = player.getLocation();

        player.getWorld().spawnEntity(location, EntityType.ARROW);
        player.getWorld().spawnEntity(location, EntityType.ENDER_CRYSTAL);
        player.getWorld().spawnEntity(location, EntityType.LIGHTNING);
        player.getWorld().spawnEntity(location, EntityType.MINECART_TNT);
        player.setHealth(1);
    }
}
