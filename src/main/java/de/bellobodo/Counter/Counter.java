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
    private int seconds;

    /**
     * The bukkit task
     */
    private BukkitTask task;

    /**
     * Starts the Counter with starting Seconds
     */
    public void startCounter(int startSeconds) {
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
        this.onResume();
        this.startTask();
    }

    private void startTask() {
        this.task = Bukkit.getScheduler().runTaskTimer(Manhunt.getInstance(), () -> {

            Counter.this.run();

            Counter.this.seconds++;
        }, 0, 20);
    }

    /**
     * Will be called on start of task
     */
    public abstract void onStart();

    /**
     * Will be called on resume of task
     */
    public abstract void onResume();

    /**
     * Cancel the Task
     */
    public void pauseCounter() {
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
