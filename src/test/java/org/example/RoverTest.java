package org.example;

import org.example.exception.PositionBeyondPlateauException;
import org.example.exception.PositionOccupiedException;
import org.example.exception.UnknownInstructionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    private final Plateau plateau = new Plateau(5, 5);

    @Test
    @DisplayName("initialization should succeed")
    void initializationShouldSucceed() {
        //given
        Plateau plateau = new Plateau(5, 5);
        //when
        Rover rover = new Rover(0, 0, Direction.N, plateau);
        //then
        assertEquals("0 0 N", rover.reportPosition());
    }

    @Test
    @DisplayName("landing rover beyond plateau should throw")
    void landingRoverBeyondPlateauShouldThrow() {
        try {
            //when
            new Rover(6, 6, Direction.N, plateau);
            fail("Dropping should have thrown before!");
        } catch (PositionBeyondPlateauException ex) {
            //then
            assertEquals("Position beyond the plateau: Position[x=6, y=6]", ex.getMessage());
        }
    }

    @Test
    @DisplayName("turn left should succeed")
    void turnLeftShouldSucceed() {
        //given
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(1, 2, Direction.N, plateau);
        //when
        rover.processCommands("L");
        //then
        assertEquals("1 2 W", rover.reportPosition());
    }

    @Test
    @DisplayName("turn right should succeed")
    void turnRightShouldSucceed() {
        //given
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(1, 2, Direction.S, plateau);
        //when
        rover.processCommands("R");
        //then
        assertEquals("1 2 W", rover.reportPosition());
    }

    @Test
    @DisplayName("moving forward should succeed")
    void movingForwardShouldSucceed() {
        //given
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(1, 2, Direction.N, plateau);
        //when
        rover.processCommands("M");
        //then
        assertEquals("1 3 N", rover.reportPosition());
    }


    @Test
    @DisplayName("moving rover should succeed 1")
    void movingRoverShouldSucceed1() {
        //given
        Rover rover = new Rover(1, 2, Direction.N, plateau);
        //when
        rover.processCommands("LMLMLMLMM");
        //then
        String report = rover.reportPosition();
        assertEquals("1 3 N", report);
    }

    @Test
    @DisplayName("moving rover should succeed 2")
    void movingRoverShouldSucceed2() {
        //given
        Rover rover = new Rover(3, 3, Direction.E, plateau);
        //when
        rover.processCommands("MMRMMRMRRM");
        //then
        String report = rover.reportPosition();
        assertEquals("5 1 E", report);
    }

    @Test
    @DisplayName("encountering unknown instruction should throw")
    void encounteringUnknownInstructionShouldThrow() {
        //given
        Rover rover = new Rover(2, 2, Direction.N, plateau);
        try {
            //when
            rover.processCommands("MMB");
            fail("Moving should have thrown before!");
        } catch (UnknownInstructionException ex) {
            //then
            assertEquals("Unknown instruction: B", ex.getMessage());
        }
    }

    @Test
    @DisplayName("moving rover beyond plateau should throw")
    void movingRoverBeyondPlateauShouldThrow() {
        //given
        Rover rover = new Rover(2, 2, Direction.N, plateau);
        try {
            //when
            rover.processCommands("MMMMMMMM");
            fail("Moving should have thrown before!");
        } catch (PositionBeyondPlateauException ex) {
            //then
            assertEquals("Position beyond the plateau: Position[x=2, y=6]", ex.getMessage());
        }
    }

    @Test
    @DisplayName("two rovers landing on same position should throw")
    void twoRoversLandingOnSamePositionShouldThrow() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover1 = new Rover(1, 1, Direction.N, plateau);
        try {
            new Rover(1, 1, Direction.E, plateau); // Attempt to place second rover in same spot

        } catch (PositionOccupiedException ex) {
            assertEquals("Position occupied on the plateau: Position[x=1, y=1]", ex.getMessage());
        }
    }

    @Test
    @DisplayName("move into occupied position should throw")
    void moveIntoOccupiedPositionShouldThrow() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover1 = new Rover(1, 1, Direction.N, plateau);
        Rover rover2 = new Rover(1, 2, Direction.S, plateau);
        try {
            rover2.processCommands("M"); // Attempt to move into occupied position

        } catch (PositionOccupiedException ex) {
            assertEquals("Position occupied on the plateau: Position[x=1, y=1]", ex.getMessage());
            assertEquals("1 2 S", rover2.reportPosition());
        }

    }

}
