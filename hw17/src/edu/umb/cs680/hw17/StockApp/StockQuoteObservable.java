package edu.umb.cs680.hw17.StockApp;

import java.util.HashMap;
import java.util.Map;

public class StockQuoteObservable extends Observable{
    Map<String, Double> tq = new HashMap<String, Double>();

    public void changeQuote(String t, Double q){
        tq.put(t, q);
        notifyObservers(new StockEvent(t, q));
    }

    public static void main(String[] args) {
        StockQuoteObservable SQO = new StockQuoteObservable();

        //creating observers
        LineChartObserver LCO= new LineChartObserver();
        TableObserver TO = new TableObserver();
        ThreeDObserver TDO = new ThreeDObserver();

        SQO.addObserver(LCO);
        SQO.addObserver(TO);
        SQO.addObserver(TDO);

        System.out.println(SQO.getObservers());
        SQO.changeQuote("Event1", 100.11);
        SQO.changeQuote("Event2", 10.0);
        SQO.changeQuote("Event4", 3.1416);
        SQO.changeQuote("Event3", 1.1);
       
    }
}
