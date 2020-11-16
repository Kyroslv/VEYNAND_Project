/*
 * Exemple d'utilisation
 * 
 * A entrer dans le JTextField : 
 * 
 * Davidson
 * 
 * 
 * R�sultat attendu avec les tables non modifi�:
 * 
 * Liste des auteur ayant travaill� avec Davidson :
 * -Cohen-Boulakia
 * -Froidevaux
 * -Buneman
 * 
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Classe Q2 qui correspont a l'affichage de la r�ponse � la question 2
 * @author lucas
 * 
 */

public class Q2 implements ActionListener{

	/**
	 * La question est stock� dand un JLabel
	 */

	JLabel l= new JLabel("Affichage de la liste des co-auteurs ayant travaill� avec un chercheur donn�.",JLabel.CENTER);

	/**
	 * Un JTextField est cr�� afin de pouvoir ecrire un nom d'auteur
	 */

	JTextField j = new JTextField(50);
	JFrame frame=new JFrame("Q2");

	/**
	 * Deux JButton sont cr��s:
	 * "continuer" pour afficher la r�ponse
	 * "retour" pour afficher le menu
	 */

	JButton b = new JButton("continuer");
	JButton r = new JButton("retour");

	/**
	 *  Un JTextArea est cr�� afin d'y afficher le resultat
	 */

	String var="R�ponse � la question 2: \n";
	JTextArea rep = new JTextArea(var);

	/**
	 * action effectu� lors du clic sur le JButton "Q2"
	 */

	public void actionPerformed(ActionEvent e) {

		/**
		 * cr�ation des diff�rents JPanel pour une interface plus ergonomique
		 */

		JPanel panneauDeControle= new JPanel(new GridLayout(3,1));
		JPanel panneauDeControle2= new JPanel(new GridLayout(1,2));

		panneauDeControle2.add(new JLabel("Donner un chercheur "+"    ",JLabel.CENTER));
		panneauDeControle2.add(j);

		panneauDeControle.add(l);
		panneauDeControle.add(panneauDeControle2);
		panneauDeControle.add(b);

		rep.setEditable(false);

		/**
		 * action effectu� lors du clic sur le JButton "continuer"
		 * appelle la classe Req2
		 */

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var = "R�ponse � la question 2: \n\n";

				try {
					Req2 s = new Req2(j.getText());
					if (s.getRes().equals("Liste des auteur ayant travaill� avec " + j.getText() + " :\n")) {
						var += "Aucune r�ponse";
					}else {
						var += s.getRes();
					}		
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				rep.setText(var);
			}		
		});

		/**
		 * action effectu� lors du clic sur le JButton "retour"
		 */

		r.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Menu();
				frame.dispose();
			}		
		});

		//Construction de l'IG dans une JFrame		 

		frame.getContentPane().add(panneauDeControle,BorderLayout.NORTH);
		frame.getContentPane().add(new JScrollPane(rep),BorderLayout.CENTER);
		frame.getContentPane().add(r,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(400,400));
		frame.setVisible(true);

	}
}
