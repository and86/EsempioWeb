package it.alfasoft.andrea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletNew
 */
@WebServlet(description = "una descrizione di servlet", urlPatterns = { "/aaa" })
public class ServletNew extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.setContentType("text/html");	
	
	String nome=request.getParameter("username");
		
		HttpSession session=request.getSession();	//session serve per memorizzare i dati e mantenere traccia di qualcuno
		
		ServletContext context=request.getServletContext();	//context vive per tutto il ciclo dell'applicazione
		
		PrintWriter wr=response.getWriter();
		if(!nome.isEmpty()&& nome!=null){
		session.setAttribute("usernameSalvatoSession", nome);
		
		context.setAttribute("usernameSalvatoContext", nome);
		}		
		wr.println("ciao "+nome);
		wr.println("ciao da session "+session.getAttribute("usernameSalvatoSession")+"<br>");
		wr.println("ciao da context "+context.getAttribute("usernameSalvatoContext")+"<br>");
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		PrintWriter wr=response.getWriter();
		if(password.equals("123")){		
		wr.println("benvenuto "+username);
		} else{
		
		response.sendRedirect("login.html");
		}
	
	}
	


}
