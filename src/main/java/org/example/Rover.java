package org.example;

import org.example.exception.LocationBeyondPlateauException;
import org.example.exception.UnknownInstructionException;

public class Rover {
    private Position position;
    private Direction direction;
    private final Plateau plateau;

    public Rover(int x, int y, Direction direction, Plateau plateau) {
        this.direction = direction;
        this.plateau = plateau;
        if (plateau.isValidPosition(x, y)) {
            position = new Position(x, y);
        } else {
            throw new LocationBeyondPlateauException();
        }
    }

    public void processCommands(String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L': direction = direction.turnLeft(); break;
                case 'R': direction = direction.turnRight(); break;
                case 'M': moveForward(); break;
                default: throw new UnknownInstructionException(command);
            }
        }
    }

    private void moveForward() {
        Position newPosition = switch (direction) {
            case N -> new Position(position.x(), position.y() + 1);
            case E -> new Position(position.x() + 1, position.y());
            case S -> new Position(position.x(), position.y() - 1);
            case W -> new Position(position.x() - 1, position.y());
        };

        if (plateau.isValidPosition(newPosition.x(), newPosition.y())) {
            position = newPosition;
        } else {
            throw new LocationBeyondPlateauException();
        }
    }

    public String reportPosition() {
        return String.format("%d %d %s", position.x(), position.y(), direction);
    }
}
