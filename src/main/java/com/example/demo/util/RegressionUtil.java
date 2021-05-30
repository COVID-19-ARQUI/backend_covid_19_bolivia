package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class RegressionUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegressionUtil.class);

    public RegressionUtil() {
    }

    public List<Double> lineal(List<Double> x, List<Double> y, Integer cant) {
        double b = getb(y, x);
        double a = geta(y, x, b);
        List<Double> predict = new ArrayList<Double>();
        LOGGER.warn(a + "+" + b + "x");

        for (int i = 0; i < cant; i++) {
            double xp = a + (b * (i + x.size()));
            predict.add(xp);
        }
        return predict;

    }

    public List<Double> Exponencial(List<Double> x, List<Double> y, Integer cant) {
        List<Double> ypirma = new ArrayList<Double>();
        for (int i = 0; i < y.size(); i++) {
            double yy = Math.log(y.get(i));
            if (yy > 0) {
                ypirma.add(yy);
            } else {
                ypirma.add(1.0);
            }
        }
        double b = getb(ypirma, x);
        double aprima = geta(ypirma, x, b);
        double a = Math.exp(aprima);
        List<Double> predict = new ArrayList<Double>();

        LOGGER.warn(a + "*e^(" + b + "x)");

        for (int i = 0; i < cant; i++) {
            double xp = a * (Math.exp(b * (i + x.size())));
            predict.add(xp);
        }
        return predict;
    }

    public List<Double> logaritmica(List<Double> x, List<Double> y, Integer cant) {
        List<Double> xprima = new ArrayList<Double>();
        for (int i = 0; i < x.size(); i++) {
            xprima.add(Math.log(x.get(i)));
        }
        double b = getb(y, xprima);
        double aprima = geta(y, xprima, b);
        double a = Math.exp(aprima);

        List<Double> predict = new ArrayList<Double>();
        LOGGER.warn(a + "+" + b + "ln(x)");

        for (int i = 0; i < cant; i++) {
            double xp = a + (b * Math.log((i + x.size())));
            predict.add(xp);
        }
        return predict;
    }

    public List<Double> Hiperbolico(List<Double> x, List<Double> y, Integer cant) {

        List<Double> ypirma = new ArrayList<Double>();
        for (int i = 0; i < y.size(); i++) {
            double yy = 1 / y.get(i);
            if (yy == Double.POSITIVE_INFINITY) {
                ypirma.add(1.0);
            } else {

                ypirma.add(yy);
            }
        }
        LOGGER.warn("y prima" + ypirma);
        double b = getb(ypirma, x);
        double a = geta(ypirma, x, b);
        List<Double> predict = new ArrayList<Double>();
        LOGGER.warn("1/(" + a + " +" + b + "x)");

        for (int i = 0; i < cant; i++) {
            double xp = 1 / (a + (b * ((i + x.size()))));
            predict.add(xp);
        }
        return predict;

    }


    public List<Double> potencial(List<Double> x, List<Double> y, Integer cant) {

        List<Double> ypirma = new ArrayList<Double>();
        List<Double> xpirma = new ArrayList<Double>();
        for (int i = 0; i < y.size(); i++) {
            double yy = Math.log10(y.get(i));
            if (yy > 0) {
                ypirma.add(yy);
            } else {
                ypirma.add(1.0);
            }
        }
        for (int i = 0; i < x.size(); i++) {

            double xx = Math.log10(x.get(i));
            if (xx > 0) {
                xpirma.add(xx);
            } else {
                xpirma.add(1.0);
            }
        }
        LOGGER.warn("y prima" + ypirma);
        LOGGER.warn("x prima" + xpirma);
        double b = getb(ypirma, xpirma);
        double aprima = geta(ypirma, xpirma, b);
        double a = Math.pow(10, aprima);

        List<Double> predict = new ArrayList<Double>();
        LOGGER.warn(a + "x^(" + b + ")");

        for (int i = 0; i < cant; i++) {
            double xp = a * (Math.pow((i + x.size()), b));
            predict.add(xp);
        }
        return predict;

    }

    public double geta(List<Double> y, List<Double> x, Double b) {
        double a = promedio(y) - (b * promedio(x));
        return a;
    }

    public double promedio(List<Double> prom) {
        double prome = 0;
        for (int i = 0; i < prom.size(); i++) {
            prome = prome + prom.get(i);
        }
        return prome / prom.size();
    }

    public double getb(List<Double> y, List<Double> x) {
        double sumxy = sumxy(y, x);
        double sumx = sum(x);
        double sumy = sum(y);
        double sumxx = sumxx(x);
        double sumxcua = Math.pow(sum(x), 2);

        double b = ((y.size() * sumxy) - (sumx * sumy)) / ((y.size() * sumxx - sumxcua));

        return b;
    }

    public double sumxy(List<Double> y, List<Double> x) {
        double sum = 0;

        for (int i = 0; i < y.size(); i++) {
            sum = sum + y.get(i) * x.get(i);
        }
        return sum;
    }

    public double sum(List<Double> sumatoria) {
        double sum = 0;

        for (int i = 0; i < sumatoria.size(); i++) {
            sum = sum + sumatoria.get(i);
        }
        return sum;
    }

    public double sumxx(List<Double> x) {
        double sum = 0;

        for (int i = 0; i < x.size(); i++) {
            sum = sum + x.get(i) * x.get(i);
        }
        return sum;
    }


}
