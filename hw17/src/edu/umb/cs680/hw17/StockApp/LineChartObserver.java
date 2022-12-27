package edu.umb.cs680.hw17.StockApp;


public class LineChartObserver implements Observer<StockEvent>{

    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        System.out.println("\nLineChartObserver...");
        System.out.println("Sender: " + sender + "Event: " + event);
    }
}
