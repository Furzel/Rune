package model;

import java.util.Random;


public class RuneGenerator {
	
	public static enum Difficulty {
		EASY, MEDIUM, HARD
	}
	
	private int _colorRange;
	private int _shapeRange;
	private Difficulty _difficulty;
	
	public RuneGenerator(Difficulty difficulty) {
		setDifficulty(difficulty);
	}
	
	public void setDifficulty(Difficulty difficulty) {
		switch(difficulty) {
		case EASY: {
			_colorRange = 4;
			_shapeRange = 4;
		} break;
		case MEDIUM: {
			_colorRange = 4;
			_shapeRange = 6;
		} break;
		case HARD: {
			_colorRange = 6;
			_shapeRange = 6;
		} break;
		default: {
			assert(false);
		}
		}
		_difficulty = difficulty;
	}
	
	public RuneCell generateRune() {
		Random r = new Random();
		int color = r.nextInt(_colorRange);
		int shape = r.nextInt(_shapeRange);
		return new RuneCell(color, shape);
	}
	
	public int getColorRange() {
		return _colorRange;
	}
	
	public int getShapeRange() {
		return _shapeRange;
	}
}
