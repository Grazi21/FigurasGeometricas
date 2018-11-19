package edu.udc.psw.desenhos.DB.data;

import java.sql.Array;
import java.sql.Timestamp;

public class Forma {
	private long id;
	private int tipo;
	private String texto;
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Array getBinario() {
		return binario;
	}

	public void setBinario(Array binario) {
		this.binario = binario;
	}

	public int getDesenho() {
		return desenho;
	}

	public void setDesenho(int desenho) {
		this.desenho = desenho;
	}

	private Array binario;
	private int desenho;
	
	
	public Forma (long id) {
		this.id = id;
		this.tipo = "Triangulo" + "Retangulo" + "Linha" + "Ponto" + "Quadrado";
		
		
				
	}

	public Forma(long id, int nome,String texto, Array binario, int desenho) {
		this.id = id;
		this.tipo = tipo;
		this.texto = texto;
		this.binario = binario;
		this.desenho= desenho;
	}

	@Override
	public String toString() {
		return "Forma [id=" + id + ",tipo =\" + tipo + \",texto=\" + texto + \",binario =\" + binario + \",desenho =\" + desenho + \" ]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

		
}