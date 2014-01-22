package org.waman.washiki;

import java.util.Random;
import static java.lang.Math.*;

class PolarRandomGenerator{

    private final Random random;
     
    public PolarRandomGenerator(Random random){
        this.random = random;
    }
 
    private double nextDouble(){
        return this.random.nextDouble();
    }
 
    private double nextPhi(){
        return 2.0 * PI * this.random.nextDouble();
    }
 
    /**
     * @param x (n-1) 次元球面 (n >= 2)上において、
     * 一様分布するランダムな点の n 次元座標をセットする配列
     */
    public void setPointOnSphere(double[] x){
        
    }
}