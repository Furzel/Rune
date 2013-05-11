package test;

import controller.Game;

public class TestGame extends Test {

	@Override
	public void run() {
		testCreation();
		testPlayCurrentItem();
	}

	public void testCreation() {
		Game game = new Game();
		assert(game != null);
		assert(game.getCurrentItem().isRock());
	}
	
	public void testPlayCurrentItem() {
		Game game = new Game();
		game.playCurrentItem(0, 0);
		assert(game.gameGrid.getCell(0, 0).data.item.isRock());
	}
}
