package model;

public class Cell {
	
	public CellData data;
	public int x;
	public int y;
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		data = new CellData();
	}
	
	
	
}
