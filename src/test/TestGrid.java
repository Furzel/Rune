package test;

import java.util.ArrayList;

import model.Cell;
import model.Grid;

public class TestGrid extends Test {
	
	@Override
	public void run() {
		creationTest();
		getNeighborsTest();
		getCellTest();
		getCellInLineTest();
	}
	
	public void creationTest() {
		Grid g = new Grid();
		assert(g._cellGrid != null);
		assert(g._cellGrid.length == Grid.GRID_X_MAX);
		assert(g._cellGrid[0].length == Grid.GRID_Y_MAX);
	}
	
	public void getNeighborsTest() {
		Grid g = new Grid();
		Cell no = g._cellGrid[0][0];
		Cell n = g._cellGrid[1][0];
		Cell ne = g._cellGrid[2][0];
		Cell e = g._cellGrid[2][1];
		Cell se = g._cellGrid[2][2];
		Cell s = g._cellGrid[1][2];
		Cell so = g._cellGrid[0][2];
		Cell o = g._cellGrid[0][1];
		
		Cell centerCell = g._cellGrid[1][1];
		ArrayList<Cell> cellList = g.getCellNeighbors(centerCell);
		
		assert(cellList != null);
		assert(cellList.contains(no));
		assert(cellList.contains(n));
		assert(cellList.contains(ne));
		assert(cellList.contains(e));
		assert(cellList.contains(se));
		assert(cellList.contains(s));
		assert(cellList.contains(so));
		assert(cellList.contains(o));
		
		for (int i = 0; i < Grid.GRID_X_MAX; i++) {
			for (int j = 0; j < Grid.GRID_Y_MAX; j++) {
				ArrayList<Cell> neighbors = g.getCellNeighbors(g._cellGrid[i][j]);
				assert(neighbors.size() >= 3 && neighbors.size() <= 8);
			}
		}
	}
	
	public void getCellTest() {
		Grid g = new Grid();
		assert(g.getCell(-1, -1) == null);
		assert(g.getCell(Grid.GRID_X_MAX, Grid.GRID_Y_MAX) == null);
		
		for (int i = 0; i < Grid.GRID_X_MAX; i++) {
			for (int j = 0; j < Grid.GRID_Y_MAX; j++) {
				assert(g.getCell(i, j) == g._cellGrid[i][j]);
			}
		}
	}
	
	public void getCellInLineTest() {
		Grid g = new Grid();
		
		assert(g.getCellInLine(g._cellGrid[0][0], g._cellGrid[0][0]).get(0) == g._cellGrid[0][0]);
		assert(g.getCellInLine(g._cellGrid[0][0], g._cellGrid[0][0]).size() == 1);
		
		assert(g.getCellInLine(g._cellGrid[0][0], g._cellGrid[1][1]) == null);
		assert(g.getCellInLine(g._cellGrid[0][0], g._cellGrid[0][1]).size() == 2);

		for (int i = 0; i < Grid.GRID_Y_MAX; i++) {
			assert(g.getCellInLine(g._cellGrid[0][i], g._cellGrid[Grid.GRID_X_MAX-1][i]).size() == Grid.GRID_X_MAX);
			assert(g.getCellInLine(g._cellGrid[i][0], g._cellGrid[i][Grid.GRID_Y_MAX-1]).size() == Grid.GRID_Y_MAX);
		}
		
		ArrayList<Cell> resultList = g.getCellInLine(g._cellGrid[0][0], g._cellGrid[0][2]);
		assert(resultList.size() == 3);
		assert(resultList.contains(g._cellGrid[0][0]));
		assert(resultList.contains(g._cellGrid[0][1]));
		assert(resultList.contains(g._cellGrid[0][2]));
	}
	
	public void getHorizontalAndVerticalLineTest() {
		Grid g = new Grid();
		
		for (int i = 0; i < Grid.GRID_X_MAX; i++) {
			ArrayList<Cell> resultList = g.getHorizontalLine(g._cellGrid[i][0]);
			assert(resultList.size() == Grid.GRID_Y_MAX);
			for (int j = 0; j < Grid.GRID_Y_MAX; j++) {
				assert(resultList.contains(g._cellGrid[i][j]));
			}
		}
		
		for (int i = 0; i < Grid.GRID_Y_MAX; i++) {
			ArrayList<Cell> resultList2 = g.getVerticalLine(g._cellGrid[0][i]);
			assert(resultList2.size() == Grid.GRID_X_MAX);
			for (int j = 0 ; j < Grid.GRID_X_MAX; j++) {
				assert(resultList2.contains(g._cellGrid[j][i]));
			}
		}
	}
}
