package cz.jeme.programu.hibernator;

import org.bukkit.scheduler.BukkitRunnable;

public class HibernationSchedule extends BukkitRunnable {

    HibernationManager snoreHandler;

    public HibernationSchedule(HibernationManager snoreHandler) {
        this.snoreHandler = snoreHandler;
    }

    @Override
    public void run() {
        snoreHandler.enableHibernation();
    }
}
