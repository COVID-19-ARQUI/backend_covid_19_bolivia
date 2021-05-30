package com.example.demo.util;

import java.util.Random;

public class PredictorUtil {

    public double[][] regresionLineal(double[][] y, double[][] x) {
        MatrixUtil matrixUtil = new MatrixUtil();
        double[][] Betai;
        double[][] XXt_1 = matrixUtil.inversa(matrixUtil.multiplicacionMatriz(matrixUtil.transpuestaMatriz(x), x));
        //matriz.mostrarMatriz(XXt_1);
        double[][] XtY = matrixUtil.multiplicacionMatriz(matrixUtil.transpuestaMatriz(x), y);
        //matriz.mostrarMatriz(XtY);
        Betai = matrixUtil.multiplicacionMatriz(XXt_1, XtY);
        return Betai;
    }

    public double[][] varianzaVectorBi(double[][] x, double[][] y) {
        double[][] matrizC = matrizC(x);
        double varianza = varianza(y, x);
        System.out.println("Varianza    " + varianza);
        double[][] varVector = new double[regresionLineal(y, x).length][1];
        for (int i = 0; i < regresionLineal(y, x).length; i++) {

            varVector[i][0] = varianza * matrizC[i][i];
        }
        return varVector;
    }

    public double[][] Yestimado(double[][] alfai, double[][] x) {
        double[][] resultado = new double[x.length][1];
        for (int i = 0; i < x.length; i++) {
            double suma = alfai[0][0];
            // String cadena=suma+" ";
            for (int j = 1; j < alfai.length; j++) {
                suma = suma + alfai[j][0] * x[i][j];
                //  cadena+=" "+suma+" ";
            }
            //System.out.println("numero "+i+": "+cadena+" = " +suma);
            resultado[i][0] = suma;
        }
        return resultado;
    }


    public double[][] Yt(double[][] alfai, double[][] x) {
        double[][] resultado = new double[x.length][1];
        for (int i = 0; i < x.length; i++) {
            double suma = 0;
            for (int j = 0; j < alfai.length; j++) {
                suma = suma + alfai[j][0] * x[i][j];
            }
            resultado[i][0] = suma;
        }
        return resultado;
    }

    public double Promedio(double[][] Y) {

        double promedioYEstimado = 0;
        for (int i = 0; i < Y.length; i++) {
            promedioYEstimado = promedioYEstimado + Y[i][0];
        }
        return (promedioYEstimado / Y.length);
    }

    public double varianza(double[][] Y, double[][] X) {
        double suma = 0;
        double[][] Yestimado = Yestimado(regresionLineal(Y, X), X);
        for (int i = 0; i < Y.length; i++) {
            suma = suma + (Math.pow(Y[i][0] - Yestimado[i][0], 2));
        }
        suma = (suma / (X.length - X[0].length - 1));
        return suma;
    }


    public double[][] matrizC(double[][] x) {
        MatrixUtil matrixUtil = new MatrixUtil();
        return matrixUtil.metodoFadeva(matrixUtil.multiplicacionMatriz(matrixUtil.transpuestaMatriz(x), x));

    }


    public double sumaCuadrados(double[][] yestimado) {
        double resultado = 0;
        double promedioYestimado = Promedio(yestimado);
        for (int i = 0; i < yestimado.length; i++) {
            resultado = resultado + (Math.pow(yestimado[i][0] - promedioYestimado, 2));
        }
        return resultado;
    }

    public double[][] limiteSuperior(double[][] x, double[][] y, double talfa) {
        double[][] matrizC = matrizC(x);
        double desviacionEstandar = Math.sqrt(varianza(y, x));
        double[][] limites = new double[regresionLineal(y, x).length][1];
        for (int i = 0; i < regresionLineal(y, x).length; i++) {
            limites[i][0] = regresionLineal(y, x)[i][0] + (talfa * desviacionEstandar * Math.sqrt(matrizC[i][i]));
        }

        return limites;
    }


    public double[][] limiteInferior(double[][] x, double[][] y, double talfa) {
        double[][] matrizC = matrizC(x);
        double desviacionEstandar = Math.sqrt(varianza(y, x));

        double[][] limites = new double[regresionLineal(y, x).length][1];
        for (int i = 0; i < regresionLineal(y, x).length; i++) {
            limites[i][0] = regresionLineal(y, x)[i][0] - (talfa * desviacionEstandar * Math.sqrt(matrizC[i][i]));
        }
        return limites;
    }


    public double[][] valorTEstimado(double[][] x, double[][] y) {
        double[][] matrizC = matrizC(x);
        double[][] t = new double[regresionLineal(y, x).length][1];
        double desviacionEstandar = Math.sqrt(varianza(y, x));

        for (int i = 0; i < regresionLineal(y, x).length; i++) {
            t[i][0] = (regresionLineal(y, x)[i][0]) / (desviacionEstandar * Math.sqrt(matrizC[i][i]));
        }
        return t;
    }

    public String[][] pruebaSignificanciaIndividual(double[][] x, double[][] y, double talfa) {
        String[][] RechazaH = new String[regresionLineal(y, x).length][1];
        double[][] t = valorTEstimado(x, y);

        for (int i = 0; i < regresionLineal(y, x).length; i++) {
            if (Math.abs(t[i][0]) > talfa) {
                RechazaH[i][0] = "Se rechaza H0";
            } else {
                RechazaH[i][0] = "Se acepta H0";
            }
        }
        return RechazaH;
    }

    public double[][] datosdouble(int[][] datos) {
        double[][] datosdouble = new double[datos.length][1];

        for (int i = 0; i < datos.length; i++) {
            datosdouble[i][0] = (double) datos[i][0];
        }
        return datosdouble;
    }

    public double[][] deltaY(double[][] y) {
        double[][] delta = new double[y.length - 1][1];
        for (int i = 0; i < y.length - 1; i++) {
            delta[i][0] = y[i + 1][0] - y[i][0];
        }
        return delta;
    }

    public double[][] Y_1(double[][] y) {
        double[][] y_1 = new double[y.length - 1][1];
        for (int i = 0; i < y.length - 1; i++) {
            y_1[i][0] = y[i + 1][0];
        }
        return y_1;
    }


    public double[][] auteregrecionN(double[][] y, int n) {
        double[][] y_t_n = new double[y.length - n][n];
        for (int i = 0; i < y_t_n.length; i++) {
            int w = n - 1;
            for (int j = 0; j < n; j++) {
                y_t_n[i][j] = y[i + w][0];
                w--;
            }
        }
        return y_t_n;
    }

    public double[][] autoregresionParcialInge(double[][] y, int n) {
        double[][] y_t_n = new double[y.length - n][n];
        for (int i = 0; i < y_t_n.length; i++) {

            for (int j = 0; j < n; j++) {
                y_t_n[i][j] = y[i + j][0];

            }
        }
        return y_t_n;
    }

    public double[][] autoregresionDesintegradaY(double[][] y, int n) {
        double[][] y_t_n = new double[y.length - n - 1][n];
        for (int i = 0; i < y_t_n.length; i++) {
            int w = n - 1;
            for (int j = 0; j < n; j++) {
                y_t_n[i][j] = y[i + w + 1][0] - y[i + w][0];
                w--;
            }
        }
        return y_t_n;
    }

    public double[][] autoregresiondesintegradaX(double[][] y, int n) {
        double[][] y_t_n = new double[y.length - n][n];
        for (int i = 0; i < y_t_n.length; i++) {
            int w = n - 1;
            for (int j = 0; j < n; j++) {
                y_t_n[i][j] = y[i + w + 1][0] - y[i + w][0];
                w--;
            }
        }
        return y_t_n;
    }

    //
    public double[][] y_n(double[][] y, int n) {
        double[][] y_n = new double[y.length - n][1];
        for (int i = 0; i < y_n.length; i++) {
            y_n[i][0] = y[i + n][0];
        }
        return y_n;
    }


    public double[][] gamai(double[][] x, double[][] y) {
        MatrixUtil matrixUtil = new MatrixUtil();
        double[][] betai = regresionLineal(y, x);
        double[][] xx = {{betai[0][0] - 1, betai[2][0], 0}, {betai[0][0] + betai[2][0], -1, 0}, {betai[0][0], betai[1][0], 1}};
        double[][] yy = {{betai[0][0] * -1}, {betai[1][0] * -1}, {betai[2][0] * -1}};
        return matrixUtil.multiplicacionMatriz(matrixUtil.inversa(xx), yy);
    }


    public double pronostico(double[][] ai, double[][] y, int n) {
        double[][] ultimosTresDatos = new double[n][1];
        for (int i = 0; i < n; i++) {
            ultimosTresDatos[i][0] = y[y.length - i - 1][0];
        }

        double unDatoMas = 0;
        for (int i = 0; i < ultimosTresDatos.length; i++) {
            unDatoMas = unDatoMas + (ai[i][0] * ultimosTresDatos[i][0]);
        }

        return unDatoMas;
    }


    public double[][] pronosticar(double[][] y, int n, int cantidadpronosticos) {
        MatrixUtil matrixUtil = new MatrixUtil();

        double[][] yMasPronostico = new double[y.length + cantidadpronosticos][1];
        double[][] yDesintegrada = deltaY(y);

        double[][] yt = y_n(yDesintegrada, n);
        // System.out.println("Yt");
        //matriz.mostrarMatriz(yt);
        double[][] yt_n = auteregrecionN(yDesintegrada, n);
        //System.out.println("Yt-n");
        // matriz.mostrarMatriz(yt_n);

        double[][] gamai = gamai(yt_n, yt);
        double[][] datosPronosticados = new double[cantidadpronosticos][1];
        for (int i = 0; i < datosPronosticados.length; i++) {
            datosPronosticados[i][0] = pronostico(gamai, yDesintegrada, n) + y[y.length - 1][0];
            yDesintegrada = matrixUtil.agregarUnDatoACola(yDesintegrada, pronostico(gamai, yDesintegrada, n));
            y = matrixUtil.agregarUnDatoACola(y, datosPronosticados[i][0]);
        }

        yMasPronostico = matrixUtil.agregarColaMatriz(y, datosPronosticados);
        return datosPronosticados;
    }


    public double[][] PiEstimado(double[][] x, double[][] y) {
        MatrixUtil matrixUtil = new MatrixUtil();

        return matrixUtil.multiplicacionMatriz(matrixUtil.inversa(matrixUtil.multiplicacionMatriz(matrixUtil.transpuestaMatriz(x), x)), matrixUtil.multiplicacionMatriz(matrixUtil.transpuestaMatriz(x), y));
    }

    public double[][] yy(double[][] y, int num) {
        MatrixUtil matrixUtil = new MatrixUtil();
        double[][] yy = new double[y.length][1];
        for (int i = 0; i < y.length; i++) {
            yy[i][0] = y[i][num - 1];
        }
        return yy;
    }

    public double[][] primeraecuacion(double[][] x, double[][] y) {
        MatrixUtil matrixUtil = new MatrixUtil();
        double[][] primeraEcuacion = new double[x.length][6];
        double[][] yestimados = matrixUtil.multiplicacionMatriz(x, PiEstimado(x, y));
        for (int i = 0; i < x.length; i++) {
            primeraEcuacion[i][0] = 1;
            primeraEcuacion[i][1] = x[i][0];
            primeraEcuacion[i][2] = x[i][2];
            primeraEcuacion[i][3] = x[i][3];
            primeraEcuacion[i][4] = yestimados[i][1];
            primeraEcuacion[i][5] = yestimados[i][2];
        }
        return primeraEcuacion;
    }

    public double[][] terceraecuacion(double[][] x, double[][] y) {
        MatrixUtil matrixUtil = new MatrixUtil();
        double[][] primeraEcuacion = new double[x.length][5];
        double[][] yestimados = matrixUtil.multiplicacionMatriz(x, PiEstimado(x, y));
        for (int i = 0; i < x.length; i++) {
            primeraEcuacion[i][0] = 1;
            primeraEcuacion[i][1] = x[i][4];
            primeraEcuacion[i][2] = x[i][1];
            primeraEcuacion[i][3] = yestimados[i][1];
            primeraEcuacion[i][4] = yestimados[i][0];
        }
        return primeraEcuacion;
    }

    public double[][] segundaecuacion(double[][] x, double[][] y) {
        MatrixUtil matrixUtil = new MatrixUtil();
        double[][] primeraEcuacion = new double[x.length][3];
        double[][] yestimados = matrixUtil.multiplicacionMatriz(x, PiEstimado(x, y));
        for (int i = 0; i < x.length; i++) {
            primeraEcuacion[i][0] = 1;
            primeraEcuacion[i][1] = x[i][4];
            primeraEcuacion[i][2] = yestimados[i][0];
        }
        return primeraEcuacion;
    }

    public double[][] varianzaMatrizY(double[][] x, double[][] y) {
        MatrixUtil matrixUtil = new MatrixUtil();
        double[][] yestimados = matrixUtil.multiplicacionMatriz(x, PiEstimado(x, y));
        double[][] error = new double[y[0].length][1];
        for (int i = 0; i < y[0].length; i++) {
            int suma = 0;
            for (int j = 0; j < y.length; j++) {

                suma += Math.pow(y[j][i] - yestimados[j][i], 2);
            }
            error[i][0] = suma / y.length;
        }
        return error;
    }

    public double[][] mediaMatrizY(double[][] x, double[][] y) {
        MatrixUtil matrixUtil = new MatrixUtil();
        double[][] yestimados = matrixUtil.multiplicacionMatriz(x, PiEstimado(x, y));
        double[][] error = new double[y[0].length][1];
        for (int i = 0; i < y[0].length; i++) {
            double suma = 0;
            for (int j = 0; j < y.length; j++) {

                suma += (y[j][i] - yestimados[j][i]);
            }
            error[i][0] = suma / y.length;
        }
        return error;
    }

    public double[][] errorV(double[][] x, double[][] y) {
        Random random = new Random();
        double[][] error = new double[y[0].length][1];
        for (int i = 0; i < error.length; i++) {
            error[i][0] = random.nextGaussian() * mediaMatrizY(x, y)[i][0] + varianzaMatrizY(x, y)[i][0];
        }
        return error;
    }
//
//    public double[][] matrizYPronostico(double[][] x,double[][] y,int numeroecuacion,int n){
//        double[][] ecuacion=null;
//        double[][] alfaiBetai=null;
//        int numeroDeDatos=0;
//        if (numeroecuacion==1){
//            ecuacion=primeraecuacion(x,y);
//            alfaiBetai=regresionLineal(yy(y,1),primeraecuacion(x,y));
//            numeroDeDatos=ecuacion.length-1;
//        }if (numeroecuacion==2){
//            ecuacion=segundaecuacion(x,y);
//            alfaiBetai=regresionLineal(yy(y,2),segundaecuacion(x,y));
//            numeroDeDatos=ecuacion.length-1;
//        }if (numeroecuacion==3){
//            ecuacion=terceraecuacion(x,y);
//            alfaiBetai=regresionLineal(yy(y,3),terceraecuacion(x,y));
//            numeroDeDatos=ecuacion.length-1;
//
//        }
//
//        double[][] ultimosDatos=new double[ecuacion[0].length-1][1];
//        for (int i = 0; i <ecuacion[0].length-1 ; i++) {
//                ultimosDatos[i][0]=y[y.length-i-1][0];
//        }
//
//        double[][] datosPronosticados=new double[n][1];
//
//        for (int i = 0; i <n ; i++) {
//            datosPronosticados[i][0]=pronostico(alfaiBetai,yDesintegrada,n)+y[y.length-1][0];
//            yDesintegrada= matriz.agregarUnDatoACola(yDesintegrada,pronostico(gamai,yDesintegrada,n));
//            y[][]=matriz.agregarUnDatoACola(y, datosPronosticados[i][0]);
//        }
//        return ultimosDatos;
//    }


    public double[][] pronosticarYi(double[][] y, double[][] x, int cantidadpronosticos, int numeroY) {
        double[][] ecuacion = null;
        double[][] alfaiBetai = null;
        int numeroDeDatos = 0;
        if (numeroY == 1) {
            ecuacion = primeraecuacion(x, y);
            alfaiBetai = regresionLineal(yy(y, 1), primeraecuacion(x, y));
            numeroDeDatos = ecuacion.length - 1;
        }
        if (numeroY == 2) {
            ecuacion = segundaecuacion(x, y);
            alfaiBetai = regresionLineal(yy(y, 2), segundaecuacion(x, y));
            numeroDeDatos = ecuacion.length - 1;
        }
        if (numeroY == 3) {
            ecuacion = terceraecuacion(x, y);
            alfaiBetai = regresionLineal(yy(y, 3), terceraecuacion(x, y));
            numeroDeDatos = ecuacion.length - 1;

        }
        MatrixUtil matrixUtil = new MatrixUtil();
        int n = ecuacion[0].length - 1;
        double[][] yMasPronostico = new double[y.length + cantidadpronosticos][1];
        double[][] yDesintegrada = deltaY(y);

        double[][] gamai = alfaiBetai;
        double[][] datosPronosticados = new double[ecuacion[0].length - 1][1];
        for (int i = 0; i < datosPronosticados.length; i++) {
            datosPronosticados[i][0] = pronostico(gamai, yDesintegrada, n) + y[y.length - 1][0];
            yDesintegrada = matrixUtil.agregarUnDatoACola(yDesintegrada, pronostico(gamai, yDesintegrada, n));
            y = matrixUtil.agregarUnDatoACola(y, datosPronosticados[i][0]);
        }

        yMasPronostico = matrixUtil.agregarColaMatriz(y, datosPronosticados);
        return yMasPronostico;
    }


    public double[][] sacarYi(double[][] Y, int i) {
        double[][] Yfinal = new double[Y.length][1];
        for (int j = 0; j < Y.length; j++) {
            Yfinal[j][0] = Y[j][i - 1];
        }
        return Yfinal;
    }
}
