/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RedeNeural;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jeany
 */
public class Camada implements Serializable{

    private ArrayList<Neuronio> arrayListNeuronios;

    public Camada(ArrayList<Neuronio> arrayListNeuronios) {
        this.arrayListNeuronios = arrayListNeuronios;
    }

    public ArrayList<Neuronio> getArrayListNeuronios() {
        return arrayListNeuronios;
    }

    public void setArrayListNeuronios(ArrayList<Neuronio> arrayListNeuronios) {
        this.arrayListNeuronios = arrayListNeuronios;
    }

}
