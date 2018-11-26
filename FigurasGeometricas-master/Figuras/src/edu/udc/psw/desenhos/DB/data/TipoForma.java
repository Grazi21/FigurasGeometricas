package edu.udc.psw.desenhos.DB.data;


public class TipoForma {
		private long id_tipo;
		private String nome;
		private int qtd_pontos;
		private int qtd_escalares;

		public TipoForma(long id) {
			this.id_tipo = id_tipo;
			nome = ("1,Ponto")||("2,Linha")||("3,Retangulo")||("4,Circulo")||("5,Triangulo"); 			
							
	}
		
	public TipoForma(long id, String nome, int qdt_pontos,int qdt_escalares) {
			this.id_tipo = id_tipo;
			this.nome = nome;
			this.qtd_pontos = qtd_pontos;
			this.qtd_escalares = qtd_escalares;
		}

	public TipoForma(String nome2, TipoForma resultSet) {
		// TODO Auto-generated constructor stub
	}

	public long getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(long id_tipo) {
		this.id_tipo = id_tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtd_pontos() {
		return qtd_pontos;
		
	}	

	public void setQtd_pontos(int qtd_pontos) {
			this.qtd_pontos = qtd_pontos;
	}

	public int getQtd_escalares() {
		return qtd_escalares;
	}

	public void setQtd_escalares(int qtd_escalares) {
		this.qtd_escalares = qtd_escalares;
	}

}
