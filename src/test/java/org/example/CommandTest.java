package org.example;

import org.example.exception.UnknownInstructionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    @DisplayName("return correct enum for valid characters")
    void returnCorrectEnumForValidCharacters() {
        assertEquals(Command.L, Command.fromChar('L'));
        assertEquals(Command.R, Command.fromChar('R'));
        assertEquals(Command.M, Command.fromChar('M'));
    }

    @Test
    @DisplayName("invalid command should throw")
    void invalidCommandShouldThrow() {
        //given
        char invalidCommand = 'X';
        try{
            //when
            Command.fromChar(invalidCommand);
            fail("Should have thrown before!");
        } catch (UnknownInstructionException exception) {
            assertEquals("Unknown instruction: X", exception.getMessage());
        }
    }

}
