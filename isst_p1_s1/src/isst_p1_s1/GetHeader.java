package isst_p1_s1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetHeader
 */

//Opcional: m�todo getHeader().
//Devuelve el valor de una cabecera especificada como String. Si la petici�n no incluye una cabecera
//con el nombre especificado, devuelve null. Si hay muchas cabeceras con el mismo nombre, devuelve la
//primera cabecera de la petici�n. El nombre de la cabecera no distingue entre may�sculas y min�sculas.
//Este m�todo puede utilizarse con cualquier cabecera de la petici�n.

//En este c�digo, vemos el valor de las cabeceras Accept-Language y Accept-Charset.

@WebServlet("/GetHeader")
public class GetHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHeader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		String acceptLanguage = request.getHeader("Accept-Language"); //Crea un objeto de tipo String que contiene la cabecera
		//Accept-Language obtenida de la petici�n.
		String acceptCharset = request.getHeader("Accept-Charset"); //Crea un objeto de tipo String que contiene la cabecera
		//Accept-Charset obtenida de la petici�n.

		out.println("Accept-Language: " + acceptLanguage);
		out.println("Accept-Charset: " + acceptCharset);
		
		//Esta es otra manera de mostrar las cabeceras, pero sin necesidad de implementar el setContentType ni el getWriter (es decir, esas dos l�neas
		//quedar�an eliminadas). Solo poniendo estas dos l�neas de c�digo de abajo se puede mostrar en pantalla las cabeceras:
		//response.getOutputStream().println("acceptLanguage: " + acceptLanguage); 
		//response.getOutputStream().println("acceptCharset" + acceptCharset);
		
	}

}
