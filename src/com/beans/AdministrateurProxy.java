package com.beans;

public class AdministrateurProxy implements com.beans.Administrateur {
  private String _endpoint = null;
  private com.beans.Administrateur administrateur = null;
  
  public AdministrateurProxy() {
    _initAdministrateurProxy();
  }
  
  public AdministrateurProxy(String endpoint) {
    _endpoint = endpoint;
    _initAdministrateurProxy();
  }
  
  private void _initAdministrateurProxy() {
    try {
      administrateur = (new com.beans.AdministrateurServiceLocator()).getAdministrateur();
      if (administrateur != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)administrateur)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)administrateur)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (administrateur != null)
      ((javax.xml.rpc.Stub)administrateur)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.beans.Administrateur getAdministrateur() {
    if (administrateur == null)
      _initAdministrateurProxy();
    return administrateur;
  }
  
  public void modifierCategorie(java.lang.String titre, java.lang.String id) throws java.rmi.RemoteException{
    if (administrateur == null)
      _initAdministrateurProxy();
    administrateur.modifierCategorie(titre, id);
  }
  
  public java.lang.String afficherCategories() throws java.rmi.RemoteException{
    if (administrateur == null)
      _initAdministrateurProxy();
    return administrateur.afficherCategories();
  }
  
  public java.lang.String rechercherAnnonceCategorie(java.lang.String titreCategorie) throws java.rmi.RemoteException{
    if (administrateur == null)
      _initAdministrateurProxy();
    return administrateur.rechercherAnnonceCategorie(titreCategorie);
  }
  
  public java.lang.String rechercherAnnonceNom(java.lang.String nom) throws java.rmi.RemoteException{
    if (administrateur == null)
      _initAdministrateurProxy();
    return administrateur.rechercherAnnonceNom(nom);
  }
  
  public java.lang.String rechercherAnnonceVille(java.lang.String ville) throws java.rmi.RemoteException{
    if (administrateur == null)
      _initAdministrateurProxy();
    return administrateur.rechercherAnnonceVille(ville);
  }
  
  public void supprimerCategorie(java.lang.String id) throws java.rmi.RemoteException{
    if (administrateur == null)
      _initAdministrateurProxy();
    administrateur.supprimerCategorie(id);
  }
  
  public void supprimerAnnonce(java.lang.String id) throws java.rmi.RemoteException{
    if (administrateur == null)
      _initAdministrateurProxy();
    administrateur.supprimerAnnonce(id);
  }
  
  public void creerAnnonce(java.lang.String nom, java.lang.String telephone, java.lang.String categorie) throws java.rmi.RemoteException{
    if (administrateur == null)
      _initAdministrateurProxy();
    administrateur.creerAnnonce(nom, telephone, categorie);
  }
  
  public void modifierAnnonce(java.lang.String id, java.lang.String nom, java.lang.String telephone, java.lang.String categorie) throws java.rmi.RemoteException{
    if (administrateur == null)
      _initAdministrateurProxy();
    administrateur.modifierAnnonce(id, nom, telephone, categorie);
  }
  
  public void creerCategorie(java.lang.String titre) throws java.rmi.RemoteException{
    if (administrateur == null)
      _initAdministrateurProxy();
    administrateur.creerCategorie(titre);
  }
  
  public void supprimerAdresse(java.lang.String id) throws java.rmi.RemoteException{
    if (administrateur == null)
      _initAdministrateurProxy();
    administrateur.supprimerAdresse(id);
  }
  
  public void creerAdresse(java.lang.String rue, java.lang.String ville, java.lang.String code_postal, java.lang.String annonce) throws java.rmi.RemoteException{
    if (administrateur == null)
      _initAdministrateurProxy();
    administrateur.creerAdresse(rue, ville, code_postal, annonce);
  }
  
  public java.lang.String afficherAnnonces() throws java.rmi.RemoteException{
    if (administrateur == null)
      _initAdministrateurProxy();
    return administrateur.afficherAnnonces();
  }
  
  public void modifierAdresse(java.lang.String id, java.lang.String rue, java.lang.String ville, java.lang.String code_postal, java.lang.String annonce) throws java.rmi.RemoteException{
    if (administrateur == null)
      _initAdministrateurProxy();
    administrateur.modifierAdresse(id, rue, ville, code_postal, annonce);
  }
  
  
}