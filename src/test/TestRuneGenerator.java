package test;

import model.RuneCell;
import model.RuneGenerator;
import model.RuneCell.Color;
import model.RuneCell.Shape;
import model.RuneGenerator.Difficulty;

public class TestRuneGenerator extends Test {

	@Override
	public void run() {
		getterSetterTest();
		generateRuneTest();
	}
	
	public void getterSetterTest() {
		// Difficulty setting
		RuneGenerator easyGen = new RuneGenerator(RuneGenerator.Difficulty.EASY);
		RuneGenerator mediumGen = new RuneGenerator(RuneGenerator.Difficulty.MEDIUM);
		RuneGenerator hardGen = new RuneGenerator(Difficulty.HARD);
		assert(easyGen.getColorRange() == 4 && easyGen.getShapeRange() == 4);
		assert(mediumGen.getColorRange() == 4 && mediumGen.getShapeRange() == 6);
		assert(hardGen.getColorRange() == 6 && hardGen.getShapeRange() == 6);
	}
	
	public void generateRuneTest() {
		RuneGenerator easyGen = new RuneGenerator(RuneGenerator.Difficulty.EASY);
		RuneGenerator mediumGen = new RuneGenerator(RuneGenerator.Difficulty.MEDIUM);
		RuneGenerator hardGen = new RuneGenerator(Difficulty.HARD);
		// EASY
		for (int i = 0; i < 1000; i++) {
			RuneCell rune = easyGen.generateRune();
			Color c = rune.getColor();
			Shape s = rune.getShape();
			assert(c == Color.RED || c == Color.GREEN || c == Color.BLUE || c == Color.YELLOW);
			assert(s == Shape.SHAPE1 || s == Shape.SHAPE2 || s == Shape.SHAPE3 || s == Shape.SHAPE4);
		}
		// MEDIUM
		for (int i = 0; i < 1000; i++) {
			RuneCell rune = easyGen.generateRune();
			Color c = rune.getColor();
			Shape s = rune.getShape();
			assert(c == Color.RED || c == Color.GREEN || c == Color.BLUE || c == Color.YELLOW);
			assert(s == Shape.SHAPE1 || s == Shape.SHAPE2 || s == Shape.SHAPE3 || s == Shape.SHAPE4 || s == Shape.SHAPE5 || s == Shape.SHAPE6);
		}
		// HARD
		for (int i = 0; i < 1000; i++) {
			RuneCell rune = easyGen.generateRune();
			Color c = rune.getColor();
			Shape s = rune.getShape();
			assert(c == Color.RED || c == Color.GREEN || c == Color.BLUE || c == Color.YELLOW || c == Color.BLACK || c == Color.WHITE);
			assert(s == Shape.SHAPE1 || s == Shape.SHAPE2 || s == Shape.SHAPE3 || s == Shape.SHAPE4 || s == Shape.SHAPE5 || s == Shape.SHAPE6);
		}
	}
	
}
