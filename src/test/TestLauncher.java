package test;

import java.util.ArrayList;

public class TestLauncher {
	
	public void runAllTests() {
		ArrayList<Test> testList = new ArrayList<Test>();
		// ADD TEST HERE
		testList.add(new TestCell());
		testList.add(new TestGrid());
		testList.add(new TestRuneCell());
		testList.add(new TestRuneGenerator());
		// RUN THE TEST
		int i = 0;
		for (Test t : testList) {
			System.out.println("Starting test n° " + i);
			t.run();
			System.out.println("test n° " + i + " completed");
			i++;
		}
		System.out.println("All test completed !");
	}
}
