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
	public boolean canBePlacedOnCell(Cell c, Grid g) {
		assert(c != null);
		if (c.data.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean canBePlacedOnCell(Cell c) {
		return this.canBePlacedOnCell(c, null);
	}

	@Override
	public void putOnCell(Cell c) {
		assert(c != null);
		assert(c.data.item != null);
		c.data.item = null;
	}

}
