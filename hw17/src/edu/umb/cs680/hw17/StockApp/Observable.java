package edu.umb.cs680.hw17.StockApp;

import java.util.LinkedList;
import java.util.List;

public abstract class Observable<StockEvent> {
	private LinkedList<Observer<StockEvent>> observers = new LinkedList<>();
	
	public void addObserver(Observer<StockEvent> o) {
		observers.add(o);
	}

	public void clearObservers() {
		observers.clear();
		
	}
	public List<Observer<StockEvent>> getObservers(){
		return observers;
	}
	
	public int countObservers() {
		return observers.size();
		
	}
	public void removeObserver(Observer<StockEvent> o) {
		observers.remove(o);
	}

	public void notifyObservers(StockEvent event) {
		observers.forEach( (observer)->{observer.update(this, event);} );
	}
}
