package edu.udc.psw.modelo;

public class FabricaFormas {// cria formas geometricas//
	
	public static FormaGeometrica fabricarFormaGeometrica(String forma) {
		int i = forma.indexOf(' ');
		String nome = forma.substring(0,i);
		FormaGeometrica formaGeometrica= null;
		
		if(nome.equals(Linha.class.getSimpleName()))
			formaGeometrica = new Linha();
		else if(nome.equals(Retangulo.class.getSimpleName()))
			formaGeometrica = new Retangulo();
		else if(nome.equals(Ponto2D.class.getSimpleName()))
			formaGeometrica = new Ponto2D();
		
		
		System.out.println(formaGeometrica.getClass().getSimpleName() + " "+ formaGeometrica.toString());
		
		return formaGeometrica;
	
	}
	
	public static Linha fabricarLinha(String linha) {
		int i = linha.indexOf(')');
		Ponto2D p1 = fabricarPonto2D(linha.substring(0, i));
		Ponto2D p2 = fabricarPonto2D(linha.substring(i+1));
		Linha l = new Linha(p1,p2);
		//System.out.println(l.getClass().getSimpleName()+" "+ l.toString());
		return l;
	}
	
	public static Ponto2D fabricarPonto2D(String ponto) {
		int i = ponto.indexOf(';');
		double x = Double.parseDouble(ponto.substring(1,i).replace(',', '.'));
		double y = Double.parseDouble(ponto.substring(i+1, ponto.length()-1).replace(',', '.'));
		Ponto2D p = new Ponto2D(x,y);
		//System.out.println(ponto.getClass().getSimpleName()+" "+ p.toString());
		return p;
	}
	
	public static Retangulo fabricarRertangulo(String Retangulo) {
		int i = Retangulo.indexOf(')');
		Ponto2D p1 = fabricarPonto2D(Retangulo.substring(0, i));
		Ponto2D p2 = fabricarPonto2D(Retangulo.substring(i+1));
		Retangulo r = new Retangulo();
		//System.out.println(r.getClass().getSimpleName()+" "+ r.toString());
		return r;
	}
	
	public static Ponto2D fabricarPonto2D (byte bytes[]) {
		return null;
	}
	
	
	
}
