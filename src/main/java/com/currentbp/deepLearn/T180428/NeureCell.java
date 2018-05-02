package com.currentbp.deepLearn.T180428;

/**
 * Created by Administrator on 2018/4/28.
 */
public class NeureCell {
    private double w = 0;
    private double b = 0;
    private double out = 0;
    private int in = 0;

    public void setIn(int in) {
        this.in = in;
    }

    public void setWandB(double w, double b) {
        this.w = w;
        this.b = b;
    }

    public double getW() {
        return w;
    }

    public double getB() {
        return b;
    }

    public double getOut() {
        double z = in * w + b;
        return 1 / (1 + Math.exp(-z));
    }
}
