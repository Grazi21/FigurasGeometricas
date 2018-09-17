package edu.udc.psw.modelo.manipulador;

import java.awt.Graphics;

import edu.udc.psw.modelo.Ponto2D;
import edu.udc.psw.modelo.Triangulo;

public class ManipuladorTriangulo implements ManipuladorFormaGeometrica {

	private Triangulo triangulo;
	private int click;
	private boolean finalizado = false;
	private boolean cancelado = false;

	public ManipuladorTriangulo(Triangulo triangulo) {
		this.triangulo = triangulo;
		this.click = 0;
	}

	public void click(float x, float y) {
		if (finalizado || cancelado)
			return;
		if (click == 0) {
			triangulo.setA(new Ponto2D(x, y));
			triangulo.setB(new Ponto2D(x, y));
			triangulo.setC(new Ponto2D(x, y));
			click++;
		} else if (click == 1) {
			triangulo.setB(new Ponto2D(x, y));
			click++;
		} else if (click == 2) {
			triangulo.setC(new Ponto2D(x, y));
			finalizado = true;
		}
	}

	public void press(float x, float y) { }

	public void release(float x, float y) { }

	public void drag(float x, float y) { }

	public void move(float x, float y) {
		if (finalizado || cancelado)
			return;
		if (click == 1) {
			triangulo.setB(new Ponto2D(x, y));
		} else if (click == 2) {
			triangulo.setC(new Ponto2D(x, y));
		}
	}

	@Override
	public void click(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void press(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void release(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drag(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}