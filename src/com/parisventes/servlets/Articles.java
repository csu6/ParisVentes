package com.parisventes.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parisventes.beans.Article;
import com.parisventes.beans.BDD;

@WebServlet("/article")
public class Articles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String FILENAME = "C:\\Users\\Administrateur\\eclipse-workspace\\ParisVentes\\WebContent\\articles.txt";

	public Articles() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = 0;

		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}

		Article articles = new Article();
		articles.setRequest(request);
		
		BDD bdd = new BDD(FILENAME);
		request.setAttribute("article", articles.findById(bdd.readFile(), id));

		this.getServletContext().getRequestDispatcher("/WEB-INF/article.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}