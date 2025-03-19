package org.example.exception;

import org.example.Position;

public class PositionBeyondPlateauException extends RuntimeException {
	public PositionBeyondPlateauException() {
		super("Position beyond the plateau!");
	}

	public PositionBeyondPlateauException(Position position) {
		super("Position beyond the plateau: " + position);
	}

}
