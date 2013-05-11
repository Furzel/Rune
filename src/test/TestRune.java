package test;

import model.Rune;

public class TestRune extends Test {
	
	@Override
	public void run() {
		testCreation();
		testGetterAndSetters();
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
}
