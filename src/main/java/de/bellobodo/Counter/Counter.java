package de.bellobodo.Counter;

import de.bellobodo.Manhunt;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

public abstract class Counter implements Runnable {

    /**
     * Boolean if task run
     */
    private boolean running = false;

    /**
     * started Seconds of Task
     */
    private int Seconds;

    /**
     * The bukkit task
     */
    private BukkitTask task;

    public void startCountdown(int startSeconds) {
        this.running = true;
        this.Seconds = startSeconds;
        this.onStart();
        this.task = Bukkit.getScheduler().runTaskTimer(Manhunt.getInstance(), () -> {

            Counter.this.run();

            Counter.this.Seconds++;
        }, 0, 20);
    }

    /**
     * Will be called on start of task
     */
    public abstract void onStart();

    /**
     * Cancel the Task
     */
    public void cancelCounter() {
        this.running = false;
        this.task.cancel();
    }

    public boolean isRunning() {
        return running;
    }

    public int getSeconds() {
        return Seconds;
    }

    public BukkitTask getTask() {
        return task;
    }
}
