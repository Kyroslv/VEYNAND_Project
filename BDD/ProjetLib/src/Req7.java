import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe Req7 qui correspont a la requ�te de la question 7
 * @author lucas
 * 
 */

public class Req7 {

	Identifiant i = new Identifiant();

	/*
	 * On stock les informations � afficher dans un String
	 */

	private String res="";	
	private boolean bool = false;

	/**
	 * Requ�te effectu� lors du clic sur le boutton "continuer" dans la classe Q1
	 * @param param
	 * @throws Exception
	 */


	public Req7(String param) throws Exception{	

		bool=false;

		/**
		 * Connection a la base de donn�e grace aux identifiants
		 */

		Connection cnt = i.connect();

		/**
		 * Selectionne le chercheur qui a attribu� la note maximal � l'article "param"
		 */

		PreparedStatement ps = cnt.prepareStatement("select nomchercheur from Noter inner join Chercheur on Noter.email = Chercheur.email where titre=? and note = (select max(note) from noter where titre= ?)");

		/**
		 * Selectionne le laboratoire dans lequel le chercheur de la requ�te pr�c�dente travail
		 */

		PreparedStatement ps2 = cnt.prepareStatement("select nomlabo from Travailler inner join Chercheur on Travailler.Email = Chercheur.email where nomchercheur = ?");

		/**
		 * Selectionne les chercheurs qui ont �cris le titre "param"
		 */

		PreparedStatement ps3 = cnt.prepareStatement("select nomchercheur from Ecrire inner join chercheur on Ecrire.Email = Chercheur.email where titre=?");

		/**
		 * Selectionne par chercheur de la requ�te pr�c�dente les laboratoire o� ils travaillent 
		 */

		PreparedStatement ps4 = cnt.prepareStatement("select nomlabo from Travailler inner join Chercheur on Travailler.Email = Chercheur.email where nomchercheur = ?");
		ps.setString(1,param);
		ps.setString(2,param);
		res+="Verification de l'attribution de la note maximal de l'article :\n\""+ param + " :\"\n\n";
		ResultSet rs = ps.executeQuery();

		while(rs.next() && !bool){

			res+="-La note maximal � ete attribu� par " + rs.getString("nomchercheur")+"\n";
			ps2.setString(1,rs.getString("nomchercheur"));
			ResultSet rs2 = ps2.executeQuery();

			while(rs2.next() && !bool) {

				res+="\n-" + rs.getString("nomchercheur") + " travail dans le laboratoire :\n" + rs2.getString("nomlabo")+"\n\n";
				ps3.setString(1,param);
				ResultSet rs3 = ps3.executeQuery();

				while(rs3.next() && !bool) {

					ps4.setString(1,rs3.getString("nomchercheur"));
					ResultSet rs4 = ps4.executeQuery();

					while(rs4.next() && !bool) {

						res+="---"+rs3.getString("nomchercheur")+" travail dans le  laboratoire :\n\"" + rs4.getString("nomlabo") +"\"\n";

						if(rs4.getString("nomlabo").equals(rs2.getString("nomlabo"))) {
							bool=true;
							res+="\n"+rs.getString("nomchercheur")+", le chercheur ayant attribu� la note maximal � l'article :\n\""+ param + "\"\ntravail dans le laboratoire :\n\"" + rs4.getString("nomlabo") + "\"\nqui est commun avec " + rs3.getString("nomchercheur") + ", un auteur de cet article.\n";
						}	

					}
					rs4.close();
				}
				rs3.close();	
			}
			rs2.close();
		}
		rs.close();
		ps2.close();
		ps3.close();
		ps4.close();
		ps.close();
		rs.close();
		cnt.close();
		if(!bool) {
			res+="\nLe ou les chercheurs ayant attribu� la note maximal a l'article\n\"" + param + "\"\nn'ont pas de laboratoire commun avec les auteurs de cet article.\n";
		}
	}

	/**
	 * M�thode qui retourne le r�sultat de la requ�te
	 * @return
	 */

	public String getRes() {
		return res;
	}

}
