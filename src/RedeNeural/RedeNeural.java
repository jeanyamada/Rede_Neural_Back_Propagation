/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RedeNeural;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jeany
 */
public class RedeNeural implements Serializable{
    
    private Camada camadaEntrada, camadaOculta, camadaSaida;
    private double erroRede;
    public static RedeNeural redeNeural = new RedeNeural();
    
    public RedeNeural() {
        camadaEntrada = new Camada(new ArrayList());
        camadaOculta = new Camada(new ArrayList());
        camadaSaida = new Camada(new ArrayList());
    }
    
    public void alocaCamada(Camada camada, int quant, String nameCamada) {
        camada.getArrayListNeuronios().clear();
        for (int i = 0; i < quant; i++) {
            camada.getArrayListNeuronios().add(new Neuronio(0, nameCamada + Integer.toString(i), new ArrayList<>()));
        }
    }
    
    public void conectaRedeNeural() {
        
        redeNeural.getCamadaEntrada().getArrayListNeuronios().stream().forEach((x) -> {
            x.getArrayListPesos().clear();
        });
        
        redeNeural.getCamadaOculta().getArrayListNeuronios().stream().forEach((x) -> {
            x.getArrayListPesos().clear();
        });
        
        redeNeural.getCamadaEntrada().getArrayListNeuronios().stream().forEach((x) -> {
            redeNeural.getCamadaOculta().getArrayListNeuronios().stream().forEach((y) -> {
                x.getArrayListPesos().add(new Peso(0, y));
            });
        });
        
        redeNeural.getCamadaOculta().getArrayListNeuronios().stream().forEach((x) -> {
            redeNeural.getCamadaSaida().getArrayListNeuronios().stream().forEach((y) -> {
                x.getArrayListPesos().add(new Peso(0, y));
            });
        });
    }
    
    public void inserePesosAleatórios() {
        Random random = new Random();
        
        redeNeural.getCamadaEntrada().getArrayListNeuronios().stream().forEach((x) -> {
            x.getArrayListPesos().stream().forEach((y) -> {
                double value = random.nextDouble();
                if (random.nextInt(2) == 1) {
                    value *= -1.0d;
                }
                y.setPeso(value);
            });
        });
        
        redeNeural.getCamadaOculta().getArrayListNeuronios().stream().forEach((x) -> {
            x.getArrayListPesos().stream().forEach((y) -> {
                double value = random.nextDouble();
                if (random.nextInt(2) == 1) {
                    value *= -1.0d;
                }
                y.setPeso(value);
            });
        });
    }
    
    public RedeNeural getRedeNeural() {
        return redeNeural;
    }
    
    public void setRedeNeural(RedeNeural redeNeural) {
        RedeNeural.redeNeural = redeNeural;
    }
    
    public Camada getCamadaEntrada() {
        return camadaEntrada;
    }
    
    public void setCamadaEntrada(Camada camadaEntrada) {
        this.camadaEntrada = camadaEntrada;
    }
    
    public Camada getCamadaOculta() {
        return camadaOculta;
    }
    
    public void setCamadaOculta(Camada camadaOculta) {
        this.camadaOculta = camadaOculta;
    }
    
    public Camada getCamadaSaida() {
        return camadaSaida;
    }
    
    public void setCamadaSaida(Camada camadaSaida) {
        this.camadaSaida = camadaSaida;
    }
    
    public double getErroRede() {
        return erroRede;
    }
    
    public void setErroRede(double erroRede) {
        this.erroRede = erroRede;
    }
    
}
