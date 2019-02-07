package isst_p1_s1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetRequestURI
 */

//Opcional: m�todo getRequestURI.

@WebServlet("/GetRequestURI")
public class GetRequestURI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRequestURI() {
        super();
        // TODO Auto-generated constructor stub
    }

    static final String NEW_HOST = "http://www.java2s.com";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String newLocation = NEW_HOST + request.getRequestURI();
		
		response.setHeader("Refresh", "10; URL=" + newLocation);
		
		out.println("La URI solicitada se ha movido a un host diferente. <br>");
		out.println("Su nueva localizaci�n es " + newLocation + "<br>");
		out.println("El navegador te llevar� all� en 10 segundos");
	}

}
