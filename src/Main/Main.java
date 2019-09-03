/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Arquivo.Arquivo;
import RedeNeural.Camada;
import GUI.Principal;
import RedeNeural.Neuronio;
import RedeNeural.Peso;
import RedeNeural.RedeNeural;
import Treinamento.BackPropagation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeany
 */
public class Main {

    public static Principal principal = new Principal();
    
    public static void main(String[] args) {


        
        
        principal.setVisible(true);
        /*
        RedeNeural redeNeural = new RedeNeural();

        
        redeNeural.getCamadaEntrada().getArrayListNeuronios().add(new Neuronio(0,new ArrayList()));
        redeNeural.getCamadaEntrada().getArrayListNeuronios().add(new Neuronio(1,new ArrayList()));
        
        redeNeural.getCamadaOculta().getArrayListNeuronios().add(new Neuronio(0,new ArrayList()));
        redeNeural.getCamadaOculta().getArrayListNeuronios().add(new Neuronio(0,new ArrayList()));
        redeNeural.getCamadaOculta().getArrayListNeuronios().add(new Neuronio(0,new ArrayList()));
        redeNeural.getCamadaOculta().getArrayListNeuronios().add(new Neuronio(0,new ArrayList()));
        
        redeNeural.getCamadaSaida().getArrayListNeuronios().add(new Neuronio(0,"1",new ArrayList()));
        
        
        redeNeural.getCamadaEntrada().getArrayListNeuronios().get(0).getArrayListPesos().add(new Peso(1.1f,redeNeural.getCamadaOculta().getArrayListNeuronios().get(0)));
        redeNeural.getCamadaEntrada().getArrayListNeuronios().get(0).getArrayListPesos().add(new Peso(3.6f,redeNeural.getCamadaOculta().getArrayListNeuronios().get(1)));
        redeNeural.getCamadaEntrada().getArrayListNeuronios().get(0).getArrayListPesos().add(new Peso(2.1f,redeNeural.getCamadaOculta().getArrayListNeuronios().get(2)));
        redeNeural.getCamadaEntrada().getArrayListNeuronios().get(0).getArrayListPesos().add(new Peso(0.9f,redeNeural.getCamadaOculta().getArrayListNeuronios().get(3)));
    
        redeNeural.getCamadaEntrada().getArrayListNeuronios().get(1).getArrayListPesos().add(new Peso(-1.4f,redeNeural.getCamadaOculta().getArrayListNeuronios().get(0)));
        redeNeural.getCamadaEntrada().getArrayListNeuronios().get(1).getArrayListPesos().add(new Peso(-4.1f,redeNeural.getCamadaOculta().getArrayListNeuronios().get(1)));
        redeNeural.getCamadaEntrada().getArrayListNeuronios().get(1).getArrayListPesos().add(new Peso(2.5f,redeNeural.getCamadaOculta().getArrayListNeuronios().get(2)));
        redeNeural.getCamadaEntrada().getArrayListNeuronios().get(1).getArrayListPesos().add(new Peso(-1.0f,redeNeural.getCamadaOculta().getArrayListNeuronios().get(3)));
    
        redeNeural.getCamadaOculta().getArrayListNeuronios().get(0).getArrayListPesos().add(new Peso(1.2f,redeNeural.getCamadaSaida().getArrayListNeuronios().get(0)));
        redeNeural.getCamadaOculta().getArrayListNeuronios().get(1).getArrayListPesos().add(new Peso(1.6f,redeNeural.getCamadaSaida().getArrayListNeuronios().get(0)));
        redeNeural.getCamadaOculta().getArrayListNeuronios().get(2).getArrayListPesos().add(new Peso(4.3f,redeNeural.getCamadaSaida().getArrayListNeuronios().get(0)));
        redeNeural.getCamadaOculta().getArrayListNeuronios().get(3).getArrayListPesos().add(new Peso(3.2f,redeNeural.getCamadaSaida().getArrayListNeuronios().get(0)));
    
        System.out.println("Camada Entrada");
        printValor(redeNeural.getCamadaEntrada());
        
        System.out.println("Camada Oculta");
        printValor(redeNeural.getCamadaOculta());
        
        System.out.println("Camada Saída");
        printValor(redeNeural.getCamadaSaida());
        
        System.out.println("Peso Camada Entrada");
        printPeso(redeNeural.getCamadaEntrada());
        
        System.out.println("Peso Camada Oculta");
        printPeso(redeNeural.getCamadaOculta());
        
        ArrayList<ArrayList<Double[]>> dados = new ArrayList<>();
        
        ArrayList<Double[]> dados1 = new ArrayList<>();
        
        Double [] vec = new Double[3];
        
        vec[0] = 0.0d;
        vec[1] = 1.0d;
        vec[2] = 0.0d;
        
        dados1.add(vec);
        
        dados.add(dados1);
        

        
        BackPropagation.backPropagation.treinamentoRedeNeural(redeNeural,dados,0.0d,1.0d,0);
        

        System.out.println("Camada Oculta pós NET");
        printValor(redeNeural.getCamadaOculta());
        
        
        
        System.out.println("Camada Oculta Função de Transferência");
        printFuncao(redeNeural.getCamadaOculta());
        
        
        
        System.out.println("Camada Oculta Derivada");
        printDerivada(redeNeural.getCamadaOculta());
        
        
        
        System.out.println("Camada Saída pós NET");
        printValor(redeNeural.getCamadaSaida());
        
        
        System.out.println("Camada Saída Função de Transferência");
        printFuncao(redeNeural.getCamadaSaida());
        

        
        System.out.println("Camada Saída Derivada");
        printDerivada(redeNeural.getCamadaSaida());
        
        
        System.out.println("Camada Saída ERRO");
        printErro(redeNeural.getCamadaSaida());
        
        
        
        System.out.println("Camada Oculta ERRO");
        printErro(redeNeural.getCamadaOculta());
        
        
        
        
        System.out.println("Camada Saída ERRO pós ajuste");
        printPeso(redeNeural.getCamadaOculta());
        

        System.out.println("Camada Oculta ERRO pós ajuste");
        printPeso(redeNeural.getCamadaEntrada());
        
        
        printErroRede(redeNeural);
        
        */
        
        
        

    }

    public static void printValor(Camada camada) {
        camada.getArrayListNeuronios().forEach((x) -> {
            System.out.print(x.getNet() + " ");
        });
        System.out.println();
    }

    public static void printErro(Camada camada) {
        camada.getArrayListNeuronios().forEach((x) -> {
            System.out.print(x.getErro() + " ");
        });
        System.out.println();
    }

    public static void printFuncao(Camada camada) {
        camada.getArrayListNeuronios().forEach((x) -> {
            System.out.print(x.getFuncaoTranferencia() + " ");
        });
        System.out.println();
    }

    public static void printDerivada(Camada camada) {
        camada.getArrayListNeuronios().forEach((x) -> {
            System.out.print(x.getDerivadaFuncaoTransferencia() + " ");
        });
        System.out.println();
    }

    public static void printPeso(Camada camada) {
        camada.getArrayListNeuronios().forEach((x) -> {
            x.getArrayListPesos().forEach((y) -> {
                System.out.print(y.getPeso() + " ");
            });
            System.out.print("| ");
        });
        System.out.println();
    }
    
    public static void printErroRede(RedeNeural redeNeural){
        System.out.println(redeNeural.getErroRede());
    }
    
}
