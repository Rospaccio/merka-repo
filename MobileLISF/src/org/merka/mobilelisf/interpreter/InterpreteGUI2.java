package org.merka.mobilelisf.interpreter;
import javax.swing.*;

import org.merka.mobilelisf.interpreter.ast.*;
import org.merka.mobilelisf.interpreter.visitor.*;

import java.util.Hashtable;
import java.awt.*;
/*
 * prova1.java
 *
 * Created on 18 maggio 2004, 17.07
 */

/**
 *
 * @author  Administrator
 */
public class InterpreteGUI2 extends javax.swing.JFrame {
    
    
    Parser parser = null;
    JTree treeGUI = null;
    EvalVisitor exe = new EvalVisitor();  //non lo chiamo "interprete" perch� � il nome del package
    
    
    /** Creates new form prova1 */
    public InterpreteGUI2() 
    {
        initComponents();
        this.setResizable(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        impostazioniDisegnoDialog = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        xMaxLabel = new javax.swing.JLabel();
        xMaxTextField = new javax.swing.JTextField();
        spazioLabel1 = new javax.swing.JLabel();
        nPuntiLabel = new javax.swing.JLabel();
        nPuntiTextField = new javax.swing.JTextField();
        OKButton = new javax.swing.JButton();
        IOPanel = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        executeButton = new javax.swing.JButton();
        clearOutputTextAreaButton = new javax.swing.JButton();
        clearInputTextAreaButton = new javax.swing.JButton();
        ASTCompletoButton = new javax.swing.JButton();
        impostazioniButton = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        textPanel = new javax.swing.JPanel();
        inputPanel = new javax.swing.JPanel();
        inputLabel = new javax.swing.JLabel();
        inputScrollPane = new javax.swing.JScrollPane();
        inputTextArea = new javax.swing.JTextArea();
        outputPanel = new javax.swing.JPanel();
        outputLabel = new javax.swing.JLabel();
        outputScrollPane = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        treePanel = new javax.swing.JPanel();
        treeLabel = new javax.swing.JLabel();
        treeScrollPane = new javax.swing.JScrollPane();
        drawPanel = new javax.swing.JPanel();
        innerDrawPanel = new javax.swing.JPanel();
        drawLabel = new javax.swing.JLabel();

        impostazioniDisegnoDialog.setTitle("Impostazioni di Disegno");
        impostazioniDisegnoDialog.setFont(new java.awt.Font("Comic Sans MS", 0, 14));
        impostazioniDisegnoDialog.setModal(true);
        impostazioniDisegnoDialog.setName("Impostazioni di Disegno");
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 300));
        xMaxLabel.setText("X MAX = ");
        jPanel1.add(xMaxLabel);

        xMaxTextField.setPreferredSize(new java.awt.Dimension(70, 16));
        jPanel1.add(xMaxTextField);

        spazioLabel1.setPreferredSize(new java.awt.Dimension(10, 16));
        jPanel1.add(spazioLabel1);

        nPuntiLabel.setText("N\u00b0 punti da calcolare = ");
        jPanel1.add(nPuntiLabel);

        nPuntiTextField.setMinimumSize(new java.awt.Dimension(80, 16));
        nPuntiTextField.setPreferredSize(new java.awt.Dimension(70, 16));
        jPanel1.add(nPuntiTextField);

        impostazioniDisegnoDialog.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        impostazioniDisegnoDialog.getContentPane().add(OKButton, java.awt.BorderLayout.SOUTH);

        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        IOPanel.setLayout(new java.awt.BorderLayout());

        buttonPanel.setPreferredSize(new java.awt.Dimension(438, 72));
        executeButton.setMnemonic('e');
        executeButton.setActionCommand("Execute!");
        executeButton.setLabel("Execute!");
        executeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeButtonActionPerformed(evt);
            }
        });

        buttonPanel.add(executeButton);

        clearOutputTextAreaButton.setMnemonic('p');
        clearOutputTextAreaButton.setText("Pulisci Output");
        clearOutputTextAreaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearOutputTextAreaButtonActionPerformed(evt);
            }
        });

        buttonPanel.add(clearOutputTextAreaButton);

        clearInputTextAreaButton.setMnemonic('u');
        clearInputTextAreaButton.setText("Pulisci Input");
        clearInputTextAreaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearInputTextAreaButtonActionPerformed(evt);
            }
        });

        buttonPanel.add(clearInputTextAreaButton);

        ASTCompletoButton.setText("AST Completo");
        ASTCompletoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASTCompletoButtonActionPerformed(evt);
            }
        });

        buttonPanel.add(ASTCompletoButton);

        impostazioniButton.setText("Impostazioni Disegno");
        impostazioniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                impostazioniButtonActionPerformed(evt);
            }
        });

        buttonPanel.add(impostazioniButton);

        IOPanel.add(buttonPanel, java.awt.BorderLayout.SOUTH);

        textPanel.setLayout(new javax.swing.BoxLayout(textPanel, javax.swing.BoxLayout.Y_AXIS));

        textPanel.setPreferredSize(new java.awt.Dimension(300, 300));
        inputPanel.setLayout(new java.awt.BorderLayout());

        inputLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inputLabel.setText("Finestra Input");
        inputPanel.add(inputLabel, java.awt.BorderLayout.NORTH);

        inputTextArea.setFont(new java.awt.Font("Comic Sans MS", 0, 16));
        inputScrollPane.setViewportView(inputTextArea);

        inputPanel.add(inputScrollPane, java.awt.BorderLayout.CENTER);

        textPanel.add(inputPanel);

        outputPanel.setLayout(new java.awt.BorderLayout());

        outputLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        outputLabel.setText("Finestra Output");
        outputPanel.add(outputLabel, java.awt.BorderLayout.NORTH);

        outputTextArea.setEditable(false);
        outputTextArea.setFont(new java.awt.Font("Comic Sans MS", 0, 16));
        outputScrollPane.setViewportView(outputTextArea);

        outputPanel.add(outputScrollPane, java.awt.BorderLayout.CENTER);

        textPanel.add(outputPanel);

        jSplitPane1.setLeftComponent(textPanel);

        treePanel.setLayout(new java.awt.BorderLayout());

        treeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        treeLabel.setText("Abstract Tree");
        treePanel.add(treeLabel, java.awt.BorderLayout.NORTH);

        treePanel.add(treeScrollPane, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(treePanel);

        IOPanel.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(IOPanel);

        drawPanel.setLayout(new java.awt.BorderLayout());

        innerDrawPanel.setBackground(new java.awt.Color(153, 204, 255));
        innerDrawPanel.setPreferredSize(new java.awt.Dimension(500, 500));
        drawPanel.add(innerDrawPanel, java.awt.BorderLayout.CENTER);

        drawLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        drawLabel.setText("Grafico");
        drawPanel.add(drawLabel, java.awt.BorderLayout.NORTH);

        getContentPane().add(drawPanel);

        pack();
    }//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        /*nPunti e xMax vengono inizializzate con il loro valore attuale, cos� in caso di 
         eccezione  viene assegnato di nuovo il vecchio valore.
         Comunque questa soluzione � da considerare provvisoria*/
        int nPunti = exe.getNPunti();
        int xMax = exe.getXMax(); 
        try{
            nPunti=Integer.parseInt(this.nPuntiTextField.getText());
            xMax=Integer.parseInt(this.xMaxTextField.getText());
        }
        catch(Exception e)
        {
            /*Come gestire le eccezioni?*/
        }
        this.impostazioniDisegnoDialog.hide();
        this.exe.setNPunti(nPunti);
        this.exe.setXMax(xMax);
    }//GEN-LAST:event_OKButtonActionPerformed

    private void impostazioniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_impostazioniButtonActionPerformed
        this.nPuntiTextField.setText(""+exe.getNPunti());
        this.xMaxTextField.setText(""+exe.getXMax());
        this.impostazioniDisegnoDialog.setSize(400,100);
        this.impostazioniDisegnoDialog.setResizable(false);
        this.impostazioniDisegnoDialog.show();
    }//GEN-LAST:event_impostazioniButtonActionPerformed

    private void ASTCompletoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASTCompletoButtonActionPerformed
        // Add your handling code here:
        SimpleNode AST = exe.getProgramma();
        this.treeGUI = new JTree(AST);
        this.treeScrollPane.setViewportView(treeGUI);
    }//GEN-LAST:event_ASTCompletoButtonActionPerformed

    private void clearInputTextAreaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearInputTextAreaButtonActionPerformed
        // Add your handling code here:
        this.inputTextArea.setText("");
    }//GEN-LAST:event_clearInputTextAreaButtonActionPerformed

    private void clearOutputTextAreaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearOutputTextAreaButtonActionPerformed
        // Add your handling code here:
        this.outputTextArea.setText("");
        this.innerDrawPanel.getGraphics().clearRect(0, 0, 500, 500);
        this.innerDrawPanel.setBackground(new java.awt.Color(153, 204, 255));
        this.innerDrawPanel.repaint();
    }//GEN-LAST:event_clearOutputTextAreaButtonActionPerformed

    private void executeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeButtonActionPerformed

        ASTProgramma programma = null;
        //memorizza in una stringa il programma immesso in console
        String programmaString = this.inputTextArea.getText();
        //se un parser � gi� stato creato lo reinizzializza, altrimenti lo crea
        if (parser == null)
            parser = new Parser(new java.io.StringReader(programmaString));
        else
            parser.ReInit(new java.io.StringReader(programmaString));
        //crea l'oggetto Programma che incapsula l'AST del programma immesso
        try{
            programma = parser.Programma();
        }
        catch (Exception ex)
        {
            this.outputTextArea.setText(outputTextArea.getText()+"\n----+++----\nEccezione!!"+ex+"\n----+++----");
            return;
        }
        
        this.exe.setProgramma(programma);
        try
        {
            this.exe.execute();    
        }
        catch(Exception ex) //Pendente: questa gestione delle eccezioni � provvisoria
        {
            this.outputTextArea.setText(outputTextArea.getText()+"\n----+++----\nEccezione!!"+ex+"\n----+++----");
            return;
        }
       
        //Aggiorna tutte le finestre di output con i valori attualmente forniti dal visitor:            
        this.outputTextArea.setText(exe.getOutput());
        SimpleNode tree = (SimpleNode)exe.getTreeOutput();
        this.treeGUI = new JTree(tree);
        this.treeScrollPane.setViewportView(treeGUI);
        this.drawGraphic();
        
    }//GEN-LAST:event_executeButtonActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new InterpreteGUI2().show();
    }
    
    public void drawGraphic()
    {
        Graphics g = innerDrawPanel.getGraphics();
        g.translate(250, 250);
        g.setPaintMode();
        //Arrotonda i valori dei punti
        int nPunti = exe.getNPunti();
        double[] x = new double[nPunti];
        double[] y = new double[nPunti];
        //Recupera i valori dei punti da disegnare
        x = exe.getXPoints();
        y = exe.getYPoints();
        //Arrotonda i valori double ad int e trasla i punti per adattarli all'area di disegno
        int[] xInt = new int[nPunti];
        int[] yInt = new int[nPunti];
        //calcola il coefficente di traslazione come (larghezza_pannello/2) / -xMax_reale
        double alfa = (this.innerDrawPanel.getSize().width /2) / exe.getXMax();
        for (int i = 0; i<nPunti;i++)
        {
            xInt[i] =  (int)Math.round(x[i] * alfa);
            yInt[i] = -(int)Math.round(y[i] * alfa); //l'asse y cresce verso il basso!
        }
        //Disegna gli assi cartesiani
        g.drawLine(-250,0,250,0);
        g.drawLine(0,-250,0,250);
        //Disegna il grafico della funzione
        //g.drawPolyline(xInt,yInt,nPunti);
        
        /*il ciclo for � un espediente forse poco elegante per disegnare soltanto i punti
         della funzione calcolati, non i segmenti che li collegano.
         Ma come si fa altrimenti per disegnare soltanto un punto?*/
        for(int i=0;i<nPunti;i++)
        {
            g.drawLine(xInt[i],yInt[i], xInt[i], yInt[i]);
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ASTCompletoButton;
    private javax.swing.JPanel IOPanel;
    private javax.swing.JButton OKButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton clearInputTextAreaButton;
    private javax.swing.JButton clearOutputTextAreaButton;
    private javax.swing.JLabel drawLabel;
    private javax.swing.JPanel drawPanel;
    private javax.swing.JButton executeButton;
    private javax.swing.JButton impostazioniButton;
    private javax.swing.JDialog impostazioniDisegnoDialog;
    private javax.swing.JPanel innerDrawPanel;
    private javax.swing.JLabel inputLabel;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JScrollPane inputScrollPane;
    private javax.swing.JTextArea inputTextArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel nPuntiLabel;
    private javax.swing.JTextField nPuntiTextField;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JPanel outputPanel;
    private javax.swing.JScrollPane outputScrollPane;
    private javax.swing.JTextArea outputTextArea;
    private javax.swing.JLabel spazioLabel1;
    private javax.swing.JPanel textPanel;
    private javax.swing.JLabel treeLabel;
    private javax.swing.JPanel treePanel;
    private javax.swing.JScrollPane treeScrollPane;
    private javax.swing.JLabel xMaxLabel;
    private javax.swing.JTextField xMaxTextField;
    // End of variables declaration//GEN-END:variables
    
}
