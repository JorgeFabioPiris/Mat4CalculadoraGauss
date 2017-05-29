/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import visual.Vista;

/**
 *
 * @author Jorge Fabio
 */
public class GaussUtilidades {

    public static void limpiar() {
        Vista.ResultadosMatrices.setText("");
        Vista.txtX00.setText("");
        Vista.txtX21.setText("");
        Vista.txtX22.setText("");
        Vista.txtX23.setText("");
        Vista.txtResult1.setText("");
        Vista.txtResult2.setText("");
        Vista.txtResult3.setText("");
        Vista.txtX01.setText("");
        Vista.txtX02.setText("");
        Vista.txtX03.setText("");
        Vista.txtX10.setText("");
        Vista.txtX11.setText("");
        Vista.txtX12.setText("");
        Vista.txtX13.setText("");
        Vista.txtX20.setText("");
        Vista.txtX00.requestFocus();
    }

    public static void limpiarTextArea() {
        Vista.txtResult1.setText("");
        Vista.txtResult2.setText("");
        Vista.txtResult3.setText("");
        Vista.ResultadosMatrices.setText("");
        Vista.txtX11.requestFocus();
    }

    public static int roundDenominador(double numero) {
        String letra = String.valueOf(numero);
        String total = letra.substring(letra.indexOf(".") + 1);
        int totalInt = (int) Math.pow(10, total.length());
        return totalInt;
    }

    public static String fraccion(Integer num, Integer den) {
        int cont = 1;
        do {
            num = num % cont == 0 ? num / cont : num;
            den = den % cont == 0 ? den / cont : den;
            cont++;
        } while (num % cont == 0 && den % cont == 0);

        return num + "/" + den.toString();
    }

    static int obtener_mcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return obtener_mcd(b, a % b);
        }
    }

    //Metodo que permite pasar de un TextField a otro presionando enter
    public static void moverConEnter(java.awt.event.KeyEvent evt, JComponent source) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            source.requestFocus();
        }
    }

    //Metodo que acciona un boto al presionar enter
    public static void hacerClicConEnter(java.awt.event.KeyEvent evt, JButton buttom) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buttom.doClick();
        }
    }

}
