package edu.umb.cs680.hw06.PrintingFramework;


public class PrintJob {
    String job="";
    PrintJob(){
        this.job="CDonstructor of PrintJob invoked";
    }
    public String getJob(){
        return this.job;
    }


    public static void main(String[] args) {
        PrintJob PJ =new PrintJob();
        System.out.println(PJ.getJob());
    }
}