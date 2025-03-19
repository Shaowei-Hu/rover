package org.example.exception;

public class LocationBeyondPlateauException extends RuntimeException {
	public LocationBeyondPlateauException() {
		super("Location beyond the plateau!");
	}
}
