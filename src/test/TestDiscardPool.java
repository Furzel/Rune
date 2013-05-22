package test;

import model.DiscardPool;
import model.Rock;

public class TestDiscardPool extends Test {

	@Override
	public void run() {
		testCreation();
		testAddToDiscradPool();
		testExtractFromPool();
	}

	public void testCreation() {
		assert(new DiscardPool(42) != null);
	}
	
	public void testAddToDiscradPool() {
		DiscardPool dp = new DiscardPool(2);
		assert(dp.getPoolContentSize() == 0);
		assert(dp.addToDiscardPool(new Rock()));
		assert(dp.getPoolContentSize() == 1);
		assert(dp.addToDiscardPool(new Rock()));
		assert(dp.getPoolContentSize() == 2);
		assert(!dp.addToDiscardPool(new Rock()));
		assert(dp.getPoolContentSize() == 2);
	}
	
	public void testExtractFromPool() {
		DiscardPool dp = new DiscardPool(2);
		assert(dp.extractFromPool() == null);
		Rock r = new Rock();
		dp.addToDiscardPool(r);
		assert(r.equals(dp.extractFromPool()));
		assert(dp.getPoolContentSize() == 0);
		dp.addToDiscardPool(new Rock());
		dp.addToDiscardPool(r);
		assert(!r.equals(dp.extractFromPool()));
		assert(r.equals(dp.extractFromPool()));
	}
}
