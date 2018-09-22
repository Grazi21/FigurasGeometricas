package edu.udc.psw.modelo;

import java.util.List;

import edu.udc.psw.modelo.FormaGeometrica;
import edu.udc.psw.modelo.manipulador.ManipuladorFormaGeometrica;
import edu.udc.psw.modelo.manipulador.ManipuladorTriangulo;

public class Triangulo implements FormaGeometrica {
	
	protected Ponto2D x;
	protected Ponto2D y;
	protected Ponto2D z;
	
	protected Ponto2D xT;
	protected Ponto2D yT;
	protected Ponto2D zT;
	
	public Triangulo() {
		x = new Ponto2D(0, 0, 0);
		y = new Ponto2D(0, 0, 0);
		z = new Ponto2D(0, 0, 0);
		this.xT = new Ponto2D(x);
		this.yT = new Ponto2D(y);
		this.zT = new Ponto2D(z);
	}
	
	public Triangulo(Ponto2D X, Ponto2D Y, Ponto2D Z) {
		this.xT = new Ponto2D(x);
		this.yT = new Ponto2D(y);
		this.zT = new Ponto2D(z);
	}
	
	
	@Override
	public Ponto2D centro() {
		return new Ponto2D((xT.getX()+yT.getX()+zT.getX())/3, (xT.getY()+yT.getY()+zT.getY())/3, (xT.getZ()+yT.getZ()+zT.getZ())/3);
	}

	@Override
	public double area() {
		return Math.abs(
				((xT.getX() - zT.getX()) * (yT.getY() - zT.getY()) - (xT.getY() - zT.getY()) * (yT.getX() - zT.getX())) / 2);
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double base() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double altura() {
		return 0;
	}

	@Override
	public byte[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManipuladorFormaGeometrica getManipulador() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormaGeometrica clone() {
		return (FormaGeometrica) new ManipuladorTriangulo(null);
	}
	

}