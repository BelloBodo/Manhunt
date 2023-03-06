package de.bellobodo.Counter;

import de.bellobodo.Manhunt;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

public abstract class Counter implements Runnable {

    /**
     * The instance of the Main Class
     */
    private final Manhunt instance = Manhunt.getInstance();

    /**
     * Boolean if task run
     */
    private boolean running = false;

    /**
     * started Seconds of Task
     */
    private int seconds;

    /**
     * The bukkit task
     */
    private BukkitTask task;

    /**
     * Will be called on start of task
     */
    public abstract void onStart();

    /**
     * Starts the Counter with starting Seconds
     */
    public void startCounter(final int startSeconds) {
        this.running = true;
        this.seconds = startSeconds;
        this.onStart();
        this.startTask();
    }

    /**
     * Starts the Counter at 0 Seconds
     */
    public void startCounter() {
        this.running = true;
        this.seconds = 0;
        this.onStart();
        this.startTask();
    }

    /**
     * Starts the Counter with the previous Seconds
     */
    public void resumeCounter() {
        this.running = true;
        this.onStart();
        this.startTask();
    }

    private void startTask() {
        this.task = Bukkit.getScheduler().runTaskTimer(instance, () -> {

            Counter.this.run();

            Counter.this.seconds++;
        }, 0, 20);
    }

    /**
     * Cancel the Task
     */
    public void stopCounter() {
        this.running = false;
        this.task.cancel();
    }

    public boolean isRunning() {
        return running;
    }

    public int getSeconds() {
        return seconds;
    }

    public BukkitTask getTask() {
        return task;
    }
}
