package de.bellobodo;

import de.bellobodo.counter.GameCounter;
import de.bellobodo.commands.HuntCommand;
import de.bellobodo.listeners.*;
import de.bellobodo.gamestate.GameState;
import de.bellobodo.manager.render.HotbarManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public final class Manhunt extends JavaPlugin {

    private static Manhunt instance;

    private static GameState gameState;

    private static GameCounter gameCounter;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        gameState = GameState.PENDING;

        gameCounter = new GameCounter();

        Bukkit.getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerRespawnListener(), this);
        Bukkit.getPluginManager().registerEvents(new MoveListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new EntityDeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), this);
        Bukkit.getPluginManager().registerEvents(new EntityExplodeListener(), this);


        getCommand("hunt").setExecutor(new HuntCommand());

        HotbarManager.startHotbar();
    }

    @Override
    public void onDisable() {

    }

    public static Manhunt getInstance() {
        return instance;
    }

    public static GameState getGameState() {
        return gameState;
    }

    public static void setGameState(GameState gameState) {
        Manhunt.gameState = gameState;
    }

    public static GameCounter getGameCounter() {
        return gameCounter;
    }
}
