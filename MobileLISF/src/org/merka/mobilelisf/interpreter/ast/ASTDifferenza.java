/* Generated By:JJTree: Do not edit this line. ASTDifferenza.java */

package org.merka.mobilelisf.interpreter.ast;
import org.merka.mobilelisf.interpreter.*;
import org.merka.mobilelisf.interpreter.visitor.*;

public class ASTDifferenza extends SimpleNode {
  public ASTDifferenza(int id) {
    super(id);
  }

  public ASTDifferenza(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data)throws Exception {
    return visitor.visit(this, data);
  }
}
