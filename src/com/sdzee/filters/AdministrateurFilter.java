package com.sdzee.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.beans.Utilisateur;

public class AdministrateurFilter implements Filter {
    public static final String ACCES_CONNEXION  = "/projet/index.jsp";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";

    public void init( FilterConfig config ) throws ServletException {
    }

    public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) throws IOException,
            ServletException {
        /* Cast des objets request et response */
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        /* Non-filtrage des ressources statiques */
        String chemin = request.getRequestURI().substring( request.getContextPath().length() );
        if ( chemin.startsWith( "/inc" ) ) {
            chain.doFilter( request, response );
            return;
        }

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute( ATT_SESSION_USER);

        
        if ( session.getAttribute( ATT_SESSION_USER ) == null ) {
            /* Redirection vers la page publique */
        	response.sendRedirect( ACCES_CONNEXION );
            //request.getRequestDispatcher( ACCES_CONNEXION ).forward( request, response );
        } else {
        	if ( utilisateur.getAdmin() == 1 ) {
            	/* Affichage de la page restreinte */
                chain.doFilter( request, response );
            } else {
            	/* Redirection vers la page publique */
            	response.sendRedirect( ACCES_CONNEXION );
                //request.getRequestDispatcher( ACCES_CONNEXION ).forward( request, response );
            }
        }
        
    }

    public void destroy() {
    }
}