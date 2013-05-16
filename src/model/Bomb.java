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

	@Override
	public boolean canBePlacedOnCell(Cell c) {
		assert(c != null);
		if (c.data.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void putOnCell(Cell c) {
		assert(c != null);
		assert(c.data.item != null);
		c.data.item = null;
	}

}
