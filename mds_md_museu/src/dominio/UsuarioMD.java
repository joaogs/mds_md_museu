package dominio;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioMD extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = (String) request.getParameter("cmd");
		
		if (cmd == null) {
			doGet(request,response);
		} else {
			
		}
	}

}
