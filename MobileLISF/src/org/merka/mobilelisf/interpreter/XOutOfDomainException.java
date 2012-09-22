/*
 * XOutOfDomainException.java
 *
 * Created on 23 maggio 2004, 13.13
 */

package org.merka.mobilelisf.interpreter;

/**
 *
 * @author  Administrator
 */
public class XOutOfDomainException extends Exception {
    
    /** Creates a new instance of XOutOfDomainException */
    public XOutOfDomainException(String msg) 
    {
        super(msg);
    }
    
    public XOutOfDomainException()
    {
        super("");
    }
}
