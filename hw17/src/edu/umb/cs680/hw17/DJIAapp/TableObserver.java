package edu.umb.cs680.hw17.DJIAapp;

public class TableObserver  implements Observer<Double>{

    @Override
    public void update(Observable<Double> sender, Double event) {
       
        System.out.println("\nTableObserver...");

        System.out.println("Sender: " + sender + "Event: " + event);
    }
}
