package isst_p1_s1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetAuthType
 */

//Parte opcional: probar otros métodos de HttpServletRequest.
//Métodos getAuthType(): devuelve el nombre del esquema de autenticación utilizado para proteger el Servlet.
//Todos los contenedores de servlets son compatibles con la autenticación básica, de formulario y de certificado
//de cliente, y pueden además ser compatibles con la autenticación de resumen. Si el servlet no se autentica, 
//se devuelve un nulo (que es nuestro caso).


@WebServlet("/GetAuthType")
public class GetAuthType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAuthType() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		
		out.println("<h1>This is a password protected resource</h1");
		out.println("<pre>");
		out.println("User Name: " + request.getRemoteUser());
		String name = (request.getUserPrincipal() == null) ? null : request.getUserPrincipal().getName();
		out.println("Principal Name: " + name);
		out.println("Authentication Type: " + request.getAuthType());
		out.println("Is a Manager: " + request.isUserInRole("manager"));
		out.println("</pre>");
		out.println("</body></html>");
		
	}

}
