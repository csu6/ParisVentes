package com.parisventes.beans;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Personne {
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String password;
	private HttpServletRequest request;
	private static String FILENAME = "C:\\Users\\Administrateur\\eclipse-workspace\\ParisVentes\\WebContent\\personnes.txt";

	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Bonjour, je m'appelle " + this.firstname + " " + this.lastname + ", voilà mon numéro " + this.password
				+ " et mon email " + this.email;
	}
	
	public Personne splitLine(String line) {
		String[] arr = line.split("\\|");
		Personne personne = new Personne();
		personne.id = this.stringToInteger(arr[0]);
		
		personne.firstname = arr[1];
		personne.lastname = arr[2];
		personne.email = arr[3];
		personne.phone = arr[4];
		personne.password = arr[5];
		
		return personne;
		
	}
	
	public ArrayList<Personne> findAll(List<String> allLines) {
		String html = new String();
		 ArrayList<Personne> arr = new  ArrayList<Personne>();
		for (String line : allLines) {
			Personne personne = this.splitLine(line);
			arr.add(personne);
		}
		return arr;
	}
	
	public Personne findById(List<String> allLines, Integer id) {
		for (int i = 0; i < allLines.size(); i++) {

			Personne personne = this.splitLine(allLines.get(i));
			System.out.println(personne.id + " : " + id);
			if (personne.id == id) {
				return personne;
//				html = "<article><h4>";
//				html += personne.getFirstname() + "</h4><figure><img src=\"";
//				html += request.getContextPath() + "/img/" + personne + "\" alt=\"\"><figcaption>";
//				html += personne.lastname + "</figcaption></figure><span>";
//				html += personne.phone + "�</span></article>";
//				return html;
			}else {
//				html = "Aucune personne n'existe avec cet identifiant";
			}
		}
		
		return null;
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
