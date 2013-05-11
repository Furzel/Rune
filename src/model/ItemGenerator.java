package model;

import java.util.Random;


public class ItemGenerator {
	
	public static enum Difficulty {
		EASY, MEDIUM, HARD
	}
	
	private int _colorRange;
	private int _shapeRange;
	private int _rockPercentage;
	private int _bombPercentage;
	private Difficulty _difficulty;
	
	public ItemGenerator(Difficulty difficulty) {
		setDifficulty(difficulty);
	}
	
	public void setDifficulty(Difficulty difficulty) {
		switch(difficulty) {
		case EASY: {
			_colorRange = 4;
			_shapeRange = 4;
			_rockPercentage = 15;
			_bombPercentage = 15;
		} break;
		case MEDIUM: {
			_colorRange = 4;
			_shapeRange = 6;
			_rockPercentage = 10;
			_bombPercentage = 10;
		} break;
		case HARD: {
			_colorRange = 6;
			_shapeRange = 6;
			_rockPercentage = 5;
			_bombPercentage = 5;
		} break;
		default: {
			assert(false);
		}
		}
		_difficulty = difficulty;
	}
	
	public Item generateItem() {
		Random r = new Random();
		if (r.nextInt(100) < _rockPercentage) {
			return new Rock();
		} else if (r.nextInt(100) < _bombPercentage) {
			return new Bomb();
		} else {
			int color = r.nextInt(_colorRange);
			int shape = r.nextInt(_shapeRange);
			return new Rune(color, shape);
		}
	}
	
	public int getColorRange() {
		return _colorRange;
	}
	
	public int getShapeRange() {
		return _shapeRange;
	}
}
