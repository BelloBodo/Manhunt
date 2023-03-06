package de.bellobodo;

import de.bellobodo.Counter.GameCounter;
import de.bellobodo.commands.HuntCommand;
import de.bellobodo.listeners.DamageListener;
import de.bellobodo.listeners.DeathListener;
import de.bellobodo.listeners.MoveListener;
import de.bellobodo.other.GameState;
import de.bellobodo.render.HotbarManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

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

        Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new MoveListener(), this);


        getCommand("hunt").setExecutor(new HuntCommand());

        HotbarManager.updatePlayerHotbar();
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
