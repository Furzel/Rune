package test;

import model.Bomb;
import model.Cell;
import model.Rune;

public class TestBomb extends Test {

	@Override
	public void run() {
		testCreation();
		testCanBePlacedOnCell();
		testPutOnCell();
	}

	public void testCreation() {
		Bomb b = new Bomb();
		assert(b != null);
	}
	
	public void testPutOnCell() {
		Bomb b = new Bomb();
		Cell c = new Cell(5, 5);
		Rune r = new Rune(1, 2);
		c.data.item = r;
		b.putOnCell(c);
		assert(c.data.isEmpty());
	}
	
	public void testCanBePlacedOnCell() {
		Bomb b = new Bomb();
		Cell c = new Cell(5, 5);
		// Bomb have no effect on empty cell
		assert(c.data.isEmpty());
		assert(!b.canBePlacedOnCell(c));
		// Bomb can only be placed on a non empty cell 
		Rune r = new Rune(1, 2);
		c.data.item = r;
		assert(!c.data.isEmpty() && b.canBePlacedOnCell(c));
	}
}
