/*
 * Exemple d'utilisation
 * 
 * R�sultat attendu avec les tables non modifi�:
 * 
 * Buneman:
 * -Department of Computer and Information Science University of Pennsylvania
 * -Laboratory for Foundations of Computer Science
 * 
 * Cohen-Boulakia:
 * -Laboratoire de Recherche en Informatique
 * 
 * Froidevaux:
 * -Laboratoire de Recherche en Informatique
 * 
 * Davidson:
 * -Department of Computer and Information Science University of Pennsylvania
 * 
 * Segoufin:
 * -INRIA Saclay - Ile-de-France
 * -Laboratoire Sp�cification et V�rification
 * 
 * Lamport:
 * -Microsoft Corporation
 * 
 * Lynch:
 * -Theory of Distributed Systems
 * 
 * Guerraoui:
 * -Distributed Programming Laboratory
 * -INRIA Saclay - Ile-de-France
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

/**
 * Classe Q3 qui correspont a l'affichage de la r�ponse � la question 3
 * @author lucas
 * 
 */

public class Q3 implements ActionListener{

	/**
	 * La question est stock� dans un JLabel
	 */

	JLabel l= new JLabel("Affichage de la liste des laboratoires de chaque chercheur.",JLabel.CENTER);
	JFrame frame=new JFrame("Q3");

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

	String var="R�ponse � la question 3: \n";
	JTextArea rep = new JTextArea(var);

	/**
	 * action effectu� lors du clic sur le JButton "Q3"
	 */

	public void actionPerformed(ActionEvent e) {

		/**
		 * cr�ation des diff�rents JPanel pour une interface plus ergonomique
		 */

		JPanel panneauDeControle= new JPanel(new GridLayout(2,1));

		panneauDeControle.add(l);
		panneauDeControle.add(b);

		rep.setEditable(false);

		/**
		 * action effectu� lors du clic sur le JButton "continuer"
		 * appelle la classe Req3
		 */

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var = "R�ponse � la question 3: \n\n";

				try {
					Req3 s = new Req3();
					var += s.getRes();
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
