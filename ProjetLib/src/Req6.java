import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe Req6 qui correspont a la requ�te de la question 6
 * @author lucas
 * 
 */

public class Req6 {

	Identifiant i = new Identifiant();

	/*
	 * On stock les informations � afficher dans un String
	 */

	private String res="";

	/*
	 * On stock le nombre de note attribu�
	 */

	private int nbrN=0;

	/*
	 * On stock le nombre d'articles
	 */

	private Double nb=0.0;

	/*
	 * On stock la somme des notes des articles
	 */

	private Double sum=0.0;

	/**
	 * Requ�te effectu� lors du clic sur le boutton "continuer" dans la classe Q1
	 * @param param
	 * @throws Exception
	 */


	public Req6(String param) throws Exception{		

		/**
		 * Connection a la base de donn�e grace aux identifiants
		 */

		Connection cnt = i.connect();

		/**
		 * Selectionne les chercheurs quand ils travaillent dans le laboratoire "param" et les trient par ordre d�croisant du nombre d'articles pubi�s
		 */

		PreparedStatement ps = cnt.prepareStatement("select nomchercheur from Chercheur inner join Ecrire on Chercheur.email = Ecrire.Email inner join Travailler on Chercheur.email = Travailler.Email where NomLabo = ? group by nomchercheur order by count(titre) desc");

		/**
		 * Selectionne par chercheur de la requ�te pr�c�dente, les titres qu'il a �crit
		 */

		PreparedStatement ps2 = cnt.prepareStatement("select distinct titre from Ecrire inner join Chercheur on Ecrire.Email = Chercheur.email where nomchercheur = ?");

		/**
		 * Selectionne  par le chercheur de la premi�re requ�te, le nombre de titres qu'il a �crit
		 */

		PreparedStatement ps3 = cnt.prepareStatement("select distinct count(Ecrire.Titre) as count  from Ecrire inner join Chercheur on Ecrire.Email = Chercheur.email where nomchercheur= ?");

		/**
		 * Selectionne par titre de la deuxi�me requ�te, le nombre de note ainsi que la moyenne des notes obtenues
		 */

		PreparedStatement ps4 = cnt.prepareStatement("select distinct count(note) as count2, avg(note) as moy from Noter where titre = ?");
		ps.setString(1,param);
		ResultSet rs = ps.executeQuery();
		res+="Laboratoire :\n" + param + "\n\n";
		while(rs.next()){

			res+=rs.getString("nomchercheur")+"\n";
			ps3.setString(1,rs.getString("nomchercheur"));
			ResultSet rs3 = ps3.executeQuery();

			while(rs3.next()){

				res+="-nombre d'articles publi�s : "+rs3.getInt("count")+"\n";
			}
			rs3.close();
			ps2.setString(1,rs.getString("nomchercheur"));
			ResultSet rs2 = ps2.executeQuery();

			while(rs2.next()){

				ps4.setString(1,rs2.getString("titre"));
				ResultSet rs4 = ps4.executeQuery();

				while(rs4.next()){
					nb++;
					nbrN+=rs4.getDouble("count2");
					sum+= rs4.getDouble("moy");
				}
				rs4.close();
			}
			res+="-nombre de notes attribu�es aux articles : " + nbrN+"\n";
			res+="-moyenne des notes attribu�es : "+ sum/nb+"\n";

			nbrN=0;
			nb=0.0;
			sum=0.0;

			rs2.close();
			res+="\n";
		}
		rs.close();
		ps2.close();
		ps3.close();
		ps4.close();
		ps.close();
		rs.close();
		cnt.close();	
	}

	/**
	 * M�thode qui retourne le r�sultat de la requ�te
	 * @return
	 */

	public String getRes() {
		return res;
	}

}
