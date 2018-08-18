package edu.udc.psw.modelo;

import java.io.Serializable;
import java.nio.ByteBuffer;

import edu.udc.psw.modelo.manipulador.ManipuladorFormaGeometrica;

public interface FormaGeometrica extends Serializable { // Serializable - Cria forma geometria no arquivo de forma
														// serial, copia o conteudo da memoria para o disco//

	public long getSerialVersionUID();
	
	
	public Ponto2D centro();

	public double area();

	public double perimetro();

	public double base();

	public double altura();

	public ManipuladorFormaGeometrica getManipulador();

	public FormaGeometrica clone();


	public static FormaGeometrica fabricarFormaGeometrica(byte[] array) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//public static byte[] toByteArray(double value) {
	//	byte[] bytes = new byte [8];
	//	ByteBuffer.wrap(bytes).putDouble(value);
	//	return bytes;
	//}
	
	//public static double toDouble(byte[]bytes) {
	//	return  ByteBuffer.wrap(bytes).getDouble(value);
	//}
}
