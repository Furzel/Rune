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
		testCanBePlacedOnCell();
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
		assert(!rune1.canBePlacedOnCell(g.getCell(1,1), g));
		Rock rock1 = new Rock();
		rock1.putOnCell(g.getCell(5,5));
		// Can't be place over something
		assert(!rune1.canBePlacedOnCell(g.getCell(5,5), g));
		// Can be placed next to a rock 
		assert(rune1.canBePlacedOnCell(g.getCell(5, 4), g));
		rune1.putOnCell(g.getCell(5, 4));
		Rune rune2 = new Rune(Rune.Color.BLACK, Rune.Shape.SHAPE1);
		// Can be placed next to a rune with same shape
		assert(rune2.canBePlacedOnCell(g.getCell(5, 3), g));
		rune2.putOnCell(g.getCell(5, 3));
		Rune rune3 = new Rune(Rune.Color.BLACK, Rune.Shape.SHAPE2);
		// Can be placed next to a rune with same color
		assert(rune3.canBePlacedOnCell(g.getCell(5,2), g));
		rune3.putOnCell(g.getCell(5, 2));
		Rune rune4 = new Rune(Rune.Color.BLACK, Rune.Shape.SHAPE2);
		// Can be placed next to the exact same rune
		assert(rune4.canBePlacedOnCell(g.getCell(4, 2), g));
		rune4.putOnCell(g.getCell(4, 2));
		Rune rune5 = new Rune(Rune.Color.RED, Rune.Shape.SHAPE5);
		// Can't be placed if neither shape or color are the same
		assert(!rune5.canBePlacedOnCell(g.getCell(4,1), g));
		Rune rune6 = new Rune(Rune.Color.BLACK, Rune.Shape.SHAPE5);
		Rune rune7 = new Rune(Rune.Color.GREEN, Rune.Shape.SHAPE1);
		// Rune have to match with all their neighboors
		assert(rune6.canBePlacedOnCell(g.getCell(4,3), g));
		assert(!rune7.canBePlacedOnCell(g.getCell(4,3), g));
		rune6.putOnCell(g.getCell(4, 3));
	}
}
