package test;

import model.Cell;

public class TestCell extends Test {
	
	@Override
	public void run() {
		creationTest();
	}
	
	public void creationTest() {
		Cell c = new Cell(42, 43);
		assert(c.x == 42);
		assert(c.y == 43);
		assert(c.data != null);
	}
	
	
	
}
