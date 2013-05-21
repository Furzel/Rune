package model;

import java.util.ArrayList;

public class DiscardPool {
	
	public int discardPoolLimit;
	
	private ArrayList<Item> _poolContent;
	
	public DiscardPool(int discardPoolLimit) {
		_poolContent = new ArrayList<Item>();
		this.discardPoolLimit = discardPoolLimit;
	}
	
	public void addToDiscardPool(Item i) {
		
	}
}
