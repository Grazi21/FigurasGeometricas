package edu.udc.psw.desenhos.controle;

import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import edu.udc.psw.colecao.Iterador;
import edu.udc.psw.colecao.ListaEncadeada;
import edu.udc.psw.desenhos.DB.DAO.DesenhosDAO;
import edu.udc.psw.desenhos.DB.DAO.LinhaDAO;
import edu.udc.psw.desenhos.DB.DAO.PontoDAO;
import edu.udc.psw.desenhos.DB.DAO.RetanguloDAO;
import edu.udc.psw.desenhos.DB.data.Desenhos;
import edu.udc.psw.desenhos.controle.persistencia.ArquivoFormaGeometrica;
import edu.udc.psw.desenhos.controle.persistencia.ArquivoFormasBinario;
import edu.udc.psw.desenhos.controle.persistencia.ArquivoFormasSerial;
import edu.udc.psw.desenhos.controle.persistencia.ArquivoFormasTexto;
import edu.udc.psw.gui.views.FormaGeometricaView;
import edu.udc.psw.modelo.FormaGeometrica;
import edu.udc.psw.modelo.Linha;
import edu.udc.psw.modelo.Ponto2D;
import edu.udc.psw.modelo.Retangulo;

// Classe Context do padrão Strategy
// Classe ConcreteSubject do padrão Observer
public class Documento {
	private ListaEncadeada<FormaGeometrica> listaFormas;
	// Lista de observadores - padrão Observer
	private ListaEncadeada<FormaGeometricaView> listaViews;

	public Documento() {
		super();
		listaFormas = new ListaEncadeada<FormaGeometrica>();
		listaViews = new ListaEncadeada<FormaGeometricaView>();
	}

	// Metodo Attach(Observer) do padrão Observer
	public void adicionaView(FormaGeometricaView view) {
		listaViews.inserirFim(view);
		atualizaViews();
	}

	// Metodo Detach(Observer) do padrão Observer
	public void removeView(FormaGeometricaView view) {
		listaViews.remover(view);
		atualizaViews();
	}

	// Metodo Notify() do padrão Observer
	public void atualizaViews() {
		Iterador<FormaGeometricaView> i = listaViews.getInicio();
		FormaGeometricaView view;
		while ((view = (FormaGeometricaView) i.proximo()) != null) {
			// Invoca o metodo Update do objeto Observer
			view.atualizar();
		}
	}

	public void novaForma(FormaGeometrica forma) {
		listaFormas.inserirFim(forma);
		// Uso do metodo Notify() do padrão Observer
		atualizaViews();
	}

	public void novoPonto(int x, int y) {
		Ponto2D p = new Ponto2D(x, y);
		listaFormas.inserirFim(p);
		// Uso do metodo Notify() do padrão Observer
		atualizaViews();
	}

	public void novaLinha(int xi, int yi, int xf, int yf) {
		Linha l = new Linha(new Ponto2D(xi, yi), new Ponto2D(xf, yf));
		listaFormas.inserirFim(l);
		// Uso do metodo Notify() do padrão Observer
		atualizaViews();
	}

	public void novoRetangulo(int xi, int yi, int xf, int yf) {
		Retangulo r = new Retangulo(new Ponto2D(xi, yi), new Ponto2D(xf, yf));
		listaFormas.inserirFim(r);
		// Uso do metodo Notify() do padrão Observer
		atualizaViews();
	}

	public int getQtdFiguras() {
		return listaFormas.getTamanho();
	}

	public FormaGeometrica getFigura(int pos) {
		return (FormaGeometrica) listaFormas.pesquisar(pos);
	}

	public Iterador<FormaGeometrica> getIteradorFormas() {
		return listaFormas.getInicio();
	}

	// Metodo ContextInterface da classe Context no padrão Strategy
	public void salvarFormas(File file) {
		ArquivoFormaGeometrica arq = null;

		String name = file.getName();
		String ext = name.substring(name.lastIndexOf('.') + 1);

		// Determina qual algoritmo será utilizado, no padrão Strategy
		if (ext.compareTo("ser") == 0)
			arq = new ArquivoFormasSerial(file);
		if (ext.compareTo("txt") == 0)
			arq = new ArquivoFormasTexto(file);
		if (ext.compareTo("bin") == 0)
			arq = new ArquivoFormasBinario(file);
		// Uso do metodo AlgorithmInterface() da classe Strategy
		arq.salvarFormas(listaFormas);

	}

	// Metodo ContextInterface da classe Context no padrão Strategy
	public void lerFormas(File file) {
		ArquivoFormaGeometrica arq = null;

		String name = file.getName();
		String ext = name.substring(name.lastIndexOf('.') + 1);

		// Determina qual algoritmo será utilizado, no padrão Strategy
		if (ext.compareTo("ser") == 0)
			arq = new ArquivoFormasSerial(file);
		if (ext.compareTo("txt") == 0)
			arq = new ArquivoFormasTexto(file);
		if (ext.compareTo("bin") == 0)
			arq = new ArquivoFormasBinario(file);
		// Uso do metodo AlgorithmInterface() da classe Strategy
		listaFormas = arq.lerFormas();

		// Uso do metodo Notify() do padrão Observer
		atualizaViews();
	}

	public void salvarBD(String nomeDesenho) {
		DesenhosDAO desenhosDAO = new DesenhosDAO();
		long time = System.currentTimeMillis();
		Desenhos desenho = new Desenhos(0, nomeDesenho, new Timestamp(time), new Timestamp(time));

		
		try {
			desenhosDAO.insert(desenho);
		} catch (IllegalStateException | SQLException e) {
			e.printStackTrace();
		}

		PontoDAO pontoDAO = new PontoDAO((int)desenho.getId());
		LinhaDAO linhaDAO = new LinhaDAO((int)desenho.getId());
		RetanguloDAO retanguloDAO = new RetanguloDAO((int)desenho.getId());
		
		Iterador<FormaGeometrica> i = listaFormas.getInicio();
		FormaGeometrica forma;
		while ((forma = (FormaGeometrica) i.proximo()) != null) {
			if(forma.getClass().equals(Ponto2D.class)) {
				try {
					pontoDAO.insert((Ponto2D) forma);
				} catch (IllegalStateException | SQLException e) {
					e.printStackTrace();
				}
			}
			if(forma.getClass().equals(Linha.class)) {
				try {
					linhaDAO.insert((Linha) forma);
				} catch (IllegalStateException | SQLException e) {
					e.printStackTrace();
				}
			}
			if(forma.getClass().equals(Retangulo.class)) {
				try {
					retanguloDAO.insert((Retangulo) forma);
				} catch (IllegalStateException | SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
