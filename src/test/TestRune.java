package test;

import model.Cell;
import model.Grid;
import model.Rock;
import model.Rune;

public class TestRune extends Test {
	
	@Override
	public void run() {
		testCreation();
		testGetterAndSetters();
		testPutOnCell();
	}
	
	public void testCreation() {
		Rune rune = new Rune(Rune.Color.BLUE, Rune.Shape.SHAPE2);
		assert(rune.getColor() == Rune.Color.BLUE);
		assert(rune.getShape() == Rune.Shape.SHAPE2);
		assert(!rune.isRock());
		assert(!rune.isBomb());
		assert(rune.isRune());
	}
	
	public void testGetterAndSetters() {
		Rune rune = new Rune(Rune.Color.BLUE, Rune.Shape.SHAPE2);
		rune.setColorAndShape(Rune.Color.BLACK, Rune.Shape.SHAPE1);
		assert(rune.getColor() == Rune.Color.BLACK);
		assert(rune.getShape() == Rune.Shape.SHAPE1);
		assert(!rune.isRock());
	}
	
	public void testPutOnCell() {
		Rune rune = new Rune(Rune.Color.BLUE, Rune.Shape.SHAPE2);
		Cell c = new Cell(0, 0);
		rune.putOnCell(c);
		assert(c.data.item.equals(rune));
	}
	
	public void testCanBePlacedOnCell() {
		Rune rune1 = new Rune(Rune.Color.BLUE, Rune.Shape.SHAPE1);
		Grid g = new Grid();
		// Can't be placed next to nothing
		assert(rune1.canBePlacedOnCell(g.getCell(1,1)));
		// Can't be place over something
		// Can be placed next to a rock 
		Rock rock1 = new Rock();
		rock1.putOnCell(g.getCell(5,5));
		assert(!rune1.canBePlacedOnCell(g.getCell(5,5)));
		assert(rune1.canBePlacedOnCell(g.getCell(5, 4)));
		rune1.putOnCell(g.getCell(1,1));
		
	}
}
