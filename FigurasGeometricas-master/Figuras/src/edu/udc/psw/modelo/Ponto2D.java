package edu.udc.psw.modelo;

import java.nio.ByteBuffer;

import edu.udc.psw.modelo.manipulador.ManipuladorFormaGeometrica;
import edu.udc.psw.modelo.manipulador.ManipuladorPonto2D;

public class Ponto2D implements FormaGeometrica {
	public static final long serialVersionUID = 1L;
	private double x;
	private double y;
	private double z;

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public Ponto2D(Ponto2D x2) {
		x = 0.0;
		y = 0.0;
		z= 0.0;
	}
	
	public Ponto2D(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Ponto2D(byte[] x2){
		if(ByteBuffer.wrap(x2, 0, 8).getLong() != serialVersionUID) {
			x = 0.0;
			y = 0.0;
			z= 0.0;
			return;
		}
		x = ByteBuffer.wrap(x2, 8, 8).getDouble();
		y = ByteBuffer.wrap(x2, 16, 8).getDouble();
		z = ByteBuffer.wrap(x2, 24, 8).getDouble();
	}	
	
	@Override
	public byte[] toArray() {
		byte[] bytes = new byte[24];
		ByteBuffer.wrap(bytes,0,8).putLong(serialVersionUID);
		ByteBuffer.wrap(bytes,8,8).putDouble(x);
	    ByteBuffer.wrap(bytes,16,8).putDouble(y);
	    ByteBuffer.wrap(bytes,24,8).putDouble(z);
	    return bytes;
	}
	
	@Override
	public Ponto2D clone() {
		return new Ponto2D(x, y,z);
	}

	public double distancia(Ponto2D p){
		return Math.sqrt( (x - p.x)*(x - p.x) + (y - p.y)*(y - p.y));
	}

	@Override
	public String toString(){
		return String.format("(%.2f; %.2f; %.2f)", x, y, z);
	}

	@Override
	public Ponto2D centro() {
		return clone();
	}

	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimetro() {
		return 0;
	}

	@Override
	public double base() {
		return 0;
	}

	@Override
	public double altura() {
		return 0;
	}
	
	@Override
	public ManipuladorFormaGeometrica getManipulador() {
		return new ManipuladorPonto2D(this);
	}
}