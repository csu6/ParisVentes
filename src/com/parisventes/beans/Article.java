package com.parisventes.beans;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Article {
	private Integer id;

	private String title;
	private String linkImg;
	private String description;
	private Float price;
	private HttpServletRequest request;
	

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLinkImg() {
		return linkImg;
	}
	public void setLinkImg(String linkImg) {
		this.linkImg = linkImg;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(String price) {
		try {
			this.price = Float.parseFloat(price);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<Article> findAll(List<String> allLines) {
		String html = new String();
		 ArrayList<Article> arr = new  ArrayList<Article>();
		for (String line : allLines) {
			Article article = this.splitLine(line);
			arr.add(article);
//			html += "<article><h4>";
//			html += article.title + "</h4><figure><a href=\"" + this.request.getContextPath() +"/article?id="+article.id+ "\"><img src=\"";
//			html += this.request.getContextPath() + "/img/" + article.linkImg+ "\" alt=\"\"></a><figcaption>";
//			html += article.description + "</figcaption></figure><span>";
//			html += article.price + "</span></article>";
		}
		return arr;
	}
	
	public String findById(List<String> allLines, Integer id) {
		String html = new String();
		for (int i = 0; i < allLines.size(); i++) {

			Article article = this.splitLine(allLines.get(i));
			System.out.println(article.id + " : " + id);
			if (article.id == id) {
				html = "<article><h4>";
				html += article.title + "</h4><figure><img src=\"";
				html += request.getContextPath() + "/img/" + article.linkImg + "\" alt=\"\"><figcaption>";
				html += article.description + "</figcaption></figure><span>";
				html += article.price + "�</span></article>";
				return html;
			}else {
				html = "Aucun article n'existe avec cet identifiant";
			}
		}
		
		return html;
	}
	
//	public Article splitLine(String line) {
//		String[] arr = line.split("\\|");
//		Article article = new Article();
//		article.setId(arr[0]);
//		article.setTitle(arr[1]);
//		article.setLinkImg(arr[2]);
//		article.setDescription(arr[3]);
//		article.setPrice(arr[4]);
//		return article;
//		
//	}
	public Article splitLine(String line) {
		String[] arr = line.split("\\|");
		Article article = new Article();
		article.id = this.stringToInteger(arr[0]);
		
		article.title = arr[1];
		article.linkImg = arr[2];
		article.description = arr[3];
		
		try {
			article.price = Float.parseFloat(arr[4]);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return article;
		
	}

	
	public Integer stringToInteger(String str) {
		Integer i = 0;
		try {
			i = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			System.out.println("Attention problème de parseInt dans mon article et dans ma méthode splitLine pour mon id");
		}
		return i;
	}

	
}