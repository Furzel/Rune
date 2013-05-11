package model;

import java.util.ArrayList;

public class Grid {
	
	public static final int GRID_X_MAX = 11;
	public static final int GRID_Y_MAX = 11;
	public Cell[][] _cellGrid;
	
	public Grid() {
		_cellGrid = new Cell[GRID_Y_MAX][GRID_X_MAX];
		for (int i = 0; i < GRID_Y_MAX; i++) {
			for (int j = 0; j < GRID_X_MAX; j++) {
				_cellGrid[i][j] = new Cell(i, j);
			}
		}
	}
	
	public ArrayList<Cell> getCellNeighbors(Cell c) {
		ArrayList<Cell> cellList = new ArrayList<Cell>();
		for (int i = c.y-1; i <= c.y+1; i++) {
			for (int j = c.x-1; j <= c.x+1; j++) {
				// dont send the middle cell
				if (!(i == c.y && j == c.x)) {
					Cell neighbor = getCell(i,j);
					if (neighbor != null) {
						cellList.add(neighbor);
					}
				}
			}
		}
		return cellList;
	}
	
	public Cell getCell(int x, int y) {
		if ( x < GRID_X_MAX && x >= 0 && y < GRID_Y_MAX && y >= 0) {
			return _cellGrid[x][y];
		} else {
			System.out.println("/!\\ getCell returned NULL");
			return null;
		}
	}
	
	public ArrayList<Cell> getCellInLine(Cell start, Cell end) {
		ArrayList<Cell> cellList = new ArrayList<Cell>();
		// No diagonales allowed
		if (start.x == end.x || start.y == end.y) {
			cellList.add(start);
			if (start != end) {
				boolean isHorizontal = start.x == end.x;
				boolean isForward = isHorizontal ? start.y < end.y : start.x < end.x;
				int step = isForward ? 1 : -1;
				int i = isHorizontal ? start.y : start.x;
				do {
					i += step;
					Cell c;
					if (isHorizontal) {
						c = getCell(start.x, i);
					} else {
						c = getCell(i, start.y);
					}
					cellList.add(c);
				} while ( isHorizontal ? _cellGrid[start.x][i] != end : _cellGrid[i][start.y] != end );
			}
		} else {
			return null;
		}
		return cellList;
	}
	
	public ArrayList<Cell> getHorizontalLine(Cell c) {
		return getLine(c, true);
	}
	
	public ArrayList<Cell> getVerticalLine(Cell c) {
		return getLine(c, false);
	}
	
	private ArrayList<Cell> getLine(Cell c, boolean isHorizontal) {
		ArrayList<Cell> cellList = new ArrayList<Cell>();
		Cell pointForward;
		Cell pointBackward;
		if (isHorizontal) {
			pointForward = _cellGrid[c.x][Grid.GRID_Y_MAX-1];
			pointBackward = _cellGrid[c.x][0];
		} else {
			pointForward = _cellGrid[Grid.GRID_X_MAX-1][c.y];
			pointBackward = _cellGrid[0][c.y];
		}
		cellList.addAll(getCellInLine(c, pointForward));
		// Originall cell is included in both add, we need to remove it to avoid duplicate
		if (cellList.contains(c)) {
			cellList.remove(c);
		} else {
			assert(false);
		}
		cellList.addAll(getCellInLine(c, pointBackward));
		return cellList;
	}
}
