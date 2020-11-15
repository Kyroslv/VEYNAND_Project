/*
 * Exemples d'utilisations
 */

/*
 * Exemple d'utilisation Creer A
 * 
 * Cliquer sur le JButton "Creer A"
 * 
 * 
 * R�sultat attendu avec les tables non modifi�:
 * 
 * Trigger A cr��
 * 
 */

/*
 * Exemple d'utilisation Creer B
 * 
 * Cliquer sur le JButton "Creer B"
 * 
 * 
 * R�sultat attendu avec les tables non modifi�:
 * 
 * Trigger B cr��
 * 
 */

/*
 * Exemple d'utilisation Supprimer A
 * 
 * Cliquer sur le JButton "Supprimer A"
 * 
 * 
 * R�sultat attendu avec les tables non modifi�:
 * 
 * Le trigger A n'existe pas
 * 
 */

/*
 * Exemple d'utilisation Supprimer A avec le trigger existant
 * 
 * Cliquer sur le JButton "Supprimer A"
 * 
 * 
 * R�sultat attendu avec les tables non modifi�:
 * 
 * Trigger A supprim�
 * 
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLSyntaxErrorException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Classe Q8 qui correspont a l'affichage de la r�ponse � la question 8
 * @author lucas
 * 
 */

public class Q8 implements ActionListener{

	/**
	 * La question est stock� dans un JLabel
	 */
	JLabel l= new JLabel("Creation et suppression des triggers.",JLabel.CENTER);

	JFrame frame=new JFrame("Q8");

	/**
	 * Cinq JButton sont cr��s:
	 * "Creer A" affin de creer le trigger A
	 * "Creer B" affin de creer le trigger B
	 * "Supprimer A" affin de supprimer le trigger A
	 * "Supprimer B" affin de supprimer le trigger B
	 * "retour" pour afficher le menu
	 */

	JButton ca = new JButton("Creer A");
	JButton cb = new JButton("Creer B");
	JButton sa = new JButton("Supprimer A");
	JButton sb = new JButton("Supprimer B");

	JButton r = new JButton("retour");

	/**
	 *  Un JTextArea est cr�� afin d'y afficher le resultat
	 */

	String var="R�ponse � la question 8: \n\n";
	JTextArea rep = new JTextArea(var);

	/**
	 * action effectu� lors du clic sur le JButton "Q8"
	 */

	public void actionPerformed(ActionEvent e) {

		/**
		 * cr�ation des diff�rents JPanel pour une interface plus ergonomique
		 */

		JPanel panneauDeControle= new JPanel(new GridLayout(3,1));
		JPanel panneauDeControle2= new JPanel(new GridLayout(1,2));
		JPanel panneauDeControle3= new JPanel(new GridLayout(1,2));

		panneauDeControle2.add(ca);
		panneauDeControle2.add(cb);

		panneauDeControle3.add(sa);
		panneauDeControle3.add(sb);

		panneauDeControle.add(l);
		panneauDeControle.add(panneauDeControle2);
		panneauDeControle.add(panneauDeControle3);

		rep.setEditable(false);

		/**
		 * action effectu� lors du clic sur le JButton "Creer A"
		 * appelle la classe Req8CA
		 */

		ca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var="R�ponse � la question 8: \n\n";

				try {
					new Req8CA();
					var+=("Trigger A cr��");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				rep.setText(var);
			}		
		});

		/**
		 * action effectu� lors du clic sur le JButton "Creer B"
		 * appelle la classe Req8CB
		 */

		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var="R�ponse � la question 8: \n\n";

				try {
					new Req8CB();
					var+=("Trigger B cr��");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				rep.setText(var);
			}		
		});

		/**
		 * action effectu� lors du clic sur le JButton "Supprimer A"
		 * appelle la classe Req8SA
		 */

		sa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var="R�ponse � la question 8: \n\n";

				try {
					try {
						new Req8SA();
						var+=("Trigger A supprim�");
					} catch (SQLSyntaxErrorException e2) {
						var+=("Le trigger A n'existe pas");
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}

				rep.setText(var);
			}		
		});

		/**
		 * action effectu� lors du clic sur le JButton "Supprimer B"
		 * appelle la classe Req8SB
		 */

		sb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var="R�ponse � la question 8: \n\n";

				try {
					try {
						new Req8SB();
						var+=("Trigger B supprim�");
					} catch (SQLSyntaxErrorException e2) {
						var+=("Le trigger B n'existe pas");
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
