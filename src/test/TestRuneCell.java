package test;

import model.RuneCell;

public class TestRuneCell extends Test {
	
	@Override
	public void run() {
		testCreation();
		testGetterAndSetters();
	}
	
	public void testCreation() {
		RuneCell rc = new RuneCell();
		assert(rc.isEmpty());
		assert(rc.getColor() == null);
		assert(rc.getShape() == null);
		assert(!rc.isRock());
		RuneCell rc2 = new RuneCell(RuneCell.Color.BLUE, RuneCell.Shape.SHAPE2);
		assert(!rc2.isEmpty());
		assert(rc2.getColor() == RuneCell.Color.BLUE);
		assert(rc2.getShape() == RuneCell.Shape.SHAPE2);
		assert(!rc2.isRock());
		RuneCell rc3 = new RuneCell(3,4);
		assert(!rc3.isEmpty());
		assert(rc3.getColor() == RuneCell.Color.YELLOW);
		assert(rc3.getShape() == RuneCell.Shape.SHAPE5);
		assert(!rc3.isRock());
	}
	
	public void testGetterAndSetters() {
		RuneCell rc = new RuneCell();
		rc.setRock();
		assert(!rc.isEmpty());
		assert(rc.getColor() == null);
		assert(rc.getShape() == null);
		assert(rc.isRock());
		rc.setRune(RuneCell.Color.BLACK, RuneCell.Shape.SHAPE1);
		assert(!rc.isEmpty());
		assert(rc.getColor() == RuneCell.Color.BLACK);
		assert(rc.getShape() == RuneCell.Shape.SHAPE1);
		assert(!rc.isRock());
		rc.setEmpty();
		assert(rc.isEmpty());
		assert(rc.getColor() == null);
		assert(rc.getShape() == null);
		assert(!rc.isRock());
	}
}
