package com.guitar.app;

public enum Type {
	ACOUSTIC, ELECTRIC;

	public String toString() {
		switch (this) {
		case ACOUSTIC:
			return "Indian Rosewood";
		case ELECTRIC:
			return "Electric";
		}
		return null;
	}
}
