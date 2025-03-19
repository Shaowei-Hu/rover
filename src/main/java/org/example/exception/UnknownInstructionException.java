package org.example.exception;

public class UnknownInstructionException extends RuntimeException {

	public UnknownInstructionException() {
		super("Unknown instruction!");
	}
	public UnknownInstructionException(char instruction) {
		super("Unknown instruction: " + instruction);
	}
}
