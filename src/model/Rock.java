package model;

public class Rock implements Item {

	@Override
	public boolean isRock() {
		return true;
	}

	@Override
	public boolean isBomb() {
		return false;
	}

	@Override
	public boolean isRune() {
		return false;
	}

}
