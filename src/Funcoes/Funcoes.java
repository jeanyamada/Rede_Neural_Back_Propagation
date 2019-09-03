/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcoes;

/**
 *
 * @author jean
 */
public class Funcoes {
    
    public static double tangenteHiperbolica(double x) {
        return Math.tanh(x);
    }

    public static double derivadaTangenteHiperbolica(double x) {
        return 1.0d - Math.pow(tangenteHiperbolica(x),2);       
    }

    public static double logistica(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    public static double derivadaLogistica(double x) {
        return logistica(x)*(1.0d - logistica(x));
    }

    public static double linear(double x) {
        return x;
    }

    public static double derivadaLinear(double x) {
        return 1.0d;
    }
}
