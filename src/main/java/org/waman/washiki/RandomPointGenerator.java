package org.waman.washiki;

public interface RandomPointGenerator{

    void setRandomPoint(double[] x);

    default double[] newRandomPoint(int n){
        double[] x = new double[n];
        setRandomPoint(x);
        return x;
    }
}
