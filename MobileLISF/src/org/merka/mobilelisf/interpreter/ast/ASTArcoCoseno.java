/* Generated By:JJTree: Do not edit this line. ASTArcoCoseno.java */

package org.merka.mobilelisf.interpreter.ast;
import org.merka.mobilelisf.interpreter.*;
import org.merka.mobilelisf.interpreter.visitor.*;

public class ASTArcoCoseno extends SimpleNode {
  public ASTArcoCoseno(int id) {
    super(id);
  }

  public ASTArcoCoseno(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data)throws Exception {
    return visitor.visit(this, data);
  }
}
