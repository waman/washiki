package org.waman.washiki;

import java.util.Random;
import static java.lang.Math.*;

public class RandomOnSphere extends RandomPointGenerator{

    private final RandomGenerator random;

    public RandomOnSphere(){
        this(Math::random);
    }

    public RandomOnSphere(long seed){
        this(new Random(seed)::nextDouble);
    }
     
    public RandomOnSphere(RandomGenerator random){
        this.random = random;
    }

    private double nextPhi(){
        return 2.0 * PI * random.nextDouble();
    }

    @Override
    public RandomGenerator getRandomGenerator() {
        return this.random;
    }

    /**
     * @param x array to which coordinate of a random point on (n-1)-sphere (n >= 2) is set.
     */
    @Override
    public void setRandomPoint(double[] x){
        setRandomPoint(x, x.length);
    }

    private void setRandomPoint(double[] x, int n){
        switch(n){
            case 1:
                throw new IllegalArgumentException("Argument array must have at least 2 length.");
            case 2:
                setRandomPointOnCircumference(x);
                break;
            
            case 3:
                setRandomPointOnSphere2D(x);
                break;
            
            default:
                setRandomPointOnSphereND(x, n);
        }
    }

    private void setRandomPointOnCircumference(double[] x){
        assert x.length == 2;
     
        double phi = nextPhi();
     
        x[0] = sin(phi);
        x[1] = cos(phi);
    }

    private void setRandomPointOnSphere2D(double[] x){
        assert x.length == 3;
     
        double phi = nextPhi();
        double sinTheta = this.random.nextDouble() * 2.0 - 1.0;  // uniform distribution in [-1, 1]
        double cosTheta = sqrt(1 - sinTheta * sinTheta);
     
        x[0] = sinTheta;
        x[1] = cosTheta * sin(phi);
        x[2] = cosTheta * cos(phi);
    }

    private void setRandomPointOnSphereND(double[] x, int n){
        assert n >= 4;
     
        setRandomPoint(x, n - 2);  // generate the uniform distribution on (n-3)-sphere

        double phi = nextPhi();
        double theta = this.random.nextDouble();
        double sinTheta = pow(theta, 1.0/(n-2.0));
        double cosTheta = sqrt(1 - sinTheta * sinTheta);
     
        for(int i = 0; i < n-2; i++)
            x[i] *= sinTheta;
     
        x[n-2] = cosTheta * sin(phi);
        x[n-1] = cosTheta * cos(phi);
    }
}