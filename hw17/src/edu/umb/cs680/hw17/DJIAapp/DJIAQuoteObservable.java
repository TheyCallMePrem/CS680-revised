package edu.umb.cs680.hw17.DJIAapp;


public class DJIAQuoteObservable extends Observable{
    double quote;

    public void changeQuote(Double q){
        quote = q;
        notifyObservers(Double.valueOf(this.quote));
    }

    public static void main(String[] args) {
        DJIAQuoteObservable SQO = new DJIAQuoteObservable();

        //creating observers
        LineChartObserver LCO= new LineChartObserver();
        TableObserver TO = new TableObserver();
        ThreeDObserver TDO = new ThreeDObserver();

        SQO.addObserver(LCO);
        SQO.addObserver(TO);
        SQO.addObserver(TDO);

        System.out.println(SQO.getObservers());
        SQO.changeQuote(100.11);
        SQO.changeQuote(10.0);
        SQO.changeQuote(3.1416);
        SQO.changeQuote(1.1);
       
    }
}
