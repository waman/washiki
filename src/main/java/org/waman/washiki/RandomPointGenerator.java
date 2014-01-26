package org.waman.washiki;

abstract class RandomPointGenerator{

    public abstract RandomGenerator getRandomGenerator();
    public abstract void setRandomPoint(double[] x);

    public double[] newRandomPoint(int n){
        double[] x = new double[n];
        setRandomPoint(x);
        return x;
    }
}
