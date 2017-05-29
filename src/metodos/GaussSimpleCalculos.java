/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import visual.Vista;

/**
 *
 * @author Jorge Fabio
 */
public class GaussSimpleCalculos {

    //Se declaran las variables para recolectar los datos
    static double x11, x12, x13, x21, x22, x23, x31, x32, x33, r1, r2, r3, x, y, z, multiplicador;

    static String multi;

    //metodo que resuelve por el metodo de Gauss Simple
    public static void calcular() {
        x11 = Double.parseDouble(Vista.txtX00.getText());
        x12 = Double.parseDouble(Vista.txtX01.getText());
        x13 = Double.parseDouble(Vista.txtX02.getText());
        x21 = Double.parseDouble(Vista.txtX10.getText());
        x22 = Double.parseDouble(Vista.txtX11.getText());
        x23 = Double.parseDouble(Vista.txtX12.getText());
        x31 = Double.parseDouble(Vista.txtX20.getText());
        x32 = Double.parseDouble(Vista.txtX21.getText());
        x33 = Double.parseDouble(Vista.txtX22.getText());
        r1 = Double.parseDouble(Vista.txtX03.getText());
        r2 = Double.parseDouble(Vista.txtX13.getText());
        r3 = Double.parseDouble(Vista.txtX23.getText());

        Vista.ResultadosMatrices.append("PASO 1\nSe crea la matriz a partir de las ecuaciones \n");

        double A[][] = {
            {x11, x12, x13, r1},
            {x21, x22, x23, r2},
            {x31, x32, x33, r3},};

        cargarTextArea(A);

        multiplicador = A[1][0] / A[0][0];

        multi = decimalAFraccion(multiplicador);

        Vista.ResultadosMatrices.append("PASO 2\n"
                + "Multiplicador = " + multi + "\n"
                + "Fila 1 se pasa igual\n"
                + "Fila 2 menos el Multiplicador multiplicado x Fila 1 \n"
                + "Fila 3 se pasa igual\n");

        double B[][] = new double[3][4];

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                switch (i) {
                    case 0:
                        B[i][j] = A[i][j];
                        break;
                    case 1:
                        B[i][j] = A[i][j] - multiplicador * A[i - 1][j];
                        break;
                    case 2:
                        B[i][j] = A[i][j];
                        break;
                    default:
                        break;
                }
            }
        }

        cargarTextArea(B);

        multiplicador = B[2][0] / A[0][0];
        multi = decimalAFraccion(multiplicador);

        Vista.ResultadosMatrices.append("PASO 3\n"
                + "Multiplicador = " + multi + "\n"
                + "Fila 3 menos el Multiplicador multiplicado x Fila 1 \n");

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                switch (i) {
                    case 0:
                        A[i][j] = B[i][j];
                        break;
                    case 1:
                        A[i][j] = B[i][j];
                        break;
                    case 2:
                        A[i][j] = B[i][j] - multiplicador * B[i - 2][j];
                        break;
                    default:
                        break;
                }
            }
        }

        cargarTextArea(A);

        multiplicador = A[2][1] / A[1][1];

        multi = decimalAFraccion(multiplicador);

        Vista.ResultadosMatrices.append("PASO 4\n"
                + "Multiplicador = " + multi + "\n"
                + "Fila 3 menos el Multiplicador multiplicado x Fila 1 \n");

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                switch (i) {
                    case 0:
                        B[i][j] = A[i][j];
                        break;
                    case 1:
                        B[i][j] = A[i][j];
                        break;
                    case 2:
                        B[i][j] = A[i][j] - multiplicador * B[i - 1][j];
                        break;
                    default:
                        break;
                }
            }
        }

        cargarTextArea(B);

        //Se aplica la validacion para informar si el sistema tiene o no solucion
        switch (validar(B)) {

            case 1:
                Vista.ResultadosMatrices.append("\tEste es un sistema Incompatible"
                        + "\n\tya que el mismo no posee soluciones posibles"
                        + "\n\tdebido a que dos o mas ecuaciones son paralelas");
                break;
            case 2:
                Vista.ResultadosMatrices.append("\tEste es un sistema Compatible e Indeterminado"
                        + "\n\tya que el mismo posee infinitas soluciones"
                        + "\n\tdebido a que dos o mas ecuaciones estan superpuestas");
                break;
            default:
                Vista.ResultadosMatrices.append("PASO 5\nPasar de matriz a sistema de ecuaciones lineales\n\n");

                String X,
                 Y,
                 Z,
                 R,
                 S,
                 T;
    
                if (B[0][0] == 1) {
                    X = " ";
                } else if (B[0][0] == -1) {
                    X = "-";
                } else if (B[0][0] % 1 == 0) {
                    X = (int) B[0][0] + "";
                } else {
                    X = decimalAFraccion(B[0][0]);
                }

                if (B[0][1] == 1) {
                    Y = " ";
                } else if (B[0][1] == -1) {
                    Y = "-";
                } else if (B[0][1] % 1 == 0) {
                    Y = (int) B[0][1] + "";
                } else {
                    Y = decimalAFraccion(B[0][1]);
                }

                if (B[0][2] == 1) {
                    Z = " ";
                } else if (B[0][2] == -1) {
                    Z = "-";
                } else if (B[0][2] % 1 == 0) {
                    Z = (int) B[0][2] + "";
                } else {
                    Z = decimalAFraccion(B[0][2]);
                }

                if (B[0][3] == 1) {
                    R = " ";
                } else if (B[0][3] == -1) {
                    R = "-";
                } else if (B[0][3] % 1 == 0) {
                    R = (int) B[0][3] + "";
                } else {
                    R = decimalAFraccion(B[0][3]);
                }

                Vista.ResultadosMatrices.append(X + "x + " + Y + "y + " + Z + "z = " + R + "\n");

                if (B[1][1] == 1) {
                    Y = " ";
                } else if (B[1][1] == -1) {
                    Y = "-";
                } else if (B[1][1] % 1 == 0) {
                    Y = (int) B[1][1] + "";
                } else {
                    Y = decimalAFraccion(B[1][1]);
                }
                
                if (B[1][2] == 1) {
                    Z = " ";
                } else if (B[1][2] == -1) {
                    Z = "-";
                } else if (B[1][2] % 1 == 0) {
                    Z = (int) B[1][2] + "";
                } else {
                    Z = decimalAFraccion(B[1][2]);
                }
                
                if (B[1][3] == 1) {
                    R = " ";
                } else if (B[1][3] == -1) {
                    R = "-";
                } else if (B[1][3] % 1 == 0) {
                    R = (int) B[1][3] + "";
                } else {
                    R = decimalAFraccion(B[1][3]);
                }

                Vista.ResultadosMatrices.append("       " + Y + "y + " + Z + "z = " + R + "\n");

                if (B[2][2] == 1) {
                    Z = " ";
                } else if (B[2][2] % 1 == 0) {
                    Z = (int) B[2][2] + "";
                } else {
                    Z = decimalAFraccion(B[2][2]);
                }
                
                if (B[2][3] == 1) {
                    R = " ";
                } else if (B[2][3] % 1 == 0) {
                    R = (int) B[2][3] + "";
                } else {
                    R = decimalAFraccion(B[2][3]);
                }

                Vista.ResultadosMatrices.append("              " + Z + "z = " + R + "\n\n");

                z = (B[2][3] - B[2][0] - B[2][1]) / B[2][2];
                y = (B[1][3] - B[1][0] - B[1][2] * z) / B[1][1];
                x = (B[0][3] - B[0][1] * y - B[0][2] * z) / B[0][0];

                if (x % 1 == 0) {
                    x = (int) x;
                    Vista.txtResult1.setText(x + "");
                } else {

                    Vista.txtResult1.setText(decimalAFraccion(x));
                }
                if (y % 1 == 0) {
                    y = (int) y;
                    Vista.txtResult2.setText(y + "");
                } else {
                    Vista.txtResult2.setText(decimalAFraccion(y));
                }

                if (z % 1 == 0) {
                    z = (int) z;
                    Vista.txtResult3.setText(z + "");
                } else {
                    Vista.txtResult3.setText(decimalAFraccion(z));
                }

                if (B[2][2] == 1) {
                    Z = " ";
                } else if (B[2][2] % 1 == 0) {
                    Z = (int) B[2][2] + "";
                } else {
                    Z = decimalAFraccion(B[2][2]);
                }
                if (B[2][3] == 1) {
                    R = " ";
                } else if (B[2][3] % 1 == 0) {
                    R = (int) B[2][3] + "";
                } else {
                    R = decimalAFraccion(B[2][3]);
                }

                Vista.ResultadosMatrices.append("PASO 6\n"
                        + "Sustitucion regresiva\n"
                        + "De la tercera ecuacion se despeja z\n"
                        + "z = " + R + "  /  " + Z + "\n\n");

                if (B[1][1] == 1) {
                    X = " ";
                } else if (B[1][1] == -1) {
                    X = " / -1";
                } else if (B[1][1] % 1 == 0) {
                    X = " /  " + (int) B[1][1];
                } else {
                    X = " /  " + decimalAFraccion(B[1][1]);
                }

                if (B[1][2] == 1) {
                    Y = " ";
                } else if (B[1][2] == -1) {
                    Y = "-";
                } else if (B[1][2] % 1 == 0) {
                    Y = (int) B[1][2] + "";
                } else {
                    Y = decimalAFraccion(B[1][2]);
                }

                if (z == 1) {
                    Z = " ";
                } else if (z == -1) {
                    Z = "-";
                } else if (z % 1 == 0) {
                    Z = (int) z + "";
                } else {
                    Z = decimalAFraccion(z);
                }

                if (B[1][3] == 1) {
                    R = " ";
                } else if (B[1][3] == -1) {
                    R = "-";
                } else if (B[1][3] % 1 == 0) {
                    R = (int) B[1][3] + "";
                } else {
                    R = decimalAFraccion(B[1][3]);
                }

                Vista.ResultadosMatrices.append("De la segunda ecuacion se despeja y\n"
                        + "y = (" + R + "  -  " + Y + "  x  " + Z + ") " + X + "\n\n");

                if (B[0][1] == 1) {
                    X = " ";
                } else if (B[0][1] == -1) {
                    X = " /  -1";
                } else if (B[0][1] % 1 == 0) {
                    X = " /  " + (int) B[0][1];
                } else {
                    X = " /  " + decimalAFraccion(B[0][1]);
                }
                if (B[0][1] == 1) {
                    Y = " ";
                } else if (B[0][1] % 1 == 0) {
                    Y = (int) B[0][1] + " x ";
                } else {
                    Y = decimalAFraccion(B[0][1]) + " x ";
                }
                if (B[0][2] == 1) {
                    Z = " ";
                } else if (B[0][2] % 1 == 0) {
                    Z = (int) B[0][2] + " x ";
                } else {
                    Z = decimalAFraccion(B[0][2]) + " x ";
                }
                if (B[0][3] == 1) {
                    R = " ";
                } else if (B[0][3] % 1 == 0) {
                    R = (int) B[0][3] + "";
                } else {
                    R = decimalAFraccion(B[0][3]);
                }
                if (y == 1) {
                    S = " ";
                } else if (y % 1 == 0) {
                    S = (int) y + "";
                } else {
                    S = decimalAFraccion(B[0][3]);
                }
                if (z == 1) {
                    T = " ";
                } else if (z % 1 == 0) {
                    T = (int) z + "";
                } else {
                    T = decimalAFraccion(B[0][3]);
                }
                Vista.ResultadosMatrices.append("De la primera ecuacion se despeja x\n"
                        + "x = (" + R + "  -  " + Y + S + "  -  " + Z + T + ") " + X + "\n\n");
                break;
        }
    }

    private static void cargarTextArea(double x[][]) {

        for (double[] x1 : x) {
            Vista.ResultadosMatrices.append("[   ");
            for (int j = 0; j < x1.length; j++) {
                if (j == 3) {
                    Vista.ResultadosMatrices.append("|   ");
                }
                if (x1[j] % 1 == 0) {
                    int n = (int) x1[j];
                    Vista.ResultadosMatrices.append(n + "   ");
                } else {
                    String numero = decimalAFraccion(x1[j]);
                    Vista.ResultadosMatrices.append(numero + "   ");
                }
            }
            Vista.ResultadosMatrices.append("]");
            Vista.ResultadosMatrices.append("\n");
        }
        Vista.ResultadosMatrices.append("\n");
        Vista.ResultadosMatrices.append("\n");
    }

    private static String decimalAFraccion(double x) {

        String retorno;

        double numerador = x;

        int denominador = GaussUtilidades.roundDenominador(numerador);

        int intNumerador = (int) (numerador * denominador);

        denominador = denominador * 1;

        int mcd = GaussUtilidades.obtener_mcd(intNumerador, denominador);

        intNumerador = intNumerador / mcd;

        denominador = denominador / mcd;

        if (numerador < 0) {

            intNumerador = intNumerador * -1;
            denominador = denominador * -1;

            retorno = GaussUtilidades.fraccion(intNumerador, denominador);

        } else {

            retorno = GaussUtilidades.fraccion(intNumerador, denominador);

        }

        return retorno;

    }

    private static int validar(double z[][]) {

        int validar = 0;

        if (z[1][0] + z[1][1] + z[1][2] == 0 && z[1][3] != 0) {
            validar = validar + 1;
        }
        if (z[2][0] + z[2][1] + z[2][2] == 0 && z[2][3] != 0) {
            validar = validar + 1;
        }
        if (z[2][0] + z[2][1] + z[2][2] + z[2][3] == 0) {
            validar = validar + 2;
        }

        return validar;
    }

}
