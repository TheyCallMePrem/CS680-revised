package edu.umb.cs680.hw17.StockApp;

public class ThreeDObserver implements Observer<StockEvent>{

    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        System.out.println("\nThreeDObserver...");
        System.out.println("Sender: " + sender + "Event: " + event);
    }
}
                                   