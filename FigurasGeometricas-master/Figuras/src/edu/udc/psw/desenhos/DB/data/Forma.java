package edu.udc.psw.desenhos.DB.data;

import java.sql.Array;
import java.sql.Timestamp;


public class Forma {
	
	private long id_formas;
	private int TipoForma;
	private String texto;
	private Array binary;
	private int desenho;
	
	public Forma(long id_formas) {
		this.id_formas = id_formas;
				
	}

	public Forma(long id_formas, int tipo, String texto, Array binario, int desenho) {
		this.id_formas = id_formas;
		this.TipoForma = ("1,Ponto")||("2,Linha")||("3,Retangulo")||("4,Circulo")||("5,Triangulo");
		this.texto = texto;
		this.binary= binario;
		this.desenho = desenho;
	}
	
	
	public long getId_formas() {
		return id_formas;
	}
	public void setId_formas(long id_formas) {
		this.id_formas = id_formas;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Array getBinary() {
		return binary;
	}
	public void setBinary(Array binary) {
		this.binary = binary;
	}
	public int getDesenho() {
		return desenho;
	}
	public void setDesenho(int desenho) {
		this.desenho = desenho;
	}

	public int getTipoForma() {
		return TipoForma;
	}

	public void setTipoForma(int tipoForma) {
		TipoForma = tipoForma;
	}
	
	
			
}