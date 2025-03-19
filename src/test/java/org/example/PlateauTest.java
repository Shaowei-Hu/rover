package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    @DisplayName("valid position should return true")
    void validPositionShouldSucceed() {
        //given
        Plateau plateau = new Plateau(5, 5);
        //then
        assertTrue(plateau.isValidPosition(0, 0));
        assertTrue(plateau.isValidPosition(5, 5));
        assertTrue(plateau.isValidPosition(3, 2));
    }

    @Test
    @DisplayName("invalid position should return false")
    void testInvalidPosition() {
        //given
        Plateau plateau = new Plateau(5, 5);
        //then
        assertFalse(plateau.isValidPosition(-1, 0));
        assertFalse(plateau.isValidPosition(0, -1));
        assertFalse(plateau.isValidPosition(8, 5));
        assertFalse(plateau.isValidPosition(5, 8));
    }

}
