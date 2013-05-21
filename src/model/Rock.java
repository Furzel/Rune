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

	@Override
	public boolean canBePlacedOnCell(Cell c, Grid g) {
		assert(c != null);
		if(c.data.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean canBePlacedOnCell(Cell c) {
		return this.canBePlacedOnCell(c, null);
	}

	@Override
	public void putOnCell(Cell c) {
		assert(c != null);
		c.data.item = this;
	}

}
