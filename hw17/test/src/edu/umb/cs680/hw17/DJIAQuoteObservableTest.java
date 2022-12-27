
package edu.umb.cs680.hw17;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import java.util.List;


import java.util.LinkedList;
import org.junit.jupiter.api.Test;


import edu.umb.cs680.hw17.DJIAapp.*;



public class DJIAQuoteObservableTest {
    @Test
    public void checkaddObserver(){
        DJIAQuoteObservable DQO = new DJIAQuoteObservable();
        LineChartObserver LCO= new LineChartObserver();
        TableObserver TO = new TableObserver();
        ThreeDObserver TDO = new ThreeDObserver();

        DQO.addObserver(LCO);
        DQO.addObserver(TO);
        DQO.addObserver(TDO);
        List<String> actual= new LinkedList<String>();
        List<Observer<Double>> Observers = DQO.getObservers();
        for(Observer<Double> element: Observers){
            actual.add(element.getClass().toString());
        }
        List<String> expected= new LinkedList<String>(Arrays.asList("class edu.umb.cs680.hw17.DJIAapp.LineChartObserver", "class edu.umb.cs680.hw17.DJIAapp.TableObserver" , "class edu.umb.cs680.hw17.DJIAapp.ThreeDObserver"));
        assertEquals(expected, actual);
    }

    @Test
    public void checkremoveObserver(){
        DJIAQuoteObservable DQO = new DJIAQuoteObservable();
        LineChartObserver LCO= new LineChartObserver();
        TableObserver TO = new TableObserver();
        ThreeDObserver TDO = new ThreeDObserver();

        DQO.addObserver(LCO);
        DQO.addObserver(TO);
        DQO.addObserver(TDO);
        DQO.removeObserver(TDO);
        DQO.removeObserver(TO);
        List<String> actual= new LinkedList<String>();
        List<Observer<Double>> Observers = DQO.getObservers();
        for(Observer<Double> element: Observers){
            actual.add(element.getClass().toString());
        }
        
        List<String> expected= new LinkedList<String>(Arrays.asList("class edu.umb.cs680.hw17.DJIAapp.LineChartObserver"));
        assertEquals(expected, actual);
    }

    @Test
    public void checkclearObserver(){
        DJIAQuoteObservable DQO = new DJIAQuoteObservable();
        LineChartObserver LCO= new LineChartObserver();
        TableObserver TO = new TableObserver();
        ThreeDObserver TDO = new ThreeDObserver();

        DQO.addObserver(LCO);
        DQO.addObserver(TO);
        DQO.addObserver(TDO);
        
        DQO.clearObservers();
        List<String> actual= new LinkedList<String>();
        List<Observer<Double>> Observers = DQO.getObservers();
        for(Observer<Double> element: Observers){
            actual.add(element.getClass().toString());
        }
         
        List<String> expected= new LinkedList<String>(Arrays.asList());
        assertEquals(expected, actual);
    }

    @Test
    public void checkcountObservers(){
        DJIAQuoteObservable DQO = new DJIAQuoteObservable();
        LineChartObserver LCO= new LineChartObserver();
        TableObserver TO = new TableObserver();
        ThreeDObserver TDO = new ThreeDObserver();

        DQO.addObserver(LCO);
        DQO.addObserver(TO);
        DQO.addObserver(TDO);
        
        int actual= DQO.countObservers();
        int expected=3;
        assertEquals(expected, actual);
    }
    @Test
    public void checkaddObserverWithLambdaExpression(){
        DJIAQuoteObservable DQO = new DJIAQuoteObservable();
        // LineChartObserver LCO= new LineChartObserver();
        // TableObserver TO = new TableObserver(); 
        // ThreeDObserver TDO = new ThreeDObserver();
        
        
        Observer quoteUpdateLineChart = (Observable Sender, Object event) -> {
            System.out.println("LineChartObserver..." + "Sender : " + Sender + "Event:" + event );};

        // Observer quoteUpdateTable = (Observable Sender, Object event) -> {
        //     System.out.println("TableObserver... " + "Sender : " + Sender + "Event:" + event );};

        //     Observer quoteUpdate3D = (Observable Sender, Object event) -> {
        //         System.out.println("ThreeDObserver..." + "Sender : " + Sender + "Event:" + event );};

        DQO.addObserver(quoteUpdateLineChart);
        // DQO.addObserver(quoteUpdateTable);
        // DQO.addObserver(quoteUpdate3D);
        List<String> actual= new LinkedList<String>();
        List<Observer<Double>> Observers = DQO.getObservers();
        for(Observer<Double> element: Observers){
            actual.add(element.getClass().toString());
        }
        //List<String> expected= new LinkedList<String>(Arrays.asList("class edu.umb.cs680.hw17.DJIAapp.LineChartObserver"));
        assertNotNull(actual);
    }

    @Test
    public void checkremoveObserverWithLambdaExpression(){
        DJIAQuoteObservable DQO = new DJIAQuoteObservable();
        // LineChartObserver LCO= new LineChartObserver();
        // TableObserver TO = new TableObserver(); 
        // ThreeDObserver TDO = new ThreeDObserver();
        
        
        Observer quoteUpdateLineChart = (Observable Sender, Object event) -> {
            System.out.println("LineChartObserver..." + "Sender : " + Sender + "Event:" + event );};

        // Observer quoteUpdateTable = (Observable Sender, Object event) -> {
        //     System.out.println("TableObserver... " + "Sender : " + Sender + "Event:" + event );};

        //     Observer quoteUpdate3D = (Observable Sender, Object event) -> {
        //         System.out.println("ThreeDObserver..." + "Sender : " + Sender + "Event:" + event );};

        DQO.addObserver(quoteUpdateLineChart);
        DQO.removeObserver(quoteUpdateLineChart);
        // DQO.addObserver(quoteUpdateTable);
        // DQO.addObserver(quoteUpdate3D);
        // List<String> actual= new LinkedList<String>();
        // List<Observer<Double>> Observers = DQO.getObservers();
        // for(Observer<Double> element: Observers){
        //     actual.add(element.getClass().toString());
        // }
        List<String> expected= new LinkedList<String>(Arrays.asList()); //Empty
        assertEquals(expected,DQO.getObservers());
    }
    
    
}


// [class edu.umb.cs680.hw17.LineChartObserver, 
// class edu.umb.cs680.hw17.TableObserver, 
// class edu.umb.cs680.hw17.ThreeDObserver]


// Consumer<Integer> consumer = (value) -> System.out.println(value);

// 
