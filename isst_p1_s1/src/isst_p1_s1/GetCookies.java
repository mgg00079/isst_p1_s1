package isst_p1_s1;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookies
 */

//Opcional: implementaci�n del m�todo getCookies().
//Devuelve un array que contiene todos los objetos de tipo Cookie enviados en la petici�n. 
//Devuelve null si no se ha enviado ninguna cookie.

@WebServlet("/GetCookies")
public class GetCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    res.setContentType("text/html");
	    PrintWriter out = res.getWriter();

	    String sessionid = null; //Inicializaci�n de la sesi�n.
	    Cookie[] cookies = req.getCookies(); //Se crea el objeto de tipo Cookie llamado "cookies".
	    //En �l se introducen las cookies de la petici�n.
	    
	    if (cookies != null) { //Si las cookies no est�n vac�as.
	      for (int i = 0; i < cookies.length; i++) { //Recorre las cookies.
	        if (cookies[i].getName().equals("sessionid")) { 
	          sessionid = cookies[i].getValue();
	          break;
	        }
	      }
	    }

	    // Si no se ha enviado ID de sesi�n, se genera uno.
	    // Luego se asegura de enviarlo al cliente en la respuesta.
	    if (sessionid == null) { //Si la ID de sesi�n est� vac�a.
	      sessionid = generateSessionId(); //Genera un ID de sesi�n.
	      Cookie c = new Cookie("sessionid", sessionid); //Almacena el valor generado del ID de sesi�n en un objeto de
	      //tipo Cookie llamado "c".
	      res.addCookie(c); //A�ade el objeto de tipo Cookie "c" a la respuesta.
	    }

	    out.println("<HEAD><TITLE>Current Shopping Cart Items</TITLE></HEAD>");
	    out.println("<BODY>");

	    // Los productos que hay en el carrito de la compra se asocian con el ID de sesi�n.
	    String[] items = getItemsFromCart(sessionid); //Genera un array de tipo String llamado "items" (que son los productos
	    //del carrito de la compra.
	    //El m�todo getItemsFromCart se implementa m�s abajo.

	    // Muestra en pantalla los productos que hay actualmente en el carrito.
	    out.println("You currently have the following items in your cart:<BR>");
	    if (items == null) { //Si el array "items" est� vac�o.
	      out.println("<B>None</B>"); //Muestra en pantalla el mensaje que indica que no hay ning�n producto en el carrito.
	    } else { 
	      out.println("<UL>"); //La etiqueta <ul> se utiliza para hacer una lista.
	      for (int i = 0; i < items.length; i++) { //Recorre el array "items".
	        out.println("<LI>" + items[i]); //Los muestra uno a uno.
	      }
	      out.println("</UL>");
	    }

	    // Pregunta si quieren a�adirse m�s productos al carrito o revisarlos.
	    out.println("<FORM ACTION=\"/servlet/ShoppingCart\" METHOD=POST>");
	    out.println("Would you like to<BR>");
	    out.println("<INPUT TYPE=SUBMIT VALUE=\" Add More Items \">");
	    out.println("<INPUT TYPE=SUBMIT VALUE=\" Check Out \">");
	    out.println("</FORM>");

	    // Ofrece una p�gina de ayuda.
	    out.println("For help, click <A HREF=\"/servlet/Help"
	        + "?topic=ShoppingCartViewerCookie\">here</A>");

	    out.println("</BODY></HTML>");
	}
	
	
	private static String generateSessionId() throws UnsupportedEncodingException {
	    String uid = new java.rmi.server.UID().toString(); // guaranteed unique
	    return URLEncoder.encode(uid,"UTF-8"); // encode any special chars
	}

	private static String[] getItemsFromCart(String sessionid) { //Se pasa el par�metro session id.
	    return new String[]{"a","b"};  //Devuelve el valor de los productos que habr� en el carrito.
	}

}
