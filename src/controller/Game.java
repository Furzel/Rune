package controller;

import model.Cell;
import model.Grid;
import model.Item;
import model.Rock;

public class Game {
	
	public Grid gameGrid;
	private Item _currentItem;
	
	
	public Game() {
		gameGrid = new Grid();
		_currentItem = new Rock();
	}
	
	public boolean playCurrentItem(int x, int y) {
		assert(_currentItem != null);
		Cell c = gameGrid.getCell(x, y);
		assert(c != null);
		if (_currentItem.canBePlacedOnCell(c, gameGrid)) {
			_currentItem.putOnCell(c);
			return true;
		}
		return false;
	}
	
	public Item getCurrentItem() {
		return _currentItem;
	}
	
}
