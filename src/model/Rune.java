package model;

import java.util.ArrayList;

public class Rune implements Item{

	public static enum Color {
		RED, GREEN, BLUE, YELLOW, BLACK, WHITE;
	}
	
	public static enum Shape {
		SHAPE1, SHAPE2, SHAPE3, SHAPE4, SHAPE5, SHAPE6;
	}
	
	private Color _color;
	private Shape _shape;
	
	public Rune(Color c, Shape s) {
		_color = c;
		_shape = s;
	}
	
	public Rune(int color, int shape) {
		assert(shape >= 0 && color <= Color.values().length);
		assert(shape >= 0 && color <= Shape.values().length);
		_color = Color.values()[color];
		_shape = Shape.values()[shape];
	}
	
	public Color getColor() {
		return _color;
	}
	
	public Shape getShape() {
		return _shape;
	}
	
	public void setColorAndShape(Color c, Shape s) {
		_color = c;
		_shape = s;
	}
	
	@Override
	public boolean isRock() {
		return false;
	}

	@Override
	public boolean isBomb() {
		return false;
	}

	@Override
	public boolean isRune() {
		return true;
	}

	@Override
	public boolean canBePlacedOnCell(Cell c, Grid g) {
		if (!c.data.isEmpty()) {
			return false;
		}
		ArrayList<Cell> neighbors = g.getCrossCellNeighbors(c);
		// We need to check for empty neighbors because even if an 
		// empty one is a suitable neighbor, we can't place the rune
		// if all of them are empty
		int maxEmptyNeighbors = neighbors.size() - 1;
		boolean canBePlaced = true;
		for (Cell neighbor : neighbors) {
			if (!isSuitableNeighboor(neighbor)) {
				canBePlaced = false;
				break;
			} else if (neighbor.data.isEmpty()) {
				maxEmptyNeighbors--;
			}
		}
		return canBePlaced && maxEmptyNeighbors >= 0;
	}

	@Override
	public void putOnCell(Cell c) {
		assert(c.data.isEmpty());
		c.data.item = this;
	}
	
	private boolean isSuitableNeighboor(Cell c) {
		if (c.data.isEmpty()) {
			return true;
		} else if (c.data.item.isRock()) {
			return true;
		} else if (c.data.item.isRune()) {
			Rune r = (Rune)c.data.item;
			return r.getColor() == this.getColor() || r.getShape() == this.getShape();
		} else {
			assert(false); // WHADAFUK ?
			return false;
		}
	}
	
}
