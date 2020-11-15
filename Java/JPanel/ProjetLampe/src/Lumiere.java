package ProjetLampe;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class Lumiere extends JPanel{

	//declaration des attribut numero qui correspond au numero de la lampe,etat un boolean repr�sentant son �tat (allum� ou �teint) et coul sa couleur
	int numero;
	Boolean etat = false;
	Color coul=Color.gray;
	
	//constructeur cr�ant une lampe avec un numero n
	public Lumiere(int n) {
		numero=n;
		etat=false;
	}
	
	//cr�e un rectangle de couleur coul repr�entant la lampe
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(coul);
		g.fillRect(0,0, 90, 110);
	}	

	//permet de changer l'�tat de la lampe entre true ou false si elle est allum� ou eteinte et de refaire le rectangle
	public void changeEtat() {
		if (this.etat==false) {
			this.etat=true;
			coul=Color.yellow;
		}else {
			etat=false;
			coul=Color.gray;
		}
		repaint();
	}
	
	//permet de faire un rectangle vert pour symboliser la victoire
	public void gagner() {
		coul=Color.green;
		repaint();
	}
	
	//renvoie la couleur de la lampe
	public Color getCoul() {
		return coul;
	}
	
	//permet de changer la couleur de la lampe
	public void setCoul(Color c) {
		this.coul=c;
		repaint();
	}
	
	//retourne l'etat de la lampe
	public boolean getEtat() {
		return etat;
	}
	
	//retourne le num�ro de la lampe
	public int getNum() {
		return numero;
	}
	
}
