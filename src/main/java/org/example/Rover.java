package org.example;

import org.example.exception.PositionBeyondPlateauException;
import org.example.exception.PositionOccupiedException;

public class Rover {
    private Position position;
    private Direction direction;
    private final Plateau plateau;

    public Rover(int x, int y, Direction direction, Plateau plateau) {
        this(new Position(x, y), direction, plateau);
    }

    public Rover(Position position, Direction direction, Plateau plateau) {
        this.direction = direction;
        this.plateau = plateau;

        if (!plateau.isValidPosition(position)) {
            throw new PositionBeyondPlateauException(position);
        }
        if (plateau.isOccupied(position)) {
            throw new PositionOccupiedException(position);
        }

        this.position = position;
        plateau.addOccupiedPosition(position);
    }

    public void processCommands(String commands) {
        commands.chars()
                .mapToObj(c -> Command.fromChar((char) c))
                .forEach(this::executeCommand);
    }

    private void executeCommand(Command command) {
        switch (command) {
            case L -> direction = direction.turnLeft();
            case R -> direction = direction.turnRight();
            case M -> moveForward();
        }
    }

    private void moveForward() {
        Position newPosition = switch (direction) {
            case N -> new Position(position.x(), position.y() + 1);
            case E -> new Position(position.x() + 1, position.y());
            case S -> new Position(position.x(), position.y() - 1);
            case W -> new Position(position.x() - 1, position.y());
        };

        if (plateau.isOccupied(newPosition)) {
            throw new PositionOccupiedException(newPosition);
        }

        if (!plateau.isValidPosition(newPosition)) {
            throw new PositionBeyondPlateauException(newPosition);
        }

        plateau.updatePosition(position, newPosition);
        position = newPosition;

    }

    public String reportPosition() {
        return String.format("%d %d %s", position.x(), position.y(), direction);
    }
}
