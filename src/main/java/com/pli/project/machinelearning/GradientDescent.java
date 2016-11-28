package com.pli.project.machinelearning;

/**
 * Created by lipeng on 2016/11/28.
 * Use Gradient Descent to find the extreme point of z^2 = x^2 + y^2, e.g. z = (x^2 + x^2)^(0.5).
 * http://www.allenlipeng47.com/blog/index.php/2016/11/22/example-of-gradient-descent/
 */
public class GradientDescent {

    public static void main (String[] args) throws java.lang.Exception{
        // your code goes here
        System.out.println(Math.pow((26 * 26 + 46 * 46), -0.5));
        double x = 1, y = 5, delta = 1;
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " (x, y): " + x + ", " + y);
            double tmp = Math.pow((x * x + y * y), -0.5);
            double x2 = x - delta * x * tmp;
            double y2 = y - delta * y * tmp;
            x = x2;
            y = y2;
        }
        System.out.println("(x, y): " + x + ", " + y);
    }

}
