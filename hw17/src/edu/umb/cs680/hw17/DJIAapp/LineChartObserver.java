package edu.umb.cs680.hw17.DJIAapp;

public class LineChartObserver implements Observer<Double>{

    @Override
    public void update(Observable<Double> sender, Double event) {
        System.out.println("\nLineChartObserver...");
        System.out.println("Sender: " + sender + "Event: " + event);
    }
}
