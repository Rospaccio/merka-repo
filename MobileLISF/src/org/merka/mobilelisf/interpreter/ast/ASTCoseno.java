/* Generated By:JJTree: Do not edit this line. ASTCoseno.java */

package org.merka.mobilelisf.interpreter.ast;
import org.merka.mobilelisf.interpreter.*;
import org.merka.mobilelisf.interpreter.visitor.*;

public class ASTCoseno extends SimpleNode {
  public ASTCoseno(int id) {
    super(id);
  }

  public ASTCoseno(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data)throws Exception {
    return visitor.visit(this, data);
  }
}
