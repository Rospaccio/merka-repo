/*
 * CheckerVisitor.java
 *
 * Created on 19 agosto 2004, 11.01
 */

package org.merka.mobilelisf.interpreter.visitor;
import java.util.Hashtable;

import org.merka.mobilelisf.interpreter.*;
import org.merka.mobilelisf.interpreter.ast.*;
/**
 *
 * @author  Alberto Mercati
 */

/*Classe che ha il compito di verificare, ad ogni occorrenza di variabile applicata, 
 *che tale variabile sia stata definite (cioè sia presente nella symbolTable).*/

public class CheckerVisitor implements ParserVisitor {
    
    /** Creates a new instance of CheckerVisitor */
    protected Hashtable symbolTable;
    
    public CheckerVisitor(Hashtable evalVisitorSymbolTable)
    {
        this.symbolTable = evalVisitorSymbolTable;
    }
    
    public void setSymbolTable(Hashtable symbolTable)
    {
        this.symbolTable = symbolTable;
    }
    
    /**
     *Controlla che node sia una variabile definita, cioè che sia presente nella Symbol Table
     */
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTVariabile node, Object data) throws Exception 
    {
        String varName = node.getName();
        Object entry = symbolTable.get(varName);
        if (entry == null)
            throw new Exception("Variabile "+varName+" non definita");
        //else OK!
        node.jjtGetChild(0).jjtAccept(this,data);
        return null;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTEsponente node, Object data) throws Exception 
    {      
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTSomma node, Object data) throws Exception {
        Node child0 = node.jjtGetChild(0);
        child0.jjtAccept(this, null);
        Node child1 = node.jjtGetChild(1);
        child1.jjtAccept(this, data);
        return null;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoCancellaTutto node, Object data) throws Exception {
        return null;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTMonomio node, Object data) throws Exception {
        Node child0 = node.jjtGetChild(0);
        child0.jjtAccept(this, data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTValoreAssoluto node, Object data) throws Exception 
    {
        node.jjtGetChild(0).jjtAccept(this,data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoCancellaVariabile node, Object data) throws Exception {
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTVariabileIndipendente node, Object data) throws Exception {
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTLogaritmoNaturale node, Object data) throws Exception {
        node.jjtGetChild(0).jjtAccept(this,data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoDisegno node, Object data) throws Exception 
    {
        node.jjtGetChild(0).jjtAccept(this,data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTProgramma node, Object data) throws Exception {
        node.jjtGetChild(0).jjtAccept(this, data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.SimpleNode node, Object data) throws Exception {
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTDifferenza node, Object data) throws Exception {
        node.jjtGetChild(0).jjtAccept(this,data);
        node.jjtGetChild(1).jjtAccept(this, data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTArcoSeno node, Object data) throws Exception {
        node.jjtGetChild(0).jjtAccept(this, data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTDivisione node, Object data) throws Exception {
        node.jjtGetChild(0).jjtAccept(this,data);
        node.jjtGetChild(1).jjtAccept(this,data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTSeno node, Object data) throws Exception {
        node.jjtGetChild(0).jjtAccept(this, data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoStampa node, Object data) throws Exception {
        node.jjtGetChild(0).jjtAccept(this,data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTTangente node, Object data) throws Exception {
         node.jjtGetChild(0).jjtAccept(this,data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTEsponenziale node, Object data) throws Exception {
         node.jjtGetChild(0).jjtAccept(this,data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoAssegnamento node, Object data) throws Exception {
        node.jjtGetChild(1).jjtAccept(this,data);
        return null;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTArcoTangente node, Object data) throws Exception {
        node.jjtGetChild(0).jjtAccept(this,data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoCalcolo node, Object data) throws Exception {
        node.jjtGetChild(0).jjtAccept(this,data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTCotangente node, Object data) throws Exception {
        node.jjtGetChild(0).jjtAccept(this,data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTFattoriale node, Object data) throws Exception {
        node.jjtGetChild(0).jjtAccept(this,data);
        return data;       
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTArcoCoseno node, Object data) throws Exception {
        node.jjtGetChild(0).jjtAccept(this,data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTNum node, Object data) throws Exception {
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTCoseno node, Object data) throws Exception {
        node.jjtGetChild(0).jjtAccept(this,data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoElenco node, Object data) throws Exception {
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTProdotto node, Object data) throws Exception {
        node.jjtGetChild(0).jjtAccept(this, data);
        node.jjtGetChild(1).jjtAccept(this,data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTMonomioNegativo node, Object data) throws Exception {
        node.jjtGetChild(0).jjtAccept(this,data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTLogaritmo node, Object data) throws Exception {
        node.jjtGetChild(1).jjtAccept(this,data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTArcoCotangente node, Object data) throws Exception {
        node.jjtGetChild(0).jjtAccept(this,data);
        return data;
    }
    
    public Object visit(org.merka.mobilelisf.interpreter.ast.ASTComandoAlbero node, Object data) throws Exception {
        node.jjtGetChild(0).jjtAccept(this,data);
        return data;
    }
    
}
