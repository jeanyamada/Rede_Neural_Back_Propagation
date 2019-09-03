/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.FileNotFoundException;
import java.io.IOException;
import Arquivo.*;
import java.util.ArrayList;

/**
 *
 * @author jeany
 */
public class ControladorArquivo {

    public static boolean salvarRedeNeural(){
        return Arquivo.arquivo.salvarRedeNeural();
    }
    
    public static boolean abrirRedeNeural(){
        return Arquivo.arquivo.abrirRedeNeural();
    }
    public static boolean lerArquivo() throws FileNotFoundException, IOException {
        return Arquivo.arquivo.lerArquivo();
    }

    public static boolean separaClasses() {
        return Arquivo.arquivo.separaClasses();
    }

    public static void normalizaDados() {
        Arquivo.arquivo.normalizaDados();
    }

    public static int quantClasses() {
        return Arquivo.arquivo.quantClasses();
    }

    public static int quantEntrada() {
        return Arquivo.arquivo.quantEntrada();
    }
    
    public static ArrayList<ArrayList<Double[]>> getClasses(){
        return Arquivo.arquivo.getClasses();
    }
}
