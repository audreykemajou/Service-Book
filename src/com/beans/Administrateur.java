/**
 * Administrateur.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.beans;

public interface Administrateur extends java.rmi.Remote {
    public void modifierAdresse(java.lang.String id, java.lang.String rue, java.lang.String ville, java.lang.String code_postal, java.lang.String annonce) throws java.rmi.RemoteException;
    public void creerCategorie(java.lang.String titre) throws java.rmi.RemoteException;
    public void creerAnnonce(java.lang.String nom, java.lang.String telephone, java.lang.String categorie, java.lang.String rue, java.lang.String ville, java.lang.String code_postal) throws java.rmi.RemoteException;
    public void supprimerAdresse(java.lang.String id) throws java.rmi.RemoteException;
    public void supprimerAnnonce(java.lang.String id) throws java.rmi.RemoteException;
    public java.lang.String afficherAnnonces() throws java.rmi.RemoteException;
    public void creerAdresse(java.lang.String rue, java.lang.String ville, java.lang.String code_postal, java.lang.String annonce) throws java.rmi.RemoteException;
    public void modifierAnnonce(java.lang.String id, java.lang.String nom, java.lang.String telephone, java.lang.String categorie, java.lang.String rue, java.lang.String ville, java.lang.String code_postal) throws java.rmi.RemoteException;
    public void supprimerCategorie(java.lang.String id) throws java.rmi.RemoteException;
    public java.lang.String rechercherAnnonceNom(java.lang.String nom) throws java.rmi.RemoteException;
    public java.lang.String rechercherAnnonceVille(java.lang.String ville) throws java.rmi.RemoteException;
    public void modifierCategorie(java.lang.String titre, java.lang.String id) throws java.rmi.RemoteException;
    public java.lang.String afficherCategories() throws java.rmi.RemoteException;
    public java.lang.String rechercherAnnonceCategorie(java.lang.String titreCategorie) throws java.rmi.RemoteException;
    public java.lang.String rechercherAdresseString(java.lang.String idAnnonce) throws java.rmi.RemoteException;
    public java.lang.String rechercherAnnonceIdCategorie(java.lang.String idCategorie) throws java.rmi.RemoteException;
    public java.lang.String rechercherAnnonceIdString(java.lang.String idAnnonce) throws java.rmi.RemoteException;
    public java.lang.String rechercherAdresseStringId(java.lang.String idAdresse) throws java.rmi.RemoteException;
    public java.lang.String rechercherCategorieString(java.lang.String idCategorie) throws java.rmi.RemoteException;
}
