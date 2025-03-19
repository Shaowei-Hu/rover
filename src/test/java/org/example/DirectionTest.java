package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    @DisplayName("turn left should succeed")
    void turnLeftShouldSucceed() {
        assertEquals(Direction.W, Direction.N.turnLeft());
        assertEquals(Direction.S, Direction.W.turnLeft());
        assertEquals(Direction.E, Direction.S.turnLeft());
        assertEquals(Direction.N, Direction.E.turnLeft());
    }

    @Test
    @DisplayName("turn right should succeed")
    void turnRightShouldSucceed() {
        assertEquals(Direction.E, Direction.N.turnRight());
        assertEquals(Direction.S, Direction.E.turnRight());
        assertEquals(Direction.W, Direction.S.turnRight());
        assertEquals(Direction.N, Direction.W.turnRight());
    }
}

