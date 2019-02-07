package isst_p1_s1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */

//Implementamos lo que hay en el Servlet1 con HTML. Para información sobre el código, consultar Servlet1.

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); //Para que coja las etiquetas que utilicemos.
		PrintWriter out = response.getWriter(); 
		
		//Aquí empezamos con HTML:
		String title = "Cabeceras HTTP"; //Definimos un título para la página.
		out.println("<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body>\n");
		out.println("<h1>Métodos getHeaderNames y getHeaders</h1>\n" + "<table width=\"100%\" border=\"1\"\n"
		+ "<tr>\n" + "<th> Nombre cabecera </th><th>Valor cabecera</th>\n" + "</tr>\n");
		
		Enumeration<String> names = request.getHeaderNames(); 
		while (names.hasMoreElements()) { 
			String name = (String) names.nextElement(); 
			Enumeration<String> values = request.getHeaders(name); //El <String> lo requiere para que no sea raw data.		
			if(values != null) { 
				while(values.hasMoreElements()) { 
					String value = (String) values.nextElement(); 
					out.println("<tr><td>" + name + "</td>\n<td> " + value + "/td></tr>\n"); 
				}
			}
		}
		
		out.println("</table>\n");
	}
}
