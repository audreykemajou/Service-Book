/**
 * AdministrateurService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.beans;

public interface AdministrateurService extends javax.xml.rpc.Service {
    public java.lang.String getAdministrateurAddress();

    public com.beans.Administrateur getAdministrateur() throws javax.xml.rpc.ServiceException;

    public com.beans.Administrateur getAdministrateur(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
