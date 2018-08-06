package edu.udc.psw.modelo;

import java.io.Serializable;

import edu.udc.psw.modelo.manipulador.ManipuladorFormaGeometrica;

public interface FormaGeometrica extends Serializable { // Serializable - Cria forma geometria no arquivo de forma
														// serial, copia o conteudo da memoria para o disco//

	public Ponto2D centro();

	public double area();

	public double perimetro();

	public double base();

	public double altura();

	public ManipuladorFormaGeometrica getManipulador();

	public FormaGeometrica clone();

}
