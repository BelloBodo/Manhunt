package de.bellobodo.countdowns;

import de.bellobodo.Manhunt;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

public abstract class Countdown implements Runnable {

    /**
     * Boolean if task run
     */
    private boolean running = false;

    /**
     * started Seconds of Task
     */
    private int startedSeconds;

    /**
     * remaining Seconds of Task
     */
    private int remainingSeconds;

    /**
     * The bukkit task
     */
    private BukkitTask task;

    /**
     * Start the Countdown
     * @param remainingSeconds The remaining seconds for the counter
     */
    public void startCountdown(int remainingSeconds) {
        this.running = true;
        this.startedSeconds = remainingSeconds;
        this.remainingSeconds = remainingSeconds;
        this.onStart();
        this.task = Bukkit.getScheduler().runTaskTimer(Manhunt.getInstance(), () -> {
            if (Countdown.this.remainingSeconds <= 0) {
                Countdown.this.cancelCountdown();
                Countdown.this.onEnd();
                return;
            }

            Countdown.this.run();
            Countdown.this.remainingSeconds--;
        }, 0, 20);
    }

    /**
     * Will be called on start of task
     */
    public abstract void onStart();

    /**
     * Will be called after remaining seconds are 0
     */
    public abstract void onEnd();

    /**
     * Cancel the Task
     */
    public void cancelCountdown() {
        this.running = false;
        this.task.cancel();
    }

    public boolean isRunning() {
        return running;
    }

    public int getStartedSeconds() {
        return startedSeconds;
    }

    public int getRemainingSeconds() {
        return remainingSeconds;
    }

    public Countdown setRemainingSeconds(int remainingSeconds) {
        this.remainingSeconds = remainingSeconds;
        return this;
    }

    public BukkitTask getTask() {
        return task;
    }
}
