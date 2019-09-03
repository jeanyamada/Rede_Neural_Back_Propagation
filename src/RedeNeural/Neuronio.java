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
public class Neuronio implements Serializable{

    private double net;
    private double erro;
    private double funcaoTranferencia;
    private double derivadaFuncaoTransferencia;
    private ArrayList<Peso> arrayListPesos;
    private String name;
    
    public Neuronio(double net,String name, ArrayList<Peso> arrayListPesos) {
        this.net = net;
        this.arrayListPesos = arrayListPesos;
        this.name = name;
    }  
    

    public double getFuncaoTranferencia() {
        return funcaoTranferencia;
    }

    public void setFuncaoTranferencia(double funcaoTranferencia) {
        this.funcaoTranferencia = funcaoTranferencia;
    }

    public double getDerivadaFuncaoTransferencia() {
        return derivadaFuncaoTransferencia;
    }

    public void setDerivadaFuncaoTransferencia(double derivadaFuncaoTransferencia) {
        this.derivadaFuncaoTransferencia = derivadaFuncaoTransferencia;
    }

    public ArrayList<Peso> getArrayListPesos() {
        return arrayListPesos;
    }

    public void setArrayListPesos(ArrayList<Peso> arrayListPesos) {
        this.arrayListPesos = arrayListPesos;
    }

    public double getNet() {
        return net;
    }

    public void setNet(double valor) {
        this.net = valor;
    }

    public double getErro() {
        return erro;
    }

    public void setErro(double erro) {
        this.erro = erro;
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
