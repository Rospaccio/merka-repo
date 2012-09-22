/*
 * Util.java
 *
 * Created on 25 maggio 2004, 20.37
 */

package org.merka.mobilelisf.interpreter;
import org.merka.mobilelisf.interpreter.*;
import org.merka.mobilelisf.interpreter.ast.*;
import org.merka.mobilelisf.interpreter.visitor.*;

/**
 *
 * @author  Administrator
 */
public class Util {
    
    /** Creates a new instance of Util */
    public Util() {
    }
    
    public static ASTSomma createSomma(Node arg0, Node arg1)
    {
        ASTSomma somma = new ASTSomma(ParserTreeConstants.JJTSOMMA);
        somma.jjtAddChild(arg0,0);
        somma.jjtAddChild(arg1, 1);
        return somma;
    }
    
    public static ASTDifferenza ASTDifferenza(Node arg0, Node arg1)
    {
        ASTDifferenza differenza = new ASTDifferenza(ParserTreeConstants.JJTDIFFERENZA);
        differenza.jjtAddChild(arg0,0);
        differenza.jjtAddChild(arg1,1);
        return differenza;
    }
    
    public static ASTProdotto createProdotto(Node arg0, Node arg1)
    {
        ASTProdotto prodotto = new ASTProdotto(ParserTreeConstants.JJTPRODOTTO);
        prodotto.jjtAddChild(arg0, 0);
        prodotto.jjtAddChild(arg1, 1);
        return prodotto;
    }
    
    public static ASTDivisione createDivisione(Node arg0, Node arg1)
    {
        ASTDivisione divisione = new ASTDivisione(ParserTreeConstants.JJTDIVISIONE);
        divisione.jjtAddChild(arg0,0);
        divisione.jjtAddChild(arg1,1);
        return divisione;
    }
    
    public static ASTMonomio createMonomio(Node arg, Node esp)
    {
        ASTMonomio monomio = new ASTMonomio(ParserTreeConstants.JJTMONOMIO);
        monomio.jjtAddChild(arg,0);
        monomio.jjtAddChild(arg,1);
        return monomio;
    }
    
    public static ASTMonomio createMonomio(Node arg, ASTNum numEsp)
    {
        ASTEsponente esp = new ASTEsponente(ParserTreeConstants.JJTESPONENTE);
        esp.jjtAddChild(numEsp,0);
        return createMonomio(arg,esp);
    }
    
    public static ASTMonomio createMonomio(Node arg, double doubleEsp)
    {
        ASTNum numEsp = new ASTNum(doubleEsp, ParserTreeConstants.JJTNUM);
        return createMonomio(arg,numEsp);
    }
}
