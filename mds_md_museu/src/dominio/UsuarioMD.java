package dominio;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.exception.CPFinvalidoException;

public class UsuarioMD extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public UsuarioMD(){
		super();
	}
	
	private boolean verificaCPF(String cpf)throws CPFinvalidoException
	{
		return true;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cmd = (String) request.getParameter("cmd");
		
		if (cmd == null) {
			doGet(request,response);
		} else {
			String cpf;
			String senha;
			try {
				cpf = (String) request.getSession().getAttribute("cpfUsuario");
				senha = (String) request.getSession().getAttribute("pswUsuario");
			}
			catch(NullPointerException e){
				cpf = "";
				senha = "";
				request.getRequestDispatcher("UsuarioNaoInformaDados.jsp").forward(request, response);
			}
			if (!response.isCommitted()){
				
				try {
					
					switch (cmd) {
						
					case "Entrar":
					
					break;
					case "Cadastrar usuário":
						
						verificaCPF(cpf);
					break;	
					}
				}
				catch(CPFinvalidoException e)
				{
					
				}
			}
		}
	}

}
