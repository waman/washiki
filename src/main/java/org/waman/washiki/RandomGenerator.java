package org.waman.washiki;

@FunctionalInterface
public interface RandomGenerator{

    double nextDouble();

    default double nextDouble(double max){
        return max * nextDouble();
    }

    default double nextDouble(double min, double max){
        return (max - min) * nextDouble() + min;
    }
}
