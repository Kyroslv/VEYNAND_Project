/*
 * Exemple d'utilisation
 * 
 * A entrer dans le JTextField : 
 * 
 * Adding Structure to Unstructured Data
 * 
 * 
 * R�sultat attendu avec les tables non modifi�:
 * 
 * Verification de l'attribution de la note maximal de l'article :
 * "Adding Structure to Unstructured Data :"
 * 
 * -La note maximal � ete attribu� par Segoufin
 * 
 * -Segoufin travail dans le laboratoire :
 * INRIA Saclay - Ile-de-France
 * 
 * ---Buneman travail dans le  laboratoire :
 * "Department of Computer and Information Science University of Pennsylvania"
 * ---Buneman travail dans le  laboratoire :
 * "Laboratory for Foundations of Computer Science"
 * ---Davidson travail dans le  laboratoire :
 * "Department of Computer and Information Science University of Pennsylvania"
 * 
 * -Segoufin travail dans le laboratoire :
 * Laboratoire Sp�cification et V�rification
 * 
 * ---Buneman travail dans le  laboratoire :
 * "Department of Computer and Information Science University of Pennsylvania"
 * ---Buneman travail dans le  laboratoire :
 * "Laboratory for Foundations of Computer Science"
 * ---Davidson travail dans le  laboratoire :
 * "Department of Computer and Information Science University of Pennsylvania"
 * 
 * Le ou les chercheurs ayant attribu� la note maximal a l'article
 * "Adding Structure to Unstructured Data"
 * n'ont pas de laboratoire commun avec les auteurs de cet article.
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
 * Classe Q7 qui correspont a l'affichage de la r�ponse � la question 7
 * @author lucas
 * 
 */

public class Q7 implements ActionListener{

	/**
	 * La question est stock� dans trois JLabel
	 */

	JLabel l= new JLabel("V�rifie que la note maximal d'un article donn� n'a pas �t� attribu�",JLabel.CENTER);
	JLabel l2 = new JLabel("par un chercheur appartenant au meme laboratoire",JLabel.CENTER);
	JLabel l3 = new JLabel("qu'un des auteur de l'article.",JLabel.CENTER);

	/**
	 * Un JTextField est cr�� afin de pouvoir ecrire un nom d'auteur
	 */

	JTextField j = new JTextField(50);
	JFrame frame=new JFrame("Q7");

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

	String var="R�ponse � la question 7: \n";
	JTextArea rep = new JTextArea(var);

	/**
	 * action effectu� lors du clic sur le JButton "Q7"
	 */

	public void actionPerformed(ActionEvent e) {

		/**
		 * cr�ation des diff�rents JPanel pour une interface plus ergonomique
		 */

		JPanel panneauDeControle= new JPanel(new GridLayout(5,1));
		JPanel panneauDeControle2= new JPanel(new GridLayout(1,2));

		panneauDeControle2.add(new JLabel("Donner un article "+"    ",JLabel.CENTER));
		panneauDeControle2.add(j);

		panneauDeControle.add(l);
		panneauDeControle.add(l2);
		panneauDeControle.add(l3);
		panneauDeControle.add(panneauDeControle2);
		panneauDeControle.add(b);

		rep.setEditable(false);

		/**
		 * action effectu� lors du clic sur le JButton "continuer"
		 * appelle la classe Req7
		 */

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var = "R�ponse � la question 7: \n\n";

				try {
					Req7 s = new Req7(j.getText());
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
