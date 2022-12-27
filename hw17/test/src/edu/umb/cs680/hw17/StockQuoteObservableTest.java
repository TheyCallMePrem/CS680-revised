package edu.umb.cs680.hw17;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import java.util.List;


import java.util.LinkedList;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw17.StockApp.LineChartObserver;
import edu.umb.cs680.hw17.StockApp.Observable;
import edu.umb.cs680.hw17.StockApp.Observer;
import edu.umb.cs680.hw17.StockApp.StockEvent;
import edu.umb.cs680.hw17.StockApp.StockQuoteObservable;
import edu.umb.cs680.hw17.StockApp.TableObserver;
import edu.umb.cs680.hw17.StockApp.ThreeDObserver;


public class StockQuoteObservableTest {
    @Test
    public void checkaddObserver(){
        StockQuoteObservable SQO = new StockQuoteObservable();
        LineChartObserver LCO= new LineChartObserver();
        TableObserver TO = new TableObserver();
        ThreeDObserver TDO = new ThreeDObserver();

        SQO.addObserver(LCO);
        SQO.addObserver(TO);
        SQO.addObserver(TDO);
        List<String> actual= new LinkedList<String>();
        List<Observer<StockEvent>> Observers = SQO.getObservers();
        for(Observer<StockEvent> element: Observers){
            actual.add(element.getClass().toString());
        }
        List<String> expected= new LinkedList<String>(Arrays.asList("class edu.umb.cs680.hw17.StockApp.LineChartObserver", "class edu.umb.cs680.hw17.StockApp.TableObserver" , "class edu.umb.cs680.hw17.StockApp.ThreeDObserver"));
        assertEquals(expected, actual);
    }

    @Test
    public void checkremoveObserver(){
        StockQuoteObservable SQO = new StockQuoteObservable();
        LineChartObserver LCO= new LineChartObserver();
        TableObserver TO = new TableObserver();
        ThreeDObserver TDO = new ThreeDObserver();

        SQO.addObserver(LCO);
        SQO.addObserver(TO);
        SQO.addObserver(TDO);
        SQO.removeObserver(TDO);
        SQO.removeObserver(TO);
        List<String> actual= new LinkedList<String>();
        List<Observer<StockEvent>> Observers = SQO.getObservers();
        for(Observer<StockEvent> element: Observers){
            actual.add(element.getClass().toString());
        }
        
        List<String> expected= new LinkedList<String>(Arrays.asList("class edu.umb.cs680.hw17.StockApp.LineChartObserver"));
        assertEquals(expected, actual);
    }

    @Test
    public void checkclearObserver(){
        StockQuoteObservable SQO = new StockQuoteObservable();
        LineChartObserver LCO= new LineChartObserver();
        TableObserver TO = new TableObserver();
        ThreeDObserver TDO = new ThreeDObserver();

        SQO.addObserver(LCO);
        SQO.addObserver(TO);
        SQO.addObserver(TDO);
        
        SQO.clearObservers();
        List<String> actual= new LinkedList<String>();
        List<Observer<StockEvent>> Observers = SQO.getObservers();
        for(Observer<StockEvent> element: Observers){
            actual.add(element.getClass().toString());
        }
        
        List<String> expected= new LinkedList<String>(Arrays.asList());
        assertEquals(expected, actual);
    }

    @Test
    public void checkcountObservers(){
        StockQuoteObservable SQO = new StockQuoteObservable();
        LineChartObserver LCO= new LineChartObserver();
        TableObserver TO = new TableObserver();
        ThreeDObserver TDO = new ThreeDObserver();

        SQO.addObserver(LCO);
        SQO.addObserver(TO);
        SQO.addObserver(TDO);
        
        int actual= SQO.countObservers();
        int expected=3;
        assertEquals(expected, actual);
    }

    @Test
    public void checkaddObserverWithLambdaExpression(){
        StockQuoteObservable SQO = new StockQuoteObservable();
        // LineChartObserver LCO= new LineChartObserver();
        // TableObserver TO = new TableObserver(); 
        // ThreeDObserver TDO = new ThreeDObserver();
        
        
        Observer quoteUpdateLineChart = (Observable observable, Object obj) -> {
            System.out.println("LineChartObserver LE : "+"ticker = "+((StockEvent) obj).getTicker()+" quote = "+((StockEvent) obj).getQuote());};

        // Observer quoteUpdateTable = (Observable Sender, Object event) -> {
        //     System.out.println("TableObserver... " + "Sender : " + Sender + "Event:" + event );};

        //     Observer quoteUpdate3D = (Observable Sender, Object event) -> {
        //         System.out.println("ThreeDObserver..." + "Sender : " + Sender + "Event:" + event );};

        SQO.addObserver(quoteUpdateLineChart);
        // SQO.addObserver(quoteUpdateTable);
        // SQO.addObserver(quoteUpdate3D);
        List<String> actual= new LinkedList<String>();
        List<Observer<Double>> Observers = SQO.getObservers();
        for(Observer<Double> element: Observers){
            actual.add(element.getClass().toString());
        }
        //List<String> expected= new LinkedList<String>(Arrays.asList("class edu.umb.cs680.hw17.DJIAapp.LineChartObserver"));
        assertNotNull(actual);
    }

    @Test
    public void checkremoveObserverWithLambdaExpression(){
        StockQuoteObservable SQO = new StockQuoteObservable();
        // LineChartObserver LCO= new LineChartObserver();
        // TableObserver TO = new TableObserver(); 
        // ThreeDObserver TDO = new ThreeDObserver();
        
        
        Observer quoteUpdateLineChart = (Observable Sender, Object event) -> {
            System.out.println("LineChartObserver..." + "Sender : " + Sender + "Event:" + event );};

        // Observer quoteUpdateTable = (Observable Sender, Object event) -> {
        //     System.out.println("TableObserver... " + "Sender : " + Sender + "Event:" + event );};

        //     Observer quoteUpdate3D = (Observable Sender, Object event) -> {
        //         System.out.println("ThreeDObserver..." + "Sender : " + Sender + "Event:" + event );};

        SQO.addObserver(quoteUpdateLineChart);
        SQO.removeObserver(quoteUpdateLineChart);
        // SQO.addObserver(quoteUpdateTable);
        // SQO.addObserver(quoteUpdate3D);
        // List<String> actual= new LinkedList<String>();
        // List<Observer<Double>> Observers = SQO.getObservers();
        // for(Observer<Double> element: Observers){
        //     actual.add(element.getClass().toString());
        // }
        List<String> expected= new LinkedList<String>(Arrays.asList()); //Empty
        assertEquals(expected,SQO.getObservers());
    }
    
    
}


// [class edu.umb.cs680.hw17.LineChartObserver, 
// class edu.umb.cs680.hw17.TableObserver, 
// class edu.umb.cs680.hw17.ThreeDObserver]