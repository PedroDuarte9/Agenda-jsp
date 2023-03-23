package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBean;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/inserir" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO(); //Instaciamos um objeto do Tipo DAO para acesso a classe que fará a persistencia ao banco de dados
	JavaBean contato = new JavaBean();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) //Método que fará a requisição para tela de Agenda de Contatos
			throws ServletException, IOException {
		// teste de conexão
		dao.testeConexao();
		String action = request.getServletPath(); //Atibuto que guarda o Path da requisição
		System.out.println(action);
		if (action.equals("/main")) {// Se o path estiver igual ao do parâmetro faço uma request e traga a response do parâmetro
			contatos(request, response);
		}
		else if(action.equals("/inserir")) {
			novoContato(request,response);
		}
		else {
			response.sendRedirect("index.html");
		}
	}

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("agenda.jsp"); //Método que vai direcionar para uma página jsp
	}
	
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			//Testando se o parâmetro está chegando
			System.out.println(request.getParameter("nome"));
			System.out.println(request.getParameter("fone"));
			System.out.println(request.getParameter("email"));
			
			//Setando os dados
			contato.setNome(request.getParameter("nome"));
			contato.setFone(request.getParameter("fone"));
			contato.setEmail(request.getParameter("email"));
		
			//Invocar o método inserirContato passando o obeto javaBean
			dao.inserirContatos(contato);
			
			//redireciono para o documento inicial agenda.jsp
			response.sendRedirect("main");
			
		
		
	}
	
	
	

}
