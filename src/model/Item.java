package model;

public interface Item {

	public boolean isRock();
	public boolean isBomb();
	public boolean isRune();
	
	public boolean canBePlacedOnCell(Cell c);
	public void putOnCell(Cell c);
}
