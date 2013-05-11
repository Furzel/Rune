package controller;

import test.TestLauncher;

public class starter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launchTest();
	}
	
	public static void launchTest() {
		TestLauncher launcher = new TestLauncher();
		launcher.runAllTests();
	}

}
