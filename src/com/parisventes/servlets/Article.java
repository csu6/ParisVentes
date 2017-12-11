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

/**
 * Servlet implementation class Article
 */
@WebServlet("/article")
public class Article extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String FILENAME = "C:\\Users\\Administrateur\\eclipse-workspace\\ParisVentes\\WebContent\\articles.txt";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Article() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer articleId = Integer.parseInt(request.getParameter("id"));
		String article = readFile(FILENAME, articleId, request);
		
		request.setAttribute("article", article);
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/article.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String readFile(String path, Integer articleId, HttpServletRequest request) {
		String s = "";
		

		try {
		List<String> allLines = Files.readAllLines(Paths.get(path));
			for (String line : allLines) {
			String arr[] = line.split("\\|");
			System.out.println(Integer.parseInt(arr[0])+" == "+articleId);
			if(Integer.parseInt(arr[0]) == articleId) {

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
				

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}

}
