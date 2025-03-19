package org.example;

import java.util.HashSet;
import java.util.Set;

public class Plateau {
    private final int maxX;
    private final int maxY;

    private final Set<Position> occupiedPositions = new HashSet<>();

    public Plateau(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean isValidPosition(Position position) {
        return position.x() >= 0 && position.x() <= maxX && position.y() >= 0 && position.y() <= maxY;
    }

    public boolean isOccupied(Position position) {
        return occupiedPositions.contains(position);
    }

    public boolean addOccupiedPosition(Position position) {
        return occupiedPositions.add(position);
    }

    public void updatePosition(Position oldPosition, Position newPosition) {
        occupiedPositions.remove(oldPosition);
        occupiedPositions.add(newPosition);
    }
}
