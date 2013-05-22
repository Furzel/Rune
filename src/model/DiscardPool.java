package model;

import java.util.LinkedList;

public class DiscardPool {
	
	public int discardPoolLimit;
	
	private LinkedList<Item> _poolContent;
	
	public DiscardPool(int discardPoolLimit) {
		_poolContent = new LinkedList<Item>();
		this.discardPoolLimit = discardPoolLimit;
	}
	
	public boolean addToDiscardPool(Item i) {
		if (getPoolContentSize() < discardPoolLimit) {
			_poolContent.add(i);
			return true;
		} else {
			return false;
		}
	}
	
	public int getPoolContentSize() {
		return _poolContent.size();
	}
	
	public Item extractFromPool() {
		if (_poolContent.size() == 0) {
			return null;
		} else {
			return _poolContent.removeFirst();
		}
	}
}
