package model;

public class Bomb implements Item {

	@Override
	public boolean isRock() {
		return false;
	}

	@Override
	public boolean isBomb() {
		return true;
	}

	@Override
	public boolean isRune() {
		return false;
	}

}
