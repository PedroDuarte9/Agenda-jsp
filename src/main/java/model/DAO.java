package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
 /*Módulo de conexão*/
	
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
	//Teste de Conexão
	public void testeConexao() {
		
		try {
			Connection con = conectar();
			System.out.println("Conexão feita com sucesso " + con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
