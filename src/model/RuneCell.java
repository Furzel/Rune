package model;

public class RuneCell extends CellData {
	
	public static enum Color {
		RED, GREEN, BLUE, YELLOW, BLACK, WHITE, NONE;
	}
	
	public static enum Shape {
		SHAPE1, SHAPE2, SHAPE3, SHAPE4, SHAPE5, SHAPE6, NONE;
	}
	
	private Color _color;
	private Shape _shape;
	private boolean _isEmpty;
	private boolean _isRock;
	
	
	public RuneCell() {
		
		_color = Color.NONE;
		_shape = Shape.NONE;
		_isEmpty = true;
		_isRock = false;
	}
	
	public RuneCell(Color c, Shape s) {
		_color = c;
		_shape = s;
		_isEmpty = false;
		_isRock = false;
	}
	
	public RuneCell(int color, int shape) {
		assert(shape >= 0 && color <= 6);
		assert(shape >= 0 && color <= 6);
		_color = Color.values()[color];
		_shape = Shape.values()[shape];
	}
	
	public Color getColor() {
		if (_color != Color.NONE) {
			return _color;
		} else {
			return null;
		}
	}
	
	public Shape getShape() {
		if (_shape != Shape.NONE) {
			return _shape;
		} else {
			return null;
		}
	}
	
	public void setRune(Color c, Shape s) {
		assert(c != Color.NONE);
		assert(s != Shape.NONE);
		_color = c;
		_shape = s;
		_isEmpty = false;
		_isRock = false;
	}
	
	public boolean isEmpty() {
		return _isEmpty;
	}
	
	public void setEmpty() {
		_isEmpty = true;
		_isRock = false;
		_color = Color.NONE;
		_shape = Shape.NONE;
	}
	
	public boolean isRock() {
		return _isRock;
	}
	
	public void setRock() {
		_isRock = true;
		_isEmpty = false;
		_color = Color.NONE;
		_shape = Shape.NONE;
	}
}
