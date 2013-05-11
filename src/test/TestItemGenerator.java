package test;

import model.Item;
import model.ItemGenerator;
import model.ItemGenerator.Difficulty;
import model.Rune;
import model.Rune.Color;
import model.Rune.Shape;

public class TestItemGenerator extends Test {

	@Override
	public void run() {
		getterSetterTest();
		generateRuneTest();
	}
	
	public void getterSetterTest() {
		// Difficulty setting
		ItemGenerator easyGen = new ItemGenerator(ItemGenerator.Difficulty.EASY);
		ItemGenerator mediumGen = new ItemGenerator(ItemGenerator.Difficulty.MEDIUM);
		ItemGenerator hardGen = new ItemGenerator(Difficulty.HARD);
		assert(easyGen.getColorRange() == 4 && easyGen.getShapeRange() == 4);
		assert(mediumGen.getColorRange() == 4 && mediumGen.getShapeRange() == 6);
		assert(hardGen.getColorRange() == 6 && hardGen.getShapeRange() == 6);
	}
	
	public void generateRuneTest() {
		ItemGenerator easyGen = new ItemGenerator(ItemGenerator.Difficulty.EASY);
		ItemGenerator mediumGen = new ItemGenerator(ItemGenerator.Difficulty.MEDIUM);
		ItemGenerator hardGen = new ItemGenerator(Difficulty.HARD);
		// EASY
		for (int i = 0; i < 1000; i++) {
			Item item = easyGen.generateItem();
			if (item.isRune()) {
				Rune rune = (Rune) item;
				Color c = rune.getColor();
				Shape s = rune.getShape();
				assert(c == Color.RED || c == Color.GREEN || c == Color.BLUE || c == Color.YELLOW);
				assert(s == Shape.SHAPE1 || s == Shape.SHAPE2 || s == Shape.SHAPE3 || s == Shape.SHAPE4);
			}
		}
		// MEDIUM
		for (int i = 0; i < 1000; i++) {
			Item item = mediumGen.generateItem();
			if (item.isRune()) {
				Rune rune = (Rune) item;
				Color c = rune.getColor();
				Shape s = rune.getShape();
				assert(c == Color.RED || c == Color.GREEN || c == Color.BLUE || c == Color.YELLOW);
				assert(s == Shape.SHAPE1 || s == Shape.SHAPE2 || s == Shape.SHAPE3 || s == Shape.SHAPE4 || s == Shape.SHAPE5 || s == Shape.SHAPE6);
			}
		}
		// HARD
		for (int i = 0; i < 1000; i++) {
			Item item = hardGen.generateItem();
			if (item.isRune()) {
				Rune rune = (Rune) item;
				Color c = rune.getColor();
				Shape s = rune.getShape();
				assert(c == Color.RED || c == Color.GREEN || c == Color.BLUE || c == Color.YELLOW || c == Color.BLACK || c == Color.WHITE);
				assert(s == Shape.SHAPE1 || s == Shape.SHAPE2 || s == Shape.SHAPE3 || s == Shape.SHAPE4 || s == Shape.SHAPE5 || s == Shape.SHAPE6);
			}
		}
	}
	
}
