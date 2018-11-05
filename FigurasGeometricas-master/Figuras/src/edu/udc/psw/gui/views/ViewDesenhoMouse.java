package edu.udc.psw.gui.views;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import edu.udc.psw.desenhos.controle.Documento;
import edu.udc.psw.modelo.FormaGeometrica;
import edu.udc.psw.modelo.manipulador.ManipuladorFormaGeometrica;

//Classe ConcreteObserver do padr�o Observer
public class ViewDesenhoMouse extends ViewDesenho implements FormaGeometricaView, MouseMotionListener, MouseListener {
	private static final long serialVersionUID = 2L;
	private boolean desenhando;
	private FormaGeometrica forma;
	private ManipuladorFormaGeometrica manipulador;

	public ViewDesenhoMouse(Documento doc) {
		super(doc);
		desenhando = false;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	public void novaFormaGeometrica(FormaGeometrica forma) {
		this.forma = forma;
		manipulador = forma.getManipulador();
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		
		if (forma != null)
			manipulador.paint(g);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (forma != null)
			manipulador.paint(g);
	}

	// Metodo Update() do padr�o Observer
	@Override
	public void atualizar() {
		getParent().revalidate();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (manipulador != null) {
			manipulador.click(e.getX(), e.getY());

			atualizar();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (manipulador != null) {
			manipulador.press(e.getX(), e.getY());

			desenhando = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (desenhando) {
			manipulador.release(e.getX(), e.getY());

			doc.novaForma(forma);

			desenhando = false;

			forma = forma.clone();
			manipulador = forma.getManipulador();

			atualizar();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (desenhando) {
			manipulador.drag(e.getX(), e.getY());

			atualizar();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

}
