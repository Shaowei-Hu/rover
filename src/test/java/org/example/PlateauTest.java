package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    private Plateau plateau;
    private Position position1;
    private Position position2;

    @BeforeEach
    void setUp() {
        plateau = new Plateau(5, 5);  // Creating a 5x5 plateau
        position1 = new Position(2, 2);
        position2 = new Position(3, 3);
    }

    @Test
    @DisplayName("valid position should return true")
    void validPositionShouldSucceed() {
        //given
        //then
        assertTrue(plateau.isValidPosition(new Position(0, 0)));
        assertTrue(plateau.isValidPosition(new Position(5, 5)));
        assertTrue(plateau.isValidPosition(new Position(3, 2)));
    }

    @Test
    @DisplayName("invalid position should return false")
    void testInvalidPosition() {
        //given
        //then
        assertFalse(plateau.isValidPosition(new Position(-1, 0)));
        assertFalse(plateau.isValidPosition(new Position(0, -1)));
        assertFalse(plateau.isValidPosition(new Position(8, 5)));
        assertFalse(plateau.isValidPosition(new Position(5, 8)));
    }
    
    @Test
    @DisplayName("position is occupied should return true")
    void positionIsOccupiedShouldReturnTrue() {
        //given
        plateau.addOccupiedPosition(position1);
        //when
        boolean result = plateau.isOccupied(position1);
        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("position is not occupied should return false")
    void positionIsNotOccupiedShouldReturnFalse() {
        //when
        boolean result = plateau.isOccupied(position1);
        //then
        assertFalse(result);
    }

    @Test
    @DisplayName("add a position successfully")
    void addPositionSuccessfully() {

        //when
        boolean result = plateau.addOccupiedPosition(position1);
        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("update position correctly")
    void updatePositionCorrectly() {
        //given
        plateau.addOccupiedPosition(position1);
        assertTrue(plateau.isOccupied(position1));
        //when
        plateau.updatePosition(position1, position2);
        //then
        assertFalse(plateau.isOccupied(position1));
        assertTrue(plateau.isOccupied(position2));
    }

}
