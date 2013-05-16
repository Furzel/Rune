package test;

import model.Cell;
import model.Grid;
import model.Rock;
import model.Rock;
import model.Rune;

public class TestRock extends Test {

	@Override
	public void run() {
		testCanBePlacedOnCell();
		testCreation();
		testPutOnCell();
	}
	
	public void testCreation() {
		Rock r = new Rock();
		assert(r!=null);
	}
	
	public void testPutOnCell() {
		Rock r = new Rock();
		Cell c = new Cell(0, 0);
		r.putOnCell(c);
		assert(c.data.item.equals(r));
	}
	
	public void testCanBePlacedOnCell() {
		Rock r = new Rock();
		Grid g = new Grid();
		// Can be put on empty grid
		Cell c = g.getCell(5, 5);
		assert(r.canBePlacedOnCell(c));
		// Can't be put on a non empty cell
		Rune ru = new Rune(1, 2);
		c.data.item = ru;
		assert(!r.canBePlacedOnCell(c));
	}

}
