package com.memeasaur.cubecorelaby;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class CubecoreLaby extends JavaPlugin {
    public static ArrayList<String> requestList = new ArrayList<>();
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new CubecoreLabyListeners(), this);
    }

    @Override
    public void onDisable() {
    }
}
