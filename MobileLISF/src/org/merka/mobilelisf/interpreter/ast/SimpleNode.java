/* Generated By:JJTree: Do not edit this line. SimpleNode.java */

package org.merka.mobilelisf.interpreter.ast;
import javax.swing.tree.TreeNode;

import org.merka.mobilelisf.interpreter.*;
import org.merka.mobilelisf.interpreter.visitor.*;

public class SimpleNode implements javax.swing.tree.TreeNode, Node {
  protected Node parent;
  protected Node[] children;
  protected int id;
  protected Parser parser;

  public SimpleNode(int i) {
    id = i;
  }

  public SimpleNode(Parser p, int i) {
    this(i);
    parser = p;
  }

  public void jjtOpen() {
  }

  public void jjtClose() {
  }
  
  public void jjtSetParent(Node n) { parent = n; }
  public Node jjtGetParent() { return parent; }

  public void jjtAddChild(Node n, int i) {
    if (children == null) {
      children = new Node[i + 1];
    } else if (i >= children.length) {
      Node c[] = new Node[i + 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = n;
  }

  public Node jjtGetChild(int i) {
    return children[i];
  }

  public int jjtGetNumChildren() {
    return (children == null) ? 0 : children.length;
  }

  /** Accept the visitor. **/
  public Object jjtAccept(org.merka.mobilelisf.interpreter.visitor.ParserVisitor visitor, Object data) throws Exception
  {
    return visitor.visit(this, data);
  }

  /** Accept the visitor. **/
  public Object childrenAccept(ParserVisitor visitor, Object data) throws Exception{
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        children[i].jjtAccept(visitor, data);
      }
    }
    return data;
  }

  /* You can override these two methods in subclasses of SimpleNode to
     customize the way the node appears when the tree is dumped.  If
     your output uses more than one line you should override
     toString(String), otherwise overriding toString() is probably all
     you need to do. */

  public String toString() { return ParserTreeConstants.jjtNodeName[id]; }
  public String toString(String prefix) { return prefix + toString(); }

  /* Override this method if you want to customize how the node dumps
     out its children. */

  public void dump(String prefix) {
    System.out.println(toString(prefix));
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
	SimpleNode n = (SimpleNode)children[i];
	if (n != null) {
	  n.dump(prefix + " ");
	}
      }
    }
  }
 /*-------------------------------------------------------------------------------------*/
 /*-------------------------------------------------------------------------------------*/
 /*------------------------- Metodi dell'interfaccia TreeNode --------------------------*/
 /*-------------------------------------------------------------------------------------*/
 /*-------------------------------------------------------------------------------------*/
  
  /*
   *Restituisce un oggetto che implementa Enumeration,
   *i cui elementi sono tutti  i figli del nodo
   */
  public java.util.Enumeration children() 
  {
      int numC = this.jjtGetNumChildren();
      java.util.Vector v = new java.util.Vector(numC);
      for (int i = 0; i<numC; i++)
      {
          v.addElement(this.jjtGetChild(i));    //finch� ci sono figli li aggiunge al Vector
      }
      return v.elements(); // Il metodo Vector.elements() restituisce un oggetto Enumeration
  }
  
  /*
   *restituisce true se l'oggetto ammette figli, quindi dovrebbe essere ridefinito per
   *ogni sottoclasse di SimpleNode.
   */
  public boolean getAllowsChildren() 
  {
      return true;
  }
  
  public javax.swing.tree.TreeNode getChildAt(int childIndex) 
  {
      return (javax.swing.tree.TreeNode) this.jjtGetChild(childIndex);
  }
  
  public int getChildCount() 
  {
      return this.jjtGetNumChildren();
  }
  
  public int getIndex(javax.swing.tree.TreeNode node) 
  {
      int numc = this.jjtGetNumChildren();
      for (int i = 0; i<numc; i++)
      {
          if ( (TreeNode)jjtGetChild(i) == node )
              return i;
      }
      return -1;
  }
  
  public javax.swing.tree.TreeNode getParent() 
  {
      return (TreeNode) this.jjtGetParent();
  }
  
  /*Discorso analogo a quanto detto per getAllowsChildren()
   */
  public boolean isLeaf() 
  {
      return false;
  }
  
}

