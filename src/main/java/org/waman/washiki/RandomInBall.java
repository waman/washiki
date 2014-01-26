package org.waman.washiki;

import java.util.Random;

import static java.lang.Math.pow;

public class RandomInBall extends RandomPointGenerator{

    private final RandomOnSphere random;

    public RandomInBall() {
        this(Math::random);
    }

    public RandomInBall(long seed) {
        this(new Random(seed)::nextDouble);
    }

    public RandomInBall(RandomGenerator random) {
        this.random = new RandomOnSphere(random);
    }

    @Override
    public RandomGenerator getRandomGenerator() {
        return this.random.getRandomGenerator();
    }

    @Override
    /**
     * @param x array to which coordinate of a random point in n-ball (n >= 2)
     */
    public void setRandomPoint(double[] x){
        int n = x.length;
        this.random.setRandomPoint(x);
        double r = pow(getRandomGenerator().nextDouble(), 1.0/n);

        for(int i = 0; i < n; i++)
            x[i] *= r;
    }
}
