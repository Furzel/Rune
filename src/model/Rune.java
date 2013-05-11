package model;

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
	
}
