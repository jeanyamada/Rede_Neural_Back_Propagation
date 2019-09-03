/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RedeNeural;

import java.io.Serializable;

/**
 *
 * @author jeany
 */
public class Peso implements Serializable{

    private double peso;
    private Neuronio neuronio;

    public Peso(double peso, Neuronio neuronio) {
        this.peso = peso;
        this.neuronio = neuronio;
    }

    public Neuronio getNeuronio() {
        return neuronio;
    }

    public void setNeuronio(Neuronio neuronio) {
        this.neuronio = neuronio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

}
