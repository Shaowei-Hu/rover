package org.example;

import org.example.exception.UnknownInstructionException;

public enum Command {
    L, R, M;

    public static Command fromChar(char command) {
        try {
            return Command.valueOf(String.valueOf(command));
        } catch (IllegalArgumentException e) {
            throw new UnknownInstructionException(command);
        }
    }
}
