/* Generated By:JJTree: Do not edit this line. ASTEsponente.java */

package org.merka.mobilelisf.interpreter.ast;
import org.merka.mobilelisf.interpreter.*;
import org.merka.mobilelisf.interpreter.visitor.*;

public class ASTEsponente extends SimpleNode {
  public ASTEsponente(int id) {
    super(id);
  }

  public ASTEsponente(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) throws Exception{
    return visitor.visit(this, data);
  }
}
