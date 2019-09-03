/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import RedeNeural.RedeNeural;
import java.util.ArrayList;
import Treinamento.*;

/**
 *
 * @author jeany
 */
public class ControladorBackProp {
    
    public static Integer[][] testeRedeNeural(RedeNeural redeNeural, ArrayList<ArrayList<Double[]>> dados) {
        return BackPropagation.backPropagation.testeRedeNeural(redeNeural, dados);
    }
    
    public static void treinamentoRedeNeural(RedeNeural redeNeural, ArrayList<ArrayList<Double[]>> classes,Double erro,Double aprendizado,int limit) {
        BackPropagation.backPropagation.treinamentoRedeNeural(redeNeural, classes,erro,aprendizado,limit);
    }
    
    public static int getFuncaoTransferencia() {
        return BackPropagation.backPropagation.getFuncaoTransferencia();
    }

    public static void setFuncaoTransferencia(int funcaoTransferencia) {
        BackPropagation.backPropagation.setFuncaoTransferencia(funcaoTransferencia);
    }
}
