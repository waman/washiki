package org.waman.washiki;

abstract class RandomPointGenerator{

    public abstract RandomGenerator getRandomGenerator();

    public abstract void setRandomPoint(double[] x);

    public void setRandomPoint(double[] x, double radius){
        setRandomPoint(x);
        enlarge(x, radius);
    }

    public double[] newRandomPoint(int n){
        double[] x = new double[n];
        setRandomPoint(x);
        return x;
    }

    public double[] newRandomPoint(int n, double radius){
        double[] x = newRandomPoint(n);
        enlarge(x, radius);
        return x;
    }

    protected void enlarge(double[] x, double scale){
        for(int i = 0, n = x.length; i < n; i++){
            x[i] *= scale;
        }
    }
}
