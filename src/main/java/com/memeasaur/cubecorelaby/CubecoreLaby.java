package com.memeasaur.cubecorelaby;

import net.kyori.adventure.text.Component;
import net.labymod.serverapi.core.model.moderation.InstalledAddon;
import net.labymod.serverapi.server.bukkit.event.LabyModPlayerJoinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class CubecoreLaby extends JavaPlugin implements Listener {
    public static ArrayList<String> requestList = new ArrayList<>();
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
    }

    @EventHandler
    void onLabyJoin(LabyModPlayerJoinEvent e) {
        e.labyModPlayer().requestInstalledAddons(requestList, response -> {
            for (InstalledAddon addon : response.getInstalledAddons()) {
                if (addon.isLocal()) {
                    e.labyModPlayer().getPlayer().kick(Component.text("kicked (non-store addon)"));
                }
                else if (addon.getNamespace().equals("labyfabric")) {
                    e.labyModPlayer().getPlayer().sendMessage("labyfabric isn't allowed once the optifine addon is available");
                }
                e.labyModPlayer().disableAddons("damageindicator");
            }
        });
    }
}
