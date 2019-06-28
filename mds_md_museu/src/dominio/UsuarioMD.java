package dominio;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.exception.CPFinvalidoException;
import dominio.exception.SenhaRN1Exception;
import java.util.InputMismatchException;

public class UsuarioMD extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public UsuarioMD(){
		super();
	}
	
	private void verificaCPF(String CPF)throws CPFinvalidoException
	{
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            throw new CPFinvalidoException(); 
          
        char dig10, dig11;
        int sm, i, r, num, peso;
          
        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {              
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0         
        // (48 eh a posicao de '0' na tabela ASCII)         
            num = (int)(CPF.charAt(i) - 48); 
            sm = sm + (num * peso);
            peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico
          
        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);
          
        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)));
                 
            else throw new CPFinvalidoException();
                } catch (InputMismatchException erro) {
                	throw new CPFinvalidoException();
                }
	}
	
	private void verificaSenha(String senha)throws SenhaRN1Exception {
		if(senha.length()<6)
			throw new SenhaRN1Exception();
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
						verificaSenha(senha);
						break;
					
					default:
						doGet(request,response);
						break;
					}
				}
				catch(CPFinvalidoException e)
				{
					request.getRequestDispatcher("CPFinvalido.jsp").forward(request, response);
				}
				catch(SenhaRN1Exception e) {
					request.getRequestDispatcher("SenhaForaDaRegra.jsp").forward(request, response);
				}
			}
		}
	}

}
