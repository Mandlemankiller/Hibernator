package cz.jeme.programu.hibernator;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.logging.Level;

public class HibernationRunnable extends BukkitRunnable {

    private long sleep;

    public HibernationRunnable(long sleep) {
        this.sleep = sleep;
    }

    public void setSleep(long sleep) {
        this.sleep = sleep;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            Hibernator.serverLog(Level.SEVERE, "Sleep interrupted!");
            e.printStackTrace();
        }
    }

    public void unloadChunks(boolean log) {
        for (World world : Bukkit.getWorlds()) {
            long unloads = 0;
            long failedUnloads = 0;
            for (Chunk chunk : world.getLoadedChunks()) {
                if (chunk.unload()) {
                    unloads++;
                } else {
                    failedUnloads++;
                }
            }
            if (log) {
                String logMessage = world.getName() + ": Unloaded " + unloads + " chunks, unable to unload "
                        + failedUnloads;
                Hibernator.serverLog(Level.INFO, logMessage);
            }
        }
    }
}
