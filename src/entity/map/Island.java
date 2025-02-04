package entity.map;

import config.Settings;

import java.util.ArrayList;
import java.util.List;

public class Island {

    private final int rows;
    private final int columns;
    public Location[][] locations;

    public Location[][] getLocations() {
        return locations;
    }

    public Island(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.locations = new Location[rows][columns];
        locationFactory();
    }

    public void locationFactory() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                locations[i][j] = new Location();
                locations[i][j].setRowsLocation(i);
                locations[i][j].setColumnsLocation(j);
            }
        }
    }

    public Location getLocation(int x, int y) {
        return locations[x][y];
    }

    public int getRows() {
        return locations.length;
    }

    public int getColumns() {
        return locations[0].length;
    }

    public List<Location> locationsList() {
        ArrayList<Location> locationArrayList = new ArrayList<>(getRows() * getColumns());
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                locationArrayList.add(locations[i][j]);
            }
        }
        return locationArrayList;
    }


}
