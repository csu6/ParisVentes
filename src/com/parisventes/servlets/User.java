package com.parisventes.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parisventes.beans.Article;
import com.parisventes.beans.BDD;
import com.parisventes.beans.Personne;

/**
 * Servlet implementation class User
 */
@WebServlet("/user")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String FILENAME = "C:\\Users\\Administrateur\\eclipse-workspace\\ParisVentes\\WebContent\\personnes.txt";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = 0;

		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}

		Personne personne = new Personne();
		personne.setRequest(request);
		
		BDD bdd = new BDD(FILENAME);
		System.out.println();
		Personne user = personne.findById(bdd.readFile(), id);
		request.setAttribute("user", user);

		this.getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
