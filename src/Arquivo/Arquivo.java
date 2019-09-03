package Arquivo;

import Controladores.ControladorRedeNeural;
import RedeNeural.RedeNeural;
import javax.swing.JFileChooser;
import com.opencsv.CSVReader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Arquivo {

    private List<String[]> dados;
    private ArrayList<ArrayList<Double[]>> classes;
    public static Arquivo arquivo = new Arquivo();

    public Arquivo() {
    }

    public boolean salvarRedeNeural(){
        
        JFileChooser fopen = new JFileChooser();

        int retorno = fopen.showSaveDialog(null);
        
        if (retorno == JFileChooser.APPROVE_OPTION) {
            ObjectOutputStream objectOut = null;			
            try {
                objectOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fopen.getSelectedFile())));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                objectOut.writeObject(ControladorRedeNeural.getRedeNeural());
            } catch (IOException ex) {
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                objectOut.close();
                return true;
            } catch (IOException ex) {
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean abrirRedeNeural(){
        JFileChooser fopen = new JFileChooser();

        int retorno = fopen.showOpenDialog(null);
        
         if (retorno == JFileChooser.APPROVE_OPTION) {
            ObjectInputStream objectIn = null;
            try {
                objectIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fopen.getSelectedFile())));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ControladorRedeNeural.setRedeNeural((RedeNeural) objectIn.readObject());
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                objectIn.close();
                return true;
            } catch (IOException ex) {
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         return false;
    }
    public boolean lerArquivo() throws FileNotFoundException, IOException {

        JFileChooser fopen = new JFileChooser();

        int retorno = fopen.showOpenDialog(null);

        CSVReader reader = null;

        if (retorno == JFileChooser.APPROVE_OPTION) {
            reader = new CSVReader(new FileReader(fopen.getSelectedFile()), ',', '"', 1);
            setDados(reader.readAll());
            return true;
        }

        return false;
    }

    public boolean separaClasses() {

        ArrayList<ArrayList<Double[]>> dadosClasses = new ArrayList<>();
        ArrayList<Double[]> classeAux = null;

        ArrayList<String> classe = new ArrayList<>();
        int pos = getDados().get(0).length - 1;

        for (int i = 0; i < getDados().size(); i++) {
            if (!classe.contains(getDados().get(i)[pos])) {
                classe.add(getDados().get(i)[pos]);
                classeAux = new ArrayList<>();
                classeAux.add(convert(getDados().get(i)));
                dadosClasses.add(classeAux);
            } else {
                classeAux = dadosClasses.get(Integer.parseInt(getDados().get(i)[pos])-1);
                classeAux.add(convert(getDados().get(i)));
            }
        }

        setClasses(dadosClasses);

        return dadosClasses.size() > 0;

    }

    public Double[] convert(String[] dados) {
        Double[] newDados = new Double[dados.length];

        for (int i = 0; i < dados.length; i++) {
            newDados[i] = Double.parseDouble(dados[i]);
        }
        return newDados;
    }

    public void normalizaDados() {

        double maior = 0.0d;

        for(int i = 0;i < quantEntrada();i++){
            
            for (ArrayList<Double[]> x : classes) {
                
                for(Double[] y:x)
                    if(y[i]> maior)
                        maior = y[i];
            }
            
            for (ArrayList<Double[]> x : classes) {
                
                for(Double[] y:x)
                    y[i] = y[i]/maior;
            }
            
            maior = 0.0d;
        }

    }

    public int quantEntrada() {
        if (getClasses().size() > 0) {
            return getClasses().get(0).get(0).length - 1;
        }
        return 0;
    }

    public int quantClasses() {
        return getClasses().size();
    }

    public List<String[]> getDados() {
        return dados;
    }

    public void setDados(List<String[]> dados) {
        this.dados = dados;
    }

    public ArrayList<ArrayList<Double[]>> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<ArrayList<Double[]>> classes) {
        this.classes = classes;
    }

}
