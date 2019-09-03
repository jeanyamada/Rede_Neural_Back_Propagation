/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.*;
import RedeNeural.Neuronio;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jean
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaRede = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuRedeNeural = new javax.swing.JMenu();
        jMenuItemAbrir = new javax.swing.JMenuItem();
        jMenuItemSalvar = new javax.swing.JMenuItem();
        jMenuTreinarRede = new javax.swing.JMenu();
        jMenuItemAbrirTreino = new javax.swing.JMenuItem();
        jMenuTestarRede = new javax.swing.JMenu();
        jMenuItemAbrirTeste = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setResizable(false);

        jTextAreaRede.setEditable(false);
        jTextAreaRede.setColumns(20);
        jTextAreaRede.setRows(5);
        jScrollPane1.setViewportView(jTextAreaRede);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
        );

        jMenuRedeNeural.setText("Rede Neural");

        jMenuItemAbrir.setText("Abrir");
        jMenuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirActionPerformed(evt);
            }
        });
        jMenuRedeNeural.add(jMenuItemAbrir);

        jMenuItemSalvar.setText("Salvar");
        jMenuItemSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalvarActionPerformed(evt);
            }
        });
        jMenuRedeNeural.add(jMenuItemSalvar);

        jMenuBar1.add(jMenuRedeNeural);

        jMenuTreinarRede.setText("Treinar Rede");

        jMenuItemAbrirTreino.setText("Abrir arquivo");
        jMenuItemAbrirTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirTreinoActionPerformed(evt);
            }
        });
        jMenuTreinarRede.add(jMenuItemAbrirTreino);

        jMenuBar1.add(jMenuTreinarRede);

        jMenuTestarRede.setText("Testar Rede");

        jMenuItemAbrirTeste.setText("Abrir Arquivo");
        jMenuItemAbrirTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirTesteActionPerformed(evt);
            }
        });
        jMenuTestarRede.add(jMenuItemAbrirTeste);

        jMenuBar1.add(jMenuTestarRede);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemAbrirTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirTreinoActionPerformed

        try {
            if(Controladores.ControladorArquivo.lerArquivo()){
                
                ControladorArquivo.separaClasses();
                ControladorArquivo.normalizaDados();
                
                new P1(this,true).setVisible(true);
                
                initTextArea();
            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemAbrirTreinoActionPerformed

    private void jMenuItemAbrirTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirTesteActionPerformed
        // TODO add your handling code here:
        
        try {
            // TODO add your handling code here:

            if(ControladorArquivo.lerArquivo()){
            
                ControladorArquivo.separaClasses();

                ControladorArquivo.normalizaDados();
                
                Integer[][]matriz = ControladorBackProp.testeRedeNeural(ControladorRedeNeural.getRedeNeural(),ControladorArquivo.getClasses());
                
                new MT(this, true,matriz).setVisible(true);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jMenuItemAbrirTesteActionPerformed

    private void jMenuItemSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalvarActionPerformed
        // TODO add your handling code here:
        ControladorArquivo.salvarRedeNeural();
    }//GEN-LAST:event_jMenuItemSalvarActionPerformed

    private void jMenuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirActionPerformed
        // TODO add your handling code here:
        if(ControladorArquivo.abrirRedeNeural())
            initTextArea();
    }//GEN-LAST:event_jMenuItemAbrirActionPerformed

    public void initTextArea(){
        
        String text = "Rede Neural";
        
        text+="\n\nFunção de transferência: ";
        
        switch(ControladorBackProp.getFuncaoTransferencia()){
            case 0: text+="Logística"; break;
            case 1: text+="Tangente Hiperbólica"; break;
        }
           

        text += "\n\nCamada Entrada\n\nNeurônios: "; 
        text = ControladorRedeNeural.getRedeNeural().getCamadaEntrada().getArrayListNeuronios().stream().map((x) -> x.getName()+" ").reduce(text, String::concat);
        
        text += "\n\nCamada Oculta\n\nNeurônios: "; 
        text = ControladorRedeNeural.getRedeNeural().getCamadaOculta().getArrayListNeuronios().stream().map((x) -> x.getName()+" ").reduce(text, String::concat);
            
        text += "\n\nCamada Saída\n\nNeurônios: "; 
        text = ControladorRedeNeural.getRedeNeural().getCamadaSaida().getArrayListNeuronios().stream().map((x) -> x.getName()+" ").reduce(text, String::concat);
            
        text+="\n\nPesos camada oculta\n\n";
        for(Neuronio x:ControladorRedeNeural.getRedeNeural().getCamadaEntrada().getArrayListNeuronios())
            text = x.getArrayListPesos().stream().map((y) -> x.getName()+" -- "+Double.toString(y.getPeso())+" --> "+y.getNeuronio().getName()+"\n").reduce(text, String::concat);
        
        text+="\n\nPesos camada saída\n\n";
        for(Neuronio x:ControladorRedeNeural.getRedeNeural().getCamadaOculta().getArrayListNeuronios())
            text = x.getArrayListPesos().stream().map((y) -> x.getName()+" -- "+Double.toString(y.getPeso())+" --> "+y.getNeuronio().getName()+"\n").reduce(text, String::concat);
        
        jTextAreaRede.setText(text);
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAbrir;
    private javax.swing.JMenuItem jMenuItemAbrirTeste;
    private javax.swing.JMenuItem jMenuItemAbrirTreino;
    private javax.swing.JMenuItem jMenuItemSalvar;
    private javax.swing.JMenu jMenuRedeNeural;
    private javax.swing.JMenu jMenuTestarRede;
    private javax.swing.JMenu jMenuTreinarRede;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaRede;
    // End of variables declaration//GEN-END:variables
}