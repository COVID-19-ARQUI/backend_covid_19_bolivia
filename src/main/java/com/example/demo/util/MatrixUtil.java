package com.example.demo.util;

public class MatrixUtil {

    public MatrixUtil() {
    }

    public void mostrarMatriz(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matriz[i].length; j++) {
                String value = String.format("%10s", matriz[i][j]);
                System.out.print(" " + value + " ");
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public void mostrarMatrizString(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print((matriz[i][j]) + "   ");
            }
            System.out.println();
        }
    }

    public void mostrarMatrizVectorDouble(double[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.println((vector[i]) + "   ");
        }
    }

    public void mostrarMatrizVectorDouble(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.println((vector[i]) + "   ");
        }
    }


    public double[][] transpuestaMatriz(double[][] matriz) {

        double[][] transposedResult = new double[matriz[0].length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                transposedResult[j][i] = matriz[i][j];
            }
        }
        return transposedResult;
    }

    public double[][] multiplicacionMatriz(double[][] matriz1, double[][] matriz2) {
        double[][] multiplicationResultado = new double[matriz1.length][matriz2[0].length];
        if (matriz1[0].length == matriz2.length) {
            for (int i = 0; i < matriz1.length; i++) {
                for (int j = 0; j < matriz2[0].length; j++) {
                    for (int k = 0; k < matriz1[0].length; k++) {
                        multiplicationResultado[i][j] += matriz1[i][k] * matriz2[k][j];
                    }
                }
            }
        } else {
            throw new RuntimeException("No se puede multiplicar las matrices");
        }
        return multiplicationResultado;
    }


    public double determinanteMatriz(double[][] matriz) {
        double determinante = 0;
        double suma1 = 0, suma2 = 0;
        double[][] matriz2 = new double[matriz.length][matriz.length + matriz.length - 1];

        if (matriz.length == matriz[0].length) {
            for (int i = 0; i < matriz2.length; i++) {
                for (int j = 0; j < matriz2[0].length; j++) {
                    if (j >= matriz[0].length) {
                        matriz2[i][j] = matriz[i][j - matriz.length];
                    }
                    if (j < matriz[0].length) {
                        matriz2[i][j] = matriz[i][j];
                    }
                }
            }
            System.out.println("La matriz es cuadrada");
            for (int j = 0; j < matriz2.length; j++) {
                double multiplicacion = 1;
                double multiplicacion2 = 1;
                int contador = 0, ii = 0, jj = j, iii = matriz.length - 1;
                while (contador < matriz2.length) {
                    multiplicacion = multiplicacion * matriz2[ii][jj];
                    multiplicacion2 = multiplicacion2 * matriz2[iii][jj];
                    ii++;
                    iii--;
                    jj++;
                    contador++;
                }
                suma1 = suma1 + multiplicacion;
                suma2 = suma2 + multiplicacion2;
            }

        } else {
            throw new RuntimeException("La matriz no es cuadrada");
        }
        return suma1 - suma2;
    }


    public double[][] metodoFadeva(double[][] matrizA) {

        int iteraciones = 1;
        double[][] inversa;
        double[][] A1 = matrizA;
        double Q1 = Q_sumatrazaMetodoFadeva(A1, iteraciones);
        double[][] B1 = B1(Q1, A1);
        double[][] Bn_1 = new double[matrizA.length][matrizA.length];
        while (!cerosMatriz(B1)) {
            Bn_1 = B1;
            iteraciones++;
            A1 = multiplicacionMatriz(matrizA, B1);
            Q1 = Q_sumatrazaMetodoFadeva(A1, iteraciones);
            B1 = B1(Q1, A1);
//			System.out.println(iteraciones);
//			mostrarMatriz(A1);
//			System.out.println(Q1);
//			mostrarMatriz(B1);
//			System.out.println("Matriz Bn-1 es: ");
//			mostrarMatriz(Bn_1);
        }
        inversa = QxI(1 / Q1, Bn_1);

        return inversa;
    }

    private double[][] B1(double Qn, double[][] An) {
        //double[][] Bn=new double[A.length][A.length];
        double[][] Bn = new double[An.length][An.length];
        Bn = restaMatrices(An, QxI(Qn, matrizIdentidad(An.length)));
        return Bn;
    }

    public double[][] QxI(double Q, double[][] identidad) {
        double[][] QxI = new double[identidad.length][identidad.length];
        for (int i = 0; i < identidad.length; i++) {
            for (int j = 0; j < identidad[0].length; j++) {
                QxI[i][j] = Q * identidad[i][j];
            }
        }
        return QxI;
    }

    private double Q_sumatrazaMetodoFadeva(double[][] An, int den) {
        double Q = 0;
        for (int i = 0; i < An.length; i++) {
            for (int j = 0; j < An.length; j++) {
                if (i == j) {
                    Q = Q + An[i][i];
                }
            }
        }

        return Q / den;
    }

    private double[][] matrizIdentidad(int tamaño) {
        double[][] identidad = new double[tamaño][tamaño];
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (i == j) {
                    identidad[i][j] = 1;
                } else {
                    identidad[i][j] = 0;
                }
            }
        }

        return identidad;
    }

    public boolean cerosMatriz(double[][] matriz) {
        boolean ceros = true;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != 0) {
                    ceros = false;
                }
            }
        }
        return ceros;
    }

    public double[][] restaMatrices(double[][] matriz, double[][] matriz2) {
        double[][] resultado = new double[matriz.length][matriz[0].length];
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[0].length; j++) {
                resultado[i][j] = matriz[i][j] - matriz2[i][j];
            }
        }
        return resultado;
    }


    public double[][] inversa(double a[][]) {
        //Cantidad de filas y columnas: Matriz cuadrada
        int n = a.length;


        double x[][] = new double[n][n];
        double identidad[][] = new double[n][n];

        int index[] = new int[n];

        //Matriz identidad
        for (int i = 0; i < n; ++i) {
            identidad[i][i] = 1;
        }

        // Transforma la matriz en un triángulo superior.

        gaussian(a, index);

        // Actualice la matriz b [i] [j] con las relaciones almacenadas
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    identidad[index[j]][k] -= a[index[j]][i] * identidad[index[i]][k];
                }
            }
        }


        // Realizar sustituciones hacia atrás.
        for (int i = 0; i < n; ++i) {
            x[n - 1][i] = identidad[index[n - 1]][i] / a[index[n - 1]][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                x[j][i] = identidad[index[j]][i];
                for (int k = j + 1; k < n; ++k) {
                    x[j][i] -= a[index[j]][k] * x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }


    public void gaussian(double a[][], int index[]) {

        int n = index.length;
        double c[] = new double[n];


        // Inicializar el índice
        for (int i = 0; i < n; i++) {
            index[i] = i;

        }

        // Encuentra los factores de reescalamiento, uno de cada fila
        for (int i = 0; i < n; i++) {
            double c1 = 0;
            for (int j = 0; j < n; j++) {

                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) {
                    c1 = c0;
                }
            }
            c[i] = c1;
        }

        // Busca el elemento pivotante de cada columna.
        int k = 0;
        for (int j = 0; j < n - 1; j++) {

            double pi1 = 0;
            for (int i = j; i < n; i++) {

                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Intercambiar filas según el orden de giro.
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < n; i++) {

                double pj = a[index[i]][j] / a[index[j]][j];

                // Registrar las relaciones de giro por debajo de la diagonal
                a[index[i]][j] = pj;

                // Modificar otros elementos en consecuencia.
                for (int l = j + 1; l < n; l++) {
                    a[index[i]][l] -= pj * a[index[j]][l];

                }
            }
        }
    }


    public double[][] agregarUnDatoACola(double[][] matrizInicial, double datoAgregar) {
        double[][] datosfinales = new double[matrizInicial.length + 1][1];
        for (int i = 0; i < datosfinales.length; i++) {
            if (i < matrizInicial.length) {
                datosfinales[i][0] = matrizInicial[i][0];
            }
            if (i == matrizInicial.length) {
                datosfinales[i][0] = datoAgregar;
            }
        }
        return datosfinales;
    }

    public double[][] agregarColaMatriz(double[][] matrizInicial, double[][] matrizAagregar) {
        double[][] datosfinales = new double[matrizInicial.length + matrizAagregar.length][1];
        for (int i = 0; i < datosfinales.length; i++) {
            if (i < matrizInicial.length) {
                datosfinales[i][0] = matrizInicial[i][0];
            }
            if (i >= matrizInicial.length) {
                datosfinales[i][0] = matrizAagregar[i - matrizInicial.length][0];
            }
        }
        return datosfinales;
    }


}