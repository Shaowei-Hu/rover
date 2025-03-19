package org.example.exception;

import org.example.Position;

public class PositionOccupiedException extends RuntimeException {
	public PositionOccupiedException() {
		super("Position occupied on the plateau!");
	}

	public PositionOccupiedException(Position position) {
		super("Position occupied on the plateau: " + position);
	}
}
