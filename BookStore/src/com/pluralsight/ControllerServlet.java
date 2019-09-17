package com.pluralsight;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */


public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;
       
    
    
	public ControllerServlet() {
        super();
        
        bookDAO = new BookDAO();
        bookDAO.connect();
        bookDAO.disconnect();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		if (action.contentEquals("/new")) {
			addBook(request, response); 
		}
		else {
			 listBook(request, response);
		}
	}

	private void listBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Book> books=bookDAO.listAllBooks();
		
		request.setAttribute("book_list", books);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/BookList.jsp");
		dispatcher.forward(request, response);
		
	}

	private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/BookForm.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		if (action.contentEquals("/insert")) {
			insertBook(request, response); 
		}
		
	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("booktitle");
		String author = request.getParameter("bookauthor");
		String priceString = request.getParameter("bookprice");
		
		Book newBook = new Book(title, author, Float.parseFloat(priceString));
		
		bookDAO.insertBook(newBook);
		
		response.sendRedirect("list");
	}

}
