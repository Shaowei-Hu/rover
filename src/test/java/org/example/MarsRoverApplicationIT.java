package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverApplicationIT {

    private static final String INPUT_FILE_PATH = "src/test/resources/input.txt";
    private static final String ERROR_INPUT_FILE_PATH = "src/test/resources/error_input.txt";
    public static final String NON_EXISTENT_FILE = "nonexistent.txt";
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private ByteArrayOutputStream outContent;
    private ByteArrayOutputStream errContent;

    @BeforeEach
    void setUp() {
        // Redirect System.out and System.err to capture output
        outContent = new ByteArrayOutputStream();
        errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    void tearDown() {
        // Restore
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    @DisplayName("Mars Rover Application with valid input")
    void marsRoverApplicationWithValidInput() {
        //given when
        MarsRoverApplication.main(new String[]{INPUT_FILE_PATH});

        //then
        String output = outContent.toString().trim().replace("\r\n", "\n");
        String expectedOutput =
                """
                1 3 N
                5 1 E""";
        assertEquals(expectedOutput, output);
    }

    @Test
    @DisplayName("Mars Rover Application with missing file")
    void marsRoverApplicationWithMissingFile() {
        //given when
        MarsRoverApplication.main(new String[]{NON_EXISTENT_FILE});

        //then
        String errorOutput = errContent.toString().trim();
        assertTrue(errorOutput.contains("File not found"));
    }

    @Test
    @DisplayName("Mars Rover Application with invalid input")
    void marsRoverApplicationWithInvalidInput() {
        //given when
        MarsRoverApplication.main(new String[]{ERROR_INPUT_FILE_PATH});

        //then
        String errorOutput = errContent.toString().trim();
        assertTrue(errorOutput.contains("Error processing input"));
    }
}
