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
    void setRandomPoint(double[] x){
        setRandomPoint(x, x.length);
    }

    private void setRandomPoint(double[] x, int n){
        switch(n){  // n は(球面の次元 + 1) に注意。　(n-1) 次元球面上の一様分布を生成
            case 2:
                setRandomPointOnCircumference(x);  // 円周上（1次元）上の一様分布
                break;
            
            case 3:
                setRandomPointOnSphere2D(x);  // 普通の球面（2次元）上の一様分布
                break;
            
            default:
                setRandomPointOnSphereND(x, n);  // n >= 4 のとき
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
        double sinTheta = nextDouble() * 2.0 - 1.0;  // 区間 [-1, 1] での一様分布
        double cosTheta = sqrt(1 - sinTheta * sinTheta);
     
        x[0] = sinTheta;
        x[1] = cosTheta * sin(phi);
        x[2] = cosTheta * cos(phi);
    }

    private void setRandomPointOnSphereND(double[] x, int n){
        assert n >= 4;
     
        setRandomPoint(x, n - 2);  // (n-3) 次元球面上の一様分布を生成

        double phi = nextPhi();
        double theta = nextDouble();
        double sinTheta = pow(theta, 1.0/(n-2.0));
        double cosTheta = sqrt(1 - sinTheta * sinTheta);
     
        for(int i = 0; i < n-2; i++)
            x[i] *= sinTheta;
     
        x[n-2] = cosTheta * sin(phi);
        x[n-1] = cosTheta * cos(phi);
    }
}