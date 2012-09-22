/* Generated By:JJTree: Do not edit this line. ast\ParserVisitor.java */

package org.merka.mobilelisf.interpreter.visitor;
import org.merka.mobilelisf.interpreter.*;
import org.merka.mobilelisf.interpreter.ast.*;

public interface ParserVisitor
{
  public Object visit(SimpleNode node, Object data)throws Exception;
  public Object visit(ASTProgramma node, Object data)throws Exception;
  public Object visit(ASTComandoAssegnamento node, Object data)throws Exception;
  public Object visit(ASTComandoCalcolo node, Object data)throws Exception;
  public Object visit(ASTComandoStampa node, Object data)throws Exception;
  public Object visit(ASTComandoAlbero node, Object data)throws Exception;
  public Object visit(ASTComandoElenco node, Object data) throws Exception;
  public Object visit(ASTComandoCancellaVariabile node, Object data)throws Exception;
  public Object visit(ASTComandoCancellaTutto node, Object data)throws Exception;
  public Object visit(ASTComandoDisegno node, Object data)throws Exception;
  public Object visit(ASTSomma node, Object data)throws Exception;
  public Object visit(ASTDifferenza node, Object data)throws Exception;
  public Object visit(ASTProdotto node, Object data)throws Exception;
  public Object visit(ASTDivisione node, Object data)throws Exception;
  public Object visit(ASTMonomio node, Object data)throws Exception;
  public Object visit(ASTNum node, Object data)throws Exception;
  public Object visit(ASTEsponente node, Object data)throws Exception;
  public Object visit(ASTSeno node, Object data)throws Exception;
  public Object visit(ASTCoseno node, Object data)throws Exception;
  public Object visit(ASTTangente node, Object data)throws Exception;
  public Object visit(ASTCotangente node, Object data)throws Exception;
  public Object visit(ASTArcoSeno node, Object data)throws Exception;
  public Object visit(ASTArcoCoseno node, Object data)throws Exception;
  public Object visit(ASTArcoTangente node, Object data)throws Exception;
  public Object visit(ASTArcoCotangente node, Object data)throws Exception;
  public Object visit(ASTMonomioNegativo node, Object data)throws Exception;
  public Object visit(ASTLogaritmoNaturale node, Object data)throws Exception;
  public Object visit(ASTLogaritmo node, Object data)throws Exception;
  public Object visit(ASTValoreAssoluto node, Object data)throws Exception;
  public Object visit(ASTEsponenziale node, Object data)throws Exception;
  public Object visit(ASTFattoriale node, Object data)throws Exception;
  public Object visit(ASTVariabile node, Object data)throws Exception;
  public Object visit(ASTVariabileIndipendente node, Object data)throws Exception;
}
