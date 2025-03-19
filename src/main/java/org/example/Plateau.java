package org.example;

public class Plateau {
    private final int maxX;
    private final int maxY;

    public Plateau(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
    }
}
