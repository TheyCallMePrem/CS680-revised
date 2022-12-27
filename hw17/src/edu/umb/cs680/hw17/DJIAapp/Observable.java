package edu.umb.cs680.hw17.DJIAapp;


import java.util.LinkedList;
import java.util.List;

public abstract class Observable<Double> {
	private LinkedList<Observer<Double>> observers = new LinkedList<>();
	
	public void addObserver(Observer<Double> o) {
		observers.add(o);
	}

	public void clearObservers() {
		observers.clear();
		
	}
	public List<Observer<Double>> getObservers(){
		return observers;
	}
	
	public int countObservers() {
		return observers.size();
		
	}
	public void removeObserver(Observer<Double> o) {
		observers.remove(o);
	}

	public void notifyObservers(Double event) {
		observers.forEach( (observer)->{observer.update(this, event);} );
	}
}
// (Observer<Double> o)->{observers.add(o)}; 
