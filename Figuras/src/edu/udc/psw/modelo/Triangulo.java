package edu.udc.psw.modelo;
import java.util.ArrayList;
import java.util.List;
import edu.udc.psw.modelo.manipulador.ManipuladorFormaGeometrica;
import edu.udc.psw.modelo.manipulador.ManipuladorCirculo;

public class Triangulo implements FormaGeometrica {
	protected Ponto2D a;
	protected Ponto2D b;
	protected Ponto2D c;
	
	protected Ponto2D aT;
	protected Ponto2D bT;
	protected Ponto2D cT;
	
	public Triangulo() {
		a = new Ponto2D(0, 0);
		b = new Ponto2D(0, 0);
		c = new Ponto2D(0, 0);
		this.aT = new Ponto2D(a);
		this.bT = new Ponto2D(b);
		this.cT = new Ponto2D(c);
	}

	public Triangulo(Ponto2D A, Ponto2D B, Ponto2D C) {
		this.setA(A);
		this.setB(B);
		this.setC(C);
		this.aT = new Ponto2D(a);
		this.bT = new Ponto2D(b);
		this.cT = new Ponto2D(c);
	}

	@Override
	public String toString() {
		return "Triangulo [A=" + a + ", B=" + b + ", C=" + c + " transforma��o=" + t + "]";
	}

	public static Triangulo getNewInstance() {
        return new Triangulo();
    }
	
	public float getArea() {
		return Math.abs(
				((aT.getX() - cT.getX()) * (bT.getY() - cT.getY()) - (aT.getY() - cT.getY()) * (bT.getX() - cT.getX())) / 2);
	}

	public void setTransformacao(Transformacao t) {
		this.t = t;
		aplicarTransformacao();
	}

	public void comporTransformacao(Transformacao t) {
		if(this.t== null) {
			this.t= Transformacao.getIdentidade();
		}
		this.t.compor(t);
		aplicarTransformacao();
	}

	
	public Transformacao getTransformacao() {
		return t;
	}

	private void aplicarTransformacao() {
		float[][] p = t.aplicar(getPontosCoordHom());
		aT.setCoordHom(p[0]);
		bT.setCoordHom(p[1]);
		cT.setCoordHom(p[2]);
	}

	public void setA(Ponto2D a) {
		this.a = a;
		aplicarTransformacao();
	}

	
	public Ponto2D getA() {
		return a;
	}

	public void setB(Ponto2D b) {
		this.b = b;
		aplicarTransformacao();
	}

	
	public Ponto2D getB() {
		return b;
	}

	public void setC(Ponto2D c) {
		this.c = c;
		aplicarTransformacao();
	}


	public Ponto2D getC() {
		return c;
	}

	
	public Ponto2D getCentro() {
		return new Ponto2D((aT.getX()+bT.getX()+cT.getX())/3, (aT.getY()+bT.getY()+cT.getY())/3);
	}

	public List<Ponto2D> getListPontos() {
		List<Ponto2D> l = new ArrayList<Ponto2D>();
		l.add(a);
		l.add(b);
		l.add(c);
		return l;
	}

	public void setListPontos(List<Ponto2D> pontos) throws IllegalArgumentException {
		if(pontos.size() != 3)
			throw new IllegalArgumentException("N�mero do pontos inv�lido");
		
		a = pontos.get(0);
		b = pontos.get(1);
		c = pontos.get(2);
		aplicarTransformacao();
	}
	
	public float[][] getPontos2D() {
		float[][] v = new float[3][2];
		v[0] = a.getCoord2D();
		v[1] = b.getCoord2D();
		v[2] = c.getCoord2D();
		return v;
	}

	
	public float[][] getPontosCoordHom() {
		float[][] v = new float[3][3];
		v[0] = a.getCoordHom();
		v[1] = b.getCoordHom();
		v[2] = c.getCoordHom();
		return v;
	}

	public void setPontos2D(float[][] v) {
		if(v.length != 3 && v[0].length != 2)
			throw new IllegalArgumentException("N�mero de coordenadas inv�lido");
		
		a.setCoord2D(v[0]);
		b.setCoord2D(v[1]);
		c.setCoord2D(v[2]);
		aplicarTransformacao();
	}

	public void setPontosCoordHom(float[][] v) {
		if(v.length != 3 && v[0].length != 3)
			throw new IllegalArgumentException("N�mero de coordenadas inv�lido");
		
		a.setCoordHom(v[0]);
		b.setCoordHom(v[1]);
		c.setCoordHom(v[2]);
		aplicarTransformacao();
	}

	@Override
	public long getSerialVersionUID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Ponto2D centro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ManipuladorFormaGeometrica getManipulador() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormaGeometrica clone() {
		// TODO Auto-generated method stub
		return null;
	}

