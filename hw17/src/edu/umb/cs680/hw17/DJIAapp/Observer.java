package edu.umb.cs680.hw17.DJIAapp;

public interface Observer<T> {
	public void update(Observable<T> sender, T event);
}

