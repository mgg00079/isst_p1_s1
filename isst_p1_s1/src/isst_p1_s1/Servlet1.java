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
 * Servlet implementation class Servlet1
 */

//Aquí se implementan los métodos getHeaderNames() y getHeaders().

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain"); //Le dice al cliente (el navegador web) qué tipo de contenido es para que sepa qué hacer con él.
		PrintWriter out = response.getWriter(); //En Servlets, la salida puede ser un caracter o byte. Para datos de caracter (por ejemplo, texto), podemos usar PrintWriter.
		//PrintWriter: imprime datos de texto en un flujo de caracteres.
		//getWriter: devuelve un objeto PrintWriter que puede enviar texto en caracteres al cliente.
		
		out.println("Request Headers:");
		Enumeration names = request.getHeaderNames(); //Se crea un objeto de tipo Enumeración con el nombre "names". En el se incluyen los nombres de las cabeceras de la petición.
		while (names.hasMoreElements()) { //Mientras el objeto "names" tenga elementos.
			String name = (String) names.nextElement(); //El "(String)" es para convertir a String lo que hay en "names", puesto que es un objeto de tipo Enumeration.
			//Si utilizamos la sentencia: String name = names.nextElement();, Eclipse nos dará un aviso de que tenemos que incluir la conversión a String con --> (String).
			Enumeration values = request.getHeaders(name); //Soporta múltiples valores.
			//getHeaders devuelve el valor de la cabecera. Entonces, se define un objeto de tipo enumeración llamado "values", que va a contener los valores de las cabeceras.
			if(values != null) { //Si el objeto "values" no está vacío.
				while(values.hasMoreElements()) { //Y mientras haya más elementos en dicho objeto.
					String value = (String) values.nextElement(); //Se almacena en la variable "value" los elementos del objeto de tipo Enumeration "values" (recordar que hay que pasarlo a tipo String).
					out.println(name + ": " + value); //Aquí se muestran el nombre y el valor de las cabeceras.
				}
			}
		}
	}
}
