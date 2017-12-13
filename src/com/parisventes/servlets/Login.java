package com.parisventes.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parisventes.beans.Article;
import com.parisventes.beans.BDD;
import com.parisventes.beans.Personne;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String email = "toto@toto.fr";
	private String password = "123456";
	private Boolean isLog = false;
	private ArrayList<Personne> listPersonnes;
	
	private static String FILENAME = "C:\\Users\\Administrateur\\eclipse-workspace\\ParisVentes\\WebContent\\personnes.txt";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		HttpSession session = request.getSession(true);

		String[] str = { "vanessa", "chairat", "sam" };

		request.setAttribute("str", str);
		request.setAttribute("value", null);

	

		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = "<div class=\"p-3 mb-2 bg-danger text-white\">Erreur email ou password !!</div>";
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		isLog = false;
		
		String logout = "";

		HttpSession session = request.getSession(true);
		System.out.println("logoutlogoutlogoutlogoutlogoutlogoutlogoutlogoutlogout");
		if(request.getParameter("logout") != null) {
			logout =  request.getParameter("logout");
			msg = "<div class=\"p-3 mb-2 bg-primary text-white\">Logout success!!!!</div>";
			 session.invalidate();
		} else {
			

			// Get all users
			Personne personnes = new Personne();
			personnes.setRequest(request);
			
			BDD bdd = new BDD(FILENAME);
			
			this.listPersonnes = personnes.findAll(bdd.readFile());
			request.setAttribute("personnes",listPersonnes);
			
			// Verifier user

			//if(this.email.equals(email) && this.password.equals(password)) {
			if( this.canConnect(email, password) != null ) {
				msg = "<div class=\"p-3 mb-2 bg-primary text-white\">Connexion success!!!!</div>";
				isLog = true;
				// Cookie cookie = new Cookie("email", email);
				// cookie.setMaxAge(10);
				// response.addCookie(cookie);
				//
				session.setAttribute("email", email);
				session.setAttribute("personne", this.canConnect(email, password));
				session.setAttribute("listPersonne", this.listPersonnes);
				session.setAttribute("isLog", isLog);
				response.sendRedirect(request.getContextPath()+"/user?id=2");
			}
		}
		request.setAttribute("msg", msg);


		if(!isLog) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}

	}
	
	
	public Personne canConnect(String mail, String mdp) {

		Personne personne = null;		
		Iterator<Personne> iterator = listPersonnes.iterator();
		while(iterator.hasNext()) {
			Personne p = iterator.next();
			if(p.getEmail().toLowerCase().equals(mail) && p.getPassword().equals(mdp)) {
				personne  = p;
				break;
			}
		}
	
		return personne;
	}

}
