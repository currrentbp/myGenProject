package com.currentbp.deepLearn;

import java.util.Random;

/**
 * Created by Administrator on 2018/4/28.
 */
public class DeepLearn {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NeureCell cell = new NeureCell();
        Random random = new Random();
        //init w and b
        double eta = 3;//learn speed
        cell.setWandB(random.nextDouble(), random.nextDouble());
        cell.setIn(1);
        double a0 = cell.getOut();
        double dw = 0.2 * eta * a0;
        double db = 0.2 * eta * a0;
        cell.setWandB(cell.getW() - dw, cell.getB() - db);
        for (int i = 0; i < 200; i++) {
            cell.setIn(1);
            double ai = cell.getOut();
            dw = 0.2 * eta * ai;
            db = 0.2 * eta * ai;
            cell.setWandB(cell.getW() - dw, cell.getB() - db);
            System.out.println(ai);
        }

    }
}
