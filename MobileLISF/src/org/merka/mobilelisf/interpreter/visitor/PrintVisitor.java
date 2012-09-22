/*
 * PrintVisitor.java
 *
 * Created on 18 maggio 2004, 22.02
 */

package org.merka.mobilelisf.interpreter.visitor;
import org.merka.mobilelisf.interpreter.*;
import org.merka.mobilelisf.interpreter.ast.*;

/**
 *
 * @author  Administrator
 */

/*Pendente: che convenzione adottare per la stampa delle parentesi???*/
/*Tentativo: le parentesi sono messe dall'oggetto contenitore intorno all'oggetto contenuto*/
/*L'oggetto contenitore indica le regole di precedenza sugli oggetti che conosce, i propri figli*/

public class PrintVisitor implements ParserVisitor{
    protected String programmaString = "nessuna modifica";
    
    /** Creates a new instance of PrintVisitor */
    public PrintVisitor() 
    {
    }
    
    public String getProgrammaString()
    {
        return this.programmaString;
    }
    
    public void setProgrammaString(String programma)
    {
        this.programmaString = programma;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTVariabile node, Object data) throws Exception{
        //String varName = node.getName();
        node.jjtGetChild(0).jjtAccept(this, data);
        String arg = this.getProgrammaString();
        setProgrammaString(node.getName()+"("+arg+")");
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTEsponente node, Object data)throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this,data);
        String esponente = "^"+getProgrammaString();
        setProgrammaString(esponente);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoCancellaTutto node, Object data)
    {
        String comando = "delete all;";
        setProgrammaString(comando);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTMonomio node, Object data)throws Exception 
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String arg = this.getProgrammaString();
        node.jjtGetChild(1).jjtAccept(this, data);
        String esp = this.getProgrammaString();
        //l'oggetto contenitore (Monomio) pone la parentesi per indicare la corretta precedenza 
        //fra gli oggetti che lui conosce (cioè i figli)
        this.setProgrammaString("("+arg+")^"+esp); 
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTValoreAssoluto node, Object data) throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String arg = this.getProgrammaString();
        this.setProgrammaString("abs("+arg+")");
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoCancellaVariabile node, Object data) throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this,data);
        String varName = this.getProgrammaString();
        String comando = "delete "+varName+";";
        this.setProgrammaString(comando);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTVariabileIndipendente node, Object data) 
    {
        this.setProgrammaString("x");
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTLogaritmoNaturale node, Object data) throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String arg = this.getProgrammaString();
        this.setProgrammaString("ln("+arg+")");
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoDisegno node, Object data)throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String varName = this.getProgrammaString();
        String comando = "draw "+varName+";";
        this.setProgrammaString(comando);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTProgramma node, Object data) throws Exception
    {
        String programma = "";
        int numChildren = node.jjtGetNumChildren();
        for (int i = 0; i<numChildren; i++)
        {
            node.jjtGetChild(i).jjtAccept(this, data);
            programma = programma+this.getProgrammaString()+"\n";
        }
        this.setProgrammaString(programma);
        return data;
    }
    
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.SimpleNode node, Object data) 
    {
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTArcoSeno node, Object data) throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String arg = this.getProgrammaString();
        this.setProgrammaString("arcsen("+arg+")");
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTSeno node, Object data) throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this,data);
        String arg = this.getProgrammaString();
        String funzione = "sin("+arg+")";
        this.setProgrammaString(funzione);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTTangente node, Object data) throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String arg = this.getProgrammaString();
        this.setProgrammaString("tan("+arg+")");
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTEsponenziale node, Object data)throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String arg = this.getProgrammaString();
        this.setProgrammaString("exp("+arg+")");
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoAssegnamento node, Object data)throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String varName = this.getProgrammaString();
        node.jjtGetChild(1).jjtAccept(this,data);
        String funzione = this.getProgrammaString();
        String comando = varName+" = "+funzione+";";
        this.setProgrammaString(comando);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTArcoTangente node, Object data)throws Exception 
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String arg = this.getProgrammaString();
        this.setProgrammaString("arctan("+arg+")"); 
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoCalcolo node, Object data) throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this,data);   //visita della variabile
        String varName = this.getProgrammaString();
        node.jjtGetChild(1).jjtAccept(this,data);    //visita del numero
        String numero = this.getProgrammaString();
        this.setProgrammaString(varName+"("+numero+")?;");
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTCotangente node, Object data)throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String arg = this.getProgrammaString();
        this.setProgrammaString("cotan("+arg+")");
        return data;
    }
      
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTFattoriale node, Object data) throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String arg = this.getProgrammaString();
        this.setProgrammaString("fact("+arg+")");
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTArcoCoseno node, Object data)throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String arg = this.getProgrammaString();
        this.setProgrammaString("arccos("+arg+")");
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTNum node, Object data) 
    {
        setProgrammaString(""+node.getValue());
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTCoseno node, Object data) throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String arg = this.getProgrammaString();
        this.setProgrammaString("cos("+arg+")");
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoElenco node, Object data) 
    {
        this.setProgrammaString("list;");
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTMonomioNegativo node, Object data)throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String arg = this.getProgrammaString();
        this.setProgrammaString("-("+arg+")");
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTLogaritmo node, Object data)throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this,data);
        String base = this.getProgrammaString();
        node.jjtGetChild(1).jjtAccept(this,data);
        String arg = this.getProgrammaString();
        this.setProgrammaString("log<"+base+">("+arg+")");
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTArcoCotangente node, Object data) throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String arg = this.getProgrammaString();
        this.setProgrammaString("arccotan("+arg+")");
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTSomma node, Object data)throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String arg1 = this.getProgrammaString();
        node.jjtGetChild(1).jjtAccept(this,data);
        String arg2 = this.getProgrammaString();
        this.setProgrammaString("("+arg1+"+"+arg2+")");
        return data;
    }
    
    public Object visit (ASTComandoStampa node, Object data)throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this,data);
        String varName = this.getProgrammaString();
        this.setProgrammaString(varName+"?;");
        return data;
    }
    
    public Object visit(ASTComandoAlbero node, Object data)throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String varName = this.getProgrammaString();
        this.setProgrammaString("tree "+varName+";");
        return data;
    }
    
    public Object visit(ASTDifferenza node, Object data)throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String arg1 = this.getProgrammaString();
        node.jjtGetChild(1).jjtAccept(this,data);
        String arg2 = this.getProgrammaString();
        this.setProgrammaString("("+arg1+"-"+arg2+")");
        return data;
    }
    
    public Object visit(ASTProdotto node, Object data)throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String arg1 = this.getProgrammaString();
        node.jjtGetChild(1).jjtAccept(this,data);
        String arg2 = this.getProgrammaString();
        this.setProgrammaString("("+arg1+"*"+arg2+")");
        return data;
    }
    
    public Object visit(ASTDivisione node, Object data)throws Exception
    {
        node.jjtGetChild(0).jjtAccept(this, data);
        String arg1 = this.getProgrammaString();
        node.jjtGetChild(1).jjtAccept(this,data);
        String arg2 = this.getProgrammaString();
        this.setProgrammaString("("+arg1+"/"+arg2+")");
        return data;
    }
}
