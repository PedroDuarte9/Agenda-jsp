package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class DAO {
	/* Módulo de conexão */

//Parâmetro de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbagenda";
	private String user = "root";
	private String password = "Pedro123.";

//Método de Conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// Teste de Conexão
	public void testeConexao() {

		try {
			Connection con = conectar();
			System.out.println("Conexão feita com sucesso " + con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// CRUD Inserção de Dados
	public void inserirContatos(JavaBean contato) {
		String create = "insert into contatos (nome,fone,email) values (?,?,?)";// Variável que armazena a query

		// Try-catch para não ocorrer nenhum problema na conecção com o banco
		try {
			// Iniciando a conexão com o banco
			Connection con = conectar();
			// Preparando o ambiente do banco
			PreparedStatement pst = con.prepareStatement(create);
			// Substituindo os parâmetros (?) pelo conteudo das variáveis
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			// Executar a Query
			pst.execute();
			// Encerrar a conexão com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/* CRUD Listar Dados */
	public ArrayList<JavaBean> listarContatos(){
		//Criando objeto para acessar a Classe JavaBean
		ArrayList<JavaBean> contatos = new ArrayList<>();
		String read = "select * from contatos";
						
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				//Variaveis de apoio que recebem os dados do banco 
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				//Populando o ArrayList com o objeto criado acima
				contatos.add(new JavaBean(idcon, nome, fone, email));
			}
			con.close();
			return contatos;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
