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
		Linha l = new Linha();
		System.out.println(l.getClass().getSimpleName()+" "+ linha);
		return l;
	}
	
	public static Ponto2D fabricarPonto2D(String Ponto2D) {
		Ponto2D p = new Ponto2D();
		System.out.println(Ponto2D.getClass().getSimpleName()+" "+ Ponto2D);
		return p;
	}
	
	public static Retangulo fabricarRertangulo(String Retangulo) {
		Retangulo r = new Retangulo();
		System.out.println(Retangulo.getClass().getSimpleName()+" "+ Retangulo);
		return r;
	}
	
}
