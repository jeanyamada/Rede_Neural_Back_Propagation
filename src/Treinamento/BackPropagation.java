/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treinamento;

import Funcoes.Funcoes;
import RedeNeural.Camada;
import RedeNeural.Neuronio;
import RedeNeural.Peso;
import RedeNeural.RedeNeural;
import java.util.ArrayList;

/**
 *
 * @author jeany
 */
public class BackPropagation {

    public static BackPropagation backPropagation = new BackPropagation();
    private int funcaoTransferencia;

    public BackPropagation() {
    }

    public Integer[][] testeRedeNeural(RedeNeural redeNeural, ArrayList<ArrayList<Double[]>> dados) {

        Integer[][] matriz = new Integer[dados.size()][dados.size()];

        for (int i = 0; i < dados.size(); i++) {
            for (int j = 0; j < dados.size(); j++) {
                matriz[i][j] = 0;
            }
        }

        for (int x = 0; x < dados.size(); x++) {
            for (Double[] k : dados.get(x)) {

                insereEntradaRedeNeural(redeNeural, k);

                /*calcula NET camada oculta*/
                for (Neuronio y : redeNeural.getCamadaOculta().getArrayListNeuronios()) {
                    netOculta(redeNeural.getCamadaEntrada(), y);
                }

                /*calcula função camada oculta*/
                for (Neuronio y : redeNeural.getCamadaOculta().getArrayListNeuronios()) {
                    switch (getFuncaoTransferencia()) {
                        case 0:
                            y.setFuncaoTranferencia(Funcoes.logistica(y.getNet()));
                            break;
                        case 1:
                            y.setFuncaoTranferencia(Funcoes.tangenteHiperbolica(y.getNet()));
                            break;
                    }
                }

                /*calcula NET da Camada de Saída*/
                for (Neuronio y : redeNeural.getCamadaSaida().getArrayListNeuronios()) {
                    netSaida(redeNeural.getCamadaOculta(), y);
                }

                /*calcula Função de Transferência Camada de Saída*/
                for (Neuronio y : redeNeural.getCamadaSaida().getArrayListNeuronios()) {
                    switch (getFuncaoTransferencia()) {
                        case 0:
                            y.setFuncaoTranferencia(Funcoes.logistica(y.getNet()));
                            break;
                        case 1:
                            y.setFuncaoTranferencia(Funcoes.tangenteHiperbolica(y.getNet()));
                            break;

                    }
                }

//                for (Neuronio n : redeNeural.getCamadaSaida().getArrayListNeuronios()) {
//                    System.out.print(n.getFuncaoTranferencia() + " ");
//                }

                double maior = 0.0d;
                int pos = 0;
                for (int i = 0; i < redeNeural.getCamadaSaida().getArrayListNeuronios().size(); i++) {
                    if (redeNeural.getCamadaSaida().getArrayListNeuronios().get(i).getFuncaoTranferencia() > maior) {
                        maior = redeNeural.getCamadaSaida().getArrayListNeuronios().get(i).getFuncaoTranferencia();
                        pos = i;
                    }
                }

                matriz[pos][x]++;
                //System.out.println(pos);
            }
        }
        return matriz;
    }

    public void treinamentoRedeNeural(RedeNeural redeNeural, ArrayList<ArrayList<Double[]>> classes, Double erro, Double aprendizado, int limit) {
        int quant = Integer.MAX_VALUE;
        int maxIterator = 0;

        for (ArrayList<Double[]> x : classes) {
            if (quant > x.size()) {
                quant = x.size();
            }
        }

        do {
            for (int i = 0; i < quant; i++) {

                for (int j = 0; j < classes.size(); j++) {

                    insereEntradaRedeNeural(redeNeural, classes.get(j).get(i));

                    /*calcula NET camada oculta*/
                    for (Neuronio y : redeNeural.getCamadaOculta().getArrayListNeuronios()) {
                        netOculta(redeNeural.getCamadaEntrada(), y);
                    }

                    /*calcula função camada oculta*/
                    for (Neuronio y : redeNeural.getCamadaOculta().getArrayListNeuronios()) {
                        switch (getFuncaoTransferencia()) {
                            case 0:
                                y.setFuncaoTranferencia(Funcoes.logistica(y.getNet()));
                                break;
                            case 1:
                                y.setFuncaoTranferencia(Funcoes.tangenteHiperbolica(y.getNet()));
                                break;

                        }
                    }

                    /*calcula derivada da função camada oculta*/
                    for (Neuronio y : redeNeural.getCamadaOculta().getArrayListNeuronios()) {;
                        switch (getFuncaoTransferencia()) {
                            case 0:
                                y.setDerivadaFuncaoTransferencia(Funcoes.derivadaLogistica(y.getNet()));
                                break;
                            case 1:
                                y.setDerivadaFuncaoTransferencia(Funcoes.derivadaTangenteHiperbolica(y.getNet()));
                                break;

                        }
                    }

                    /*calcula NET da Camada de Saída*/
                    for (Neuronio y : redeNeural.getCamadaSaida().getArrayListNeuronios()) {
                        netSaida(redeNeural.getCamadaOculta(), y);
                    }

                    /*calcula função camada oculta*/
                    for (Neuronio y : redeNeural.getCamadaSaida().getArrayListNeuronios()) {
                        switch (getFuncaoTransferencia()) {
                            case 0:
                                y.setFuncaoTranferencia(Funcoes.logistica(y.getNet()));
                                break;
                            case 1:
                                y.setFuncaoTranferencia(Funcoes.tangenteHiperbolica(y.getNet()));
                                break;

                        }
                    }

                    /*calcula derivada da função camada saida*/
                    for (Neuronio y : redeNeural.getCamadaSaida().getArrayListNeuronios()) {;
                        switch (getFuncaoTransferencia()) {
                            case 0:
                                y.setDerivadaFuncaoTransferencia(Funcoes.derivadaLogistica(y.getNet()));
                                break;
                            case 1:
                                y.setDerivadaFuncaoTransferencia(Funcoes.derivadaTangenteHiperbolica(y.getNet()));
                                break;

                        }
                    }

                    double[] esperado = new double[redeNeural.getCamadaSaida().getArrayListNeuronios().size()];

                    for (int k = 0; k < esperado.length; k++) {
                        if (getFuncaoTransferencia() == 1) {
                            esperado[k] = -1.0d;
                        } else {
                            esperado[k] = 0.0d;
                        }
                    }

                    esperado[j] = 1.0d;

                    /*calcula erro camada saída*/
                    erroCamadaSaida(esperado, redeNeural.getCamadaSaida());

                    /*calcula erro camada oculta*/
                    erroCamadaOculta(redeNeural.getCamadaOculta());

                    /*ajusta peso camada saída*/
                    ajustaPesoCamadaSaida(redeNeural.getCamadaOculta(), aprendizado);

                    /*ajusta peso camada oculta*/
                    ajustaPesoCamadaOculta(redeNeural.getCamadaEntrada(), aprendizado);
                }
            }

            erroRede(redeNeural.getCamadaSaida(), redeNeural);

            //System.out.println(redeNeural.getErroRede());
            maxIterator++;

        } while (redeNeural.getErroRede() > erro && maxIterator < limit);

        redeNeural.getCamadaEntrada().getArrayListNeuronios().forEach((x) -> {
            x.setNet(0.0d);
        });
        redeNeural.getCamadaOculta().getArrayListNeuronios().forEach((x) -> {
            x.setNet(0.0d);
        });
        redeNeural.getCamadaSaida().getArrayListNeuronios().forEach((x) -> {
            x.setNet(0.0d);
        });

    }

    public void insereEntradaRedeNeural(RedeNeural redeNeural, Double[] entrada) {
        for (int i = 0; i < entrada.length - 1; i++) {
            redeNeural.getCamadaEntrada().getArrayListNeuronios().get(i).setNet(entrada[i]);
        }

    }

    /*passar camada anterior*/
    public static void netOculta(Camada camada, Neuronio neuronio) {
        double net = 0.0d;
        for (Neuronio x : camada.getArrayListNeuronios()) {
            for (Peso y : x.getArrayListPesos()) {
                if (y.getNeuronio().equals(neuronio)) {
                    net += y.getPeso() * x.getNet();
                }
            }
        }
        neuronio.setNet(net);
    }

    public static void netSaida(Camada camada, Neuronio neuronio) {
        double net = 0.0d;
        for (Neuronio x : camada.getArrayListNeuronios()) {
            for (Peso y : x.getArrayListPesos()) {
                if (y.getNeuronio().equals(neuronio)) {
                    net += y.getPeso() * x.getFuncaoTranferencia();
                }
            }
        }
        neuronio.setNet(net);
    }

    /*passar camada de saída*/
    public static void erroCamadaSaida(double[] esperado, Camada camada) {
        for (int i = 0; i < camada.getArrayListNeuronios().size(); i++) {
            camada.getArrayListNeuronios().get(i).setErro((esperado[i] - camada.getArrayListNeuronios().get(i).getFuncaoTranferencia()) * camada.getArrayListNeuronios().get(i).getDerivadaFuncaoTransferencia());
        }
    }

    /*passar camada oculta*/
    public static void erroCamadaOculta(Camada camada) {
        double soma = 0.0d;
        for (Neuronio x : camada.getArrayListNeuronios()) {
            for (Peso y : x.getArrayListPesos()) {
                soma += y.getPeso() * y.getNeuronio().getErro();
            }
            x.setErro(soma * x.getDerivadaFuncaoTransferencia());
            soma = 0.0d;
        }

    }

    /*passar camada oculta*/
    public static void ajustaPesoCamadaSaida(Camada camada, double aprendizado) {
        for (Neuronio x : camada.getArrayListNeuronios()) {
            for (Peso y : x.getArrayListPesos()) {
                y.setPeso(y.getPeso() + (aprendizado * y.getNeuronio().getErro() * x.getFuncaoTranferencia()));
            }
        }
    }

    /*passar camada entrada*/
    public static void ajustaPesoCamadaOculta(Camada camada, double aprendizado) {
        for (Neuronio x : camada.getArrayListNeuronios()) {
            for (Peso y : x.getArrayListPesos()) {
                y.setPeso(y.getPeso() + (aprendizado * y.getNeuronio().getErro() * x.getNet()));
            }
        }
    }

    /*passar camada saida*/
    public static double erroRede(Camada camada, RedeNeural redeNeural) {

        double soma = 0.0d;

        for (Neuronio x : camada.getArrayListNeuronios()) {
            soma += Math.pow(x.getErro(), 2);
        }

        redeNeural.setErroRede(soma * 0.5d);
        return 0.5d * soma;
    }

    public BackPropagation getBackPropagation() {
        return backPropagation;
    }

    public void setBackPropagation(BackPropagation backPropagation) {
        BackPropagation.backPropagation = backPropagation;
    }

    public int getFuncaoTransferencia() {
        return funcaoTransferencia;
    }

    public void setFuncaoTransferencia(int funcaoTransferencia) {
        this.funcaoTransferencia = funcaoTransferencia;
    }

}
