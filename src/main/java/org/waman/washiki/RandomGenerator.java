package org.waman.washiki;

@FunctionalInterface
public interface RandomGenerator{

    double nextDouble();

    default double nextDouble(double max){
        return max * nextDouble();
    }
}
