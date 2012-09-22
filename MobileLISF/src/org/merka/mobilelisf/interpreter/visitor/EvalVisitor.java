/*
 * EvalVisitor.java
 *
 * Created on 20 maggio 2004, 17.08
 */

package org.merka.mobilelisf.interpreter.visitor;
import java.util.Hashtable;
import java.util.Enumeration;

import org.merka.mobilelisf.interpreter.*;
import org.merka.mobilelisf.interpreter.ast.*;

/**
 *
 * @author  Administrator
 */
/*EvalVisitor richiede che gli venga passato un oggetto ASTProgramma dall'esterno*/
/*Contiene la Simbol Table, con tutti gli oggetti funzione che vengono definiti,
  perciò deve avere tempo di vita pari all'applicazione*/
/*il campo "programma" viene agiornato ogni volta che c'è un nuovo programma da eseguire,
  mentre il workspace (Symbol Table, albero, ecc...) rimane memorizzato*/

public class EvalVisitor implements ParserVisitor
{
    protected Hashtable symbolTable = new Hashtable();
    protected ASTProgramma programma;    //AST del programma immesso
    //protected byte status;
    protected CheckerVisitor checker = null;   //analizzatore semantico
    protected double currentRealValue;   //valore attualmente ottenuto dalle valutazioni
                                        //possono esitere solo valori di tipo double
    protected String output = "";
    protected Node treeOutput = null;
    protected int xMax = 10;            
    protected int nPunti = 201;     //limite massimo per il calcolo dei punti da disegnare
    protected double[] xPoints = new double[nPunti], yPoints = new double[nPunti];
    
    /** Creates a new instance of EvalVisitor */
    public EvalVisitor()
    {
    }
    
    public EvalVisitor(ASTProgramma p)
    {
        this.programma = p;
    }
    
    public void setProgramma(ASTProgramma p)
    {
        this.programma = p;
    }
    
    public ASTProgramma getProgramma()
    {
        return this.programma;
    }
    
    public String getOutput()
    {
        return this.output;

    }
    
    public Node getTreeOutput()
    {
        return this.treeOutput;
    }
    
    public double[] getXPoints()
    {
        return this.xPoints;
    }
    
    public double[] getYPoints()
    {
        return this.yPoints;
    }
    
    public int getNPunti()
    {
        return this.nPunti;
    }
    public void setNPunti(int nPunti)
    {
        this.nPunti = nPunti;
        //devono essere correttamente modificate le dimensioni dei vettori di punti
       xPoints = new double[nPunti];
       yPoints = new double[nPunti];   
    }
    public int getXMax()
    {
        return this.xMax;
    }
    
    public void setXMax(int x)
    {
        this.xMax = x;
    }
    
    protected CheckerVisitor createOrSetChecker()
    {
        if (this.checker == null)   //il checker non è ancora stato creato
            this.checker = new CheckerVisitor(this.symbolTable);
        else
            this.checker.setSymbolTable(this.symbolTable);
        return this.checker;            
    }
    
    public void execute()throws Exception
    {
        //Prima di invocare la Accept resetta i valori di output e treeOutput, che da questo momento
        //in poi non saranno più validi e verranno sovrascritti
        this.output = "";
        this.treeOutput = null;
        this.programma.jjtAccept(this,null);
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTVariabile node, Object data)throws Exception
    {
        //Il valore del punto ne quale la funzione deve essere calcolata viene passato lungo
        //l'albero tramite la variabile data, come oggetto di classe Double
        Object entry = symbolTable.get(node.getName());  
        //recupera il sotto-albero corrisp alla funzione
        Node funzione = (Node)entry;
        //Controlla che la variabile sia stata definita
        if (funzione == null)
        {
            throw new Exception("Variabile non definita: "+node.getName());
        }
        //Effettua il casting dell'argomento a Double
        Double arg = (Double)data;
        //L'argomento di funzione deve essere data, se il nodo ASTVariabile non ha figli,
        //altrimenti deve essere il valore restituito dalla funzione figlio
        //child0 -> Funzione racchisa tra le parentesi. Da essa si ottiene 
        //l'argomento per la ASTVariabile node
        Double argNode = (Double)data;
        if(node.jjtGetNumChildren()>0)
        {
            Node child0 = node.jjtGetChild(0);
            argNode = (Double)child0.jjtAccept(this, data);
        }
        Object risultato = funzione.jjtAccept(this,argNode);
        //risultato sarà di classe Double
        return risultato;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTEsponente node, Object data) 
    {
        //Deve semplicemente restituire il valore del suo numero
        ASTNum num = (ASTNum)node.jjtGetChild(0);
        return new Double(num.getValue());
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTSomma node, Object data) throws Exception
    {
        //recupera i valori dei due argomenti
        Double arg1 = (Double)node.jjtGetChild(0).jjtAccept(this, data);
        Double arg2 = (Double)node.jjtGetChild(1).jjtAccept(this,data);
        //restituisce la somma degli argomenti
        return new Double(arg1.doubleValue()+arg2.doubleValue());
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoCancellaTutto node, Object data)
    {
        //cancella tutte le funzioni memorizzate nella symbol table
        symbolTable.clear();
        this.xPoints=new double[nPunti];
        this.yPoints=new double[nPunti];
        /*in questo modo tutti i punti vengono re-inizzializzati a zero,
         il che equivale a cancellare l'output grafico*/
        
        this.output += "Cancellate tutte le variabili\n";
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTMonomio node, Object data) throws Exception
    {
        Double arg = (Double)node.jjtGetChild(0).jjtAccept(this, data);
        Double esp = (Double)node.jjtGetChild(1).jjtAccept(this,data);
        return new Double( Math.pow(arg.doubleValue(), esp.doubleValue()) );
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTValoreAssoluto node, Object data)throws Exception
    {
        Double arg = (Double)node.jjtGetChild(0).jjtAccept(this,data);
        if (arg.doubleValue() >=0)
            return arg;
        else
            return new Double (-arg.doubleValue());
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoCancellaVariabile node, Object data)throws Exception
    {
        Node child0 = node.jjtGetChild(0);
        ASTVariabile var = (ASTVariabile)child0;
        String varName = var.getName();
        Object entry = symbolTable.get(varName);
        if (entry == null) //non esiste alcuna funzione con questo nome -> errore
        {
            throw new Exception("Variabile non definita: "+varName);
        }
        //else
        symbolTable.remove(varName);
        this.output += "Cancellata variabile: "+varName+"\n";
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTVariabileIndipendente node, Object data)
    {
        //Deve restituire il valore attuale della variabile indipendete, 
        //ovvero l'oggetto Double che viene passato lungo l'albero nella variabile data
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTLogaritmoNaturale node, Object data) throws Exception
    {
        //Vincolo: il dominio del logaritmo è (0,+Inf), estremi esclusi
        Double arg = (Double)node.jjtGetChild(0).jjtAccept(this,data);
        if (arg.doubleValue()<=0)
            //Pendente: come fare per segnalere riga e colonna?
            throw new XOutOfDomainException("Argomento di ln <=0");
        Double risultato = new Double (Math.log(arg.doubleValue()));
        return risultato;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoDisegno node, Object data) throws Exception
    {
        //Vengono calcolati 101 valori compresi tra -xMax e xMax; 
        double currentX = -xMax;
        //recupera la variabile 
        ASTVariabile var = (ASTVariabile)node.jjtGetChild(0);
        //recupera l'oggetto funzione memorizzato con nella var
        Node funzione = (Node)this.symbolTable.get(var.getName());
        //controlla che la funzione sia stata definita
        if(funzione == null) //la funzione non era stata def
            throw new Exception("Variabile non definita :"+var.getName());
        //else
        //Calcola il passo di incremento per currentX. n punti = n-1 intervalli
        //cast necessario, altrimenti esegue l'operazione fra int, tralasciando i decimali
        double passo = (double)(2*xMax) / (nPunti - 1);
        //ciclo for che ripartisce uniformemente i punti x per i quali calcolare la funzione
        for(int i = 0;i<nPunti; i++)
        {
            xPoints[i] = currentX;
            currentX += passo;
        }
        //ciclo for che calcola gli nPunti punti
        for(int i = 0; i<nPunti; i++)
        {
            try{
                Double p = (Double)(funzione.jjtAccept(this, new Double(xPoints[i])));
                yPoints[i] = p.doubleValue();
            }
            catch(XOutOfDomainException e)
            {
               yPoints[i] = Double.NaN;
               continue;
            }
        }
        
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTProgramma node, Object data)throws Exception 
    {
        node.childrenAccept(this, data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.SimpleNode node, Object data) 
    {
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTDifferenza node, Object data)throws Exception  
    {
        Double arg1 = (Double)node.jjtGetChild(0).jjtAccept(this,data);
        Double arg2 = (Double)node.jjtGetChild(1).jjtAccept(this,data);
        Double risultato = new Double(arg1.doubleValue() - arg2.doubleValue());
        return risultato;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTArcoSeno node, Object data) throws Exception
    {
        //Vincolo: Il dominio dell'arcsen è [-pi/2, pi/2]
        Double arg = (Double)node.jjtGetChild(0).jjtAccept(this,data);
        double value = arg.doubleValue();
        if( value < -1 || value > 1)
            throw new XOutOfDomainException("Argomento di arcsin non valido");
        //else
        Double risultato = new Double(Math.asin(value));
        return risultato;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTDivisione node, Object data) throws Exception
    {
        Double arg1 = (Double)node.jjtGetChild(0).jjtAccept(this,data);
        Double arg2 = (Double)node.jjtGetChild(1).jjtAccept(this, data);
        Double risultato = new Double(arg1.doubleValue() / arg2.doubleValue());
        return risultato;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTSeno node, Object data)throws Exception
    {
        Double arg = (Double)node.jjtGetChild(0).jjtAccept(this,data);
        Double risultato = new Double(Math.sin(arg.doubleValue()));
        return risultato;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoStampa node, Object data)throws Exception
    {
        PrintVisitor printer = new PrintVisitor();
        Node child0 = node.jjtGetChild(0);
        ASTVariabile var = (ASTVariabile)child0;
        String varName = var.getName();
        Object entry = symbolTable.get(varName);
        if(entry == null)
            throw new Exception("Variabile non definita: "+varName);
        //else
        Node funzione = (Node)entry;
        funzione.jjtAccept(printer, null);
        this.output += varName+" = "+printer.getProgrammaString()+"\n";
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTTangente node, Object data) throws Exception
    {
        //Pendente: come controllare i valori per i quali tan non è definita?
        Double arg = (Double)node.jjtGetChild(0).jjtAccept(this,data);
        Double risultato = new Double (Math.tan(arg.doubleValue()));
        return risultato;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTEsponenziale node, Object data)throws Exception
    {
        Double arg = (Double)node.jjtGetChild(0).jjtAccept(this,data);
        Double risultato = new Double(Math.exp(arg.doubleValue()));
        return risultato;
    }
    
    //Assegna una funzione ad una variabile, creando una entry nella symbol table
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoAssegnamento node, Object data)throws Exception
    {
        Node childNode0 = (ASTVariabile)node.jjtGetChild(0);    //recupera la variabile
        ASTVariabile var = (ASTVariabile)childNode0;            //effettua il casting
        String varName = var.getName();                         //memorizza il nome della var
        Node funzione = node.jjtGetChild(1);                    //recupera il sottoalbero corrisp alla funzione
        /*
         *A questo punto occorre creare un Checker che esplori il sotto-albero "funzione",
         *per verificare che non contenga variabili applicate che non sono state definite
         *(<=> non sono presenti nella Symbol Table).
         */
        
        /*crea il checker (se non esiste ancora) e lo inizzializza con l'attuale SymbolTable*/
        this.createOrSetChecker();
        funzione.jjtAccept(checker, null);
        /*Se ci sono errori verrà generata un'eccezione dal checker, altrimenti significa 
         che tutto è andato bene => si può inserire la variabile nella Symbol Table*/
        symbolTable.put(varName, funzione);                     //crea la entry nella symbolTable
        this.output += "Assegnata variabile: "+varName+"\n";
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTArcoTangente node, Object data) throws Exception
    {
        Double arg = (Double)node.jjtGetChild(0).jjtAccept(this,data);
        Double risultato = new Double(Math.atan(arg.doubleValue()));
        return risultato;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoCalcolo node, Object data)throws Exception
    {
        Node child1 = node.jjtGetChild(1);          //recupera il paramentro attuale della funzione
        ASTNum num = (ASTNum)child1;
        Double arg = new Double(num.getValue());    //argomento della funzione
        Object r = node.jjtGetChild(0).jjtAccept(this,arg);
        Double risultato = (Double) r;
        //recupera la variabile
        Node child0 = node.jjtGetChild(0);
        ASTVariabile var = (ASTVariabile) child0;
        this.output += var.getName()+"("+arg+") = "+risultato+"\n";
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTCotangente node, Object data) throws Exception
    {
        Double arg = (Double)node.jjtGetChild(0).jjtAccept(this,data);
        // cotan(x) = cos(x) / sen(x)
        Double risultato = new Double( Math.cos(arg.doubleValue()) / Math.sin(arg.doubleValue()));
        return risultato;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTFattoriale node, Object data) throws Exception
    {
        //Vincolo: l'argomento del fatoriale deve essere un numero intero
        Double arg = (Double)data;
        if (arg.doubleValue() != Math.rint(arg.doubleValue()) || arg.doubleValue()<0)
            throw new XOutOfDomainException("Argomento di fact non intero");
        //else
        Double risultato = new Double(fact((int)Math.round(arg.doubleValue())));
        return risultato;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTArcoCoseno node, Object data) throws Exception
    {
        Double arg = (Double)node.jjtGetChild(0).jjtAccept(this, data);
        if (arg.doubleValue() < -1 || arg.doubleValue() > 1)
            throw new XOutOfDomainException("Argomento di arccos non valido");
        //else
        return new Double(Math.acos(arg.doubleValue()));
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTNum node, Object data) 
    {
        return new Double(node.getValue());
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTCoseno node, Object data) throws Exception
    {
        Double arg = (Double)node.jjtGetChild(0).jjtAccept(this,data);
        Double risultato = new Double(Math.cos(arg.doubleValue()));
        return risultato;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoElenco node, Object data) throws Exception
    {
        Object entry;
        Node funzione;
        StringBuffer funzioneString = new StringBuffer("");
        Object currentKey;
        String varName;
        PrintVisitor printer;
        
        //Enumeration che contiene le chiavi, cioè i nomi delle var definite
        Enumeration keys = symbolTable.keys(); 
        //per ogni elemento della symbol table effettua una visita con PrintVisitor,
        //quindi appende la funzione nella  stringa funzioneString
        while (keys.hasMoreElements())
        {
            currentKey = keys.nextElement();
            varName = (String)currentKey;
            entry = symbolTable.get(varName);
            funzione = (Node)entry;
            printer = new PrintVisitor();
            funzione.jjtAccept(printer, null);
            funzioneString.append(varName+" = "+ printer.getProgrammaString()+"\n"); //Aggiunge un ritorno a capo e la successiva funzione
        }
        this.output += "Variabili definite:\n" + funzioneString;
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTProdotto node, Object data) throws Exception
    {
        Double arg1 = (Double)node.jjtGetChild(0).jjtAccept(this,data);
        Double arg2 = (Double)node.jjtGetChild(1).jjtAccept(this, data);
        Double risultato = new Double (arg1.doubleValue() * arg2.doubleValue());
        return risultato;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTMonomioNegativo node, Object data) throws Exception
    {
        Double arg = (Double)node.jjtGetChild(0).jjtAccept(this,data);
        return new Double(-arg.doubleValue());
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTLogaritmo node, Object data)throws Exception 
    {
        //Pendente: Quali sono i vincoli sul valore della base del logaritmo?
        Double arg = (Double)node.jjtGetChild(1).jjtAccept(this,data);
        ASTNum num = (ASTNum)node.jjtGetChild(0);
        double base = num.getValue();
        if(arg.doubleValue() <= 0)
            throw new XOutOfDomainException("Argomento di log <= 0");
        //else
        if (base <=0)
            throw new Exception("Base di log <= 0");
        //else
        Double risultato = new Double( Math.log(arg.doubleValue()) / Math.log(base));
        return risultato;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTArcoCotangente node, Object data) 
    {
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoAlbero node, Object data) throws Exception
    {
        Node child0 = node.jjtGetChild(0);
        ASTVariabile var = (ASTVariabile)child0;
        String varName = var.getName();
        Object entry = symbolTable.get(varName);
        Node funzione = (Node)entry;
        if (funzione == null)
            throw new Exception("Variabile non definita: "+varName);
        //else
        this.treeOutput = funzione;
        return data;
    }
    
    protected int fact(int n)
    {
        if(n == 0)
            return 1;
        else
           return n*fact(n-1);
    }
}
