package edu.udc.psw.modelo;

import java.nio.ByteBuffer;

import edu.udc.psw.modelo.manipulador.ManipuladorFormaGeometrica;
import edu.udc.psw.modelo.manipulador.ManipuladorRetangulo;

public class Retangulo implements FormaGeometrica {
	
	public static final long serialVersionUID = 1L;
	private Ponto2D a;
	private Ponto2D b;
	
	public Retangulo(){
		a = new Ponto2D();
		b = new Ponto2D();
	}
	
	public Retangulo(Ponto2D a, Ponto2D b){
		this.a = a.clone();
		this.b = b.clone();
	}
	
	public Retangulo(float ax, float ay, float bx, float by){
		a = new Ponto2D(ax, ay);
		b = new Ponto2D(bx, by);
	}
	
	public Ponto2D getA() {
		return a.clone();
	}

	public Ponto2D getB() {
		return b.clone();
	}

	public void setA(Ponto2D a) {
		this.a = a.clone();
	}

	public void setB(Ponto2D b) {
		this.b = b.clone();
	}
	
	public Ponto2D centro(){
		return new Ponto2D((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2);
	}
	
	public double base(){
		return Math.abs(a.getX() - b.getX());
	}
	
	public double altura(){
		return Math.abs(a.getY() - b.getY());
	}
	
	public double area(){
		return base() * altura();
	}

	@Override
	public double perimetro() {
		return 2 * base() + 2 * altura();
	}

	@Override
	public String toString(){
		return a.toString() + b.toString();
	}
	
	public byte[] toArrayA() {
		byte [] bytes = new byte [16];
		ByteBuffer.wrap(bytes,0,8).putDouble(a.getX());
		ByteBuffer.wrap(bytes,8,8).putDouble(a.getY());
		return bytes;
	}
	
	public byte[] toArrayB() {
		byte [] bytes = new byte [16];
		ByteBuffer.wrap(bytes,0,8).putDouble( b.getX());
		ByteBuffer.wrap(bytes,8,8).putDouble( b.getY());
		return bytes;
	}
	

	
	@Override
	public ManipuladorFormaGeometrica getManipulador() {
		return new ManipuladorRetangulo(this);
	}

	@Override
	public Retangulo clone() {
		return new Retangulo(a, b);
	}

	@Override
	public long getSerialVersionUID() {
		return serialVersionUID;
	}
}
