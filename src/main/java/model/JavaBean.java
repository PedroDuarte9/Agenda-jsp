package model;

public class JavaBean {
	/*A Classe JavaBean tem como responsabilidade, podemos definir que a classe segue um conjunto de especificações com o objetivo principal na segurança, isolando e encapsulando os dados 
	 * Podendo salvar o seu estado para o uso posterior partindo do mesmo ponto, ou seja salvando os dados num fluxo para posterior recuperação
	 * Na prática */
	
	private String idcon;
	private String nome;
	private String fone;
	private String email;
	
	public JavaBean() {
		super();
	}

	public JavaBean(String idcon, String nome, String fone, String email) {
		
		this.idcon = idcon;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}

	public String getIdcon() {
		return idcon;
	}

	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	

}
