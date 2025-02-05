import config.Settings;
import entity.Creature;
import entity.map.Island;
import entity.map.Location;
import util.LocationAnimalServise;
import util.Statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Application {
    public static void main(String[] args) {

        Island island = new Island(Settings.rowsCount, Settings.columnsCount);
        island.locationFactory();
        Statistics statistics = new Statistics(island);
        System.out.println("День 1");
        statistics.run();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 1; i <= Settings.maxDay; i++) {
            List<Future<?>> tasks = new ArrayList<>();
            tasks.add(executorService.submit(new LocationAnimalServise(island)));

            if (!tasks.isEmpty()) {
                for (Future<?> future : tasks) {
                    try {
                        future.get();
                    } catch (ExecutionException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("День " + (i + 1));
                statistics.run();
            }
        }
        executorService.shutdown();
    }
}
