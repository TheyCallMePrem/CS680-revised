package edu.umb.cs680.hw11;

import java.util.List;

public class Manhattan implements DistanceMetric {

    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        if(p1.size() != p2.size()){
            throw new IllegalArgumentException("The size of p1 and p2 must be the same");
        }
        else{
            double sumOfMod = 0.0;
            for(int i=0; i < p1.size(); i++) {
		    	sumOfMod += Math.abs(p1.get(i)-p2.get(i));
		    }
            return sumOfMod;
        }
    }
    
}
