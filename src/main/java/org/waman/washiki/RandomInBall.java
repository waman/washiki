package org.waman.washiki;

import java.util.Random;

import static java.lang.Math.pow;

public class RandomInBall implements RandomPointGenerator{

    private final RandomGenerator random;
    private final RandomOnSphere randomOnSphere;

    public RandomInBall() {
        this(Math::random);
    }

    public RandomInBall(long seed) {
        this(new Random(seed)::nextDouble);
    }

    public RandomInBall(RandomGenerator random) {
        this(random, new RandomOnSphere(random));
    }

    private RandomInBall(RandomGenerator random, RandomOnSphere randomOnSphere) {
        this.random = random;
        this.randomOnSphere = randomOnSphere;
    }

    @Override
    /**
     * @param x array to which coordinate of a randomOnSphere point in n-ball (n >= 2)
     */
    public void setRandomPoint(double[] x){
        int n = x.length;
        this.randomOnSphere.setRandomPoint(x);
        double r = pow(this.random.nextDouble(), 1.0/n);

        for(int i = 0; i < n; i++)
            x[i] *= r;
    }
}
