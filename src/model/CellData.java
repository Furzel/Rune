package model;

public class CellData {
	public Item item;
	
	public CellData() {
		item = null;
	}
	
	public boolean isEmpty() {
		return item == null;
	}
}
