package com.parisventes.servlets;

import java.io.File;
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


/**
 * Servlet implementation class Home
 */
@WebServlet("")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String FILENAME = "C:\\Users\\Administrateur\\eclipse-workspace\\ParisVentes\\WebContent\\articles.txt";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * //response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("request", this.getServletContext());
		request.setAttribute("request2", request.getContextPath());
		String path = this.getServletContext().getContextPath();
		String pathCss = this.getServletContext().getRealPath("/WEB-INF/css");  
		String pathImg = this.getServletContext().getRealPath("/WEB-INF/img");  
		request.setAttribute("path", pathCss);
		request.setAttribute("pathCss", pathCss);
		request.setAttribute("pathImg", pathImg);
		

		String articles1 = readFile(FILENAME,  request);
		
		request.setAttribute("articles", articles1);
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		*/
		
		Article articles = new Article();
		articles.setRequest(request);
		
		BDD bdd = new BDD(FILENAME);
		request.setAttribute("articles", articles.findAll(bdd.readFile()));
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		
		
		
	}

	private String readFile(String path, HttpServletRequest request) {
		String s = "";
		

		try {
		List<String> allLines = Files.readAllLines(Paths.get(path));
			for (String line : allLines) {
			String arr[] = line.split("\\|");
				s += "       <article>\r\n" + 
						"	       <a href=\""+request.getContextPath()+"/article?id="+arr[0]+"\"><div class=\"card text-center\" style=\"width: 20rem;\">\r\n" + 
						"			  <img class=\"card-img-top\" src=\"img/"+arr[2]+"\" alt=\""+arr[1]+"\">\r\n" + 
						"			  <div class=\"card-block\">\r\n" + 
						"			    <h4 class=\"card-title\">"+arr[1]+"</h4>\r\n" + 
						"			    <p class=\"card-text\">"+arr[3]+"</p>\r\n" + 
						"			    <a href=\"#\" class=\"btn btn-primary\">"+arr[4]+" &euro;</a>\r\n" + 
						"			  </div>\r\n" + 
						"			</div></a>\r\n" + 
						"       </article>";
				

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
