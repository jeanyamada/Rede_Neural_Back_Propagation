/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import RedeNeural.*;
import Arquivo.*;
/**
 *
 * @author jeany
 */
public class ControladorRedeNeural {
    
    public static void alocaCamadaEntrada(){
       RedeNeural.redeNeural.alocaCamada(RedeNeural.redeNeural.getCamadaEntrada(),Arquivo.arquivo.quantEntrada(),"E");
    }
    public static void alocaCamadaOculta(int quant){
       RedeNeural.redeNeural.alocaCamada(RedeNeural.redeNeural.getCamadaOculta(),quant,"I");
    }
    public static void alocaCamadaOculta(){
        int quant = (int) Math.round(Math.sqrt(Arquivo.arquivo.quantEntrada()*Arquivo.arquivo.quantClasses()));
        RedeNeural.redeNeural.alocaCamada(RedeNeural.redeNeural.getCamadaOculta(),quant,"I");
    }
    public static void alocaCamadaSaida(){
       RedeNeural.redeNeural.alocaCamada(RedeNeural.redeNeural.getCamadaSaida(),Arquivo.arquivo.quantClasses(),"S");
    }
    public static void conectaRedeNeural(){
        RedeNeural.redeNeural.conectaRedeNeural();
    }    
    public static void inserePesosAleatórios() {
        RedeNeural.redeNeural.inserePesosAleatórios();
    }
    public static RedeNeural getRedeNeural(){
        return RedeNeural.redeNeural;
    }
    
    public static void setRedeNeural(RedeNeural redeNeural){
        RedeNeural.redeNeural = redeNeural;
    }
}
