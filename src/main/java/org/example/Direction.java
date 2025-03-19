package org.example;

public enum Direction {
    N, E, S, W;

    public Direction turnLeft() {
        return switch (this) {
            case E -> N;
            case N -> W;
            case S -> E;
            case W -> S;
        };
    }

    public Direction turnRight() {
        return switch (this) {
            case E -> S;
            case N -> E;
            case S -> W;
            case W -> N;
        };
    }
}
