package com.pli.project.machinelearning;

/**
 * Created by lipeng on 2016/11/26.
 * To predict house price. Seems not correct.
 * https://youtu.be/rnlti7rgns0?list=PLZ9qNFMHZ-A4rycgrgOYma6zxF4BZGGPW#t=05m14s
 */
public class LRHousePrice {

        public static void main(String[] args) {
                gdCalc(x, y);
//                System.out.println(costFunc(5, 2, x, y));
        }

        public static double[] gdCalc(double[][] x, double[] y) {
                int m = x.length, n = 4;        // m: number of training set, n: the number of feature
                double[] theta = {1, -2, -2, -2, -2};
                double alpha = 0.1;
                for (int itr = 0; itr < 1000; itr++) {
                        double[] deri = new double[n + 1];
                        for (int i = 0; i < m; i++) {
                                /*
                                for (int j = 0; j < n + 1; j++) {
                                        deri[j] = (theta[0] + theta[1] * x[i][1] + theta[2] * x[i][2] + theta[3] * x[i][3] + theta[4] * x[i][4]) * x[i][j];
                                }*/
                                deri[0] = theta[0] + theta[1] * x[i][1] + theta[2] * x[i][2] + theta[3] * x[i][3] + theta[4] * x[i][4];
                                deri[1] = (theta[0] + theta[1] * x[i][1] + theta[2] * x[i][2] + theta[3] * x[i][3] + theta[4] * x[i][4]) * x[i][1];
                                deri[2] = (theta[0] + theta[1] * x[i][1] + theta[2] * x[i][2] + theta[3] * x[i][3] + theta[4] * x[i][4]) * x[i][2];
                                deri[3] = (theta[0] + theta[1] * x[i][1] + theta[2] * x[i][2] + theta[3] * x[i][3] + theta[4] * x[i][4]) * x[i][3];
                                deri[4] = (theta[0] + theta[1] * x[i][1] + theta[2] * x[i][2] + theta[3] * x[i][3] + theta[4] * x[i][4]) * x[i][4];
                        }
                        for (int i = 0; i < n + 1; i++) {
                                theta[i] = theta[i] - (alpha * deri[i]) / m;
                        }
                        System.out.println("theta[]: (" + theta[0] + ", " + theta[1] + ", " + theta[2] + ", " + theta[3] + ", " + theta[4] + "), cost: " + costFunc(theta, x, y));
                }
                return new double[]{theta[0], theta[1], theta[2], theta[3], theta[4]};
        }

        public static double costFunc(double[] theta, double[][] x, double[] y) {
                int m = x.length;
                double cost = 0;
                for (int i = 0; i < m; i++) {
                        cost = cost + Math.pow(theta[0] + theta[1] * x[i][1] + theta[2] * x[i][2] + theta[3] * x[i][3] + theta[4] * x[i][4] - y[i], 2);
                }
                cost = cost / m / 2;
                return cost;
        }

        // 100 points, around y = 2x + 5, -10 < x < 10
        static double[][] x = {
                {1,     2.014,   5,      1,      4.5,     4.60},
                {1,     1.416,   3,      2,      4.0,     2.32},
                {1,     1.534,   3,      2,      3.0,     3.15},
                {1,     8.52,    2,      1,      3.6,     1.78},
                {1,     3.000,   4,      1,      3.8,     5.40}
        };

        static double y[] = {460, 232, 315, 178, 540};

}
