package edu.udc.psw.modelo;

import edu.udc.psw.modelo.manipulador.ManipuladorFormaGeometrica;

public class Circulo implements FormaGeometrica {
		
	private static final long serialVersionUID = 6L;
	private double raio;
	    private double perimetro;
	    private double area;

	    public Circulo() {
	        this.raio = 0;this.perimetro = 0;this.area = 0;
	    }

	    public Circulo(double raio) {
	        this.raio = raio;
	        this.perimetro = 0;
	        this.area = 0;
	    }

	   	    
	    public double getRaio() {
	        return raio;
	    }

	    public void setRaio(double raio) {
	        this.raio = raio;
	    }

	    public double getApotema() {
	        return (raio != 0) ? this.raio / 2 : 0;
	    }

	    public double getAreaTrianguloEquilateroInscrito() {
	        return (raio != 0) ? ((3 * Math.pow(raio, 2) * Math.sqrt(3)) / 4) : 0;
	    }

	    @Override
	    public String toString() {
	        return ("Raio:[" + this.raio + " Perimetro:[" + this.perimetro() + "] Area:[" + this.area() + "] Area trinagulo Inscrito:[" + this.getAreaTrianguloEquilateroInscrito() + "]");
	    }
	    

	@Override
	public Ponto2D centro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double area() {
		 this.area = (raio != 0) ? 2 * Math.PI * Math.pow(raio, 2) : area;
	        return area;
	}

	@Override
	public double perimetro() {
		this.perimetro = (raio != 0) ? 2 * Math.PI * raio : perimetro;
        return perimetro;
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
		// TODO Auto-generated method stub
		return null;
	}

}
